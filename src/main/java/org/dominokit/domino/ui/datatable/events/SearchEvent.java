package org.dominokit.domino.ui.datatable.events;

public class SearchEvent implements TableEvent {

    public static final String SEARCH_EVENT = "table-search";

    private final String searchText;

    public SearchEvent(String searchText) {
        this.searchText = searchText;
    }

    public String getSearchText() {
        return searchText;
    }

    @Override
    public String getType() {
        return SEARCH_EVENT;
    }
}
