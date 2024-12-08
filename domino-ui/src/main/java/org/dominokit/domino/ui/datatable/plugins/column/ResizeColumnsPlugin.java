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

import static org.dominokit.domino.ui.datatable.DataTableStyles.dui_column_resizer;
import static org.dominokit.domino.ui.utils.Domino.*;
import static org.dominokit.domino.ui.utils.Unit.px;

import elemental2.dom.DomGlobal;
import elemental2.dom.EventListener;
import elemental2.dom.MouseEvent;
import jsinterop.base.Js;
import org.dominokit.domino.ui.datatable.*;
import org.dominokit.domino.ui.datatable.events.ColumnResizedEvent;
import org.dominokit.domino.ui.datatable.events.ColumnResizingEvent;
import org.dominokit.domino.ui.datatable.plugins.DataTablePlugin;
import org.dominokit.domino.ui.datatable.plugins.HasPluginConfig;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.events.EventType;
import org.dominokit.domino.ui.utils.DominoCSSRule;
import org.dominokit.domino.ui.utils.DominoDom;

/**
 * A DataTable plugin that allows users to resize column widths via drag-and-drop.
 *
 * @param <T> The data type of the DataTable.
 */
public class ResizeColumnsPlugin<T>
    implements DataTablePlugin<T>, HasPluginConfig<T, ResizeColumnsPlugin<T>, ResizeColumnsConfig> {

  private ResizeColumnsConfig config = new ResizeColumnsConfig();
  private DataTable<T> datatable;

  private ColumnConfig<T> resizingColumn;
  private boolean resizing = false;

  /**
   * Initializes the plugin and prepares columns for resizing.
   *
   * @param dataTable The DataTable to which this plugin is applied.
   */
  @Override
  public void init(DataTable<T> dataTable) {
    this.datatable = dataTable;
    dataTable
        .getTableConfig()
        .getColumnsGrouped()
        .forEach(
            column ->
                column.applyAndOnSubColumns(
                    col -> {
                      if (!ResizeColumnMeta.get(col).isPresent()) {
                        col.applyMeta(ResizeColumnMeta.create());
                      }

                      ResizeColumnMeta.get(col)
                          .ifPresent(
                              meta -> {
                                meta.setOriginalWidth(col.getWidth());
                                meta.setOriginalMinWidth(col.getMinWidth());
                                meta.setOriginalMaxWidth(col.getMaxWidth());
                              });
                    }));
  }

  /**
   * Handles the addition of a header to the DataTable and enables column resizing via
   * drag-and-drop.
   *
   * @param dataTable The DataTable to which the header is added.
   * @param column The ColumnConfig representing the column to which the header is added.
   */
  @Override
  public void onHeaderAdded(DataTable<T> dataTable, ColumnConfig<T> column) {
    ResizeColumnMeta.get(column)
        .ifPresent(
            resizeColumnMeta -> {
              if (resizeColumnMeta.isResizable()) {
                DivElement resizeElement =
                    elements
                        .div()
                        .addCss(dui_column_resizer)
                        .addClickListener(
                            evt -> {
                              evt.stopPropagation();
                              evt.preventDefault();
                            });
                EventListener resizeListener =
                    evt -> {
                      MouseEvent mouseEvent = Js.uncheckedCast(evt);
                      column.applyAndOnParents(
                          col -> {
                            ResizeColumnMeta.get(col)
                                .ifPresent(
                                    meta -> {
                                      double currentPosition = mouseEvent.clientX;
                                      double diff = currentPosition - meta.getStartPosition();
                                      resizeColumn(col, meta, diff);
                                    });
                          });

                      column.onEachLastSubColumn(
                          col -> {
                            ResizeColumnMeta.get(col)
                                .ifPresent(
                                    meta -> {
                                      double currentPosition = mouseEvent.clientX;
                                      double diff = currentPosition - meta.getStartPosition();
                                      resizeColumn(col, meta, diff);
                                    });
                          });

                      ColumnConfig<T> dataColumn = column.getLastGrandSiblingColumn();
                      ResizeColumnMeta.get(dataColumn)
                          .ifPresent(
                              meta -> {
                                double currentPosition = mouseEvent.clientX;
                                double diff = currentPosition - meta.getStartPosition();

                                dataTable.fireTableEvent(ColumnResizingEvent.of(column, diff));
                              });
                    };

                resizeElement.addEventListener(
                    EventType.mousedown.getName(),
                    evt -> {
                      MouseEvent mouseEvent = Js.uncheckedCast(evt);
                      if (mouseEvent.buttons == 1) {
                        mouseEvent.stopPropagation();
                        mouseEvent.preventDefault();
                        this.resizingColumn = column;
                        this.resizing = true;
                        column
                            .getGrandParent()
                            .applyAndOnSubColumns(
                                col ->
                                    ResizeColumnMeta.get(col)
                                        .ifPresent(
                                            meta ->
                                                meta.setInitialWidth(
                                                        col.getHeadElement()
                                                            .getBoundingClientRect()
                                                            .width)
                                                    .setStartPosition(mouseEvent.clientX)));
                        DominoDom.document.body.addEventListener(
                            EventType.mousemove.getName(), resizeListener);
                      }
                    });
                EventListener stopResizing =
                    evt -> {
                      evt.stopPropagation();
                      if (column.equals(this.resizingColumn) && resizing) {
                        this.resizing = false;
                        ResizeColumnMeta.get(column)
                            .ifPresent(
                                meta -> {
                                  MouseEvent mouseEvent = Js.uncheckedCast(evt);
                                  double currentPosition = mouseEvent.clientX;
                                  double diff = currentPosition - meta.getStartPosition();

                                  dataTable.fireTableEvent(
                                      ColumnResizedEvent.of(column, diff, true));
                                });

                        DominoDom.document.body.removeEventListener(
                            EventType.mousemove.getName(), resizeListener);
                      }
                    };

                this.datatable.onAttached(
                    (e, mutationRecord) -> {
                      DominoDom.document.body.addEventListener(
                          EventType.mouseup.getName(), stopResizing);
                    });
                this.datatable.onDetached(
                    (e, mutationRecord) -> {
                      resizeElement.removeEventListener(EventType.mouseup.getName(), stopResizing);
                      DominoDom.document.body.removeEventListener(
                          EventType.mouseup.getName(), stopResizing);
                    });
                column.appendChild(resizeElement);
              }
            });
  }

  /**
   * Resizes the specified column with the given metadata and difference value.
   *
   * @param col The ColumnConfig to resize.
   * @param meta The ResizeColumnMeta containing column resize metadata.
   * @param diff The difference in width to apply to the column.
   */
  private void resizeColumn(ColumnConfig<T> col, ResizeColumnMeta meta, double diff) {
    DomGlobal.requestAnimationFrame(
        timestamp -> {
          double widthValue = meta.getInitialWidth() + diff;
          if (widthValue >= 20) {
            String width = px.of(widthValue);

            col.setWidth(width);

            String minWidth = meta.suppliedMinWidthOrOriginal(width);

            if (config.isClipContent()) {
              String maxWidth = meta.suppliedMaxWidthOrOriginal(width);
              col.maxWidth(maxWidth);
              ColumnCssRuleMeta.get(col)
                  .flatMap(cssMeta -> cssMeta.getColumnCssRule(ColumnCssRuleMeta.DEFAULT_RULE))
                  .ifPresent(
                      columnCssRule ->
                          columnCssRule.getCssRule().setProperty("max-width", maxWidth));
            }

            ColumnCssRuleMeta.get(col)
                .flatMap(cssMeta -> cssMeta.getColumnCssRule(ColumnCssRuleMeta.DEFAULT_RULE))
                .ifPresent(
                    columnCssRule -> {
                      DominoCSSRule style = columnCssRule.getCssRule();
                      style.setProperty("min-width", minWidth);
                      style.setProperty("width", width);
                    });

            ColumnHeaderMeta.get(col)
                .ifPresent(
                    headersMeta ->
                        headersMeta
                            .getExtraHeadElements()
                            .forEach(header -> header.setWidth(width)));
            datatable.getDynamicStyleSheet().flush();
          }
        });
  }

  /**
   * Handles actions before adding a cell to the DataTable.
   *
   * @param dataTable The DataTable.
   * @param tableRow The TableRow where the cell is added.
   * @param rowCell The RowCell to be added.
   */
  @Override
  public void onBeforeAddCell(DataTable<T> dataTable, TableRow<T> tableRow, RowCell<T> rowCell) {
    if (config.isClipContent()) {
      elements.elementOf(rowCell.getCellInfo().getElement()).addCss(dui_text_ellipsis);
    }
  }

  /**
   * Sets the configuration for the ResizeColumnsPlugin.
   *
   * @param config The ResizeColumnsConfig to set.
   * @return The ResizeColumnsPlugin instance.
   */
  @Override
  public ResizeColumnsPlugin<T> setConfig(ResizeColumnsConfig config) {
    this.config = config;
    return this;
  }

  /**
   * Gets the current configuration of the ResizeColumnsPlugin.
   *
   * @return The current ResizeColumnsConfig.
   */
  @Override
  public ResizeColumnsConfig getConfig() {
    return config;
  }
}
