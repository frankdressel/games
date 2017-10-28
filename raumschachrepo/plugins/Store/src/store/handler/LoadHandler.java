package store.handler;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import raumschachmodell.modell.Spiel;
import store.Activator;
import store.DataBase;

/**
 * This class is responsible for reacting to the GUI action: Load was selected
 * in a menu.
 * 
 * @author frank
 * 
 */
public class LoadHandler extends AbstractHandler {

    /**
     * Dummy constructor.
     */
    public LoadHandler() {
    }

    @Override
    public Object execute(final ExecutionEvent event) throws ExecutionException {
        // Create a Shell for selecting the game.
        final Shell shell = new Shell(SWT.SHELL_TRIM | SWT.APPLICATION_MODAL);
        shell.setSize(new Point(400, 200));
        shell.setLayout(new GridLayout(1, true));
        shell.setText(Messages.LoadHandler_loadTitle);

        // Show a table with the games.
        final Composite tableComposite = new Composite(shell, SWT.NONE);
        final TableColumnLayout tableColumnLayout = new TableColumnLayout();
        tableComposite.setLayout(tableColumnLayout);
        tableComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
                true));

        // Create the table viewer.
        final TableViewer viewer = new TableViewer(tableComposite, SWT.MULTI
                | SWT.H_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
        // Set the content provider. Use ArrayContentProvider to provide a
        // 2d-elements (items with more than one subitems).
        viewer.setContentProvider(new ArrayContentProvider());

        final Table table = viewer.getTable();
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
        table.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(final SelectionEvent e) {
                try {
                    DataBase.getInstance().assignData(table.getSelectionIndex());
                } catch (final IllegalArgumentException e1) {
                    e1.printStackTrace();
                } catch (final SecurityException e1) {
                    e1.printStackTrace();
                } catch (final IllegalAccessException e1) {
                    e1.printStackTrace();
                } catch (final InvocationTargetException e1) {
                    e1.printStackTrace();
                } catch (final NoSuchMethodException e1) {
                    e1.printStackTrace();
                } finally {
                    shell.close();
                }
            }
        });

        // Set the height to a 19 rows.
        final int desiredHeight = table.getItemHeight() * 10
                + table.getHeaderHeight();
        final GridData doubleColumnGridData = new GridData(200, desiredHeight);
        doubleColumnGridData.grabExcessHorizontalSpace = true;
        doubleColumnGridData.grabExcessVerticalSpace = false;
        doubleColumnGridData.horizontalAlignment = SWT.FILL;
        doubleColumnGridData.verticalAlignment = SWT.FILL;
        tableComposite.setLayoutData(doubleColumnGridData);

        // The column for the position.
        final TableViewerColumn viewerColumnMove = new TableViewerColumn(
                viewer, SWT.NONE);
        final TableColumn column = viewerColumnMove.getColumn();
        column.setText(Messages.LoadHandler_description);
        viewerColumnMove.setLabelProvider(new ColumnLabelProvider() {
            @Override
            public String getText(final Object element) {
                final Spiel spiel = (Spiel) element;
                return spiel.getBeschreibung();
            }
        });
        // Set the width to 70%.
        tableColumnLayout.setColumnData(viewerColumnMove.getColumn(),
                new ColumnWeightData(70));

        // Set as input a new Arraylist.
        viewer.setInput(DataBase.getInstance().load());

        // Layout.
        shell.pack();
        // Place the shell in the middle.
        shell.setLocation(
                Display.getCurrent().getBounds().width / 2
                        - shell.getBounds().width / 2, Display.getCurrent()
                        .getBounds().height / 2 - shell.getBounds().height / 2);
        // Open the shell.
        shell.open();

        return null;
    }

}
