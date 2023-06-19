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

import elemental2.dom.Element;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

public abstract class BaseElement<E extends Element, T extends BaseElement<E, T>>
    extends BaseDominoElement<E, T> {

  private final E wrappedElement;

  /** @param element the E element extending from {@link Element} */
  public BaseElement(E element) {
    this.wrappedElement = element;
    init((T) this);
    addCss(dui);
  }

  public DominoElement<E> toDominoElement() {
    return elementOf(wrappedElement);
  }

  /**
   * @return the E element that is extending from {@link HTMLElement} wrapped in this DominoElement
   */
  @Override
  public E element() {
    return wrappedElement;
  }
}
