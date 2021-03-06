package org.dominokit.domino.ui.datatable.store;

import org.dominokit.domino.ui.datatable.plugins.SortDirection;

import java.util.Comparator;

/**
 * An interface to implement the sort mechanism for a {@link LocalListDataStore}
 * @param <T> the type of the data table records
 */
@FunctionalInterface
public interface RecordsSorter<T> {
    /**
     *
     * @param sortBy String sort column name
     * @param sortDirection {@link SortDirection}
     * @return a {@link Comparator} to sort the records
     */
    Comparator<T> onSortChange(String sortBy, SortDirection sortDirection);
}
