package org.dominokit.domino.ui.datatable.store;

import org.dominokit.domino.ui.datatable.plugins.SortDirection;

import java.util.List;
import java.util.Optional;

public class DataChangedEvent<T> {
    private final List<T> newData;
    private final boolean append;
    private final int totalCount;
    private final Optional<SortDirection> sortDir;
    private final Optional<String> sortColumn;

    public DataChangedEvent(List<T> newData, int totalCount) {
        this.newData = newData;
        this.totalCount = totalCount;
        this.append=false;
        this.sortDir = Optional.empty();
        this.sortColumn = Optional.empty();
    }

    public DataChangedEvent(List<T> newData, int totalCount, SortDirection sortDirection, String sortColumn) {
        this.newData = newData;
        this.totalCount = totalCount;
        this.append=false;
        this.sortDir = Optional.of(sortDirection);
        this.sortColumn = Optional.of(sortColumn);
    }

    public DataChangedEvent(List<T> newData, boolean append, int totalCount) {
        this.newData = newData;
        this.append = append;
        this.totalCount = totalCount;
        this.sortDir = Optional.empty();
        this.sortColumn = Optional.empty();
    }

    public DataChangedEvent(List<T> newData, boolean append, int totalCount, SortDirection sortDirection, String sortColumn) {
        this.newData = newData;
        this.append = append;
        this.totalCount = totalCount;
        this.sortDir = Optional.of(sortDirection);
        this.sortColumn = Optional.of(sortColumn);
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

    public Optional<SortDirection> getSortDir() {
        return sortDir;
    }

    public Optional<String> getSortColumn() {
        return sortColumn;
    }
}
