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
package org.dominokit.domino.ui.datatable;

/**
 * implementations of this interface will save changes from the dirty record into the original
 * record
 *
 * @param <T> the type of data table records
 */
@FunctionalInterface
public interface SaveDirtyRecordHandler<T> {
  /**
   * saveDirtyRecord.
   *
   * @param originalRecord T the record in the table row
   * @param dirtyRecord T the dirty record that has changes
   */
  void saveDirtyRecord(T originalRecord, T dirtyRecord);
}
