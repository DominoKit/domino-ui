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
package org.dominokit.domino.ui.themes;

import elemental2.dom.Element;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.style.DominoCss;
import org.dominokit.domino.ui.utils.ElementsFactory;

/**
 * Represents a Domino UI theme.
 *
 * <p>A theme in Domino UI provides a consistent appearance and behavior (look and feel) across the
 * UI components. The interface provides methods to apply, cleanup, and check if a theme is applied
 * to specific UI components or globally.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>{@code
 * MyCustomTheme customTheme = new MyCustomTheme();
 * customTheme.apply();
 * if(customTheme.isApplied()) {
 *     // do something
 * }
 * customTheme.cleanup();
 * }</pre>
 *
 * @see IsElement
 * @see DominoCss
 * @see ElementsFactory
 */
public interface IsDominoTheme extends ElementsFactory, DominoCss {

  /**
   * Returns the name of the theme.
   *
   * @return the theme name
   */
  String getName();

  /**
   * Returns the category of the theme.
   *
   * @return the theme category
   */
  String getCategory();

  /**
   * Applies the theme to the specified target element.
   *
   * @param target the target element to apply the theme to
   */
  default void apply(IsElement<? extends Element> target) {
    apply(target.element());
  }

  /**
   * Removes the theme from the specified target element.
   *
   * @param target the target element to cleanup the theme from
   */
  default void cleanup(IsElement<? extends Element> target) {
    cleanup(target.element());
  }

  /**
   * Checks if the theme is applied to the specified target element.
   *
   * @param target the target element to check
   * @return {@code true} if the theme is applied, {@code false} otherwise
   */
  default boolean isApplied(IsElement<? extends Element> target) {
    return isApplied(target.element());
  }

  /** Applies the theme globally. */
  default void apply() {
    apply(body().element());
  };

  /** Removes the theme globally. */
  default void cleanup() {
    cleanup(body().element());
  }

  /**
   * Checks if the theme is applied globally.
   *
   * @return {@code true} if the theme is applied, {@code false} otherwise
   */
  default boolean isApplied() {
    return isApplied(body().element());
  }

  /**
   * Applies the theme to the specified target {@link Element}.
   *
   * @param target the target {@link Element} to apply the theme to
   */
  void apply(Element target);

  /**
   * Removes the theme from the specified target {@link Element}.
   *
   * @param target the target {@link Element} to cleanup the theme from
   */
  void cleanup(Element target);

  /**
   * Checks if the theme is applied to the specified target {@link Element}.
   *
   * @param target the target {@link Element} to check
   * @return {@code true} if the theme is applied, {@code false} otherwise
   */
  boolean isApplied(Element target);
}
