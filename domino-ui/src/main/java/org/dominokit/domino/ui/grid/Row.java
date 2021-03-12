package org.dominokit.domino.ui.grid;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.jboss.elemento.IsElement;

import java.util.function.Consumer;

import static org.jboss.elemento.Elements.div;

/**
 * A component which provides an abstract level of the CSS grid row which will inherit the styles for the CSS grid row by default
 * <p>
 * More information can be found in <a href="https://developer.mozilla.org/en-US/docs/Web/CSS/grid-row">MDN official documentation</a>
 * <p>
 * Customize the component can be done by overwriting classes provided by {@link GridStyles}
 *
 * <p>For example: </p>
 * <pre>
 *     Row.create()
 *        .appendChild(element);
 * </pre>
 *
 * @param <T> the derivative Row type
 * @see BaseDominoElement
 * @see Row_12
 * @see Row_16
 * @see Row_18
 * @see Row_24
 * @see Row_32
 */
public class Row<T extends Row<T>> extends BaseDominoElement<HTMLDivElement, T> {

    protected final Columns columns;
    protected HTMLDivElement row;

    public Row(Columns columns) {
        this.row = div().css(GridStyles.GRID_ROW).css(columns.getColumnsStyle()).element();
        this.columns = columns;
    }

    /**
     * Creates a grid row with default 12 columns
     *
     * @return new instance of {@link Row_12}
     */
    public static Row_12 create() {
        return new Row_12();
    }

    /**
     * Creates a grid row with 12 columns
     *
     * @return new instance of {@link Row_12}
     */
    public static Row_12 of12Columns() {
        return new Row_12();
    }

    /**
     * @deprecated Use {@link Row#of12Columns()} instead
     */
    @Deprecated
    public static Row_12 of12Colmns() {
        return new Row_12();
    }

    /**
     * Creates a grid row with 16 columns
     *
     * @return new instance of {@link Row_16}
     */
    public static Row_16 of16Columns() {
        return new Row_16();
    }

    /**
     * @deprecated Use {@link Row#of16Columns()} instead
     */
    @Deprecated
    public static Row_16 of16Colmns() {
        return new Row_16();
    }

    /**
     * Creates a grid row with 18 columns
     *
     * @return new instance of {@link Row_18}
     */
    public static Row_18 of18Columns() {
        return new Row_18();
    }

    /**
     * @deprecated Use {@link Row#of18Columns()} instead
     */
    @Deprecated
    public static Row_18 of18Colmns() {
        return new Row_18();
    }

    /**
     * Creates a grid row with 24 columns
     *
     * @return new instance of {@link Row_24}
     */
    public static Row_24 of24Columns() {
        return new Row_24();
    }

    /**
     * @deprecated Use {@link Row#of24Columns()} instead
     */
    @Deprecated
    public static Row_24 of24Colmns() {
        return new Row_24();
    }

    /**
     * Creates a grid row with 32 columns
     *
     * @return new instance of {@link Row_32}
     */
    public static Row_32 of32Columns() {
        return new Row_32();
    }

    /**
     * @deprecated Use {@link Row#of32Columns()} instead
     */
    @Deprecated
    public static Row_32 of32Colmns() {
        return new Row_32();
    }


    /**
     * Creates a grid row with {@code columns} count
     *
     * @param columns the number of columns
     * @param <T> the type of row
     * @return new instance of {@link Row} based on the number of columns
     */
    public static <T extends Row<T>> T create(Columns columns) {
        switch (columns) {
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

    /**
     * Sets the spaces between columns inside the row
     *
     * @param gap the string value of the space in <a href="https://developer.mozilla.org/en-US/docs/Web/CSS/gap">CSS gap format</a>
     * @return same instance
     */
    public T setGap(String gap) {
        Style.of(row).setProperty("grid-gap", gap);
        return (T) this;
    }

    /**
     * Adds new column
     *
     * @param column A new {@link Column} to add
     * @return same instance
     */
    public T addColumn(Column column) {
        return appendChild(column);
    }

    /**
     * Adds new column
     *
     * @param column A new {@link Column} to add
     * @return same instance
     */
    public T appendChild(Column column) {
        row.appendChild(column.element());
        return (T) this;
    }

    /**
     * Adds a column which cover all the row
     *
     * @param consumer a {@link Consumer} that provides the created column
     * @return same instance
     */
    public T fullSpan(Consumer<Column> consumer) {
        consumer.accept(addAutoSpanColumn(columns.getCount()));
        return (T) this;
    }

    protected Column addAutoSpanColumn(int span) {
        Column column = Column.span(span, columns.getCount());
        appendChild(column);
        return column;
    }

    /**
     * {@inheritDoc
     */
    @Override
    public HTMLDivElement element() {
        return row;
    }

    /**
     * Adds a new element to the row
     *
     * @param element the {@link HTMLElement} to add
     * @return same instance
     */
    public T appendChild(HTMLElement element) {
        row.appendChild(element);
        return (T) this;
    }

    /**
     * {@inheritDoc
     */
    @Override
    public T appendChild(IsElement<?> element) {
        row.appendChild(element.element());
        return (T) this;
    }

    /**
     * Fits the columns to match the row size without any margin
     *
     * @return same instance
     */
    public T condensed() {
        return style().setMarginBottom("0px").get();
    }

    /**
     * @deprecated Use {@link Row#condensed()} ()} instead
     */
    @Deprecated
    public T condenced() {
        return style().setMarginBottom("0px").get();
    }

}
