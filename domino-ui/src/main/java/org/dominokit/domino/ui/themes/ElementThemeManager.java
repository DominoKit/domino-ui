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
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.utils.ElementsFactory;

/**
 * Manages themes on a per-element basis for Domino UI components.
 *
 * <p>This class offers methods to apply, remove, and register themes targeting specific UI
 * elements.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>{@code
 * ElementThemeManager manager = ElementThemeManager.INSTANCE;
 * manager.apply(MyCustomTheme.INSTANCE, myElement);
 * }</pre>
 *
 * @see IsDominoTheme
 * @see ElementsFactory
 */
public class ElementThemeManager implements ElementsFactory {

  public static final ElementThemeManager INSTANCE = new ElementThemeManager();

  private final Map<String, IsDominoTheme> byCategory = new HashMap<>();
  private final Map<String, IsDominoTheme> registeredThemes = new HashMap<>();

  private ElementThemeManager() {
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
   * Applies the specified theme to a target element represented as {@link IsElement}.
   *
   * @param theme the theme to be applied
   * @param target the target element to apply the theme on
   * @return the {@link ElementThemeManager} instance
   */
  public ElementThemeManager apply(IsDominoTheme theme, IsElement<? extends Element> target) {
    return apply(theme, target.element());
  }

  /**
   * Applies the specified theme to a target {@link Element}.
   *
   * @param theme the theme to be applied
   * @param target the target element to apply the theme on
   * @return the {@link ElementThemeManager} instance
   */
  public ElementThemeManager apply(IsDominoTheme theme, Element target) {
    if (byCategory.containsKey(theme.getCategory())) {
      byCategory.get(theme.getCategory()).cleanup(target);
    }

    byCategory.put(theme.getCategory(), theme);
    theme.apply(target);
    return INSTANCE;
  }

  /**
   * Removes the theme with the specified name from a target element represented as {@link
   * IsElement}.
   *
   * @param themeName the name of the theme to be removed
   * @param target the target element to remove the theme from
   * @return the {@link ElementThemeManager} instance
   */
  public ElementThemeManager remove(String themeName, IsElement<? extends Element> target) {
    return remove(themeName, target.element());
  }

  /**
   * Removes the theme with the specified name from a target {@link Element}.
   *
   * @param themeName the name of the theme to be removed
   * @param target the target element to remove the theme from
   * @return the {@link ElementThemeManager} instance
   */
  public ElementThemeManager remove(String themeName, Element target) {
    Optional<IsDominoTheme> theme =
        byCategory.values().stream().filter(t -> t.getName().equals(themeName)).findFirst();
    theme.ifPresent(
        t -> {
          t.cleanup(target);
          byCategory.remove(t.getCategory());
        });
    return INSTANCE;
  }

  /**
   * Registers a new theme, making it available for future use.
   *
   * @param theme the theme to be registered
   * @return the {@link ElementThemeManager} instance
   */
  public ElementThemeManager registerTheme(IsDominoTheme theme) {
    registeredThemes.put(theme.getName(), theme);
    return INSTANCE;
  }
}
