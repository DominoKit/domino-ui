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
import org.dominokit.domino.ui.datatable.CellRenderer;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableRow;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.datatable.events.TableEventListener;

/**
 * An interface for implementing datatable plugins
 *
 * <p>the methods in this interface are all hood methods that will be called on specific places
 * while building the data table
 *
 * @param <T> the type of the datatable records
 */
public interface DataTablePlugin<T> extends TableEventListener {

  /**
   * this method is used to initialise the plugin with the datatable instance
   *
   * @param dataTable the {@link DataTable} we are attaching this plugin to.
   */
  default void init(DataTable<T> dataTable) {}

  /**
   * This well be called once the table is initialized and before it is appended to the dom
   *
   * @param dataTable the {@link DataTable} we are attaching this plugin to.
   */
  default void onBeforeAddTable(DataTable<T> dataTable) {}

  /**
   * This method will be called right before adding all columns headers elements to the table
   *
   * @param dataTable the {@link DataTable} we are attaching this plugin to.
   */
  default void onBeforeAddHeaders(DataTable<T> dataTable) {}

  /**
   * This method will be called right after adding all columns headers elements to the table
   *
   * @param dataTable the {@link DataTable} we are attaching this plugin to.
   */
  default void onAfterAddHeaders(DataTable<T> dataTable) {}

  /**
   * This method will be called right after adding a column header element to the table
   *
   * @param dataTable the {@link DataTable} we are attaching this plugin to.
   * @param column the {@link ColumnConfig} of the column we added the header for.
   */
  default void onHeaderAdded(DataTable<T> dataTable, ColumnConfig<T> column) {}

  /**
   * This method will be called right after adding body element to the table
   *
   * @param dataTable the {@link DataTable} we are attaching this plugin to.
   */
  default void onBodyAdded(DataTable<T> dataTable) {}

  /**
   * This method will be called right before adding a row to the table
   *
   * @param dataTable the {@link DataTable} we are attaching this plugin to.
   * @param tableRow the {@link TableRow} we are about to add
   */
  default void onBeforeAddRow(DataTable<T> dataTable, TableRow<T> tableRow) {}

  /**
   * This method will be called right after adding a row to the table
   *
   * @param dataTable the {@link DataTable} we are attaching this plugin to.
   * @param tableRow the {@link TableRow} added
   */
  default void onRowAdded(DataTable<T> dataTable, TableRow<T> tableRow) {}

  /**
   * This method will be called right after all rows are added to the table
   *
   * @param dataTable the {@link DataTable} we are attaching this plugin to.
   */
  default void onAllRowsAdded(DataTable<T> dataTable) {}

  /**
   * This method will be called right after adding the table element to its root element
   *
   * @param dataTable the {@link DataTable} we are attaching this plugin to.
   */
  default void onAfterAddTable(DataTable<T> dataTable) {}

  /** {@inheritDoc} */
  @Override
  default void handleEvent(TableEvent event) {}

  default boolean requiresUtilityColumn() {
    return false;
  }

  default Optional<List<HTMLElement>> getUtilityElements(
      DataTable<T> dataTable, CellRenderer.CellInfo<T> cellInfo) {
    return Optional.empty();
  }
}
