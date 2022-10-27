package org.dominokit.domino.ui.utils;

import elemental2.dom.HTMLElement;
import org.jboss.elemento.IsElement;

public class UtilityElement<T extends HTMLElement> extends BaseDominoElement<T, UtilityElement<T>>{

    private DominoElement<T> element;

    public static <T extends HTMLElement> UtilityElement<T> of(T element){
        return new UtilityElement<>(element);
    }

    public static <T extends HTMLElement> UtilityElement<T> of(IsElement<T> element){
        return new UtilityElement<>(element);
    }

    public UtilityElement(T element) {
        this.element = DominoElement.of(element);
        init(this);
    }
    public UtilityElement(IsElement<T> element) {
        this(element.element());
    }

    @Override
    public T element() {
        return element.element();
    }
}
