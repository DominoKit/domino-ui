package org.dominokit.domino.ui.datatable.store;

import java.util.List;

public class DataChangedEvent<T> {
    private final List<T> newData;
    private final boolean append;
    private final int totalCount;

    public DataChangedEvent(List<T> newData, int totalCount) {
        this.newData = newData;
        this.totalCount = totalCount;
        this.append=false;
    }

    public DataChangedEvent(List<T> newData, boolean append, int totalCount) {
        this.newData = newData;
        this.append = append;
        this.totalCount = totalCount;
    }

    public List<T> getNewData() {
        return newData;
    }

    public boolean isAppend() {
        return append;
    }

    public int getTotalCount() {
        return totalCount;
    }
}
