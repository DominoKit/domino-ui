package org.dominokit.domino.ui.datatable.events;

public class SearchEvent implements TableEvent {

    public static final String SEARCH_EVENT = "table-search";

    private final String searchText;
    private final String searchField;

    public SearchEvent(String searchText, String searchField) {
        this.searchText = searchText;
        this.searchField = searchField;
    }

    public String getSearchText() {
        return searchText;
    }

    public String getSearchField() {
        return searchField;
    }

    @Override
    public String getType() {
        return SEARCH_EVENT;
    }
}
