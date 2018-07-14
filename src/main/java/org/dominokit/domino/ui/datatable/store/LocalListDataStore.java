package org.dominokit.domino.ui.datatable.store;

import org.dominokit.domino.ui.datatable.events.SearchEvent;
import org.dominokit.domino.ui.datatable.events.SortEvent;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.pagination.HasPagination;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.datatable.events.SearchEvent.SEARCH_EVENT;
import static org.dominokit.domino.ui.datatable.events.SortEvent.SORT_EVENT;
import static org.dominokit.domino.ui.datatable.events.TablePageChangeEvent.PAGINATION_EVENT;

public class LocalListDataStore<T> implements DataStore<T> {

    private List<StoreDataChangeListener<T>> listeners = new ArrayList<>();

    private final List<T> original;
    private List<T> filtered;
    private HasPagination pagination;
    private SearchFilter<T> searchFilter;
    private RecordsSorter<T> recordsSorter;
    private SortEvent<T> lastSort;

    public LocalListDataStore() {
        this.original = new ArrayList<>();
        this.filtered = new ArrayList<>();
    }

    public LocalListDataStore(List<T> data) {
        this.original = data;
        this.filtered = new ArrayList<>(data);
    }

    public void setData(List<T> data) {
        this.original.clear();
        this.original.addAll(data);
        this.filtered.clear();
        this.filtered.addAll(original);
    }

    public SearchFilter<T> getSearchFilter() {
        return searchFilter;
    }

    public LocalListDataStore<T> setSearchFilter(SearchFilter<T> searchFilter) {
        this.searchFilter = searchFilter;
        return this;
    }

    public HasPagination getPagination() {
        return pagination;
    }

    public LocalListDataStore<T> setPagination(HasPagination pagination) {
        this.pagination = pagination;
        return this;
    }

    public RecordsSorter<T> getRecordsSorter() {
        return recordsSorter;
    }

    public LocalListDataStore<T> setRecordsSorter(RecordsSorter<T> recordsSorter) {
        this.recordsSorter = recordsSorter;
        return this;
    }

    private void updatePagination() {
        if (nonNull(pagination) && nonNull(original)) {
            this.pagination.updatePagesByTotalCount(this.original.size());
        }
    }

    @Override
    public void onDataChanged(StoreDataChangeListener<T> dataChangeListener) {
        listeners.add(dataChangeListener);
    }

    @Override
    public void removeDataChangeListener(StoreDataChangeListener<T> dataChangeListener) {
        listeners.remove(dataChangeListener);
    }

    @Override
    public void handleEvent(TableEvent event) {
        switch (event.getType()) {
            case SEARCH_EVENT:
                onSearchChanged((SearchEvent) event);
                break;
            case SORT_EVENT:
                onSortChanged((SortEvent) event);
                break;
            case PAGINATION_EVENT:
                onPageChanged();
                break;
        }
    }

    private void onSearchChanged(SearchEvent event) {
        if (nonNull(searchFilter)) {
            filtered = original.stream().filter(record -> searchFilter.filterRecord(event, record)).collect(Collectors.toList());
            if (nonNull(lastSort)) {
                sort(lastSort);
            }
            loadFirstPage();
        }
    }


    private void onSortChanged(SortEvent<T> event) {
        if (nonNull(this.recordsSorter)) {
            this.lastSort = event;
            sort(event);
            fireUpdate();
        }
    }

    private void sort(SortEvent<T> event) {
        filtered.sort(recordsSorter.onSortChange(event.getColumnConfig().getName(), event.getSortDirection()));
    }

    private void loadFirstPage() {
        if (nonNull(pagination)) {
            pagination.updatePagesByTotalCount(filtered.size());
            fireUpdate();
        } else {
            fireUpdate();
        }
    }

    private void onPageChanged() {
        fireUpdate();
    }

    @Override
    public void load() {
        fireUpdate();
        updatePagination();
    }

    private void fireUpdate() {
        listeners.forEach(dataChangeListener -> dataChangeListener.onDataChanged(new DataChangedEvent<>(getUpdateRecords(), filtered.size())));
    }

    private List<T> getUpdateRecords() {
        if (nonNull(pagination)) {
            int fromIndex = pagination.getPageSize() * (pagination.activePage() - 1);
            int toIndex = Math.min(fromIndex + pagination.getPageSize(), filtered.size());
            return new ArrayList<>(filtered.subList(fromIndex, toIndex));
        } else {
            return new ArrayList<>(filtered);
        }
    }


}
