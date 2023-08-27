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

import static org.dominokit.domino.ui.grid.Columns._12;
import static org.dominokit.domino.ui.grid.Columns._16;
import static org.dominokit.domino.ui.grid.Columns._18;
import static org.dominokit.domino.ui.grid.Columns._24;
import static org.dominokit.domino.ui.grid.Columns._32;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.style.PostfixCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * A component which provides an abstract level of the CSS grid row which will inherit the styles
 * for the CSS grid row by default
 *
 * <p>More information can be found in <a
 * href="https://developer.mozilla.org/en-US/docs/Web/CSS/grid-row">MDN official documentation</a>
 */
public class Row extends BaseDominoElement<HTMLDivElement, Row> implements GridStyles {

  protected DivElement row;

  private PostfixCssClass rowColumns = PostfixCssClass.of("dui-row", _12.getCount());

  /**
   * Constructor for Row.
   *
   * @param columns a {@link org.dominokit.domino.ui.grid.Columns} object
   */
  public Row(Columns columns) {
    this.row = div().addCss(dui_grid_row, rowColumns.postfix(columns.getCount()));
    init(this);
  }

  /**
   * Creates a grid row with default 12 columns
   *
   * @return new instance of {@link org.dominokit.domino.ui.grid.Row}
   */
  public static Row create() {
    return new Row(_12);
  }

  /**
   * Creates a grid row with 12 columns
   *
   * @return new instance of {@link org.dominokit.domino.ui.grid.Row}
   */
  public static Row of12Columns() {
    return new Row(_12);
  }

  /**
   * Creates a grid row with 16 columns
   *
   * @return new instance of {@link org.dominokit.domino.ui.grid.Row}
   */
  public static Row of16Columns() {
    return new Row(_16);
  }

  /**
   * Creates a grid row with 18 columns
   *
   * @return new instance of {@link org.dominokit.domino.ui.grid.Row}
   */
  public static Row of18Columns() {
    return new Row(_18);
  }

  /**
   * Creates a grid row with 24 columns
   *
   * @return new instance of {@link org.dominokit.domino.ui.grid.Row}
   */
  public static Row of24Columns() {
    return new Row(_24);
  }

  /**
   * Creates a grid row with 32 columns
   *
   * @return new instance of {@link org.dominokit.domino.ui.grid.Row}
   */
  public static Row of32Columns() {
    return new Row(_32);
  }

  /**
   * Sets the spaces between columns inside the row
   *
   * @param gap the string value of the space in <a
   *     href="https://developer.mozilla.org/en-US/docs/Web/CSS/gap">CSS gap format</a>
   * @return same instance
   */
  public Row setGap(String gap) {
    setCssProperty("grid-gap", gap);
    return this;
  }

  /**
   * Adds new column
   *
   * @param column A new {@link org.dominokit.domino.ui.grid.Column} to add
   * @return same instance
   */
  public Row appendChild(Column column) {
    row.appendChild(column.element());
    return this;
  }

  /**
   * span1.
   *
   * @param content a {@link org.dominokit.domino.ui.IsElement} object
   * @return a {@link org.dominokit.domino.ui.grid.Row} object
   */
  public Row span1(IsElement<?> content) {
    return appendChild(Column.span1().appendChild(content));
  }

  /**
   * span2.
   *
   * @param content a {@link org.dominokit.domino.ui.IsElement} object
   * @return a {@link org.dominokit.domino.ui.grid.Row} object
   */
  public Row span2(IsElement<?> content) {
    return appendChild(Column.span2().appendChild(content));
  }

  /**
   * span3.
   *
   * @param content a {@link org.dominokit.domino.ui.IsElement} object
   * @return a {@link org.dominokit.domino.ui.grid.Row} object
   */
  public Row span3(IsElement<?> content) {
    return appendChild(Column.span3().appendChild(content));
  }

  /**
   * span4.
   *
   * @param content a {@link org.dominokit.domino.ui.IsElement} object
   * @return a {@link org.dominokit.domino.ui.grid.Row} object
   */
  public Row span4(IsElement<?> content) {
    return appendChild(Column.span4().appendChild(content));
  }

  /**
   * span5.
   *
   * @param content a {@link org.dominokit.domino.ui.IsElement} object
   * @return a {@link org.dominokit.domino.ui.grid.Row} object
   */
  public Row span5(IsElement<?> content) {
    return appendChild(Column.span5().appendChild(content));
  }

  /**
   * span6.
   *
   * @param content a {@link org.dominokit.domino.ui.IsElement} object
   * @return a {@link org.dominokit.domino.ui.grid.Row} object
   */
  public Row span6(IsElement<?> content) {
    return appendChild(Column.span6().appendChild(content));
  }

  /**
   * span7.
   *
   * @param content a {@link org.dominokit.domino.ui.IsElement} object
   * @return a {@link org.dominokit.domino.ui.grid.Row} object
   */
  public Row span7(IsElement<?> content) {
    return appendChild(Column.span7().appendChild(content));
  }

  /**
   * span8.
   *
   * @param content a {@link org.dominokit.domino.ui.IsElement} object
   * @return a {@link org.dominokit.domino.ui.grid.Row} object
   */
  public Row span8(IsElement<?> content) {
    return appendChild(Column.span8().appendChild(content));
  }

  /**
   * span9.
   *
   * @param content a {@link org.dominokit.domino.ui.IsElement} object
   * @return a {@link org.dominokit.domino.ui.grid.Row} object
   */
  public Row span9(IsElement<?> content) {
    return appendChild(Column.span9().appendChild(content));
  }

  /**
   * span10.
   *
   * @param content a {@link org.dominokit.domino.ui.IsElement} object
   * @return a {@link org.dominokit.domino.ui.grid.Row} object
   */
  public Row span10(IsElement<?> content) {
    return appendChild(Column.span10().appendChild(content));
  }

  /**
   * span11.
   *
   * @param content a {@link org.dominokit.domino.ui.IsElement} object
   * @return a {@link org.dominokit.domino.ui.grid.Row} object
   */
  public Row span11(IsElement<?> content) {
    return appendChild(Column.span11().appendChild(content));
  }

  /**
   * span12.
   *
   * @param content a {@link org.dominokit.domino.ui.IsElement} object
   * @return a {@link org.dominokit.domino.ui.grid.Row} object
   */
  public Row span12(IsElement<?> content) {
    return appendChild(Column.span12().appendChild(content));
  }

  /**
   * span13.
   *
   * @param content a {@link org.dominokit.domino.ui.IsElement} object
   * @return a {@link org.dominokit.domino.ui.grid.Row} object
   */
  public Row span13(IsElement<?> content) {
    return appendChild(Column.span13().appendChild(content));
  }

  /**
   * span14.
   *
   * @param content a {@link org.dominokit.domino.ui.IsElement} object
   * @return a {@link org.dominokit.domino.ui.grid.Row} object
   */
  public Row span14(IsElement<?> content) {
    return appendChild(Column.span14().appendChild(content));
  }

  /**
   * span15.
   *
   * @param content a {@link org.dominokit.domino.ui.IsElement} object
   * @return a {@link org.dominokit.domino.ui.grid.Row} object
   */
  public Row span15(IsElement<?> content) {
    return appendChild(Column.span15().appendChild(content));
  }

  /**
   * span16.
   *
   * @param content a {@link org.dominokit.domino.ui.IsElement} object
   * @return a {@link org.dominokit.domino.ui.grid.Row} object
   */
  public Row span16(IsElement<?> content) {
    return appendChild(Column.span16().appendChild(content));
  }

  /**
   * span17.
   *
   * @param content a {@link org.dominokit.domino.ui.IsElement} object
   * @return a {@link org.dominokit.domino.ui.grid.Row} object
   */
  public Row span17(IsElement<?> content) {
    return appendChild(Column.span17().appendChild(content));
  }

  /**
   * span18.
   *
   * @param content a {@link org.dominokit.domino.ui.IsElement} object
   * @return a {@link org.dominokit.domino.ui.grid.Row} object
   */
  public Row span18(IsElement<?> content) {
    return appendChild(Column.span18().appendChild(content));
  }

  /**
   * span19.
   *
   * @param content a {@link org.dominokit.domino.ui.IsElement} object
   * @return a {@link org.dominokit.domino.ui.grid.Row} object
   */
  public Row span19(IsElement<?> content) {
    return appendChild(Column.span19().appendChild(content));
  }

  /**
   * span20.
   *
   * @param content a {@link org.dominokit.domino.ui.IsElement} object
   * @return a {@link org.dominokit.domino.ui.grid.Row} object
   */
  public Row span20(IsElement<?> content) {
    return appendChild(Column.span20().appendChild(content));
  }

  /**
   * span21.
   *
   * @param content a {@link org.dominokit.domino.ui.IsElement} object
   * @return a {@link org.dominokit.domino.ui.grid.Row} object
   */
  public Row span21(IsElement<?> content) {
    return appendChild(Column.span21().appendChild(content));
  }

  /**
   * span22.
   *
   * @param content a {@link org.dominokit.domino.ui.IsElement} object
   * @return a {@link org.dominokit.domino.ui.grid.Row} object
   */
  public Row span22(IsElement<?> content) {
    return appendChild(Column.span22().appendChild(content));
  }

  /**
   * span23.
   *
   * @param content a {@link org.dominokit.domino.ui.IsElement} object
   * @return a {@link org.dominokit.domino.ui.grid.Row} object
   */
  public Row span23(IsElement<?> content) {
    return appendChild(Column.span23().appendChild(content));
  }

  /**
   * span24.
   *
   * @param content a {@link org.dominokit.domino.ui.IsElement} object
   * @return a {@link org.dominokit.domino.ui.grid.Row} object
   */
  public Row span24(IsElement<?> content) {
    return appendChild(Column.span24().appendChild(content));
  }

  /**
   * span25.
   *
   * @param content a {@link org.dominokit.domino.ui.IsElement} object
   * @return a {@link org.dominokit.domino.ui.grid.Row} object
   */
  public Row span25(IsElement<?> content) {
    return appendChild(Column.span25().appendChild(content));
  }

  /**
   * span26.
   *
   * @param content a {@link org.dominokit.domino.ui.IsElement} object
   * @return a {@link org.dominokit.domino.ui.grid.Row} object
   */
  public Row span26(IsElement<?> content) {
    return appendChild(Column.span26().appendChild(content));
  }

  /**
   * span27.
   *
   * @param content a {@link org.dominokit.domino.ui.IsElement} object
   * @return a {@link org.dominokit.domino.ui.grid.Row} object
   */
  public Row span27(IsElement<?> content) {
    return appendChild(Column.span27().appendChild(content));
  }

  /**
   * span28.
   *
   * @param content a {@link org.dominokit.domino.ui.IsElement} object
   * @return a {@link org.dominokit.domino.ui.grid.Row} object
   */
  public Row span28(IsElement<?> content) {
    return appendChild(Column.span28().appendChild(content));
  }

  /**
   * span29.
   *
   * @param content a {@link org.dominokit.domino.ui.IsElement} object
   * @return a {@link org.dominokit.domino.ui.grid.Row} object
   */
  public Row span29(IsElement<?> content) {
    return appendChild(Column.span29().appendChild(content));
  }

  /**
   * span30.
   *
   * @param content a {@link org.dominokit.domino.ui.IsElement} object
   * @return a {@link org.dominokit.domino.ui.grid.Row} object
   */
  public Row span30(IsElement<?> content) {
    return appendChild(Column.span30().appendChild(content));
  }

  /**
   * span31.
   *
   * @param content a {@link org.dominokit.domino.ui.IsElement} object
   * @return a {@link org.dominokit.domino.ui.grid.Row} object
   */
  public Row span31(IsElement<?> content) {
    return appendChild(Column.span31().appendChild(content));
  }

  /**
   * span32.
   *
   * @param content a {@link org.dominokit.domino.ui.IsElement} object
   * @return a {@link org.dominokit.domino.ui.grid.Row} object
   */
  public Row span32(IsElement<?> content) {
    return appendChild(Column.span32().appendChild(content));
  }

  /**
   *
   * {@inheritDoc
   */
  @Override
  public HTMLDivElement element() {
    return row.element();
  }
}
