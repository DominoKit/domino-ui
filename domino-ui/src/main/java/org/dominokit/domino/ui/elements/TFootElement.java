package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLTableSectionElement;

public class TFootElement extends BaseElement<HTMLTableSectionElement, TFootElement> {
    public static TFootElement of(HTMLTableSectionElement e) {
        return new TFootElement(e);
    }

    public TFootElement(HTMLTableSectionElement element) {
        super(element);
    }
}