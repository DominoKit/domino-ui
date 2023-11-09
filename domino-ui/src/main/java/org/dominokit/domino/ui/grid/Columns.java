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

/** An enumeration representing different column counts for a grid system. */
public enum Columns {
  /** Represents a 12-column grid system. */
  _12(12),

  /** Represents a 16-column grid system. */
  _16(16),

  /** Represents an 18-column grid system. */
  _18(18),

  /** Represents a 24-column grid system. */
  _24(24),

  /** Represents a 32-column grid system. */
  _32(32);

  private int count;

  /**
   * Constructs a Columns enum value with the specified column count.
   *
   * @param count The number of columns in the grid system.
   */
  Columns(int count) {
    this.count = count;
  }

  /**
   * Gets the number of columns in the grid system represented by this enum value.
   *
   * @return The column count.
   */
  public int getCount() {
    return count;
  }
}
