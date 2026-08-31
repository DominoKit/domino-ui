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

/**
 * Independently composable surface treatments.
 *
 * <p>Bordered, elevated, and rounded use separate manager categories, so an application can apply
 * any combination. The corresponding clear descriptor removes only its own surface treatment.
 */
public final class DominoThemeSurface {

  public static final IsDominoTheme BORDERED =
      theme("dui-theme-bordered", DominoThemeCategories.SURFACE_BORDER);
  public static final IsDominoTheme CLEAR_BORDER =
      DominoCssTheme.clear("dui-theme-border-default", DominoThemeCategories.SURFACE_BORDER);

  public static final IsDominoTheme ELEVATED =
      theme("dui-theme-elevated", DominoThemeCategories.SURFACE_ELEVATION);
  public static final IsDominoTheme CLEAR_ELEVATION =
      DominoCssTheme.clear("dui-theme-elevation-default", DominoThemeCategories.SURFACE_ELEVATION);

  public static final IsDominoTheme ROUNDED =
      theme("dui-theme-rounded", DominoThemeCategories.SURFACE_RADIUS);
  public static final IsDominoTheme CLEAR_RADIUS =
      DominoCssTheme.clear("dui-theme-radius-default", DominoThemeCategories.SURFACE_RADIUS);

  private DominoThemeSurface() {}

  private static IsDominoTheme theme(String name, String category) {
    return DominoCssTheme.of(name, category, name);
  }
}
