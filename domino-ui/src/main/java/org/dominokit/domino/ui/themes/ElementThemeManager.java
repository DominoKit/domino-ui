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
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.utils.ElementsFactory;

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

  public ElementThemeManager apply(IsDominoTheme theme, IsElement<? extends Element> target) {
    return apply(theme, target.element());
  }

  public ElementThemeManager apply(IsDominoTheme theme, Element target) {
    if (byCategory.containsKey(theme.getCategory())) {
      byCategory.get(theme.getCategory()).cleanup(target);
    }

    byCategory.put(theme.getCategory(), theme);
    theme.apply(target);
    return INSTANCE;
  }

  public ElementThemeManager remove(String themeName, IsElement<? extends Element> target) {
    return remove(themeName, target.element());
  }

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

  public ElementThemeManager registerTheme(IsDominoTheme theme) {
    registeredThemes.put(theme.getName(), theme);
    return INSTANCE;
  }
}
