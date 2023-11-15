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

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.DomGlobal;
import java.util.List;
import jsinterop.base.Js;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.ColumnCssRuleMeta;
import org.dominokit.domino.ui.datatable.ColumnHeaderMeta;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.events.ColumnResizedEvent;
import org.dominokit.domino.ui.datatable.events.RowRecordUpdatedEvent;
import org.dominokit.domino.ui.datatable.events.TableBorderedEvent;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.datatable.plugins.DataTablePlugin;
import org.dominokit.domino.ui.datatable.plugins.HasPluginConfig;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.menu.MenuItem;
import org.dominokit.domino.ui.utils.DominoCSSRule;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.dominokit.domino.ui.utils.PrefixAddOn;

/**
 * This plugin allows users to pin specific columns to the right or left of a {@link
 * org.dominokit.domino.ui.datatable.DataTable}. Pinned columns remain fixed when scrolling
 * horizontally, making it easier to view important data while scrolling through a large dataset.
 *
 * <p>When you pin a column to the left, all columns to the left of the pinned column will also be
 * pinned to the left. Similarly, pinning a column to the right will cause all columns to the right
 * to be pinned to the right.
 *
 * <p>To pin a column to the left, use {@link
 * org.dominokit.domino.ui.datatable.plugins.column.PinColumnMeta#left()} when configuring the
 * column:
 *
 * <pre>
 * tableConfig.addColumn(ColumnConfig.create("name", "Label").applyMeta(PinColumnMeta.left()));
 * </pre>
 *
 * <p>To pin a column to the right, use {@link
 * org.dominokit.domino.ui.datatable.plugins.column.PinColumnMeta#right()}:
 *
 * <pre>
 * tableConfig.addColumn(ColumnConfig.create("name", "Label").applyMeta(PinColumnMeta.right()));
 * </pre>
 *
 * <p>This plugin provides the ability to configure the pinning behavior, including
 * enabling/disabling pinning icons and menus, and customizing the icon visuals.
 *
 * <p><strong>Customization:</strong> You can customize the pin icons using {@link
 * org.dominokit.domino.ui.icons.Icon} objects. By default, pin icons are taken from the {@link
 * org.dominokit.domino.ui.icons.lib.Icons} class.
 *
 * <p><strong>Pin Menu:</strong> This plugin provides an optional pinning menu that can be shown
 * when a column's header is right-clicked. The menu allows users to easily pin/unpin columns.
 *
 * <p>This plugin listens to various DataTable events such as column resizing and updates to ensure
 * that pinned columns stay in the correct position.
 *
 * <p><strong>Notes:</strong> - Pinning a column to the left will also pin all columns to the left
 * of that column. - Pinning a column to the right will also pin all columns to the right of that
 * column. - Pinned columns do not scroll horizontally with the table.
 *
 * @param <T> The type of data in the DataTable.
 * @see org.dominokit.domino.ui.datatable.plugins.column.PinColumnMeta
 * @see org.dominokit.domino.ui.icons.Icon
 * @see org.dominokit.domino.ui.icons.lib.Icons
 */
public class PinColumnsPlugin<T>
    implements DataTablePlugin<T>, HasPluginConfig<T, PinColumnsPlugin<T>, PinColumnsConfig> {

  /** The CSS rule applied to pinned columns. */
  public static final String PIN_COLUMNS_CSS_RULE = "PIN-COLUMNS-CSS-RULE";

  /** The DataTable instance to which this plugin is attached. */
  private DataTable<T> datatable;

  /** The icon used for pinning columns to the left. */
  private Icon<?> pinLeftIcon;

  /** The icon used for pinning columns to the right. */
  private Icon<?> pinRightIcon;

  /** The configuration for this plugin. */
  private PinColumnsConfig config = PinColumnsConfig.of();

  /** The currently pinned column to the left. */
  private ColumnConfig<T> pinLeftColumn;

  /** The currently pinned column to the right. */
  private ColumnConfig<T> pinRightColumn;

  /**
   * Initializes the PinColumnsPlugin for a specific DataTable instance.
   *
   * @param dataTable The DataTable to which this plugin is attached.
   */
  @Override
  public void init(DataTable<T> dataTable) {
    this.datatable = dataTable;
    this.pinLeftIcon = config.getPinLeftIcon().addCss(dui_order_100);
    this.pinRightIcon = config.getPinRightIcon().addCss(dui_order_100);

    datatable
        .getTableConfig()
        .getColumnsGrouped()
        .forEach(
            group ->
                group.applyAndOnSubColumns(
                    col -> {
                      ColumnCssRuleMeta.get(col)
                          .ifPresent(
                              meta -> {
                                meta.addRule(
                                    PIN_COLUMNS_CSS_RULE,
                                    "col-pin-" + col.getName().replace(" ", "_"));
                              });
                    }));
    this.datatable.onAttached(mutationRecord -> pinColumns());
  }

  /**
   * This method is called after headers are added to the DataTable. It handles pinning and
   * unpinning columns based on the configuration provided. It also sets the z-index of the header
   * element.
   *
   * @param dataTable The {@link DataTable} to which headers are added.
   */
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
                            .withValue("left")
                            .appendChild(PrefixAddOn.of(Icons.dock_left()))
                            .addSelectionHandler(
                                value -> {
                                  setPinLeftColumn(column);
                                  applyPinnedColumns();
                                }))
                    .appendChild(
                        MenuItem.<String>create(config.getPinRightText())
                            .withValue("right")
                            .appendChild(PrefixAddOn.of(Icons.dock_right()))
                            .addSelectionHandler(
                                value -> {
                                  setPinRightColumn(column);
                                  applyPinnedColumns();
                                }))
                    .appendChild(
                        MenuItem.<String>create(config.getUnpinText())
                            .withValue("right")
                            .appendChild(PrefixAddOn.of(Icons.pin_off()))
                            .addSelectionHandler(
                                value -> {
                                  unpinColumn(column);
                                }));
              }
            });

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

    this.datatable.headerElement().setZIndex(2);
  }

  private void onBeforeSetPinColumn() {
    datatable
        .getTableConfig()
        .getColumnsGrouped()
        .forEach(
            group ->
                group.applyAndOnSubColumns(
                    column -> {
                      ColumnCssRuleMeta.get(column)
                          .flatMap(cssMeta -> cssMeta.getColumnCssRule(PIN_COLUMNS_CSS_RULE))
                          .ifPresent(
                              pinCssRule -> {
                                pinCssRule.getCssRule().removeProperty("position");
                                pinCssRule.getCssRule().removeProperty("z-index");
                              });
                      column.getHeadElement().removeCssProperty("z-index");
                      ColumnHeaderMeta.get(column)
                          .ifPresent(
                              columnHeaderMeta -> {
                                columnHeaderMeta
                                    .getExtraHeadElements()
                                    .forEach(element -> element.removeCssProperty("z-index"));
                              });
                    }));

    datatable.getDynamicStyleSheet().flush();
  }

  /**
   * Sets the right pin for the specified column and updates the pinned columns accordingly.
   *
   * @param pinRightColumn The {@link ColumnConfig} to be pinned on the right.
   */
  public void setPinRightColumn(ColumnConfig<T> pinRightColumn) {
    this.datatable.nowOrWhenAttached(
        () -> {
          onBeforeSetPinColumn();
          PinColumnMeta.get(pinRightColumn)
              .ifPresent(
                  meta -> {
                    if (meta.isLeftPin()) {
                      unpinLeftColumns();
                    }
                  });

          if (config.isShowPinIcon()) {
            pinRightColumn.getGrandParent().removeChild(pinLeftIcon).appendChild(pinRightIcon);
          }

          pinColumnsRight(pinRightColumn);
        });
  }

  /**
   * Unpins the specified column. If the column is pinned on the left, it will unpin left columns;
   * if it is pinned on the right, it will unpin right columns.
   *
   * @param column The {@link ColumnConfig} to be unpinned.
   */
  public void unpinColumn(ColumnConfig<T> column) {
    if (PinColumnMeta.isPinLeft(column)) {
      unpinLeftColumns();
    }

    if (PinColumnMeta.isPinRight(column)) {
      unpinRightColumns();
    }
  }

  /** Unpins all left-pinned columns. */
  public void unpinLeftColumns() {
    onBeforeSetPinColumn();
    datatable.getTableConfig().getColumnsGrouped().stream()
        .filter(PinColumnMeta::isPinLeft)
        .forEach(
            col ->
                col.applyAndOnSubColumns(
                    column -> column.removeMeta(PinColumnMeta.PIN_COLUMN_META)));
    pinLeftIcon.remove();
    applyPinnedColumns();
  }

  /** Unpins all right-pinned columns. */
  public void unpinRightColumns() {
    onBeforeSetPinColumn();
    datatable.getTableConfig().getColumnsGrouped().stream()
        .filter(PinColumnMeta::isPinRight)
        .forEach(
            col ->
                col.applyAndOnSubColumns(
                    column -> column.removeMeta(PinColumnMeta.PIN_COLUMN_META)));
    pinRightIcon.remove();
    applyPinnedColumns();
  }

  /**
   * Sets the left pin for the specified column and updates the pinned columns accordingly.
   *
   * @param pinLeftColumn The {@link ColumnConfig} to be pinned on the left.
   */
  public void setPinLeftColumn(ColumnConfig<T> pinLeftColumn) {
    this.datatable.nowOrWhenAttached(
        () -> {
          onBeforeSetPinColumn();
          PinColumnMeta.get(pinLeftColumn)
              .ifPresent(
                  meta -> {
                    if (meta.isRightPin()) {
                      unpinRightColumns();
                    }
                  });

          if (config.isShowPinIcon()) {
            pinLeftColumn.getGrandParent().removeChild(pinRightIcon).appendChild(pinLeftIcon);
          }
          pinColumnsLeft(pinLeftColumn);
        });
  }

  /**
   * Pins columns on the left side based on the provided pinned column configuration.
   *
   * @param pinLeftColumn The {@link ColumnConfig} to be pinned on the left.
   */
  private void pinColumnsLeft(ColumnConfig<T> pinLeftColumn) {
    List<ColumnConfig<T>> columns = datatable.getTableConfig().getColumnsGrouped();
    int columnIndex = columns.indexOf(pinLeftColumn.getGrandParent());
    if (nonNull(this.pinLeftColumn)) {
      this.pinLeftColumn
          .getGrandParent()
          .applyAndOnSubColumns(
              column -> {
                ColumnCssRuleMeta.get(column)
                    .flatMap(cssMeta -> cssMeta.getColumnCssRule(PIN_COLUMNS_CSS_RULE))
                    .ifPresent(
                        pinCssRule -> {
                          DominoCSSRule style = pinCssRule.getCssRule();
                          style.removeProperty("border-left");
                          style.removeProperty("border-right");
                        });
              });
    }

    this.pinLeftColumn = pinLeftColumn;
    this.pinLeftColumn
        .getGrandParent()
        .applyAndOnEachLastSubColumn(
            column -> {
              ColumnCssRuleMeta.get(column)
                  .flatMap(cssMeta -> cssMeta.getColumnCssRule(PIN_COLUMNS_CSS_RULE))
                  .ifPresent(
                      pinCssRule -> {
                        DominoCSSRule style = pinCssRule.getCssRule();
                        style.setProperty(
                            "border-right",
                            "1px solid var(--dui-datatable-pin-column-border-color)");
                        style.removeProperty("border-left");
                      });
            });
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

  /**
   * Pins columns on the right side based on the provided pinned column configuration.
   *
   * @param pinRightColumn The {@link ColumnConfig} to be pinned on the right.
   */
  private void pinColumnsRight(ColumnConfig<T> pinRightColumn) {
    List<ColumnConfig<T>> columns = datatable.getTableConfig().getColumnsGrouped();
    int columnIndex = columns.indexOf(pinRightColumn.getGrandParent());
    if (nonNull(this.pinRightColumn)) {
      this.pinRightColumn
          .getGrandParent()
          .applyAndOnSubColumns(
              column -> {
                ColumnCssRuleMeta.get(column)
                    .flatMap(cssMeta -> cssMeta.getColumnCssRule(PIN_COLUMNS_CSS_RULE))
                    .ifPresent(
                        pinCssRule -> {
                          DominoCSSRule style = pinCssRule.getCssRule();
                          style.removeProperty("border-left");
                          style.removeProperty("border-right");
                        });
              });
    }
    this.pinRightColumn = pinRightColumn;
    this.pinRightColumn
        .getGrandParent()
        .applyAndOnEachFirstSubColumn(
            column -> {
              ColumnCssRuleMeta.get(column)
                  .flatMap(cssMeta -> cssMeta.getColumnCssRule(PIN_COLUMNS_CSS_RULE))
                  .ifPresent(
                      pinCssRule -> {
                        DominoCSSRule style = pinCssRule.getCssRule();
                        style.setProperty("border-left", "1px solid #ddd");
                        style.removeProperty("border-right");
                      });
            });

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

  /**
   * Handles the given {@link org.dominokit.domino.ui.datatable.events.TableEvent} by applying
   * pinned columns when certain events occur. This method listens for events such as table border
   * updates, record updates, and column resizing to ensure pinned columns remain correctly
   * positioned.
   *
   * @param event The {@link org.dominokit.domino.ui.datatable.events.TableEvent} to handle.
   */
  @Override
  public void handleEvent(TableEvent event) {
    switch (event.getType()) {
      case TableBorderedEvent.TABLE_BORDERED_EVENT:
      case RowRecordUpdatedEvent.RECORD_UPDATED:
        applyPinnedColumns();
        break;
      case ColumnResizedEvent.COLUMN_RESIZED:
        ColumnResizedEvent columnResizedEvent = Js.uncheckedCast(event);
        ColumnConfig<?> column = columnResizedEvent.getColumn();
        if (PinColumnMeta.isPinned(column)) {
          if (columnResizedEvent.getSizeDiff() > 0) {
            if (columnResizedEvent.isCompleted()) {
              applyPinnedColumns();
            }
          } else {
            applyPinnedColumns();
          }
        }

        break;
    }
  }

  /**
   * Applies pinned columns when all rows are added to the DataTable.
   *
   * @param dataTable The DataTable to which this plugin is attached.
   */
  @Override
  public void onAllRowsAdded(DataTable<T> dataTable) {
    applyPinnedColumns();
  }

  /**
   * Applies pinned columns to the DataTable. This method is called to ensure that pinned columns
   * stay in the correct position.
   */
  private void applyPinnedColumns() {
    pinColumns();
  }

  /**
   * Pins columns based on the current configuration and DataTable state. This method is responsible
   * for determining which columns to pin and updating their positions.
   */
  private void pinColumns() {
    onBeforeSetPinColumn();
    if (datatable.isAttached()) {
      pinColumnsForAttachedTable();
    } else {
      datatable.onAttached(
          mutationRecord -> DomGlobal.setTimeout(p0 -> pinColumnsForAttachedTable()));
    }
  }

  /**
   * Pins columns for a DataTable that is currently attached to the DOM. This method calculates the
   * positions of pinned columns and ensures they remain correctly positioned.
   */
  private void pinColumnsForAttachedTable() {
    ElementUtil.withBodyObserverPaused(
        () -> {
          DomGlobal.requestAnimationFrame(
              timestamp -> {
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

                List<ColumnConfig<T>> groupedColumns =
                    datatable.getTableConfig().getColumnsGrouped();
                for (int i = groupedColumns.size() - 1; i >= 0; i--) {
                  ColumnConfig<T> column = groupedColumns.get(i);
                  if (PinColumnMeta.isPinRight(column)) {
                    rightHeaderOffset[0] =
                        PinColumnMeta.get(column).get().pin(column, rightHeaderOffset[0]);
                  }
                }
                this.datatable.getDynamicStyleSheet().flush();
              });
        });
  }

  /**
   * Sets the configuration for this plugin.
   *
   * @param config The {@link PinColumnsConfig} configuration to set.
   * @return This {@link PinColumnsPlugin} instance for method chaining.
   */
  @Override
  public PinColumnsPlugin<T> setConfig(PinColumnsConfig config) {
    this.config = config;
    return this;
  }

  /**
   * Retrieves the current configuration for this plugin.
   *
   * @return The current {@link PinColumnsConfig} configuration.
   */
  @Override
  public PinColumnsConfig getConfig() {
    return config;
  }
}
