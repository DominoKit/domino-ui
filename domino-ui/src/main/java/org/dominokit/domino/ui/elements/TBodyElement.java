package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLTableSectionElement;

public class TBodyElement extends BaseElement<HTMLTableSectionElement, TBodyElement> {
    public static TBodyElement of(HTMLTableSectionElement e) {
        return new TBodyElement(e);
    }

    public TBodyElement(HTMLTableSectionElement element) {
        super(element);
    }
}