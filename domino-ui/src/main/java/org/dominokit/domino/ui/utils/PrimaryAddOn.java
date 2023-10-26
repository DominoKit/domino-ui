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
 * The {@code PrimaryAddOn} class represents an add-on that is placed before an element to indicate
 * its primary status. It is used for adding visual elements or decorations before the main element
 * to emphasize its primary role. This class extends {@link BaseDominoElement} and is designed to
 * work with DOM elements.
 *
 * @param <T> The type of the DOM element to which the primary add-on is added.
 * @see BaseDominoElement
 */
public class PrimaryAddOn<T extends Element> extends BaseDominoElement<T, PrimaryAddOn<T>> {

  private DominoElement<T> element;

  /**
   * Creates a {@code PrimaryAddOn} instance with the specified DOM element.
   *
   * @param element The DOM element to which the primary add-on is added.
   */
  public static <T extends Element> PrimaryAddOn<T> of(T element) {
    return new PrimaryAddOn<>(element);
  }

  /**
   * Creates a {@code PrimaryAddOn} instance with the specified {@link IsElement}.
   *
   * @param element The {@link IsElement} to which the primary add-on is added.
   */
  public static <T extends Element> PrimaryAddOn<T> of(IsElement<T> element) {
    return new PrimaryAddOn<>(element);
  }

  /**
   * Constructs a {@code PrimaryAddOn} instance with the specified DOM element.
   *
   * @param element The DOM element to which the primary add-on is added.
   */
  public PrimaryAddOn(T element) {
    this.element = elementOf(element);
    init(this);
    addCss(dui_primary_addon);
  }

  /**
   * Constructs a {@code PrimaryAddOn} instance with the specified {@link IsElement}.
   *
   * @param element The {@link IsElement} to which the primary add-on is added.
   */
  public PrimaryAddOn(IsElement<T> element) {
    this(element.element());
  }

  /**
   * Gets the DOM element to which the primary add-on is added.
   *
   * @return The DOM element.
   */
  @Override
  public T element() {
    return element.element();
  }
}
