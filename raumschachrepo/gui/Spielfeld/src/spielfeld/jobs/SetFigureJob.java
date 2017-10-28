package spielfeld.jobs;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.rwt.RWT;

import raumschachmodell.figures.FigurProvider;
import spielfeld.Figur;
import spielfeld.Messages;
import spielfeld.ui.ViewBrett;
import architecture.ISpielProvider;

/**
 * This class is used for setting the figure positions on the UI representation
 * of the checkerboard according to the actual model.
 * 
 * @author frank
 * 
 */
public class SetFigureJob implements IRunnableWithProgress {

    /**
     * The instance of the underlying {@link ViewBrett}.
     */
    private final ViewBrett viewBrett;

    /**
     * The {@link ISpielProvider}, which allows acces to the current game.
     */
    private final ISpielProvider provider;

    /**
     * Creates a new {@link IRunnableWithProgress}, for placing the figures
     * according to the actual {@link FigurProvider}.
     * 
     * @param brett
     *            The actual {@link ViewBrett}.
     * @param prov
     *            The {@link ISpielProvider}, which is used for the current
     *            game.
     */
    public SetFigureJob(final ViewBrett brett, final ISpielProvider prov) {
        this.viewBrett = brett;
        this.provider = prov;
    }

    @Override
    public void run(final IProgressMonitor monitor)
            throws InvocationTargetException, InterruptedException {
        // The list of figures.
        final Collection<Figur> figures = this.provider.getSpiel().getFigures();
        // Start the progress monitor.
        monitor.beginTask(Messages.jobDescription, figures.size());
        for (final Figur figur : figures) {
            monitor.subTask(figur.getName());
            this.viewBrett.move(figur.getId(), figur.getPosition().getEbene(),
                    figur.getPosition().getBuchstabe(), figur.getPosition()
                            .getZahl());
            if (!figur.isActive()) {
                this.viewBrett.removeFigure(figur.getId());
            }
            // Remove the old adapter for the same session. It could happen,
            // that this routine is called often (for example loading a
            // game/creating a new one). There should be just one adapter for
            // the highlighting for the same session.
            final List<Adapter> removeMe = new ArrayList<Adapter>();
            final String sessionID = RWT.getRequest().getSession().getId();
            for (final Adapter adapter : figur.eAdapters()) {
                if (adapter instanceof HighlightAddAdapter
                        && ((HighlightAddAdapter) adapter).getSessionID()
                                .equalsIgnoreCase(sessionID)) {
                    removeMe.add(adapter);
                }
            }
            figur.eAdapters().removeAll(removeMe);
            // Add a new adapter.
            figur.eAdapters().add(new HighlightAddAdapter(figur, sessionID));
            monitor.worked(1);
        }
    }

    /**
     * This class represents an adapter, which causes the figure to be
     * highlighted if it is selected. Additionally, if the status of a
     * {@link Figur} is changed from inactive to active it is added again to the
     * game.
     * 
     * @author frank
     * 
     */
    class HighlightAddAdapter extends AdapterImpl {

        /**
         * The {@link Figur}, which causes the events.
         */
        private final Figur figur;
        /**
         * The session id of the session, for which the adapter is created.
         */
        private final String sessionID;

        /**
         * Creates a new adapter for a given {@link Figur}.
         * 
         * @param fig
         *            The {@link Figur} which causes the events.
         * @param id
         *            The session id of the session, for which the adapter is
         *            created.
         */
        public HighlightAddAdapter(final Figur fig, final String id) {
            this.figur = fig;
            this.sessionID = id;
        }

        @Override
        public void notifyChanged(final Notification msg) {
            // Refresh the browser.
            SetFigureJob.this.viewBrett.move(this.figur.getId(), this.figur
                    .getPosition().getEbene(), this.figur.getPosition()
                    .getBuchstabe(), this.figur.getPosition().getZahl());
            if (!this.figur.isActive()) {
                SetFigureJob.this.viewBrett.removeFigure(this.figur.getId());
            }
            // Check, if an attribute changed.
            if (msg.getFeature() instanceof EAttribute) {
                // Check, if the attribute is the active flag.
                if (((EAttribute) msg.getFeature()).getName().equalsIgnoreCase(
                        "active")) {
                    // Check, if the flag was set to true (active).
                    if (msg.getNewBooleanValue() && !msg.getOldBooleanValue()) {
                        // Add the figure.
                        SetFigureJob.this.viewBrett.addFigure(this.figur
                                .getId());
                    }
                }
            }
            // Check, if an attribute changed.
            if (msg.getFeature() instanceof EAttribute) {
                // Check, if the attribute is the selected flag.
                if (((EAttribute) msg.getFeature()).getName().equalsIgnoreCase(
                        "selected")) {
                    // Check, if the flag was set to true (active).
                    if (msg.getNewBooleanValue()) {
                        // Highlight the figure.
                        SetFigureJob.this.viewBrett.highlightFigure(this.figur
                                .getId());
                    } else {
                        // Unhighlight the figure.
                        SetFigureJob.this.viewBrett
                                .unhighlightFigure(this.figur.getId());
                    }
                }
            }
        }

        public String getSessionID() {
            return this.sessionID;
        }
    }
}
