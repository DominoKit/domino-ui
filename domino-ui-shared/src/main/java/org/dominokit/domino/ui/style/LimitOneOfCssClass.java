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
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * A class for managing a set of allowed CSS classes and ensuring that only one of them is active at
 * a time on a DOM element.
 */
public class LimitOneOfCssClass implements CssClass {

  private final CompositeCssClass allowedClasses;
  private CssClass active = CssClass.NONE;

  /**
   * Creates a new instance of LimitOneOfCssClass with the specified allowed CSS classes.
   *
   * @param allowedClasses An array of allowed CSS classes.
   * @return A new LimitOneOfCssClass instance.
   */
  public static LimitOneOfCssClass of(CssClass... allowedClasses) {
    return new LimitOneOfCssClass(allowedClasses);
  }

  /**
   * Creates a new instance of LimitOneOfCssClass with the specified allowed CSS class names.
   *
   * @param allowedClasses An array of allowed CSS class names.
   * @return A new LimitOneOfCssClass instance.
   */
  public static LimitOneOfCssClass of(String... allowedClasses) {
    return new LimitOneOfCssClass(allowedClasses);
  }

  /**
   * Constructs a LimitOneOfCssClass instance with the specified allowed CSS classes.
   *
   * @param allowedClasses An array of allowed CSS classes.
   */
  public LimitOneOfCssClass(CssClass... allowedClasses) {
    this.allowedClasses = CompositeCssClass.of(allowedClasses);
  }

  /**
   * Constructs a LimitOneOfCssClass instance with the specified allowed CSS class names.
   *
   * @param allowedClasses An array of allowed CSS class names.
   */
  public LimitOneOfCssClass(String... allowedClasses) {
    this.allowedClasses =
        CompositeCssClass.of(
            Arrays.stream(allowedClasses).map(s -> (CssClass) () -> s).collect(Collectors.toSet()));
  }

  /**
   * Constructs a LimitOneOfCssClass instance with the specified allowed CSS classes.
   *
   * @param allowedClasses A collection of allowed CSS classes.
   */
  public LimitOneOfCssClass(Collection<CssClass> allowedClasses) {
    this.allowedClasses = CompositeCssClass.of(allowedClasses);
  }

  /**
   * Sets the active CSS class from the allowed classes.
   *
   * @param activated The CSS class to activate.
   * @return This LimitOneOfCssClass instance.
   */
  public LimitOneOfCssClass use(CssClass activated) {
    if (this.allowedClasses.contains(activated)) {
      this.active = activated;
    }
    return this;
  }

  /**
   * Sets the active CSS class from the allowed classes based on an object implementing HasCssClass.
   *
   * @param activated The object implementing HasCssClass whose CSS class should be activated.
   * @return This LimitOneOfCssClass instance.
   */
  public LimitOneOfCssClass use(HasCssClass activated) {
    if (this.allowedClasses.contains(activated.getCssClass())) {
      this.active = activated.getCssClass();
    }
    return this;
  }

  /**
   * Removes the allowed CSS classes from the given DOM element.
   *
   * @param element The DOM element from which to remove the allowed CSS classes.
   */
  @Override
  public void remove(Element element) {
    allowedClasses.remove(element);
  }

  /**
   * Applies the active CSS class to the given DOM element if it is in the list of allowed classes.
   *
   * @param element The DOM element to which to apply the active CSS class.
   */
  @Override
  public void apply(Element element) {
    if (allowedClasses.contains(active)) {
      allowedClasses.remove(element);
      active.apply(element);
    }
  }

  /**
   * Gets the composite CSS class containing the allowed classes.
   *
   * @return The composite CSS class containing the allowed classes.
   */
  public CompositeCssClass getAllowedClasses() {
    return allowedClasses;
  }

  /**
   * Retrieves the active CSS class applied to a DOM element.
   *
   * @param element The DOM element for which to find the active CSS class.
   * @return An optional containing the active CSS class if found, or an empty optional if none is
   *     found.
   */
  public Optional<CssClass> getActive(Element element) {
    return CompositeCssClass.of(element).getCssClasses().stream()
        .filter(allowedClasses::contains)
        .findFirst();
  }

  /**
   * Gets the CSS class name of the currently active CSS class.
   *
   * @return The CSS class name of the currently active CSS class.
   */
  @Override
  public String getCssClass() {
    return active.getCssClass();
  }
}
