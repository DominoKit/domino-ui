package org.dominokit.domino.ui.pagination;

import elemental2.dom.HTMLAnchorElement;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.utils.DominoElement;

import java.util.stream.IntStream;

import static org.jboss.gwt.elemento.core.Elements.a;
import static org.jboss.gwt.elemento.core.Elements.li;

public class SimplePagination extends BasePagination<SimplePagination> {

    private DominoElement<HTMLAnchorElement> prevAnchor;
    private DominoElement<HTMLAnchorElement> nextAnchor;

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
        init(this);
        updatePages(pages, pageSize);
    }

    public SimplePagination updatePages(int pages) {
        return updatePages(pages, pageSize);
    }

    public SimplePagination updatePages(int pages, int pageSize) {
        this.pageSize = pageSize;
        this.pagesCount = pages;
        this.index = 1;
        allPages.clear();
        pagesElement.clearElement();
        prevAnchor = DominoElement.of(a());
        prevElement = DominoElement.of(li().css("page-nav"))
                .appendChild(prevAnchor
                        .setTooltip("Previous page")
                        .appendChild(Icons.ALL.chevron_left()
                                .clickable())
                        .addClickListener(event -> moveToPage(index - 1, false)));

        pagesElement.appendChild(prevElement);
        if (pages > 0) {
            IntStream.rangeClosed(1, pages).forEach(p -> DominoElement.of(li().css("page"))
                    .apply(element -> {
                        allPages.add(element);
                        pagesElement.appendChild(element
                                .appendChild(DominoElement.of(a())
                                        .setTextContent(p + "")
                                        .addClickListener(evt -> moveToPage(p, false)))
                        );
                    }));

        }

        nextAnchor = DominoElement.of(a());
        nextElement = DominoElement.of(li().css("page-nav"))
                .appendChild(nextAnchor
                        .setTooltip("Next page")
                        .appendChild(Icons.ALL.chevron_right()
                                .clickable())
                        .addClickListener(event -> moveToPage(index + 1, false)));

        if (pages > 0) {
            moveToPage(1, true);
        }

        if (pages <= 0) {
            nextElement.disable();
            prevElement.disable();
        }

        pagesElement.appendChild(nextElement);

        return this;
    }


    @Override
    protected void moveToPage(int page, boolean silent) {
        if (page > 0 && page <= pagesCount) {
            index = page;
            if (markActivePage) {
                gotoPage(allPages.get(page - 1));
            }

            if (!silent) {
                pageChangedCallBack.onPageChanged(page);
            }

            if (page == pagesCount)
                nextElement.disable();
            else
                nextElement.enable();

            if (page == 1)
                prevElement.disable();
            else
                prevElement.enable();
        }
    }

    public DominoElement<HTMLAnchorElement> getPrevAnchor() {
        return prevAnchor;
    }

    public DominoElement<HTMLAnchorElement> getNextAnchor() {
        return nextAnchor;
    }
}
