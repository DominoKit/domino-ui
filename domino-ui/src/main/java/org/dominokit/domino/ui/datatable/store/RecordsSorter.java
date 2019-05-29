package org.dominokit.domino.ui.datatable.store;

import org.dominokit.domino.ui.datatable.plugins.SortDirection;

import java.util.Comparator;

@FunctionalInterface
public interface RecordsSorter<T> {
    Comparator<T> onSortChange(String sortBy, SortDirection sortDirection);
}
