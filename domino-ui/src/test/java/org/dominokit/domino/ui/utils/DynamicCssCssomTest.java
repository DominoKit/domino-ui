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
import org.dominokit.domino.ui.style.FlexCss;
import org.dominokit.domino.ui.style.TypographyCss;
import org.dominokit.domino.ui.style.VisualCss;

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

  public void testProductionScriptKeepsMigratedStaticUtilitiesLazy() {
    removeDynamicStyleSheet();
    DynamicCss.reset();

    assertEquals("dui-p-4", DynamicCss.lazyCssClass("dui-p-4").getCssClass());

    assertEquals(1, countRules(".dui.dui-p-4"));
    assertEquals(0, countRules(".dui.dui-p-x-4"));
    assertEquals(0, countRules(".dui.dui-z-10"));
  }

  public void testPublicLegacyConstantsInjectSelectedUtilityFamiliesLazily() {
    removeDynamicStyleSheet();
    DynamicCss.reset();

    assertEquals("dui-border-x-4", VisualCss.dui_border_x_4.getCssClass());
    assertEquals("dui-grow-2", FlexCss.dui_grow_2.getCssClass());
    assertEquals("dui-font-size-4", TypographyCss.dui_font_size_4.getCssClass());
    assertEquals("dui-leading-6", TypographyCss.dui_leading_6.getCssClass());

    assertEquals(1, countRules(".dui.dui-border-x-4"));
    assertEquals(1, countRules(".dui.dui-grow-2"));
    assertEquals(1, countRules(".dui.dui-font-size-4"));
    assertEquals(1, countRules(".dui.dui-leading-6"));
  }

  public void testDynamicFlexReusesTheStaticGrowSelectorAfterItIsResolved() {
    removeDynamicStyleSheet();
    DynamicCss.reset();

    assertEquals("dui-grow-2", FlexCss.dui_grow_2.getCssClass());
    assertEquals(1, countRules(".dui.dui-grow-2"));
    assertEquals("dui-grow-2", DynamicFlex.grow("2").getCssClass());
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
