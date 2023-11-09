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
 * The {@code DirtyRecordProvider} functional interface defines a contract for creating a dirty
 * (modified) record based on the original record.
 *
 * @param <T> The type of data representing the records in the data table.
 */
@FunctionalInterface
public interface DirtyRecordProvider<T> {

  /**
   * Creates a dirty (modified) record based on the original record.
   *
   * @param original The original record that needs to be modified.
   * @return The modified (dirty) record.
   */
  T createDirtyRecord(T original);
}
