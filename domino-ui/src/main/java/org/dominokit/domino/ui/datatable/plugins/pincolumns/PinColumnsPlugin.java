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

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLTableCellElement;
import java.util.List;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.RowCell;
import org.dominokit.domino.ui.datatable.events.ColumnResizedEvent;
import org.dominokit.domino.ui.datatable.events.RowRecordUpdatedEvent;
import org.dominokit.domino.ui.datatable.events.TableBorderedEvent;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.datatable.plugins.DataTablePlugin;
import org.dominokit.domino.ui.datatable.plugins.HasPluginConfig;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.menu.MenuItem;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.ElementUtil;

/**
 * This plugin allow the user to pin a specific column or columns to the right or left of the table.
 * pinned columns will not scroll horizontally with the table.
 *
 * <p>pinning a column to the left will also pin all columns that are to the left of that column to
 * left too pinning a column to the right will also pin all columns that are to the right of that
 * column to the right. pinning a column in a column group will pin all columns in that group.
 *
 * <p>to pin a column to the left apply a {@link PinColumnMeta} to the column with left direction
 *
 * <pre>
 *     <code>
 *     tableConfig.addColumn(ColumnConfig.create("name", "label").applyMeta(PinColumnMeta.left()))
 *     </code>
 * </pre>
 *
 * to pin a column to the left apply a {@link PinColumnMeta} to the column with right direction
 *
 * <pre>
 *     <code>
 *     tableConfig.addColumn(ColumnConfig.create("name", "label").applyMeta(PinColumnMeta.right()))
 *     </code>
 * </pre>
 *
 * The pin menu and pin icon are both configurable and are disabled by default.
 *
 * @param <T>
 */
public class PinColumnsPlugin<T>
    implements DataTablePlugin<T>, HasPluginConfig<T, PinColumnsPlugin<T>, PinColumnsConfig> {

  public static final String dui_pinned_cell = "dui-pinned-cell";
  public static final String dui_pin_right_col = "dui-pin-right-col";
  public static final String dui_pin_left_col = "dui-pin-left-col";
  public static final String dui_pinned_left = "dui-pinned-left";
  public static final String dui_pinned_right = "dui-pinned-right";
  private DataTable<T> datatable;

  private FlexItem<?> pinLeftIcon;
  private FlexItem<?> pinRightIcon;
  private PinColumnsConfig config = PinColumnsConfig.of();

  @Override
  public void init(DataTable<T> dataTable) {
    this.datatable = dataTable;
    this.pinLeftIcon = FlexItem.of(config.getPinLeftIcon()).setOrder(100);
    this.pinRightIcon = FlexItem.of(config.getPinRightIcon()).setOrder(100);
  }

  @Override
  public void onAfterAddHeaders(DataTable<T> dataTable) {
    dataTable
        .getTableConfig()
        .getColumnsGrouped()
        .forEach(
            column -> {
              if (config.isShowPinMenu()) {
                column
                    .getMenu()
                    .appendChild(
                        MenuItem.<String>create(config.getPinLeftText())
                            .setValue("left")
                            .addLeftAddOn(FlexItem.of(Icons.ALL.dock_left_mdi()))
                            .addSelectionHandler(
                                value -> {
                                  setPinLeftColumn(column);
                                  applyPinnedColumns();
                                }))
                    .appendChild(
                        MenuItem.<String>create(config.getPinRightText())
                            .setValue("right")
                            .addLeftAddOn(FlexItem.of(Icons.ALL.dock_right_mdi()))
                            .addSelectionHandler(
                                value -> {
                                  setPinRightColumn(column);
                                  applyPinnedColumns();
                                }))
                    .appendChild(
                        MenuItem.<String>create(config.getUnpinText())
                            .setValue("right")
                            .addLeftAddOn(FlexItem.of(Icons.ALL.pin_off_mdi()))
                            .addSelectionHandler(
                                value -> {
                                  unpinColumn(column);
                                }));
              }
            });

    onBeforeSetPinColumn();
    List<ColumnConfig<T>> columns = datatable.getTableConfig().getColumns();
    columns.stream()
        .filter(PinColumnMeta::isPinLeft)
        .reduce((first, second) -> second)
        .ifPresent(this::setPinLeftColumn);

    columns.stream()
        .filter(PinColumnMeta::isPinRight)
        .findFirst()
        .ifPresent(this::setPinRightColumn);
    dataTable.onResize((element, observer, entries) -> applyPinnedColumns());
  }

  private void onBeforeSetPinColumn() {
    datatable
        .headerElement()
        .querySelectorAll("." + dui_pinned_cell + ",." + dui_pinned_left + ",." + dui_pinned_right)
        .forEach(element -> element.removeCss(dui_pinned_cell, dui_pinned_left, dui_pinned_right));
  }

  public void setPinRightColumn(ColumnConfig<T> pinRightColumn) {
    onBeforeSetPinColumn();
    PinColumnMeta.get(pinRightColumn)
        .ifPresent(
            meta -> {
              if (meta.isLeftPin()) {
                unpinLeftColumns();
              }
            });

    datatable
        .headerElement()
        .querySelectorAll("." + dui_pin_right_col)
        .forEach(element -> element.removeCss(dui_pin_right_col));
    if (config.isShowPinIcon()) {
      pinRightColumn.getGrandParent().removeChild(pinLeftIcon).appendChild(pinRightIcon);
    }
    pinRightColumn
        .getGrandParent()
        .applyAndOnFirstSubColumn(col -> col.getHeadElement().addCss(dui_pin_right_col));
    pinColumnsRight(pinRightColumn);
  }

  public void unpinColumn(ColumnConfig<T> column) {
    if (PinColumnMeta.isPinLeft(column)) {
      unpinLeftColumns();
    }

    if (PinColumnMeta.isPinRight(column)) {
      unpinRightColumns();
    }
  }

  public void unpinLeftColumns() {
    onBeforeSetPinColumn();
    datatable
        .headerElement()
        .querySelectorAll("." + dui_pin_left_col + ",." + dui_pinned_left)
        .forEach(element -> element.removeCss(dui_pin_left_col, dui_pinned_left));
    datatable.getTableConfig().getColumnsGrouped().stream()
        .filter(PinColumnMeta::isPinLeft)
        .forEach(
            col ->
                col.applyAndOnSubColumns(
                    column -> column.removeMeta(PinColumnMeta.PIN_COLUMN_META)));
    pinLeftIcon.remove();
    applyPinnedColumns();
  }

  public void unpinRightColumns() {
    onBeforeSetPinColumn();
    datatable
        .headerElement()
        .querySelectorAll("." + dui_pin_right_col + ",." + dui_pinned_right)
        .forEach(element -> element.removeCss(dui_pin_right_col, dui_pinned_right));
    datatable.getTableConfig().getColumnsGrouped().stream()
        .filter(PinColumnMeta::isPinRight)
        .forEach(
            col ->
                col.applyAndOnSubColumns(
                    column -> column.removeMeta(PinColumnMeta.PIN_COLUMN_META)));
    pinRightIcon.remove();
    applyPinnedColumns();
  }

  public void setPinLeftColumn(ColumnConfig<T> pinLeftColumn) {
    onBeforeSetPinColumn();
    PinColumnMeta.get(pinLeftColumn)
        .ifPresent(
            meta -> {
              if (meta.isRightPin()) {
                unpinRightColumns();
              }
            });
    datatable
        .headerElement()
        .querySelectorAll("." + dui_pin_left_col)
        .forEach(element -> element.removeCss(dui_pin_left_col));
    if (config.isShowPinIcon()) {
      pinLeftColumn.getGrandParent().removeChild(pinRightIcon).appendChild(pinLeftIcon);
    }
    pinLeftColumn
        .getGrandParent()
        .applyAndOnLastSubColumn(col -> col.getHeadElement().addCss(dui_pin_left_col));
    pinColumnsLeft(pinLeftColumn);
  }

  private void pinColumnsLeft(ColumnConfig<T> pinLeftColumn) {
    List<ColumnConfig<T>> columns = datatable.getTableConfig().getColumnsGrouped();
    int columnIndex = columns.indexOf(pinLeftColumn.getGrandParent());
    for (int i = 0; i <= columnIndex; i++) {
      columns.get(i).applyAndOnSubColumns(column -> column.applyMeta(PinColumnMeta.left()));
    }
    for (int i = columnIndex + 1; i < columns.size(); i++) {
      columns
          .get(i)
          .applyAndOnSubColumns(
              column -> {
                if (PinColumnMeta.isPinLeft(column)) {
                  column.removeMeta(PinColumnMeta.PIN_COLUMN_META);
                }
              });
    }
  }

  private void pinColumnsRight(ColumnConfig<T> pinRightColumn) {
    List<ColumnConfig<T>> columns = datatable.getTableConfig().getColumnsGrouped();
    int columnIndex = columns.indexOf(pinRightColumn.getGrandParent());
    for (int i = 0; i < columnIndex; i++) {
      columns
          .get(i)
          .applyAndOnSubColumns(
              column -> {
                if (PinColumnMeta.isPinRight(column)) {
                  column.removeMeta(PinColumnMeta.PIN_COLUMN_META);
                }
              });
    }
    for (int i = columnIndex; i < columns.size(); i++) {
      columns.get(i).applyAndOnSubColumns(column -> column.applyMeta(PinColumnMeta.right()));
    }
  }

  @Override
  public void handleEvent(TableEvent event) {
    switch (event.getType()) {
      case TableBorderedEvent.TABLE_BORDERED_EVENT:
      case RowRecordUpdatedEvent.RECORD_UPDATED:
        applyPinnedColumns();
        break;
      case ColumnResizedEvent.COLUMN_RESIZED:
        DomGlobal.requestAnimationFrame(
            timestamp -> {
              applyPinnedColumns();
            });
        break;
    }
  }

  @Override
  public void onAllRowsAdded(DataTable<T> dataTable) {
    applyPinnedColumns();
  }

  private void applyPinnedColumns() {
    pinColumns();
  }

  private void pinColumns() {
    if (datatable.isAttached()) {
      pinColumnsForAttachedTable();
    } else {
      datatable.onAttached(
          mutationRecord -> DomGlobal.setTimeout(p0 -> pinColumnsForAttachedTable()));
    }
  }

  private void pinColumnsForAttachedTable() {
    ElementUtil.withBodyObserverPaused(
        () -> {
          double[] leftHeaderOffset = new double[] {0};
          double[] rightHeaderOffset = new double[] {0};
          datatable
              .getTableConfig()
              .getColumnsGrouped()
              .forEach(
                  column -> {
                    if (PinColumnMeta.isPinLeft(column)) {
                      leftHeaderOffset[0] =
                          PinColumnMeta.get(column).get().pin(column, leftHeaderOffset[0]);
                    }
                  });

          List<ColumnConfig<T>> groupedColumns = datatable.getTableConfig().getColumnsGrouped();
          for (int i = groupedColumns.size() - 1; i >= 0; i--) {
            ColumnConfig<T> column = groupedColumns.get(i);
            if (PinColumnMeta.isPinRight(column)) {
              rightHeaderOffset[0] =
                  PinColumnMeta.get(column).get().pin(column, rightHeaderOffset[0]);
            }
          }
          List<ColumnConfig<T>> columns = datatable.getTableConfig().getColumns();

          datatable
              .getRows()
              .forEach(
                  tableRow -> {
                    for (int i = 0; i < columns.size(); i++) {
                      ColumnConfig<T> column = columns.get(i);
                      RowCell<T> cell = tableRow.getCell(column.getName());
                      DominoElement<HTMLTableCellElement> td =
                          DominoElement.of(cell.getCellInfo().getElement());
                      DominoElement<HTMLTableCellElement> th =
                          cell.getColumnConfig().getHeadElement();

                      if (PinColumnMeta.get(column).isPresent()) {
                        PinColumnMeta.get(column).get().pinElement(column, td);
                      } else {
                        PinColumnMeta.clearPinningCss(td);
                      }
                    }
                  });
        });
  }

  /**
   * Set the configuration for this plugin instance
   *
   * @param config {@link PinColumnsConfig}
   * @return same plugion instance
   */
  @Override
  public PinColumnsPlugin<T> setConfig(PinColumnsConfig config) {
    this.config = config;
    return this;
  }

  @Override
  public PinColumnsConfig getConfig() {
    return config;
  }
}
