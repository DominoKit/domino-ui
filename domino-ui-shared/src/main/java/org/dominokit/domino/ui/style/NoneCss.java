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
 * An implementation of the {@link CssClass} interface that represents an empty or "none" CSS class.
 * This class does not apply any CSS class to an element and always returns an empty string as the
 * CSS class name.
 */
public class NoneCss implements CssClass {

  /**
   * Retrieves an empty string as the CSS class name.
   *
   * @return An empty string.
   */
  @Override
  public String getCssClass() {
    return "";
  }

  /**
   * Applies no CSS class to the specified DOM element.
   *
   * @param element The DOM element to which no CSS class is applied.
   */
  @Override
  public void apply(Element element) {}

  /**
   * Indicates that no CSS class is applied to the specified DOM element.
   *
   * @param element The DOM element to check for the presence of CSS classes.
   * @return Always returns {@code false}.
   */
  @Override
  public boolean isAppliedTo(Element element) {
    return false;
  }

  /**
   * Indicates that no CSS class is applied to the specified IsElement instance.
   *
   * @param element The IsElement instance to check for the presence of CSS classes.
   * @return Always returns {@code false}.
   */
  @Override
  public boolean isAppliedTo(IsElement<?> element) {
    return false;
  }

  /**
   * Removes no CSS class from the specified DOM element.
   *
   * @param element The DOM element from which no CSS class is removed.
   */
  @Override
  public void remove(Element element) {}

  /**
   * Removes no CSS class from the specified IsElement instance.
   *
   * @param element The IsElement instance from which no CSS class is removed.
   */
  @Override
  public void remove(IsElement<?> element) {}
}
