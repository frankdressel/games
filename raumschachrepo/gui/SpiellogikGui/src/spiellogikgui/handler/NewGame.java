package spiellogikgui.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.widgets.Event;

import spiellogikgui.Activator;

/**
 * This is the handler for reacting to a "New Game" event.
 * 
 * @author frank
 * 
 */
public class NewGame extends AbstractHandler {

    /**
     * Default constructor.
     */
    public NewGame() {
        super();
    }

    @Override
    public Object execute(final ExecutionEvent event) throws ExecutionException {
        // Reset the game.
        final Job job = new Job("") {

            @Override
            protected IStatus run(final IProgressMonitor monitor) {
                ((Event) event.getTrigger()).display.asyncExec(new Runnable() {
                    @Override
                    public void run() {
                        Activator.getProvider().getSpiel().reset();
                    }
                });
                return Status.OK_STATUS;
            }
        };
        job.setPriority(Job.INTERACTIVE);
        job.schedule();

        return null;
    }
}
