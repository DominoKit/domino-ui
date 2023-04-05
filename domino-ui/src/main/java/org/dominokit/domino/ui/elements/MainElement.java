package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;

public class MainElement extends BaseElement<HTMLElement, MainElement> {
    public static MainElement of(HTMLElement e) {
        return new MainElement(e);
    }

    public MainElement(HTMLElement element) {
        super(element);
    }
}
