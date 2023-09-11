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
  _12(12),
  _16(16),
  _18(18),
  _24(24),
  _32(32);

  private int count;

  Columns(int count) {
    this.count = count;
  }

  /** @return The number of columns */
  /**
   * Getter for the field <code>count</code>.
   *
   * @return a int
   */
  public int getCount() {
    return count;
  }
}
