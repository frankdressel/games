package spiellogikgui.ui;


import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

import spielfeld.Farbe;
import spiellogikgui.Messages;

public class CheckMessage {
    private Display display;

    public CheckMessage(Display disp){
        this.display=disp;
    }
    /**
     * Shows a message, if the active color is in check.
     */
    public void showCheckMessage(final Farbe farbe) {
        // Show a message window.
        MessageDialog.openInformation(display.getActiveShell(), Messages.check,
                Messages.kingIsInCheck
                        + (farbe == Farbe.GRAU ? ": "+Messages.gray
                                : (farbe==Farbe.BEIDE?"":": "+Messages.orange)));
    }

    public void showGameOverMessage(Farbe farbe) {
        // Show a message window.
        MessageDialog.openInformation(display.getActiveShell(), "Game over",
                (farbe == Farbe.GRAU ? ": "+Messages.gray : (farbe==Farbe.BEIDE?"":": "+Messages.orange))
                        + " hat das Spiel verloren");
    }

    public void showRemisMessage(Farbe active) {
        // Show a message window.
        MessageDialog.openInformation(display.getActiveShell(), "Remis", "Unentschieden");
    }
}
