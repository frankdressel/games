package spiellogik;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
    private static final String BUNDLE_NAME = "spiellogik.messages"; //$NON-NLS-1$
    public static String aufgebenTitle;
    public static String aufgebenMessage;
    public static String aufgebenButton;
    public static String gewaehlteFarbe;
    public static String check;
    public static String chooseAnotherColor;
    public static String doNotChooseAColor;
    public static String ok;
    public static String colorAlreadyInUse;
    public static String allColorsUsedAlready;
    public static String justWatch;
    public static String chooseColor;
    public static String orange;
    public static String gray;
    public static String both;
    public static String kingIsInCheck;
    static {
        // initialize resource bundle
        NLS.initializeMessages(Messages.BUNDLE_NAME, Messages.class);
    }

    private Messages() {
    }
}
