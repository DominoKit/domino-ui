package org.dominokit.domino.ui.datatable.store;

import org.dominokit.domino.ui.datatable.events.SearchEvent;

/**
 * An interface to write implementation for filtering {@link LocalListDataStore} records
 * @param <T>
 */
@FunctionalInterface
public interface SearchFilter<T> {
    /**
     * Filters a record based on the search filters
     * @param event {@link SearchEvent}
     * @param record T the record being checked
     * @return boolean, true if the record match the search criteria otherwise false.
     */
    boolean filterRecord(SearchEvent event, T record);
}
