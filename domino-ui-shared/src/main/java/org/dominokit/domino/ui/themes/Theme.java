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

import static elemental2.dom.DomGlobal.document;
import static java.util.Objects.nonNull;

import java.util.ArrayList;
import java.util.List;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.style.Style;

/** Theme class. */
public class Theme {

  private static List<ThemeChangeHandler> themeChangeHandlers = new ArrayList<>();

  /** Constant <code>RED</code> */
  public static final ColorScheme RED = ColorScheme.RED;

  /** Constant <code>PINK</code> */
  public static final ColorScheme PINK = ColorScheme.PINK;

  /** Constant <code>PURPLE</code> */
  public static final ColorScheme PURPLE = ColorScheme.PURPLE;

  /** Constant <code>DEEP_PURPLE</code> */
  public static final ColorScheme DEEP_PURPLE = ColorScheme.DEEP_PURPLE;

  /** Constant <code>INDIGO</code> */
  public static final ColorScheme INDIGO = ColorScheme.INDIGO;

  /** Constant <code>BLUE</code> */
  public static final ColorScheme BLUE = ColorScheme.BLUE;

  /** Constant <code>LIGHT_BLUE</code> */
  public static final ColorScheme LIGHT_BLUE = ColorScheme.LIGHT_BLUE;

  /** Constant <code>CYAN</code> */
  public static final ColorScheme CYAN = ColorScheme.CYAN;

  /** Constant <code>TEAL</code> */
  public static final ColorScheme TEAL = ColorScheme.TEAL;

  /** Constant <code>GREEN</code> */
  public static final ColorScheme GREEN = ColorScheme.GREEN;

  /** Constant <code>LIGHT_GREEN</code> */
  public static final ColorScheme LIGHT_GREEN = ColorScheme.LIGHT_GREEN;

  /** Constant <code>LIME</code> */
  public static final ColorScheme LIME = ColorScheme.LIME;

  /** Constant <code>YELLOW</code> */
  public static final ColorScheme YELLOW = ColorScheme.YELLOW;

  /** Constant <code>AMBER</code> */
  public static final ColorScheme AMBER = ColorScheme.AMBER;

  /** Constant <code>ORANGE</code> */
  public static final ColorScheme ORANGE = ColorScheme.ORANGE;

  /** Constant <code>DEEP_ORANGE</code> */
  public static final ColorScheme DEEP_ORANGE = ColorScheme.DEEP_ORANGE;

  /** Constant <code>BROWN</code> */
  public static final ColorScheme BROWN = ColorScheme.BROWN;

  /** Constant <code>GREY</code> */
  public static final ColorScheme GREY = ColorScheme.GREY;

  /** Constant <code>BLUE_GREY</code> */
  public static final ColorScheme BLUE_GREY = ColorScheme.BLUE_GREY;

  /** Constant <code>BLACK</code> */
  public static final ColorScheme BLACK = ColorScheme.BLACK;

  /** Constant <code>WHITE</code> */
  public static final ColorScheme WHITE = ColorScheme.WHITE;

  /** Constant <code>TRANSPARENT</code> */
  public static final ColorScheme TRANSPARENT = ColorScheme.TRANSPARENT;

  private final ColorScheme scheme;
  private final String themeStyle;
  private final String name;

  /** Constant <code>currentTheme</code> */
  public static Theme currentTheme = new Theme(ColorScheme.RED);

  /**
   * Constructor for Theme.
   *
   * @param scheme a {@link org.dominokit.domino.ui.style.ColorScheme} object.
   */
  public Theme(ColorScheme scheme) {
    this.scheme = scheme;
    this.themeStyle = scheme.color().getCss().getCssClass();
    this.name = scheme.color().getName().replace(" ", "_").toLowerCase();
  }

  /**
   * Getter for the field <code>scheme</code>.
   *
   * @return a {@link org.dominokit.domino.ui.style.ColorScheme} object.
   */
  public ColorScheme getScheme() {
    return scheme;
  }

  /**
   * Getter for the field <code>themeStyle</code>.
   *
   * @return a {@link java.lang.String} object.
   */
  public String getThemeStyle() {
    return themeStyle;
  }

  /**
   * Getter for the field <code>name</code>.
   *
   * @return a {@link java.lang.String} object.
   */
  public String getName() {
    return name;
  }

  /**
   * addThemeChangeHandler.
   *
   * @param themeChangeHandler a {@link org.dominokit.domino.ui.themes.Theme.ThemeChangeHandler}
   *     object.
   */
  public static void addThemeChangeHandler(ThemeChangeHandler themeChangeHandler) {
    themeChangeHandlers.add(themeChangeHandler);
  }

  /**
   * removeThemeChangeHandler.
   *
   * @param themeChangeHandler a {@link org.dominokit.domino.ui.themes.Theme.ThemeChangeHandler}
   *     object.
   */
  public static void removeThemeChangeHandler(ThemeChangeHandler themeChangeHandler) {
    themeChangeHandlers.remove(themeChangeHandler);
  }

  /** apply. */
  public void apply() {
    Theme oldTheme = currentTheme;
    if (nonNull(currentTheme)) document.body.classList.remove(currentTheme.themeStyle);
    this.currentTheme = this;
    Style.of(document.body).addCss(themeStyle);
    themeChangeHandlers.forEach(
        themeChangeHandler -> themeChangeHandler.onThemeChanged(oldTheme, this));
  }

  @FunctionalInterface
  public interface ThemeChangeHandler {
    void onThemeChanged(Theme oldTheme, Theme newTheme);
  }
}
