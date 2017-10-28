package spielinfo;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.impl.EReferenceImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;

import spielfeld.Farbe;

/**
 * This view provides the user with information about the current player
 * strengths.
 * 
 * @author frank
 * 
 */
public class InfoView extends ViewPart {

    /**
     * The {@link Label} for showing informations about {@link Farbe#GRAU}.
     */
    private Label grau;
    /**
     * The {@link Label} for showing informations about {@link Farbe#ORANGE}.
     */
    private Label orange;

    /**
     * Default constructor.
     */
    public InfoView() {
    }

    @Override
    public void createPartControl(final Composite parent) {
        Activator.getProvider().getSpiel().eAdapters()
                .add(new EContentAdapter() {

                    @Override
                    public void notifyChanged(final Notification notification) {
                        if (notification.getFeature() instanceof EReferenceImpl
                                && ((EReferenceImpl) notification.getFeature())
                                        .getName().equalsIgnoreCase("zuege")
                                && (notification.getEventType() == Notification.ADD || notification
                                        .getEventType() == Notification.REMOVE_MANY)) {
                            parent.getDisplay().asyncExec(new Runnable() {
                                @Override
                                public void run() {
                                    InfoView.this.refresh();
                                }
                            });
                        }
                    }
                });

        // Set the layout.
        parent.setLayout(new GridLayout(1, true));
        final Composite grauComponent = new Composite(parent, SWT.None);
        grauComponent
                .setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        grauComponent.setBackground(new Color(Display.getCurrent(), 132, 132,
                132));
        grauComponent.setLayout(new GridLayout(1, true));
        final Composite orangeComponent = new Composite(parent, SWT.None);
        orangeComponent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
                true));
        orangeComponent.setBackground(new Color(Display.getCurrent(), 255, 128,
                0));
        orangeComponent.setLayout(new GridLayout(1, true));
        // Create a label for gray.
        this.grau = new Label(grauComponent, SWT.None);
        this.grau
                .setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));
        this.grau.setBackground(new Color(Display.getCurrent(), 132, 132, 132));
        this.grau.setText(""
                + Activator.getAnalyzer().analyzeStrength().get(Farbe.GRAU));
        this.grau.setAlignment(SWT.CENTER);

        // Create a label for orange.
        this.orange = new Label(orangeComponent, SWT.None);
        this.orange.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true,
                true));
        this.orange.setBackground(new Color(Display.getCurrent(), 255, 128, 0));
        this.orange.setText(""
                + Activator.getAnalyzer().analyzeStrength().get(Farbe.ORANGE));
        this.orange.setAlignment(SWT.CENTER);
    }

    @Override
    public void setFocus() {
    }

    /**
     * Refreshes the view with updated information.
     */
    private void refresh() {
        this.grau.setText(""
                + Activator.getAnalyzer().analyzeStrength().get(Farbe.GRAU));
        this.orange.setText(""
                + Activator.getAnalyzer().analyzeStrength().get(Farbe.ORANGE));
    }
}
