package org.dominokit.domino.ui.datatable.events;

import org.dominokit.domino.ui.datatable.plugins.SortDirection;

import java.util.List;
import java.util.Optional;

public class DataSortEvent implements TableEvent{

    public static final String EVENT ="data-table-sort-applied-event";

    private final String sortColumn;
    private final SortDirection sortDirection;

    public DataSortEvent(SortDirection sortDirection, String sortColumn) {
        this.sortDirection = sortDirection;
        this.sortColumn = sortColumn;
    }

    public String getSortColumn() {
        return sortColumn;
    }

    public SortDirection getSortDirection() {
        return sortDirection;
    }

    @Override
    public String getType() {
        return EVENT;
    }
}
