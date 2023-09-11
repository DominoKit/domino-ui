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

import org.dominokit.domino.ui.utils.ApplyFunction;

/** An enum representing the size of a section in {@link org.dominokit.domino.ui.grid.GridLayout} */
public enum SectionSpan {
  _0(0),
  _1(1),
  _2(2),
  _3(3),
  _4(4),
  _5(5),
  _6(6);

  private final int value;

  SectionSpan(int value) {
    this.value = value;
  }

  /** @return the size integer value */
  /**
   * Getter for the field <code>value</code>.
   *
   * @return a int
   */
  public int getValue() {
    return value;
  }

  /**
   * ifSpanOrElse.
   *
   * @param span a {@link org.dominokit.domino.ui.utils.ApplyFunction} object
   * @param elseFunction a {@link org.dominokit.domino.ui.utils.ApplyFunction} object
   */
  public void ifSpanOrElse(ApplyFunction span, ApplyFunction elseFunction) {
    if (getValue() > 0) {
      span.apply();
    } else {
      elseFunction.apply();
    }
  }
}
