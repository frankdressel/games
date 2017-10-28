package spielinfo;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import architecture.ISpielProvider;
import architecture.IStateAnalyzer;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "SpielInfo"; //$NON-NLS-1$

    // The shared instance
    private static Activator plugin;

    /**
     * The {@link ISpielProvider}, which is used for the current game.
     */
    private static ISpielProvider provider;
    /**
     * The {@link IStateAnalyzer}.
     */
    private static IStateAnalyzer analyzer;

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

    public static void bindSpielProvider(final ISpielProvider spielProvider) {
        Activator.provider = spielProvider;
    }

    public static void unbindSpielProvider(final ISpielProvider spielProvider) {
        Activator.provider = null;
    }

    public static void bindStateAnalyzer(final IStateAnalyzer stateAnalyzer) {
        Activator.analyzer = stateAnalyzer;
    }

    public static void unbindStateAnalyzer(final IStateAnalyzer stateAnalyzer) {
        Activator.analyzer = null;
    }

    public static ISpielProvider getProvider() {
        return Activator.provider;
    }

    public static IStateAnalyzer getAnalyzer() {
        return Activator.analyzer;
    }
}
