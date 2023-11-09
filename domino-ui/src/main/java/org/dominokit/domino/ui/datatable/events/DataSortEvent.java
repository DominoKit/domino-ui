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

import org.dominokit.domino.ui.datatable.plugins.pagination.SortDirection;

/**
 * The {@code DataSortEvent} class represents an event that is fired when sorting is applied to a
 * DataTable. It provides information about the sorted column and the sorting direction.
 *
 * @see org.dominokit.domino.ui.datatable.events.TableEvent
 * @see org.dominokit.domino.ui.datatable.plugins.pagination.SortDirection
 */
public class DataSortEvent implements TableEvent {

  /** The event type for data table sort applied event. */
  public static final String EVENT = "data-table-sort-applied-event";

  private final String sortColumn;
  private final SortDirection sortDirection;

  /**
   * Creates a new {@code DataSortEvent} with the specified sorting direction and sorted column.
   *
   * @param sortDirection the sorting direction (ascending or descending)
   * @param sortColumn the name of the sorted column
   */
  public DataSortEvent(SortDirection sortDirection, String sortColumn) {
    this.sortDirection = sortDirection;
    this.sortColumn = sortColumn;
  }

  /**
   * Retrieves the name of the sorted column.
   *
   * @return the name of the sorted column
   */
  public String getSortColumn() {
    return sortColumn;
  }

  /**
   * Retrieves the sorting direction (ascending or descending).
   *
   * @return the sorting direction
   */
  public SortDirection getSortDirection() {
    return sortDirection;
  }

  /**
   * Retrieves the type of this event.
   *
   * @return the event type
   */
  @Override
  public String getType() {
    return EVENT;
  }
}
