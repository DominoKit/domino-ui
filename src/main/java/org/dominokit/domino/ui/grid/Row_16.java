package org.dominokit.domino.ui.grid;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.style.Style;

import java.util.function.Consumer;

public class Row_16 extends Row<Row_16> {

    public Row_16() {
        super(Columns._16);
        init(this);
    }

    public Row_16 span1(Consumer<Column> consumer) {
        consumer.accept(addAutoSpanColumn(1));
        return this;
    }

    public Row_16 span2(Consumer<Column> consumer) {
        consumer.accept(addAutoSpanColumn(2));
        return this;
    }

    public Row_16 span3(Consumer<Column> consumer) {
        consumer.accept(addAutoSpanColumn(3));
        return this;
    }

    public Row_16 span4(Consumer<Column> consumer) {
        consumer.accept(addAutoSpanColumn(4));
        return this;
    }

    public Row_16 span5(Consumer<Column> consumer) {
        consumer.accept(addAutoSpanColumn(5));
        return this;
    }

    public Row_16 span6(Consumer<Column> consumer) {
        consumer.accept(addAutoSpanColumn(6));
        return this;
    }

    public Row_16 span7(Consumer<Column> consumer) {
        consumer.accept(addAutoSpanColumn(7));
        return this;
    }

    public Row_16 span8(Consumer<Column> consumer) {
        consumer.accept(addAutoSpanColumn(8));
        return this;
    }

    public Row_16 span9(Consumer<Column> consumer) {
        consumer.accept(addAutoSpanColumn(9));
        return this;
    }

    public Row_16 span10(Consumer<Column> consumer) {
        consumer.accept(addAutoSpanColumn(10));
        return this;
    }

    public Row_16 span11(Consumer<Column> consumer) {
        consumer.accept(addAutoSpanColumn(11));
        return this;
    }

    public Row_16 span12(Consumer<Column> consumer) {
        consumer.accept(addAutoSpanColumn(12));
        return this;
    }

    public Row_16 span13(Consumer<Column> consumer) {
        consumer.accept(addAutoSpanColumn(13));
        return this;
    }

    public Row_16 span14(Consumer<Column> consumer) {
        consumer.accept(addAutoSpanColumn(14));
        return this;
    }

    public Row_16 span15(Consumer<Column> consumer) {
        consumer.accept(addAutoSpanColumn(15));
        return this;
    }

    public Row_16 span16(Consumer<Column> consumer) {
        consumer.accept(addAutoSpanColumn(16));
        return this;
    }

    public Style<HTMLDivElement, Row_16> style() {
        return Style.of(this);
    }
}
