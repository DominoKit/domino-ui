package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLElement;

public class SupElement extends BaseElement<HTMLElement, SupElement> {
    public static SupElement of(HTMLElement e) {
        return new SupElement(e);
    }

    public SupElement(HTMLElement element) {
        super(element);
    }
}