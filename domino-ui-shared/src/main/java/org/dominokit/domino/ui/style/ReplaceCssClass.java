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

/**
 * A utility class for replacing one CSS class with another on an HTML element.
 *
 * <p>This class allows you to replace an original CSS class with a replacement CSS class on an HTML
 * element.
 */
public class ReplaceCssClass implements CssClass {

  private CssClass original = CssClass.NONE;
  private CssClass replacement = CssClass.NONE;

  /**
   * Creates a new instance of ReplaceCssClass with no initial styles.
   *
   * @return a new ReplaceCssClass instance
   */
  public static ReplaceCssClass of() {
    return new ReplaceCssClass();
  }

  /**
   * Creates a new instance of ReplaceCssClass with an initial style.
   *
   * @param initialStyle the initial CSS class to be replaced
   * @return a new ReplaceCssClass instance
   */
  public static ReplaceCssClass of(CssClass initialStyle) {
    return new ReplaceCssClass(initialStyle);
  }

  /**
   * Creates a new instance of ReplaceCssClass with a CSS class string.
   *
   * @param cssClass the CSS class string to be replaced
   * @return a new ReplaceCssClass instance
   */
  public static ReplaceCssClass of(String cssClass) {
    return new ReplaceCssClass(cssClass);
  }

  /** Constructs a default ReplaceCssClass instance with no initial styles. */
  public ReplaceCssClass() {}

  /**
   * Constructs a ReplaceCssClass instance with an initial style.
   *
   * @param initialStyle the initial CSS class to be replaced
   */
  public ReplaceCssClass(CssClass initialStyle) {
    this.original = initialStyle;
    this.replacement = original;
  }

  /**
   * Constructs a ReplaceCssClass instance with a CSS class string.
   *
   * @param cssClass the CSS class string to be replaced
   */
  public ReplaceCssClass(String cssClass) {
    this.original = () -> cssClass;
    this.replacement = original;
  }

  /**
   * Sets the replacement CSS class.
   *
   * @param replacement the replacement CSS class
   * @return this instance for chaining
   */
  public ReplaceCssClass replaceWith(CssClass replacement) {
    this.replacement = replacement;
    return this;
  }

  /**
   * Sets the replacement CSS class from an object that has a CSS class.
   *
   * @param replacement the object with a CSS class
   * @return this instance for chaining
   */
  public ReplaceCssClass replaceWith(HasCssClass replacement) {
    if (nonNull(replacement)) {
      this.replacement = replacement.getCssClass();
    }
    return this;
  }

  /**
   * Removes the replacement CSS class from the HTML element.
   *
   * @param element the HTML element to remove the replacement class from
   */
  @Override
  public void remove(Element element) {
    if (nonNull(replacement)) {
      replacement.remove(element);
    }
  }

  /**
   * Applies the replacement CSS class to the HTML element while removing the original class.
   *
   * @param element the HTML element to apply the replacement class to
   */
  @Override
  public void apply(Element element) {
    if (nonNull(replacement)) {
      original.remove(element);
      replacement.apply(element);
    }
  }

  /**
   * Gets the original CSS class.
   *
   * @return the original CSS class
   */
  public CssClass getOriginal() {
    return original;
  }

  /**
   * Gets the replacement CSS class.
   *
   * @return the replacement CSS class
   */
  public CssClass getReplacement() {
    return replacement;
  }

  /**
   * Gets the CSS class string of the replacement class.
   *
   * @return the CSS class string of the replacement class
   */
  @Override
  public String getCssClass() {
    return replacement.getCssClass();
  }
}
