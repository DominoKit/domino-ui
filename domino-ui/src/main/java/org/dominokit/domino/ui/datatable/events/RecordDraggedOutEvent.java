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
 */
public class RecordDraggedOutEvent<T> implements TableEvent {

  public static final String RECORD_DRAGGED_OUT = "record-dragged-out";

  private final T draggedOutRecord;

  public RecordDraggedOutEvent(T draggedOutRecord) {
    this.draggedOutRecord = draggedOutRecord;
  }

  @Override
  public String getType() {
    return RECORD_DRAGGED_OUT;
  }

  /** @return dragged out record */
  public T getDraggedOutRecord() {
    return draggedOutRecord;
  }
}
