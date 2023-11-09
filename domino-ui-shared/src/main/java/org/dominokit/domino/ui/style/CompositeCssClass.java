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
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import org.dominokit.domino.ui.IsElement;

/**
 * Represents a composite CSS class which can consist of multiple {@link CssClass} instances. This
 * allows for the grouping of multiple CSS classes under a single instance.
 */
public class CompositeCssClass implements CssClass {

  private Set<CssClass> cssClasses = new HashSet<>();

  /**
   * Creates a {@link CompositeCssClass} instance with a collection of {@link CssClass} instances.
   *
   * @param cssClasses A collection of CSS classes.
   * @return A new {@link CompositeCssClass} instance.
   */
  public static CompositeCssClass of(Collection<CssClass> cssClasses) {
    return new CompositeCssClass(cssClasses);
  }

  /**
   * Creates a {@link CompositeCssClass} instance with a varargs of {@link CssClass} instances.
   *
   * @param cssClasses A varargs of CSS classes.
   * @return A new {@link CompositeCssClass} instance.
   */
  public static CompositeCssClass of(CssClass... cssClasses) {
    return new CompositeCssClass(cssClasses);
  }

  /**
   * Creates a {@link CompositeCssClass} instance from the CSS classes of a given DOM {@link
   * Element}.
   *
   * @param element The DOM element from which to extract CSS classes.
   * @return A new {@link CompositeCssClass} instance.
   */
  public static CompositeCssClass of(Element element) {
    return of(
        element.classList.asList().stream()
            .map(s -> (CssClass) () -> s)
            .collect(Collectors.toList()));
  }

  /**
   * Creates a {@link CompositeCssClass} instance from the CSS classes of a given {@link IsElement}.
   *
   * @param element The UI element (implementing {@link IsElement}) from which to extract CSS
   *     classes.
   * @return A new {@link CompositeCssClass} instance.
   */
  public static CompositeCssClass of(IsElement<?> element) {
    return of(element.element());
  }

  /**
   * Constructs a {@link CompositeCssClass} with a collection of {@link CssClass} instances.
   *
   * @param cssClasses A collection of CSS classes.
   */
  public CompositeCssClass(Collection<CssClass> cssClasses) {
    this.cssClasses.addAll(cssClasses);
  }

  /**
   * Constructs a {@link CompositeCssClass} with a varargs of {@link CssClass} instances.
   *
   * @param cssClasses A varargs of CSS classes.
   */
  public CompositeCssClass(CssClass... cssClasses) {
    this(Arrays.asList(cssClasses));
  }

  /**
   * Returns the combined string representation of all {@link CssClass} instances in this composite.
   *
   * @return The combined CSS class string.
   */
  @Override
  public String getCssClass() {
    return cssClasses.stream().map(CssClass::getCssClass).collect(Collectors.joining(" "));
  }

  /**
   * Applies all CSS classes in this composite to the given DOM {@link Element}.
   *
   * @param element The DOM element to which the CSS classes will be applied.
   */
  @Override
  public void apply(Element element) {
    cssClasses.forEach(cssClass -> cssClass.apply(element));
  }

  /**
   * Checks if all CSS classes in this composite are applied to the specified DOM {@link Element}.
   *
   * @param element The DOM element to check.
   * @return {@code true} if all CSS classes are applied to the element, {@code false} otherwise.
   */
  @Override
  public boolean isAppliedTo(Element element) {
    return cssClasses.stream().allMatch(cssClass -> cssClass.isAppliedTo(element));
  }

  /**
   * Checks if all CSS classes in this composite are applied to the specified {@link IsElement}.
   *
   * @param element The UI element (implementing {@link IsElement}) to check.
   * @return {@code true} if all CSS classes are applied to the element, {@code false} otherwise.
   */
  @Override
  public boolean isAppliedTo(IsElement<?> element) {
    return isAppliedTo(element.element());
  }

  /**
   * Checks if the composite contains a specific {@link CssClass}.
   *
   * @param cssClass The CSS class to check for.
   * @return {@code true} if the composite contains the given CSS class, {@code false} otherwise.
   */
  public boolean contains(CssClass cssClass) {
    return cssClasses.stream().anyMatch(c -> c.isSameAs(cssClass));
  }

  /**
   * Returns a set of all {@link CssClass} instances in this composite.
   *
   * @return A set containing all CSS classes in the composite.
   */
  public Set<CssClass> getCssClasses() {
    return cssClasses;
  }

  /**
   * Removes all CSS classes in this composite from the given DOM {@link Element}.
   *
   * @param element The DOM element from which the CSS classes will be removed.
   */
  @Override
  public void remove(Element element) {
    cssClasses.forEach(cssClass -> cssClass.remove(element));
  }

  /**
   * Removes all CSS classes in this composite from the given {@link IsElement}.
   *
   * @param element The UI element (implementing {@link IsElement}) from which the CSS classes will
   *     be removed.
   */
  @Override
  public void remove(IsElement<?> element) {
    remove(element.element());
  }
}
