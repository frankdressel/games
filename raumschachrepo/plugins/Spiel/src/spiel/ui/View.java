package spiel.ui;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.ecore.impl.EReferenceImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

import raumschachmodell.modell.RaumschachModellPackage;
import raumschachmodell.modell.Spieler;
import spiel.Activator;
import spielfeld.Farbe;
import spielfeld.Figur;
import spielfeld.Koordinate;
import spielfeld.Zug;

/**
 * This view shows the list of moves.
 * 
 * @author frank
 * 
 */
public class View extends ViewPart {
    /**
     * The ID.
     */
    public static final String ID = "spiel.ui.View";

    /**
     * The names of the ebenen.
     */
    private final String[] ebenen = new String[] { "A", "B", "C", "D", "E" };
    /**
     * The names of the buchstaben.
     */
    private final String[] buchstaben = new String[] { "e", "d", "c", "b", "a" };

    /**
     * The {@link TableViewer}.
     */
    private TableViewer viewer = null;

    /**
     * The underlying {@link Table}.
     */
    private Table table = null;
    /**
     * The name of the creator of the game.
     */
    private Text name = null;

    /**
     * The description of the game.
     */
    private Text description = null;

    /**
     * Default constructor.
     */
    public View() {
    }

    @Override
    public void createPartControl(final Composite parent) {
        parent.setLayout(new GridLayout(1, true));

        RaumschachModellPackage.eINSTANCE.eClass();
        
        // Create the databinding context.
        DataBindingContext bindingContext = new DataBindingContext();

        final Group group = new Group(parent, SWT.BORDER);
        group.setText("Spiel");
        group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
        group.setLayout(new GridLayout(1, true));
        // The name of the player.
        this.name = new Text(group, SWT.SINGLE | SWT.BORDER);
        this.name.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true,
                1, 1));
        //Get the player for this session.
        Spieler spieler=null;
        final String id=RWT.getSessionStore().getHttpSession().getId();
        for (Spieler sp : Activator.getProvider().getSpiel().getSpieler()) {
            if(sp.getId()==id){
                spieler=sp;
                break;
            }
        }
        // Add the binding.
        bindingContext.bindValue(
                WidgetProperties.text(SWT.Modify).observe(name),
                EMFProperties.value(
                        RaumschachModellPackage.Literals.SPIELER__NAME)
                        .observe(spieler));

        // The description.
        this.description = new Text(group, SWT.MULTI | SWT.BORDER | SWT.WRAP);
        this.description.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
                true, 1, 1));

        final Composite tableComposite = new Composite(parent, SWT.NONE);
        final TableColumnLayout tableColumnLayout = new TableColumnLayout();
        tableComposite.setLayout(tableColumnLayout);
        // Add the binding.
        bindingContext.bindValue(
                WidgetProperties.text(SWT.Modify).observe(description),
                EMFProperties.value(
                        RaumschachModellPackage.Literals.SPIEL__BESCHREIBUNG)
                        .observe(Activator.getProvider().getSpiel()));

        // Create the table viewer.
        this.viewer = new TableViewer(tableComposite, SWT.MULTI | SWT.H_SCROLL
                | SWT.FULL_SELECTION | SWT.BORDER);
        // Set the content provider. Use ArrayContentProvider to provide a
        // 2d-elements (items with more than one subitems).
        this.viewer.setContentProvider(new ArrayContentProvider());
        // Make the selection available to other views
        this.getSite().setSelectionProvider(this.viewer);

        this.table = this.viewer.getTable();
        this.table.setHeaderVisible(true);
        this.table.setLinesVisible(true);

        // Set the height to a given number of rows.
        this.setHeight(tableComposite, 10);

        // Create the two columns.
        this.createColumns(tableColumnLayout);

        // Set as input the list of zuege.
        this.viewer.setInput(Activator.getProvider().getSpiel().getZuege());

        Activator.getProvider().getSpiel().eAdapters().add(new EContentAdapter() {

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
                            View.this.viewer.refresh();
                        }
                    });
                }
            }
        });
    }

    /**
     * Set the height of the table to a given number of rows.
     * 
     * @param tableComposite
     *            The {@link Composite} with the table.
     * @param rows
     *            The number of rows, that should be shown.
     */
    private void setHeight(final Composite tableComposite, final int rows) {
        final int desiredHeight = this.table.getItemHeight() * rows
                + this.table.getHeaderHeight();
        final GridData doubleColumnGridData = new GridData(200, desiredHeight);
        doubleColumnGridData.grabExcessHorizontalSpace = true;
        doubleColumnGridData.grabExcessVerticalSpace = false;
        doubleColumnGridData.horizontalAlignment = SWT.FILL;
        doubleColumnGridData.verticalAlignment = SWT.FILL;
        tableComposite.setLayoutData(doubleColumnGridData);
    }

    /**
     * Create two columns for the table. One for the figure and one for the end
     * position after the move.
     * 
     * @param tableColumnLayout
     *            The layout of the composite of the table.
     */
    private void createColumns(final TableColumnLayout tableColumnLayout) {
        // The column for the name.
        final TableViewerColumn viewerColumnName = new TableViewerColumn(
                this.viewer, SWT.NONE);
        TableColumn column = viewerColumnName.getColumn();
        column.setText("Figur ");
        viewerColumnName.setLabelProvider(new ColumnLabelProvider() {
            @Override
            public String getText(final Object element) {
                final Zug zug = (Zug) element;
                return zug.getFigur().getName();
            }

            @Override
            public Color getBackground(final Object element) {
                final Zug zug = (Zug) element;
                return zug.getFigur().getFarbe() == Farbe.GRAU ? new Color(
                        View.this.table.getDisplay(), 216, 216, 216)
                        : new Color(View.this.table.getDisplay(), 250, 172, 88);
            }
        });

        // The column width for the name. The remaining two columns share the
        // remaining place equally.
        final int spaceForName = 54;
        tableColumnLayout.setColumnData(viewerColumnName.getColumn(),
                new ColumnWeightData(spaceForName));

        // The column for the start-position.
        final TableViewerColumn viewerColumnStart = new TableViewerColumn(
                this.viewer, SWT.NONE);
        column = viewerColumnStart.getColumn();
        column.setText("Von");
        viewerColumnStart.setLabelProvider(new ColoredColumnLabelProvider() {
            @Override
            public String getText(final Object element) {
                final Zug zug = (Zug) element;
                // The end position.
                final Koordinate ende = zug.getStartPosition();
                return View.this.ebenen[ende.getEbene()] + ", "
                        + View.this.buchstaben[ende.getBuchstabe()] + ", "
                        + (ende.getZahl() + 1);
            }
        });
        // Set the width.
        tableColumnLayout.setColumnData(viewerColumnStart.getColumn(),
                new ColumnWeightData((100 - spaceForName) / 2));

        // The column for the end-position.
        final TableViewerColumn viewerColumnEnd = new TableViewerColumn(
                this.viewer, SWT.NONE);
        column = viewerColumnEnd.getColumn();
        column.setText("Nach");
        viewerColumnEnd.setLabelProvider(new ColoredColumnLabelProvider() {
            @Override
            public String getText(final Object element) {
                final Zug zug = (Zug) element;
                // The end position.
                final Koordinate ende = zug.getEndPosition();
                return View.this.ebenen[ende.getEbene()] + ", "
                        + View.this.buchstaben[ende.getBuchstabe()] + ", "
                        + (ende.getZahl() + 1);
            }
        });
        // Set the width.
        tableColumnLayout.setColumnData(viewerColumnEnd.getColumn(),
                new ColumnWeightData((100 - spaceForName) / 2));
    }

    @Override
    public void setFocus() {
    }

    /**
     * Refreshes the table viewer.
     */
    public void refreshViewer() {
        View.this.viewer.getControl().getDisplay().syncExec(new Runnable() {
            @Override
            public void run() {
                View.this.viewer.refresh();
                // Focus the last item.
                if (View.this.table.getItems().length > 0) {
                    View.this.table.showItem(View.this.table.getItems()[View.this.table
                            .getItems().length - 1]);
                }
            }
        });
    }

    public void setName(final String n) {
        this.name.setText(n);
    }

    public String getName() {
        return this.name.getText();
    }

    public String getBeschreibung() {
        return this.description.getText();
    }

    public void setBeschreibung(final String des) {
        this.description.setText(des);
    }

    /**
     * This class extends {@link ColumnLabelProvider} in such a way, that the
     * background for the labels is set according to the {@link Farbe} of the
     * used {@link Figur}. It is assummed, that the objects shown in the column
     * are {@link Zug} objects.
     * 
     * @author frank
     * 
     */
    class ColoredColumnLabelProvider extends ColumnLabelProvider {

        /**
         * Default constructor.
         */
        public ColoredColumnLabelProvider() {
            super();
        }

        @Override
        public Color getBackground(final Object element) {
            final Zug zug = (Zug) element;
            return zug.getFigur().getFarbe() == Farbe.GRAU ? new Color(
                    View.this.table.getDisplay(), 216, 216, 216) : new Color(
                    View.this.table.getDisplay(), 250, 172, 88);
        }
    }
}
