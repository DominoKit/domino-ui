package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public abstract class BaseElement<E extends HTMLElement, T extends BaseElement<E,T>> extends BaseDominoElement<E, T> {

    protected E element;

    public BaseElement() {
        this.element = createElement();
        init((T) this);
        addCss(dui);
    }

    protected abstract E createElement();

    @Override
    public E element() {
        return element;
    }
}
