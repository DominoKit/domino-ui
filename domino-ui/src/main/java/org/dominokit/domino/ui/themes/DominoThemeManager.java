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

import static java.util.Objects.isNull;

import elemental2.dom.DomGlobal;
import elemental2.webstorage.WebStorageWindow;
import java.util.*;
import java.util.stream.Collectors;

public class DominoThemeManager {

  public static final DominoThemeManager INSTANCE = new DominoThemeManager();

  private final Map<String, IsDominoTheme> byCategory = new HashMap<>();
  private final Map<String, IsDominoTheme> registeredThemes = new HashMap<>();

  private DominoThemeManager() {
    registerTheme(DominoThemeDefault.INSTANCE);
    registerTheme(DominoThemeLight.INSTANCE);
    registerTheme(DominoThemeDark.INSTANCE);
    registerTheme(DominoThemeAccent.RED);
    registerTheme(DominoThemeAccent.PINK);
    registerTheme(DominoThemeAccent.PURPLE);
    registerTheme(DominoThemeAccent.DEEP_PURPLE);
    registerTheme(DominoThemeAccent.INDIGO);
    registerTheme(DominoThemeAccent.BLUE);
    registerTheme(DominoThemeAccent.LIGHT_BLUE);
    registerTheme(DominoThemeAccent.CYAN);
    registerTheme(DominoThemeAccent.TEAL);
    registerTheme(DominoThemeAccent.GREEN);
    registerTheme(DominoThemeAccent.LIGHT_GREEN);
    registerTheme(DominoThemeAccent.LIME);
    registerTheme(DominoThemeAccent.YELLOW);
    registerTheme(DominoThemeAccent.AMBER);
    registerTheme(DominoThemeAccent.ORANGE);
    registerTheme(DominoThemeAccent.DEEP_ORANGE);
    registerTheme(DominoThemeAccent.BROWN);
    registerTheme(DominoThemeAccent.GREY);
    registerTheme(DominoThemeAccent.BLUE_GREY);
  }

  public DominoThemeManager apply(IsDominoTheme theme) {
    if (byCategory.containsKey(theme.getCategory())) {
      byCategory.get(theme.getCategory()).cleanup();
    }

    byCategory.put(theme.getCategory(), theme);
    theme.apply();
    updateUserThemes();
    return INSTANCE;
  }

  public DominoThemeManager remove(String themeName) {
    Optional<IsDominoTheme> theme =
        byCategory.values().stream().filter(t -> t.getName().equals(themeName)).findFirst();
    theme.ifPresent(
        t -> {
          t.cleanup();
          byCategory.remove(t.getCategory());
        });
    updateUserThemes();
    return INSTANCE;
  }

  public DominoThemeManager registerTheme(IsDominoTheme theme) {
    registeredThemes.put(theme.getName(), theme);
    return INSTANCE;
  }

  private void updateUserThemes() {
    WebStorageWindow.of(DomGlobal.window)
        .localStorage
        .setItem(
            "dui-user-themes",
            byCategory.values().stream()
                .map(IsDominoTheme::getName)
                .collect(Collectors.joining(",")));
  }

  public DominoThemeManager applyUserThemes() {
    String themes = WebStorageWindow.of(DomGlobal.window).localStorage.getItem("dui-user-themes");
    if (isNull(themes) || themes.isEmpty()) {
      apply(DominoThemeDefault.INSTANCE);
      apply(DominoThemeLight.INSTANCE);
      apply(DominoThemeAccent.TEAL);
    } else {
      Arrays.asList(themes.split(","))
          .forEach(
              themeName -> {
                Optional.ofNullable(registeredThemes.get(themeName))
                    .ifPresent(isDominoTheme -> apply(registeredThemes.get(themeName)));
              });
    }
    return INSTANCE;
  }
}
