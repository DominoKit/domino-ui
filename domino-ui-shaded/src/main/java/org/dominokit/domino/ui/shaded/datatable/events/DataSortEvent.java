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
package org.dominokit.domino.ui.shaded.datatable.events;

import org.dominokit.domino.ui.shaded.datatable.plugins.SortDirection;

/**
 * This event will be fired by the {@link org.dominokit.domino.ui.datatable.plugins.SortPlugin} or
 * the {@link org.dominokit.domino.ui.datatable.DataTable} when the sort is by the data store.
 */
@Deprecated
public class DataSortEvent implements TableEvent {

  /** A constant string to define a unique type for this event */
  public static final String EVENT = "data-table-sort-applied-event";

  private final String sortColumn;
  private final SortDirection sortDirection;

  /**
   * @param sortDirection {@link SortDirection}
   * @param sortColumn String, the column name that we are using to sort the data by.
   */
  public DataSortEvent(SortDirection sortDirection, String sortColumn) {
    this.sortDirection = sortDirection;
    this.sortColumn = sortColumn;
  }

  /** @return String, the sort column name */
  public String getSortColumn() {
    return sortColumn;
  }

  /** @return {@link SortDirection} */
  public SortDirection getSortDirection() {
    return sortDirection;
  }

  /** {@inheritDoc} */
  @Override
  public String getType() {
    return EVENT;
  }
}
