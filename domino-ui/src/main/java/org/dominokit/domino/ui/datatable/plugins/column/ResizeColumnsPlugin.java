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
import static org.dominokit.domino.ui.utils.Unit.px;

import elemental2.dom.DomGlobal;
import elemental2.dom.EventListener;
import elemental2.dom.MouseEvent;
import jsinterop.base.Js;
import org.dominokit.domino.ui.datatable.*;
import org.dominokit.domino.ui.datatable.events.ColumnResizedEvent;
import org.dominokit.domino.ui.datatable.plugins.DataTablePlugin;
import org.dominokit.domino.ui.datatable.plugins.HasPluginConfig;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.events.EventType;
import org.dominokit.domino.ui.utils.DominoCSSRule;
import org.dominokit.domino.ui.utils.DominoDom;

/**
 * this plugin allows resizing columns of a data table
 *
 * @param <T> the type of data table records
 */
public class ResizeColumnsPlugin<T>
    implements DataTablePlugin<T>, HasPluginConfig<T, ResizeColumnsPlugin<T>, ResizeColumnsConfig> {

  private ResizeColumnsConfig config = new ResizeColumnsConfig();
  private DataTable<T> datatable;

  /** {@inheritDoc} */
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

  /** {@inheritDoc} */
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

                                dataTable.fireTableEvent(ColumnResizedEvent.of(column, diff));
                              });
                    };

                resizeElement.addEventListener(
                    EventType.mousedown.getName(),
                    evt -> {
                      MouseEvent mouseEvent = Js.uncheckedCast(evt);
                      if (mouseEvent.buttons == 1) {
                        mouseEvent.stopPropagation();
                        mouseEvent.preventDefault();
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
                      ResizeColumnMeta.get(column)
                          .ifPresent(
                              meta -> {
                                MouseEvent mouseEvent = Js.uncheckedCast(evt);
                                double currentPosition = mouseEvent.clientX;
                                double diff = currentPosition - meta.getStartPosition();

                                dataTable.fireTableEvent(ColumnResizedEvent.of(column, diff, true));
                              });

                      DominoDom.document.body.removeEventListener(
                          EventType.mousemove.getName(), resizeListener);
                    };

                this.datatable.onAttached(
                    mutationRecord -> {
                      resizeElement.addEventListener(EventType.mouseup.getName(), stopResizing);
                      DominoDom.document.body.addEventListener(
                          EventType.mouseup.getName(), stopResizing);
                    });
                this.datatable.onDetached(
                    mutationRecord -> {
                      resizeElement.removeEventListener(EventType.mouseup.getName(), stopResizing);
                      DominoDom.document.body.removeEventListener(
                          EventType.mouseup.getName(), stopResizing);
                    });
                column.appendChild(resizeElement);
              }
            });
  }

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

  /** {@inheritDoc} */
  @Override
  public void onBeforeAddCell(DataTable<T> dataTable, TableRow<T> tableRow, RowCell<T> rowCell) {
    if (config.isClipContent()) {
      elements.elementOf(rowCell.getCellInfo().getElement()).addCss(dui_text_ellipsis);
    }
  }

  /** {@inheritDoc} */
  @Override
  public ResizeColumnsPlugin<T> setConfig(ResizeColumnsConfig config) {
    this.config = config;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public ResizeColumnsConfig getConfig() {
    return config;
  }
}
