package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLElement;

public class FigCaptionElement extends BaseElement<HTMLElement, FigCaptionElement> {
    public static FigCaptionElement of(HTMLElement e) {
        return new FigCaptionElement(e);
    }

    public FigCaptionElement(HTMLElement element) {
        super(element);
    }
}
