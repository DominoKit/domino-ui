package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLElement;

public class SmallElement extends BaseElement<HTMLElement, SmallElement> {
    public static SmallElement of(HTMLElement e) {
        return new SmallElement(e);
    }

    public SmallElement(HTMLElement element) {
        super(element);
    }
}