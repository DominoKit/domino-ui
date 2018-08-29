package org.dominokit.domino.ui.grid;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.style.Style;

import java.util.function.Consumer;

public class Row_12 extends Row<Row_12> {

    public Row_12() {
        super(Columns._12);
        initCollapsible(this);
    }

    public Row_12 span1(Consumer<Column> consumer) {
        consumer.accept(addAutoSpanColumn(1));
        return this;
    }

    public Row_12 span2(Consumer<Column> consumer) {
        consumer.accept(addAutoSpanColumn(2));
        return this;
    }

    public Row_12 span3(Consumer<Column> consumer) {
        consumer.accept(addAutoSpanColumn(3));
        return this;
    }

    public Row_12 span4(Consumer<Column> consumer) {
        consumer.accept(addAutoSpanColumn(4));
        return this;
    }

    public Row_12 span5(Consumer<Column> consumer) {
        consumer.accept(addAutoSpanColumn(5));
        return this;
    }

    public Row_12 span6(Consumer<Column> consumer) {
        consumer.accept(addAutoSpanColumn(6));
        return this;
    }

    public Row_12 span7(Consumer<Column> consumer) {
        consumer.accept(addAutoSpanColumn(7));
        return this;
    }

    public Row_12 span8(Consumer<Column> consumer) {
        consumer.accept(addAutoSpanColumn(8));
        return this;
    }

    public Row_12 span9(Consumer<Column> consumer) {
        consumer.accept(addAutoSpanColumn(9));
        return this;
    }

    public Row_12 span10(Consumer<Column> consumer) {
        consumer.accept(addAutoSpanColumn(10));
        return this;
    }

    public Row_12 span11(Consumer<Column> consumer) {
        consumer.accept(addAutoSpanColumn(11));
        return this;
    }

    public Row_12 span12(Consumer<Column> consumer) {
        consumer.accept(addAutoSpanColumn(12));
        return this;
    }

    public Style<HTMLDivElement, Row_12> style() {
        return Style.of(this);
    }
}
