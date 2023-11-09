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

import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.plugins.pagination.SortDirection;

/**
 * The {@code SortEvent} class represents an event that occurs when sorting a DataTable column.
 *
 * @param <T> the type of items in the DataTable
 * @see org.dominokit.domino.ui.datatable.events.TableEvent
 * @see org.dominokit.domino.ui.datatable.ColumnConfig
 * @see org.dominokit.domino.ui.datatable.plugins.pagination.SortDirection
 */
public class SortEvent<T> implements TableEvent {

  /** The event type for the sort event. */
  public static final String SORT_EVENT = "table-sort";

  /** The sorting direction of the column. */
  private final SortDirection sortDirection;

  /** The column configuration for the sorted column. */
  private final ColumnConfig<T> columnConfig;

  /**
   * Constructs a new {@code SortEvent} with the specified sorting direction and column
   * configuration.
   *
   * @param sortDirection the sorting direction
   * @param columnConfig the column configuration
   */
  public SortEvent(SortDirection sortDirection, ColumnConfig<T> columnConfig) {
    this.sortDirection = sortDirection;
    this.columnConfig = columnConfig;
  }

  /**
   * Retrieves the sorting direction of the column.
   *
   * @return the sorting direction
   */
  public SortDirection getSortDirection() {
    return sortDirection;
  }

  /**
   * Retrieves the column configuration for the sorted column.
   *
   * @return the column configuration
   */
  public ColumnConfig<T> getColumnConfig() {
    return columnConfig;
  }

  /**
   * Retrieves the type of this event.
   *
   * @return the event type
   */
  @Override
  public String getType() {
    return SORT_EVENT;
  }
}
