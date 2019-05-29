package org.dominokit.domino.ui.grid;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.function.Consumer;

import static org.jboss.gwt.elemento.core.Elements.div;

public class Row<T extends Row<T>> extends BaseDominoElement<HTMLDivElement, T> {

    protected final Columns columns;
    protected HTMLDivElement row;

    public Row(Columns columns) {
        this.row = div().css(GridStyles.GRID_ROW).css(columns.getColumnsStyle()).asElement();
        this.columns = columns;
    }

    public static Row_12 create(){
        return new Row_12();
    }

    public static Row_12 of12Colmns(){
        return new Row_12();
    }

    public static Row_16 of16Colmns(){
        return new Row_16();
    }

    public static Row_18 of18Colmns(){
        return new Row_18();
    }

    public static Row_24 of24Colmns(){
        return new Row_24();
    }

    public static Row_32 of32Colmns(){
        return new Row_32();
    }

    public static <T extends Row> T create(Columns columns) {
        switch (columns) {
            case _12:
                return (T) new Row_12();
            case _16:
                return (T) new Row_16();
            case _18:
                return (T) new Row_18();
            case _24:
                return (T) new Row_24();
            case _32:
                return (T) new Row_32();
            default:
                return (T) new Row_12();
        }
    }

    public T setGap(String gap) {
        Style.of(row).setProperty("grid-gap", gap);
        return (T) this;
    }

    public T addColumn(Column column) {
        return appendChild(column);
    }


    public T appendChild(Column column) {
        row.appendChild(column.asElement());
        return (T) this;
    }

    public T fullSpan(Consumer<Column> consumer) {
        consumer.accept(addAutoSpanColumn(columns.getCount()));
        return (T) this;
    }

    protected Column addAutoSpanColumn(int span) {
        Column column = Column.span(span, columns.getCount());
        appendChild(column);
        return column;
    }

    @Override
    public HTMLDivElement asElement() {
        return row;
    }

    public T appendChild(HTMLElement element) {
        row.appendChild(element);
        return (T) this;
    }

    public T appendChild(IsElement element) {
        row.appendChild(element.asElement());
        return (T) this;
    }

    public T condenced() {
        return style().setMarginBottom("0px").get();
    }

}
