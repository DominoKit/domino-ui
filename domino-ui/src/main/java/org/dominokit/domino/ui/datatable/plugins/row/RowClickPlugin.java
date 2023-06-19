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
 * This plugin allow adding a listener to single click event on a row
 *
 * @param <T> the type of the data table records
 */
public class RowClickPlugin<T> implements DataTablePlugin<T> {
  private ClickHandler<T> handler;

  /**
   * Creates a new instance
   *
   * @param handler the {@link ClickHandler} to handle the click event
   */
  public RowClickPlugin(ClickHandler<T> handler) {
    this.handler = handler;
  }

  /** {@inheritDoc} */
  @Override
  public void onRowAdded(DataTable<T> dataTable, TableRow<T> tableRow) {
    tableRow.addCss(dui_cursor_pointer);
    tableRow.addEventListener(EventType.click.getName(), evt -> handler.onClick(tableRow));
  }

  /**
   * An interface to implement handlers for the click event on a row
   *
   * @param <T> the type of the row record
   */
  @FunctionalInterface
  public interface ClickHandler<T> {
    /**
     * called when the row is clicked
     *
     * @param tableRow the clicked {@link TableRow}
     */
    void onClick(TableRow<T> tableRow);
  }
}
