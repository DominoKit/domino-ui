package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLOptGroupElement;

public class OptGroupElement extends BaseElement<HTMLOptGroupElement, OptGroupElement> {
    public static OptGroupElement of(HTMLOptGroupElement e) {
        return new OptGroupElement(e);
    }

    public OptGroupElement(HTMLOptGroupElement element) {
        super(element);
    }
}