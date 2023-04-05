package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLElement;

public class FooterElement extends BaseElement<HTMLElement, FooterElement> {
    public static FooterElement of(HTMLElement e) {
        return new FooterElement(e);
    }

    public FooterElement(HTMLElement element) {
        super(element);
    }
}
