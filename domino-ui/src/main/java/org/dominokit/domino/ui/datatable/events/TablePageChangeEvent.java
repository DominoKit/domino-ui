package org.dominokit.domino.ui.datatable.events;

import org.dominokit.domino.ui.pagination.HasPagination;

/**
 * This event will be fired when the page of the data table is changed
 */
public class TablePageChangeEvent implements TableEvent {

    /**
     * A constant string to define a unique type for this event
     */
    public static final String PAGINATION_EVENT = "table-page-change";

    private final int page;
    private final HasPagination pagination;

    /**
     *
     * @param page int, the new page
     * @param pagination the {@link HasPagination} which is the component that changed the page.
     */
    public TablePageChangeEvent(int page, HasPagination pagination) {
        this.page = page;
        this.pagination = pagination;
    }

    /**
     *
     * @return int, the new page
     */
    public int getPage() {
        return page;
    }

    /**
     *
     * @return the {@link HasPagination} which is the component that changed the page.
     */
    public HasPagination getPagination() {
        return pagination;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getType() {
        return PAGINATION_EVENT;
    }
}
