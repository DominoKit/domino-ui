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

import static org.dominokit.domino.ui.utils.Domino.*;
import static org.dominokit.domino.ui.utils.Domino.dui;
import static org.dominokit.domino.ui.utils.Domino.elementOf;

import elemental2.dom.Element;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

/**
 * The {@code BaseElement} class is an abstract base class for creating wrapper elements that
 * provide type-safe access to DOM elements. It extends {@link BaseDominoElement} and is used to
 * create specific element wrapper classes within the {@code org.dominokit.domino.ui.elements}
 * package.
 *
 * <p><strong>Usage Example:</strong>
 *
 * <pre>
 * // Create a new instance of a specific element wrapper
 * MyElement myElement = MyElement.of(element);
 *
 * // Access and manipulate the wrapped DOM element
 * myElement.setTextContent("Hello, World!");
 * myElement.addCss("custom-class");
 * </pre>
 *
 * @param <E> The type of the wrapped DOM element.
 * @param <T> The concrete subclass type.
 * @see BaseDominoElement
 */
public abstract class BaseElement<E extends Element, T extends BaseElement<E, T>>
    extends BaseDominoElement<E, T> {

  private final E wrappedElement;

  /**
   * Constructs a new {@code BaseElement} with the provided DOM element.
   *
   * @param element The DOM element to wrap.
   */
  public BaseElement(E element) {
    this.wrappedElement = element;
    init((T) this);
    addCss(dui);
  }

  /**
   * Converts the wrapped DOM element into a {@link DominoElement} for easier manipulation.
   *
   * @return A {@code DominoElement} wrapping the wrapped DOM element.
   */
  public DominoElement<E> toDominoElement() {
    return elementOf(wrappedElement);
  }

  /**
   * Retrieves the wrapped DOM element.
   *
   * @return The wrapped DOM element.
   */
  @Override
  public E element() {
    return wrappedElement;
  }
}
