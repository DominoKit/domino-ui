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

import java.util.List;

/**
 * This event will be fired after the data in the table is changed
 *
 * @param <T> the type of the table records
 */
public class TableDataUpdatedEvent<T> implements TableEvent {

  /** A constant string to define a unique type for this event */
  public static final String DATA_UPDATED = "table-data-updated";

  private final List<T> data;
  private final int totalCount;

  /**
   * Constructor for TableDataUpdatedEvent.
   *
   * @param data {@link java.util.List} of the new data records
   * @param totalCount int, the total count of the data
   */
  public TableDataUpdatedEvent(List<T> data, int totalCount) {
    this.data = data;
    this.totalCount = totalCount;
  }

  /** {@inheritDoc} */
  @Override
  public String getType() {
    return DATA_UPDATED;
  }

  /** @return {@link List} of the new data records */
  /**
   * Getter for the field <code>data</code>.
   *
   * @return a {@link java.util.List} object
   */
  public List<T> getData() {
    return data;
  }

  /** @return int, the total count of the data */
  /**
   * Getter for the field <code>totalCount</code>.
   *
   * @return a int
   */
  public int getTotalCount() {
    return totalCount;
  }
}
