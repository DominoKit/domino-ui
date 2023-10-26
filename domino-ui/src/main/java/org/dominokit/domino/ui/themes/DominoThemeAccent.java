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
import org.dominokit.domino.ui.style.DominoCss;
import org.dominokit.domino.ui.utils.ElementsFactory;

/**
 * Represents the accent themes for Domino UI components.
 *
 * <p>This class provides predefined accent themes and methods to apply, check, and remove these
 * accent themes on a specific UI element.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>{@code
 * DominoThemeAccent accentTheme = DominoThemeAccent.RED;
 * accentTheme.apply(myElement);
 * }</pre>
 *
 * @see IsDominoTheme
 * @see CssClass
 * @see ElementsFactory
 * @see DominoCss
 */
public class DominoThemeAccent implements IsDominoTheme, ElementsFactory, DominoCss {

  // Predefined accent themes.
  public static final IsDominoTheme RED = new DominoThemeAccent(dui_accent_red);
  public static final IsDominoTheme PINK = new DominoThemeAccent(dui_accent_pink);
  public static final IsDominoTheme PURPLE = new DominoThemeAccent(dui_accent_purple);
  public static final IsDominoTheme DEEP_PURPLE = new DominoThemeAccent(dui_accent_deep_purple);
  public static final IsDominoTheme INDIGO = new DominoThemeAccent(dui_accent_indigo);
  public static final IsDominoTheme BLUE = new DominoThemeAccent(dui_accent_blue);
  public static final IsDominoTheme LIGHT_BLUE = new DominoThemeAccent(dui_accent_light_blue);
  public static final IsDominoTheme CYAN = new DominoThemeAccent(dui_accent_cyan);
  public static final IsDominoTheme TEAL = new DominoThemeAccent(dui_accent_teal);
  public static final IsDominoTheme GREEN = new DominoThemeAccent(dui_accent_green);
  public static final IsDominoTheme LIGHT_GREEN = new DominoThemeAccent(dui_accent_light_green);
  public static final IsDominoTheme LIME = new DominoThemeAccent(dui_accent_lime);
  public static final IsDominoTheme YELLOW = new DominoThemeAccent(dui_accent_yellow);
  public static final IsDominoTheme AMBER = new DominoThemeAccent(dui_accent_amber);
  public static final IsDominoTheme ORANGE = new DominoThemeAccent(dui_accent_red);
  public static final IsDominoTheme DEEP_ORANGE = new DominoThemeAccent(dui_accent_deep_orange);
  public static final IsDominoTheme BROWN = new DominoThemeAccent(dui_accent_brown);
  public static final IsDominoTheme GREY = new DominoThemeAccent(dui_accent_grey);
  public static final IsDominoTheme BLUE_GREY = new DominoThemeAccent(dui_accent_blue_grey);

  /** CSS class representing the specific accent theme. */
  private final CssClass accentCss;

  /**
   * Constructor to create an accent theme with the specified CSS class.
   *
   * @param accentCss the CSS class for the accent theme.
   */
  private DominoThemeAccent(CssClass accentCss) {
    this.accentCss = accentCss;
  }

  /**
   * Retrieves the name of the accent theme.
   *
   * @return accent theme name as a string.
   */
  @Override
  public String getName() {
    return "dui-theme-accent-" + accentCss.getCssClass().replace("dui-accent-", "");
  }

  /**
   * Retrieves the category of the accent theme.
   *
   * @return accent theme category as a string. All accent themes are categorized under
   *     "dui-theme-accent".
   */
  @Override
  public String getCategory() {
    return "dui-theme-accent";
  }

  /**
   * Applies the accent theme to the specified element.
   *
   * @param element target element to apply the accent theme on.
   */
  @Override
  public void apply(Element element) {
    elementOf(element).addCss(accentCss);
  }

  /**
   * Removes the accent theme from the specified element.
   *
   * @param element target element to remove the accent theme from.
   */
  @Override
  public void cleanup(Element element) {
    elementOf(element).removeCss(accentCss);
  }

  /**
   * Checks if the accent theme is applied to the specified element.
   *
   * @param element the target element to check.
   * @return {@code true} if the accent theme is applied, otherwise {@code false}.
   */
  @Override
  public boolean isApplied(Element element) {
    return accentCss.isAppliedTo(element);
  }
}
