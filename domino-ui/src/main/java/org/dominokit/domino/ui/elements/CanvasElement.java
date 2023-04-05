package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLCanvasElement;

public class CanvasElement extends BaseElement<HTMLCanvasElement, CanvasElement> {
    public static CanvasElement of(HTMLCanvasElement e) {
        return new CanvasElement(e);
    }

    public CanvasElement(HTMLCanvasElement element) {
        super(element);
    }
}