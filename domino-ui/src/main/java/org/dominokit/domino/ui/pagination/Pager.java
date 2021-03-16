package org.dominokit.domino.ui.pagination;

import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.HTMLUListElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.EventType;
import org.jboss.elemento.HtmlContentBuilder;

import static org.jboss.elemento.Elements.*;

/**
 * A component which provides a simple navigation between a list of elements using next/previous elements
 *
 * <p>For example: </p>
 * <pre>
 *     Pager.create()
 *          .onNext(() -> DomGlobal.console.info("Going to next page."))
 *          .onPrevious(() -> DomGlobal.console.info("Going to previous page."))
 * </pre>
 *
 * @see BaseDominoElement
 */
public class Pager extends BaseDominoElement<HTMLElement, Pager> {

    private final DominoElement<HTMLUListElement> pagerElement = DominoElement.of(ul().css("pager"));
    private final DominoElement<HTMLElement> element = DominoElement.of(nav().add(pagerElement));

    private final DominoElement<HTMLLIElement> nextElement;
    private final DominoElement<HTMLLIElement> prevElement;

    private final DominoElement<HTMLAnchorElement> nextAnchor;
    private final DominoElement<HTMLAnchorElement> prevAnchor;

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
                .element()));

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

    /**
     * @return new instance
     */
    public static Pager create() {
        return new Pager();
    }

    /**
     * Sets the handler that will be called when next element is clicked
     *
     * @param nextCallback the {@link PagerChangeCallback}
     * @return same instance
     */
    public Pager onNext(PagerChangeCallback nextCallback) {
        this.onNext = nextCallback;
        return this;
    }

    /**
     * Sets the handler that will be called when previous element is clicked
     *
     * @param previousCallback the {@link PagerChangeCallback}
     * @return same instance
     */
    public Pager onPrevious(PagerChangeCallback previousCallback) {
        this.onPrev = previousCallback;
        return this;
    }

    /**
     * Disables the next element
     *
     * @return same instance
     */
    public Pager disableNext() {
        this.allowNext = false;
        nextElement.style().remove("disabled");
        nextElement.style().add("disabled");

        return this;
    }

    /**
     * Disables the previous element
     *
     * @return same instance
     */
    public Pager disablePrevious() {
        this.allowPrev = false;
        prevElement.style().remove("disabled");
        prevElement.style().add("disabled");

        return this;
    }

    /**
     * Enables the next element
     *
     * @return same instance
     */
    public Pager enableNext() {
        this.allowNext = true;
        nextElement.style().remove("disabled");

        return this;
    }

    /**
     * Enables the previous element
     *
     * @return same instance
     */
    public Pager enablePrevious() {
        this.allowPrev = true;
        prevElement.style().remove("disabled");

        return this;
    }

    /**
     * Sets the text of the next element
     *
     * @param text the new text
     * @return same instance
     */
    public Pager nextText(String text) {
        nextAnchor.setTextContent(text);
        return this;
    }

    /**
     * Sets the text of the previous element
     *
     * @param text the new text
     * @return same instance
     */
    public Pager previousText(String text) {
        prevAnchor.setTextContent(text);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pager show() {
        nextElement.style().add("next");
        prevElement.style().add("previous");
        return this;
    }

    /**
     * Shows arrows next to the navigation elements
     *
     * @return same instance
     */
    public Pager showArrows() {
        prevAnchor.insertFirst(span().attr("aria-hidden", "true").textContent("←"));
        nextAnchor.appendChild(span().attr("aria-hidden", "true").textContent("→"));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLElement element() {
        return element.element();
    }

    /**
     * A handler that will be called when the navigation is changed
     */
    public interface PagerChangeCallback {
        void onChange();
    }
}
