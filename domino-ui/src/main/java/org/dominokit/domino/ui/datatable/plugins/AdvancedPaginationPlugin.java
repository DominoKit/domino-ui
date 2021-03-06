package org.dominokit.domino.ui.datatable.plugins;

import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.events.TablePageChangeEvent;
import org.dominokit.domino.ui.pagination.AdvancedPagination;

/**
 * This plugin attach an {@link AdvancedPagination} component to the data table and fires {@link TablePageChangeEvent}
 * when ever the page is changed
 *
 * @param <T> the type of the data table records
 */
public class AdvancedPaginationPlugin<T> implements DataTablePlugin<T> {

    private AdvancedPagination pagination;

    /**
     * Creates and instance with default page size of 10
     */
    public AdvancedPaginationPlugin() {
        this(10);
    }

    /**
     * Creates and instance with a custom page size
     * @param pageSize int, Page size
     */
    public AdvancedPaginationPlugin(int pageSize) {
        this.pagination = AdvancedPagination.create(0, pageSize);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAfterAddTable(DataTable<T> dataTable) {
        dataTable.element().appendChild(pagination.element());
        pagination.onPageChanged(pageNumber -> dataTable.fireTableEvent(new TablePageChangeEvent(pageNumber, pagination)));
    }

    /**
     *
     * @return the {@link AdvancedPagination} wrapped in this plugin
     */
    public AdvancedPagination getPagination() {
        return pagination;
    }
}
