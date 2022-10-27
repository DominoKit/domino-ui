package org.dominokit.domino.ui.utils;

import elemental2.dom.HTMLElement;
import org.jboss.elemento.IsElement;

public class HeaderElement<T extends HTMLElement> extends BaseDominoElement<T, HeaderElement<T>>{

    private DominoElement<T> element;

    public static <T extends HTMLElement> HeaderElement<T> of(T element){
        return new HeaderElement<>(element);
    }

    public static <T extends HTMLElement> HeaderElement<T> of(IsElement<T> element){
        return new HeaderElement<>(element);
    }

    public HeaderElement(T element) {
        this.element = DominoElement.of(element);
        init(this);
    }
    public HeaderElement(IsElement<T> element) {
        this(element.element());
    }

    @Override
    public T element() {
        return element.element();
    }
}
