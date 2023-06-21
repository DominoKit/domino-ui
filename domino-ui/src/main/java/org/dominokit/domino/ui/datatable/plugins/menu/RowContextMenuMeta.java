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
 * RowContextMenuMeta class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class RowContextMenuMeta<T> implements ComponentMeta {
  /** Constant <code>ROW_CONTEXT_MENU_META="row-context-menu-meta"</code> */
  public static final String ROW_CONTEXT_MENU_META = "row-context-menu-meta";

  private final TableRow<T> tableRow;

  /**
   * Constructor for RowContextMenuMeta.
   *
   * @param tableRow a {@link org.dominokit.domino.ui.datatable.TableRow} object
   */
  public RowContextMenuMeta(TableRow<T> tableRow) {
    this.tableRow = tableRow;
  }

  /**
   * of.
   *
   * @param tableRow a {@link org.dominokit.domino.ui.datatable.TableRow} object
   * @param <T> a T class
   * @return a {@link org.dominokit.domino.ui.datatable.plugins.menu.RowContextMenuMeta} object
   */
  public static <T> RowContextMenuMeta<T> of(TableRow<T> tableRow) {
    return new RowContextMenuMeta<>(tableRow);
  }

  /**
   * get.
   *
   * @param menu a {@link org.dominokit.domino.ui.menu.Menu} object
   * @param <T> a T class
   * @return a {@link java.util.Optional} object
   */
  public static <T> Optional<RowContextMenuMeta<T>> get(Menu<?> menu) {
    Optional<MenuTarget> target = menu.getTarget();
    if (target.isPresent()) {
      return target.get().getMeta(ROW_CONTEXT_MENU_META);
    }
    return Optional.empty();
  }

  /**
   * Getter for the field <code>tableRow</code>.
   *
   * @return a {@link org.dominokit.domino.ui.datatable.TableRow} object
   */
  public TableRow<T> getTableRow() {
    return tableRow;
  }

  /** {@inheritDoc} */
  @Override
  public String getKey() {
    return ROW_CONTEXT_MENU_META;
  }
}
