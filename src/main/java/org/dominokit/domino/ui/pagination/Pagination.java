package org.dominokit.domino.ui.pagination;

import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Waves;
import org.dominokit.domino.ui.utils.ElementUtil;
import elemental2.dom.*;
import org.jboss.gwt.elemento.core.EventType;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.core.builder.HtmlContentBuilder;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

import static org.jboss.gwt.elemento.core.Elements.*;

public class Pagination implements IsElement<HTMLElement> {

    private static final String WAVES_EFFECT = "waves-effect";

    private HTMLUListElement pagesElement = ul().css("pagination").asElement();
    private HTMLElement element = nav().add(pagesElement).asElement();
    private HTMLLIElement activePage = li().asElement();
    private HTMLLIElement prevElement;
    private HTMLLIElement nextElement;

    private List<HTMLLIElement> allPages = new LinkedList<>();
    private PageChangedCallBack pageChangedCallBack = pageIndex -> {};
    private String size="pagination-default";

    private int index = 1;
    private boolean markActivePage = false;
    private int pagesCount;

    public static Pagination create(int pages) {
        return new Pagination(pages);
    }

    public Pagination(int pages) {
        this.pagesCount = pages;
        updatePages(pages);
        Waves.init();
    }

    private void updatePages(int pages) {
        ElementUtil.clear(pagesElement);
        prevElement=li().add(a().css(WAVES_EFFECT).add(Icons.ALL.chevron_left().asElement())
                .on(EventType.click, event -> moveToPage(index-1)).asElement()).asElement();
        pagesElement.appendChild(prevElement);

        IntStream.rangeClosed(1, pages).forEach(p -> {
            HtmlContentBuilder<HTMLLIElement> li = li();
            HtmlContentBuilder<HTMLAnchorElement> anchor = a().css(WAVES_EFFECT).textContent(p + "").on(EventType.click, event -> {
                pageChangedCallBack.onPageChanged(p);
                moveToPage(p);
            });
            allPages.add(li.asElement());
            pagesElement.appendChild(li.add(anchor).asElement());
        });

        nextElement = li().add(a().css(WAVES_EFFECT).add(Icons.ALL.chevron_right().asElement())
                .on(EventType.click, event -> moveToPage(index+1)).asElement()).asElement();

        pagesElement.appendChild(nextElement);
    }

    private void setActivePage(HTMLLIElement li) {
        activePage.classList.remove("active");
        activePage = li;
        activePage.classList.add("active");
    }

    public Pagination setActivePage(int page) {
        if (page > 0 && page <= pagesCount) {
            moveToPage(page);
        }
        return this;
    }

    public Pagination nextPage(){
        moveToPage(index+1);
        return this;
    }

    public Pagination previousPage(){
        moveToPage(index-1);
        return this;
    }

    private void moveToPage(int page) {
        if (page > 0 && page <= pagesCount) {
            index = page;
            if (markActivePage) {
                setActivePage(allPages.get(page-1));
            }
            pageChangedCallBack.onPageChanged(page);

            if(page==pagesCount)
                nextElement.classList.add("disabled");
            else
                nextElement.classList.remove("disabled");

            if(page==1)
                prevElement.classList.add("disabled");
            else
                prevElement.classList.remove("disabled");
        }
    }

    public Pagination markActivePage() {
        this.markActivePage = true;
        return this;
    }

    public Pagination onPageChanged(PageChangedCallBack pageChangedCallBack) {
        this.pageChangedCallBack = pageChangedCallBack;
        return this;
    }

    public Pagination large(){
        return setSize("pagination-lg");
    }

    public Pagination small(){
        return setSize("pagination-sm");
    }

    private Pagination setSize(String sizeStyle) {
        pagesElement.classList.remove(size);
        pagesElement.classList.add(sizeStyle);
        size=sizeStyle;
        return this;
    }

    @Override
    public HTMLElement asElement() {
        return element;
    }

    @FunctionalInterface
    public interface PageChangedCallBack {
        void onPageChanged(int pageNumber);
    }
}
