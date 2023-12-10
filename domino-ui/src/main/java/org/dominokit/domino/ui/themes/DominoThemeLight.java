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

import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.Element;
import org.dominokit.domino.ui.style.CssClass;

/**
 * Represents the light theme for Domino UI components.
 *
 * <p>This class provides methods to apply, check, and remove the light theme on a specific UI
 * element.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>{@code
 * DominoThemeLight lightTheme = DominoThemeLight.INSTANCE;
 * lightTheme.apply(myElement);
 * }</pre>
 *
 * @see IsDominoTheme
 * @see CssClass
 */
public class DominoThemeLight implements IsDominoTheme {

  /** Singleton instance of {@link DominoThemeLight}. */
  public static final IsDominoTheme INSTANCE = new DominoThemeLight();

  /** CSS class representing the light theme. */
  private CssClass dui_theme_light = () -> "dui-colors-light";

  /**
   * Retrieves the name of the theme.
   *
   * @return theme name as a string.
   */
  @Override
  public String getName() {
    return "dui-theme-light";
  }

  /**
   * Retrieves the category of the theme.
   *
   * @return theme category as a string. In this case, it's categorized under "dui-dark-mode" to
   *     suggest that this theme is the opposite of the dark mode.
   */
  @Override
  public String getCategory() {
    return "dui-dark-mode";
  }

  /**
   * Applies the light theme to the specified element.
   *
   * @param element target element to apply the theme on.
   */
  @Override
  public void apply(Element element) {
    elementOf(element).addCss(dui_theme_light);
  }

  /**
   * Removes the light theme from the specified element.
   *
   * @param element target element to remove the theme from.
   */
  @Override
  public void cleanup(Element element) {
    elementOf(element).removeCss(dui_theme_light);
  }

  /**
   * Checks if the light theme is applied to the specified element.
   *
   * @param element the target element to check.
   * @return {@code true} if the theme is applied, otherwise {@code false}.
   */
  @Override
  public boolean isApplied(Element element) {
    return dui_theme_light.isAppliedTo(element);
  }
}
