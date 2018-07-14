package org.dominokit.domino.ui.datatable.store;

import org.dominokit.domino.ui.datatable.events.SearchEvent;

@FunctionalInterface
public interface SearchFilter<T> {
    boolean filterRecord(SearchEvent event, T record);
}
