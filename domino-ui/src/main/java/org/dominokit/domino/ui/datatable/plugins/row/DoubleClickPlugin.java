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
 * this plugin attach a handler to listen for double click event on data table rows
 *
 * @param <T> the type of data table records
 */
public class DoubleClickPlugin<T> implements DataTablePlugin<T> {

  private DoubleClickHandler<T> handler;

  /**
   * creates a new instance
   *
   * @param handler the {@link
   *     org.dominokit.domino.ui.datatable.plugins.row.DoubleClickPlugin.DoubleClickHandler}
   */
  public DoubleClickPlugin(DoubleClickHandler<T> handler) {
    this.handler = handler;
  }

  /** {@inheritDoc} */
  @Override
  public void onRowAdded(DataTable<T> dataTable, TableRow<T> tableRow) {
    tableRow.addCss(dui_cursor_pointer);
    tableRow.addEventListener(EventType.dblclick, evt -> handler.onDoubleClick(tableRow));
  }

  /**
   * An interface to handle row double click event
   *
   * @param <T> the type of the row record
   */
  @FunctionalInterface
  public interface DoubleClickHandler<T> {
    /**
     * to handle the event
     *
     * @param tableRow the {@link TableRow} being double clicked
     */
    void onDoubleClick(TableRow<T> tableRow);
  }
}
