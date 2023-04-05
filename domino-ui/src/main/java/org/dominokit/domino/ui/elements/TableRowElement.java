package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLTableRowElement;

public class TableRowElement extends BaseElement<HTMLTableRowElement, TableRowElement> {
    public static TableRowElement of(HTMLTableRowElement e) {
        return new TableRowElement(e);
    }

    public TableRowElement(HTMLTableRowElement element) {
        super(element);
    }
}