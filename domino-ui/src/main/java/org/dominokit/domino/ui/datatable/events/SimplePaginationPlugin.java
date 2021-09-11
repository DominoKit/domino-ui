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
package org.dominokit.domino.ui.datatable.events;

import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.plugins.DataTablePlugin;
import org.dominokit.domino.ui.pagination.SimplePagination;

/**
 * @deprecated use {@link org.dominokit.domino.ui.datatable.plugins.SimplePaginationPlugin}
 * @param <T> The type of data table records
 */
@Deprecated
public class SimplePaginationPlugin<T> implements DataTablePlugin<T> {

  private SimplePagination simplePagination;

  private final int pageSize;

  public SimplePaginationPlugin() {
    this(10);
  }

  public SimplePaginationPlugin(int pageSize) {
    this.pageSize = pageSize;
    this.simplePagination = SimplePagination.create(0, pageSize).markActivePage().gotoPage(1);
  }

  @Override
  public void onAfterAddTable(DataTable<T> dataTable) {
    dataTable.element().appendChild(simplePagination.element());

    simplePagination.onPageChanged(
        pageNumber ->
            dataTable.fireTableEvent(new TablePageChangeEvent(pageNumber, simplePagination)));
  }

  public SimplePagination getSimplePagination() {
    return simplePagination;
  }
}
