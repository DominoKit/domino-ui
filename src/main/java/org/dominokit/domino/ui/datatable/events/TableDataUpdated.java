package org.dominokit.domino.ui.datatable.events;

import java.util.List;

public class TableDataUpdated<T> implements TableEvent {

    public static final String DATA_UPDATED = "table-data-updated";

    private final List<T> data;
    private final int totalCount;

    public TableDataUpdated(List<T> data, int totalCount) {
        this.data = data;
        this.totalCount = totalCount;
    }

    @Override
    public String getType() {
        return DATA_UPDATED;
    }

    public List<T> getData() {
        return data;
    }

    public int getTotalCount() {
        return totalCount;
    }
}
