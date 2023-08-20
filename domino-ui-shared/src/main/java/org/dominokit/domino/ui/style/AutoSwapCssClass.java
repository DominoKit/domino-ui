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

/** AutoSwapCssClass class. */
public class AutoSwapCssClass implements CssClass {

  private CssClass first = CssClass.NONE;
  private CssClass second = CssClass.NONE;

  /**
   * of.
   *
   * @param first a {@link org.dominokit.domino.ui.style.CssClass} object.
   * @param second a {@link org.dominokit.domino.ui.style.CssClass} object.
   * @return a {@link org.dominokit.domino.ui.style.AutoSwapCssClass} object.
   */
  public static AutoSwapCssClass of(CssClass first, CssClass second) {
    return new AutoSwapCssClass(first, second);
  }

  /**
   * of.
   *
   * @param first a {@link org.dominokit.domino.ui.style.HasCssClass} object.
   * @param second a {@link org.dominokit.domino.ui.style.HasCssClass} object.
   * @return a {@link org.dominokit.domino.ui.style.AutoSwapCssClass} object.
   */
  public static AutoSwapCssClass of(HasCssClass first, HasCssClass second) {
    return new AutoSwapCssClass(first.getCssClass(), second.getCssClass());
  }

  /**
   * of.
   *
   * @param first a {@link java.lang.String} object.
   * @param second a {@link java.lang.String} object.
   * @return a {@link org.dominokit.domino.ui.style.AutoSwapCssClass} object.
   */
  public static AutoSwapCssClass of(String first, String second) {
    return new AutoSwapCssClass(first, second);
  }

  /** Constructor for AutoSwapCssClass. */
  public AutoSwapCssClass() {}

  /**
   * Constructor for AutoSwapCssClass.
   *
   * @param first a {@link org.dominokit.domino.ui.style.CssClass} object.
   * @param second a {@link org.dominokit.domino.ui.style.CssClass} object.
   */
  public AutoSwapCssClass(CssClass first, CssClass second) {
    this.first = first;
    this.second = second;
  }

  /**
   * Constructor for AutoSwapCssClass.
   *
   * @param first a {@link java.lang.String} object.
   * @param second a {@link java.lang.String} object.
   */
  public AutoSwapCssClass(String first, String second) {
    this.first = () -> first;
    this.second = () -> second;
  }

  /** {@inheritDoc} */
  @Override
  public void remove(Element element) {
    if (nonNull(first)) {
      first.remove(element);
    }

    if (nonNull(second)) {
      second.remove(element);
    }
  }

  /** {@inheritDoc} */
  @Override
  public void apply(Element element) {
    first.remove(element);
    second.apply(element);
    CssClass temp = first;
    first = second;
    second = temp;
  }

  /**
   * Getter for the field <code>first</code>.
   *
   * @return a {@link org.dominokit.domino.ui.style.CssClass} object.
   */
  public CssClass getFirst() {
    return first;
  }

  /**
   * Getter for the field <code>second</code>.
   *
   * @return a {@link org.dominokit.domino.ui.style.CssClass} object.
   */
  public CssClass getSecond() {
    return second;
  }

  /** {@inheritDoc} */
  @Override
  public String getCssClass() {
    return first.getCssClass();
  }
}
