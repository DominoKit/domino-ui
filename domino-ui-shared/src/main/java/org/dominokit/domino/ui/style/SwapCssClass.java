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
 * SwapCssClass class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class SwapCssClass implements CssClass {

  private CssClass current = CssClass.NONE;
  private CssClass replacement = CssClass.NONE;

  /**
   * of.
   *
   * @return a {@link org.dominokit.domino.ui.style.SwapCssClass} object.
   */
  public static SwapCssClass of() {
    return new SwapCssClass();
  }

  /**
   * of.
   *
   * @param initialStyle a {@link org.dominokit.domino.ui.style.CssClass} object.
   * @return a {@link org.dominokit.domino.ui.style.SwapCssClass} object.
   */
  public static SwapCssClass of(CssClass initialStyle) {
    return new SwapCssClass(initialStyle);
  }

  /**
   * of.
   *
   * @param initialStyle a {@link org.dominokit.domino.ui.style.HasCssClass} object.
   * @return a {@link org.dominokit.domino.ui.style.SwapCssClass} object.
   */
  public static SwapCssClass of(HasCssClass initialStyle) {
    return new SwapCssClass(initialStyle.getCssClass());
  }

  /**
   * of.
   *
   * @param cssClass a {@link java.lang.String} object.
   * @return a {@link org.dominokit.domino.ui.style.SwapCssClass} object.
   */
  public static SwapCssClass of(String cssClass) {
    return new SwapCssClass(cssClass);
  }

  /** Constructor for SwapCssClass. */
  public SwapCssClass() {}

  /**
   * Constructor for SwapCssClass.
   *
   * @param initialStyle a {@link org.dominokit.domino.ui.style.CssClass} object.
   */
  public SwapCssClass(CssClass initialStyle) {
    this.current = initialStyle;
    this.replacement = current;
  }

  /**
   * Constructor for SwapCssClass.
   *
   * @param cssClass a {@link java.lang.String} object.
   */
  public SwapCssClass(String cssClass) {
    this.current = () -> cssClass;
    this.replacement = current;
  }

  /**
   * replaceWith.
   *
   * @param replacement a {@link org.dominokit.domino.ui.style.CssClass} object.
   * @return a {@link org.dominokit.domino.ui.style.SwapCssClass} object.
   */
  public SwapCssClass replaceWith(CssClass replacement) {
    this.replacement = replacement;
    return this;
  }

  /**
   * replaceWith.
   *
   * @param replacement a {@link org.dominokit.domino.ui.style.HasCssClass} object.
   * @return a {@link org.dominokit.domino.ui.style.SwapCssClass} object.
   */
  public SwapCssClass replaceWith(HasCssClass replacement) {
    if (nonNull(replacement)) {
      this.replacement = replacement.getCssClass();
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public void remove(Element element) {
    if (nonNull(current)) {
      current.remove(element);
    }
  }

  /** {@inheritDoc} */
  @Override
  public void apply(Element element) {
    remove(element);
    current = replacement;
    replacement.apply(element);
  }

  /**
   * Getter for the field <code>current</code>.
   *
   * @return a {@link org.dominokit.domino.ui.style.CssClass} object.
   */
  public CssClass getCurrent() {
    return current;
  }

  /**
   * Getter for the field <code>replacement</code>.
   *
   * @return a {@link org.dominokit.domino.ui.style.CssClass} object.
   */
  public CssClass getReplacement() {
    return replacement;
  }

  /** {@inheritDoc} */
  @Override
  public String getCssClass() {
    return replacement.getCssClass();
  }
}
