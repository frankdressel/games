package spielfeld;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import architecture.ISpielProvider;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "Spielfeld"; //$NON-NLS-1$

    // The shared instance
    private static Activator plugin;

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
    
    public static void bindSpielProvider(ISpielProvider spielProvider){
        provider=spielProvider;
    }
    
    public static void unbindSpielProvider(ISpielProvider spielProvider){
        provider=null;
    }

    public static ISpielProvider getProvider() {
        return provider;
    }
}
