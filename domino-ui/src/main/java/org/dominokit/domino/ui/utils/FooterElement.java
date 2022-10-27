package org.dominokit.domino.ui.utils;

import elemental2.dom.HTMLElement;
import org.jboss.elemento.IsElement;

public class FooterElement<T extends HTMLElement> extends BaseDominoElement<T, FooterElement<T>>{

    private DominoElement<T> element;

    public static <T extends HTMLElement> FooterElement<T> of(T element){
        return new FooterElement<>(element);
    }

    public static <T extends HTMLElement> FooterElement<T> of(IsElement<T> element){
        return new FooterElement<>(element);
    }

    public FooterElement(T element) {
        this.element = DominoElement.of(element);
        init(this);
    }
    public FooterElement(IsElement<T> element) {
        this(element.element());
    }

    @Override
    public T element() {
        return element.element();
    }
}
