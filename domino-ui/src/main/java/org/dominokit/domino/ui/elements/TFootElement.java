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

import elemental2.dom.HTMLTableSectionElement;

/**
 * TFootElement class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class TFootElement extends BaseElement<HTMLTableSectionElement, TFootElement> {
  /**
   * of.
   *
   * @param e a {@link elemental2.dom.HTMLTableSectionElement} object
   * @return a {@link org.dominokit.domino.ui.elements.TFootElement} object
   */
  public static TFootElement of(HTMLTableSectionElement e) {
    return new TFootElement(e);
  }

  /**
   * Constructor for TFootElement.
   *
   * @param element a {@link elemental2.dom.HTMLTableSectionElement} object
   */
  public TFootElement(HTMLTableSectionElement element) {
    super(element);
  }
}
