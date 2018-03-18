package com.progressoft.brix.domino.ui.pagination;

import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.HTMLUListElement;
import org.jboss.gwt.elemento.core.EventType;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.core.builder.HtmlContentBuilder;

import static org.jboss.gwt.elemento.core.Elements.*;

public class Pager implements IsElement<HTMLElement> {

    private HTMLUListElement pagerElement = ul().css("pager").asElement();
    private HTMLElement element = nav().add(pagerElement).asElement();

    private HTMLLIElement nextElement;
    private HTMLLIElement prevElement;

    private HTMLAnchorElement nextAnchor;
    private HTMLAnchorElement prevAnchor;

    private PagerChangeCallback onNext = () -> {
    };
    private PagerChangeCallback onPrev = () -> {
    };

    private boolean allowNext = true;
    private boolean allowPrev = true;

    public Pager() {
        HtmlContentBuilder<HTMLAnchorElement> nextAnchor = a();
        this.nextAnchor = nextAnchor.asElement();
        nextElement = li().add(nextAnchor.css("wave-effect")
                .on(EventType.click, event -> {
                    if (allowNext)
                        onNext.onChange();
                })
                .textContent("Next")
                .asElement()).asElement();

        HtmlContentBuilder<HTMLAnchorElement> prevAnchor = a();
        this.prevAnchor = prevAnchor.asElement();
        prevElement = li().add(prevAnchor.css("wave-effect")
                .on(EventType.click, event -> {
                    if (allowPrev)
                        onPrev.onChange();
                })
                .textContent("Previous")
                .asElement()).asElement();
        pagerElement.appendChild(prevElement);
        pagerElement.appendChild(nextElement);
    }

    public static Pager create() {
        return new Pager();
    }

    public Pager onNext(PagerChangeCallback nextCallback) {
        this.onNext = nextCallback;
        return this;
    }

    public Pager onPrevious(PagerChangeCallback previousCallback) {
        this.onPrev = previousCallback;
        return this;
    }

    public Pager disableNext() {
        this.allowNext = false;
        nextElement.classList.remove("disabled");
        nextElement.classList.add("disabled");

        return this;
    }

    public Pager disablePrevious() {
        this.allowPrev = false;
        prevElement.classList.remove("disabled");
        prevElement.classList.add("disabled");

        return this;
    }

    public Pager enableNext() {
        this.allowNext = true;
        nextElement.classList.remove("disabled");

        return this;
    }

    public Pager enablePrevious() {
        this.allowPrev = true;
        prevElement.classList.remove("disabled");

        return this;
    }

    public Pager nextText(String text) {
        nextAnchor.textContent = text;
        return this;
    }

    public Pager previousText(String text) {
        prevAnchor.textContent = text;
        return this;
    }

    public Pager expand() {
        nextElement.classList.add("next");
        prevElement.classList.add("previous");
        return this;
    }

    public Pager showArrows() {
        prevAnchor.insertBefore(span().attr("aria-hidden", "true").textContent("←").asElement(), prevAnchor.firstChild);
        nextAnchor.appendChild(span().attr("aria-hidden", "true").textContent("→").asElement());
        return this;
    }

    @Override
    public HTMLElement asElement() {
        return element;
    }


    public interface PagerChangeCallback {
        void onChange();
    }
}
