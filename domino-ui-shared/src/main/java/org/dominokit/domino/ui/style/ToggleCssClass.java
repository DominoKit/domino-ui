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

/** A utility class for toggling a CSS class on an HTML element. */
public class ToggleCssClass implements CssClass {

  private final CssClass cssClass;

  /**
   * Creates a new instance of ToggleCssClass with the given CSS class.
   *
   * @param cssClass The CSS class to toggle.
   * @return new ToggleCssClass instance
   */
  public static ToggleCssClass of(CssClass cssClass) {
    return new ToggleCssClass(cssClass);
  }

  /**
   * Creates a new instance of ToggleCssClass with the CSS class from the provided HasCssClass
   * instance.
   *
   * @param cssClass The HasCssClass instance containing the CSS class to toggle.
   * @return new ToggleCssClass instance
   */
  public static ToggleCssClass of(HasCssClass cssClass) {
    return new ToggleCssClass(cssClass.getCssClass());
  }

  /**
   * Creates a new instance of ToggleCssClass with the given CSS class.
   *
   * @param cssClass The CSS class to toggle.
   * @return new ToggleCssClass instance
   */
  public static ToggleCssClass of(String cssClass) {
    return new ToggleCssClass(() -> cssClass);
  }

  /**
   * Constructs a new ToggleCssClass instance with the given CSS class.
   *
   * @param cssClass The CSS class to toggle.
   */
  public ToggleCssClass(CssClass cssClass) {
    this.cssClass = cssClass;
  }

  /**
   * Toggles the CSS class on the given HTML element. If the class is already applied, it will be
   * removed; otherwise, it will be added.
   *
   * @param element The HTML element on which to toggle the CSS class.
   */
  @Override
  public void apply(Element element) {
    if (element.classList.contains(getCssClass())) {
      element.classList.remove(getCssClass());
    } else {
      element.classList.add(getCssClass());
    }
  }

  /**
   * Gets the CSS class represented by this ToggleCssClass instance.
   *
   * @return The CSS class to toggle.
   */
  @Override
  public String getCssClass() {
    return cssClass.getCssClass();
  }
}
