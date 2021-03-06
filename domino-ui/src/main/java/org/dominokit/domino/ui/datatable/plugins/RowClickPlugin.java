package org.dominokit.domino.ui.datatable.plugins;

import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableRow;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.EventType;

/**
 * This plugin allow adding a listener to single click event on a row
 * @param <T> the type of the data table records
 */
public class RowClickPlugin<T> implements DataTablePlugin<T> {
    private ClickHandler<T> handler;

    /**
     * Creates a new instance
     * @param handler the {@link ClickHandler} to handle the click event
     */
    public RowClickPlugin(ClickHandler<T> handler) {
        this.handler = handler;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onRowAdded(DataTable<T> dataTable, TableRow<T> tableRow) {
        DominoElement.of(tableRow.element()).styler(style -> style.setCursor("pointer"));
        tableRow.element().addEventListener(EventType.click.getName(), evt -> handler.onClick(tableRow));
    }

    /**
     * An interface to implement handlers for the click event on a row
     * @param <T> the type of the row record
     */
    @FunctionalInterface
    public interface ClickHandler<T> {
        /**
         * called when the row is clicked
         * @param tableRow the clicked {@link TableRow}
         */
        void onClick(TableRow<T> tableRow);
    }
}
