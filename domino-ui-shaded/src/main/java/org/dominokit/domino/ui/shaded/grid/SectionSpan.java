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
package org.dominokit.domino.ui.shaded.grid;

/** An enum representing the size of a section in {@link GridLayout} */
public enum SectionSpan {
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
  public int getValue() {
    return value;
  }
}
