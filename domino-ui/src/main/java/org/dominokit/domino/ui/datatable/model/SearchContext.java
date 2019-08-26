package org.dominokit.domino.ui.datatable.model;

import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.events.SearchClearedEvent;
import org.dominokit.domino.ui.datatable.events.SearchEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class SearchContext<T> {

    private final DataTable<T> dataTable;
    private final List<Filter> filters = new ArrayList<>();
    private final List<Consumer<SearchContext<T>>> beforeSearchHandlers = new ArrayList<>();

    public SearchContext(DataTable<T> dataTable) {
        this.dataTable = dataTable;
    }

    public SearchContext add(Filter filter) {
        if (filters.contains(filter)) {
            this.filters.remove(filter);
        }

        this.filters.add(filter);
        return this;
    }

    public SearchContext remove(Filter filter) {
        return remove(filter.getFieldName(), filter.getCategory());
    }

    public SearchContext remove(String fieldName) {
        filters.removeAll(filters.stream().filter(filter -> filter.getFieldName().equals(fieldName)).collect(Collectors.toList()));
        return this;
    }

    public SearchContext remove(String fieldName, Category category) {
        filters.removeAll(filters.stream().filter(filter -> filter.getFieldName().equals(fieldName)
                && filter.getCategory().equals(category)).collect(Collectors.toList()));
        return this;
    }

    public SearchContext removeByCategory(Category category) {
        List<Filter> collect = filters.stream().filter(filter -> filter.getCategory().equals(category)).collect(Collectors.toList());
        if (!collect.isEmpty()) {
            filters.removeAll(collect);
        }
        return this;
    }

    public SearchContext clear() {
        filters.clear();
        dataTable.fireTableEvent(new SearchClearedEvent());
        return this;
    }

    public List<Filter> get(String fieldName) {
        return filters.stream().filter(filter -> filter.getFieldName().equals(fieldName)).collect(Collectors.toList());
    }

    public List<Filter> listAll() {
        return new ArrayList<>(filters);
    }

    public boolean contains(Filter filter) {
        return filters.stream().anyMatch(f -> f.equals(filter));
    }

    public void fireSearchEvent() {
        beforeSearchHandlers.forEach(handler -> handler.accept(SearchContext.this));
        dataTable.fireTableEvent(new SearchEvent(listAll()));
    }

    public void addBeforeSearchHandler(Consumer<SearchContext<T>> handler) {
        this.beforeSearchHandlers.add(handler);
    }

    public void removeBeforeSearchHandler(Consumer<SearchContext<T>> handler) {
        this.beforeSearchHandlers.remove(handler);
    }
}
