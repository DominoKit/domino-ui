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

public class DynamicAdvancedCssTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testPositionFactoriesUseDominoPositionConventions() {
    assertEquals("dui-inset-10px", DynamicPosition.of("10px").getCssClass());
    assertEquals("dui-inset-x-2rem", DynamicPosition.x(Unit.rem.of(2)).getCssClass());
    assertEquals("dui-inset-y-10px", DynamicPosition.y("10px").getCssClass());
    assertEquals("dui-top-10px", DynamicPosition.top("10px").getCssClass());
    assertEquals("dui-right-10px", DynamicPosition.right("10px").getCssClass());
    assertEquals("dui-bottom-10px", DynamicPosition.bottom("10px").getCssClass());
    assertEquals("dui-left-10px", DynamicPosition.left("10px").getCssClass());
    assertEquals("dui-z-100", DynamicPosition.zIndex("100").getCssClass());
    assertEquals(
        Arrays.asList("top", "right", "bottom", "left"), DynamicPosition.INSET.getCssProperties());
  }

  public void testFlexAndGridFactoriesUseDominoConventions() {
    assertEquals("dui-basis-10px", DynamicFlex.basis("10px").getCssClass());
    assertEquals("dui-grow-2", DynamicFlex.grow("2").getCssClass());
    assertEquals("dui-shrink-3", DynamicFlex.shrink("3").getCssClass());
    assertEquals("dui-order-4", DynamicFlex.order("4").getCssClass());
    assertTrue(
        DynamicGrid.columns("repeat(5, minmax(0, 1fr))")
            .getCssClass()
            .startsWith("dui-grid-cols-dyn-"));
    assertTrue(DynamicGrid.rows("minmax(0, 1fr)").getCssClass().startsWith("dui-grid-rows-dyn-"));
    assertEquals("dui-auto-cols-7px", DynamicGrid.autoColumns("7px").getCssClass());
    assertEquals("dui-auto-rows-8px", DynamicGrid.autoRows("8px").getCssClass());
    assertEquals(Arrays.asList("flex-basis"), DynamicFlex.BASIS.getCssProperties());
    assertEquals(Arrays.asList("grid-template-columns"), DynamicGrid.COLUMNS.getCssProperties());
  }

  public void testGeometryAndTypographyFactoriesUseDominoConventions() {
    assertEquals("dui-border-1px", DynamicBorder.of("1px").getCssClass());
    assertEquals("dui-border-x-2px", DynamicBorder.x("2px").getCssClass());
    assertEquals("dui-border-t-3px", DynamicBorder.top("3px").getCssClass());
    assertEquals("dui-rounded-4px", DynamicRadius.of("4px").getCssClass());
    assertEquals("dui-rounded-t-5px", DynamicRadius.top("5px").getCssClass());
    assertEquals("dui-rounded-tl-6px", DynamicRadius.topLeft("6px").getCssClass());
    assertEquals("dui-outline-7px", DynamicOutline.width("7px").getCssClass());
    assertEquals("dui-outline-offset-8px", DynamicOutline.offset("8px").getCssClass());
    assertEquals("dui-font-size-9px", DynamicTypography.fontSize("9px").getCssClass());
    assertEquals("dui-leading-10px", DynamicTypography.lineHeight("10px").getCssClass());
    assertEquals("dui-tracking-11px", DynamicTypography.letterSpacing("11px").getCssClass());
    assertEquals("dui-font-weight-500", DynamicTypography.fontWeight("500").getCssClass());
    assertEquals(Arrays.asList("border-top-width"), DynamicBorder.TOP.getCssProperties());
    assertEquals(
        Arrays.asList("border-top-left-radius"), DynamicRadius.TOP_LEFT.getCssProperties());
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
