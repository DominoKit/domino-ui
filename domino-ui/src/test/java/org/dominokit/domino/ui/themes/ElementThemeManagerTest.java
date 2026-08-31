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
import elemental2.dom.HTMLElement;

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
}
