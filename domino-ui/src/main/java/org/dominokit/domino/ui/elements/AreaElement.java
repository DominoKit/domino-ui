package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLAreaElement;

public class AreaElement extends BaseElement<HTMLAreaElement, AreaElement> {
    public static AreaElement of(HTMLAreaElement e) {
        return new AreaElement(e);
    }

    public AreaElement(HTMLAreaElement element) {
        super(element);
    }
}