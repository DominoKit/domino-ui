package org.dominokit.domino.ui.datatable.events;

import java.util.List;

public class OnBeforeDataChangeEvent<T> implements TableEvent {

    public static final String ON_BEFORE_DATA_CHANGE = "table-on-before-data-change";

    private final List<T> data;
    private final int totalCount;
    private boolean isAppend = false;

    public OnBeforeDataChangeEvent(List<T> data, int totalCount, boolean isAppend) {
        this.data = data;
        this.totalCount = totalCount;
        this.isAppend = isAppend;
    }

    @Override
    public String getType() {
        return ON_BEFORE_DATA_CHANGE;
    }

    public List<T> getData() {
        return data;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public boolean isAppend() {
        return isAppend;
    }
}
