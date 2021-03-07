package org.dominokit.domino.ui.datatable.plugins;

import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.events.TablePageChangeEvent;
import org.dominokit.domino.ui.pagination.AdvancedPagination;
import org.dominokit.domino.ui.pagination.SimplePagination;

/**
 * This plugin attach an {@link SimplePagination} component to the data table and fires {@link TablePageChangeEvent}
 * when ever the page is changed
 *
 * @param <T> the type of the data table records
 */
public class SimplePaginationPlugin<T> implements DataTablePlugin<T> {

    private SimplePagination simplePagination;

    private final int pageSize;

    /**
     * Creates and instance with default page size of 10
     */
    public SimplePaginationPlugin() {
        this(10);
    }

    /**
     * Creates and instance with a custom page size
     * @param pageSize int, Page size
     */
    public SimplePaginationPlugin(int pageSize) {
        this.pageSize = pageSize;
        this.simplePagination = SimplePagination.create(0, pageSize)
                .markActivePage()
                .gotoPage(1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAfterAddTable(DataTable<T> dataTable) {
        dataTable.element()
                .appendChild(simplePagination.element());

        simplePagination.onPageChanged(pageNumber -> dataTable.fireTableEvent(new TablePageChangeEvent(pageNumber, simplePagination)));
    }

    /**
     *
     * @return the {@link SimplePagination} wrapped in this plugin
     */
    public SimplePagination getSimplePagination() {
        return simplePagination;
    }
}
