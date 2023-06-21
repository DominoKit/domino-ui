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
 * BooleanCssClass class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class BooleanCssClass implements CssClass {

  private CssClass cssClass;
  private boolean addRemove;

  /**
   * of.
   *
   * @param cssClass a {@link org.dominokit.domino.ui.style.CssClass} object.
   * @param addRemove a boolean.
   * @return a {@link org.dominokit.domino.ui.style.BooleanCssClass} object.
   */
  public static BooleanCssClass of(CssClass cssClass, boolean addRemove) {
    return new BooleanCssClass(cssClass, addRemove);
  }

  /**
   * of.
   *
   * @param cssClass a {@link org.dominokit.domino.ui.style.HasCssClass} object.
   * @param addRemove a boolean.
   * @return a {@link org.dominokit.domino.ui.style.BooleanCssClass} object.
   */
  public static BooleanCssClass of(HasCssClass cssClass, boolean addRemove) {
    return new BooleanCssClass(cssClass.getCssClass(), addRemove);
  }

  /**
   * of.
   *
   * @param cssClass a {@link java.lang.String} object.
   * @param addRemove a boolean.
   * @return a {@link org.dominokit.domino.ui.style.BooleanCssClass} object.
   */
  public static BooleanCssClass of(String cssClass, boolean addRemove) {
    return new BooleanCssClass(() -> cssClass, addRemove);
  }

  /**
   * of.
   *
   * @param cssClass a {@link org.dominokit.domino.ui.style.CssClass} object.
   * @return a {@link org.dominokit.domino.ui.style.BooleanCssClass} object.
   */
  public static BooleanCssClass of(CssClass cssClass) {
    return new BooleanCssClass(cssClass);
  }

  /**
   * of.
   *
   * @param cssClass a {@link org.dominokit.domino.ui.style.HasCssClass} object.
   * @return a {@link org.dominokit.domino.ui.style.BooleanCssClass} object.
   */
  public static BooleanCssClass of(HasCssClass cssClass) {
    return new BooleanCssClass(cssClass.getCssClass());
  }

  /**
   * of.
   *
   * @param cssClass a {@link java.lang.String} object.
   * @return a {@link org.dominokit.domino.ui.style.BooleanCssClass} object.
   */
  public static BooleanCssClass of(String cssClass) {
    return new BooleanCssClass(() -> cssClass);
  }

  /**
   * Constructor for BooleanCssClass.
   *
   * @param cssClass a {@link org.dominokit.domino.ui.style.CssClass} object.
   * @param addRemove a boolean.
   */
  public BooleanCssClass(CssClass cssClass, boolean addRemove) {
    this.cssClass = cssClass;
    this.addRemove = addRemove;
  }

  /**
   * Constructor for BooleanCssClass.
   *
   * @param cssClass a {@link org.dominokit.domino.ui.style.CssClass} object.
   */
  public BooleanCssClass(CssClass cssClass) {
    this(cssClass, true);
  }

  /** {@inheritDoc} */
  @Override
  public void apply(Element element) {
    apply(element, addRemove);
  }

  /**
   * apply.
   *
   * @param element a {@link elemental2.dom.Element} object.
   * @param addRemove a boolean.
   */
  public void apply(Element element, boolean addRemove) {
    if (addRemove) {
      cssClass.apply(element);
    } else {
      remove(element);
    }
  }

  /**
   * apply.
   *
   * @param element a {@link org.dominokit.domino.ui.IsElement} object.
   * @param addRemove a boolean.
   */
  public void apply(IsElement<?> element, boolean addRemove) {
    apply(element.element(), addRemove);
  }

  /** {@inheritDoc} */
  @Override
  public boolean isAppliedTo(Element element) {
    return cssClass.isAppliedTo(element);
  }

  /** {@inheritDoc} */
  @Override
  public boolean isAppliedTo(IsElement<?> element) {
    return cssClass.isAppliedTo(element);
  }

  /** {@inheritDoc} */
  @Override
  public void remove(Element element) {
    cssClass.remove(element);
  }

  /** {@inheritDoc} */
  @Override
  public void remove(IsElement<?> element) {
    cssClass.remove(element);
  }

  /** {@inheritDoc} */
  @Override
  public String getCssClass() {
    return cssClass.getCssClass();
  }
}
