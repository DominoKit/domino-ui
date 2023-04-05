package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLTableCellElement;

public class THElement extends BaseElement<HTMLTableCellElement, THElement> {
    public static THElement of(HTMLTableCellElement e) {
        return new THElement(e);
    }

    public THElement(HTMLTableCellElement element) {
        super(element);
    }
}