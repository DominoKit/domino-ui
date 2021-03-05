package org.dominokit.domino.ui.datatable.events;

import org.dominokit.domino.ui.datatable.model.Category;
import org.dominokit.domino.ui.datatable.model.Filter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This event is fired when ever the search filters of the data table are changed,
 * it is fired from the following locations :
 * <p></p>
 * {@link org.dominokit.domino.ui.datatable.store.LocalListDataStore}
 * <p></p>
 * {@link org.dominokit.domino.ui.datatable.store.LocalListScrollingDataSource}
 * <p></p>
 * {@link org.dominokit.domino.ui.datatable.store.SearchFilter}
 * <p></p>
 * {@link org.dominokit.domino.ui.datatable.model.SearchContext}
 */
public class SearchEvent implements TableEvent {

    /**
     * A constant string to define a unique type for this event
     */
    public static final String SEARCH_EVENT = "table-search";
    private final List<Filter> filters;

    /**
     *
     * @param filters the {@link List} of {@link Filter}s that are being applied
     */
    public SearchEvent(List<Filter> filters) {
        this.filters = filters;
    }

    /**
     *
     * @return the {@link List} of {@link Filter}s that are being applied
     */
    public List<Filter> getFilters() {
        return filters;
    }

    /**
     *
     * @param category {@link Category}
     * @return a List of {@link Filter}s of the specified category
     */
    public List<Filter> getByCategory(Category category) {
        return filters.stream().filter(f -> f.getCategory().equals(category)).collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getType() {
        return SEARCH_EVENT;
    }
}
