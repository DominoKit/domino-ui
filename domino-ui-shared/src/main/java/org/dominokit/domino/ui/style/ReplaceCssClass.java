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

/** ReplaceCssClass class. */
public class ReplaceCssClass implements CssClass {

  private CssClass original = CssClass.NONE;
  private CssClass replacement = CssClass.NONE;

  /**
   * of.
   *
   * @return a {@link org.dominokit.domino.ui.style.ReplaceCssClass} object.
   */
  public static ReplaceCssClass of() {
    return new ReplaceCssClass();
  }

  /**
   * of.
   *
   * @param initialStyle a {@link org.dominokit.domino.ui.style.CssClass} object.
   * @return a {@link org.dominokit.domino.ui.style.ReplaceCssClass} object.
   */
  public static ReplaceCssClass of(CssClass initialStyle) {
    return new ReplaceCssClass(initialStyle);
  }

  /**
   * of.
   *
   * @param cssClass a {@link java.lang.String} object.
   * @return a {@link org.dominokit.domino.ui.style.ReplaceCssClass} object.
   */
  public static ReplaceCssClass of(String cssClass) {
    return new ReplaceCssClass(cssClass);
  }

  /** Constructor for ReplaceCssClass. */
  public ReplaceCssClass() {}

  /**
   * Constructor for ReplaceCssClass.
   *
   * @param initialStyle a {@link org.dominokit.domino.ui.style.CssClass} object.
   */
  public ReplaceCssClass(CssClass initialStyle) {
    this.original = initialStyle;
    this.replacement = original;
  }

  /**
   * Constructor for ReplaceCssClass.
   *
   * @param cssClass a {@link java.lang.String} object.
   */
  public ReplaceCssClass(String cssClass) {
    this.original = () -> cssClass;
    this.replacement = original;
  }

  /**
   * replaceWith.
   *
   * @param replacement a {@link org.dominokit.domino.ui.style.CssClass} object.
   * @return a {@link org.dominokit.domino.ui.style.ReplaceCssClass} object.
   */
  public ReplaceCssClass replaceWith(CssClass replacement) {
    this.replacement = replacement;
    return this;
  }

  /**
   * replaceWith.
   *
   * @param replacement a {@link org.dominokit.domino.ui.style.HasCssClass} object.
   * @return a {@link org.dominokit.domino.ui.style.ReplaceCssClass} object.
   */
  public ReplaceCssClass replaceWith(HasCssClass replacement) {
    if (nonNull(replacement)) {
      this.replacement = replacement.getCssClass();
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public void remove(Element element) {
    if (nonNull(replacement)) {
      replacement.remove(element);
    }
  }

  /** {@inheritDoc} */
  @Override
  public void apply(Element element) {
    if (nonNull(replacement)) {
      original.remove(element);
      replacement.apply(element);
    }
  }

  /**
   * Getter for the field <code>original</code>.
   *
   * @return a {@link org.dominokit.domino.ui.style.CssClass} object.
   */
  public CssClass getOriginal() {
    return original;
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
