package spielfeld;

import org.eclipse.osgi.util.NLS;

/**
 * This class is responsible for handling internationalisation.
 * 
 * @author frank
 * 
 */
public final class Messages extends NLS {
    /**
     * The variable for naming the progress monitor observing the set up of the
     * figures.
     */
    public static String jobDescription;
    /**
     * The name of the message bundle.
     */
    private static final String BUNDLE_NAME = "spielfeld.messages"; //$NON-NLS-1$
    static {
        // initialize resource bundle
        NLS.initializeMessages(Messages.BUNDLE_NAME, Messages.class);
    }

    /**
     * Avoids instantiation.
     */
    private Messages() {
    }
}
