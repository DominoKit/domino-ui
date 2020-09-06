package org.dominokit.domino.ui.pagination;

import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLUListElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

import java.util.LinkedList;
import java.util.List;

import static org.jboss.elemento.Elements.*;

public abstract class BasePagination<T extends BasePagination<T>> extends BaseDominoElement<HTMLElement, T> implements HasPagination {

    protected DominoElement<HTMLUListElement> pagesElement = DominoElement.of(ul().css("pagination"));
    protected DominoElement<HTMLElement> element = DominoElement.of(nav().add(pagesElement));
    protected DominoElement<? extends HTMLElement> activePage = DominoElement.of(li());
    protected DominoElement<? extends HTMLElement> prevElement;
    protected DominoElement<? extends HTMLElement> nextElement;

    protected List<DominoElement<? extends HTMLElement>> allPages = new LinkedList<>();
    protected PageChangedCallBack pageChangedCallBack = pageIndex -> {
    };
    protected String size = "pagination-default";

    protected int index = 1;
    protected boolean markActivePage = true;
    protected int pagesCount;
    protected int pageSize = 10;
    protected int totalCount = 0;

    @Override
    public HasPagination updatePagesByTotalCount(int totalCount) {
        int pages = (totalCount / this.pageSize) + (totalCount % this.pageSize > 0 ? 1 : 0);
        this.totalCount = totalCount;
        return updatePages(pages, this.pageSize);
    }

    @Override
    public HasPagination updatePagesByTotalCount(int totalCount, int pageSize) {
        int pages = (totalCount / pageSize) + (totalCount % pageSize > 0 ? 1 : 0);
        this.totalCount = totalCount;
        return updatePages(pages, pageSize);
    }

    @Override
    public T gotoPage(int page) {
        return gotoPage(page, false);
    }

    @Override
    public T gotoPage(int page, boolean silent) {
        if (page > 0 && page <= pagesCount) {
            moveToPage(page, silent);
        }
        return (T) this;
    }

    @Override
    public T nextPage() {
        return nextPage(false);
    }

    @Override
    public T previousPage() {
        return previousPage(false);
    }

    @Override
    public T nextPage(boolean silent) {
        moveToPage(index + 1, silent);
        return (T) this;
    }

    @Override
    public T previousPage(boolean silent) {
        moveToPage(index - 1, silent);
        return (T) this;
    }

    @Override
    public T gotoFirst() {
        return gotoFirst(false);
    }

    @Override
    public T gotoLast() {
        return gotoLast(false);
    }

    @Override
    public T gotoFirst(boolean silent) {
        if (this.pagesCount > 0) {
            return gotoPage(1, silent);
        }
        return (T) this;
    }

    @Override
    public T gotoLast(boolean silent) {
        if (this.pagesCount > 0) {
            return gotoPage(pagesCount, silent);
        }
        return (T) this;
    }

    @Override
    public T markActivePage() {
        this.markActivePage = true;
        gotoPage(activePage);
        return (T) this;
    }

    public T setMarkActivePage(boolean markActivePage) {
        this.markActivePage = markActivePage;
        if (!markActivePage) {
            activePage.style().remove("active");
        }

        return (T) this;
    }

    void gotoPage(DominoElement<? extends HTMLElement> li) {
        activePage.style().remove("active");
        activePage = li;
        if (markActivePage) {
            activePage.style().add("active");
        }
    }


    @Override
    public T onPageChanged(PageChangedCallBack pageChangedCallBack) {
        this.pageChangedCallBack = pageChangedCallBack;
        return (T) this;
    }

    public T large() {
        return setSize("pagination-lg");
    }

    public T small() {
        return setSize("pagination-sm");
    }

    private T setSize(String sizeStyle) {
        pagesElement.style().remove(size);
        pagesElement.style().add(sizeStyle);
        size = sizeStyle;
        return (T) this;
    }

    @Override
    public T setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return (T) this;
    }

    @Override
    public int getPageSize() {
        return this.pageSize;
    }

    @Override
    public int activePage() {
        return index;
    }

    @Override
    public int getPagesCount() {
        return pagesCount;
    }

    protected abstract void moveToPage(int page, boolean silent);

    @Override
    public HTMLElement element() {
        return element.element();
    }

}
