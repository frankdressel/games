package store.ui;

import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.part.ViewPart;

import spielfeld.Figur;
import spielfeld.Koordinate;
import spielfeld.SpielfeldFactory;
import store.Activator;

import architecture.ISpielProvider;

/**
 * This view can be used to change the figure attributes manually.
 * 
 * @author frank
 * 
 */
public class FigureView extends ViewPart {

    /**
     * The id.
     */
    public static final String ID = "store.ui.FigureView";

    /**
     * Default constructor.
     */
    public FigureView() {
        super();
    }

    @Override
    public void createPartControl(final Composite parent) {
        final Table table = new Table(parent, SWT.FULL_SELECTION);
        final TableViewer viewer = new TableViewer(table);
        table.setHeaderVisible(true);
        // First column is for the name
        final TableViewerColumn viewerColumn1 = new TableViewerColumn(viewer,
                SWT.NONE);
        viewerColumn1.setLabelProvider(new CellLabelProvider() {
            @Override
            public void update(final ViewerCell cell) {
                cell.setText(((Figur) cell.getElement()).getName());
            }
        });
        final TableColumn column1 = viewerColumn1.getColumn();
        column1.setText("Name");
        column1.setWidth(150);
        column1.setResizable(true);
        column1.setMoveable(true);

        // Second column is for the active flag
        final TableViewerColumn viewerColumn2 = new TableViewerColumn(viewer,
                SWT.NONE);
        viewerColumn2.setEditingSupport(new ActivityEditing(viewer));
        final TableColumn column2 = viewerColumn2.getColumn();
        column2.setText("Active");
        column2.setWidth(100);
        column2.setResizable(true);
        column2.setMoveable(true);
        viewerColumn2.setLabelProvider(new CellLabelProvider() {
            @Override
            public void update(final ViewerCell cell) {
                cell.setText(((Figur) cell.getElement()).isActive() ? "true"
                        : "false");
            }
        });

        // Third column is for the active position
        final TableViewerColumn viewerColumn3 = new TableViewerColumn(viewer,
                SWT.NONE);
        viewerColumn3.setEditingSupport(new EbenenEditing(viewer));
        final TableColumn column3 = viewerColumn3.getColumn();
        column3.setText("Ebene");
        column3.setWidth(100);
        column3.setResizable(true);
        column3.setMoveable(true);
        viewerColumn3.setLabelProvider(new CellLabelProvider() {
            @Override
            public void update(final ViewerCell cell) {
                cell.setText(((Figur) cell.getElement()).getPosition()
                        .getEbene() + "");
            }
        });

        // Third column is for the active position
        final TableViewerColumn viewerColumn4 = new TableViewerColumn(viewer,
                SWT.NONE);
        viewerColumn4.setEditingSupport(new BuchstabenEditing(viewer));
        final TableColumn column4 = viewerColumn4.getColumn();
        column4.setText("Buchstabe");
        column4.setWidth(100);
        column4.setResizable(true);
        column4.setMoveable(true);
        viewerColumn4.setLabelProvider(new CellLabelProvider() {
            @Override
            public void update(final ViewerCell cell) {
                cell.setText(((Figur) cell.getElement()).getPosition()
                        .getBuchstabe() + "");
            }
        });

        // Third column is for the active position
        final TableViewerColumn viewerColumn5 = new TableViewerColumn(viewer,
                SWT.NONE);
        viewerColumn5.setEditingSupport(new ZahlEditing(viewer));
        final TableColumn column5 = viewerColumn5.getColumn();
        column5.setText("Zahl");
        column5.setWidth(100);
        column5.setResizable(true);
        column5.setMoveable(true);
        viewerColumn5.setLabelProvider(new CellLabelProvider() {
            @Override
            public void update(final ViewerCell cell) {
                cell.setText(((Figur) cell.getElement()).getPosition()
                        .getZahl() + "");
            }
        });

        // Setting content provider
        final ObservableListContentProvider viewerContent = new ObservableListContentProvider();
        viewer.setContentProvider(viewerContent);

        viewer.setInput(new WritableList(Activator.getProvider().getSpiel().getFigures(),
                Figur.class));
    }

    @Override
    public void setFocus() {
    }

    /**
     * This class is responsible for creating a combobox in the table for the
     * active attribute of figures.
     * 
     * @author frank
     * 
     */
    private class ActivityEditing extends EditingSupport {
        /**
         * The {@link TableViewer}.
         */
        private final TableViewer viewer;

        /**
         * Constructor.
         * 
         * @param view
         *            The {@link TableViewer} used.
         */
        public ActivityEditing(final TableViewer view) {
            super(view);
            this.viewer = view;
        }

        @Override
        protected CellEditor getCellEditor(final Object element) {
            final String[] activ = new String[2];
            activ[0] = "false";
            activ[1] = "true";

            return new ComboBoxCellEditor(this.viewer.getTable(), activ);
        }

        @Override
        protected boolean canEdit(final Object element) {
            return true;
        }

        @Override
        protected Object getValue(final Object element) {
            final Figur figur = (Figur) element;
            if (figur.isActive()) {
                return 1;
            }
            return 0;

        }

        @Override
        protected void setValue(final Object element, final Object value) {
            final Figur figur = (Figur) element;
            if ((Integer) value == 0) {
                figur.setActive(false);
            } else {
                figur.setActive(true);
            }
            this.viewer.refresh();
        }
    }

    /**
     * This class is responsible for setting the ebenen-attribute based on the
     * table.
     * 
     * @author frank
     * 
     */
    private class EbenenEditing extends EditingSupport {
        /**
         * The {@link TableViewer}.
         */
        private final TableViewer viewer;

        /**
         * Constructor.
         * 
         * @param view
         *            The {@link TableViewer} used.
         */
        public EbenenEditing(final TableViewer view) {
            super(view);
            this.viewer = view;
        }

        @Override
        protected Object getValue(final Object element) {
            return ((Figur) element).getPosition().getEbene() + "";
        }

        @Override
        protected void setValue(final Object element, final Object value) {
            if (((String) value).length() > 0) {
                final Figur figur = (Figur) element;
                // Remove the listeners to do unrecognized changes.
                final List<Adapter> adapters = figur.eAdapters();
                for (final Adapter adapter : adapters) {
                    figur.eAdapters().remove(adapter);
                }
                final Koordinate koord = SpielfeldFactory.eINSTANCE
                        .createKoordinate();
                koord.setEbene(Integer.parseInt((String) value));
                koord.setBuchstabe(figur.getPosition().getBuchstabe());
                koord.setZahl(figur.getPosition().getZahl());
                figur.setPosition(koord);
                this.viewer.refresh();
                // Add the adapters again.
                figur.eAdapters().addAll(adapters);
            }
        }

        @Override
        protected boolean canEdit(final Object element) {
            return true;
        }

        @Override
        protected CellEditor getCellEditor(final Object element) {
            return new TextCellEditor(this.viewer.getTable());
        }
    }

    /**
     * This class is responsible for setting the buchstaben-attribute based on
     * the table.
     * 
     * @author frank
     * 
     */
    private class BuchstabenEditing extends EditingSupport {
        /**
         * The {@link TableViewer}.
         */
        private final TableViewer viewer;

        /**
         * Constructor.
         * 
         * @param view
         *            The {@link TableViewer} used.
         */
        public BuchstabenEditing(final TableViewer view) {
            super(view);
            this.viewer = view;
        }

        @Override
        protected Object getValue(final Object element) {
            return ((Figur) element).getPosition().getBuchstabe() + "";
        }

        @Override
        protected void setValue(final Object element, final Object value) {
            final Figur figur = (Figur) element;
            // Remove the listeners to do unrecognized changes.
            final List<Adapter> adapters = figur.eAdapters();
            for (final Adapter adapter : adapters) {
                figur.eAdapters().remove(adapter);
            }
            final Koordinate koord = SpielfeldFactory.eINSTANCE
                    .createKoordinate();
            koord.setEbene(figur.getPosition().getEbene());
            koord.setBuchstabe(Integer.parseInt((String) value));
            koord.setZahl(figur.getPosition().getZahl());
            figur.setPosition(koord);
            // Add the adapters again.
            figur.eAdapters().addAll(adapters);
            this.viewer.refresh();
        }

        @Override
        protected boolean canEdit(final Object element) {
            return true;
        }

        @Override
        protected CellEditor getCellEditor(final Object element) {
            return new TextCellEditor(this.viewer.getTable());
        }
    }

    /**
     * This class is responsible for setting the zahl-attribute based on the
     * table.
     * 
     * @author frank
     * 
     */
    private class ZahlEditing extends EditingSupport {
        /**
         * The {@link TableViewer}.
         */
        private final TableViewer viewer;

        /**
         * Constructor.
         * 
         * @param view
         *            The {@link TableViewer} used.
         */
        public ZahlEditing(final TableViewer view) {
            super(view);
            this.viewer = view;
        }

        @Override
        protected Object getValue(final Object element) {
            return ((Figur) element).getPosition().getZahl() + "";
        }

        @Override
        protected void setValue(final Object element, final Object value) {
            final Figur figur = (Figur) element;
            // Remove the listeners to do unrecognized changes.
            final List<Adapter> adapters = figur.eAdapters();
            for (final Adapter adapter : adapters) {
                figur.eAdapters().remove(adapter);
            }
            final Koordinate koord = SpielfeldFactory.eINSTANCE
                    .createKoordinate();
            koord.setEbene(figur.getPosition().getEbene());
            koord.setBuchstabe(figur.getPosition().getBuchstabe());
            koord.setZahl(Integer.parseInt((String) value));
            figur.setPosition(koord);
            // Add the adapters again.
            figur.eAdapters().addAll(adapters);
            this.viewer.refresh();
        }

        @Override
        protected boolean canEdit(final Object element) {
            return true;
        }

        @Override
        protected CellEditor getCellEditor(final Object element) {
            return new TextCellEditor(this.viewer.getTable());
        }
    }

}
