package org.dominokit.domino.ui.datatable.plugins;

import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.events.TablePageChangeEvent;
import org.dominokit.domino.ui.pagination.AdvancedPagination;

/**
 * Advanced Pagination Plugin.
 *
 * @param <T>
 */
public class AdvancedPaginationPlugin<T> implements DataTablePlugin<T> {

    private AdvancedPagination pagination;
    
    public AdvancedPaginationPlugin() {
        this(10);
    }

    public AdvancedPaginationPlugin(int pageSize) {
        this.pagination = AdvancedPagination.create(0, pageSize);
    }
    
    @Override
    public void onAfterAddTable(DataTable<T> dataTable) {
        dataTable.element().appendChild(pagination.element());
        pagination.onPageChanged(pageNumber -> dataTable.fireTableEvent(new TablePageChangeEvent(pageNumber, pagination)));
    }

    public AdvancedPagination getPagination() {
        return pagination;
    }
}
