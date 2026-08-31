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

public class DominoCssThemeTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testAppliesAndCleansUpTheConfiguredClasses() {
    HTMLElement target = (HTMLElement) DomGlobal.document.createElement("div");
    DominoCssTheme theme =
        DominoCssTheme.of("acme-brand", DominoThemeCategories.MAIN, "acme-brand");

    assertEquals("acme-brand", theme.getName());
    assertEquals(DominoThemeCategories.MAIN, theme.getCategory());

    theme.apply(target);
    assertTrue(target.classList.contains("dui"));
    assertTrue(target.classList.contains("acme-brand"));
    assertTrue(theme.isApplied(target));

    theme.cleanup(target);
    assertTrue(target.classList.contains("dui"));
    assertFalse(target.classList.contains("acme-brand"));
    assertFalse(theme.isApplied(target));
  }

  public void testRejectsInvalidThemeValues() {
    assertInvalid("", DominoThemeCategories.MAIN, "acme-brand");
    assertInvalid("acme-brand", "", "acme-brand");
    assertInvalid("acme-brand", DominoThemeCategories.MAIN, "acme brand");
  }

  public void testClearThemeKeepsTheDominoMarkerWithoutAddingAnEmptyClass() {
    HTMLElement target = (HTMLElement) DomGlobal.document.createElement("div");
    DominoCssTheme clear =
        DominoCssTheme.clear("clear-surface", DominoThemeCategories.SURFACE_BORDER);

    clear.apply(target);

    assertTrue(target.classList.contains("dui"));
    assertFalse(target.classList.contains(""));
    assertFalse(clear.isApplied(target));

    clear.cleanup(target);
    assertTrue(target.classList.contains("dui"));
  }

  private void assertInvalid(String name, String category, String cssClass) {
    try {
      DominoCssTheme.of(name, category, cssClass);
      fail("Expected invalid theme values to be rejected");
    } catch (IllegalArgumentException expected) {
      // Expected.
    }
  }
}
