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
import java.util.function.Supplier;
import org.dominokit.domino.ui.IsElement;

/**
 * A utility class to facilitate the conditional application or removal of CSS classes based on
 * boolean conditions. This class acts as a wrapper around the {@link CssClass} interface, with the
 * provision for conditional application or removal of styles.
 *
 * @see CssClass
 * @author [Your Name or Organization]
 */
public class ConditionalCssClass implements CssClass {

  private CssClass cssClass;
  private Supplier<Boolean> condition;

  /**
   * Creates an instance with a specified {@link CssClass} and a condition flag.
   *
   * @param cssClass The CSS class to be conditionally applied or removed.
   * @param condition Condition flag to determine if the class should be applied (true) or removed
   *     (false).
   * @return A new instance of {@code ConditionalCssClass}.
   */
  public static ConditionalCssClass of(CssClass cssClass, Supplier<Boolean> condition) {
    return new ConditionalCssClass(cssClass, condition);
  }

  /**
   * Creates an instance with a specified {@link HasCssClass} and a condition flag. This method
   * extracts the {@link CssClass} from the provided {@link HasCssClass}.
   *
   * @param cssClass The object implementing {@link HasCssClass} whose CSS class will be extracted.
   * @param condition Condition flag to determine if the class should be applied (true) or removed
   *     (false).
   * @return A new instance of {@code ConditionalCssClass}.
   */
  public static ConditionalCssClass of(HasCssClass cssClass, Supplier<Boolean> condition) {
    return new ConditionalCssClass(cssClass.getCssClass(), condition);
  }

  /**
   * Creates an instance with a specified CSS class string and a condition flag.
   *
   * @param cssClass The string representation of the CSS class to be conditionally applied or
   *     removed.
   * @param condition Condition flag to determine if the class should be applied (true) or removed
   *     (false).
   * @return A new instance of {@code ConditionalCssClass}.
   */
  public static ConditionalCssClass of(String cssClass, Supplier<Boolean> condition) {
    return new ConditionalCssClass(() -> cssClass, condition);
  }

  /**
   * Initializes the {@code ConditionalCssClass} with a provided {@link CssClass} and a condition
   * flag.
   *
   * @param cssClass The CSS class to be managed.
   * @param condition Condition flag to determine if the class should be applied (true) or removed
   *     (false).
   */
  public ConditionalCssClass(CssClass cssClass, Supplier<Boolean> condition) {
    this.cssClass = cssClass;
    this.condition = condition;
  }

  /**
   * Applies or removes the CSS class on the provided element based on the condition flag.
   *
   * @param element The DOM element to which the CSS class will be applied or removed.
   */
  @Override
  public void apply(Element element) {
    apply(element, condition);
  }

  /**
   * Applies or removes the CSS class on the provided element based on the given condition flag.
   *
   * @param element The DOM element to which the CSS class will be applied or removed.
   * @param condition Condition flag to determine if the class should be applied (true) or removed
   *     (false).
   */
  public void apply(Element element, Supplier<Boolean> condition) {
    if (condition.get()) {
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
   * @param condition Condition flag to determine if the class should be applied (true) or removed
   *     (false).
   */
  public void apply(IsElement<?> element, Supplier<Boolean> condition) {
    apply(element.element(), condition);
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
