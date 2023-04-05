package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLElement;

public class VarElement extends BaseElement<HTMLElement, VarElement> {
    public static VarElement of(HTMLElement e) {
        return new VarElement(e);
    }

    public VarElement(HTMLElement element) {
        super(element);
    }
}