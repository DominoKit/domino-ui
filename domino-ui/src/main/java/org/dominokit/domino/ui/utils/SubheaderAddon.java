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
 * The {@code SubheaderAddon} class represents a subheader addon element that can be used to enhance
 * the appearance and functionality of a UI component. It extends the {@link BaseDominoElement}
 * class and provides methods for creating and manipulating subheader addon elements.
 *
 * <p>Subheader addons are typically used to provide additional information or actions related to
 * the main content of a UI component.
 *
 * @param <T> The type of the underlying HTML element.
 * @see BaseDominoElement
 * @see Element
 * @see IsElement
 */
public class SubheaderAddon<T extends Element> extends BaseDominoElement<T, SubheaderAddon<T>> {

  private DominoElement<T> element;

  /**
   * Creates a new {@code SubheaderAddon} instance from the given HTML element.
   *
   * @param element The HTML element to use as the subheader addon.
   * @return A new {@code SubheaderAddon} instance.
   */
  public static <T extends Element> SubheaderAddon<T> of(T element) {
    return new SubheaderAddon<>(element);
  }

  /**
   * Creates a new {@code SubheaderAddon} instance from the given {@link IsElement} object.
   *
   * @param element The {@link IsElement} object to use as the subheader addon.
   * @return A new {@code SubheaderAddon} instance.
   */
  public static <T extends Element> SubheaderAddon<T> of(IsElement<T> element) {
    return new SubheaderAddon<>(element);
  }

  /**
   * Creates a new {@code SubheaderAddon} instance with the specified HTML element.
   *
   * <p>This constructor initializes the subheader addon element and adds the necessary CSS class to
   * style it.
   *
   * @param element The HTML element to use as the subheader addon.
   */
  public SubheaderAddon(T element) {
    this.element = elementOf(element);
    init(this);
    addCss(dui_subheader_addon);
  }

  /**
   * Creates a new {@code SubheaderAddon} instance from the given {@link IsElement} object.
   *
   * @param element The {@link IsElement} object to use as the subheader addon.
   */
  public SubheaderAddon(IsElement<T> element) {
    this(element.element());
  }

  /**
   * Retrieves the underlying HTML element associated with this subheader addon.
   *
   * @return The HTML element used as the subheader addon.
   */
  @Override
  public T element() {
    return element.element();
  }
}
