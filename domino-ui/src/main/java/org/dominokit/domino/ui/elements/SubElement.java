package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLElement;

public class SubElement extends BaseElement<HTMLElement, SubElement> {
    public static SubElement of(HTMLElement e) {
        return new SubElement(e);
    }

    public SubElement(HTMLElement element) {
        super(element);
    }
}