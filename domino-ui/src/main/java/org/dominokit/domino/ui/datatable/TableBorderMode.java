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
 * Controls which parts of a bordered data table receive borders.
 *
 * <p>{@link #FULL} preserves the existing {@link DataTable#setBordered(boolean)} behavior. The
 * other modes provide more focused border treatments without changing the table's row, stripe, or
 * selection behavior.
 */
public enum TableBorderMode {
  /** The table and its cells are bordered, preserving the legacy behavior. */
  FULL,
  /** Only the table container is bordered. */
  TABLE,
  /** Rows receive horizontal borders. */
  ROWS,
  /** Cells receive vertical borders. */
  COLUMNS,
  /** Only root column groups in the header receive vertical borders. */
  COLUMN_GROUPS,
  /** The table and header/footer cells are bordered. */
  SECTIONS
}
