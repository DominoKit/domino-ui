package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLOptionElement;

public class OptionElement extends BaseElement<HTMLOptionElement, OptionElement> {
    public static OptionElement of(HTMLOptionElement e) {
        return new OptionElement(e);
    }

    public OptionElement(HTMLOptionElement element) {
        super(element);
    }
}