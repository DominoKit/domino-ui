package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLTableSectionElement;

public class THeadElement extends BaseElement<HTMLTableSectionElement, THeadElement> {
    public static THeadElement of(HTMLTableSectionElement e) {
        return new THeadElement(e);
    }

    public THeadElement(HTMLTableSectionElement element) {
        super(element);
    }
}