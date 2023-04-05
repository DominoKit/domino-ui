package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLElement;

public class BElement extends BaseElement<HTMLElement, BElement> {
    public static BElement of(HTMLElement e) {
        return new BElement(e);
    }

    public BElement(HTMLElement element) {
        super(element);
    }
}
