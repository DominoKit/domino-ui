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
 * Built-in character/material themes.
 *
 * <p>Include {@code domino-ui-themes.css}, or the individual character stylesheet, before applying
 * one of these descriptors. Character themes occupy their own manager category and preserve the
 * selected identity, accent, density, and surface choices.
 */
public final class DominoThemeCharacter {

  public static final IsDominoTheme CARBON = theme("carbon");
  public static final IsDominoTheme PAPER = theme("paper");
  public static final IsDominoTheme TERMINAL = theme("terminal");
  public static final IsDominoTheme GLASS = theme("glass");
  public static final IsDominoTheme BLUEPRINT = theme("blueprint");
  public static final IsDominoTheme HIGH_CONTRAST = theme("high-contrast");
  public static final IsDominoTheme EDITORIAL = theme("editorial");
  public static final IsDominoTheme SOFT_UI = theme("soft-ui");
  public static final IsDominoTheme NEON_NIGHT = theme("neon-night");
  public static final IsDominoTheme RETRO_CONSOLE = theme("retro-console");
  public static final IsDominoTheme AURORA = theme("aurora");

  private DominoThemeCharacter() {}

  private static IsDominoTheme theme(String name) {
    String cssClass = "dui-theme-" + name;
    return DominoCssTheme.of(cssClass, DominoThemeCategories.CHARACTER, cssClass);
  }
}
