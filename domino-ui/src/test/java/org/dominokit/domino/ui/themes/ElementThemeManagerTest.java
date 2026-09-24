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
import elemental2.dom.HTMLElement;
import java.util.ArrayList;
import java.util.List;

public class ElementThemeManagerTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testElementThemesAreTrackedPerTarget() {
    HTMLElement first = (HTMLElement) DomGlobal.document.createElement("div");
    HTMLElement second = (HTMLElement) DomGlobal.document.createElement("div");

    ElementThemeManager.INSTANCE.apply(DominoThemeLight.INSTANCE, first);
    ElementThemeManager.INSTANCE.apply(DominoThemeDark.INSTANCE, second);
    ElementThemeManager.INSTANCE.remove("dui-theme-light", first);

    assertFalse(DominoThemeLight.INSTANCE.isApplied(first));
    assertTrue(DominoThemeDark.INSTANCE.isApplied(second));

    DominoThemeDark.INSTANCE.cleanup(second);
  }

  public void testReplacingAThemeKeepsOtherCategoriesOnTheSameTarget() {
    HTMLElement target = (HTMLElement) DomGlobal.document.createElement("div");

    ElementThemeManager.INSTANCE.apply(DominoThemeDefault.INSTANCE, target);
    ElementThemeManager.INSTANCE.apply(DominoThemeLight.INSTANCE, target);
    ElementThemeManager.INSTANCE.apply(DominoThemeAccent.TEAL, target);
    ElementThemeManager.INSTANCE.apply(DominoThemeAccent.BLUE, target);

    assertTrue(DominoThemeDefault.INSTANCE.isApplied(target));
    assertTrue(DominoThemeLight.INSTANCE.isApplied(target));
    assertFalse(DominoThemeAccent.TEAL.isApplied(target));
    assertTrue(DominoThemeAccent.BLUE.isApplied(target));

    ElementThemeManager.INSTANCE.remove("dui-default", target);
    ElementThemeManager.INSTANCE.remove("dui-theme-light", target);
    ElementThemeManager.INSTANCE.remove("dui-theme-accent-blue", target);
  }

  public void testOptionalThemesComposeOnAnElementAndClearOneSurfaceCategory() {
    HTMLElement target = (HTMLElement) DomGlobal.document.createElement("div");

    ElementThemeManager.INSTANCE.apply(DominoThemeIdentity.OCEAN, target);
    ElementThemeManager.INSTANCE.apply(DominoThemeCharacter.PAPER, target);
    ElementThemeManager.INSTANCE.apply(DominoThemeSurface.BORDERED, target);
    ElementThemeManager.INSTANCE.apply(DominoThemeSurface.ROUNDED, target);

    assertTrue(DominoThemeIdentity.OCEAN.isApplied(target));
    assertTrue(DominoThemeCharacter.PAPER.isApplied(target));
    assertTrue(DominoThemeSurface.BORDERED.isApplied(target));
    assertTrue(DominoThemeSurface.ROUNDED.isApplied(target));

    ElementThemeManager.INSTANCE.apply(DominoThemeSurface.CLEAR_BORDER, target);

    assertFalse(DominoThemeSurface.BORDERED.isApplied(target));
    assertTrue(DominoThemeSurface.ROUNDED.isApplied(target));
    assertTrue(DominoThemeIdentity.OCEAN.isApplied(target));
    assertTrue(DominoThemeCharacter.PAPER.isApplied(target));

    ElementThemeManager.INSTANCE.remove("dui-theme-ocean", target);
    ElementThemeManager.INSTANCE.remove("dui-theme-paper", target);
    ElementThemeManager.INSTANCE.remove("dui-theme-border-default", target);
    ElementThemeManager.INSTANCE.remove("dui-theme-rounded", target);
  }

  public void testChangeListenerReportsTargetAndIsolatedSnapshots() {
    ElementThemeManager manager = ElementThemeManager.INSTANCE;
    HTMLElement first = (HTMLElement) DomGlobal.document.createElement("div");
    HTMLElement second = (HTMLElement) DomGlobal.document.createElement("div");
    manager.apply(DominoThemeAccent.TEAL, first);
    manager.apply(DominoThemeAccent.CORAL, second);

    List<ThemeChange> changes = new ArrayList<>();
    ThemeChangeListener listener = changes::add;
    manager.addThemeChangeListener(listener);
    try {
      manager.apply(DominoThemeAccent.BLUE, first);

      assertEquals(1, changes.size());
      ThemeChange change = changes.get(0);
      assertEquals(ThemeChange.Scope.ELEMENT, change.getScope());
      assertSame(first, change.getTarget());
      assertSame(DominoThemeAccent.TEAL, change.getPreviousTheme());
      assertSame(DominoThemeAccent.BLUE, change.getCurrentTheme());
      assertEquals(1, change.getPreviousThemes().size());
      assertSame(
          DominoThemeAccent.TEAL, change.getPreviousThemes().get(DominoThemeCategories.ACCENT));
      assertSame(
          DominoThemeAccent.BLUE, change.getCurrentThemes().get(DominoThemeCategories.ACCENT));
      assertSame(
          DominoThemeAccent.CORAL, manager.getThemes(second).get(DominoThemeCategories.ACCENT));
    } finally {
      manager.removeThemeChangeListener(listener);
      manager.remove(DominoThemeAccent.BLUE.getName(), first);
      manager.remove(DominoThemeAccent.CORAL.getName(), second);
    }
  }

  public void testClearSurfaceThemeIsIncludedInChangeAndUnknownRemovalIsSilent() {
    ElementThemeManager manager = ElementThemeManager.INSTANCE;
    HTMLElement target = (HTMLElement) DomGlobal.document.createElement("div");
    manager.apply(DominoThemeSurface.BORDERED, target);

    List<ThemeChange> changes = new ArrayList<>();
    ThemeChangeListener listener = changes::add;
    manager.addThemeChangeListener(listener);
    try {
      manager.apply(DominoThemeSurface.CLEAR_BORDER, target);
      manager.remove("not-an-active-theme", target);
      manager.remove(DominoThemeSurface.CLEAR_BORDER.getName(), target);

      assertEquals(2, changes.size());
      assertSame(DominoThemeSurface.BORDERED, changes.get(0).getPreviousTheme());
      assertSame(DominoThemeSurface.CLEAR_BORDER, changes.get(0).getCurrentTheme());
      assertSame(
          DominoThemeSurface.CLEAR_BORDER,
          changes.get(0).getCurrentThemes().get(DominoThemeCategories.SURFACE_BORDER));
      assertFalse(DominoThemeSurface.BORDERED.isApplied(target));
      assertEquals(ThemeChange.Operation.REMOVE, changes.get(1).getOperation());
      assertNull(changes.get(1).getCurrentTheme());
      assertTrue(changes.get(1).getCurrentThemes().isEmpty());
    } finally {
      manager.removeThemeChangeListener(listener);
      manager.remove(DominoThemeSurface.CLEAR_BORDER.getName(), target);
    }
  }

  public void testThemeCleanupCallbackCannotReenterSameElement() {
    ElementThemeManager manager = ElementThemeManager.INSTANCE;
    HTMLElement target = (HTMLElement) DomGlobal.document.createElement("div");
    int[] cleanupCalls = {0};
    IsDominoTheme reentrant =
        new IsDominoTheme() {
          @Override
          public String getName() {
            return "reentrant-element-accent";
          }

          @Override
          public String getCategory() {
            return DominoThemeCategories.ACCENT;
          }

          @Override
          public void apply(Element element) {}

          @Override
          public void cleanup(Element element) {
            if (++cleanupCalls[0] == 1) {
              manager.apply(DominoThemeAccent.BLUE, element);
            }
          }

          @Override
          public boolean isApplied(Element element) {
            return false;
          }
        };
    manager.apply(reentrant, target);

    try {
      try {
        manager.apply(DominoThemeAccent.TEAL, target);
        fail("A theme callback must not mutate the same element recursively");
      } catch (IllegalStateException expected) {
        assertTrue(expected.getMessage().contains("theme"));
      }
    } finally {
      manager.remove(reentrant.getName(), target);
      manager.remove(DominoThemeAccent.BLUE.getName(), target);
      manager.remove(DominoThemeAccent.TEAL.getName(), target);
    }
  }
}
