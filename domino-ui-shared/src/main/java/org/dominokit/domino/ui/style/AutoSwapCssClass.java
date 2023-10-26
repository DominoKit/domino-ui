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
 * Represents a CSS class handler with an automatic swap mechanism between two CSS classes.
 *
 * <p>The {@code AutoSwapCssClass} allows for automatic swapping between two specified CSS classes
 * whenever {@link #apply(Element)} is called. This can be useful for toggling between two styles
 * without the need for additional logic.
 *
 * @see CssClass
 */
public class AutoSwapCssClass implements CssClass {

  private CssClass first = CssClass.NONE;
  private CssClass second = CssClass.NONE;

  /**
   * Factory method to create an instance of {@code AutoSwapCssClass} with two {@link CssClass}
   * objects.
   *
   * @param first The first CSS class.
   * @param second The second CSS class.
   * @return An instance of {@code AutoSwapCssClass}.
   */
  public static AutoSwapCssClass of(CssClass first, CssClass second) {
    return new AutoSwapCssClass(first, second);
  }

  /**
   * Factory method to create an instance of {@code AutoSwapCssClass} with two {@link HasCssClass}
   * objects.
   *
   * @param first The first CSS class holder.
   * @param second The second CSS class holder.
   * @return An instance of {@code AutoSwapCssClass}.
   */
  public static AutoSwapCssClass of(HasCssClass first, HasCssClass second) {
    return new AutoSwapCssClass(first.getCssClass(), second.getCssClass());
  }

  /**
   * Factory method to create an instance of {@code AutoSwapCssClass} with two strings representing
   * CSS classes.
   *
   * @param first The first CSS class as a string.
   * @param second The second CSS class as a string.
   * @return An instance of {@code AutoSwapCssClass}.
   */
  public static AutoSwapCssClass of(String first, String second) {
    return new AutoSwapCssClass(first, second);
  }

  /** Default constructor. */
  public AutoSwapCssClass() {}

  /**
   * Constructs an {@code AutoSwapCssClass} with two {@link CssClass} objects.
   *
   * @param first The first CSS class.
   * @param second The second CSS class.
   */
  public AutoSwapCssClass(CssClass first, CssClass second) {
    this.first = first;
    this.second = second;
  }

  /**
   * Constructs an {@code AutoSwapCssClass} with two strings representing CSS classes.
   *
   * @param first The first CSS class as a string.
   * @param second The second CSS class as a string.
   */
  public AutoSwapCssClass(String first, String second) {
    this.first = () -> first;
    this.second = () -> second;
  }

  /**
   * Removes both CSS classes from the provided {@link Element}.
   *
   * @param element The DOM element from which the CSS classes should be removed.
   */
  @Override
  public void remove(Element element) {
    if (nonNull(first)) {
      first.remove(element);
    }

    if (nonNull(second)) {
      second.remove(element);
    }
  }

  /**
   * Swaps the two CSS classes and applies the "current" one to the provided {@link Element}.
   *
   * <p>This will remove the current CSS class and apply the other one. On subsequent calls, the two
   * classes will keep swapping.
   *
   * @param element The DOM element to which the CSS class should be applied.
   */
  @Override
  public void apply(Element element) {
    first.remove(element);
    second.apply(element);
    CssClass temp = first;
    first = second;
    second = temp;
  }

  /**
   * Returns the first (or current) CSS class.
   *
   * @return The first CSS class.
   */
  public CssClass getFirst() {
    return first;
  }

  /**
   * Returns the second (or swapped) CSS class.
   *
   * @return The second CSS class.
   */
  public CssClass getSecond() {
    return second;
  }

  /**
   * Returns the current CSS class as a string.
   *
   * @return The CSS class string.
   */
  @Override
  public String getCssClass() {
    return first.getCssClass();
  }
}
