package org.dominokit.domino.ui.pagination;

import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.HTMLUListElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.gwt.elemento.core.EventType;
import org.jboss.gwt.elemento.core.builder.HtmlContentBuilder;

import static org.jboss.gwt.elemento.core.Elements.*;

public class Pager extends BaseDominoElement<HTMLElement, Pager> {

    private DominoElement<HTMLUListElement> pagerElement = DominoElement.of(ul().css("pager"));
    private DominoElement<HTMLElement> element = DominoElement.of(nav().add(pagerElement));

    private DominoElement<HTMLLIElement> nextElement;
    private DominoElement<HTMLLIElement> prevElement;

    private DominoElement<HTMLAnchorElement> nextAnchor;
    private DominoElement<HTMLAnchorElement> prevAnchor;

    private PagerChangeCallback onNext = () -> {
    };
    private PagerChangeCallback onPrev = () -> {
    };

    private boolean allowNext = true;
    private boolean allowPrev = true;

    public Pager() {
        HtmlContentBuilder<HTMLAnchorElement> nextAnchor = a();
        this.nextAnchor = DominoElement.of(nextAnchor);
        nextElement = DominoElement.of(li().add(nextAnchor.css("wave-effect")
                .on(EventType.click, event -> {
                    if (allowNext)
                        onNext.onChange();
                })
                .textContent("Next")
                .asElement()));

        HtmlContentBuilder<HTMLAnchorElement> prevAnchor = a();
        this.prevAnchor = DominoElement.of(prevAnchor);
        prevElement = DominoElement.of(li().add(prevAnchor.css("wave-effect")
                .on(EventType.click, event -> {
                    if (allowPrev)
                        onPrev.onChange();
                })
                .textContent("Previous")));
        pagerElement.appendChild(prevElement);
        pagerElement.appendChild(nextElement);

        init(this);
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
        nextElement.style().remove("disabled");
        nextElement.style().add("disabled");

        return this;
    }

    public Pager disablePrevious() {
        this.allowPrev = false;
        prevElement.style().remove("disabled");
        prevElement.style().add("disabled");

        return this;
    }

    public Pager enableNext() {
        this.allowNext = true;
        nextElement.style().remove("disabled");

        return this;
    }

    public Pager enablePrevious() {
        this.allowPrev = true;
        prevElement.style().remove("disabled");

        return this;
    }

    public Pager nextText(String text) {
        nextAnchor.setTextContent(text);
        return this;
    }

    public Pager previousText(String text) {
        prevAnchor.setTextContent(text);
        return this;
    }

    @Override
    public Pager show() {
        nextElement.style().add("next");
        prevElement.style().add("previous");
        return this;
    }

    public Pager showArrows() {
        prevAnchor.insertFirst(span().attr("aria-hidden", "true").textContent("←"));
        nextAnchor.appendChild(span().attr("aria-hidden", "true").textContent("→"));
        return this;
    }

    @Override
    public HTMLElement asElement() {
        return element.asElement();
    }


    public interface PagerChangeCallback {
        void onChange();
    }
}
