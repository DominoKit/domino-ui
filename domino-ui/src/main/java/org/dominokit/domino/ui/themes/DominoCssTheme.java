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
package org.dominokit.domino.ui.themes;

import elemental2.dom.Element;
import org.dominokit.domino.ui.style.CssClass;

/**
 * A small {@link IsDominoTheme} implementation for themes represented by one CSS class.
 *
 * <p>The class adds Domino UI's marker class together with the configured theme class, allowing a
 * consumer to define the corresponding custom-property overrides in CSS. The custom stylesheet
 * should scope those overrides to the themed {@code .dui} root.
 */
public final class DominoCssTheme implements IsDominoTheme {

  private final String name;
  private final String category;
  private final CssClass cssClass;
  private final boolean clear;

  private DominoCssTheme(String name, String category, CssClass cssClass, boolean clear) {
    this.name = requireValue(name, "name");
    this.category = requireValue(category, "category");
    this.cssClass = cssClass;
    this.clear = clear;
  }

  /**
   * Creates a theme backed by one CSS class token.
   *
   * @param name persisted/display name of the theme
   * @param category manager category in which the theme replaces another theme
   * @param cssClass CSS class defining the theme's custom-property overrides
   * @return a validated CSS-backed theme
   * @throws IllegalArgumentException when a value is empty or the class is not one CSS token
   */
  public static DominoCssTheme of(String name, String category, String cssClass) {
    validateCssClass(cssClass);
    return new DominoCssTheme(name, category, () -> cssClass, false);
  }

  /**
   * Creates a clear descriptor for a category that has no CSS class of its own.
   *
   * <p>When applied through a theme manager, this descriptor replaces the currently active theme in
   * its category and leaves that category unmarked. It still applies the standard {@code dui}
   * marker required by Domino UI's scoped CSS.
   *
   * @param name persisted/display name of the clear option
   * @param category manager category to clear
   * @return a validated no-class theme descriptor
   */
  public static DominoCssTheme clear(String name, String category) {
    return new DominoCssTheme(name, category, () -> "", true);
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getCategory() {
    return category;
  }

  @Override
  public void apply(Element element) {
    if (clear) {
      elementOf(element).addCss(dui);
    } else {
      elementOf(element).addCss(dui, cssClass);
    }
  }

  @Override
  public void cleanup(Element element) {
    // The marker may also belong to another active Domino UI theme on this root.
    if (!clear) {
      elementOf(element).removeCss(cssClass);
    }
  }

  @Override
  public boolean isApplied(Element element) {
    return !clear && cssClass.isAppliedTo(element);
  }

  private static String requireValue(String value, String label) {
    if (value == null || value.trim().isEmpty()) {
      throw new IllegalArgumentException("Theme " + label + " must not be empty");
    }
    return value;
  }

  private static void validateCssClass(String cssClass) {
    if (cssClass == null || cssClass.isEmpty()) {
      throw new IllegalArgumentException("Theme CSS class must not be empty");
    }

    char first = cssClass.charAt(0);
    if (!isAsciiLetter(first) && first != '_') {
      throw new IllegalArgumentException("Theme CSS class must start with a letter or underscore");
    }

    for (int index = 1; index < cssClass.length(); index++) {
      char character = cssClass.charAt(index);
      if (!isAsciiLetter(character)
          && !isAsciiDigit(character)
          && character != '_'
          && character != '-') {
        throw new IllegalArgumentException("Theme CSS class must be one CSS class token");
      }
    }
  }

  private static boolean isAsciiLetter(char character) {
    return (character >= 'a' && character <= 'z') || (character >= 'A' && character <= 'Z');
  }

  private static boolean isAsciiDigit(char character) {
    return character >= '0' && character <= '9';
  }
}
