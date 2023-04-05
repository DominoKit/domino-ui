package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLTableCellElement;

public class TDElement extends BaseElement<HTMLTableCellElement, TDElement> {
    public static TDElement of(HTMLTableCellElement e) {
        return new TDElement(e);
    }

    public TDElement(HTMLTableCellElement element) {
        super(element);
    }
}