package spielfeld.ui;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpSession;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.rwt.RWT;
import org.eclipse.rwt.lifecycle.JSWriter;
import org.eclipse.rwt.lifecycle.UICallBack;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;
import org.eclipse.swt.browser.ProgressEvent;
import org.eclipse.swt.browser.ProgressListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.part.ViewPart;

import raumschachmodell.figures.FigurProvider;
import raumschachmodell.modell.Spiel;
import raumschachmodell.modell.Spieler;
import spielfeld.Activator;
import spielfeld.Farbe;
import spielfeld.Field;
import spielfeld.Figur;
import spielfeld.Koordinate;
import spielfeld.SpielfeldFactory;
import spielfeld.jobs.SetFigureJob;

/**
 * This class is the {@link ViewPart} for representing the main game area. For
 * each {@link Spieler}, there is one {@link ViewBrett} instance.
 * 
 * @author frank
 * 
 */
public class ViewBrett extends ViewPart {

    /**
     * The {@link Browser}, which is used for representing the javascript game
     * area.
     */
    private Browser browser;

    /**
     * The {@link Spieler}, which is associated with this special instance of
     * the {@link ViewBrett}.
     */
    private Spieler spieler;

    /**
     * Constructs a new main game area viewpart.
     */
    public ViewBrett() {
        super();
        UICallBack.activate(this.toString());
        for (final Spieler sp : Activator.getProvider().getSpiel().getSpieler()) {
            if (sp.getId().equalsIgnoreCase(
                    RWT.getRequest().getSession().getId())) {
                this.spieler = sp;
                break;
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * spielfeld.ui.ISpielFeld#createPartControl(org.eclipse.swt.widgets.Composite
     * )
     */
    @Override
    public void createPartControl(final Composite parent) {
        parent.setLayout(new GridLayout());

        this.browser = new Browser(parent, SWT.NONE);
        parent.setLayout(new GridLayout(1, true));
        this.browser.setLayoutData(new GridData(GridData.FILL_BOTH));
        this.browser.setUrl("/javascript/camera_orthographic.html");

        this.browser.addProgressListener(new ProgressListener() {

            @Override
            public void completed(final ProgressEvent event) {
                // Initial setup.
                ViewBrett.this.initialGameSetting();
                // Add the listener.
                final Spiel spiel = Activator.getProvider().getSpiel();
                spiel.eAdapters().add(new AdapterImpl() {
                    @Override
                    public void notifyChanged(final Notification msg) {
                        // Check, if an attribute changed.
                        if (msg.getFeature() instanceof EAttribute) {
                            // Check, if the attribute is the id.
                            if (((EAttribute) msg.getFeature()).getName()
                                    .equalsIgnoreCase("id")) {
                                ViewBrett.this.initialGameSetting();
                            }
                        }
                    }
                });
            }

            @Override
            public void changed(final ProgressEvent event) {
            }
        });

        // Publish the select functions in Javascript.
        new SelectFigureFunction(this.browser, "fObjectSelected");
    }

    /*
     * (non-Javadoc)
     * 
     * @see spielfeld.ui.ISpielFeld#setFocus()
     */
    @Override
    public void setFocus() {
        // TODO Auto-generated method stub

    }

    /**
     * This class represents a function, which can be injected in the browser
     * and can be called from javascript. On the other hand, it has access to
     * the java scope and thus allows a communication between javascript and
     * java.
     * 
     * @author frank
     * 
     */
    class SelectFigureFunction extends BrowserFunction {
        /**
         * Constructs the {@link SelectFigureFunction}.
         * 
         * @param b
         *            The {@link Browser}, in which the function should be
         *            inserted.
         * @param name
         *            The name of the function. With this name it can be called
         *            from javascript.
         */
        SelectFigureFunction(final Browser b, final String name) {
            super(b, name);
        }

        @Override
        public Object function(final Object[] arguments) {
            // Check for fields.
            if (((String) arguments[0]).equals("checker")) {
                // Create the koordinates.
                final Koordinate koord = SpielfeldFactory.eINSTANCE
                        .createKoordinate();
                koord.setEbene(((Double) arguments[1]).intValue());
                koord.setBuchstabe(((Double) arguments[2]).intValue());
                koord.setZahl(((Double) arguments[3]).intValue());
                // Set the field selected.
                FigurProvider.findField(
                        Activator.getProvider().getSpiel().getFields(), koord)
                        .setSelected(true);

                return null;
            }
            // Try to convert the argument.
            final String id = (String) arguments[0];
            // Select/Unselect the figure.
            final Figur figur = FigurProvider.findFigur(Activator.getProvider()
                    .getSpiel().getFigures(), id);
            // There is no figure selected already. Is this color allowed?
            if (!(figur.getFarbe() == ViewBrett.this.spieler.getFarbe() || ViewBrett.this.spieler
                    .getFarbe() == Farbe.BEIDE)) {
                return null;
            }
            if (figur.isSelected()) {
                figur.setSelected(false);
            } else {
                figur.setSelected(true);
            }

            return null;
        }
    }

    /**
     * Initialises the {@link ViewBrett}. The figures are set according to the
     * actual {@link Spiel} and listeners are attached.
     */
    private void initialGameSetting() {
        final String id = this.hashCode() + "" + System.currentTimeMillis();
        UICallBack.activate(id);
        this.execute("initialGameSetting();");

        this.browser.getDisplay().syncExec(new Runnable() {
            @Override
            public void run() {
                try {
                    final ProgressMonitorDialog pM = new ProgressMonitorDialog(
                            ViewBrett.this.browser.getShell());
                    pM.run(false, false, new SetFigureJob(ViewBrett.this,
                            Activator.getProvider()));
                } catch (final InvocationTargetException e) {
                    e.printStackTrace();
                } catch (final InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Add the listener to the fields.
        for (final Field field : Activator.getProvider().getSpiel().getFields()) {
            field.eAdapters().add(new AdapterImpl() {
                @Override
                public void notifyChanged(final Notification msg) {
                    // Check, if an attribute changed.
                    if (msg.getFeature() instanceof EAttribute) {
                        // Check, if the attribute is the selected flag.
                        if (((EAttribute) msg.getFeature()).getName()
                                .equalsIgnoreCase("possible")) {
                            // Check, if the flag was set to true (active).
                            if (msg.getNewBooleanValue()) {
                                // Highlight the field.
                                ViewBrett.this.highlightField(field, true);
                            } else {
                                // Unhighlight the figure.
                                ViewBrett.this.unhighlightField(field);
                            }
                        }
                        // Check, if the attribute is the selected flag.
                        if (((EAttribute) msg.getFeature()).getName()
                                .equalsIgnoreCase("attackable")) {
                            // Check, if the flag was set to true (active).
                            if (msg.getNewBooleanValue()) {
                                // Highlight the field.
                                ViewBrett.this.highlightField(field, false);
                            } else {
                                // Unhighlight the figure.
                                ViewBrett.this.unhighlightField(field);
                            }
                        }
                    }
                }
            });
        }
    }

    /**
     * Highlights a {@link Figur} with the given id on the game area.
     * 
     * @param id
     *            The {@link Figur#getId()}.
     */
    public void highlightFigure(final String id) {
        this.execute("highlightFigure('" + id + "');");
    }

    /**
     * Unhighlights a {@link Figur} with the given id on the game area.
     * 
     * @param id
     *            The {@link Figur#getId()}.
     */
    public void unhighlightFigure(final String id) {
        this.execute("unhighlightFigure('" + id + "');");
    }

    /**
     * Highlights a {@link Field} with on the game area. A distinction between
     * highlighting fields with opponent {@link Figur}s and without is made.
     * 
     * @param field
     *            The {@link Field}, which should be highlighted.
     * @param move
     *            True, if there is no opponent {@link Figur} and thus it is a
     *            normal move at this {@link Field}, false otherwise.
     */
    public void highlightField(final Field field, final boolean move) {
        this.execute("highlightField(" + field.getPosition().getEbene() + ","
                + field.getPosition().getBuchstabe() + ","
                + field.getPosition().getZahl() + "," + move + ");");
    }

    /**
     * Unhighlights a {@link Field} with on the game area.
     * 
     * @param field
     *            The {@link Field}, which should be highlighted.
     */
    public void unhighlightField(final Field field) {
        this.execute("unhighlightField(" + field.getPosition().getEbene() + ","
                + field.getPosition().getBuchstabe() + ","
                + field.getPosition().getZahl() + ");");
    }

    /**
     * Places a {@link Figur} at a given position on the game area.
     * 
     * @param id
     *            The {@link Figur#getId()} of the {@link Figur}, which should
     *            be placed.
     * @param ebene
     *            The ebene-coordinate where the {@link Figur} should be placed.
     * @param buchstabe
     *            The buchstabe-coordinate where the {@link Figur} should be
     *            placed.
     * @param zahl
     *            The zahl-coordinate where the {@link Figur} should be placed.
     */
    public void move(final String id, final int ebene, final int buchstabe,
            final int zahl) {
        this.execute("move('" + id + "', " + ebene + ", " + buchstabe + ", "
                + zahl + ");");
    }

    /**
     * Removes a {@link Figur} with a given id from the game area.
     * 
     * @param id
     *            The {@link Figur#getId()}.
     */
    public void removeFigure(final String id) {
        this.execute("remove('" + id + "');");
    }

    /**
     * Adds a {@link Figur} with a given id to the game area.
     * 
     * @param id
     *            The {@link Figur#getId()}.
     */
    public void addFigure(final String id) {
        this.execute("add('" + id + "');");
    }

    /**
     * Executes a javascript command by bypassing the
     * {@link Browser#execute(String)} command, which is extremely slow due to
     * sleeps.
     * 
     * @param string
     *            The command, which should be executed.
     */
    private void execute(final String string) {
        System.out.println(this.browser.getDisplay());
        final HttpSession session = RWT.getSessionStore().getHttpSession();
        System.out.println("MaxInactiveIntervall: "
                + session.getMaxInactiveInterval());

        this.getParentDisplay().asyncExec(new Runnable() {
            @Override
            public void run() {
                final long start = System.currentTimeMillis();
                final JSWriter writer = JSWriter
                        .getWriterFor(ViewBrett.this.browser);
                try {
                    writer.call("execute", new Object[] { string });
                } catch (final IOException e) {
                    e.printStackTrace();
                }
                // execute(string);
                System.out.println(string + ": "
                        + (System.currentTimeMillis() - start));
            }
        });
    }

    /*
     * (non-Javadoc)
     * 
     * @see spielfeld.ui.ISpielFeld#getParentDisplay()
     */
    public Display getParentDisplay() {
        return this.browser.getDisplay();
    }
}
