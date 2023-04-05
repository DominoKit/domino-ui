package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLElement;

public class DDElement extends BaseElement<HTMLElement, DDElement> {
    public static DDElement of(HTMLElement e) {
        return new DDElement(e);
    }

    public DDElement(HTMLElement element) {
        super(element);
    }
}
