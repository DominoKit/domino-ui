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
/** A utility class for swapping CSS classes applied to HTML elements. */
package org.dominokit.domino.ui.style;

import static java.util.Objects.nonNull;

import elemental2.dom.Element;

public class SwapCssClass implements CssClass {

  private CssClass current = CssClass.NONE;
  private CssClass replacement = CssClass.NONE;

  /** Creates a new instance of SwapCssClass with no initial styles. */
  public static SwapCssClass of() {
    return new SwapCssClass();
  }

  /**
   * Creates a new instance of SwapCssClass with the given initial style.
   *
   * @param initialStyle The initial CSS class to apply.
   */
  public static SwapCssClass of(CssClass initialStyle) {
    return new SwapCssClass(initialStyle);
  }

  /**
   * Creates a new instance of SwapCssClass with the CSS class from the provided HasCssClass
   * instance.
   *
   * @param initialStyle The initial HasCssClass instance.
   */
  public static SwapCssClass of(HasCssClass initialStyle) {
    return new SwapCssClass(initialStyle.getCssClass());
  }

  /**
   * Creates a new instance of SwapCssClass with the given CSS class.
   *
   * @param cssClass The initial CSS class to apply.
   */
  public static SwapCssClass of(String cssClass) {
    return new SwapCssClass(cssClass);
  }

  /** Constructs a new SwapCssClass instance with no initial style. */
  public SwapCssClass() {}

  /**
   * Constructs a new SwapCssClass instance with the given initial style.
   *
   * @param initialStyle The initial CSS class to apply.
   */
  public SwapCssClass(CssClass initialStyle) {
    this.current = initialStyle;
    this.replacement = current;
  }

  /**
   * Constructs a new SwapCssClass instance with the given CSS class.
   *
   * @param cssClass The initial CSS class to apply.
   */
  public SwapCssClass(String cssClass) {
    this.current = () -> cssClass;
    this.replacement = current;
  }

  /**
   * Replaces the current CSS class with the provided replacement CSS class.
   *
   * @param replacement The CSS class to replace the current class with.
   * @return This SwapCssClass instance for method chaining.
   */
  public SwapCssClass replaceWith(CssClass replacement) {
    this.replacement = replacement;
    return this;
  }

  /**
   * Replaces the current CSS class with the CSS class from the provided HasCssClass instance.
   *
   * @param replacement The HasCssClass instance containing the replacement CSS class.
   * @return This SwapCssClass instance for method chaining.
   */
  public SwapCssClass replaceWith(HasCssClass replacement) {
    if (nonNull(replacement)) {
      this.replacement = replacement.getCssClass();
    }
    return this;
  }

  /**
   * Removes the current CSS class from the given HTML element, if it is not null.
   *
   * @param element The HTML element from which to remove the current CSS class.
   */
  @Override
  public void remove(Element element) {
    if (nonNull(current)) {
      current.remove(element);
    }
  }

  /**
   * Applies the replacement CSS class to the given HTML element, replacing the current class.
   *
   * @param element The HTML element to apply the replacement CSS class to.
   */
  @Override
  public void apply(Element element) {
    remove(element);
    current = replacement;
    replacement.apply(element);
  }

  /**
   * Gets the currently applied CSS class.
   *
   * @return The current CSS class.
   */
  public CssClass getCurrent() {
    return current;
  }

  /**
   * Gets the replacement CSS class.
   *
   * @return The replacement CSS class.
   */
  public CssClass getReplacement() {
    return replacement;
  }

  /**
   * Gets the CSS class represented by this SwapCssClass instance.
   *
   * @return The CSS class represented by this instance (equivalent to the replacement class).
   */
  @Override
  public String getCssClass() {
    return replacement.getCssClass();
  }
}
