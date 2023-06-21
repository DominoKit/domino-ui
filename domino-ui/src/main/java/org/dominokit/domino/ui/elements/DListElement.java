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

import elemental2.dom.HTMLDListElement;

/**
 * DListElement class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class DListElement extends BaseElement<HTMLDListElement, DListElement> {
  /**
   * of.
   *
   * @param e a {@link elemental2.dom.HTMLDListElement} object
   * @return a {@link org.dominokit.domino.ui.elements.DListElement} object
   */
  public static DListElement of(HTMLDListElement e) {
    return new DListElement(e);
  }

  /**
   * Constructor for DListElement.
   *
   * @param element a {@link elemental2.dom.HTMLDListElement} object
   */
  public DListElement(HTMLDListElement element) {
    super(element);
  }
}
