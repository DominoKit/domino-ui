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
import static org.dominokit.domino.ui.utils.Domino.*;

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
import org.dominokit.domino.ui.dnd.Draggable;
import org.dominokit.domino.ui.dnd.DropZone;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.lib.Icons;

/**
 * The {@code DragDropPlugin} class is a DataTable plugin that enables drag-and-drop functionality
 * for table rows. It allows users to drag rows and drop them into other DataTables linked with this
 * plugin. This class implements the {@link DataTablePlugin} interface and provides methods to
 * configure the drag-and-drop behavior.
 *
 * <p><strong>Usage Example:</strong>
 *
 * <pre>
 * DataTable&lt;Person&gt; dataTable = DataTable.create(data);
 * DragDropPlugin&lt;Person&gt; dragDropPlugin = new DragDropPlugin&lt;&gt;();
 * dragDropPlugin.linkWith(dataTable2); // Link with another DataTable
 * dataTable.addPlugin(dragDropPlugin);
 * </pre>
 *
 * @param <T> The type of data in the DataTable.
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

  /**
   * Initializes the DragDropPlugin with the given DataTable. This method sets up the drag-and-drop
   * functionality.
   *
   * @param dataTable The DataTable to which the drag-and-drop behavior will be added.
   */
  @Override
  public void init(DataTable<T> dataTable) {
    this.dataTable = dataTable;
    dropZone = new DropZone();
    dragSource = new DragSource();
    initEmptyDropArea(dataTable);
  }

  /**
   * Initializes the empty drop area within the DataTable. This area is displayed when items can be
   * dropped.
   *
   * @param dataTable The DataTable to which the empty drop area will be added.
   */
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

  /**
   * Indicates whether this plugin requires a utility column in the DataTable.
   *
   * @return {@code true} if a utility column is required; otherwise, {@code false}.
   */
  @Override
  public boolean requiresUtilityColumn() {
    return true;
  }

  /**
   * Returns utility elements for the DataTable cell.
   *
   * @param dataTable The DataTable to which the cell belongs.
   * @param cellInfo Information about the cell.
   * @return An optional list of utility elements, including the drag-and-drop icon.
   */
  @Override
  public Optional<List<HTMLElement>> getUtilityElements(
      DataTable<T> dataTable, CellRenderer.CellInfo<T> cellInfo) {
    return Optional.of(
        Collections.singletonList(dragDropIconSupplier.get().addCss(dui_row_dnd_grab).element()));
  }

  /**
   * Handles the addition of a header column in the DataTable.
   *
   * @param dataTable The DataTable to which the header is added.
   * @param column The column configuration.
   */
  @Override
  public void onHeaderAdded(DataTable<T> dataTable, ColumnConfig<T> column) {
    if (column.isUtilityColumn()) {
      column.appendChild(div().appendChild(dragDropIconSupplier.get()));
    }
  }

  /**
   * Handles the addition of a row in the DataTable.
   *
   * @param dataTable The DataTable to which the row is added.
   * @param tableRow The added row.
   */
  @Override
  public void onRowAdded(DataTable<T> dataTable, TableRow<T> tableRow) {
    dragSource.addDraggable(Draggable.of(tableRow));
    dropZone.addDropTarget(
        tableRow, draggableId -> moveItem(dataTable, tableRow.getRecord(), draggableId));
  }

  /**
   * Moves an item within the DataTable or to another DataTable when it is dropped.
   *
   * @param dataTable The DataTable containing the item.
   * @param record The record to be moved.
   * @param draggableId The unique identifier of the draggable item.
   */
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

  /**
   * Handles events related to the DataTable, such as RecordDraggedOutEvent and RecordDroppedEvent.
   *
   * @param event The event to be handled.
   */
  @Override
  public void handleEvent(TableEvent event) {
    if (event instanceof RecordDraggedOutEvent) {
      emptyDropRow.toggleDisplay(dataTable.getRows().isEmpty());
    }
    if (event instanceof RecordDroppedEvent) {
      emptyDropRow.hide();
    }
  }

  /**
   * Finds a TableRow by its unique identifier (draggableId) within a DataTable.
   *
   * @param draggableId The unique identifier of the draggable item.
   * @param dataTable The DataTable in which to search for the TableRow.
   * @return An Optional containing the TableRow if found; otherwise, an empty Optional.
   */
  private Optional<TableRow<T>> find(String draggableId, DataTable<T> dataTable) {
    if (nonNull(dataTable.querySelector("[domino-uuid='" + draggableId + "']"))) {
      return dataTable.getRows().stream()
          .filter(row -> row.getDominoId().equals(draggableId))
          .findFirst();
    }
    return Optional.empty();
  }

  /**
   * Links this plugin with another DataTable, allowing drag-and-drop between them.
   *
   * @param other The DataTable to link with.
   */
  public void linkWith(DataTable<T> other) {
    otherDataTables.add(other);
    if (!emptyDropRow.isAttached()) {
      dataTable.appendChild(emptyDropRow);
    }
  }

  /**
   * Sets the supplier for the empty drop area icon.
   *
   * @param emptyDropIconSupplier A {@link Supplier} that provides an empty drop area {@link Icon}.
   */
  public void setEmptyDropIconSupplier(Supplier<Icon<?>> emptyDropIconSupplier) {
    this.emptyDropIconSupplier = emptyDropIconSupplier;
  }

  /**
   * Sets the supplier for the drag-and-drop icon displayed in the DataTable.
   *
   * @param dragDropIconSupplier A {@link Supplier} that provides the drag-and-drop {@link Icon}.
   */
  public void setDragDropIconSupplier(Supplier<Icon<?>> dragDropIconSupplier) {
    this.dragDropIconSupplier = dragDropIconSupplier;
  }

  /**
   * Retrieves the empty drop area as a {@link DivElement}.
   *
   * @return The empty drop area as a {@link DivElement}.
   */
  public DivElement getEmptyDropArea() {
    return emptyDropArea;
  }

  /**
   * Sets the text content for the empty drop area.
   *
   * @param text The text to display in the empty drop area.
   */
  public void setEmptyDropText(String text) {
    emptyDropText.textContent = text;
  }
}
