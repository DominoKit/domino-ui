package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLElement;

public class StrongElement extends BaseElement<HTMLElement, StrongElement> {
    public static StrongElement of(HTMLElement e) {
        return new StrongElement(e);
    }

    public StrongElement(HTMLElement element) {
        super(element);
    }
}