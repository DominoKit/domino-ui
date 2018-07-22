package org.dominokit.domino.ui.pagination;

import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.HTMLUListElement;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Waves;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.jboss.gwt.elemento.core.EventType;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.core.builder.HtmlContentBuilder;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

import static org.jboss.gwt.elemento.core.Elements.*;

public class SimplePagination implements IsElement<HTMLElement>, HasPagination {

    private static final String WAVES_EFFECT = "waves-effect";

    private HTMLUListElement pagesElement = ul().css("pagination").asElement();
    private HTMLElement element = nav().add(pagesElement).asElement();
    private HTMLLIElement activePage = li().asElement();
    private HTMLLIElement prevElement;
    private HTMLLIElement nextElement;

    private List<HTMLLIElement> allPages = new LinkedList<>();
    private PageChangedCallBack pageChangedCallBack = pageIndex -> {
    };
    private String size = "pagination-default";

    private int index = 1;
    private boolean markActivePage = true;
    private int pagesCount;
    private int pageSize = 10;

    public static SimplePagination create() {
        return new SimplePagination();
    }

    public static SimplePagination create(int pages) {
        return new SimplePagination(pages);
    }

    public static SimplePagination create(int pages, int pageSize) {
        return new SimplePagination(pages, pageSize);
    }

    public SimplePagination() {
        this(0);
    }

    public SimplePagination(int pages) {
        this(pages, 10);
    }

    public SimplePagination(int pages, int pageSize) {
        this.pagesCount = pages;
        this.pageSize = pageSize;
        updatePages(pages, pageSize);
    }

    public SimplePagination updatePages(int pages) {
        return updatePages(pages, pageSize);
    }

    @Override
    public HasPagination updatePagesByTotalCount(int totalCount) {
        int pages = (totalCount / this.pageSize) + (totalCount % this.pageSize > 0 ? 1 : 0);
        return updatePages(pages, this.pageSize);
    }

    @Override
    public HasPagination updatePagesByTotalCount(int totalCount, int pageSize) {
        int pages = (totalCount / pageSize) + (totalCount % pageSize > 0 ? 1 : 0);
        return updatePages(pages, pageSize);
    }

    public SimplePagination updatePages(int pages, int pageSize) {
        this.pageSize = pageSize;
        this.pagesCount = pages;
        this.index = 1;
        allPages.clear();
        ElementUtil.clear(pagesElement);
        prevElement = li().add(a().css(WAVES_EFFECT).add(Icons.ALL.chevron_left().asElement())
                .on(EventType.click, event -> moveToPage(index - 1, false)).asElement()).asElement();
        pagesElement.appendChild(prevElement);
        if (pages > 0) {
            IntStream.rangeClosed(1, pages).forEach(p -> {
                HtmlContentBuilder<HTMLLIElement> li = li();
                HtmlContentBuilder<HTMLAnchorElement> anchor = a().css(WAVES_EFFECT).textContent(p + "").on(EventType.click, event -> moveToPage(p, false));
                Waves.create(anchor.asElement());
                allPages.add(li.asElement());
                pagesElement.appendChild(li.add(anchor).asElement());
            });

        }

        nextElement = li().add(a().css(WAVES_EFFECT).add(Icons.ALL.chevron_right().asElement())
                .on(EventType.click, event -> moveToPage(index + 1, false)).asElement()).asElement();

        if (pages > 0) {
            moveToPage(1, true);
        }

        if (pages <= 0) {
            nextElement.classList.add("disabled");
            prevElement.classList.add("disabled");
        }

        pagesElement.appendChild(nextElement);

        return this;
    }

    private void gotoPage(HTMLLIElement li) {
        activePage.classList.remove("active");
        activePage = li;
        activePage.classList.add("active");
    }

    @Override
    public SimplePagination gotoPage(int page) {
        return gotoPage(page, false);
    }

    @Override
    public SimplePagination gotoPage(int page, boolean silent) {
        if (page > 0 && page <= pagesCount) {
            moveToPage(page, silent);
        }
        return this;
    }

    @Override
    public SimplePagination nextPage() {
        return nextPage(false);
    }

    @Override
    public SimplePagination previousPage() {
        return previousPage(false);
    }

    @Override
    public SimplePagination nextPage(boolean silent) {
        moveToPage(index + 1, silent);
        return this;
    }

    @Override
    public SimplePagination previousPage(boolean silent) {
        moveToPage(index - 1, silent);
        return this;
    }

    @Override
    public HasPagination gotoFirst() {
        return gotoFirst(false);
    }

    @Override
    public HasPagination gotoLast() {
        return gotoLast(false);
    }

    @Override
    public HasPagination gotoFirst(boolean silent) {
        if (this.pagesCount > 0) {
            return gotoPage(1, silent);
        }
        return this;
    }

    @Override
    public HasPagination gotoLast(boolean silent) {
        if (this.pagesCount > 0) {
            return gotoPage(pagesCount, silent);
        }
        return this;
    }

    private void moveToPage(int page, boolean silent) {
        if (page > 0 && page <= pagesCount) {
            index = page;
            if (markActivePage) {
                gotoPage(allPages.get(page - 1));
            }

            if (!silent) {
                pageChangedCallBack.onPageChanged(page);
            }

            if (page == pagesCount)
                nextElement.classList.add("disabled");
            else
                nextElement.classList.remove("disabled");

            if (page == 1)
                prevElement.classList.add("disabled");
            else
                prevElement.classList.remove("disabled");
        }
    }

    @Override
    public SimplePagination markActivePage() {
        this.markActivePage = true;
        gotoPage(activePage);
        return this;
    }

    @Override
    public SimplePagination onPageChanged(PageChangedCallBack pageChangedCallBack) {
        this.pageChangedCallBack = pageChangedCallBack;
        return this;
    }

    public SimplePagination large() {
        return setSize("pagination-lg");
    }

    public SimplePagination small() {
        return setSize("pagination-sm");
    }

    private SimplePagination setSize(String sizeStyle) {
        pagesElement.classList.remove(size);
        pagesElement.classList.add(sizeStyle);
        size = sizeStyle;
        return this;
    }

    @Override
    public HasPagination setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
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

    @Override
    public HTMLElement asElement() {
        return element;
    }
}
