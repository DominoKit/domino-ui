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

import elemental2.dom.HTMLOptionElement;

/**
 * OptionElement class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class OptionElement extends BaseElement<HTMLOptionElement, OptionElement> {
  /**
   * of.
   *
   * @param e a {@link elemental2.dom.HTMLOptionElement} object
   * @return a {@link org.dominokit.domino.ui.elements.OptionElement} object
   */
  public static OptionElement of(HTMLOptionElement e) {
    return new OptionElement(e);
  }

  /**
   * Constructor for OptionElement.
   *
   * @param element a {@link elemental2.dom.HTMLOptionElement} object
   */
  public OptionElement(HTMLOptionElement element) {
    super(element);
  }
}
