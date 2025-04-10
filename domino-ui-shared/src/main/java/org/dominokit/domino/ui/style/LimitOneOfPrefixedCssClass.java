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
import java.util.*;

/**
 * A class for managing a set of prefixed CSS classes and ensuring that only one of them is active
 * at a time on a DOM element.
 */
public class LimitOneOfPrefixedCssClass implements CssClass {

  private final Set<String> prefixes;

  private final CssClass cssClass;

  /**
   * Creates a new instance of {@link LimitOneOfPrefixedCssClass} with the specified prefix CSS
   * class name and a string postfix.
   *
   * @param prefixes The base CSS classes names to be replaced.
   * @param cssClass css class to replace all prefixed css classes.
   * @return A new {@link LimitOneOfPrefixedCssClass} instance with the specified css class.
   */
  public static LimitOneOfPrefixedCssClass of(Set<String> prefixes, String cssClass) {
    return new LimitOneOfPrefixedCssClass(prefixes, () -> cssClass);
  }

  /**
   * Creates a new instance of {@link LimitOneOfPrefixedCssClass} with the specified prefix CSS
   * class name and a string postfix.
   *
   * @param prefixes The base CSS classes names to be replaced.
   * @param cssClass css class to replace all prefixed css classes.
   * @return A new {@link LimitOneOfPrefixedCssClass} instance with the specified css class.
   */
  public static LimitOneOfPrefixedCssClass of(Set<String> prefixes, CssClass cssClass) {
    return new LimitOneOfPrefixedCssClass(prefixes, cssClass);
  }

  /**
   * Creates a new instance of {@link LimitOneOfPrefixedCssClass} with the specified prefix CSS
   * class name and a string postfix.
   *
   * @param prefix The base CSS classes names to be replaced.
   * @param cssClass css class to replace all prefixed css classes.
   * @return A new {@link LimitOneOfPrefixedCssClass} instance with the specified css class.
   */
  public static LimitOneOfPrefixedCssClass of(String prefix, String cssClass) {
    return of(
        new HashSet<>() {
          {
            add(prefix);
          }
        },
        cssClass);
  }

  /**
   * Creates a new instance of {@link LimitOneOfPrefixedCssClass} with the specified prefix CSS
   * class name and a string postfix.
   *
   * @param prefix The base CSS classes names to be replaced.
   * @param cssClass css class to replace all prefixed css classes.
   * @return A new {@link LimitOneOfPrefixedCssClass} instance with the specified css class.
   */
  public static LimitOneOfPrefixedCssClass of(String prefix, CssClass cssClass) {
    return of(
        new HashSet<>() {
          {
            add(prefix);
          }
        },
        cssClass);
  }

  /**
   * Creates a new instance of {@link LimitOneOfPrefixedCssClass} with the specified prefix CSS
   * class name and a string postfix.
   *
   * @param cssClass css class to replace all prefixed css classes.
   * @param prefixes The base CSS classes names to be replaced.
   * @return A new {@link LimitOneOfPrefixedCssClass} instance with the specified css class.
   */
  public static LimitOneOfPrefixedCssClass of(CssClass cssClass, String... prefixes) {
    return of(new HashSet<>(Arrays.asList(prefixes)), cssClass);
  }

  /**
   * Creates a new instance of {@link LimitOneOfPrefixedCssClass} with the specified prefix CSS
   * class name and a string postfix.
   *
   * @param cssClass css class to replace all prefixed css classes.
   * @param prefixes The base CSS classes names to be replaced.
   * @return A new {@link LimitOneOfPrefixedCssClass} instance with the specified css class.
   */
  public static LimitOneOfPrefixedCssClass of(String cssClass, String... prefixes) {
    return of(new HashSet<>(Arrays.asList(prefixes)), cssClass);
  }

  /**
   * Creates a PostfixCssClass with the specified base CSS class name and string postfix.
   *
   * @param prefixes The base CSS class name without any postfix.
   * @param cssClass The class to replace prefixed css classes.
   */
  public LimitOneOfPrefixedCssClass(Set<String> prefixes, CssClass cssClass) {
    this.prefixes = prefixes;
    this.cssClass = cssClass;
  }

  /**
   * Removes all css classes that has the same prefix as the baseCssName.
   *
   * @param element The DOM element from which to remove the prefixed CSS classes.
   */
  @Override
  public void remove(Element element) {
    CompositeCssClass.of(element).getCssClasses().stream()
        .filter(
            className ->
                prefixes.stream().anyMatch(prefix -> className.getCssClass().startsWith(prefix)))
        .forEach(css -> css.remove(element));
  }

  /**
   * Applies the active CSS class to the given DOM element if it is in the list of allowed classes.
   *
   * @param element The DOM element to which to apply the active CSS class.
   */
  @Override
  public void apply(Element element) {
    remove(element);
    this.cssClass.apply(element);
  }

  @Override
  public String getCssClass() {
    return this.cssClass.getCssClass();
  }
}
