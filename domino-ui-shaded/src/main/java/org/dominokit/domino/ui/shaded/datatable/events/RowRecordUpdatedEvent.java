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

import org.dominokit.domino.ui.shaded.datatable.TableRow;

/**
 * This event will be fired when the record of a specific row in the table has its record updated
 *
 * @param <T> the type of the record
 */
@Deprecated
public class RowRecordUpdatedEvent<T> implements TableEvent {

  /** A constant string to define a unique type for this event */
  public static final String RECORD_UPDATED = "record-updated";

  private final TableRow<T> tableRow;

  /** @param tableRow the {@link TableRow} being updated */
  public RowRecordUpdatedEvent(TableRow<T> tableRow) {
    this.tableRow = tableRow;
  }

  /** {@inheritDoc} */
  @Override
  public String getType() {
    return RECORD_UPDATED;
  }

  /** @return the {@link TableRow} being updated */
  public TableRow<T> getTableRow() {
    return tableRow;
  }
}
