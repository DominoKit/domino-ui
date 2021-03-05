package org.dominokit.domino.ui.datatable.events;

import org.dominokit.domino.ui.datatable.plugins.SortDirection;

import java.util.List;
import java.util.Optional;

/**
 * This event will be fired by the {@link org.dominokit.domino.ui.datatable.plugins.SortPlugin} or the {@link org.dominokit.domino.ui.datatable.DataTable}
 * when the sort is by the data store.
 */
public class DataSortEvent implements TableEvent{

    /**
     * A constant string to define a unique type for this event
     */
    public static final String EVENT ="data-table-sort-applied-event";

    private final String sortColumn;
    private final SortDirection sortDirection;

    /**
     *
     * @param sortDirection {@link SortDirection}
     * @param sortColumn String, the column name that we are using to sort the data by.
     */
    public DataSortEvent(SortDirection sortDirection, String sortColumn) {
        this.sortDirection = sortDirection;
        this.sortColumn = sortColumn;
    }

    /**
     *
     * @return String, the sort column name
     */
    public String getSortColumn() {
        return sortColumn;
    }

    /**
     *
     * @return {@link SortDirection}
     */
    public SortDirection getSortDirection() {
        return sortDirection;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getType() {
        return EVENT;
    }
}
