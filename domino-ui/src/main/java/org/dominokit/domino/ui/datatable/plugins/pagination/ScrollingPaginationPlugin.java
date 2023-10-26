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

package org.dominokit.domino.ui.datatable.plugins.pagination;

import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.events.TablePageChangeEvent;
import org.dominokit.domino.ui.datatable.plugins.DataTablePlugin;
import org.dominokit.domino.ui.pagination.ScrollingPagination;

/**
 * A plugin for adding scrolling pagination functionality to a DataTable.
 *
 * @param <T> The type of data in the DataTable.
 */
public class ScrollingPaginationPlugin<T> implements DataTablePlugin<T> {

  private ScrollingPagination pagination;

  /** Initializes the plugin with a default page size of 10 and a default window size of 10. */
  public ScrollingPaginationPlugin() {
    this(10);
  }

  /**
   * Initializes the plugin with a specified page size and a default window size of 10.
   *
   * @param pageSize The number of items per page.
   */
  public ScrollingPaginationPlugin(int pageSize) {
    this(pageSize, 10);
  }

  /**
   * Initializes the plugin with a specified page size and window size.
   *
   * @param pageSize The number of items per page.
   * @param windowSize The number of pages to display in the pagination window.
   */
  public ScrollingPaginationPlugin(int pageSize, int windowSize) {
    this.pagination = ScrollingPagination.create(0, pageSize, windowSize);
  }

  /**
   * Adds the scrolling pagination component to the DataTable and registers a change listener to
   * handle page change events.
   *
   * @param dataTable The DataTable instance to which this plugin is applied.
   */
  @Override
  public void onAfterAddTable(DataTable<T> dataTable) {
    dataTable.appendChild(pagination);
    pagination.addChangeListener(
        (oldPage, pageNumber) ->
            dataTable.fireTableEvent(new TablePageChangeEvent(pageNumber, pagination)));
  }

  /**
   * Gets the ScrollingPagination instance used by this plugin.
   *
   * @return The ScrollingPagination instance.
   */
  public ScrollingPagination getPagination() {
    return pagination;
  }
}
