package org.dominokit.domino.ui.datatable.events;

import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.pagination.HasPagination;

public class TablePageChangeEvent implements TableEvent {

    public static final String PAGINATION_EVENT = "table-page-change";

    private final int page;
    private final HasPagination pagination;

    public TablePageChangeEvent(int page, HasPagination pagination) {
        this.page = page;
        this.pagination = pagination;
    }

    public int getPage() {
        return page;
    }

    public HasPagination getPagination() {
        return pagination;
    }

    @Override
    public String getType() {
        return PAGINATION_EVENT;
    }
}
