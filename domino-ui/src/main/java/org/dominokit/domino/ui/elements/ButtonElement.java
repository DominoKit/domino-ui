package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLButtonElement;

public class ButtonElement extends BaseElement<HTMLButtonElement, ButtonElement> {
    public static ButtonElement of(HTMLButtonElement e) {
        return new ButtonElement(e);
    }

    public ButtonElement(HTMLButtonElement element) {
        super(element);
    }
}