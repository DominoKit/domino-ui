package org.dominokit.domino.ui.datatable.plugins;

import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.events.TablePageChangeEvent;
import org.dominokit.domino.ui.pagination.ScrollingPagination;

/**
 * Scrolling Pagination Plugin.
 *
 * @param <T>
 */
public class ScrollingPaginationPlugin<T> implements DataTablePlugin<T> {

    private ScrollingPagination pagination;

    public ScrollingPaginationPlugin() {
        this(10);
    }
    
    public ScrollingPaginationPlugin(int pageSize) {
        this(pageSize, 10);
    }
    
    public ScrollingPaginationPlugin(int pageSize, int windowSize) {
      this.pagination = ScrollingPagination.create(0, pageSize, windowSize);
    }
    
    @Override
    public void onAfterAddTable(DataTable<T> dataTable) {
        dataTable.element().appendChild(pagination.element());
        pagination.onPageChanged(pageNumber -> dataTable.fireTableEvent(new TablePageChangeEvent(pageNumber, pagination)));
    }

    public ScrollingPagination getPagination() {
        return pagination;
    }
}
