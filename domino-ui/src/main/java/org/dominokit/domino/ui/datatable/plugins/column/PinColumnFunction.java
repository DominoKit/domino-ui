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
package org.dominokit.domino.ui.datatable.plugins.column;

import org.dominokit.domino.ui.datatable.ColumnConfig;

/** The functional interface for pinning columns in a DataTable. */
interface PinColumnFunction {

  /**
   * Pins a column to a specified position in a DataTable.
   *
   * @param column The column to be pinned.
   * @param position The position to which the column should be pinned.
   * @return The new position of the column after pinning.
   */
  double pin(ColumnConfig<?> column, double position);
}
