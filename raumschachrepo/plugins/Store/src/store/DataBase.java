package store;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EReferenceImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.teneo.PersistenceOptions;
import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.eclipse.emf.teneo.hibernate.HbHelper;
import org.eclipse.osgi.service.datalocation.Location;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.hibernate.classic.Session;
import org.hibernate.context.ManagedSessionContext;
import org.hibernate.jdbc.Work;

import raumschachmodell.figures.FigurProvider;
import raumschachmodell.modell.RaumschachModellPackage;
import raumschachmodell.modell.Spiel;
import spielfeld.Field;
import spielfeld.Figur;
import spielfeld.SpielfeldPackage;
import spielfeld.Zug;

import architecture.ISpielProvider;

/**
 * Implementation of the data base connector. The {@link DataBase} can be set to
 * debug mode with a predefined database directory. Please look at the command
 * line arguments in the documentation.
 * 
 * @author frank
 * 
 */
public final class DataBase {

    /**
     * The actual instance.
     */
    private static DataBase instance;

    /**
     * The {@link SessionFactory}, which can create sessions.
     */
    private final SessionFactory sessionFactory;

    /**
     * The data store used.
     */
    private HbDataStore dataStore;

    /**
     * The actual session.
     */
    private Session session;

    /**
     * An adapter for the zuege. Whenever a zug is added, the game is saved.
     */
    private final EContentAdapter zugAdapter;

    /**
     * Creates a new {@link DataBase}.
     */
    public DataBase() {
        // Check, if there is already an instance of this. This shouldn't be the
        // case.
        if (DataBase.instance != null) {
            throw new InstantiationError("This instance exists already");
        }
        // Assign the actual instance.
        DataBase.instance = this;

        // Sets the properties for a simple Hibernate db.
        final Properties hibernateProperties = this.setUpProperties();
        // Create the session factory, which is used to create new sessions.
        this.sessionFactory = this.setUpSessionFactory(hibernateProperties,
                "RaumschachStore");

        // Create a new session.
        this.session = this.sessionFactory.openSession();

        // Add a listener to the zug list and save after each zug.
        this.zugAdapter = new EContentAdapter() {

            @Override
            public void notifyChanged(final Notification notification) {
                if (notification.getFeature() instanceof EReferenceImpl
                        && ((EReferenceImpl) notification.getFeature())
                                .getName().equalsIgnoreCase("zuege")
                        && notification.getEventType() == Notification.ADD) {
                    DataBase.instance.save(Activator.getProvider().getSpiel());
                }
            }
        };
        Activator.getProvider().getSpiel().eAdapters().add(this.zugAdapter);

    }

    /**
     * Sets the properties for a simple Hibernate db.
     * 
     * @return The {@link Properties} for a simple Hibernate data base.
     */
    private Properties setUpProperties() {
        // The name for the database file.
        String databaseFileName = "raumschachdb";
        // Create a directory for the database.
        final Location workspace = Platform.getInstanceLocation();
        URI uri;
        try {
            uri = workspace.getURL().toURI();
            final File file = new File(uri.getPath() + "/database");
            // Check for a command line argument for the database location.
            String userdefined = null;
            final String args[] = Platform.getCommandLineArgs();
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("-dbLocation")) {
                    // Go to the next argument, which should be the new database
                    // location. Note: The modification of the controSl variable
                    // i is attentional.
                    i++;
                    userdefined = args[i];
                }
            }
            databaseFileName = (userdefined == null ? file.getAbsolutePath()
                    : userdefined) + File.separator + databaseFileName;
        } catch (final URISyntaxException e) {
            e.printStackTrace();
        }

        // Create new properties.
        final Properties props = new Properties();

        props.setProperty(Environment.DRIVER, "org.hsqldb.jdbcDriver");
        props.setProperty(Environment.USER, "sa");
        props.setProperty(Environment.URL, "jdbc:hsqldb:file:"
                + databaseFileName);
        props.setProperty(Environment.PASS, "");
        props.setProperty(Environment.DIALECT,
                org.hibernate.dialect.HSQLDialect.class.getName());
        props.setProperty(PersistenceOptions.ID_FEATURE_AS_PRIMARY_KEY, "id");

        // set a specific option see this page
        // http://wiki.eclipse.org/Teneo/Hibernate/Configuration_Options
        // for all the available options
        props.setProperty(PersistenceOptions.CASCADE_POLICY_ON_NON_CONTAINMENT,
                "REFRESH,PERSIST,MERGE");

        return props;
    }

    /**
     * Creates a new {@link SessionFactory} for an underlying
     * {@link HbDataStore} with the given properties and name.
     * 
     * @param hibernateProperties
     *            The {@link Properties} for the underlying {@link HbDataStore}.
     * @param dataStoreName
     *            The name of the {@link HbDataStore}.
     * @return The {@link SessionFactory} for the specified {@link HbDataStore}.
     */
    protected SessionFactory setUpSessionFactory(
            final Properties hibernateProperties, final String dataStoreName) {
        // Create the DataStore.
        this.dataStore = HbHelper.INSTANCE
                .createRegisterDataStore(dataStoreName);
        this.dataStore.setDataStoreProperties(hibernateProperties);

        // Configure the EPackages used by this DataStore.
        this.dataStore
                .setEPackages(new EPackage[] {
                        RaumschachModellPackage.eINSTANCE,
                        SpielfeldPackage.eINSTANCE });

        // Initialize the DataStore. This sets up the Hibernate mapping and, in
        // turn, creates the corresponding tables in the database.
        this.dataStore.initialize();

        while (!this.dataStore.isInitialized()) {
            try {
                Thread.sleep(1000);
            } catch (final InterruptedException e) {
                e.printStackTrace();
            }
        }

        return this.dataStore.getSessionFactory();
    }

    /**
     * Saves the given Spiel in the database.
     * 
     * @param spiel
     *            The {@link Spiel}, which should be saved.
     */
    public void save(final Spiel spiel) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                DataBase.this.session.close();
                DataBase.this.session = DataBase.this.sessionFactory
                        .openSession();

                ManagedSessionContext.bind(DataBase.this.session);

                // Run over all tagclouds.
                DataBase.this.session.beginTransaction();
                // Make it persistent.
                DataBase.this.session.saveOrUpdate(spiel);
                // Commit the changes to the database.
                DataBase.this.session.getTransaction().commit();

                DataBase.this.session = ManagedSessionContext
                        .unbind(DataBase.this.sessionFactory);
            }
        }).start();
    }

    /**
     * Loads the data from the database.
     * 
     * @return The {@link List} of {@link Spiel}s, which were saved in the
     *         database.
     */
    @SuppressWarnings("unchecked")
    public List<Spiel> load() {
        this.session.close();
        this.session = this.sessionFactory.openSession();
        ManagedSessionContext.bind(this.session);

        this.session.beginTransaction();

        // Get all objects.
        final Query query = this.session.createQuery("from Spiel");
        final List<Spiel> results = query.list();

        this.session.getTransaction().commit();
        this.session = ManagedSessionContext.unbind(this.sessionFactory);

        return results;
    }

    /**
     * Copy another game to the actual one.
     * 
     * @param index
     *            The index of the {@link Spiel}, for which the {@link Zug}e
     *            should be read.
     * @throws NoSuchMethodException
     *             An exception occurred.
     * @throws InvocationTargetException
     *             An exception occurred.
     * @throws IllegalAccessException
     *             An exception occurred.
     */
    public void assignData(final int index) throws IllegalAccessException,
            InvocationTargetException, NoSuchMethodException {
        // Detach the adapter for the zuege.
        final List<Adapter> adapters = new ArrayList<Adapter>();
        for (final Adapter adapter : Activator.getProvider().getSpiel().eAdapters()) {
            adapters.add(adapter);
        }
        Activator.getProvider().getSpiel().eAdapters().clear();

        // Reset.
        Activator.getProvider().getSpiel().reset();

        this.session.close();
        this.session = this.sessionFactory.openSession();
        ManagedSessionContext.bind(this.session);

        this.session.beginTransaction();

        // Get all objects.
        final Query query = this.session.createQuery("from Spiel");
        @SuppressWarnings("unchecked")
        final List<Spiel> results = query.list();
        final Spiel spiel = results.get(index);

        // Copy the fields.
        for (final Field field : Activator.getProvider().getSpiel().getFields()) {
            this.copyWithReflection(
                    FigurProvider.findField(spiel.getFields(),
                            field.getPosition()), field);
        }
        // Copy the figures.
        for (final Figur figur : Activator.getProvider().getSpiel().getFigures()) {
            this.copyWithReflection(
                    FigurProvider.findFigur(spiel.getFigures(), figur.getId()),
                    figur);
        }

        // Add the adapter.
        Activator.getProvider().getSpiel().eAdapters().addAll(adapters);
        // Detach the load adapter.
        Activator.getProvider().getSpiel().eAdapters().remove(this.zugAdapter);

        // Copy the zuege.
        this.copyZuege(spiel.getZuege(), Activator.getProvider().getSpiel());
        // Copy active flag.
        Activator.getProvider().getSpiel().setActive(spiel.getActive());
        // Copy beschreibung.
        Activator.getProvider().getSpiel().setBeschreibung(spiel.getBeschreibung());
        // Copy id.
        Activator.getProvider().getSpiel().setId(spiel.getId());

        // Add the zugadapter.
        Activator.getProvider().getSpiel().eAdapters().add(this.zugAdapter);

        this.session = ManagedSessionContext.unbind(this.sessionFactory);
    }

    /**
     * Copies the {@link Zug}e from the load game to the actual one. For this
     * operation, the adapters for {@link Zug}e should be detached first and
     * afterwards be set again.
     * 
     * @param zuege
     *            The loaded {@link Zug}-List, which should be copied.
     * @param copyTo
     *            The actual play.
     */
    private void copyZuege(final EList<Zug> zuege, final Spiel copyTo) {
        copyTo.getZuege().clear();
        for (final Zug zug : zuege) {
            copyTo.getZuege().add(zug);
        }
    }

    /**
     * Uses reflection to copy all set-able attributes, which are not null.
     * 
     * @param valueToSet
     *            An exception occurred.
     * @param copyTo
     *            The {@link Spiel}, in which the data should be copied.
     * @throws IllegalAccessException
     *             An exception occurred.
     * @throws InvocationTargetException
     *             An exception occurred.
     * @throws NoSuchMethodException
     *             An exception occurred.
     */
    private void copyWithReflection(final Object valueToSet, final Object copyTo)
            throws IllegalAccessException, InvocationTargetException,
            NoSuchMethodException {
        // Should be two times the same object type.
        assert valueToSet.getClass() == copyTo.getClass();
        final Method[] methods = copyTo.getClass().getMethods();
        // Run over all methods. If it is a set method, check for boolean. If
        // yes, ask for the value with is... else use get...
        for (final Method method : methods) {
            if (!method.getName().startsWith("set")) {
                continue;
            }
            final Class[] parameters = method.getParameterTypes();
            if (parameters.length > 1) {
                continue;
            }
            if (parameters[0] == boolean.class) {
                method.invoke(
                        copyTo,
                        valueToSet
                                .getClass()
                                .getMethod(
                                        method.getName().replaceFirst("set",
                                                "is"), null)
                                .invoke(valueToSet, null));
            } else {
                // Get the value to set.
                final Object setMe = valueToSet
                        .getClass()
                        .getMethod(method.getName().replaceFirst("set", "get"),
                                null).invoke(valueToSet, null);
                if (setMe != null) {
                    method.invoke(copyTo, setMe);
                } else {
                    System.err.println("Ignore null argument: " + method);
                }
            }
        }
    }

    /**
     * Shut down the data base.
     */
    public void stop() {
        // Tell the db to shut down. This is necessary, because HSQLDB is using
        // a meaningful delay for the write operations.
        this.session.doWork(new Work() {
            @Override
            public void execute(final Connection connection)
                    throws SQLException {
                connection.createStatement().execute("SHUTDOWN");
            }
        });
        // Close the session.
        this.session.close();
        // Close the data store.
        this.dataStore.close();
    }

    public static DataBase getInstance() {
        return DataBase.instance;
    }
}
