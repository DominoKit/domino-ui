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

import elemental2.svg.SVGLineElement;

/** LineElement class. */
public class LineElement extends BaseElement<SVGLineElement, LineElement> {
  /**
   * of.
   *
   * @param e a {@link elemental2.svg.SVGLineElement} object
   * @return a {@link org.dominokit.domino.ui.elements.LineElement} object
   */
  public static LineElement of(SVGLineElement e) {
    return new LineElement(e);
  }

  /**
   * Constructor for LineElement.
   *
   * @param element a {@link elemental2.svg.SVGLineElement} object
   */
  public LineElement(SVGLineElement element) {
    super(element);
  }
}
