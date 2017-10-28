package verwaltung;

import org.eclipse.rwt.RWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

    public ApplicationWorkbenchWindowAdvisor(
            final IWorkbenchWindowConfigurer configurer) {
        super(configurer);
    }

    @Override
    public ActionBarAdvisor createActionBarAdvisor(
            final IActionBarConfigurer configurer) {
        return new ApplicationActionBarAdvisor(configurer);
    }

    @Override
    public void preWindowOpen() {
        final IWorkbenchWindowConfigurer configurer = this
                .getWindowConfigurer();
        final Rectangle rect = Display.getDefault().getPrimaryMonitor()
                .getBounds();
        configurer.setInitialSize(new Point(rect.width, rect.height));
        configurer.setShowCoolBar(false);
        configurer.setShowStatusLine(false);
        configurer.setTitle("Raumschach"); //$NON-NLS-1$
        configurer.setShowProgressIndicator(true);

        //Maps the newly created display of the current HTTPSession to the session id.
        Activator.getDisplayProvider().addDisplay(RWT.getSessionStore().getHttpSession().getId(),
                configurer.getWindow().getWorkbench().getDisplay());
    }
}
