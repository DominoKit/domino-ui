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

import static org.junit.Assert.assertEquals;

import com.google.gwt.junit.client.GWTTestCase;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;

public class ThemeCatalogTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testOrangeAccentUsesTheOrangeCssClass() {
    HTMLElement target = (HTMLElement) DomGlobal.document.createElement("div");

    DominoThemeAccent.ORANGE.apply(target);

    assertEquals("dui-theme-accent-orange", DominoThemeAccent.ORANGE.getName());
    assertTrue(target.classList.contains("dui-accent-orange"));

    DominoThemeAccent.ORANGE.cleanup(target);
  }

  public void testAdditionalAccentThemesUseTheirNamedCssClasses() {
    assertEquals("dui-theme-accent-coral", DominoThemeAccent.CORAL.getName());
    assertEquals("dui-theme-accent-emerald", DominoThemeAccent.EMERALD.getName());
    assertEquals("dui-theme-accent-cobalt", DominoThemeAccent.COBALT.getName());
    assertEquals("dui-theme-accent-plum", DominoThemeAccent.PLUM.getName());
  }
}
