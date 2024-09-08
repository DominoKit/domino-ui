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
package org.dominokit.domino.ui.shaded.datatable;

/**
 * Implementations of this interface should return a dirty copy of a record from data table row to
 * be used for editable data tables, all changes applied to the dirty record will be reflected to
 * the original record if saved or will be reverted if the edit is canceled
 *
 * @param <T> the type of the data table records
 */
@FunctionalInterface
@Deprecated
public interface DirtyRecordProvider<T> {
  /**
   * @param original T the original record from the table row
   * @return T a copy of the original record.
   */
  T createDirtyRecord(T original);
}
