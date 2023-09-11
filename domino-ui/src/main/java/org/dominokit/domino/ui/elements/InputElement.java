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
package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.IsElement;

/** InputElement class. */
public class InputElement extends BaseElement<HTMLInputElement, InputElement> {
  /**
   * of.
   *
   * @param e a {@link elemental2.dom.HTMLInputElement} object
   * @return a {@link org.dominokit.domino.ui.elements.InputElement} object
   */
  public static InputElement of(HTMLInputElement e) {
    return new InputElement(e);
  }

  /**
   * of.
   *
   * @param e a {@link org.dominokit.domino.ui.IsElement} object
   * @return a {@link org.dominokit.domino.ui.elements.InputElement} object
   */
  public static InputElement of(IsElement<HTMLInputElement> e) {
    return new InputElement(e.element());
  }

  /**
   * Constructor for InputElement.
   *
   * @param element a {@link elemental2.dom.HTMLInputElement} object
   */
  public InputElement(HTMLInputElement element) {
    super(element);
  }

  /**
   * getName.
   *
   * @return a {@link java.lang.String} object
   */
  public String getName() {
    return element.element().name;
  }

  /**
   * setName.
   *
   * @param name a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.elements.InputElement} object
   */
  public InputElement setName(String name) {
    element.element().name = name;
    return this;
  }
}
