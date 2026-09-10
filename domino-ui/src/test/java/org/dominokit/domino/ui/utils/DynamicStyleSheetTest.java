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
package org.dominokit.domino.ui.utils;

import static org.dominokit.domino.ui.utils.Domino.div;

import com.google.gwt.junit.client.GWTTestCase;
import elemental2.dom.CSSStyleSheet;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;

public class DynamicStyleSheetTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testReturnsTheBrowserStyleSheetAfterAttachment() {
    DivElement target = div();
    DynamicStyleSheet<HTMLDivElement, DivElement> styles = new DynamicStyleSheet<>("test-", target);

    assertSame(styles.getStyleElement().sheet, styles.getStyleSheet());
    DomGlobal.document.body.appendChild(target.element());
    try {
      CSSStyleSheet sheet = styles.getStyleSheet();
      assertNotNull(sheet);
      assertSame(styles.getStyleElement().sheet, sheet);
      sheet.insertRule(".domino-stylesheet-test { color: red; }", 0);
      assertEquals(1, styles.getStyleSheet().cssRules.length);
      sheet.deleteRule(0);
      assertEquals(0, styles.getStyleSheet().cssRules.length);
    } finally {
      target.element().remove();
    }
  }

  public void testReadsTheCurrentStyleSheetAfterReattachment() {
    DivElement target = div();
    DynamicStyleSheet<HTMLDivElement, DivElement> styles = new DynamicStyleSheet<>("test-", target);

    DomGlobal.document.body.appendChild(target.element());
    try {
      assertNotNull(styles.getStyleSheet());
      target.element().remove();
      assertSame(styles.getStyleElement().sheet, styles.getStyleSheet());
      DomGlobal.document.body.appendChild(target.element());
      assertNotNull(styles.getStyleSheet());
      assertSame(styles.getStyleElement().sheet, styles.getStyleSheet());
    } finally {
      target.element().remove();
    }
  }
}
