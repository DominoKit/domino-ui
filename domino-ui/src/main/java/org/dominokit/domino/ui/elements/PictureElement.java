package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLPictureElement;

public class PictureElement extends BaseElement<HTMLPictureElement, PictureElement> {
    public static PictureElement of(HTMLPictureElement e) {
        return new PictureElement(e);
    }

    public PictureElement(HTMLPictureElement element) {
        super(element);
    }
}
