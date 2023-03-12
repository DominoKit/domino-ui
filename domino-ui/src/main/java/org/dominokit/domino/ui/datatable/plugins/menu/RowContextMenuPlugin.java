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

public class RowContextMenuPlugin<T> implements DataTablePlugin<T> {

  private final Menu<?> menu;

  public RowContextMenuPlugin(Menu<?> menu) {
    this.menu = menu;
  }

  @Override
  public void onRowAdded(DataTable<T> dataTable, TableRow<T> tableRow) {
    this.menu.addTarget(
        MenuTarget.of(tableRow.element()).applyMeta(RowContextMenuMeta.of(tableRow)));
  }

  public Optional<RowContextMenuMeta<T>> getRowContextMenuMeta() {
    return RowContextMenuMeta.get(this.menu);
  }
}
