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
import static org.dominokit.domino.ui.utils.Unit.px;
import static org.dominokit.domino.ui.utils.DominoDom.document;

import elemental2.dom.EventListener;
import elemental2.dom.MouseEvent;
import jsinterop.base.Js;
import org.dominokit.domino.ui.datatable.*;
import org.dominokit.domino.ui.datatable.events.ColumnResizedEvent;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.events.EventType;

/**
 * this plugin allows resizing columns of a data table
 *
 * @param <T> the type of data table records
 */
public class ResizeColumnsPlugin<T> implements DataTablePlugin<T> {

  @Override
  public void init(DataTable<T> dataTable) {
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
                    elements.div().css(COLUMN_RESIZER);

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
                                      String width = px.of(meta.getInitialWidth() + diff);
                                      col.getHeadElement().setWidth(width);
                                      col.setWidth(width);

                                      ColumnHeaderMeta.get(col)
                                          .ifPresent(
                                              headersMeta ->
                                                  headersMeta
                                                      .getExtraHeadElements()
                                                      .forEach(
                                                          header -> {
                                                            header.setWidth(width);
                                                          }));
                                    });
                          });

                      column.onEachLastSubColumn(
                          col -> {
                            ResizeColumnMeta.get(col)
                                .ifPresent(
                                    meta -> {
                                      double currentPosition = mouseEvent.clientX;
                                      double diff = currentPosition - meta.getStartPosition();
                                      String width = px.of(meta.getInitialWidth() + diff);
                                      col.getHeadElement().setWidth(width);
                                      col.setWidth(width).minWidth(width).maxWidth(width);

                                      ColumnHeaderMeta.get(col)
                                          .ifPresent(
                                              headersMeta ->
                                                  headersMeta
                                                      .getExtraHeadElements()
                                                      .forEach(
                                                          header -> {
                                                            header.setWidth(width);
                                                          }));
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
                        document.body.addEventListener(
                            EventType.mousemove.getName(), resizeListener);
                      }
                    });
                resizeElement.addEventListener(
                    EventType.mouseup.getName(),
                    evt -> {
                      document.body.removeEventListener(
                          EventType.mousemove.getName(), resizeListener);
                    });
                document.body.addEventListener(
                    EventType.mouseup.getName(),
                    evt -> {
                      document.body.removeEventListener(
                          EventType.mousemove.getName(), resizeListener);
                    });
                column.appendChild(FlexItem.of(resizeElement));
              }
            });
  }
}
