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

/** PostfixCssClass class. */
public class PostfixCssClass implements CssClass {
  private final String baseCssName;

  private final SwapCssClass swapCssClass;

  /**
   * of.
   *
   * @param baseCssName a {@link java.lang.String} object.
   * @param postfix a int.
   * @return a {@link org.dominokit.domino.ui.style.PostfixCssClass} object.
   */
  public static PostfixCssClass of(String baseCssName, int postfix) {
    return new PostfixCssClass(baseCssName, postfix);
  }

  /**
   * of.
   *
   * @param baseCssName a {@link java.lang.String} object.
   * @param postfix a {@link java.lang.String} object.
   * @return a {@link org.dominokit.domino.ui.style.PostfixCssClass} object.
   */
  public static PostfixCssClass of(String baseCssName, String postfix) {
    return new PostfixCssClass(baseCssName, postfix);
  }

  /**
   * of.
   *
   * @param baseCssName a {@link java.lang.String} object.
   * @return a {@link org.dominokit.domino.ui.style.PostfixCssClass} object.
   */
  public static PostfixCssClass of(String baseCssName) {
    return new PostfixCssClass(baseCssName);
  }

  /**
   * Constructor for PostfixCssClass.
   *
   * @param baseCssName a {@link java.lang.String} object.
   */
  public PostfixCssClass(String baseCssName) {
    this.baseCssName = baseCssName;
    this.swapCssClass = SwapCssClass.of();
  }

  /**
   * Constructor for PostfixCssClass.
   *
   * @param baseCssName a {@link java.lang.String} object.
   * @param postfix a int.
   */
  public PostfixCssClass(String baseCssName, int postfix) {
    this.baseCssName = baseCssName;
    this.swapCssClass = SwapCssClass.of(() -> baseCssName + "-" + postfix);
  }

  /**
   * Constructor for PostfixCssClass.
   *
   * @param baseCssName a {@link java.lang.String} object.
   * @param postfix a {@link java.lang.String} object.
   */
  public PostfixCssClass(String baseCssName, String postfix) {
    this.baseCssName = baseCssName;
    this.swapCssClass = SwapCssClass.of(() -> baseCssName + "-" + postfix);
  }

  /**
   * postfix.
   *
   * @param postfix a int.
   * @return a {@link org.dominokit.domino.ui.style.PostfixCssClass} object.
   */
  public PostfixCssClass postfix(int postfix) {
    this.swapCssClass.replaceWith(() -> baseCssName + "-" + postfix);
    return this;
  }

  /**
   * postfix.
   *
   * @param postfix a {@link java.lang.String} object.
   * @return a {@link org.dominokit.domino.ui.style.PostfixCssClass} object.
   */
  public PostfixCssClass postfix(String postfix) {
    this.swapCssClass.replaceWith(() -> baseCssName + "-" + postfix);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public void remove(Element element) {
    swapCssClass.remove(element);
  }

  /** {@inheritDoc} */
  @Override
  public void apply(Element element) {
    swapCssClass.apply(element);
  }

  /** {@inheritDoc} */
  @Override
  public String getCssClass() {
    return swapCssClass.getCssClass();
  }
}
