package spiellogikgui.ui;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import raumschachmodell.modell.Spieler;
import spielfeld.Farbe;
import spiellogikgui.Activator;
import spiellogikgui.Messages;

/**
 * This class provides a shell with a GUI for the farb selection of a player.
 * 
 * @author frank
 * 
 */
public final class Farbselection {

    /**
     * A string constant.
     */
    private static final String SELECTED_FARBE = Messages.gewaehlteFarbe;
    /**
     * A string constant.
     */
    private static final String PLEASE_CHOOSE_ANOTHER_COLOR = Messages.chooseAnotherColor;
    /**
     * A string constant.
     */
    private static final String OK = Messages.ok;
    /**
     * A string constant.
     */
    private static final String ALREADY_IN_USE = Messages.colorAlreadyInUse;
    /**
     * The user selection shell.
     */
    Shell shell = null;

    Spieler spieler = null;
    private final Display display;

    /**
     * Default constructor.
     */
    public Farbselection(final Display disp) {
        this.display = disp;
    }

    /**
     * Opens a shell with a GUI, which allows a player the selection of a color.
     * 
     */
    public void askUserForSelection() {
        // Start a ui thread.
        this.display.syncExec(new Runnable() {
            @Override
            public void run() {
                // Get the player for this session.
                final String id = RWT.getSessionStore().getHttpSession()
                        .getId();
                for (final Spieler sp : Activator.getProvider().getSpiel()
                        .getSpieler()) {
                    if (sp.getId() == id) {
                        Farbselection.this.spieler = sp;
                        break;
                    }
                }

                // The parent Shell.
                // Check, if all the Farben are already used.
                final List<Spieler> spielerList = Activator.getProvider()
                        .getSpiel().getSpieler();
                final Set<Farbe> farbenUsed = new HashSet<Farbe>();
                for (final Spieler sp : spielerList) {
                    if (sp.getFarbe() != Farbe.UNSET) {
                        farbenUsed.add(sp.getFarbe());
                    }
                }
                if (farbenUsed.size() == 2) {
                    new MessageDialog(Farbselection.this.display
                            .getActiveShell(), Messages.allColorsUsedAlready,
                            null, Messages.justWatch,
                            MessageDialog.INFORMATION,
                            new String[] { Farbselection.OK }, 0).open();
                } else {
                    // Show a window, where the user can select the Farbe.
                    Farbselection.this.shell = new Shell(
                            Farbselection.this.display.getActiveShell(),
                            SWT.SHELL_TRIM | SWT.APPLICATION_MODAL);
                    Farbselection.this.shell.setText(Messages.chooseColor);
                    Farbselection.this.shell.setLayout(new GridLayout(3, true));
                    // Create three buttons for the Farbe.
                    final Button orange = new Button(Farbselection.this.shell,
                            SWT.RADIO);
                    orange.addSelectionListener(new SelectionAdapter() {

                        @Override
                        public void widgetSelected(final SelectionEvent e) {
                            if (!farbenUsed.contains(Farbe.ORANGE)
                                    && !farbenUsed.contains(Farbe.BEIDE)) {
                                Farbselection.this.shell.close();
                                Farbselection.this.shell.dispose();
                                farbenUsed.add(Farbe.ORANGE);
                                System.out.println(Farbselection.SELECTED_FARBE
                                        + Farbe.ORANGE);
                                Farbselection.this.spieler
                                        .setFarbe(Farbe.ORANGE);
                            } else {
                                new MessageDialog(
                                        Farbselection.this.display
                                                .getActiveShell(),
                                        Farbselection.ALREADY_IN_USE,
                                        null,
                                        Farbselection.PLEASE_CHOOSE_ANOTHER_COLOR,
                                        MessageDialog.INFORMATION,
                                        new String[] { Farbselection.OK }, 0)
                                        .open();
                            }
                        }
                    });
                    orange.setText(Messages.orange);
                    orange.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
                            true));

                    final Button grey = new Button(Farbselection.this.shell,
                            SWT.RADIO);
                    grey.addSelectionListener(new SelectionAdapter() {
                        @Override
                        public void widgetSelected(final SelectionEvent e) {
                            if (!farbenUsed.contains(Farbe.GRAU)
                                    && !farbenUsed.contains(Farbe.BEIDE)) {
                                Farbselection.this.spieler.setFarbe(Farbe.GRAU);
                                Farbselection.this.shell.close();
                                Farbselection.this.shell.dispose();
                                farbenUsed.add(Farbe.GRAU);
                                System.out.println(Farbselection.SELECTED_FARBE
                                        + Farbe.GRAU);
                            } else {
                                new MessageDialog(
                                        Farbselection.this.display
                                                .getActiveShell(),
                                        Farbselection.ALREADY_IN_USE,
                                        null,
                                        Farbselection.PLEASE_CHOOSE_ANOTHER_COLOR,
                                        MessageDialog.INFORMATION,
                                        new String[] { Farbselection.OK }, 0)
                                        .open();
                            }
                        }
                    });
                    grey.setText(Messages.gray);
                    grey.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
                            true));

                    final Button both = new Button(Farbselection.this.shell,
                            SWT.RADIO);
                    both.addSelectionListener(new SelectionAdapter() {
                        @Override
                        public void widgetSelected(final SelectionEvent e) {
                            if (!farbenUsed.contains(Farbe.BEIDE)) {
                                Farbselection.this.spieler
                                        .setFarbe(Farbe.BEIDE);
                                Farbselection.this.shell.close();
                                Farbselection.this.shell.dispose();
                                farbenUsed.add(Farbe.BEIDE);
                                System.out.println(Farbselection.SELECTED_FARBE
                                        + Farbe.BEIDE);
                            } else {
                                new MessageDialog(
                                        Farbselection.this.display
                                                .getActiveShell(),
                                        Farbselection.ALREADY_IN_USE,
                                        null,
                                        Farbselection.PLEASE_CHOOSE_ANOTHER_COLOR,
                                        MessageDialog.INFORMATION,
                                        new String[] { Farbselection.OK }, 0)
                                        .open();
                            }
                        }
                    });
                    both.setText(Messages.both);
                    both.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
                            true));

                    final Button cancel = new Button(Farbselection.this.shell,
                            SWT.PUSH);
                    cancel.addSelectionListener(new SelectionAdapter() {
                        @Override
                        public void widgetSelected(final SelectionEvent e) {
                            Farbselection.this.shell.close();
                            Farbselection.this.shell.dispose();
                        }
                    });
                    cancel.setText(Messages.doNotChooseAColor);
                    cancel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
                            true, 3, 1));

                    // Layout.
                    Farbselection.this.shell.pack();
                    // Place the shell in the middle.
                    Farbselection.this.shell.setLocation(
                            Farbselection.this.display.getBounds().width
                                    / 2
                                    - Farbselection.this.shell.getBounds().width
                                    / 2,
                            Farbselection.this.display.getBounds().height
                                    / 2
                                    - Farbselection.this.shell.getBounds().height
                                    / 2);
                    // Open the shell.
                    Farbselection.this.shell.open();
                }

                // Wait until the shell is closed.
                while (!Farbselection.this.shell.isDisposed()) {
                    if (!Farbselection.this.display.readAndDispatch()) {
                        Farbselection.this.display.sleep();
                    }
                }
            }
        });
    }
}
