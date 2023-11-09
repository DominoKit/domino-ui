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
package org.dominokit.domino.ui.style;

import elemental2.dom.Element;
import org.dominokit.domino.ui.IsElement;

/**
 * An interface for defining CSS properties and their behavior. Implementations of this interface
 * can apply and remove CSS properties on DOM elements.
 */
public interface IsCssProperty {

  /**
   * Applies the defined CSS property to the given DOM element.
   *
   * @param element The DOM element to apply the CSS property to.
   */
  void apply(Element element);

  /**
   * Default method to apply the CSS property to an {@link IsElement}.
   *
   * @param element The {@link IsElement} to apply the CSS property to.
   */
  default void apply(IsElement<?> element) {
    apply(element.element());
  }

  /**
   * Removes the defined CSS property from the given DOM element.
   *
   * @param element The DOM element to remove the CSS property from.
   */
  void remove(Element element);

  /**
   * Default method to remove the CSS property from an {@link IsElement}.
   *
   * @param element The {@link IsElement} to remove the CSS property from.
   */
  default void remove(IsElement<?> element) {
    remove(element.element());
  }
}
