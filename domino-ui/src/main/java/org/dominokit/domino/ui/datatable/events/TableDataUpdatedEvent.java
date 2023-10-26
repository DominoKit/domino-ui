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
 * The {@code TableDataUpdatedEvent} class represents an event that occurs when the data in a
 * DataTable is updated.
 *
 * @param <T> the type of data in the DataTable
 */
public class TableDataUpdatedEvent<T> implements TableEvent {

  /** The event type for the table data updated event. */
  public static final String DATA_UPDATED = "table-data-updated";

  /** The updated data in the DataTable. */
  private final List<T> data;

  /** The total count of data in the DataTable. */
  private final int totalCount;

  /**
   * Constructs a new {@code TableDataUpdatedEvent} with the specified data and total count.
   *
   * @param data the updated data in the DataTable
   * @param totalCount the total count of data in the DataTable
   */
  public TableDataUpdatedEvent(List<T> data, int totalCount) {
    this.data = data;
    this.totalCount = totalCount;
  }

  /**
   * Retrieves the type of this event.
   *
   * @return the event type
   */
  @Override
  public String getType() {
    return DATA_UPDATED;
  }

  /**
   * Gets the updated data in the DataTable.
   *
   * @return the updated data
   */
  public List<T> getData() {
    return data;
  }

  /**
   * Gets the total count of data in the DataTable.
   *
   * @return the total count of data
   */
  public int getTotalCount() {
    return totalCount;
  }
}
