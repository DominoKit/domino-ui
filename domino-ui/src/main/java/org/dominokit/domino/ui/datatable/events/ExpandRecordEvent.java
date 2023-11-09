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

import org.dominokit.domino.ui.datatable.TableRow;

/**
 * The {@code ExpandRecordEvent} class represents an event that is fired when a record is expanded
 * in a DataTable. It provides information about the expanded TableRow.
 *
 * @param <T> the type of data in the TableRow
 * @see org.dominokit.domino.ui.datatable.events.TableEvent
 * @see org.dominokit.domino.ui.datatable.TableRow
 */
public class ExpandRecordEvent<T> implements TableEvent {

  /** The event type for expand record event. */
  public static final String EXPAND_RECORD = "expand-record";

  private final TableRow<T> tableRow;

  /**
   * Creates a new {@code ExpandRecordEvent} with the specified TableRow.
   *
   * @param tableRow the TableRow that was expanded
   */
  public ExpandRecordEvent(TableRow<T> tableRow) {
    this.tableRow = tableRow;
  }

  /**
   * Retrieves the type of this event.
   *
   * @return the event type
   */
  @Override
  public String getType() {
    return EXPAND_RECORD;
  }

  /**
   * Retrieves the TableRow that was expanded.
   *
   * @return the expanded TableRow
   */
  public TableRow<T> getTableRow() {
    return tableRow;
  }
}
