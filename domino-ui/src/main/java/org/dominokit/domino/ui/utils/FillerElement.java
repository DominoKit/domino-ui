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

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.elements.SpanElement;

/** FillerElement class. */
public class FillerElement extends BaseDominoElement<HTMLElement, FillerElement> {

  private SpanElement element;

  /**
   * create.
   *
   * @return a {@link org.dominokit.domino.ui.utils.FillerElement} object
   */
  public static FillerElement create() {
    return new FillerElement();
  }

  /** Constructor for FillerElement. */
  public FillerElement() {
    element = span().addCss(dui_grow_1);
    init(this);
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return element.element();
  }
}
