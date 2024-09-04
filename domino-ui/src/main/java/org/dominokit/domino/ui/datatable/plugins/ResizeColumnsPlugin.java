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
package org.dominokit.domino.ui.datatable.plugins;

import static org.dominokit.domino.ui.datatable.DataTableStyles.COLUMN_RESIZER;
import static org.dominokit.domino.ui.style.Unit.px;

import elemental2.dom.*;
import jsinterop.base.Js;
import org.dominokit.domino.ui.datatable.*;
import org.dominokit.domino.ui.datatable.events.ColumnResizedEvent;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.utils.DominoCSSRule;
import org.dominokit.domino.ui.utils.DominoDom;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.EventType;

/**
 * this plugin allows resizing columns of a data table
 *
 * @param <T> the type of data table records
 */
@Deprecated
public class ResizeColumnsPlugin<T>
    implements DataTablePlugin<T>, HasPluginConfig<T, ResizeColumnsPlugin<T>, ResizeColumnsConfig> {

  private ResizeColumnsConfig config = new ResizeColumnsConfig();
  private DataTable<T> datatable;

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
                DominoElement<HTMLDivElement> resizeElement =
                    DominoElement.div()
                        .css(COLUMN_RESIZER)
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
                column.appendChild(FlexItem.of(resizeElement));
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

  @Override
  public void onBeforeAddCell(DataTable<T> dataTable, TableRow<T> tableRow, RowCell<T> rowCell) {
    if (config.isClipContent()) {
      DominoElement.of(rowCell.getCellInfo().getElement()).addCss("ellipsis-text");
    }
  }

  @Override
  public ResizeColumnsPlugin<T> setConfig(ResizeColumnsConfig config) {
    this.config = config;
    return this;
  }

  @Override
  public ResizeColumnsConfig getConfig() {
    return config;
  }
}
