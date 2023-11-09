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

import java.util.function.Supplier;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.plugins.DataTablePlugin;
import org.dominokit.domino.ui.dnd.DragSource;
import org.dominokit.domino.ui.dnd.Draggable;
import org.dominokit.domino.ui.dnd.DropZone;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.lib.Icons;

/**
 * A DataTable plugin that allows columns to be reordered via drag-and-drop.
 *
 * @param <T> The type of data displayed in the DataTable.
 */
public class ReorderColumnsPlugin<T> implements DataTablePlugin<T> {

  private final DropZone dropZone = new DropZone();
  private final DragSource dragSource = new DragSource();
  private Supplier<Icon<?>> headerIconSupplier = Icons::drag_vertical;

  /**
   * Handles the addition of a header to the DataTable and enables column reordering via
   * drag-and-drop.
   *
   * @param dataTable The DataTable to which the header is added.
   * @param column The ColumnConfig representing the column to which the header is added.
   */
  @Override
  public void onHeaderAdded(DataTable<T> dataTable, ColumnConfig<T> column) {
    if (!column.isUtilityColumn()) {
      dropZone.addDropTarget(
          column.getHeadElement(),
          draggableName -> {
            ColumnConfig<T> movedColumn = dataTable.getTableConfig().getColumnByName(draggableName);
            int movedIndex = dataTable.getTableConfig().getColumns().indexOf(movedColumn);
            int toIndex = dataTable.getTableConfig().getColumns().indexOf(column);
            dataTable.getTableConfig().getColumns().remove(movedIndex);
            dataTable.getTableConfig().getColumns().add(toIndex, movedColumn);
            dataTable.redraw();
          });

      dragSource.addDraggable(Draggable.of(column.getName(), column.getHeadElement()));
      column.appendChild(div().addCss(dui_order_100).appendChild(headerIconSupplier.get()));
    }
  }

  /**
   * Sets a custom supplier for the header icon used for column reordering.
   *
   * @param headerIconSupplier A supplier for the header icon.
   */
  public void setHeaderIconSupplier(Supplier<Icon<?>> headerIconSupplier) {
    this.headerIconSupplier = headerIconSupplier;
  }
}
