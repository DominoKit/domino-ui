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

/** Standard categories used by Domino UI's built-in theme manager. */
public final class DominoThemeCategories {

  /** The base component-token theme category. */
  public static final String MAIN = "dui-main-theme";

  /** The light/dark color-mode category. */
  public static final String COLOR_MODE = "dui-dark-mode";

  /** The accent/brand color category. */
  public static final String ACCENT = "dui-theme-accent";

  /** The visual identity category, such as Ocean or Forest. */
  public static final String IDENTITY = "dui-theme-identity";

  /** The character/material category, such as Glass or Terminal. */
  public static final String CHARACTER = "dui-theme-character";

  /** The spacing and control-density category. */
  public static final String DENSITY = "dui-theme-density";

  /** The composable border surface category. */
  public static final String SURFACE_BORDER = "dui-theme-surface-border";

  /** The composable elevation surface category. */
  public static final String SURFACE_ELEVATION = "dui-theme-surface-elevation";

  /** The composable radius surface category. */
  public static final String SURFACE_RADIUS = "dui-theme-surface-radius";

  private DominoThemeCategories() {}
}
