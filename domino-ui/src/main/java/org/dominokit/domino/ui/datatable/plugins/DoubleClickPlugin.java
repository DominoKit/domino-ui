package org.dominokit.domino.ui.datatable.plugins;

import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableRow;
import org.jboss.elemento.EventType;

/**
 * this plugin attach a handler to listen for double click event on data table rows
 * @param <T> the type of data table records
 */
public class DoubleClickPlugin<T> implements DataTablePlugin<T> {

    private DoubleClickHandler<T> handler;

    /**
     * creates a new instance
     * @param handler the {@link DoubleClickHandler}
     */
    public DoubleClickPlugin(DoubleClickHandler<T> handler) {
        this.handler = handler;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onRowAdded(DataTable<T> dataTable, TableRow<T> tableRow) {
        tableRow.element().addEventListener(EventType.dblclick.getName(), evt -> {
            handler.onDoubleClick(tableRow);
        });
    }

    /**
     * An interface to handle row double click event
     * @param <T> the type of the row record
     */
    @FunctionalInterface
    public interface DoubleClickHandler<T> {
        /**
         * to handle the event
         * @param tableRow the {@link TableRow} being double clicked
         */
        void onDoubleClick(TableRow<T> tableRow);
    }
}
