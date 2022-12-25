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
package org.dominokit.domino.ui.datatable.plugins.pincolumns;

import elemental2.dom.HTMLElement;
import java.util.List;
import java.util.Optional;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.ColumnHeaderMeta;
import org.dominokit.domino.ui.datatable.ColumnMeta;
import org.dominokit.domino.ui.utils.DominoElement;

public class PinColumnMeta implements ColumnMeta, PinColumnFunction, PinElementToColumn {

  public static final String dui_pinned_cell = "dui-pinned-cell";
  public static final String dui_pin_right_col = "dui-pin-right-col";
  public static final String dui_pin_left_col = "dui-pin-left-col";
  public static final String dui_pinned_left = "dui-pinned-left";
  public static final String dui_pinned_right = "dui-pinned-right";

  private final PinDirection direction;

  public static final String PIN_COLUMN_META = "pin-column-meta";

  public static PinColumnMeta left() {
    return new PinColumnMeta(PinDirection.LEFT);
  }

  public static PinColumnMeta right() {
    return new PinColumnMeta(PinDirection.RIGHT);
  }

  public static Optional<PinColumnMeta> get(ColumnConfig<?> column) {
    return column.getMeta(PIN_COLUMN_META);
  }

  public static boolean isPinLeft(ColumnConfig<?> column) {
    return PinColumnMeta.get(column).isPresent() && PinColumnMeta.get(column).get().isLeftPin();
  }

  public static boolean isPinRight(ColumnConfig<?> column) {
    return PinColumnMeta.get(column).isPresent() && PinColumnMeta.get(column).get().isRightPin();
  }

  public static boolean isPinned(ColumnConfig<?> column) {
    return !(PinColumnMeta.isPinLeft(column) || PinColumnMeta.isPinRight(column));
  }

  public PinColumnMeta(PinDirection direction) {
    this.direction = direction;
  }

  public boolean isLeftPin() {
    return PinDirection.LEFT.equals(direction);
  }

  public boolean isRightPin() {
    return PinDirection.RIGHT.equals(direction);
  }

  @Override
  public String getKey() {
    return PIN_COLUMN_META;
  }

  @Override
  public double pin(ColumnConfig<?> column, double position) {
    return direction.pin(column, position);
  }

  @Override
  public void pinElement(ColumnConfig<?> column, DominoElement<?> element) {
    direction.pinElement(column, element);
  }

  public static void clearPinningCss(DominoElement<?> element) {
    element.removeCss(dui_pinned_cell, dui_pin_left_col, dui_pin_right_col);
  }

  public enum PinDirection implements PinColumnFunction, PinElementToColumn {
    LEFT(
        PinDirection::pinHeaderLeft,
        (column, element) -> {
          element.addCss(dui_pinned_cell);
          if (column.getHeadElement().containsCss(dui_pin_left_col)) {
            element.addCss(dui_pin_left_col);
          } else {
            element.removeCss(dui_pin_left_col);
          }
          element.removeCss(dui_pin_right_col);
          element
              .setCssProperty("left", column.getHeadElement().getAttribute("pin-left-data") + "px")
              .setCssProperty("right", "auto");
        }),
    RIGHT(
        PinColumnMeta::pinHeaderRight,
        (column, element) -> {
          element.addCss(dui_pinned_cell);
          if (column.getHeadElement().containsCss(dui_pin_right_col)) {
            element.addCss(dui_pin_right_col);
          } else {
            element.removeCss(dui_pin_right_col);
          }
          element.removeCss(dui_pin_left_col);
          element
              .setCssProperty(
                  "right", column.getHeadElement().getAttribute("pin-right-data") + "px")
              .setCssProperty("left", "auto");
        });

    private PinColumnFunction pinColumnFunction;
    private PinElementToColumn pinElementToColumn;

    PinDirection(PinColumnFunction pinColumnFunction, PinElementToColumn pinElementToColumn) {
      this.pinColumnFunction = pinColumnFunction;
      this.pinElementToColumn = pinElementToColumn;
    }

    private static <T> double pinHeaderLeft(ColumnConfig<T> column, double left) {
      column.getHeadElement().addCss(dui_pinned_left);
      column.getHeadElement().setAttribute("pin-left-data", left);

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
      ColumnHeaderMeta.get(column)
          .ifPresent(
              meta ->
                  meta.getExtraHeadElements()
                      .forEach(
                          headElement -> {
                            headElement.addCss(dui_pinned_left);
                            column
                                .getHeadElement()
                                .hasCssClass(dui_pin_left_col)
                                .ifPresent(headElement::addCss);
                            pinElementLeft(headElement, left);
                          }));
      return pinElementLeft(column.getHeadElement(), left);
    }

    @Override
    public double pin(ColumnConfig<?> column, double position) {
      return pinColumnFunction.pin(column, position);
    }

    @Override
    public void pinElement(ColumnConfig<?> column, DominoElement<?> element) {
      pinElementToColumn.pinElement(column, element);
    }
  }

  private static double pinElementLeft(DominoElement<? extends HTMLElement> element, double left) {
    if (!element.containsCss(dui_pinned_cell)) {
      element.addCss(dui_pinned_cell);
    }
    element.setCssProperty("left", left + "px").setCssProperty("right", "auto");
    return left + element.getBoundingClientRect().width;
  }

  private static <T> double pinHeaderRight(ColumnConfig<T> column, double right) {
    column.getHeadElement().addCss(dui_pinned_right);
    column.getHeadElement().setAttribute("pin-right-data", right);
    if (column.isColumnGroup()) {
      double[] childOffset = new double[] {right};
      List<ColumnConfig<T>> subColumns = column.getSubColumns();
      for (int i = subColumns.size() - 1; i >= 0; i--) {
        ColumnConfig<?> subColumn = subColumns.get(i);
        subColumn.applyMeta(PinColumnMeta.get(column).get());
        childOffset[0] = pinHeaderRight(subColumn, childOffset[0]);
      }
    }
    ColumnHeaderMeta.get(column)
        .ifPresent(
            meta ->
                meta.getExtraHeadElements()
                    .forEach(
                        headElement -> {
                          headElement.addCss(dui_pinned_right);
                          column
                              .getHeadElement()
                              .hasCssClass(dui_pin_right_col)
                              .ifPresent(headElement::addCss);
                          pinElementRight(headElement, right);
                        }));
    return pinElementRight(column.getHeadElement(), right);
  }

  private static double pinElementRight(
      DominoElement<? extends HTMLElement> element, double right) {
    if (!element.containsCss(dui_pinned_cell)) {
      element.addCss(dui_pinned_cell);
    }
    element.setCssProperty("right", right + "px").setCssProperty("left", "auto");
    return right + element.getBoundingClientRect().width;
  }
}
