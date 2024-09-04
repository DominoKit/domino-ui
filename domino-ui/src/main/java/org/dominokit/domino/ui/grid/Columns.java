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
package org.dominokit.domino.ui.grid;

/** An enum representing the number of columns a row can have */
public enum Columns {
  _12(GridStyles.ROW_12, 12),
  _16(GridStyles.ROW_16, 16),
  _18(GridStyles.ROW_18, 18),
  _24(GridStyles.ROW_24, 24),
  _32(GridStyles.ROW_32, 32);

  private String columnsStyle;
  private int count;

  Columns(String columnsStyle, int count) {
    this.columnsStyle = columnsStyle;
    this.count = count;
  }

  /** @return The style of the row based on the columns count */
  public String getColumnsStyle() {
    return columnsStyle;
  }

  /** @return The number of columns */
  public int getCount() {
    return count;
  }
}
