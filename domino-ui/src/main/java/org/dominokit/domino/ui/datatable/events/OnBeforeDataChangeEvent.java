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
 * The {@code OnBeforeDataChangeEvent} class represents an event that is fired before the data in a
 * DataTable is changed. It provides information about the new data, total count, and whether the
 * data is being appended.
 *
 * @param <T> the type of data in the DataTable
 * @see org.dominokit.domino.ui.datatable.events.TableEvent
 */
public class OnBeforeDataChangeEvent<T> implements TableEvent {

  /** The event type for the on-before-data-change event. */
  public static final String ON_BEFORE_DATA_CHANGE = "table-on-before-data-change";

  private final List<T> data;
  private final int totalCount;
  private boolean isAppend = false;

  /**
   * Creates a new {@code OnBeforeDataChangeEvent} with the specified data, total count, and append
   * flag.
   *
   * @param data the new data to be set in the DataTable
   * @param totalCount the total count of data in the DataTable
   * @param isAppend {@code true} if the data is being appended, {@code false} otherwise
   */
  public OnBeforeDataChangeEvent(List<T> data, int totalCount, boolean isAppend) {
    this.data = data;
    this.totalCount = totalCount;
    this.isAppend = isAppend;
  }

  /**
   * Retrieves the type of this event.
   *
   * @return the event type
   */
  @Override
  public String getType() {
    return ON_BEFORE_DATA_CHANGE;
  }

  /**
   * Retrieves the new data that will be set in the DataTable.
   *
   * @return the new data
   */
  public List<T> getData() {
    return data;
  }

  /**
   * Retrieves the total count of data in the DataTable.
   *
   * @return the total count
   */
  public int getTotalCount() {
    return totalCount;
  }

  /**
   * Checks if the data is being appended.
   *
   * @return {@code true} if the data is being appended, {@code false} otherwise
   */
  public boolean isAppend() {
    return isAppend;
  }
}
