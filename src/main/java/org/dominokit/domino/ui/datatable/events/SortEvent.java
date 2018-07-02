package org.dominokit.domino.ui.datatable.events;

import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.plugins.DataTableSortPlugin;

public class SortEvent<T> implements TableEvent {

    public static final String SORT_EVENT = "table-sort";

    private final DataTableSortPlugin.SortDirection sortDirection;
    private final ColumnConfig<T> columnConfig;

    public SortEvent(DataTableSortPlugin.SortDirection sortDirection, ColumnConfig<T> columnConfig) {
        this.sortDirection = sortDirection;
        this.columnConfig = columnConfig;
    }

    public DataTableSortPlugin.SortDirection getSortDirection() {
        return sortDirection;
    }

    public ColumnConfig<T> getColumnConfig() {
        return columnConfig;
    }

    @Override
    public String getType() {
        return SORT_EVENT;
    }
}
