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
 * This event will be fired when a record gets dragged out
 *
 * @param <T> the type of the record
 * @author vegegoku
 * @version $Id: $Id
 */
public class RecordDraggedOutEvent<T> implements TableEvent {

  /** Constant <code>RECORD_DRAGGED_OUT="record-dragged-out"</code> */
  public static final String RECORD_DRAGGED_OUT = "record-dragged-out";

  private final T draggedOutRecord;

  /**
   * Constructor for RecordDraggedOutEvent.
   *
   * @param draggedOutRecord a T object
   */
  public RecordDraggedOutEvent(T draggedOutRecord) {
    this.draggedOutRecord = draggedOutRecord;
  }

  /** {@inheritDoc} */
  @Override
  public String getType() {
    return RECORD_DRAGGED_OUT;
  }

  /** @return dragged out record */
  /**
   * Getter for the field <code>draggedOutRecord</code>.
   *
   * @return a T object
   */
  public T getDraggedOutRecord() {
    return draggedOutRecord;
  }
}
