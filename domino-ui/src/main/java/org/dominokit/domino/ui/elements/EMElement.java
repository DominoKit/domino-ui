package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLElement;

public class EMElement extends BaseElement<HTMLElement, EMElement> {
    public static EMElement of(HTMLElement e) {
        return new EMElement(e);
    }

    public EMElement(HTMLElement element) {
        super(element);
    }
}