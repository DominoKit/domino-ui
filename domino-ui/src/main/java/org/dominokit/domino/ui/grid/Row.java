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
package org.dominokit.domino.ui.grid;

import static org.dominokit.domino.ui.grid.Columns.*;
import static org.dominokit.domino.ui.utils.Domino.*;
import static org.dominokit.domino.ui.utils.Domino.div;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.style.PostfixCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * Represents a row in a grid layout.
 *
 * @see BaseDominoElement
 */
public class Row extends BaseDominoElement<HTMLDivElement, Row> implements GridStyles {

  protected DivElement row;

  private PostfixCssClass rowColumns = PostfixCssClass.of("dui-row", _12.getCount());

  /**
   * Constructs a new row with the specified number of columns.
   *
   * @param columns The number of columns in the row.
   */
  public Row(Columns columns) {
    this.row = div().addCss(dui_grid_row, rowColumns.postfix(columns.getCount()));
    init(this);
  }

  /**
   * Creates a new row with 12 columns.
   *
   * @return A new row with 12 columns.
   */
  public static Row create() {
    return new Row(_12);
  }

  /**
   * Creates a new row with 12 columns.
   *
   * @return A new row with 12 columns.
   */
  public static Row of12Columns() {
    return new Row(_12);
  }

  /**
   * Creates a new row with 16 columns.
   *
   * @return A new row with 16 columns.
   */
  public static Row of16Columns() {
    return new Row(_16);
  }

  /**
   * Creates a new row with 18 columns.
   *
   * @return A new row with 18 columns.
   */
  public static Row of18Columns() {
    return new Row(_18);
  }

  /**
   * Creates a new row with 24 columns.
   *
   * @return A new row with 24 columns.
   */
  public static Row of24Columns() {
    return new Row(_24);
  }

  /**
   * Creates a new row with 32 columns.
   *
   * @return A new row with 32 columns.
   */
  public static Row of32Columns() {
    return new Row(_32);
  }

  /**
   * Sets the gap between elements in the row.
   *
   * @param gap The gap value to set.
   * @return This Row instance.
   */
  public Row setGap(String gap) {
    setCssProperty("grid-gap", gap);
    return this;
  }

  /**
   * Appends a column to the row.
   *
   * @param column The column to append.
   * @return This Row instance.
   */
  public Row appendChild(Column column) {
    row.appendChild(column.element());
    return this;
  }

  /**
   * Appends a column with a span of 1 to the row, containing the provided content.
   *
   * @param content The content to be placed in the column.
   * @return This Row instance.
   */
  public Row span1(IsElement<?> content) {
    return appendChild(Column.span1().appendChild(content));
  }

  /**
   * Appends a column with a span of 2 to the row, containing the provided content.
   *
   * @param content The content to be placed in the column.
   * @return This Row instance.
   */
  public Row span2(IsElement<?> content) {
    return appendChild(Column.span2().appendChild(content));
  }

  /**
   * Appends a column with a span of 3 to the row, containing the provided content.
   *
   * @param content The content to be placed in the column.
   * @return This Row instance.
   */
  public Row span3(IsElement<?> content) {
    return appendChild(Column.span3().appendChild(content));
  }

  /**
   * Appends a column with a span of 4 to the row, containing the provided content.
   *
   * @param content The content to be placed in the column.
   * @return This Row instance.
   */
  public Row span4(IsElement<?> content) {
    return appendChild(Column.span4().appendChild(content));
  }

  /**
   * Appends a column with a span of 5 to the row, containing the provided content.
   *
   * @param content The content to be placed in the column.
   * @return This Row instance.
   */
  public Row span5(IsElement<?> content) {
    return appendChild(Column.span5().appendChild(content));
  }

  /**
   * Appends a column with a span of 6 to the row, containing the provided content.
   *
   * @param content The content to be placed in the column.
   * @return This Row instance.
   */
  public Row span6(IsElement<?> content) {
    return appendChild(Column.span6().appendChild(content));
  }

  /**
   * Appends a column with a span of 7 to the row, containing the provided content.
   *
   * @param content The content to be placed in the column.
   * @return This Row instance.
   */
  public Row span7(IsElement<?> content) {
    return appendChild(Column.span7().appendChild(content));
  }

  /**
   * Appends a column with a span of 8 to the row, containing the provided content.
   *
   * @param content The content to be placed in the column.
   * @return This Row instance.
   */
  public Row span8(IsElement<?> content) {
    return appendChild(Column.span8().appendChild(content));
  }

  /**
   * Appends a column with a span of 9 to the row, containing the provided content.
   *
   * @param content The content to be placed in the column.
   * @return This Row instance.
   */
  public Row span9(IsElement<?> content) {
    return appendChild(Column.span9().appendChild(content));
  }

  /**
   * Appends a column with a span of 10 to the row, containing the provided content.
   *
   * @param content The content to be placed in the column.
   * @return This Row instance.
   */
  public Row span10(IsElement<?> content) {
    return appendChild(Column.span10().appendChild(content));
  }

  /**
   * Appends a column with a span of 11 to the row, containing the provided content.
   *
   * @param content The content to be placed in the column.
   * @return This Row instance.
   */
  public Row span11(IsElement<?> content) {
    return appendChild(Column.span11().appendChild(content));
  }

  /**
   * Appends a column with a span of 12 to the row, containing the provided content.
   *
   * @param content The content to be placed in the column.
   * @return This Row instance.
   */
  public Row span12(IsElement<?> content) {
    return appendChild(Column.span12().appendChild(content));
  }

  /**
   * Appends a column with a span of 13 to the row, containing the provided content.
   *
   * @param content The content to be placed in the column.
   * @return This Row instance.
   */
  public Row span13(IsElement<?> content) {
    return appendChild(Column.span13().appendChild(content));
  }

  /**
   * Appends a column with a span of 14 to the row, containing the provided content.
   *
   * @param content The content to be placed in the column.
   * @return This Row instance.
   */
  public Row span14(IsElement<?> content) {
    return appendChild(Column.span14().appendChild(content));
  }

  /**
   * Appends a column with a span of 15 to the row, containing the provided content.
   *
   * @param content The content to be placed in the column.
   * @return This Row instance.
   */
  public Row span15(IsElement<?> content) {
    return appendChild(Column.span15().appendChild(content));
  }

  /**
   * Appends a column with a span of 16 to the row, containing the provided content.
   *
   * @param content The content to be placed in the column.
   * @return This Row instance.
   */
  public Row span16(IsElement<?> content) {
    return appendChild(Column.span16().appendChild(content));
  }

  /**
   * Appends a column with a span of 17 to the row, containing the provided content.
   *
   * @param content The content to be placed in the column.
   * @return This Row instance.
   */
  public Row span17(IsElement<?> content) {
    return appendChild(Column.span17().appendChild(content));
  }

  /**
   * Appends a column with a span of 18 to the row, containing the provided content.
   *
   * @param content The content to be placed in the column.
   * @return This Row instance.
   */
  public Row span18(IsElement<?> content) {
    return appendChild(Column.span18().appendChild(content));
  }

  /**
   * Appends a column with a span of 19 to the row, containing the provided content.
   *
   * @param content The content to be placed in the column.
   * @return This Row instance.
   */
  public Row span19(IsElement<?> content) {
    return appendChild(Column.span19().appendChild(content));
  }

  /**
   * Appends a column with a span of 20 to the row, containing the provided content.
   *
   * @param content The content to be placed in the column.
   * @return This Row instance.
   */
  public Row span20(IsElement<?> content) {
    return appendChild(Column.span20().appendChild(content));
  }

  /**
   * Appends a column with a span of 21 to the row, containing the provided content.
   *
   * @param content The content to be placed in the column.
   * @return This Row instance.
   */
  public Row span21(IsElement<?> content) {
    return appendChild(Column.span21().appendChild(content));
  }

  /**
   * Appends a column with a span of 22 to the row, containing the provided content.
   *
   * @param content The content to be placed in the column.
   * @return This Row instance.
   */
  public Row span22(IsElement<?> content) {
    return appendChild(Column.span22().appendChild(content));
  }

  /**
   * Appends a column with a span of 23 to the row, containing the provided content.
   *
   * @param content The content to be placed in the column.
   * @return This Row instance.
   */
  public Row span23(IsElement<?> content) {
    return appendChild(Column.span23().appendChild(content));
  }

  /**
   * Appends a column with a span of 24 to the row, containing the provided content.
   *
   * @param content The content to be placed in the column.
   * @return This Row instance.
   */
  public Row span24(IsElement<?> content) {
    return appendChild(Column.span24().appendChild(content));
  }

  /**
   * Appends a column with a span of 25 to the row, containing the provided content.
   *
   * @param content The content to be placed in the column.
   * @return This Row instance.
   */
  public Row span25(IsElement<?> content) {
    return appendChild(Column.span25().appendChild(content));
  }

  /**
   * Appends a column with a span of 26 to the row, containing the provided content.
   *
   * @param content The content to be placed in the column.
   * @return This Row instance.
   */
  public Row span26(IsElement<?> content) {
    return appendChild(Column.span26().appendChild(content));
  }

  /**
   * Appends a column with a span of 27 to the row, containing the provided content.
   *
   * @param content The content to be placed in the column.
   * @return This Row instance.
   */
  public Row span27(IsElement<?> content) {
    return appendChild(Column.span27().appendChild(content));
  }

  /**
   * Appends a column with a span of 28 to the row, containing the provided content.
   *
   * @param content The content to be placed in the column.
   * @return This Row instance.
   */
  public Row span28(IsElement<?> content) {
    return appendChild(Column.span28().appendChild(content));
  }

  /**
   * Appends a column with a span of 29 to the row, containing the provided content.
   *
   * @param content The content to be placed in the column.
   * @return This Row instance.
   */
  public Row span29(IsElement<?> content) {
    return appendChild(Column.span29().appendChild(content));
  }

  /**
   * Appends a column with a span of 30 to the row, containing the provided content.
   *
   * @param content The content to be placed in the column.
   * @return This Row instance.
   */
  public Row span30(IsElement<?> content) {
    return appendChild(Column.span30().appendChild(content));
  }

  /**
   * Appends a column with a span of 31 to the row, containing the provided content.
   *
   * @param content The content to be placed in the column.
   * @return This Row instance.
   */
  public Row span31(IsElement<?> content) {
    return appendChild(Column.span31().appendChild(content));
  }

  /**
   * Appends a column with a span of 32 to the row, containing the provided content.
   *
   * @param content The content to be placed in the column.
   * @return This Row instance.
   */
  public Row span32(IsElement<?> content) {
    return appendChild(Column.span32().appendChild(content));
  }

  /**
   * {@inheritDoc} Returns the underlying HTMLDivElement of this Row.
   *
   * @return The HTMLDivElement element representing this Row.
   */
  @Override
  public HTMLDivElement element() {
    return row.element();
  }
}
