package help;

import java.text.MessageFormat;

import org.eclipse.help.IContext;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.help.AbstractHelpUI;

public class RAPHelpUI extends AbstractHelpUI {

  public void displayHelp() {
    openHelpWindow( getBaseUrl( "/html/rules.html" ) );
  }

  private void openHelpWindow( String url ) {
    Shell parentShell = getActiveShell();
    Shell shell = new Shell( parentShell, SWT.SHELL_TRIM );
    shell.setText("Zu Hülf', zu Hülf'!");
    GridLayout layout = new GridLayout( 1, false );
    layout.marginHeight = 0;
    layout.marginWidth = 0;
    shell.setLayout( layout );
    shell.setSize( 600, 480 );
    shell.setLocation( 150, 150 );
    
    Browser browser = new Browser( shell, SWT.NONE );
    browser.setLayoutData( new GridData( SWT.FILL, SWT.FILL, true, true ) );
    browser.setUrl( url );
    
    shell.open();
  }

  private Shell getActiveShell() {
    IWorkbench workbench = PlatformUI.getWorkbench();
    Shell parentShell = workbench.getActiveWorkbenchWindow().getShell();
    return parentShell;
  }

  public void displayHelpResource( String href ) {
    openHelpWindow( getBaseUrl( "/topic" + href ) );
  }

  public boolean isContextHelpDisplayed() {
    return false;
  }

  public void displayDynamicHelp() {
    super.displayDynamicHelp();
    displayHelp();
  }

  public void displayContext( IContext context, int x, int y ) {
    String text = context.getText();
    MessageDialog.openInformation( getActiveShell(), "Context Help", text );
  }

  private static String getBaseUrl( String path ) {
    String helpURL = "http://{0}:{1}" + path;
    Object[] param = new Object[]{
      RWT.getRequest().getServerName(),
      String.valueOf( RWT.getRequest().getServerPort() )
    };
    return MessageFormat.format( helpURL, param );
  }
}
