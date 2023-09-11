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
 * This event will be fired when ever the sort in a data store is changed or by clicking on a column
 * header
 *
 * @param <T> the type of the table records
 */
public class SortEvent<T> implements TableEvent {

  /** A constant string to define a unique type for this event */
  public static final String SORT_EVENT = "table-sort";

  private final SortDirection sortDirection;
  private final ColumnConfig<T> columnConfig;

  /**
   * Constructor for SortEvent.
   *
   * @param sortDirection the {@link
   *     org.dominokit.domino.ui.datatable.plugins.pagination.SortDirection}
   * @param columnConfig the {@link org.dominokit.domino.ui.datatable.ColumnConfig} that represent
   *     the column being clicked for sort
   */
  public SortEvent(SortDirection sortDirection, ColumnConfig<T> columnConfig) {
    this.sortDirection = sortDirection;
    this.columnConfig = columnConfig;
  }

  /** @return the {@link SortDirection} */
  /**
   * Getter for the field <code>sortDirection</code>.
   *
   * @return a {@link org.dominokit.domino.ui.datatable.plugins.pagination.SortDirection} object
   */
  public SortDirection getSortDirection() {
    return sortDirection;
  }

  /** @return the {@link ColumnConfig} that represent the column being clicked for sort */
  /**
   * Getter for the field <code>columnConfig</code>.
   *
   * @return a {@link org.dominokit.domino.ui.datatable.ColumnConfig} object
   */
  public ColumnConfig<T> getColumnConfig() {
    return columnConfig;
  }

  /** {@inheritDoc} */
  @Override
  public String getType() {
    return SORT_EVENT;
  }
}
