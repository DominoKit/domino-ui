/*
 * Copyright © 2019 Dominokit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dominokit.domino.ui.shaded.grid;

import static org.jboss.elemento.Elements.div;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import java.util.function.Consumer;
import org.dominokit.domino.ui.shaded.style.Style;
import org.dominokit.domino.ui.shaded.utils.BaseDominoElement;
import org.dominokit.domino.ui.shaded.utils.DominoElement;
import org.jboss.elemento.IsElement;

/**
 * A component which provides an abstract level of the CSS grid row which will inherit the styles
 * for the CSS grid row by default
 *
 * <p>More information can be found in <a
 * href="https://developer.mozilla.org/en-US/docs/Web/CSS/grid-row">MDN official documentation</a>
 *
 * <p>Customize the component can be done by overwriting classes provided by {@link GridStyles}
 *
 * <p>For example:
 *
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
@Deprecated
public class Row<T extends Row<T>> extends BaseDominoElement<HTMLDivElement, T> {

  protected final Columns columns;
  protected HTMLDivElement row;

  public Row(Columns columns) {
    this.row =
        DominoElement.of(div()).css(GridStyles.GRID_ROW).css(columns.getColumnsStyle()).element();
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

  /** @deprecated Use {@link Row#of12Columns()} instead */
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

  /** @deprecated Use {@link Row#of16Columns()} instead */
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

  /** @deprecated Use {@link Row#of18Columns()} instead */
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

  /** @deprecated Use {@link Row#of24Columns()} instead */
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

  /** @deprecated Use {@link Row#of32Columns()} instead */
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
   * @param gap the string value of the space in <a
   *     href="https://developer.mozilla.org/en-US/docs/Web/CSS/gap">CSS gap format</a>
   * @return same instance
   */
  public T setGap(String gap) {
    Style.of(row).setCssProperty("grid-gap", gap);
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

  /** @deprecated Use {@link Row#condensed()} ()} instead */
  @Deprecated
  public T condenced() {
    return style().setMarginBottom("0px").get();
  }
}
