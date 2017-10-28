package spiellogikgui;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.impl.EReferenceImpl;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import raumschachmodell.modell.Spiel;
import raumschachmodell.modell.Spieler;
import raumschachmodell.modell.State;
import spielfeld.Farbe;
import spiellogikgui.ui.CheckMessage;
import spiellogikgui.ui.Farbselection;
import architecture.IDisplayProvider;
import architecture.ISpielProvider;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "SpiellogikGui"; //$NON-NLS-1$

    // The shared instance
    private static Activator plugin;

    private static IDisplayProvider displayProvider;

    /**
     * The {@link ISpielProvider}, which is used for the current game.
     */
    private static ISpielProvider provider;

    /**
     * The constructor
     */
    public Activator() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
     * )
     */
    @Override
    public void start(final BundleContext context) throws Exception {
        super.start(context);
        Activator.plugin = this;
    }

    /**
     * Adds adapters for the game messages like displaying chess message or
     * showing the color selection dialog.
     */
    private static void addGameNotifiers() {
        final Spiel spiel = Activator.provider.getSpiel();
        spiel.eAdapters().add(new AdapterImpl() {
            @Override
            public void notifyChanged(final Notification msg) {
                // Check, if an attribute changed.
                if (msg.getFeature() instanceof EReferenceImpl) {
                    // Check, if the attribute is the selected flag.
                    if (((EReferenceImpl) msg.getFeature()).getName()
                            .equalsIgnoreCase("spieler")) {
                        final Spieler spieler = (Spieler) msg.getNewValue();
                        spieler.eAdapters().add(new AdapterImpl() {
                            @Override
                            public void notifyChanged(final Notification msg) {
                                // Check, if an attribute changed.
                                if (msg.getFeature() instanceof EAttribute) {
                                    // Check, if the attribute is the state
                                    // flag.
                                    if (((EAttribute) msg.getFeature())
                                            .getName()
                                            .equalsIgnoreCase("state")) {
                                        // Run over all displays.
                                        for (final Display display : Activator.displayProvider
                                                .getAllDisplays()) {
                                            if (msg.getNewValue() == State.MATT) {
                                                // Show the matt message.
                                                display.asyncExec(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        // Show the matt
                                                        // message.
                                                        new CheckMessage(
                                                                display)
                                                                .showGameOverMessage(spieler
                                                                        .getFarbe());
                                                    }
                                                });
                                            }
                                            if (msg.getNewValue() == State.REMIS) {
                                                // Show the matt message.
                                                display.asyncExec(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        // Show the matt
                                                        // message.
                                                        new CheckMessage(
                                                                display)
                                                                .showRemisMessage(spieler
                                                                        .getFarbe());
                                                    }
                                                });
                                            }
                                            if (msg.getNewValue() == State.SCHACH) {
                                                // Show the matt message.
                                                display.asyncExec(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        new CheckMessage(
                                                                display)
                                                                .showCheckMessage(spieler
                                                                        .getFarbe());
                                                    }
                                                });
                                            }
                                        }
                                    }
                                    // Check, if the attribute is the farbe
                                    // flag.
                                    if (((EAttribute) msg.getFeature())
                                            .getName()
                                            .equalsIgnoreCase("farbe")) {
                                        if (msg.getNewValue() == Farbe.UNSET) {
                                            // Show the matt message.
                                            Activator.displayProvider
                                                    .getDisplay(spieler.getId())
                                                    .asyncExec(new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            new Farbselection(
                                                                    Activator.displayProvider
                                                                            .getDisplay(spieler
                                                                                    .getId()))
                                                                    .askUserForSelection();
                                                        }
                                                    });
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            }
        });
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
     * )
     */
    @Override
    public void stop(final BundleContext context) throws Exception {
        Activator.plugin = null;
        super.stop(context);
    }

    /**
     * Returns the shared instance
     * 
     * @return the shared instance
     */
    public static Activator getDefault() {
        return Activator.plugin;
    }

    public static void bindISpielProvider(final ISpielProvider spielProvider) {
        Activator.provider = spielProvider;
        addGameNotifiers();
    }

    public static void unbindISpielProvider(final ISpielProvider spielProvider) {
        Activator.provider = null;
    }

    public static ISpielProvider getProvider() {
        return Activator.provider;
    }

    public static void bindDisplayProvider(final IDisplayProvider provider) {
        Activator.displayProvider = provider;
    }

    public static void unbindDisplayProvider(final IDisplayProvider provider) {
        Activator.displayProvider = null;
    }

}
