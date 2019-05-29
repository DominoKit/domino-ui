package org.dominokit.domino.ui.pagination;

public interface HasPagination{
    HasPagination gotoPage(int page);
    HasPagination gotoPage(int page, boolean silent);

    HasPagination nextPage();
    HasPagination previousPage();

    HasPagination nextPage(boolean silent);
    HasPagination previousPage(boolean silent);

    HasPagination gotoFirst();
    HasPagination gotoLast();

    HasPagination gotoFirst(boolean silent);
    HasPagination gotoLast(boolean silent);

    HasPagination markActivePage();
    HasPagination updatePages(int pages);
    HasPagination updatePages(int pages, int pageSize);
    HasPagination updatePagesByTotalCount(int totalCount);
    HasPagination updatePagesByTotalCount(int totalCount, int pageSize);

    HasPagination setPageSize(int pageSize);
    int getPageSize();
    int activePage();
    int getPagesCount();

    HasPagination onPageChanged(PageChangedCallBack pageChangedCallBack);

    @FunctionalInterface
    interface PageChangedCallBack {
        void onPageChanged(int pageNumber);
    }
}
