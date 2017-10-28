package log;

import java.io.File;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.eclipse.core.runtime.Platform;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    public static final String LOGGERNAME=Logger.GLOBAL_LOGGER_NAME;
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		Logger.getLogger(LOGGERNAME).setUseParentHandlers(false);
		//Create a new filehandler.
		final FileHandler handler=new FileHandler(Platform.getLocation().toFile().toString()+File.separator+"raumschach.log");
		handler.setFormatter(new SimpleFormatter());
		Logger.getLogger(LOGGERNAME).addHandler(handler);
		Logger.getLogger(LOGGERNAME).setLevel(Level.FINEST);
		Logger.getLogger(LOGGERNAME).log(Level.INFO,"Logger started");
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	    Logger.getLogger(LOGGERNAME).log(Level.INFO,"Logger stoped");
	    for (Handler handler : Logger.getLogger(LOGGERNAME).getHandlers()) {
	        handler.flush();
	        handler.close();
        }
	}

}
