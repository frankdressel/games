package store.handler;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
    private static final String BUNDLE_NAME = "handler.messages"; //$NON-NLS-1$
    public static String LoadHandler_name;
    public static String LoadHandler_description;
    public static String LoadHandler_checkPositions;
    public static String LoadHandler_loadTitle;
    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    private Messages() {
    }
}
