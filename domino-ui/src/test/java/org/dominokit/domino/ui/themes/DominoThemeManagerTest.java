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
import elemental2.dom.Element;
import elemental2.webstorage.Storage;
import elemental2.webstorage.WebStorageWindow;
import java.util.ArrayList;
import java.util.List;

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
    DominoThemeManager.INSTANCE.remove("dui-theme-accent-coral");
    DominoThemeManager.INSTANCE.remove("dui-theme-accent-emerald");
    DominoThemeManager.INSTANCE.remove("dui-theme-accent-cobalt");
    DominoThemeManager.INSTANCE.remove("dui-theme-accent-plum");
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

  public void testAdditionalAccentThemeIsRegisteredAndCanBeRestored() {
    DomGlobal.document.body.className = "";
    Storage storage = WebStorageWindow.of(DomGlobal.window).localStorage;
    storage.setItem("dui-user-themes", "dui-theme-accent-coral");

    DominoThemeManager.INSTANCE.applyUserThemes();

    assertTrue(DomGlobal.document.body.classList.contains("dui-accent-coral"));
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

  public void testChangeListenerReceivesGlobalReplacementWithWholeStateSnapshots() {
    DominoThemeManager manager = DominoThemeManager.INSTANCE;
    manager.apply(DominoThemeDefault.INSTANCE);
    manager.apply(DominoThemeAccent.TEAL);

    List<ThemeChange> changes = new ArrayList<>();
    ThemeChangeListener listener = changes::add;
    manager.addThemeChangeListener(listener);
    try {
      manager.apply(DominoThemeAccent.BLUE);

      assertEquals(1, changes.size());
      ThemeChange change = changes.get(0);
      assertEquals(ThemeChange.Scope.GLOBAL, change.getScope());
      assertEquals(ThemeChange.Operation.APPLY, change.getOperation());
      assertSame(DomGlobal.document.body, change.getTarget());
      assertEquals(DominoThemeCategories.ACCENT, change.getCategory());
      assertSame(DominoThemeAccent.TEAL, change.getPreviousTheme());
      assertSame(DominoThemeAccent.BLUE, change.getCurrentTheme());
      assertSame(
          DominoThemeDefault.INSTANCE, change.getPreviousThemes().get(DominoThemeCategories.MAIN));
      assertSame(
          DominoThemeDefault.INSTANCE, change.getCurrentThemes().get(DominoThemeCategories.MAIN));
      assertSame(
          DominoThemeAccent.TEAL, change.getPreviousThemes().get(DominoThemeCategories.ACCENT));
      assertSame(
          DominoThemeAccent.BLUE, change.getCurrentThemes().get(DominoThemeCategories.ACCENT));
      assertSame(DominoThemeAccent.BLUE, manager.getThemes().get(DominoThemeCategories.ACCENT));

      try {
        change.getPreviousThemes().clear();
        fail("Theme snapshots must be read-only");
      } catch (UnsupportedOperationException expected) {
        assertSame(
            DominoThemeAccent.TEAL, change.getPreviousThemes().get(DominoThemeCategories.ACCENT));
      }
    } finally {
      manager.removeThemeChangeListener(listener);
    }
  }

  public void testReapplyAndSuccessfulRemovalNotifyButUnknownRemovalDoesNot() {
    DominoThemeManager manager = DominoThemeManager.INSTANCE;
    manager.apply(DominoThemeAccent.BLUE);

    List<ThemeChange> changes = new ArrayList<>();
    ThemeChangeListener listener = changes::add;
    manager.addThemeChangeListener(listener);
    try {
      manager.apply(DominoThemeAccent.BLUE);
      manager.remove("not-an-active-theme");
      manager.remove(DominoThemeAccent.BLUE.getName());

      assertEquals(2, changes.size());
      assertEquals(ThemeChange.Operation.APPLY, changes.get(0).getOperation());
      assertSame(DominoThemeAccent.BLUE, changes.get(0).getPreviousTheme());
      assertSame(DominoThemeAccent.BLUE, changes.get(0).getCurrentTheme());
      assertEquals(changes.get(0).getPreviousThemes(), changes.get(0).getCurrentThemes());
      assertEquals(ThemeChange.Operation.REMOVE, changes.get(1).getOperation());
      assertSame(DominoThemeAccent.BLUE, changes.get(1).getPreviousTheme());
      assertNull(changes.get(1).getCurrentTheme());
      assertFalse(changes.get(1).getCurrentThemes().containsKey(DominoThemeCategories.ACCENT));
    } finally {
      manager.removeThemeChangeListener(listener);
    }
  }

  public void testRestoringPersistedThemesNotifiesForEachAppliedTheme() {
    DominoThemeManager manager = DominoThemeManager.INSTANCE;
    WebStorageWindow.of(DomGlobal.window)
        .localStorage
        .setItem("dui-user-themes", "dui-default,dui-theme-light,dui-theme-accent-teal");

    List<ThemeChange> changes = new ArrayList<>();
    ThemeChangeListener listener = changes::add;
    manager.addThemeChangeListener(listener);
    try {
      manager.applyUserThemes();

      assertEquals(3, changes.size());
      assertEquals(DominoThemeCategories.MAIN, changes.get(0).getCategory());
      assertEquals(DominoThemeCategories.COLOR_MODE, changes.get(1).getCategory());
      assertEquals(DominoThemeCategories.ACCENT, changes.get(2).getCategory());
      assertSame(
          DominoThemeAccent.TEAL,
          changes.get(2).getCurrentThemes().get(DominoThemeCategories.ACCENT));
    } finally {
      manager.removeThemeChangeListener(listener);
    }
  }

  public void testNestedListenerChangesReachEveryListenerInEventOrder() {
    DominoThemeManager manager = DominoThemeManager.INSTANCE;
    manager.apply(DominoThemeAccent.TEAL);

    List<ThemeChange.Operation> observed = new ArrayList<>();
    ThemeChangeListener remover =
        change -> {
          if (change.getOperation() == ThemeChange.Operation.APPLY
              && change.getCurrentTheme() == DominoThemeAccent.BLUE) {
            manager.remove(DominoThemeAccent.BLUE.getName());
          }
        };
    ThemeChangeListener observer = change -> observed.add(change.getOperation());
    manager.addThemeChangeListener(remover).addThemeChangeListener(observer);
    try {
      manager.apply(DominoThemeAccent.BLUE);

      assertEquals(2, observed.size());
      assertEquals(ThemeChange.Operation.APPLY, observed.get(0));
      assertEquals(ThemeChange.Operation.REMOVE, observed.get(1));
    } finally {
      manager.removeThemeChangeListener(remover).removeThemeChangeListener(observer);
    }
  }

  public void testThemeApplyCallbackCannotReenterGlobalManager() {
    DominoThemeManager manager = DominoThemeManager.INSTANCE;
    IsDominoTheme reentrant =
        new IsDominoTheme() {
          @Override
          public String getName() {
            return "reentrant-accent";
          }

          @Override
          public String getCategory() {
            return DominoThemeCategories.ACCENT;
          }

          @Override
          public void apply(Element target) {
            manager.apply(DominoThemeAccent.BLUE);
          }

          @Override
          public void cleanup(Element target) {}

          @Override
          public boolean isApplied(Element target) {
            return false;
          }
        };

    try {
      try {
        manager.apply(reentrant);
        fail("A theme callback must not mutate its manager recursively");
      } catch (IllegalStateException expected) {
        assertTrue(expected.getMessage().contains("theme"));
      }
    } finally {
      manager.remove(reentrant.getName());
    }
  }
}
