package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLElement;

public class NavElement extends BaseElement<HTMLElement, NavElement> {
    public static NavElement of(HTMLElement e) {
        return new NavElement(e);
    }

    public NavElement(HTMLElement element) {
        super(element);
    }
}
