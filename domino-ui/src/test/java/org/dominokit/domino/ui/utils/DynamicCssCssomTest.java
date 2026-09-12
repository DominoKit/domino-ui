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

import static elemental2.dom.DomGlobal.document;

import com.google.gwt.junit.client.GWTTestCase;
import elemental2.dom.CSSRule;
import elemental2.dom.CSSStyleRule;
import elemental2.dom.CSSStyleSheet;
import elemental2.dom.HTMLStyleElement;
import jsinterop.base.Js;
import org.dominokit.domino.ui.style.CssClass;

public class DynamicCssCssomTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testFacadeCreatesOneScopedDocumentStyleSheet() {
    removeDynamicStyleSheet();
    DynamicCss.reset();
    DynamicCssDefinition definition =
        DynamicCssDefinition.of("dui-test-facade", "dui-test-facade-value", "padding");

    CssClass cssClass = DynamicCss.cssClass(definition, "10px");

    assertEquals("dui-test-facade-10px", cssClass.getCssClass());
    assertEquals(1, document.querySelectorAll("style#dui-dynamic-css").length);
    assertEquals(1, countRules("body.dui"));
    assertEquals(1, countRules(".dui.dui-test-facade-10px"));
  }

  @Override
  protected void gwtTearDown() {
    removeDynamicStyleSheet();
    DynamicCss.reset();
  }

  private void removeDynamicStyleSheet() {
    HTMLStyleElement styleElement =
        Js.uncheckedCast(document.getElementById(DynamicCssRegistry.STYLE_ELEMENT_ID));
    if (styleElement != null) {
      styleElement.parentNode.removeChild(styleElement);
    }
  }

  private int countRules(String selector) {
    CSSStyleSheet styleSheet =
        Js.uncheckedCast(
            Js.<HTMLStyleElement>uncheckedCast(
                    document.getElementById(DynamicCssRegistry.STYLE_ELEMENT_ID))
                .sheet);
    int matches = 0;
    for (int index = 0; index < styleSheet.cssRules.length; index++) {
      CSSRule rule = styleSheet.cssRules.item(index);
      CSSStyleRule styleRule = Js.uncheckedCast(rule);
      if (selector.equals(styleRule.selectorText)) {
        matches++;
      }
    }
    return matches;
  }
}
