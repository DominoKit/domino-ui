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
 * The {@code SaveDirtyRecordHandler} functional interface defines a contract for handling the
 * saving of a dirty (modified) record compared to its original version in a data table.
 *
 * @param <T> The type of data representing the record.
 */
@FunctionalInterface
public interface SaveDirtyRecordHandler<T> {

  /**
   * Handles the saving of a dirty record compared to its original version.
   *
   * @param originalRecord The original, unmodified record.
   * @param dirtyRecord The modified (dirty) record to be saved.
   */
  void saveDirtyRecord(T originalRecord, T dirtyRecord);
}
