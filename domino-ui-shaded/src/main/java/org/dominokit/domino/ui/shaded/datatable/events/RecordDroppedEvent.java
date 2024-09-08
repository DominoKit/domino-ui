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

/**
 * This event will be fired when a record gets dropped
 *
 * @param <T> the type of the record
 */
@Deprecated
public class RecordDroppedEvent<T> implements TableEvent {

  public static final String RECORD_DROPPED = "record-dropped";

  private final T droppedRecord;
  private final T targetRecord;

  public RecordDroppedEvent(T droppedRecord, T targetRecord) {
    this.droppedRecord = droppedRecord;
    this.targetRecord = targetRecord;
  }

  @Override
  public String getType() {
    return RECORD_DROPPED;
  }

  /** @return the dropped record */
  public T getDroppedRecord() {
    return droppedRecord;
  }

  /** @return the target record */
  public T getTargetRecord() {
    return targetRecord;
  }
}
