package org.dominokit.domino.ui.datatable.events;

import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.plugins.DataTablePlugin;
import org.dominokit.domino.ui.pagination.SimplePagination;

public class SimplePaginationPlugin<T> implements DataTablePlugin<T> {

    private SimplePagination simplePagination;

    private final int pageSize;

    public SimplePaginationPlugin() {
        this(10);
    }

    public SimplePaginationPlugin(int pageSize) {
        this.pageSize = pageSize;
        this.simplePagination = SimplePagination.create(0, pageSize)
                .markActivePage()
                .gotoPage(1);
    }

    @Override
    public void onAfterAddTable(DataTable<T> dataTable) {
        dataTable.asElement()
                .appendChild(simplePagination.asElement());

        simplePagination.onPageChanged(pageNumber -> dataTable.fireTableEvent(new TablePageChangeEvent(pageNumber, simplePagination)));
    }

    public SimplePagination getSimplePagination() {
        return simplePagination;
    }
}
