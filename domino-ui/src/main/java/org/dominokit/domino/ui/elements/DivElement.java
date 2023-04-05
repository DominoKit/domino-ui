package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLDivElement;

public class DivElement extends BaseElement<HTMLDivElement, DivElement> {
    public static DivElement of(HTMLDivElement e) {
        return new DivElement(e);
    }

    public DivElement(HTMLDivElement element) {
        super(element);
    }
}
