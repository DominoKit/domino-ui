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

import com.google.gwt.junit.client.GWTTestCase;
import elemental2.dom.DomGlobal;
import elemental2.webstorage.Storage;
import elemental2.webstorage.WebStorageWindow;

public class DominoThemeManagerTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  @Override
  protected void gwtTearDown() throws Exception {
    DominoThemeManager.INSTANCE.remove("dui-default");
    DominoThemeManager.INSTANCE.remove("dui-theme-light");
    DominoThemeManager.INSTANCE.remove("dui-theme-dark");
    DominoThemeManager.INSTANCE.remove("dui-theme-accent-teal");
    DominoThemeManager.INSTANCE.remove("dui-theme-accent-blue");
    DominoThemeManager.INSTANCE.remove("dui-theme-ocean");
    DominoThemeManager.INSTANCE.remove("dui-theme-forest");
    DominoThemeManager.INSTANCE.remove("dui-theme-glass");
    DominoThemeManager.INSTANCE.remove("dui-theme-terminal");
    DominoThemeManager.INSTANCE.remove("dui-theme-aurora");
    DominoThemeManager.INSTANCE.remove("dui-theme-bordered");
    DominoThemeManager.INSTANCE.remove("dui-theme-elevated");
    DominoThemeManager.INSTANCE.remove("dui-theme-rounded");
    DominoThemeManager.INSTANCE.remove("dui-theme-border-default");
    DominoThemeManager.INSTANCE.remove("dui-theme-elevation-default");
    DominoThemeManager.INSTANCE.remove("dui-theme-radius-default");
    DominoThemeManager.INSTANCE.remove("acme-brand");
    Storage storage = WebStorageWindow.of(DomGlobal.window).localStorage;
    storage.removeItem("dui-user-themes");
    super.gwtTearDown();
  }

  public void testApplyingThemesPreservesOneThemePerCategory() {
    DomGlobal.document.body.className = "";
    DominoThemeManager.INSTANCE.apply(DominoThemeDefault.INSTANCE);
    DominoThemeManager.INSTANCE.apply(DominoThemeLight.INSTANCE);
    DominoThemeManager.INSTANCE.apply(DominoThemeAccent.TEAL);
    assertTrue(DomGlobal.document.body.classList.contains("dui-accent-teal"));
    DominoThemeManager.INSTANCE.apply(DominoThemeAccent.BLUE);

    assertTrue(DominoThemeDefault.INSTANCE.isApplied());
    assertTrue(DominoThemeLight.INSTANCE.isApplied());
    assertTrue(DomGlobal.document.body.classList.contains("dui-accent-blue"));
    assertFalse(DomGlobal.document.body.classList.contains("dui-accent-teal"));
    assertTrue(DominoThemeAccent.BLUE.isApplied());
  }

  public void testUnknownPersistedThemesAreIgnored() {
    Storage storage = WebStorageWindow.of(DomGlobal.window).localStorage;
    storage.setItem("dui-user-themes", "dui-default,unknown-theme,dui-theme-dark");

    DominoThemeManager.INSTANCE.applyUserThemes();

    assertTrue(DominoThemeDefault.INSTANCE.isApplied());
    assertTrue(DominoThemeDark.INSTANCE.isApplied());
  }

  public void testRegisteredCssThemeCanBeAppliedGlobally() {
    DominoCssTheme customTheme =
        DominoCssTheme.of("acme-brand", DominoThemeCategories.MAIN, "acme-brand");

    DominoThemeManager.INSTANCE.registerTheme(customTheme).apply(customTheme);

    assertTrue(DomGlobal.document.body.classList.contains("acme-brand"));
    assertTrue(customTheme.isApplied());
  }

  public void testOptionalThemeCategoriesComposeAndClearIndependently() {
    DomGlobal.document.body.className = "";

    DominoThemeManager.INSTANCE.apply(DominoThemeIdentity.OCEAN);
    DominoThemeManager.INSTANCE.apply(DominoThemeCharacter.GLASS);
    DominoThemeManager.INSTANCE.apply(DominoThemeSurface.BORDERED);
    DominoThemeManager.INSTANCE.apply(DominoThemeSurface.ELEVATED);
    DominoThemeManager.INSTANCE.apply(DominoThemeSurface.ROUNDED);

    assertTrue(DominoThemeIdentity.OCEAN.isApplied());
    assertTrue(DominoThemeCharacter.GLASS.isApplied());
    assertTrue(DominoThemeSurface.BORDERED.isApplied());
    assertTrue(DominoThemeSurface.ELEVATED.isApplied());
    assertTrue(DominoThemeSurface.ROUNDED.isApplied());

    DominoThemeManager.INSTANCE.apply(DominoThemeIdentity.FOREST);
    assertFalse(DominoThemeIdentity.OCEAN.isApplied());
    assertTrue(DominoThemeIdentity.FOREST.isApplied());
    assertTrue(DominoThemeCharacter.GLASS.isApplied());
    assertTrue(DominoThemeSurface.BORDERED.isApplied());

    DominoThemeManager.INSTANCE.apply(DominoThemeSurface.CLEAR_BORDER);
    assertFalse(DominoThemeSurface.BORDERED.isApplied());
    assertTrue(DominoThemeSurface.ELEVATED.isApplied());
    assertTrue(DominoThemeSurface.ROUNDED.isApplied());
    assertTrue(DomGlobal.document.body.classList.contains("dui-theme-elevated"));
    assertTrue(DomGlobal.document.body.classList.contains("dui-theme-rounded"));
  }

  public void testAuroraIsRegisteredAsACharacterTheme() {
    DomGlobal.document.body.className = "";
    Storage storage = WebStorageWindow.of(DomGlobal.window).localStorage;
    storage.setItem("dui-user-themes", "dui-theme-aurora");

    DominoThemeManager.INSTANCE.applyUserThemes();

    assertTrue(DomGlobal.document.body.classList.contains("dui-theme-aurora"));
  }
}
