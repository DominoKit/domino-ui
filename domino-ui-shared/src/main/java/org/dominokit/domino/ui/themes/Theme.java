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
/**
 * The Theme class represents a color theme for a user interface. It provides a set of predefined
 * color schemes and allows changing the current theme dynamically.
 */
package org.dominokit.domino.ui.themes;

import static elemental2.dom.DomGlobal.document;
import static java.util.Objects.nonNull;

import java.util.ArrayList;
import java.util.List;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.style.Style;

public class Theme {

  private static List<ThemeChangeHandler> themeChangeHandlers = new ArrayList<>();

  /** Predefined color scheme: Red. */
  public static final ColorScheme RED = ColorScheme.RED;

  /** Predefined color scheme: Pink. */
  public static final ColorScheme PINK = ColorScheme.PINK;

  /** Predefined color scheme: Purple. */
  public static final ColorScheme PURPLE = ColorScheme.PURPLE;

  public static final ColorScheme DEEP_PURPLE = ColorScheme.DEEP_PURPLE;

  public static final ColorScheme INDIGO = ColorScheme.INDIGO;

  public static final ColorScheme BLUE = ColorScheme.BLUE;

  public static final ColorScheme LIGHT_BLUE = ColorScheme.LIGHT_BLUE;

  public static final ColorScheme CYAN = ColorScheme.CYAN;

  public static final ColorScheme TEAL = ColorScheme.TEAL;

  public static final ColorScheme GREEN = ColorScheme.GREEN;

  public static final ColorScheme LIGHT_GREEN = ColorScheme.LIGHT_GREEN;

  public static final ColorScheme LIME = ColorScheme.LIME;

  public static final ColorScheme YELLOW = ColorScheme.YELLOW;

  public static final ColorScheme AMBER = ColorScheme.AMBER;

  public static final ColorScheme ORANGE = ColorScheme.ORANGE;

  public static final ColorScheme DEEP_ORANGE = ColorScheme.DEEP_ORANGE;

  public static final ColorScheme BROWN = ColorScheme.BROWN;

  public static final ColorScheme GREY = ColorScheme.GREY;

  public static final ColorScheme BLUE_GREY = ColorScheme.BLUE_GREY;

  public static final ColorScheme BLACK = ColorScheme.BLACK;

  public static final ColorScheme WHITE = ColorScheme.WHITE;

  public static final ColorScheme TRANSPARENT = ColorScheme.TRANSPARENT;

  private final ColorScheme scheme;
  private final String themeStyle;
  private final String name;

  /** The currently active theme. */
  public static Theme currentTheme = new Theme(ColorScheme.RED);

  /**
   * Creates a new Theme instance with the specified color scheme.
   *
   * @param scheme The color scheme for this theme.
   */
  public Theme(ColorScheme scheme) {
    this.scheme = scheme;
    this.themeStyle = scheme.color().getCss().getCssClass();
    this.name = scheme.color().getName().replace(" ", "_").toLowerCase();
  }

  /**
   * Gets the color scheme associated with this theme.
   *
   * @return The color scheme.
   */
  public ColorScheme getScheme() {
    return scheme;
  }

  /**
   * Gets the CSS class representing the theme's style.
   *
   * @return The CSS class.
   */
  public String getThemeStyle() {
    return themeStyle;
  }

  /**
   * Gets the name of the theme.
   *
   * @return The name of the theme.
   */
  public String getName() {
    return name;
  }

  /**
   * Adds a theme change handler to be notified when the theme changes.
   *
   * @param themeChangeHandler The theme change handler to add.
   */
  public static void addThemeChangeHandler(ThemeChangeHandler themeChangeHandler) {
    themeChangeHandlers.add(themeChangeHandler);
  }

  /**
   * Removes a theme change handler.
   *
   * @param themeChangeHandler The theme change handler to remove.
   */
  public static void removeThemeChangeHandler(ThemeChangeHandler themeChangeHandler) {
    themeChangeHandlers.remove(themeChangeHandler);
  }

  /** Applies this theme to the document's body element, changing the UI's color scheme. */
  public void apply() {
    Theme oldTheme = currentTheme;
    if (nonNull(currentTheme)) document.body.classList.remove(currentTheme.themeStyle);
    this.currentTheme = this;
    Style.of(document.body).addCss(themeStyle);
    themeChangeHandlers.forEach(
        themeChangeHandler -> themeChangeHandler.onThemeChanged(oldTheme, this));
  }

  /** A functional interface for handling theme change events. */
  @FunctionalInterface
  public interface ThemeChangeHandler {
    /**
     * Called when the theme changes.
     *
     * @param oldTheme The previous theme.
     * @param newTheme The new theme.
     */
    void onThemeChanged(Theme oldTheme, Theme newTheme);
  }
}
