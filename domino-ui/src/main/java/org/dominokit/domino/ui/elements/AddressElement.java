package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLElement;

public class AddressElement extends BaseElement<HTMLElement, AddressElement> {
    public static AddressElement of(HTMLElement e) {
        return new AddressElement(e);
    }
    public AddressElement(HTMLElement element) {
        super(element);
    }
}
