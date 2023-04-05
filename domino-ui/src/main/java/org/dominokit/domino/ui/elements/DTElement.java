package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLElement;

public class DTElement extends BaseElement<HTMLElement, DTElement> {
    public static DTElement of(HTMLElement e) {
        return new DTElement(e);
    }

    public DTElement(HTMLElement element) {
        super(element);
    }
}
