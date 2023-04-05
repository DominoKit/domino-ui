package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLImageElement;

public class ImageElement extends BaseElement<HTMLImageElement, ImageElement> {
    public static ImageElement of(HTMLImageElement e) {
        return new ImageElement(e);
    }

    public ImageElement(HTMLImageElement element) {
        super(element);
    }
}