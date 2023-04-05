package org.dominokit.domino.ui.elements;

import elemental2.dom.Element;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

public abstract class BaseElement<E extends Element, T extends BaseElement<E,T>> extends BaseDominoElement<E, T> {

    private final E wrappedElement;

    /** @param element the E element extending from {@link Element} */
    public BaseElement(E element) {
        this.wrappedElement = element;
        init((T) this);
        addCss(dui);
    }

    public DominoElement<E> toDominoElement(){
        return elementOf(wrappedElement);
    }

    /**
     * @return the E element that is extending from {@link HTMLElement} wrapped in this DominoElement
     */
    @Override
    public E element() {
        return wrappedElement;
    }
}
