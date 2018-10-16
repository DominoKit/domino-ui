package org.dominokit.domino.ui.datatable.plugins;

import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.events.TablePageChangeEvent;
import org.dominokit.domino.ui.pagination.CustomPagination;

public class CustomPaginationPlugin<T> implements DataTablePlugin<T> {

    private CustomPagination customPagination;

    public CustomPaginationPlugin() {
        this(10, 10);
    }

    public CustomPaginationPlugin(int pageSize, int pagesVisible) {
        this.customPagination = CustomPagination.create(0, pageSize, pagesVisible)
                .markActivePage()
                .gotoPage(1);
    }

    @Override
    public void onAfterAddTable(DataTable<T> dataTable) {
        dataTable.asElement()
                .appendChild(customPagination.asElement());

        customPagination.onPageChanged(pageNumber -> dataTable.fireTableEvent(new TablePageChangeEvent(pageNumber, customPagination)));
    }

    public CustomPagination getPagination() {
        return customPagination;
    }
}
