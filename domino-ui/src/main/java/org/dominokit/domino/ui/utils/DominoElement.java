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
package org.dominokit.domino.ui.utils;

import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.*;

/**
 * A utility class for working with DOM elements that extends the capabilities of {@link
 * BaseDominoElement}.
 *
 * @param <E> The type of the wrapped DOM element.
 */
public abstract class DominoElement<E extends Element>
    extends BaseDominoElement<E, DominoElement<E>> {

  /** Constructs a new {@code DominoElement} with the specified DOM element. */
  public DominoElement() {
    init(this);
    addCss(dui);
  }

  /**
   * Constructs a new {@code DominoElement} with the specified DOM element.
   *
   * @param addDuiRootCss use to control adding domino-ui root css class dui.
   */
  public DominoElement(boolean addDuiRootCss) {
    init(this);
    if (addDuiRootCss) {
      addCss(dui);
    }
  }
}
