package raumschachmodell;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
    private static final String BUNDLE_NAME = "raumschachmodell.messages"; //$NON-NLS-1$
    public static String whiteKnight;
    public static String blackKnight;
    public static String whiteUnicorn;
    public static String blackUnicorn;
    public static String created;
    public static String blackCastle;
    public static String whiteCastle;
    public static String whiteBishop;
    public static String blackBishop;
    public static String whiteQueen;
    public static String blackQueen;
    public static String blackKing;
    public static String whiteKing;
    public static String blackPawn;
    public static String whitePawn;
    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    private Messages() {
    }
}
