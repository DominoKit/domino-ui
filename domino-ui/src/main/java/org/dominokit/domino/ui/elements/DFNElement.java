package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLElement;

public class DFNElement extends BaseElement<HTMLElement, DFNElement> {
    public static DFNElement of(HTMLElement e) {
        return new DFNElement(e);
    }

    public DFNElement(HTMLElement element) {
        super(element);
    }
}