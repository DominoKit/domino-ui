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
import org.dominokit.domino.ui.style.Style;

public class LegacyThemeCompatibilityTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testLegacyThemeReplacesBodyClassAndNotifiesHandlers() {
    Theme initialTheme = new Theme(Theme.RED);
    Theme replacementTheme = new Theme(Theme.BLUE);
    DomGlobal.document.body.className = "";
    Theme.currentTheme = initialTheme;
    Style.of(DomGlobal.document.body).addCss(initialTheme.getScheme().color().getCss());

    final Theme[] observedOldTheme = new Theme[1];
    final Theme[] observedNewTheme = new Theme[1];
    Theme.ThemeChangeHandler handler =
        (oldTheme, newTheme) -> {
          observedOldTheme[0] = oldTheme;
          observedNewTheme[0] = newTheme;
        };

    Theme.addThemeChangeHandler(handler);
    try {
      replacementTheme.apply();

      assertFalse(initialTheme.getScheme().color().getCss().isAppliedTo(DomGlobal.document.body));
      assertTrue(
          replacementTheme.getScheme().color().getCss().isAppliedTo(DomGlobal.document.body));
      assertSame(initialTheme, observedOldTheme[0]);
      assertSame(replacementTheme, observedNewTheme[0]);
    } finally {
      Theme.removeThemeChangeHandler(handler);
      DomGlobal.document.body.className = "";
      Theme.currentTheme = initialTheme;
    }
  }
}
