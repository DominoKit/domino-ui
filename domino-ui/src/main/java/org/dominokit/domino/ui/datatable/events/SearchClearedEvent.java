package org.dominokit.domino.ui.datatable.events;

public class SearchClearedEvent implements TableEvent {

    public static final String SEARCH_EVENT_CLEARED = "table-search-cleared";

    @Override
    public String getType() {
        return SEARCH_EVENT_CLEARED;
    }
}
