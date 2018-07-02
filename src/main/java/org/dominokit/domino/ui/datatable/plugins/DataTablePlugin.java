package org.dominokit.domino.ui.datatable.plugins;

import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableRow;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.datatable.events.TableEventListener;

public interface DataTablePlugin<T> extends TableEventListener {

    default void onBeforeAddTable(DataTable<T> dataTable){}
    default void onBeforeAddHeaders(DataTable<T> dataTable){}
    default void onHeaderAdded(DataTable<T> dataTable, ColumnConfig<T> column){}
    default void onBodyAdded(DataTable<T> dataTable){}
    default void onBeforeAddRow(DataTable<T> dataTable){}
    default void onRowAdded(DataTable<T> dataTable, TableRow<T> tableRow){}
    default void onAllRowsAdded(DataTable<T> dataTable, TableRow<T> tableRow){}
    default void onAfterAddTable(DataTable<T> dataTable){}

    @Override
    default void handleEvent(TableEvent event) {}
}
