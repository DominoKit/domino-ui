package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLElement;

public class HeaderElement extends BaseElement<HTMLElement, HeaderElement> {
    public static HeaderElement of(HTMLElement e) {
        return new HeaderElement(e);
    }

    public HeaderElement(HTMLElement element) {
        super(element);
    }
}
