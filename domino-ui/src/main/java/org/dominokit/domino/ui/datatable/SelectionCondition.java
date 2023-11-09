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
 * The {@code SelectionCondition} functional interface defines a contract for specifying the
 * conditions under which a row in a data table can be selected.
 *
 * @param <T> The type of data representing the records in the data table.
 */
public interface SelectionCondition<T> {

  /**
   * Determines whether the selection of a specific row in a data table is allowed based on the
   * provided conditions.
   *
   * @param table The {@link DataTable} to which the row belongs.
   * @param tableRow The {@link TableRow} being considered for selection.
   * @return {@code true} if the row is allowed to be selected, {@code false} otherwise.
   */
  boolean isAllowSelection(DataTable<T> table, TableRow<T> tableRow);
}
