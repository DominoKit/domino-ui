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

package org.dominokit.domino.ui.datatable.plugins.row;

import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableRow;
import org.dominokit.domino.ui.datatable.plugins.DataTablePlugin;
import org.dominokit.domino.ui.events.EventType;

/**
 * The {@code RowClickPlugin} class is a DataTable plugin that adds click event handling for table
 * rows. It allows you to specify a custom click handler using the {@link ClickHandler} functional
 * interface.
 *
 * @param <T> The type of data in the DataTable rows.
 * @see DataTablePlugin
 * @see TableRow
 */
public class RowClickPlugin<T> implements DataTablePlugin<T> {
  private ClickHandler<T> handler;

  /**
   * Creates a new {@code RowClickPlugin} with the provided click handler.
   *
   * @param handler The click handler to be executed when a row is clicked.
   */
  public RowClickPlugin(ClickHandler<T> handler) {
    this.handler = handler;
  }

  /**
   * Adds click event handling for newly added table rows. When a row is clicked, the click handler
   * {@link ClickHandler#onClick(TableRow)} is executed.
   *
   * @param dataTable The DataTable to which this plugin is applied.
   * @param tableRow The table row to which the click event handling is added.
   */
  @Override
  public void onRowAdded(DataTable<T> dataTable, TableRow<T> tableRow) {
    tableRow.addCss(dui_cursor_pointer);
    tableRow.addEventListener(EventType.click.getName(), evt -> handler.onClick(tableRow));
  }

  /**
   * A functional interface for handling row click events.
   *
   * @param <T> The type of data in the DataTable rows.
   */
  @FunctionalInterface
  public interface ClickHandler<T> {
    /**
     * Handles a row click event.
     *
     * @param tableRow The table row that was clicked.
     */
    void onClick(TableRow<T> tableRow);
  }
}
