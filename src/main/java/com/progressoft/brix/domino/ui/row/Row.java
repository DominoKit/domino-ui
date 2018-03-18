package com.progressoft.brix.domino.ui.row;

import com.progressoft.brix.domino.ui.column.Column;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.jboss.gwt.elemento.core.IsElement;

import static org.jboss.gwt.elemento.core.Elements.div;

public class Row implements IsElement<HTMLDivElement> {

    private HTMLDivElement row;

    private Row(HTMLDivElement row) {
        this.row = row;
    }

    public static Row create() {
        return new Row(div().css("row clearfix").asElement());
    }

    public Column addColumn() {
        Column column = Column.create();
        row.appendChild(column.asElement());
        return column;
    }

    public Row addColumn(Column column) {
        row.appendChild(column.asElement());
        return this;
    }

    @Override
    public HTMLDivElement asElement() {
        return row;
    }

    public Row appendContent(HTMLElement element) {
        row.appendChild(element);
        return this;
    }
}
