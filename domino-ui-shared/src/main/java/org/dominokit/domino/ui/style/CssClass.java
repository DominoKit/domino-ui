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
 * CssClass interface.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public interface CssClass {

  /** Constant <code>NONE</code> */
  CssClass NONE = new NoneCss();

  /**
   * getCssClass.
   *
   * @return a {@link java.lang.String} object
   */
  String getCssClass();

  /**
   * apply.
   *
   * @param element a {@link org.dominokit.domino.ui.IsElement} object
   */
  default void apply(IsElement<?> element) {
    apply(element.element());
  }

  /**
   * apply.
   *
   * @param element a {@link elemental2.dom.Element} object
   */
  default void apply(Element element) {
    if (!element.classList.contains(getCssClass())) {
      element.classList.add(getCssClass());
    }
  }

  /**
   * apply.
   *
   * @param elements a {@link elemental2.dom.Element} object
   */
  default void apply(Element... elements) {
    Arrays.asList(elements).forEach(this::apply);
  }

  /**
   * apply.
   *
   * @param elements a {@link org.dominokit.domino.ui.IsElement} object
   */
  default void apply(IsElement<?>... elements) {
    Arrays.asList(elements).forEach(this::apply);
  }

  /**
   * isAppliedTo.
   *
   * @param element a {@link elemental2.dom.Element} object
   * @return a boolean
   */
  default boolean isAppliedTo(Element element) {
    if (nonNull(element)) {
      return element.classList.contains(getCssClass());
    }
    return false;
  }

  /**
   * isAppliedTo.
   *
   * @param element a {@link org.dominokit.domino.ui.IsElement} object
   * @return a boolean
   */
  default boolean isAppliedTo(IsElement<?> element) {
    if (nonNull(element)) {
      return isAppliedTo(element.element());
    }
    return false;
  }

  /**
   * remove.
   *
   * @param element a {@link elemental2.dom.Element} object
   */
  default void remove(Element element) {
    element.classList.remove(getCssClass());
  }

  /**
   * remove.
   *
   * @param elements a {@link elemental2.dom.Element} object
   */
  default void remove(Element... elements) {
    Arrays.asList(elements).forEach(this::remove);
  }

  /**
   * remove.
   *
   * @param element a {@link org.dominokit.domino.ui.IsElement} object
   */
  default void remove(IsElement<?> element) {
    remove(element.element());
  }

  /**
   * remove.
   *
   * @param elements a {@link org.dominokit.domino.ui.IsElement} object
   */
  default void remove(IsElement<?>... elements) {
    Arrays.asList(elements).forEach(this::remove);
  }

  /**
   * isSameAs.
   *
   * @param other a {@link org.dominokit.domino.ui.style.CssClass} object
   * @return a boolean
   */
  default boolean isSameAs(CssClass other) {
    return Objects.equals(getCssClass(), other.getCssClass());
  }
}
