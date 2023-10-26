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
import org.dominokit.domino.ui.utils.ElementsFactory;

/**
 * Manages the themes for Domino UI components.
 *
 * <p>Provides capabilities to apply, remove, register and manage themes persistently using
 * WebStorage. It also allows applying user-preferred themes.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>{@code
 * DominoThemeManager manager = DominoThemeManager.INSTANCE;
 * manager.apply(MyCustomTheme.INSTANCE);
 * }</pre>
 *
 * @see IsDominoTheme
 * @see ElementsFactory
 */
public class DominoThemeManager implements ElementsFactory {

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

  /**
   * Applies the specified theme and stores the user preference in local storage.
   *
   * @param theme the theme to be applied
   * @return the {@link DominoThemeManager} instance
   */
  public DominoThemeManager apply(IsDominoTheme theme) {
    if (byCategory.containsKey(theme.getCategory())) {
      byCategory.get(theme.getCategory()).cleanup();
    }

    byCategory.put(theme.getCategory(), theme);
    theme.apply();
    updateUserThemes();
    return INSTANCE;
  }

  /**
   * Removes the theme with the specified name.
   *
   * @param themeName the name of the theme to be removed
   * @return the {@link DominoThemeManager} instance
   */
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

  /**
   * Registers a new theme, making it available for future use.
   *
   * @param theme the theme to be registered
   * @return the {@link DominoThemeManager} instance
   */
  public DominoThemeManager registerTheme(IsDominoTheme theme) {
    registeredThemes.put(theme.getName(), theme);
    return INSTANCE;
  }

  /** Updates user themes in the local storage. */
  private void updateUserThemes() {
    WebStorageWindow.of(DomGlobal.window)
        .localStorage
        .setItem(
            "dui-user-themes",
            byCategory.values().stream()
                .map(IsDominoTheme::getName)
                .collect(Collectors.joining(",")));
  }

  /**
   * Applies the user preferred themes stored in local storage. If none found, it applies the
   * default themes.
   *
   * @return the {@link DominoThemeManager} instance
   */
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
