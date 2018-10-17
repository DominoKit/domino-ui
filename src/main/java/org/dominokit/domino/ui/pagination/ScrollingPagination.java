package org.dominokit.domino.ui.pagination;

import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLLIElement;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.utils.DominoElement;

import java.util.stream.IntStream;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.a;
import static org.jboss.gwt.elemento.core.Elements.li;

public class ScrollingPagination extends BasePagination<ScrollingPagination> {

    private DominoElement<HTMLLIElement> prevSet;
    private DominoElement<HTMLLIElement> firstPage;
    private DominoElement<HTMLLIElement> nextSet;
    private DominoElement<HTMLLIElement> lastPage;

    private DominoElement<HTMLLIElement> dotsElement;
    private DominoElement<HTMLLIElement> pagesCountPageElement;
    private DominoElement<HTMLAnchorElement> prevAnchor;
    private DominoElement<HTMLAnchorElement> prevSetAnchor;
    private DominoElement<HTMLAnchorElement> firstPageAnchor;
    private DominoElement<HTMLAnchorElement> dotsAnchor;
    private DominoElement<HTMLAnchorElement> nextAnchor;
    private DominoElement<HTMLAnchorElement> nextSetAnchor;
    private DominoElement<HTMLAnchorElement> lastPageAnchor;

    private int windowSize = 10;
    private int windowIndex = 0;

    public static ScrollingPagination create() {
        return new ScrollingPagination();
    }

    public static ScrollingPagination create(int pages) {
        return new ScrollingPagination(pages);
    }

    public static ScrollingPagination create(int pages, int pageSize) {
        return new ScrollingPagination(pages, pageSize);
    }

    public static ScrollingPagination create(int pages, int pageSize, int windowSize) {
        return new ScrollingPagination(pages, pageSize, windowSize);
    }

    public ScrollingPagination() {
        this(0, 10, 10);
    }

    public ScrollingPagination(int pages) {
        this(pages, 10, 10);
    }

    public ScrollingPagination(int pages, int pageSize) {
        this(pages, pageSize, 10);
    }

    public ScrollingPagination(int pages, int pageSize, int windowSize) {
        this.pagesCount = pages;
        this.pageSize = pageSize;
        this.windowSize = windowSize;
        init(this);
        updatePages(pages, pageSize);
    }

    public ScrollingPagination updatePages(int pages) {
        return updatePages(pages, pageSize);
    }

    @Override
    public ScrollingPagination updatePages(int pages, int pageSize) {
        this.pageSize = pageSize;
        this.pagesCount = pages;
        this.index = 1;
        allPages.clear();

        prevAnchor = DominoElement.of(a());
        prevElement = DominoElement.of(li().css("page-nav"))
                .appendChild(prevAnchor
                        .setTooltip("Previous page")
                        .appendChild(Icons.ALL.chevron_left()
                                .clickable())
                        .addClickListener(event -> moveToPage(index - 1, false)));

        prevSetAnchor = DominoElement.of(a());
        prevSet = DominoElement.of(li().css("page-nav"))
                .appendChild(prevSetAnchor
                        .setTooltip("Previous pages set")
                        .appendChild(Icons.ALL.first_page()
                                .clickable())
                        .addClickListener(event -> moveToPage((windowIndex * windowSize), false)));

        firstPageAnchor = DominoElement.of(a());
        firstPage = DominoElement.of(li().css("page-nav"))
                .appendChild(firstPageAnchor
                        .setTooltip("First page")
                        .appendChild(Icons.ALL.skip_previous()
                                .clickable())
                        .addClickListener(event -> moveToPage(1, false)));

        pagesElement.clearElement()
                .appendChild(firstPage)
                .appendChild(prevSet)
                .appendChild(prevElement);

        if (pages > 0) {
            IntStream.rangeClosed(1, pages).forEach(p -> DominoElement.of(li().css("page"))
                    .apply(element -> {
                        allPages.add(element);
                        pagesElement.appendChild(element
                                .appendChild(DominoElement.of(a())
                                        .setTextContent(p + "")
                                        .addClickListener(evt -> moveToPage(p, false)))
                                .toggleDisplay(p <= windowSize)
                        );
                    }));
        }

        if (pages > windowSize) {
            dotsAnchor = DominoElement.of(a());
            dotsElement = DominoElement.of(li().css("page"))
                    .appendChild(dotsAnchor
                            .setTooltip("Next pages set")
                            .setTextContent("...")
                            .addClickListener(evt -> moveToPage((windowIndex * windowSize) + windowSize + 1, false)));
            pagesElement.appendChild(dotsElement
            );
            pagesCountPageElement = DominoElement.of(li().css("page"))
                    .appendChild(DominoElement.of(a())
                            .setTextContent("" + pages)
                            .addClickListener(evt -> moveToPage(pages, false)));
            pagesElement.appendChild(pagesCountPageElement
            );
        }

        nextAnchor = DominoElement.of(a());
        nextElement = DominoElement.of(li().css("page-nav"))
                .appendChild(nextAnchor
                        .setTooltip("Next page")
                        .appendChild(Icons.ALL.chevron_right()
                                .clickable())
                        .addClickListener(event -> moveToPage(index + 1, false)));

        nextSetAnchor = DominoElement.of(a());
        nextSet = DominoElement.of(li().css("page-nav"))
                .appendChild(nextSetAnchor
                        .setTooltip("Next pages set")
                        .appendChild(Icons.ALL.last_page()
                                .clickable())
                        .addClickListener(event -> moveToPage((windowIndex * windowSize) + windowSize + 1, false)));

        lastPageAnchor = DominoElement.of(a());
        lastPage = DominoElement.of(li().css("page-nav"))
                .appendChild(lastPageAnchor
                        .setTooltip("Last page")
                        .appendChild(Icons.ALL.skip_next()
                                .clickable())
                        .addClickListener(event -> moveToPage(allPages.size(), false)));

        if (pages > 0) {
            moveToPage(1, true);
        }

        if (pages <= 0) {
            nextElement.disable();
            prevElement.disable();
        }

        pagesElement
                .appendChild(nextElement)
                .appendChild(nextSet)
                .appendChild(lastPage);

        return this;
    }

    @Override
    void moveToPage(int page, boolean silent) {
        if (page > 0 && page <= pagesCount) {

            index = page;
            if (markActivePage) {
                gotoPage(allPages.get(page - 1));
            }

            if (!silent) {
                pageChangedCallBack.onPageChanged(page);
            }

            if (page == pagesCount) {
                nextElement.disable();
                nextSet.disable();
                lastPage.disable();
            } else {
                nextElement.enable();
                nextSet.enable();
                lastPage.enable();
            }


            if (page == 1) {
                prevElement.disable();
                prevSet.disable();
                firstPage.disable();
            } else {
                prevElement.enable();
                prevSet.enable();
                firstPage.enable();
            }

            showPageWindow(page);

        }
    }

    private void showPageWindow(int page) {
        if (page % windowSize == 0) {
            showWindow((page / windowSize) - 1);
        } else {
            showWindow(page / windowSize);
        }

        if (windowIndex == 0) {
            prevSet.disable();
        } else {
            prevSet.enable();
        }

        int windowCount = (allPages.size() / windowSize) + (allPages.size() % windowSize > 0 ? 1 : 0);
        if (windowIndex >= windowCount - 1) {
            nextSet.disable();
            if(nonNull(dotsElement) && nonNull(pagesCountPageElement)){
                dotsElement.collapse();
                pagesCountPageElement.collapse();
            }

        } else {
            nextSet.enable();
            if(nonNull(dotsElement) && nonNull(pagesCountPageElement)){
                dotsElement.expand();
                pagesCountPageElement.expand();
            }
        }

    }

    private void showWindow(int index) {

        if (index != this.windowIndex) {
            int windowMinLimit = windowIndex * windowSize;
            int windowMaxLimit = windowMinLimit + windowSize;

            for (int i = windowMinLimit; i < windowMaxLimit; i++) {
                allPages.get(i).collapse();
            }

            int targetWindowMinLimit = index * windowSize;
            int targetWindowMaxLimit = targetWindowMinLimit + windowSize;

            for (int i = targetWindowMinLimit; i < targetWindowMaxLimit; i++) {
                allPages.get(i).expand();
            }

            this.windowIndex = index;
        }
    }

    public DominoElement<HTMLAnchorElement> getPrevAnchor() {
        return prevAnchor;
    }

    public DominoElement<HTMLAnchorElement> getPrevSetAnchor() {
        return prevSetAnchor;
    }

    public DominoElement<HTMLAnchorElement> getFirstPageAnchor() {
        return firstPageAnchor;
    }

    public DominoElement<HTMLAnchorElement> getDotsAnchor() {
        return dotsAnchor;
    }

    public DominoElement<HTMLAnchorElement> getNextAnchor() {
        return nextAnchor;
    }

    public DominoElement<HTMLAnchorElement> getNextSetAnchor() {
        return nextSetAnchor;
    }

    public DominoElement<HTMLAnchorElement> getLastPageAnchor() {
        return lastPageAnchor;
    }
}
