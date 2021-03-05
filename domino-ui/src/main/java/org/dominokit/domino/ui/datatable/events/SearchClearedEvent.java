package org.dominokit.domino.ui.datatable.events;

/**
 * This event will be fired when the date table search is cleared,
 * it is fired by the
 * <p></p>
 * {@link org.dominokit.domino.ui.datatable.DataTable}
 * <p></p>
 * {@link org.dominokit.domino.ui.datatable.plugins.ColumnHeaderFilterPlugin}
 * <p></p>
 * {@link org.dominokit.domino.ui.datatable.plugins.HeaderBarPlugin.SearchTableAction}
 * <p></p>
 * {@link org.dominokit.domino.ui.datatable.model.SearchContext}
 *
 */
public class SearchClearedEvent implements TableEvent {

    /**
     * A constant string to define a unique type for this event
     */
    public static final String SEARCH_EVENT_CLEARED = "table-search-cleared";

    /**
     * {@inheritDoc}
     */
    @Override
    public String getType() {
        return SEARCH_EVENT_CLEARED;
    }
}
