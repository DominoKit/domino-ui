package org.dominokit.domino.ui.pagination;

import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.HTMLUListElement;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Waves;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.gwt.elemento.core.EventType;
import org.jboss.gwt.elemento.core.builder.HtmlContentBuilder;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

import static org.jboss.gwt.elemento.core.Elements.*;

public class CustomPagination extends BaseDominoElement<HTMLElement, CustomPagination> implements HasPagination {

    private static final String HIDDEN = "hidden";
    private static final String CONTROL = "control";
    private static final String WAVES_EFFECT = "waves-effect";

    private DominoElement<HTMLUListElement> pagesElement = DominoElement.of(ul().css("custom-pagination"));
    private DominoElement<HTMLElement> element = DominoElement.of(nav().add(pagesElement));
    private DominoElement<HTMLLIElement> activePage = DominoElement.of(li());
    private DominoElement<HTMLLIElement> prevElement;
    private DominoElement<HTMLLIElement> nextElement;
    private DominoElement<HTMLLIElement> firstElement;
    private DominoElement<HTMLLIElement> lastElement;

    private List<DominoElement<HTMLLIElement>> allPages = new LinkedList<>();
    private List<DominoElement<HTMLLIElement>> visiblePages = new LinkedList<>();    
    private PageChangedCallBack pageChangedCallBack = pageIndex -> {
    };
    private String size = "custom-pagination-default";

    private int index = 1;
    private boolean markActivePage = true;
    private int pagesCount;
    private int pageSize = 10;
    private int pagesVisible = 10;

    public static CustomPagination create() {
        return new CustomPagination();
    }

    public static CustomPagination create(int pages) {
        return new CustomPagination(pages);
    }

    public static CustomPagination create(int pages, int pageSize) {
        return new CustomPagination(pages, pageSize);
    }

    public static CustomPagination create(int pages, int pageSize, int pagesVisible) {
      return new CustomPagination(pages, pageSize, pagesVisible);
    }

    public CustomPagination() {
        this(10);
    }

    public CustomPagination(int pages) {
        this(pages, 10);
    }

    public CustomPagination(int pages, int pageSize) {
        this(pages, pageSize, 10);
    }

    public CustomPagination(int pages, int pageSize, int pagesVisible) {
        this.pagesCount = pages;
        this.pageSize = pageSize;
        this.pagesVisible = pagesVisible;
        updatePages(pages, pageSize);
        init(this);
    }

    public CustomPagination updatePages(int pages) {
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

    public CustomPagination updatePages(int pages, int pageSize) {
        this.pageSize = pageSize;
        this.pagesCount = pages;
        this.index = 1;
        allPages.clear();
        visiblePages.clear();
        pagesElement.clearElement();
        firstElement = DominoElement.of(li().add(a().css(WAVES_EFFECT).css(CONTROL).add(Icons.ALL.first_page())
            .on(EventType.click, event -> gotoFirst())));
        if(pages > pagesVisible) {
            // just add it if it is needed
            pagesElement.appendChild(firstElement);
        }
        prevElement = DominoElement.of(li().add(a().css(WAVES_EFFECT).css(CONTROL).add(Icons.ALL.chevron_left())
                .on(EventType.click, event -> moveToPage(index - 1, false))));
        pagesElement.appendChild(prevElement);
        if (pages > 0) {
            IntStream.rangeClosed(1, pages).forEach(p -> {
                HtmlContentBuilder<HTMLAnchorElement> anchor = a().css(WAVES_EFFECT).textContent(p + "").on(EventType.click, event -> moveToPage(p, false));
                Waves.create(anchor.asElement());
                DominoElement<HTMLLIElement> li = DominoElement.of(li());
                allPages.add(li);
                if(p <= pagesVisible) {
                    visiblePages.add(li);
                } else {
                  li.addCss(HIDDEN);
                }
                pagesElement.appendChild(li.appendChild(anchor));
            }); 
        }

        nextElement = DominoElement.of(li().add(a().css(WAVES_EFFECT).css(CONTROL).add(Icons.ALL.chevron_right())
                .on(EventType.click, event -> moveToPage(index + 1, false))));
        lastElement = DominoElement.of(li().add(a().css(WAVES_EFFECT).css(CONTROL).add(Icons.ALL.last_page())
            .on(EventType.click, event -> gotoLast())));

        if (pages > 0) {
            moveToPage(1, true);
        }

        if (pages <= 0) {
            nextElement.style().add("disabled");
            prevElement.style().add("disabled");
        }

        pagesElement.appendChild(nextElement);
        if(pages > pagesVisible) {
            pagesElement.appendChild(lastElement);
        }

        return this;
    }

    private void gotoPage(DominoElement<HTMLLIElement> li) {
        activePage.style().remove("active");
        activePage = li;
        activePage.style().add("active");
    }

    @Override
    public CustomPagination gotoPage(int page) {
        return gotoPage(page, false);
    }

    @Override
    public CustomPagination gotoPage(int page, boolean silent) {
        if (page > 0 && page <= pagesCount) {
            moveToPage(page, silent);
        }
        return this;
    }

    @Override
    public CustomPagination nextPage() {
        return nextPage(false);
    }

    @Override
    public CustomPagination previousPage() {
        return previousPage(false);
    }

    @Override
    public CustomPagination nextPage(boolean silent) {
        moveToPage(index + 1, silent);
        return this;
    }

    @Override
    public CustomPagination previousPage(boolean silent) {
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

            boolean goingForward = page > index;
            boolean simpleStep = Math.abs(page - index) == 1;

            // sets the index to the new page
            index = page;
            
            DominoElement<HTMLLIElement> li = allPages.get(page - 1);
            if(!visiblePages.contains(li)) {
                // if next page is not visible

                if(goingForward) {
                    // verify if simple step (next) or not (last)
                    if(simpleStep) {
                        // if simple step, get the first page and hide it
                        visiblePages.get(0).addCss(HIDDEN);
                    } else {
                        // get the visible pages and hide them
                        visiblePages.forEach(i -> i.style().add(HIDDEN));
                    }
                    // get the new visible pages list
                    visiblePages = new LinkedList<>(allPages.subList(page - pagesVisible, page));

                } else {
                    // verify if simple step (previous) or not (first)
                    if(simpleStep) {
                        // if simple step, get the last visible page and hide it
                        visiblePages.get(pagesVisible-1).addCss(HIDDEN);
                    } else {
                      visiblePages.forEach(i -> i.style().add(HIDDEN));
                    }
                    // get the new visible page list
                    visiblePages = new LinkedList<>(allPages.subList(page -1, page - 1 + pagesVisible));
                }

                // set all visible pages are visible
                visiblePages.forEach(i -> i.style().remove(HIDDEN));
            }

            if (markActivePage) {
                gotoPage(li);
            }

            if (!silent) {
                pageChangedCallBack.onPageChanged(page);
            }

            if (page == pagesCount) {
              nextElement.style().add("disabled");
              lastElement.style().add("disabled");
            } else {
              nextElement.style().remove("disabled");
              lastElement.style().remove("disabled");
            }

            if (page == 1) {
              firstElement.style().add("disabled");
              prevElement.style().add("disabled");
            } else {
              firstElement.style().remove("disabled");
              prevElement.style().remove("disabled");
            }
        }
    }

    @Override
    public CustomPagination markActivePage() {
        this.markActivePage = true;
        gotoPage(activePage);
        return this;
    }

    @Override
    public CustomPagination onPageChanged(PageChangedCallBack pageChangedCallBack) {
        this.pageChangedCallBack = pageChangedCallBack;
        return this;
    }

    public CustomPagination large() {
        return setSize("custom-pagination-lg");
    }

    public CustomPagination small() {
        return setSize("custom-pagination-sm");
    }

    private CustomPagination setSize(String sizeStyle) {
        pagesElement.style().remove(size);
        pagesElement.style().add(sizeStyle);
        size = sizeStyle;
        return this;
    }
    
    public int getPagesVisible() {
      return pagesVisible;
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
        return element.asElement();
    }
}
