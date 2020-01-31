package org.dominokit.domino.ui.datatable.plugins;

import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableRow;
import org.jboss.elemento.EventType;

public class DoubleClickPlugin<T> implements DataTablePlugin<T> {

    private DoublClickHandler<T> handler;

    public DoubleClickPlugin(DoublClickHandler<T> handler) {
        this.handler = handler;
    }

    @Override
    public void onRowAdded(DataTable<T> dataTable, TableRow<T> tableRow) {
        tableRow.element().addEventListener(EventType.dblclick.getName(), evt -> {
            handler.onDoubleClick(tableRow);
        });
    }

    @FunctionalInterface
    public interface DoublClickHandler<T> {
        void onDoubleClick(TableRow<T> tableRow);
    }
}
