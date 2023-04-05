package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLLIElement;

public class LIElement extends BaseElement<HTMLLIElement, LIElement> {
    public static LIElement of(HTMLLIElement e) {
        return new LIElement(e);
    }

    public LIElement(HTMLLIElement element) {
        super(element);
    }
}
