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

import java.util.List;

/**
 * This event will be fired by the {@link org.dominokit.domino.ui.datatable.DataTable} right before
 * the data in the table is changed to allow other plugins to apply any cleanup required before the
 * new data is applied
 *
 * @param <T> the type of the data records in the table
 */
@Deprecated
public class OnBeforeDataChangeEvent<T> implements TableEvent {

  /** A constant string to define a unique type for this event */
  public static final String ON_BEFORE_DATA_CHANGE = "table-on-before-data-change";

  private final List<T> data;
  private final int totalCount;
  private boolean isAppend = false;

  /**
   * @param data {@link List} of new data
   * @param totalCount int, the total count for the new data
   * @param isAppend boolean, true if the new data will be appended to old data, otherwise it will
   *     replace the old data.
   */
  public OnBeforeDataChangeEvent(List<T> data, int totalCount, boolean isAppend) {
    this.data = data;
    this.totalCount = totalCount;
    this.isAppend = isAppend;
  }

  /** {@inheritDoc} */
  @Override
  public String getType() {
    return ON_BEFORE_DATA_CHANGE;
  }

  /** @return {@link List} of the new data */
  public List<T> getData() {
    return data;
  }

  /** @return int, the total count of the new data */
  public int getTotalCount() {
    return totalCount;
  }

  /**
   * @return boolean, true if the new data will be appended to old data otherwise new data replaces
   *     old data.
   */
  public boolean isAppend() {
    return isAppend;
  }
}
