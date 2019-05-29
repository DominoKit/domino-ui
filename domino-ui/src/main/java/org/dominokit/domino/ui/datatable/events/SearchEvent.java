package org.dominokit.domino.ui.datatable.events;

import org.dominokit.domino.ui.datatable.model.Category;
import org.dominokit.domino.ui.datatable.model.Filter;

import java.util.List;
import java.util.stream.Collectors;

public class SearchEvent implements TableEvent {

    public static final String SEARCH_EVENT = "table-search";
    private final List<Filter> filters;

    public SearchEvent(List<Filter> filters) {
        this.filters = filters;
    }

    public List<Filter> getFilters() {
        return filters;
    }

    public List<Filter> getByCategory(Category category) {
        return filters.stream().filter(f -> f.getCategory().equals(category)).collect(Collectors.toList());
    }

    @Override
    public String getType() {
        return SEARCH_EVENT;
    }
}
