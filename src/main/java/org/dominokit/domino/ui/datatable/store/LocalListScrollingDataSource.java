package org.dominokit.domino.ui.datatable.store;

import org.dominokit.domino.ui.datatable.events.BodyScrollEvent;
import org.dominokit.domino.ui.datatable.events.SearchEvent;
import org.dominokit.domino.ui.datatable.events.SortEvent;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.datatable.plugins.BodyScrollPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.datatable.events.BodyScrollEvent.BODY_SCROLL;
import static org.dominokit.domino.ui.datatable.events.SortEvent.SORT_EVENT;
import static org.dominokit.domino.ui.datatable.events.SearchEvent.SEARCH_EVENT;

public class LocalListScrollingDataSource<T> implements DataStore<T> {

    private final List<T> original;
    private List<T> filtered = new ArrayList<>();
    private final int pageSize;
    private int pageIndex = 0;
    private List<StoreDataChangeListener<T>> listeners = new ArrayList<>();
    private SearchFilter<T> searchFilter;
    private RecordsSorter<T> recordsSorter;
    private SortEvent<T> lastSort;

    public LocalListScrollingDataSource(int pageSize) {
        this.original = new ArrayList<>();
        this.pageSize = pageSize;
    }

    public LocalListScrollingDataSource(List<T> data, int pageSize) {
        this.original = data;
        this.pageSize = pageSize;
        this.filtered.addAll(data);
    }

    public SearchFilter<T> getSearchFilter() {
        return searchFilter;
    }

    public LocalListScrollingDataSource<T> setSearchFilter(SearchFilter<T> searchFilter) {
        this.searchFilter = searchFilter;
        return this;
    }
    public RecordsSorter<T> getRecordsSorter() {
        return recordsSorter;
    }

    public LocalListScrollingDataSource<T> setRecordsSorter(RecordsSorter<T> recordsSorter) {
        this.recordsSorter = recordsSorter;
        return this;
    }

    public void setData(List<T> data){
        this.original.clear();
        this.original.addAll(data);
        this.filtered.clear();
        this.filtered.addAll(original);
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
    public void load() {
        pageIndex = 0;
        fireUpdate(false);
    }

    private void fireUpdate(boolean append) {
        int fromIndex = pageSize * pageIndex;
        int toIndex = Math.min(fromIndex + pageSize, filtered.size());

        listeners.forEach(dataChangeListener -> dataChangeListener.onDataChanged(new DataChangedEvent<>(new ArrayList<>(filtered.subList(fromIndex, toIndex)), append, filtered.size())));
    }

    @Override
    public void handleEvent(TableEvent event) {
        switch (event.getType()) {
            case BODY_SCROLL:
                onBodyScroll((BodyScrollEvent) event);
                break;
            case SORT_EVENT:
                onSort((SortEvent<T>) event);
                break;
            case SEARCH_EVENT:
                onSearch((SearchEvent) event);
                break;
        }
    }

    private void onBodyScroll(BodyScrollEvent bodyScrollEvent) {
        if (BodyScrollPlugin.ScrollPosition.BOTTOM.equals(bodyScrollEvent.getScrollPosition())) {
            int nextIndex = pageIndex + 1;
            int fromIndex=nextIndex * pageSize;
            if (fromIndex < filtered.size()) {
                pageIndex++;
                fireUpdate(true);
            }
        }
    }

    private void onSearch(SearchEvent event) {
        if(nonNull(searchFilter)){
            filtered=original.stream().filter(t -> searchFilter.filterRecord(event, t)).collect(Collectors.toList());
            if(nonNull(lastSort)){
                onSort(lastSort);
            }else {
                pageIndex = 0;
                fireUpdate(false);
            }
        }
    }

    private void onSort(SortEvent<T> event) {
        if(nonNull(this.recordsSorter)){
            this.lastSort=event;
            filtered.sort(recordsSorter.onSortChange(event.getColumnConfig().getName(), event.getSortDirection()));
            pageIndex=0;
            fireUpdate(false);
        }
    }
}
