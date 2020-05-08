package org.dominokit.domino.ui.pagination;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLLIElement;
import org.dominokit.domino.ui.forms.Select;
import org.dominokit.domino.ui.forms.SelectOption;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.utils.DominoElement;

import java.util.function.Function;
import java.util.stream.IntStream;

import static org.jboss.elemento.Elements.a;
import static org.jboss.elemento.Elements.li;

public class AdvancedPagination extends BasePagination<AdvancedPagination> {

    private DominoElement<HTMLLIElement> firstPage;
    private DominoElement<HTMLLIElement> lastPage;

    private DominoElement<HTMLAnchorElement> prevAnchor;
    private DominoElement<HTMLAnchorElement> firstPageAnchor;
    private DominoElement<HTMLAnchorElement> nextAnchor;
    private DominoElement<HTMLAnchorElement> lastPageAnchor;
    private Select<Integer> pagesSelect;

    private Function<Integer, String> pagesCountTextHandler = pagesCount -> " of " + pagesCount + " Pages";

    public static AdvancedPagination create() {
        return new AdvancedPagination();
    }

    public static AdvancedPagination create(int pages) {
        return new AdvancedPagination(pages);
    }

    public static AdvancedPagination create(int pages, int pageSize) {
        return new AdvancedPagination(pages, pageSize);
    }

    public AdvancedPagination() {
        this(0, 10);
    }

    public AdvancedPagination(int pages) {
        this(pages, 10);
    }


    public AdvancedPagination(int pages, int pageSize) {
        this.pagesCount = pages;
        this.pageSize = pageSize;
        init(this);
        updatePages(pages, pageSize);
    }

    public AdvancedPagination updatePages(int pages) {
        return updatePages(pages, pageSize);
    }

    @Override
    public AdvancedPagination updatePages(int pages, int pageSize) {
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

        firstPageAnchor = DominoElement.of(a());
        firstPage = DominoElement.of(li().css("page-nav"))
                .appendChild(firstPageAnchor
                        .setTooltip("First page")
                        .appendChild(Icons.ALL.skip_previous()
                                .clickable())
                        .addClickListener(event -> moveToPage(1, false)));

        pagesElement.clearElement()
                .appendChild(firstPage)
                .appendChild(prevElement);

        pagesSelect = Select.<Integer>create()
                .styler(style -> style.setMarginBottom("0px"))
                .addSelectionHandler(option -> moveToPage(option.getValue(), false));

        if (pages > 0) {
            IntStream.rangeClosed(1, pages).forEach(p -> {
                pagesSelect.appendChild(SelectOption.create(p, p + "")
                        .apply(element -> allPages.add(DominoElement.of(element.element()))));
            });
        }

        pagesElement.appendChild(DominoElement.of(li()).appendChild(a().style("margin-left: 10px; margin-right: 10px;").add(pagesSelect)));
        pagesElement.appendChild(DominoElement.of(li()).appendChild(a().css("adv-page-count").textContent(pagesCountTextHandler.apply(pages))));

        nextAnchor = DominoElement.of(a());
        nextElement = DominoElement.of(li().css("page-nav"))
                .appendChild(nextAnchor
                        .setTooltip("Next page")
                        .appendChild(Icons.ALL.chevron_right()
                                .clickable())
                        .addClickListener(event -> moveToPage(index + 1, false)));


        lastPageAnchor = DominoElement.of(a());
        lastPage = DominoElement.of(li().css("page-nav"))
                .appendChild(lastPageAnchor
                        .setTooltip("Last page")
                        .appendChild(Icons.ALL.skip_next()
                                .clickable())
                        .addClickListener(event -> {
                            moveToPage(allPages.size(), false);
                        }));

        if (pages > 0) {
            moveToPage(1, true);
        }

        if (pages <= 0) {
            nextElement.disable();
            prevElement.disable();
        }

        pagesElement
                .appendChild(nextElement)
                .appendChild(lastPage);
        return this;
    }

    @Override
    protected void moveToPage(int page, boolean silent) {
        if (page > 0 && page <= pagesCount) {

            index = page;

            if (!silent) {
                pageChangedCallBack.onPageChanged(page);
            }

            if (page == pagesCount) {
                nextElement.disable();
                lastPage.disable();
            } else {
                nextElement.enable();
                lastPage.enable();
            }


            if (page == 1) {
                prevElement.disable();
                firstPage.disable();
            } else {
                prevElement.enable();
                firstPage.enable();
            }


            pagesSelect.selectAt(page - 1, true);

        }
    }

    public DominoElement<HTMLAnchorElement> getPrevAnchor() {
        return prevAnchor;
    }

    public DominoElement<HTMLAnchorElement> getFirstPageAnchor() {
        return firstPageAnchor;
    }

    public DominoElement<HTMLAnchorElement> getNextAnchor() {
        return nextAnchor;
    }

    public DominoElement<HTMLAnchorElement> getLastPageAnchor() {
        return lastPageAnchor;
    }

    public void setPagesCountTextHandler(Function<Integer, String> pagesCountTextHandler) {
        this.pagesCountTextHandler = pagesCountTextHandler;
    }
}
