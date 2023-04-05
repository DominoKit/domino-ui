package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLElement;

public class WBRElement extends BaseElement<HTMLElement, WBRElement> {
    public static WBRElement of(HTMLElement e) {
        return new WBRElement(e);
    }

    public WBRElement(HTMLElement element) {
        super(element);
    }
}