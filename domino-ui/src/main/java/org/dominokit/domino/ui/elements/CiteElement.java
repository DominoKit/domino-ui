package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLElement;

public class CiteElement extends BaseElement<HTMLElement, CiteElement> {
    public static CiteElement of(HTMLElement e) {
        return new CiteElement(e);
    }

    public CiteElement(HTMLElement element) {
        super(element);
    }
}