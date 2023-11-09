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
 * A meta class for handling pinned columns in a DataTable. It provides methods and information
 * related to pinned columns.
 *
 * @see org.dominokit.domino.ui.datatable.plugins.column.PinColumnsPlugin
 */
public class PinColumnMeta implements ComponentMeta, PinColumnFunction {

  private final PinDirection direction;

  /** The meta key for PinColumnMeta. */
  public static final String PIN_COLUMN_META = "pin-column-meta";

  /**
   * Creates a new PinColumnMeta instance for pinning columns to the left side of the DataTable.
   *
   * @return A PinColumnMeta instance for pinning columns to the left side.
   */
  public static PinColumnMeta left() {
    return new PinColumnMeta(PinDirection.LEFT);
  }

  /**
   * Creates a new PinColumnMeta instance for pinning columns to the right side of the DataTable.
   *
   * @return A PinColumnMeta instance for pinning columns to the right side.
   */
  public static PinColumnMeta right() {
    return new PinColumnMeta(PinDirection.RIGHT);
  }

  /**
   * Gets an optional PinColumnMeta for the specified column.
   *
   * @param column The column for which to retrieve the PinColumnMeta.
   * @return An Optional containing the PinColumnMeta if available, or an empty Optional if not.
   */
  public static Optional<PinColumnMeta> get(ColumnConfig<?> column) {
    return column.getMeta(PIN_COLUMN_META);
  }

  /**
   * Checks if the specified column is pinned to the left side.
   *
   * @param column The column to check.
   * @return True if the column is pinned to the left side, false otherwise.
   */
  public static boolean isPinLeft(ColumnConfig<?> column) {
    return PinColumnMeta.get(column).isPresent() && PinColumnMeta.get(column).get().isLeftPin();
  }

  /**
   * Checks if the specified column is pinned to the right side.
   *
   * @param column The column to check.
   * @return True if the column is pinned to the right side, false otherwise.
   */
  public static boolean isPinRight(ColumnConfig<?> column) {
    return PinColumnMeta.get(column).isPresent() && PinColumnMeta.get(column).get().isRightPin();
  }

  /**
   * Checks if the specified column is pinned either to the left or right side.
   *
   * @param column The column to check.
   * @return True if the column is pinned, false otherwise.
   */
  public static boolean isPinned(ColumnConfig<?> column) {
    return (PinColumnMeta.isPinLeft(column) || PinColumnMeta.isPinRight(column));
  }

  /**
   * Creates a new PinColumnMeta instance with the specified pin direction.
   *
   * @param direction The pin direction.
   */
  public PinColumnMeta(PinDirection direction) {
    this.direction = direction;
  }

  /**
   * Checks if the column is pinned to the left side.
   *
   * @return True if the column is pinned to the left side, false otherwise.
   */
  public boolean isLeftPin() {
    return PinDirection.LEFT.equals(direction);
  }

  /**
   * Checks if the column is pinned to the right side.
   *
   * @return True if the column is pinned to the right side, false otherwise.
   */
  public boolean isRightPin() {
    return PinDirection.RIGHT.equals(direction);
  }

  /**
   * Gets the meta key associated with PinColumnMeta.
   *
   * @return The meta key.
   */
  @Override
  public String getKey() {
    return PIN_COLUMN_META;
  }

  /**
   * Pins the specified column at the given position.
   *
   * @param column The column to be pinned.
   * @param position The position at which to pin the column.
   * @return The new position of the column after pinning.
   */
  @Override
  public double pin(ColumnConfig<?> column, double position) {
    return direction.pin(column, position);
  }

  /** Enumeration representing the pin direction for columns. */
  public enum PinDirection implements PinColumnFunction {
    LEFT(PinDirection::pinHeaderLeft),
    RIGHT(PinColumnMeta::pinHeaderRight);

    private PinColumnFunction pinColumnFunction;

    PinDirection(PinColumnFunction pinColumnFunction) {
      this.pinColumnFunction = pinColumnFunction;
    }

    /**
     * Pins the header of the column to the left.
     *
     * @param <T> The data type of the column.
     * @param column The column to be pinned.
     * @param left The position to pin the column.
     * @return The new position of the column after pinning.
     */
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

    /**
     * Pins a column to a specified position in a DataTable. Implementing classes must provide the
     * logic for pinning the column.
     *
     * @param column The column to be pinned.
     * @param position The position to pin the column.
     * @return The new position of the column after pinning.
     */
    @Override
    public double pin(ColumnConfig<?> column, double position) {
      return pinColumnFunction.pin(column, position);
    }
  }

  /**
   * Pins the header of the column to the right.
   *
   * @param <T> The data type of the column.
   * @param column The column to be pinned.
   * @param right The position to pin the column.
   * @return The new position of the column after pinning.
   */
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
