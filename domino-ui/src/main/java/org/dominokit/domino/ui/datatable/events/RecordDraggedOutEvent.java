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
 * The {@code RecordDraggedOutEvent} class represents an event that is fired when a record is
 * dragged out of a DataTable.
 *
 * @param <T> the type of data in the DataTable
 * @see org.dominokit.domino.ui.datatable.events.TableEvent
 */
public class RecordDraggedOutEvent<T> implements TableEvent {

  /** The event type for the record-dragged-out event. */
  public static final String RECORD_DRAGGED_OUT = "record-dragged-out";

  private final T draggedOutRecord;

  /**
   * Creates a new {@code RecordDraggedOutEvent} with the specified dragged out record.
   *
   * @param draggedOutRecord the record that was dragged out
   */
  public RecordDraggedOutEvent(T draggedOutRecord) {
    this.draggedOutRecord = draggedOutRecord;
  }

  /**
   * Retrieves the type of this event.
   *
   * @return the event type
   */
  @Override
  public String getType() {
    return RECORD_DRAGGED_OUT;
  }

  /**
   * Retrieves the record that was dragged out of the DataTable.
   *
   * @return the dragged out record
   */
  public T getDraggedOutRecord() {
    return draggedOutRecord;
  }
}
