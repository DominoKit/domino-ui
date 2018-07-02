package org.dominokit.domino.ui.datatable.store;

import org.dominokit.domino.ui.datatable.events.SearchEvent;
import org.dominokit.domino.ui.datatable.events.TableEventListener;
import org.dominokit.domino.ui.datatable.plugins.DataTableSortPlugin;

import java.util.Comparator;
import java.util.List;

public interface DataStore<T> extends TableEventListener {
    void onDataChanged(StoreDataChangeListener<T> dataChangeListener);

    void removeDataChangeListener(StoreDataChangeListener<T> dataChangeListener);

    void load();

    @FunctionalInterface
    interface StoreDataChangeListener<T> {
        void onDataChanged(DataChangedEvent<T> dataChangedEvent);
    }

    @FunctionalInterface
    interface SearchFilter<T> {
        boolean filterRecord(SearchEvent event, T record);
    }

    interface RecordsSorter<T> {
        Comparator<T> onSortChange(String sortBy, DataTableSortPlugin.SortDirection sortDirection);
    }

    class DataChangedEvent<T> {
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
}

