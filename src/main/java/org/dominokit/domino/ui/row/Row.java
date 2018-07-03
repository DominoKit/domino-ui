package org.dominokit.domino.ui.row;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.column.Column;
import org.dominokit.domino.ui.style.Style;
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

    public Row condenced(){
        return Style.of(this).setMarginBottom("0px").get();
    }

    public Style<HTMLDivElement, Row> style() {
        return Style.of(this);
    }
}
