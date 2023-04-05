package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLElement;

public class UElement extends BaseElement<HTMLElement, UElement> {
    public static UElement of(HTMLElement e) {
        return new UElement(e);
    }

    public UElement(HTMLElement element) {
        super(element);
    }
}