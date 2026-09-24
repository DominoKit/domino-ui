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
 * Built-in visual identity themes.
 *
 * <p>Include {@code domino-ui-themes.css}, or the individual identity stylesheet, before applying
 * one of these descriptors. Identity themes occupy their own manager category and can be composed
 * with color mode, accent, density, character, and surface themes.
 */
public final class DominoThemeIdentity {

  public static final IsDominoTheme OCEAN = theme("ocean");
  public static final IsDominoTheme FOREST = theme("forest");
  public static final IsDominoTheme SANDSTONE = theme("sandstone");
  public static final IsDominoTheme GRAPHITE = theme("graphite");
  public static final IsDominoTheme LAVENDER = theme("lavender");
  public static final IsDominoTheme SUNSET = theme("sunset");
  public static final IsDominoTheme ARCTIC = theme("arctic");
  public static final IsDominoTheme ROSE = theme("rose");
  public static final IsDominoTheme CRIMSON = theme("crimson");
  public static final IsDominoTheme AMETHYST = theme("amethyst");
  public static final IsDominoTheme INDIGO = theme("indigo");
  public static final IsDominoTheme AZURE = theme("azure");
  public static final IsDominoTheme LAGOON = theme("lagoon");
  public static final IsDominoTheme JADE = theme("jade");
  public static final IsDominoTheme MEADOW = theme("meadow");
  public static final IsDominoTheme LIME = theme("lime");
  public static final IsDominoTheme MARIGOLD = theme("marigold");
  public static final IsDominoTheme AMBER = theme("amber");

  private DominoThemeIdentity() {}

  private static IsDominoTheme theme(String name) {
    String cssClass = "dui-theme-" + name;
    return DominoCssTheme.of(cssClass, DominoThemeCategories.IDENTITY, cssClass);
  }
}
