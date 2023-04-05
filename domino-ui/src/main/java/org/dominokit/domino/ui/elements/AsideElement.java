package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLElement;

public class AsideElement extends BaseElement<HTMLElement, AsideElement> {
    public static AsideElement of(HTMLElement e) {
        return new AsideElement(e);
    }

    public AsideElement(HTMLElement element) {
        super(element);
    }
}
