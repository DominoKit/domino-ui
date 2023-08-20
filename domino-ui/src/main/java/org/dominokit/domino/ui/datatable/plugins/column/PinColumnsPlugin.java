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
 * This plugin allow the user to pin a specific column or columns to the right or left of the table.
 * pinned columns will not scroll horizontally with the table.
 *
 * <p>pinning a column to the left will also pin all columns that are to the left of that column to
 * left too pinning a column to the right will also pin all columns that are to the right of that
 * column to the right. pinning a column in a column group will pin all columns in that group.
 *
 * <p>to pin a column to the left apply a {@link
 * org.dominokit.domino.ui.datatable.plugins.column.PinColumnMeta} to the column with left direction
 *
 * <pre>
 *     <code>
 *     tableConfig.addColumn(ColumnConfig.create("name", "label").applyMeta(PinColumnMeta.left()))
 *     </code>
 * </pre>
 *
 * <p>to pin a column to the left apply a {@link
 * org.dominokit.domino.ui.datatable.plugins.column.PinColumnMeta} to the column with right
 * direction
 *
 * <pre>
 *     <code>
 *     tableConfig.addColumn(ColumnConfig.create("name", "label").applyMeta(PinColumnMeta.right()))
 *     </code>
 * </pre>
 *
 * <p>The pin menu and pin icon are both configurable and are disabled by default.
 *
 * @param <T>
 */
public class PinColumnsPlugin<T>
    implements DataTablePlugin<T>, HasPluginConfig<T, PinColumnsPlugin<T>, PinColumnsConfig> {

  /** Constant <code>PIN_COLUMNS_CSS_RULE="PIN-COLUMNS-CSS-RULE"</code> */
  public static final String PIN_COLUMNS_CSS_RULE = "PIN-COLUMNS-CSS-RULE";

  private DataTable<T> datatable;

  private Icon<?> pinLeftIcon;
  private Icon<?> pinRightIcon;
  private PinColumnsConfig config = PinColumnsConfig.of();

  private ColumnConfig<T> pinLeftColumn;
  private ColumnConfig<T> pinRightColumn;

  /** {@inheritDoc} */
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

  /** {@inheritDoc} */
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
   * Setter for the field <code>pinRightColumn</code>.
   *
   * @param pinRightColumn a {@link org.dominokit.domino.ui.datatable.ColumnConfig} object
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
   * unpinColumn.
   *
   * @param column a {@link org.dominokit.domino.ui.datatable.ColumnConfig} object
   */
  public void unpinColumn(ColumnConfig<T> column) {
    if (PinColumnMeta.isPinLeft(column)) {
      unpinLeftColumns();
    }

    if (PinColumnMeta.isPinRight(column)) {
      unpinRightColumns();
    }
  }

  /** unpinLeftColumns. */
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

  /** unpinRightColumns. */
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
   * Setter for the field <code>pinLeftColumn</code>.
   *
   * @param pinLeftColumn a {@link org.dominokit.domino.ui.datatable.ColumnConfig} object
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

  /** {@inheritDoc} */
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

  /** {@inheritDoc} */
  @Override
  public void onAllRowsAdded(DataTable<T> dataTable) {
    applyPinnedColumns();
  }

  private void applyPinnedColumns() {
    pinColumns();
  }

  private void pinColumns() {
    onBeforeSetPinColumn();
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
   * {@inheritDoc}
   *
   * <p>Set the configuration for this plugin instance
   */
  @Override
  public PinColumnsPlugin<T> setConfig(PinColumnsConfig config) {
    this.config = config;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public PinColumnsConfig getConfig() {
    return config;
  }
}
