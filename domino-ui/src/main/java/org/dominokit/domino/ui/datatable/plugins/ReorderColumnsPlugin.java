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

import java.util.function.Supplier;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.events.StickyColumnsEvent;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.dnd.DragSource;
import org.dominokit.domino.ui.dnd.DropZone;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;

/**
 * this plugin allows reordering columns of a data table
 *
 * @param <T> the type of data table records
 */
public class ReorderColumnsPlugin<T> implements DataTablePlugin<T> {

  private final DropZone dropZone = new DropZone();
  private final DragSource dragSource = new DragSource();
  private Supplier<Icon<?>> headerIconSupplier = Icons.ALL::drag_vertical_mdi;

  /** {@inheritDoc} */
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

      dragSource.addDraggable(column.getName(), column.getHeadElement());
      column
          .getHeaderLayout()
          .appendChild(FlexItem.create().setOrder(100).appendChild(headerIconSupplier.get()));
    }
  }

  @Override
  public void handleEvent(TableEvent event) {
    if (event.getType().equals(StickyColumnsEvent.STICKY_COLUMNS)) {
      StickyColumnsEvent<T> stickyColumnsEvent = (StickyColumnsEvent<T>) event;
      for (ColumnConfig<T> column : stickyColumnsEvent.getColumns()) {
        dropZone.removeDropTarget(column.getHeadElement());
        dragSource.removeDraggable(column.getName());
      }
    }
  }

  /** @param headerIconSupplier header icon supplier */
  public void setHeaderIconSupplier(Supplier<Icon<?>> headerIconSupplier) {
    this.headerIconSupplier = headerIconSupplier;
  }
}
