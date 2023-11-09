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

/**
 * A class that represents a CSS class with optional postfixes that can be dynamically added or
 * removed from an HTML element. The base CSS class name is combined with a postfix to create the
 * final CSS class name. Postfixes can be integers or strings.
 */
public class PostfixCssClass implements CssClass {
  private final String baseCssName;

  private final SwapCssClass swapCssClass;

  /**
   * Creates a new instance of {@link PostfixCssClass} with the specified base CSS class name and an
   * integer postfix.
   *
   * @param baseCssName The base CSS class name without any postfix.
   * @param postfix The integer postfix to append to the base CSS class name.
   * @return A new {@link PostfixCssClass} instance with the specified base CSS class name and
   *     integer postfix.
   */
  public static PostfixCssClass of(String baseCssName, int postfix) {
    return new PostfixCssClass(baseCssName, postfix);
  }

  /**
   * Creates a new instance of {@link PostfixCssClass} with the specified base CSS class name and a
   * string postfix.
   *
   * @param baseCssName The base CSS class name without any postfix.
   * @param postfix The string postfix to append to the base CSS class name.
   * @return A new {@link PostfixCssClass} instance with the specified base CSS class name and
   *     string postfix.
   */
  public static PostfixCssClass of(String baseCssName, String postfix) {
    return new PostfixCssClass(baseCssName, postfix);
  }

  /**
   * Creates a new instance of {@link PostfixCssClass} with the specified base CSS class name and no
   * postfix.
   *
   * @param baseCssName The base CSS class name without any postfix.
   * @return A new {@link PostfixCssClass} instance with the specified base CSS class name.
   */
  public static PostfixCssClass of(String baseCssName) {
    return new PostfixCssClass(baseCssName);
  }

  /**
   * Creates a PostfixCssClass with the specified base CSS class name.
   *
   * @param baseCssName The base CSS class name without any postfix.
   */
  public PostfixCssClass(String baseCssName) {
    this.baseCssName = baseCssName;
    this.swapCssClass = SwapCssClass.of();
  }

  /**
   * Creates a PostfixCssClass with the specified base CSS class name and integer postfix.
   *
   * @param baseCssName The base CSS class name without any postfix.
   * @param postfix The integer postfix to append to the base CSS class name.
   */
  public PostfixCssClass(String baseCssName, int postfix) {
    this.baseCssName = baseCssName;
    this.swapCssClass = SwapCssClass.of(() -> baseCssName + "-" + postfix);
  }

  /**
   * Creates a PostfixCssClass with the specified base CSS class name and string postfix.
   *
   * @param baseCssName The base CSS class name without any postfix.
   * @param postfix The string postfix to append to the base CSS class name.
   */
  public PostfixCssClass(String baseCssName, String postfix) {
    this.baseCssName = baseCssName;
    this.swapCssClass = SwapCssClass.of(() -> baseCssName + "-" + postfix);
  }

  /**
   * Appends an integer postfix to the CSS class name.
   *
   * @param postfix The integer postfix to append.
   * @return The PostfixCssClass instance with the updated CSS class name.
   */
  public PostfixCssClass postfix(int postfix) {
    this.swapCssClass.replaceWith(() -> baseCssName + "-" + postfix);
    return this;
  }

  /**
   * Appends a string postfix to the CSS class name.
   *
   * @param postfix The string postfix to append.
   * @return The PostfixCssClass instance with the updated CSS class name.
   */
  public PostfixCssClass postfix(String postfix) {
    this.swapCssClass.replaceWith(() -> baseCssName + "-" + postfix);
    return this;
  }

  /**
   * Removes the CSS class from the specified HTML element.
   *
   * @param element The HTML element from which the CSS class will be removed.
   */
  @Override
  public void remove(Element element) {
    swapCssClass.remove(element);
  }

  /**
   * Applies the CSS class to the specified HTML element.
   *
   * @param element The HTML element to which the CSS class will be applied.
   */
  @Override
  public void apply(Element element) {
    swapCssClass.apply(element);
  }

  /**
   * Retrieves the current CSS class name, which may include the appended postfix.
   *
   * @return The current CSS class name.
   */
  @Override
  public String getCssClass() {
    return swapCssClass.getCssClass();
  }
}
