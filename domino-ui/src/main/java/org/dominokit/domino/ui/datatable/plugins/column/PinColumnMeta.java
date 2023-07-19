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
package org.dominokit.domino.ui.datatable.plugins.column;

import static org.dominokit.domino.ui.datatable.plugins.column.PinColumnsPlugin.PIN_COLUMNS_CSS_RULE;

import java.util.List;
import java.util.Optional;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.ColumnCssRuleMeta;
import org.dominokit.domino.ui.datatable.ColumnHeaderMeta;
import org.dominokit.domino.ui.utils.ComponentMeta;
import org.dominokit.domino.ui.utils.DominoCSSRule;

/**
 * PinColumnMeta class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class PinColumnMeta implements ComponentMeta, PinColumnFunction {

  private final PinDirection direction;

  /** Constant <code>PIN_COLUMN_META="pin-column-meta"</code> */
  public static final String PIN_COLUMN_META = "pin-column-meta";

  /**
   * left.
   *
   * @return a {@link org.dominokit.domino.ui.datatable.plugins.column.PinColumnMeta} object
   */
  public static PinColumnMeta left() {
    return new PinColumnMeta(PinDirection.LEFT);
  }

  /**
   * right.
   *
   * @return a {@link org.dominokit.domino.ui.datatable.plugins.column.PinColumnMeta} object
   */
  public static PinColumnMeta right() {
    return new PinColumnMeta(PinDirection.RIGHT);
  }

  /**
   * get.
   *
   * @param column a {@link org.dominokit.domino.ui.datatable.ColumnConfig} object
   * @return a {@link java.util.Optional} object
   */
  public static Optional<PinColumnMeta> get(ColumnConfig<?> column) {
    return column.getMeta(PIN_COLUMN_META);
  }

  /**
   * isPinLeft.
   *
   * @param column a {@link org.dominokit.domino.ui.datatable.ColumnConfig} object
   * @return a boolean
   */
  public static boolean isPinLeft(ColumnConfig<?> column) {
    return PinColumnMeta.get(column).isPresent() && PinColumnMeta.get(column).get().isLeftPin();
  }

  /**
   * isPinRight.
   *
   * @param column a {@link org.dominokit.domino.ui.datatable.ColumnConfig} object
   * @return a boolean
   */
  public static boolean isPinRight(ColumnConfig<?> column) {
    return PinColumnMeta.get(column).isPresent() && PinColumnMeta.get(column).get().isRightPin();
  }

  /**
   * isPinned.
   *
   * @param column a {@link org.dominokit.domino.ui.datatable.ColumnConfig} object
   * @return a boolean
   */
  public static boolean isPinned(ColumnConfig<?> column) {
    return (PinColumnMeta.isPinLeft(column) || PinColumnMeta.isPinRight(column));
  }

  /**
   * Constructor for PinColumnMeta.
   *
   * @param direction a {@link
   *     org.dominokit.domino.ui.datatable.plugins.column.PinColumnMeta.PinDirection} object
   */
  public PinColumnMeta(PinDirection direction) {
    this.direction = direction;
  }

  /**
   * isLeftPin.
   *
   * @return a boolean
   */
  public boolean isLeftPin() {
    return PinDirection.LEFT.equals(direction);
  }

  /**
   * isRightPin.
   *
   * @return a boolean
   */
  public boolean isRightPin() {
    return PinDirection.RIGHT.equals(direction);
  }

  /** {@inheritDoc} */
  @Override
  public String getKey() {
    return PIN_COLUMN_META;
  }

  /** {@inheritDoc} */
  @Override
  public double pin(ColumnConfig<?> column, double position) {
    return direction.pin(column, position);
  }

  public enum PinDirection implements PinColumnFunction {
    LEFT(PinDirection::pinHeaderLeft),
    RIGHT(PinColumnMeta::pinHeaderRight);

    private PinColumnFunction pinColumnFunction;

    PinDirection(PinColumnFunction pinColumnFunction) {
      this.pinColumnFunction = pinColumnFunction;
    }

    private static <T> double pinHeaderLeft(ColumnConfig<T> column, double left) {
      ColumnCssRuleMeta.get(column)
          .flatMap(cssMeta -> cssMeta.getColumnCssRule(PIN_COLUMNS_CSS_RULE))
          .ifPresent(
              pinCssRule -> {
                DominoCSSRule style = pinCssRule.getCssRule();
                style.setProperty("right", "auto");
                style.setProperty("position", "sticky");
                style.setProperty("left", left + "px");
                style.setProperty("z-index", "1");
              });
      column
          .getGrandParent()
          .applyAndOnSubColumns(
              col -> {
                col.getHeadElement().setCssProperty("z-index", "2");
                ColumnHeaderMeta.get(col)
                    .ifPresent(
                        columnHeaderMeta -> {
                          columnHeaderMeta
                              .getExtraHeadElements()
                              .forEach(element -> element.setCssProperty("z-index", "2"));
                        });
              });
      if (column.isColumnGroup()) {
        double[] childOffset = new double[] {left};
        column
            .getSubColumns()
            .forEach(
                subColumn -> {
                  subColumn.applyMeta(PinColumnMeta.get(column).get());
                  childOffset[0] = pinHeaderLeft(subColumn, childOffset[0]);
                });
      }

      return left + column.getHeadElement().getBoundingClientRect().width;
    }

    @Override
    public double pin(ColumnConfig<?> column, double position) {
      return pinColumnFunction.pin(column, position);
    }
  }

  private static <T> double pinHeaderRight(ColumnConfig<T> column, double right) {
    ColumnCssRuleMeta.get(column)
        .flatMap(cssMeta -> cssMeta.getColumnCssRule(PIN_COLUMNS_CSS_RULE))
        .ifPresent(
            pinCssRule -> {
              DominoCSSRule style = pinCssRule.getCssRule();
              style.setProperty("left", "auto");
              style.setProperty("position", "sticky");
              style.setProperty("right", right + "px");
              style.setProperty("z-index", "1");
            });

    column
        .getGrandParent()
        .applyAndOnSubColumns(
            col -> {
              col.getHeadElement().setCssProperty("z-index", "2");
              ColumnHeaderMeta.get(col)
                  .ifPresent(
                      columnHeaderMeta -> {
                        columnHeaderMeta
                            .getExtraHeadElements()
                            .forEach(element -> element.setCssProperty("z-index", "2"));
                      });
            });
    if (column.isColumnGroup()) {
      double[] childOffset = new double[] {right};
      List<ColumnConfig<T>> subColumns = column.getSubColumns();
      for (int i = subColumns.size() - 1; i >= 0; i--) {
        ColumnConfig<?> subColumn = subColumns.get(i);
        subColumn.applyMeta(PinColumnMeta.get(column).get());
        childOffset[0] = pinHeaderRight(subColumn, childOffset[0]);
      }
    }

    return right + column.getHeadElement().getBoundingClientRect().width;
  }
}
