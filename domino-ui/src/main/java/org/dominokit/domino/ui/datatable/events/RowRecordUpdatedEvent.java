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
 * The {@code RowRecordUpdatedEvent} class represents an event that is fired when a record in a
 * DataTable row is updated.
 *
 * @param <T> the type of data in the DataTable
 * @see org.dominokit.domino.ui.datatable.events.TableEvent
 */
public class RowRecordUpdatedEvent<T> implements TableEvent {

  /** The event type for the record-updated event. */
  public static final String RECORD_UPDATED = "record-updated";

  private final TableRow<T> tableRow;

  /**
   * Creates a new {@code RowRecordUpdatedEvent} with the specified table row.
   *
   * @param tableRow the table row containing the updated record
   */
  public RowRecordUpdatedEvent(TableRow<T> tableRow) {
    this.tableRow = tableRow;
  }

  /**
   * Retrieves the type of this event.
   *
   * @return the event type
   */
  @Override
  public String getType() {
    return RECORD_UPDATED;
  }

  /**
   * Retrieves the table row containing the updated record.
   *
   * @return the table row
   */
  public TableRow<T> getTableRow() {
    return tableRow;
  }
}
