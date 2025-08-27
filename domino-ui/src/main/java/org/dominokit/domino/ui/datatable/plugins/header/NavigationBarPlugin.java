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
package org.dominokit.domino.ui.datatable.plugins.header;

import static java.util.Objects.isNull;
import static org.dominokit.domino.ui.datatable.DataTableStyles.dui_datatable_nav_bar;

import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.plugins.DataTablePlugin;
import org.dominokit.domino.ui.layout.NavBar;
import org.dominokit.domino.ui.utils.ChildHandler;

/**
 * The NavigationBarPlugin class provides a customizable header bar for a DataTable with various
 * actions such as condensing, expanding, toggling stripes, borders, hover effect, clearing filters,
 * and showing/hiding columns.
 *
 * <p>Usage Example:
 *
 * <pre>
 * NavigationBarPlugin<MyData> headerBar = new NavigationBarPlugin<>((datatable, navbar)-> {
 *     navbar
 *          .setTitle("Table title")
 *          .setDescription("Table description")
 *          .appendChild(PostfixAddon.of(CondenseTableAction.create(datatable)))
 *          .appendChild(PostfixAddon.of(StripesTableAction.create(datatable)))
 *          .appendChild(PostfixAddon.of(BordersTableAction.create(datatable)))
 *          .appendChild(PostfixAddon.of(HoverTableAction.create(datatable)))
 *          .appendChild(PostfixAddon.of(ClearSearch.create(datatable)))
 *          .appendChild(PostfixAddon.of(SearchTableAction.create(datatable)))
 *          .appendChild(PostfixAddon.of(ShowHideColumnsAction.create(datatable)))
 * });
 *
 * DataTable<MyData> dataTable = DataTable.create(data);
 * dataTable.addPlugin(headerBar);
 * </pre>
 *
 * @param <T> The data type of the DataTable
 */
public class NavigationBarPlugin<T> implements DataTablePlugin<T> {

  private final NavBar navBar;
  private ChildHandler<DataTable<T>, NavBar> handler = (parent, self) -> {};

  /** Creates a NavigationBarPlugin with the specified title and an empty description. */
  public NavigationBarPlugin(ChildHandler<DataTable<T>, NavBar> handler) {
    this.navBar = NavBar.create().addCss(dui_datatable_nav_bar);
    if (isNull(handler)) {
      this.handler = (parent, self) -> {};
    } else {
      this.handler = handler;
    }
  }

  /**
   * {@inheritDoc}
   *
   * <p>This method is called before adding the DataTable to the DOM. It adds the header bar and
   * action elements to the DataTable.
   *
   * @param dataTable The DataTable to which the header bar and action elements will be added.
   */
  @Override
  public void onBeforeAddTable(DataTable<T> dataTable) {
    dataTable.appendChild(navBar);
    handler.apply(dataTable, navBar);
  }
}
