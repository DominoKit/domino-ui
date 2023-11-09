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

import elemental2.dom.Element;
import org.dominokit.domino.ui.IsElement;

/**
 * The {@code HeaderContent} class is a generic class that extends {@code BaseDominoElement} and
 * provides utility methods to work with header content elements.
 *
 * @param <T> The type of the header content element.
 * @see BaseDominoElement
 */
public class HeaderContent<T extends Element> extends BaseDominoElement<T, HeaderContent<T>> {

  private DominoElement<T> element;

  /**
   * Creates a new instance of {@code HeaderContent} with the specified element.
   *
   * @param element The header content element.
   * @param <T> The type of the header content element.
   * @return A new {@code HeaderContent} instance.
   */
  public static <T extends Element> HeaderContent<T> of(T element) {
    return new HeaderContent<>(element);
  }

  /**
   * Creates a new instance of {@code HeaderContent} with the specified {@code IsElement}.
   *
   * @param element The header content element wrapped in an {@code IsElement}.
   * @param <T> The type of the header content element.
   * @return A new {@code HeaderContent} instance.
   */
  public static <T extends Element> HeaderContent<T> of(IsElement<T> element) {
    return new HeaderContent<>(element);
  }

  /**
   * Creates a new instance of {@code HeaderContent} with the specified element.
   *
   * @param element The header content element.
   */
  public HeaderContent(T element) {
    this.element = elementOf(element);
    init(this);
  }

  /**
   * Creates a new instance of {@code HeaderContent} with the specified {@code IsElement}.
   *
   * @param element The header content element wrapped in an {@code IsElement}.
   */
  public HeaderContent(IsElement<T> element) {
    this(element.element());
  }

  /**
   * Returns the header content element associated with this {@code HeaderContent} instance.
   *
   * @return The header content element.
   */
  @Override
  public T element() {
    return element.element();
  }
}
