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
import org.dominokit.domino.ui.datatable.TableRow;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.menu.MenuTarget;
import org.dominokit.domino.ui.utils.ComponentMeta;

/**
 * A metadata class for associating context menus with table rows in a DataTable.
 *
 * @param <T> The type of data in the DataTable.
 */
public class RowContextMenuMeta<T> implements ComponentMeta {

  public static final String ROW_CONTEXT_MENU_META = "row-context-menu-meta";

  private final TableRow<T> tableRow;

  /**
   * Creates a new {@link RowContextMenuMeta} instance for the specified table row.
   *
   * @param tableRow The TableRow to associate with the context menu.
   */
  public RowContextMenuMeta(TableRow<T> tableRow) {
    this.tableRow = tableRow;
  }

  /**
   * Creates a new {@link RowContextMenuMeta} instance for the specified table row.
   *
   * @param <T> The type of data in the DataTable.
   * @param tableRow The TableRow to associate with the context menu.
   * @return A new {@link RowContextMenuMeta} instance.
   */
  public static <T> RowContextMenuMeta<T> of(TableRow<T> tableRow) {
    return new RowContextMenuMeta<>(tableRow);
  }

  /**
   * Gets the context menu metadata associated with a menu.
   *
   * @param <T> The type of data in the DataTable.
   * @param menu The context menu to retrieve metadata from.
   * @return An {@link Optional} containing the context menu metadata if found, or empty otherwise.
   */
  public static <T> Optional<RowContextMenuMeta<T>> get(Menu<?> menu) {
    Optional<MenuTarget> target = menu.getTarget();
    if (target.isPresent()) {
      return target.get().getMeta(ROW_CONTEXT_MENU_META);
    }
    return Optional.empty();
  }

  /**
   * Gets the TableRow associated with this context menu.
   *
   * @return The TableRow associated with the context menu.
   */
  public TableRow<T> getTableRow() {
    return tableRow;
  }

  /**
   * Gets the key used for identifying this metadata.
   *
   * @return The key for this metadata.
   */
  @Override
  public String getKey() {
    return ROW_CONTEXT_MENU_META;
  }
}
