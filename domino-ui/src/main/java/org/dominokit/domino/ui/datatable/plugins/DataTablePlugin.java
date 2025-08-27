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

import elemental2.dom.HTMLElement;
import java.util.List;
import java.util.Optional;
import org.dominokit.domino.ui.datatable.*;
import org.dominokit.domino.ui.style.DominoCss;
import org.dominokit.domino.ui.utils.DominoEvent;
import org.dominokit.domino.ui.utils.DominoEventListener;
import org.dominokit.domino.ui.utils.ElementsFactory;

/**
 * The {@code DataTablePlugin} interface represents a plugin that can be added to a DataTable to
 * extend its functionality. DataTable plugins can respond to various DataTable events and customize
 * the behavior of the DataTable.
 *
 * <p><strong>Usage Example:</strong>
 *
 * <pre>
 * public class MyDataTablePlugin implements DataTablePlugin<MyDataModel> {
 *
 *     {@literal @}Override
 *     public void init(DataTable<MyDataModel> dataTable) {
 *         // Initialize the plugin for the given DataTable
 *     }
 *
 *     // Other override methods to respond to DataTable events and customize behavior
 * }
 * </pre>
 *
 * @param <T> The type of data displayed in the DataTable.
 */
public interface DataTablePlugin<T>
    extends Comparable<DataTablePlugin<T>>, ElementsFactory, DominoCss, DominoEventListener {

  /**
   * Initializes the DataTablePlugin for the given DataTable. This method is called when the plugin
   * is added to the DataTable.
   *
   * @param dataTable The DataTable instance to which this plugin is added.
   */
  default void init(DataTable<T> dataTable) {}

  /**
   * Called before adding the DataTable to the container. Useful for custom initialization.
   *
   * @param dataTable The DataTable instance.
   */
  default void onBeforeAddTable(DataTable<T> dataTable) {}

  /**
   * Called before adding the DataTable headers to the container. Useful for custom header
   * initialization.
   *
   * @param dataTable The DataTable instance.
   */
  default void onBeforeAddHeaders(DataTable<T> dataTable) {}

  /**
   * Called after adding the DataTable headers to the container.
   *
   * @param dataTable The DataTable instance.
   */
  default void onAfterAddHeaders(DataTable<T> dataTable) {}

  /**
   * Called when a header is added to the DataTable.
   *
   * @param dataTable The DataTable instance.
   * @param column The ColumnConfig for the added header.
   */
  default void onHeaderAdded(DataTable<T> dataTable, ColumnConfig<T> column) {}

  /**
   * Called after adding the DataTable body to the container.
   *
   * @param dataTable The DataTable instance.
   */
  default void onBodyAdded(DataTable<T> dataTable) {}

  /**
   * Called before adding a row to the DataTable. Useful for custom row initialization.
   *
   * @param dataTable The DataTable instance.
   * @param tableRow The TableRow being added.
   */
  default void onBeforeAddRow(DataTable<T> dataTable, TableRow<T> tableRow) {}

  /**
   * Called when a row is added to the DataTable.
   *
   * @param dataTable The DataTable instance.
   * @param tableRow The TableRow that was added.
   */
  default void onRowAdded(DataTable<T> dataTable, TableRow<T> tableRow) {}

  /**
   * Called after all rows are added to the DataTable.
   *
   * @param dataTable The DataTable instance.
   */
  default void onAllRowsAdded(DataTable<T> dataTable) {}

  /**
   * Called after adding the DataTable to the container. Useful for custom post-initialization.
   *
   * @param dataTable The DataTable instance.
   */
  default void onAfterAddTable(DataTable<T> dataTable) {}

  /**
   * Called before adding a cell to the DataTable. Useful for custom cell initialization.
   *
   * @param dataTable The DataTable instance.
   * @param tableRow The TableRow to which the cell belongs.
   * @param rowCell The RowCell being added.
   */
  default void onBeforeAddCell(DataTable<T> dataTable, TableRow<T> tableRow, RowCell<T> rowCell) {}

  /**
   * Called after adding a cell to the DataTable.
   *
   * @param dataTable The DataTable instance.
   * @param tableRow The TableRow to which the cell belongs.
   * @param rowCell The RowCell that was added.
   */
  default void onAfterAddCell(DataTable<T> dataTable, TableRow<T> tableRow, RowCell<T> rowCell) {}

  /** {@inheritDoc} */
  @Override
  default void handleEvent(DominoEvent event) {}

  /**
   * Indicates whether the plugin requires a utility column in the DataTable. Default is {@code
   * false}.
   *
   * @return {@code true} if a utility column is required, {@code false} otherwise.
   */
  default boolean requiresUtilityColumn() {
    return false;
  }

  /**
   * Specifies the order in which the plugin should be executed. Plugins are executed in ascending
   * order of their order values. The default order value is 100.
   *
   * @return The order value for plugin execution.
   */
  default int order() {
    return 100;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Compares this DataTablePlugin with another DataTablePlugin based on their execution order.
   *
   * @param o The DataTablePlugin to compare to.
   * @return A negative integer, zero, or a positive integer if this DataTablePlugin is less than,
   *     equal to, or greater than the specified DataTablePlugin in terms of execution order.
   */
  @Override
  default int compareTo(DataTablePlugin<T> o) {
    return Integer.compare(this.order(), o.order());
  }

  /**
   * Provides utility elements that can be added to a cell based on the plugin's logic.
   *
   * @param dataTable The DataTable instance.
   * @param cellInfo Information about the cell.
   * @return An optional list of HTMLElements representing utility elements to be added to the cell.
   */
  default Optional<List<HTMLElement>> getUtilityElements(
      DataTable<T> dataTable, CellRenderer.CellInfo<T> cellInfo) {
    return Optional.empty();
  }

  /**
   * Called after adding the DataTable footer to the container.
   *
   * @param datatable The DataTable instance.
   */
  default void onFooterAdded(DataTable<T> datatable) {}
}
