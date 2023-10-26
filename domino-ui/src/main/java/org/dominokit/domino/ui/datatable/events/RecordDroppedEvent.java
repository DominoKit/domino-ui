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

/**
 * The {@code RecordDroppedEvent} class represents an event that is fired when a record is dropped
 * onto another record in a DataTable.
 *
 * @param <T> the type of data in the DataTable
 * @see org.dominokit.domino.ui.datatable.events.TableEvent
 */
public class RecordDroppedEvent<T> implements TableEvent {

  /** The event type for the record-dropped event. */
  public static final String RECORD_DROPPED = "record-dropped";

  private final T droppedRecord;
  private final T targetRecord;

  /**
   * Creates a new {@code RecordDroppedEvent} with the specified dropped and target records.
   *
   * @param droppedRecord the record that was dropped
   * @param targetRecord the record onto which the dropped record was placed
   */
  public RecordDroppedEvent(T droppedRecord, T targetRecord) {
    this.droppedRecord = droppedRecord;
    this.targetRecord = targetRecord;
  }

  /**
   * Retrieves the type of this event.
   *
   * @return the event type
   */
  @Override
  public String getType() {
    return RECORD_DROPPED;
  }

  /**
   * Retrieves the dropped record.
   *
   * @return the dropped record
   */
  public T getDroppedRecord() {
    return droppedRecord;
  }

  /**
   * Retrieves the target record onto which the dropped record was placed.
   *
   * @return the target record
   */
  public T getTargetRecord() {
    return targetRecord;
  }
}
