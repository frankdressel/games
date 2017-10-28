package verwaltung;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import architecture.IDataBaseWrapper;
import architecture.IDisplayProvider;
import architecture.ISpielProvider;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "Verwaltung"; //$NON-NLS-1$

    // The shared instance
    private static Activator plugin;

    /**
     * The provider of displays for a given session.
     */
    private static IDisplayProvider displayProvider;

    /**
     * The provider of the underlying spiel.
     */
    private static ISpielProvider spielProvider;

    /**
     * The data base wrapper.
     */
    private static IDataBaseWrapper databaseWrapper;

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

        // Check, if the user is online.
        try {
            final URL google = new URL("http://www.google.de/");
            final BufferedReader in = new BufferedReader(new InputStreamReader(
                    google.openStream()));

            in.close();

            System.out.println("Opening start file");
            Desktop.getDesktop().browse(
                    FileLocator.toFileURL(
                            FileLocator.find(Platform.getBundle("Htmls"),
                                    new Path("/html/start.html"), null))
                            .toURI());

        } catch (final IOException e) {
            Desktop.getDesktop().browse(
                    new URI("http://localhost/view?startup=view"));
        }
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

    /**
     * Returns an image descriptor for the image file at the given plug-in
     * relative path
     * 
     * @param path
     *            the path
     * @return the image descriptor
     */
    public static ImageDescriptor getImageDescriptor(final String path) {
        return AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID,
                path);
    }

    public static void bindDisplayProvider(IDisplayProvider displayProvider){
        Activator.displayProvider=displayProvider;
    }
    
    public static void unbindDisplayProvider(IDisplayProvider displayProvider){
        Activator.displayProvider=null;
    }

    public static IDisplayProvider getDisplayProvider() {
        return displayProvider;
    }
    
    public static void bindSpielProvider(ISpielProvider spielProvider){
        Activator.spielProvider=spielProvider;
    }
    
    public static void unbindSpielProvider(ISpielProvider spielProvider){
        Activator.spielProvider=null;
    }

    public static ISpielProvider getSpielProvider() {
        return spielProvider;
    }
    
    public static void bindDataBaseWrapper(IDataBaseWrapper databaseWrapper){
        Activator.databaseWrapper=databaseWrapper;
    }
    
    public static void unbindDataBaseWrapper(IDataBaseWrapper databaseWrapper){
        Activator.databaseWrapper=null;
    }

    public static IDataBaseWrapper getDatabaseWrapper() {
        return databaseWrapper;
    }
}
