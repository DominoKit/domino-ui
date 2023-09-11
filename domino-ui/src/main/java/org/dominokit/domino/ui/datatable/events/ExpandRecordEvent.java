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
 * This event will be fired by the {@link
 * org.dominokit.domino.ui.datatable.plugins.row.RecordDetailsPlugin} when a record is expanded
 *
 * @param <T> the type of the record.
 */
public class ExpandRecordEvent<T> implements TableEvent {

  /** A constant string to define a unique type for this event */
  public static final String EXPAND_RECORD = "expand-record";

  private final TableRow<T> tableRow;

  /** @param tableRow the {@link TableRow} being expanded */
  /**
   * Constructor for ExpandRecordEvent.
   *
   * @param tableRow a {@link org.dominokit.domino.ui.datatable.TableRow} object
   */
  public ExpandRecordEvent(TableRow<T> tableRow) {
    this.tableRow = tableRow;
  }

  /** {@inheritDoc} */
  @Override
  public String getType() {
    return EXPAND_RECORD;
  }

  /** @return the {@link TableRow} being expanded */
  /**
   * Getter for the field <code>tableRow</code>.
   *
   * @return a {@link org.dominokit.domino.ui.datatable.TableRow} object
   */
  public TableRow<T> getTableRow() {
    return tableRow;
  }
}
