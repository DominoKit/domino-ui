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

import static java.util.Objects.nonNull;

import elemental2.dom.Element;
import java.util.Arrays;
import java.util.Objects;
import org.dominokit.domino.ui.IsElement;

/**
 * Represents a CSS class that can be applied to or removed from DOM elements. This interface
 * provides utility methods for applying, checking, and removing CSS classes for both DOM elements
 * and elements wrapped in the {@link IsElement} interface.
 *
 * <p>Typical usage includes making elements responsive or stylistically adaptive according to the
 * applied CSS class.
 */
public interface CssClass {

  /** A default, empty CSS class. */
  CssClass NONE = new NoneCss();

  /**
   * Returns the name of the CSS class represented by this instance.
   *
   * @return The name of the CSS class.
   */
  String getCssClass();

  /**
   * Applies the CSS class to the provided {@link IsElement}.
   *
   * @param element The element to which the CSS class will be applied.
   */
  default void apply(IsElement<?> element) {
    apply(element.element());
  }

  /**
   * Applies the CSS class to the provided DOM {@link Element}.
   *
   * @param element The DOM element to which the CSS class will be applied.
   */
  default void apply(Element element) {
    element.classList.add(getCssClass());
  }

  /**
   * Applies the CSS class to a list of DOM {@link Element}s.
   *
   * @param elements The DOM elements to which the CSS class will be applied.
   */
  default void apply(Element... elements) {
    Arrays.asList(elements).forEach(this::apply);
  }

  /**
   * Applies the CSS class to a list of {@link IsElement}s.
   *
   * @param elements The elements to which the CSS class will be applied.
   */
  default void apply(IsElement<?>... elements) {
    Arrays.asList(elements).forEach(this::apply);
  }

  /**
   * Checks if the CSS class is applied to the given DOM {@link Element}.
   *
   * @param element The DOM element to check.
   * @return true if the CSS class is applied, false otherwise.
   */
  default boolean isAppliedTo(Element element) {
    if (nonNull(element)) {
      return element.classList.contains(getCssClass());
    }
    return false;
  }

  /**
   * Checks if the CSS class is applied to the given {@link IsElement}.
   *
   * @param element The element to check.
   * @return true if the CSS class is applied, false otherwise.
   */
  default boolean isAppliedTo(IsElement<?> element) {
    if (nonNull(element)) {
      return isAppliedTo(element.element());
    }
    return false;
  }

  /**
   * Removes the CSS class from the given DOM {@link Element}.
   *
   * @param element The DOM element from which the CSS class will be removed.
   */
  default void remove(Element element) {
    element.classList.remove(getCssClass());
  }

  /**
   * Removes the CSS class from a list of DOM {@link Element}s.
   *
   * @param elements The DOM elements from which the CSS class will be removed.
   */
  default void remove(Element... elements) {
    Arrays.asList(elements).forEach(this::remove);
  }

  /**
   * Removes the CSS class from the given {@link IsElement}.
   *
   * @param element The element from which the CSS class will be removed.
   */
  default void remove(IsElement<?> element) {
    remove(element.element());
  }

  /**
   * Removes the CSS class from a list of {@link IsElement}s.
   *
   * @param elements The elements from which the CSS class will be removed.
   */
  default void remove(IsElement<?>... elements) {
    Arrays.asList(elements).forEach(this::remove);
  }

  /**
   * Compares the current CSS class to another {@link CssClass} to see if they represent the same
   * CSS class name.
   *
   * @param other The other CSS class to compare with.
   * @return true if both represent the same CSS class name, false otherwise.
   */
  default boolean isSameAs(CssClass other) {
    return Objects.equals(getCssClass(), other.getCssClass());
  }
}
