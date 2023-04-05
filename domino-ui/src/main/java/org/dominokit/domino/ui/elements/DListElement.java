package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLDListElement;

public class DListElement extends BaseElement<HTMLDListElement, DListElement> {
    public static DListElement of(HTMLDListElement e) {
        return new DListElement(e);
    }

    public DListElement(HTMLDListElement element) {
        super(element);
    }
}
