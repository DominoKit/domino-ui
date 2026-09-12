/*
 * Copyright © 2026 Dominokit
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
import static org.dominokit.domino.ui.utils.Domino.dui_clr_;
import static org.dominokit.domino.ui.utils.Domino.dui_clr_schm_;

import com.google.gwt.junit.client.GWTTestCase;
import java.util.HashMap;
import java.util.Map;
import org.dominokit.domino.ui.style.CssClass;

public class DominoDynamicColorTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testFactoryExposesColorSchemeAndBaseColorConvenienceOperations() {
    DynamicColorScheme scheme = dui_clr_schm_("#EFEFAA");

    assertEquals(
        scheme.color().getContextColor().getCssClass(), scheme.getContextColor().getCssClass());
    assertEquals(
        scheme.color().getBackground().getCssClass(), scheme.getBackground().getCssClass());
    assertTrue(scheme.lighten_2().getCss().getCssClass().contains("-l-2"));
    assertTrue(scheme.darker_4().getCss().getCssClass().contains("-d-4"));
  }

  public void testFactoryReturnsReusableSchemeAndReferenceClasses() {
    assertSame(dui_clr_schm_("#EFEFAA"), dui_clr_schm_("#EFEFAA"));

    DynamicColorScheme brand = dui_clr_schm_("var(--dui-clr-app-brand)");
    assertEquals("dui-context-app-brand", brand.getContextColor().getCssClass());
    assertEquals("dui-bg-app-brand-l-2", brand.lighten_2().getBackground().getCssClass());
  }

  public void testLiteralFactoryInjectsThePaletteAndReferenceUsesContextTokens() {
    DynamicColorScheme literal = dui_clr_schm_("#EFEFAA");
    DynamicColorScheme reference = dui_clr_schm_("var(--dui-clr-app-brand)");

    assertEquals(1, document.querySelectorAll("style#dui-dynamic-colors").length);
    assertTrue(literal.getContextColor().getCssClass().startsWith("dui-context-dyn-"));
    assertEquals("dui-context-app-brand", reference.getContextColor().getCssClass());
  }

  public void testColorFactoryReturnsTheSchemeBaseCssClass() {
    CssClass color = dui_clr_("#EFEFAA");

    assertEquals(dui_clr_schm_("#EFEFAA").color().getCss().getCssClass(), color.getCssClass());
  }

  public void testBaseColorClassUsesThePredefinedColorContract() {
    RecordingStyleSheet sheet = new RecordingStyleSheet();
    DynamicColorRegistry registry = new DynamicColorRegistry(sheet);

    registry.colorScheme("#EFEFAA");

    String base = ".dui.dui-dyn-nkr5fnf";
    assertEquals("#EFEFAA", sheet.property(base, "--dui-context-color"));
    assertEquals("#EFEFAA", sheet.property(base, "--dui-bg"));
    assertEquals("var(--dui-color)", sheet.property(base, "--dui-text-color"));
    assertEquals("#EFEFAA", sheet.property(base + ":not(.dui-ignore-bg)", "background-color"));
    assertEquals(
        "var(--dui-dyn-nkr5fnf-fg-clr)", sheet.property(base + ":not(.dui-ignore-fg)", "color"));
  }

  private static final class RecordingStyleSheet implements DynamicColorStyleSheet {
    private final Map<String, Map<String, String>> properties = new HashMap<>();

    @Override
    public boolean hasRule(String selector) {
      return properties.containsKey(selector);
    }

    @Override
    public String getPropertyValue(String selector, String property) {
      return property(selector, property);
    }

    @Override
    public void setProperty(String selector, String property, String value) {
      properties.computeIfAbsent(selector, ignored -> new HashMap<>()).put(property, value);
    }

    private String property(String selector, String property) {
      Map<String, String> selectorProperties = properties.get(selector);
      return selectorProperties == null ? null : selectorProperties.get(property);
    }
  }
}
