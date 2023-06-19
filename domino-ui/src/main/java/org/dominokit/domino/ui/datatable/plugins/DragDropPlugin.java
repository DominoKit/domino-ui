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

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.datatable.DataTableStyles.*;

import elemental2.dom.HTMLElement;
import elemental2.dom.Text;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import org.dominokit.domino.ui.datatable.CellRenderer;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableRow;
import org.dominokit.domino.ui.datatable.events.RecordDraggedOutEvent;
import org.dominokit.domino.ui.datatable.events.RecordDroppedEvent;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.dnd.DragSource;
import org.dominokit.domino.ui.dnd.DropZone;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;

/**
 * this plugin allows reordering and moving records in a data table
 *
 * @param <T> the type of data table records
 */
public class DragDropPlugin<T> implements DataTablePlugin<T> {

  private DropZone dropZone;
  private DragSource dragSource;
  private TableRow<T> emptyDropRow;
  private DataTable<T> dataTable;
  private Supplier<Icon<?>> emptyDropIconSupplier = Icons::vector_point_plus;
  private Supplier<Icon<?>> dragDropIconSupplier = Icons::drag_vertical;
  private DivElement emptyDropArea;
  private Text emptyDropText;
  private final List<DataTable<T>> otherDataTables = new ArrayList<>();

  @Override
  public void init(DataTable<T> dataTable) {
    this.dataTable = dataTable;
    dropZone = new DropZone();
    dragSource = new DragSource();
    initEmptyDropArea(dataTable);
  }

  private void initEmptyDropArea(DataTable<T> dataTable) {
    emptyDropText = elements.text("Drop items here");
    emptyDropArea =
        div()
            .addCss(dui_flex, dui_items_center, dui_justify_center, dui_datatable_drop_area)
            .appendChild(emptyDropIconSupplier.get())
            .appendChild(emptyDropText);
    emptyDropRow = new TableRow<>(null, -1, dataTable).addCss(dui_datatable_drop_row);
    emptyDropRow.appendChild(emptyDropArea);
    dropZone.addDropTarget(emptyDropRow, draggableId -> moveItem(dataTable, null, draggableId));
    emptyDropRow.hide();
  }

  /** {@inheritDoc} */
  @Override
  public boolean requiresUtilityColumn() {
    return true;
  }

  /** {@inheritDoc} */
  @Override
  public Optional<List<HTMLElement>> getUtilityElements(
      DataTable<T> dataTable, CellRenderer.CellInfo<T> cellInfo) {
    return Optional.of(
        Collections.singletonList(dragDropIconSupplier.get().addCss(dui_row_dnd_grab).element()));
  }

  /** {@inheritDoc} */
  @Override
  public void onHeaderAdded(DataTable<T> dataTable, ColumnConfig<T> column) {
    if (column.isUtilityColumn()) {
      column.appendChild(div().appendChild(dragDropIconSupplier.get()));
    }
  }

  /** {@inheritDoc} */
  @Override
  public void onRowAdded(DataTable<T> dataTable, TableRow<T> tableRow) {
    dragSource.addDraggable(tableRow);
    dropZone.addDropTarget(
        tableRow, draggableId -> moveItem(dataTable, tableRow.getRecord(), draggableId));
  }

  private void moveItem(DataTable<T> dataTable, T record, String draggableId) {
    Optional<TableRow<T>> optionalTableRow = find(draggableId, dataTable);

    if (optionalTableRow.isPresent()) {
      dataTable.fireTableEvent(
          new RecordDroppedEvent<>(optionalTableRow.get().getRecord(), record));
    } else {
      for (DataTable<T> otherDataTable : otherDataTables) {
        optionalTableRow = find(draggableId, otherDataTable);
        if (optionalTableRow.isPresent()) {
          otherDataTable.fireTableEvent(
              new RecordDraggedOutEvent<>(optionalTableRow.get().getRecord()));
          dataTable.fireTableEvent(
              new RecordDroppedEvent<>(optionalTableRow.get().getRecord(), record));
        }
      }
    }
  }

  @Override
  public void handleEvent(TableEvent event) {
    if (event instanceof RecordDraggedOutEvent) {
      emptyDropRow.toggleDisplay(dataTable.getRows().isEmpty());
    }
    if (event instanceof RecordDroppedEvent) {
      emptyDropRow.hide();
    }
  }

  private Optional<TableRow<T>> find(String draggableId, DataTable<T> dataTable) {
    if (nonNull(dataTable.querySelector("[domino-uuid='" + draggableId + "']"))) {
      return dataTable.getRows().stream()
          .filter(row -> row.getDominoId().equals(draggableId))
          .findFirst();
    }
    return Optional.empty();
  }

  /**
   * Link this plugin with other data table in order to be able to move items from it
   *
   * @param other the other data table to accept items from it
   */
  public void linkWith(DataTable<T> other) {
    otherDataTables.add(other);
    if (!emptyDropRow.isAttached()) {
      dataTable.appendChild(emptyDropRow);
    }
  }

  /** @param emptyDropIconSupplier supplier to create icon for the empty drop area */
  public void setEmptyDropIconSupplier(Supplier<Icon<?>> emptyDropIconSupplier) {
    this.emptyDropIconSupplier = emptyDropIconSupplier;
  }

  /** @param dragDropIconSupplier supplier to create icon for each draggable row */
  public void setDragDropIconSupplier(Supplier<Icon<?>> dragDropIconSupplier) {
    this.dragDropIconSupplier = dragDropIconSupplier;
  }

  /** @return the element of empty drop */
  public DivElement getEmptyDropArea() {
    return emptyDropArea;
  }

  /** @param text changes the text of the empty drop area */
  public void setEmptyDropText(String text) {
    emptyDropText.textContent = text;
  }
}
