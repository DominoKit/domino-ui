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

package org.dominokit.domino.ui.datatable.plugins.menu;

import java.util.Optional;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableRow;
import org.dominokit.domino.ui.datatable.plugins.DataTablePlugin;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.menu.MenuTarget;

/**
 * A plugin for adding row context menus to a DataTable.
 *
 * @param <T> The type of data in the DataTable.
 */
public class RowContextMenuPlugin<T> implements DataTablePlugin<T> {

  private final Menu<?> menu;

  /**
   * Creates a new {@link RowContextMenuPlugin} instance with the specified context menu.
   *
   * @param menu The context menu to be associated with the rows.
   */
  public RowContextMenuPlugin(Menu<?> menu) {
    this.menu = menu;
    this.menu.setCloseOnScroll(true);
  }

  /**
   * {@inheritDoc}
   *
   * <p>Adds the context menu to the specified row when a new row is added to the DataTable.
   *
   * @param dataTable The DataTable to which this plugin is applied.
   * @param tableRow The TableRow to which the context menu is added.
   */
  @Override
  public void onRowAdded(DataTable<T> dataTable, TableRow<T> tableRow) {
    this.menu.addTarget(
        MenuTarget.of(tableRow.element()).applyMeta(RowContextMenuMeta.of(tableRow)));
    tableRow.setAttribute(Menu.DUI_AUTO_CLEAR_SELECTION, true);
  }

  /**
   * Gets the context menu associated with this plugin.
   *
   * @return An {@link Optional} containing the context menu if set, or empty otherwise.
   */
  public Optional<RowContextMenuMeta<T>> getRowContextMenuMeta() {
    return RowContextMenuMeta.get(this.menu);
  }
}
