package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLElement;

public class FigureElement extends BaseElement<HTMLElement, FigureElement> {
    public static FigureElement of(HTMLElement e) {
        return new FigureElement(e);
    }

    public FigureElement(HTMLElement element) {
        super(element);
    }
}
