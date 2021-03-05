package org.dominokit.domino.ui.datatable.events;

import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.plugins.SortDirection;

/**
 * This event will be fired when ever the sort in a data store is changed or by clicking on a column header
 * @param <T> the type of the table records
 */
public class SortEvent<T> implements TableEvent {

    /**
     * A constant string to define a unique type for this event
     */
    public static final String SORT_EVENT = "table-sort";

    private final SortDirection sortDirection;
    private final ColumnConfig<T> columnConfig;

    /**
     *
     * @param sortDirection the {@link SortDirection}
     * @param columnConfig the {@link ColumnConfig} that represent the column being clicked for sort
     */
    public SortEvent(SortDirection sortDirection, ColumnConfig<T> columnConfig) {
        this.sortDirection = sortDirection;
        this.columnConfig = columnConfig;
    }

    /**
     *
     * @return the {@link SortDirection}
     */
    public SortDirection getSortDirection() {
        return sortDirection;
    }

    /**
     *
     * @return the {@link ColumnConfig} that represent the column being clicked for sort
     */
    public ColumnConfig<T> getColumnConfig() {
        return columnConfig;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getType() {
        return SORT_EVENT;
    }
}
