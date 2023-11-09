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
 * A utility class to facilitate the conditional application or removal of CSS classes based on
 * boolean conditions. This class acts as a wrapper around the {@link CssClass} interface, with the
 * provision for conditional application or removal of styles.
 *
 * @see CssClass
 * @author [Your Name or Organization]
 */
public class BooleanCssClass implements CssClass {

  private CssClass cssClass;
  private boolean addRemove;

  /**
   * Creates an instance with a specified {@link CssClass} and a condition flag.
   *
   * @param cssClass The CSS class to be conditionally applied or removed.
   * @param addRemove Condition flag to determine if the class should be applied (true) or removed
   *     (false).
   * @return A new instance of {@code BooleanCssClass}.
   */
  public static BooleanCssClass of(CssClass cssClass, boolean addRemove) {
    return new BooleanCssClass(cssClass, addRemove);
  }

  /**
   * Creates an instance with a specified {@link HasCssClass} and a condition flag. This method
   * extracts the {@link CssClass} from the provided {@link HasCssClass}.
   *
   * @param cssClass The object implementing {@link HasCssClass} whose CSS class will be extracted.
   * @param addRemove Condition flag to determine if the class should be applied (true) or removed
   *     (false).
   * @return A new instance of {@code BooleanCssClass}.
   */
  public static BooleanCssClass of(HasCssClass cssClass, boolean addRemove) {
    return new BooleanCssClass(cssClass.getCssClass(), addRemove);
  }

  /**
   * Creates an instance with a specified CSS class string and a condition flag.
   *
   * @param cssClass The string representation of the CSS class to be conditionally applied or
   *     removed.
   * @param addRemove Condition flag to determine if the class should be applied (true) or removed
   *     (false).
   * @return A new instance of {@code BooleanCssClass}.
   */
  public static BooleanCssClass of(String cssClass, boolean addRemove) {
    return new BooleanCssClass(() -> cssClass, addRemove);
  }

  /**
   * Creates an instance with a specified {@link CssClass} and sets the condition flag to true
   * (class will be applied by default).
   *
   * @param cssClass The CSS class to be conditionally applied.
   * @return A new instance of {@code BooleanCssClass}.
   */
  public static BooleanCssClass of(CssClass cssClass) {
    return new BooleanCssClass(cssClass);
  }

  /**
   * Creates an instance with a specified {@link HasCssClass} and sets the condition flag to true
   * (class will be applied by default). This method extracts the {@link CssClass} from the provided
   * {@link HasCssClass}.
   *
   * @param cssClass The object implementing {@link HasCssClass} whose CSS class will be extracted.
   * @return A new instance of {@code BooleanCssClass}.
   */
  public static BooleanCssClass of(HasCssClass cssClass) {
    return new BooleanCssClass(cssClass.getCssClass());
  }

  /**
   * Creates an instance with a specified CSS class string and sets the condition flag to true
   * (class will be applied by default).
   *
   * @param cssClass The string representation of the CSS class to be conditionally applied.
   * @return A new instance of {@code BooleanCssClass}.
   */
  public static BooleanCssClass of(String cssClass) {
    return new BooleanCssClass(() -> cssClass);
  }

  /**
   * Initializes the {@code BooleanCssClass} with a provided {@link CssClass} and a condition flag.
   *
   * @param cssClass The CSS class to be managed.
   * @param addRemove Condition flag to determine if the class should be applied (true) or removed
   *     (false).
   */
  public BooleanCssClass(CssClass cssClass, boolean addRemove) {
    this.cssClass = cssClass;
    this.addRemove = addRemove;
  }

  /**
   * Constructor that initializes the {@code BooleanCssClass} with a provided {@link CssClass} and
   * sets the condition flag to true (class will be applied by default).
   *
   * @param cssClass The CSS class to be managed.
   */
  public BooleanCssClass(CssClass cssClass) {
    this(cssClass, true);
  }

  /**
   * Applies or removes the CSS class on the provided element based on the condition flag.
   *
   * @param element The DOM element to which the CSS class will be applied or removed.
   */
  @Override
  public void apply(Element element) {
    apply(element, addRemove);
  }

  /**
   * Applies or removes the CSS class on the provided element based on the given condition flag.
   *
   * @param element The DOM element to which the CSS class will be applied or removed.
   * @param addRemove Condition flag to determine if the class should be applied (true) or removed
   *     (false).
   */
  public void apply(Element element, boolean addRemove) {
    if (addRemove) {
      cssClass.apply(element);
    } else {
      remove(element);
    }
  }

  /**
   * Applies or removes the CSS class on the provided {@link IsElement} based on the specified
   * condition.
   *
   * @param element The UI element (implementing {@link IsElement}) on which the CSS class will be
   *     conditionally applied or removed.
   * @param addRemove Condition flag to determine if the class should be applied (true) or removed
   *     (false).
   */
  public void apply(IsElement<?> element, boolean addRemove) {
    apply(element.element(), addRemove);
  }

  /**
   * Checks if the CSS class is applied to the specified DOM {@link Element}.
   *
   * @param element The DOM element to check.
   * @return {@code true} if the CSS class is applied to the element, {@code false} otherwise.
   */
  @Override
  public boolean isAppliedTo(Element element) {
    return cssClass.isAppliedTo(element);
  }

  /**
   * Checks if the CSS class is applied to the specified {@link IsElement}.
   *
   * @param element The UI element (implementing {@link IsElement}) to check.
   * @return {@code true} if the CSS class is applied to the element, {@code false} otherwise.
   */
  @Override
  public boolean isAppliedTo(IsElement<?> element) {
    return cssClass.isAppliedTo(element);
  }

  /**
   * Removes the CSS class from the specified DOM {@link Element}.
   *
   * @param element The DOM element from which the CSS class will be removed.
   */
  @Override
  public void remove(Element element) {
    cssClass.remove(element);
  }

  /**
   * Removes the CSS class from the specified {@link IsElement}.
   *
   * @param element The UI element (implementing {@link IsElement}) from which the CSS class will be
   *     removed.
   */
  @Override
  public void remove(IsElement<?> element) {
    cssClass.remove(element);
  }

  /**
   * Retrieves the CSS class string associated with this instance.
   *
   * @return The string representation of the associated CSS class.
   */
  @Override
  public String getCssClass() {
    return cssClass.getCssClass();
  }
}
