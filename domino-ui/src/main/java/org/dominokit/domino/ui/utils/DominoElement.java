package org.dominokit.domino.ui.utils;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLBodyElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.jboss.elemento.Elements;
import org.jboss.elemento.IsElement;

/**
 * A class that can wrap any HTMLElement as domino component
 * @param <E> the type of the wrapped element
 */
public class DominoElement<E extends HTMLElement> extends BaseDominoElement<E, DominoElement<E>> {

    private final E wrappedElement;

    /**
     *
     * @param element the {@link HTMLElement} E to wrap as a DominoElement
     * @param <E> extends from {@link HTMLElement}
     * @return the {@link DominoElement} wrapping the provided element
     */
    public static <E extends HTMLElement> DominoElement<E> of(E element) {
        return new DominoElement<>(element);
    }

    /**
     *
     * @param element the {@link IsElement} E to wrap as a DominoElement
     * @param <E> extends from {@link HTMLElement}
     * @return the {@link DominoElement} wrapping the provided element
     */
    public static <E extends HTMLElement> DominoElement<E> of(IsElement<E> element) {
        return new DominoElement<>(element.element());
    }

    /**
     *
     * @return a {@link DominoElement} wrapping the document {@link HTMLBodyElement}
     */
    public static DominoElement<HTMLBodyElement> body() {
        return new DominoElement<>(DomGlobal.document.body);
    }

    /**
     *
     * @return a new {@link HTMLDivElement} wrapped as a {@link DominoElement}
     */
    public static DominoElement<HTMLDivElement> div() {
        return DominoElement.of(Elements.div());
    }

    /**
     *
     * @param element the E element extending from {@link HTMLElement}
     */
    public DominoElement(E element) {
        this.wrappedElement = element;
        init(this);
    }

    /**
     *
     * @return the E element that is extending from {@link HTMLElement} wrapped in this DominoElement
     */
    @Override
    public E element() {
        return wrappedElement;
    }
}
