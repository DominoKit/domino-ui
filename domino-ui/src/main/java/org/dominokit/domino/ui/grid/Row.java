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

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.style.PostfixCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

import static org.dominokit.domino.ui.grid.Columns.*;


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
 * @see BaseDominoElement
 */
public class Row extends BaseDominoElement<HTMLDivElement, Row> implements GridStyles{

  protected DominoElement<HTMLDivElement> row;

  private PostfixCssClass rowColumns = PostfixCssClass.of("dui-row", _12.getCount());

  public Row(Columns columns) {
    this.row =
        DominoElement.div().addCss(dui_grid_row, rowColumns.postfix(columns.getCount()));
    init(this);
  }

  /**
   * Creates a grid row with default 12 columns
   *
   * @return new instance of {@link Row}
   */
  public static Row create() {
    return new Row(_12);
  }

  /**
   * Creates a grid row with 12 columns
   *
   * @return new instance of {@link Row}
   */
  public static Row of12Columns() {
    return new Row(_12);
  }

  /**
   * Creates a grid row with 16 columns
   *
   * @return new instance of {@link Row}
   */
  public static Row of16Columns() {
    return new Row(_16);
  }

  /**
   * Creates a grid row with 18 columns
   *
   * @return new instance of {@link Row}
   */
  public static Row of18Columns() {
    return new Row(_18);
  }

  /**
   * Creates a grid row with 24 columns
   *
   * @return new instance of {@link Row}
   */
  public static Row of24Columns() {
    return new Row(_24);
  }

  /**
   * Creates a grid row with 32 columns
   *
   * @return new instance of {@link Row}
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
   * @param column A new {@link Column} to add
   * @return same instance
   */
  public Row appendChild(Column column) {
    row.appendChild(column.element());
    return this;
  }

  /**
   * {@inheritDoc
   */
  @Override
  public HTMLDivElement element() {
    return row.element();
  }

}
