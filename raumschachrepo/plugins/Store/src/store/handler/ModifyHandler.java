package store.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import store.ui.FigureView;

public class ModifyHandler extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        try {
            PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(FigureView.ID);
        } catch (PartInitException e) {
            e.printStackTrace();
        }
        return null;
    }

}
