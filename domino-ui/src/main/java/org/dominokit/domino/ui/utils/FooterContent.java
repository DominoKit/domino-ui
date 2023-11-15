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
import static org.dominokit.domino.ui.utils.Domino.elementOf;

import elemental2.dom.Element;
import org.dominokit.domino.ui.IsElement;

/**
 * A utility class for creating footer content elements.
 *
 * @param <T> The type of the underlying DOM element.
 * @see BaseDominoElement
 */
public class FooterContent<T extends Element> extends BaseDominoElement<T, FooterContent<T>> {

  private DominoElement<T> element;

  /**
   * Creates a new {@code FooterContent} instance from the given element.
   *
   * @param <T> The type of the underlying DOM element.
   * @param element The element to be used as footer content.
   * @return A new {@code FooterContent} instance.
   */
  public static <T extends Element> FooterContent<T> of(T element) {
    return new FooterContent<>(element);
  }

  /**
   * Creates a new {@code FooterContent} instance from the given IsElement.
   *
   * @param <T> The type of the underlying DOM element.
   * @param element The IsElement to be used as footer content.
   * @return A new {@code FooterContent} instance.
   */
  public static <T extends Element> FooterContent<T> of(IsElement<T> element) {
    return new FooterContent<>(element);
  }

  /**
   * Creates a new {@code FooterContent} instance from the given element.
   *
   * @param element The element to be used as footer content.
   */
  public FooterContent(T element) {
    this.element = elementOf(element);
    init(this);
  }

  /**
   * Creates a new {@code FooterContent} instance from the given IsElement.
   *
   * @param element The IsElement to be used as footer content.
   */
  public FooterContent(IsElement<T> element) {
    this(element.element());
  }

  /**
   * Retrieves the underlying DOM element representing the footer content.
   *
   * @return The underlying DOM element.
   */
  @Override
  public T element() {
    return element.element();
  }
}
