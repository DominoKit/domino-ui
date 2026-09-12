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
import elemental2.dom.HTMLStyleElement;
import java.util.Arrays;
import jsinterop.base.Js;

public class DynamicLayoutCssTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testPaddingFactoriesUseDominoPaddingConventions() {
    assertEquals("dui-p-10px", DynamicPadding.of("10px").getCssClass());
    assertEquals("dui-p-t-10px", DynamicPadding.top("10px").getCssClass());
    assertEquals("dui-p-r-10px", DynamicPadding.right("10px").getCssClass());
    assertEquals("dui-p-b-10px", DynamicPadding.bottom("10px").getCssClass());
    assertEquals("dui-p-l-10px", DynamicPadding.left("10px").getCssClass());
    assertEquals("dui-p-x-2rem", DynamicPadding.x(Unit.rem.of(2)).getCssClass());
    assertEquals("dui-p-y-10px", DynamicPadding.y("10px").getCssClass());
  }

  public void testDefinitionsMatchTheStaticUtilityProperties() {
    assertEquals("dui-p-x", DynamicPadding.X.getClassPrefix());
    assertEquals(
        Arrays.asList("padding-left", "padding-right"), DynamicPadding.X.getCssProperties());
    assertEquals("dui-m-y", DynamicMargin.Y.getClassPrefix());
    assertEquals(Arrays.asList("margin-top", "margin-bottom"), DynamicMargin.Y.getCssProperties());
    assertEquals(Arrays.asList("column-gap"), DynamicGap.X.getCssProperties());
    assertEquals(Arrays.asList("row-gap"), DynamicGap.Y.getCssProperties());
    assertEquals(Arrays.asList("text-indent"), DynamicIndent.INDENT.getCssProperties());
  }

  public void testMarginFactoriesUseDominoMarginConventions() {
    assertEquals("dui-m-10px", DynamicMargin.of("10px").getCssClass());
    assertEquals("dui-m-t-10px", DynamicMargin.top("10px").getCssClass());
    assertEquals("dui-m-r-10px", DynamicMargin.right("10px").getCssClass());
    assertEquals("dui-m-b-10px", DynamicMargin.bottom("10px").getCssClass());
    assertEquals("dui-m-l-10px", DynamicMargin.left("10px").getCssClass());
    assertEquals("dui-m-x-2rem", DynamicMargin.x(Unit.rem.of(2)).getCssClass());
    assertEquals("dui-m-y-10px", DynamicMargin.y("10px").getCssClass());
  }

  public void testSizingFactoriesUseDominoSizingConventions() {
    assertEquals("dui-w-10px", DynamicSizing.width("10px").getCssClass());
    assertEquals("dui-h-2rem", DynamicSizing.height(Unit.rem.of(2)).getCssClass());
    assertEquals("dui-min-w-10px", DynamicSizing.minWidth("10px").getCssClass());
    assertEquals("dui-min-h-10px", DynamicSizing.minHeight("10px").getCssClass());
    assertEquals("dui-max-w-10px", DynamicSizing.maxWidth("10px").getCssClass());
    assertEquals("dui-max-h-10px", DynamicSizing.maxHeight("10px").getCssClass());
  }

  public void testGapAndIndentFactoriesUseDominoConventions() {
    assertEquals("dui-gap-10px", DynamicGap.of("10px").getCssClass());
    assertEquals("dui-gap-x-10px", DynamicGap.x("10px").getCssClass());
    assertEquals("dui-gap-y-2rem", DynamicGap.y(Unit.rem.of(2)).getCssClass());
    assertEquals("dui-indent-10px", DynamicIndent.of("10px").getCssClass());
  }

  @Override
  protected void gwtTearDown() {
    HTMLStyleElement styleElement =
        Js.uncheckedCast(document.getElementById(DynamicCssRegistry.STYLE_ELEMENT_ID));
    if (styleElement != null) {
      styleElement.parentNode.removeChild(styleElement);
    }
    DynamicCss.reset();
  }
}
