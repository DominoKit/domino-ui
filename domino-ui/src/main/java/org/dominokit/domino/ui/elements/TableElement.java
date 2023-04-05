package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLTableElement;

public class TableElement extends BaseElement<HTMLTableElement, TableElement> {
    public static TableElement of(HTMLTableElement e) {
        return new TableElement(e);
    }

    public TableElement(HTMLTableElement element) {
        super(element);
    }
}