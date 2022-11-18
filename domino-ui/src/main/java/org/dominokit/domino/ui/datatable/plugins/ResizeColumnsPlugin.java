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
import static org.dominokit.domino.ui.utils.DominoDom.document;

import elemental2.dom.EventListener;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jsinterop.base.Js;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.RowCell;
import org.dominokit.domino.ui.datatable.TableRow;
import org.dominokit.domino.ui.datatable.events.ColumnResizedEvent;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.EventType;

/**
 * this plugin allows resizing columns of a data table
 *
 * @param <T> the type of data table records
 */
public class ResizeColumnsPlugin<T> implements DataTablePlugin<T> {
  private final Map<ColumnConfig<T>, List<RowCell<T>>> columnCells = new HashMap<>();

  /** {@inheritDoc} */
  @Override
  public void onHeaderAdded(DataTable<T> dataTable, ColumnConfig<T> column) {
    DominoElement<HTMLDivElement> resizeElement = DominoElement.div().css(COLUMN_RESIZER);
    final double[] initialStartPosition = {0};
    final double[] initialWidth = {0};

    EventListener resizeListener =
        evt -> {
          MouseEvent mouseEvent = Js.uncheckedCast(evt);

          double currentPosition = mouseEvent.clientX;
          double diff = currentPosition - initialStartPosition[0];
          String width = px.of(initialWidth[0] + diff);
          column.getHeadElement().setWidth(width);
          column.getHeadElement().setMaxWidth(width);
          column.getHeadElement().setMinWidth(width);
          if (dataTable.getTableConfig().isFixed()) {
            columnCells
                .get(column)
                .forEach(
                    tRowCell ->
                        DominoElement.of(tRowCell.getCellInfo().getElement())
                            .setWidth(width)
                            .setMaxWidth(width)
                            .setMinWidth(width));
          }
          dataTable.fireTableEvent(new ColumnResizedEvent());
        };

    resizeElement.addEventListener(
        EventType.mousedown.getName(),
        evt -> {
          MouseEvent mouseEvent = Js.uncheckedCast(evt);
          if (mouseEvent.buttons == 1) {
            mouseEvent.preventDefault();
            initialStartPosition[0] = mouseEvent.clientX;
            initialWidth[0] = column.getHeadElement().getBoundingClientRect().width;
            document.body.addEventListener(EventType.mousemove.getName(), resizeListener);
          }
        });
    resizeElement.addEventListener(
        EventType.mouseup.getName(),
        evt -> document.body.removeEventListener(EventType.mousemove.getName(), resizeListener));
    document.body.addEventListener(
        EventType.mouseup.getName(),
        evt -> document.body.removeEventListener(EventType.mousemove.getName(), resizeListener));
    column.getHeadElement().appendChild(resizeElement);
    column.getHeadElement().setPosition("relative");
  }

  /** {@inheritDoc} */
  @Override
  public void onRowAdded(DataTable<T> dataTable, TableRow<T> tableRow) {
    if (dataTable.getTableConfig().isFixed()) {
      for (RowCell<T> cell : tableRow.getRowCells().values()) {
        if (!columnCells.containsKey(cell.getColumnConfig())) {
          columnCells.put(cell.getColumnConfig(), new ArrayList<>());
        }
        columnCells.get(cell.getColumnConfig()).add(cell);
      }
    }
  }
}
