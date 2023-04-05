package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLElement;

public class SectionElement extends BaseElement<HTMLElement, SectionElement> {
    public static SectionElement of(HTMLElement e) {
        return new SectionElement(e);
    }

    public SectionElement(HTMLElement element) {
        super(element);
    }
}
