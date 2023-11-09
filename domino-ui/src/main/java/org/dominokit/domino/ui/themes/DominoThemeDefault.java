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
 * Represents the default theme for Domino UI components.
 *
 * <p>This class provides methods to apply, check, and remove the default theme on a specific UI
 * element.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>{@code
 * DominoThemeDefault defaultTheme = DominoThemeDefault.INSTANCE;
 * defaultTheme.apply(myElement);
 * }</pre>
 *
 * @see IsDominoTheme
 * @see CssClass
 */
public class DominoThemeDefault implements IsDominoTheme {

  /** Singleton instance of {@link DominoThemeDefault}. */
  public static final IsDominoTheme INSTANCE = new DominoThemeDefault();

  /** CSS class representing the default theme. */
  private CssClass dui_theme_default = () -> "dui-theme-default";

  /**
   * Retrieves the name of the theme.
   *
   * @return theme name as a string.
   */
  @Override
  public String getName() {
    return "dui-default";
  }

  /**
   * Retrieves the category of the theme.
   *
   * @return theme category as a string.
   */
  @Override
  public String getCategory() {
    return "dui-main-theme";
  }

  /**
   * Applies the default theme to the specified element.
   *
   * @param element target element to apply the theme on.
   */
  @Override
  public void apply(Element element) {
    elementOf(element).addCss(dui, dui_theme_default);
  }

  /**
   * Removes the default theme from the specified element.
   *
   * @param element target element to remove the theme from.
   */
  @Override
  public void cleanup(Element element) {
    elementOf(element).removeCss(dui, dui_theme_default);
  }

  /**
   * Checks if the default theme is applied to the specified element.
   *
   * @param element the target element to check.
   * @return {@code true} if the theme is applied, otherwise {@code false}.
   */
  @Override
  public boolean isApplied(Element element) {
    return dui_theme_default.isAppliedTo(element);
  }
}
