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

import com.google.gwt.junit.client.GWTTestCase;
import java.util.LinkedHashMap;
import java.util.Map;
import org.dominokit.domino.ui.style.CssClass;

public class DynamicCssRegistryTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testInjectsDominoScopedVariableAndUtilityRule() {
    InMemoryStyleSheet styleSheet = new InMemoryStyleSheet();
    DynamicCssRegistry registry = new DynamicCssRegistry(styleSheet);
    DynamicCssDefinition definition =
        DynamicCssDefinition.of("dui-test-inject", "dui-test-inject-value", "padding");

    CssClass cssClass = registry.cssClass(definition, "10px");

    assertEquals("dui-test-inject-10px", cssClass.getCssClass());
    assertEquals(2, styleSheet.ruleCount());
    assertEquals("10px", styleSheet.property("body.dui", "--dui-test-inject-value-10px"));
    assertEquals(
        "var(--dui-test-inject-value-10px)",
        styleSheet.property(".dui.dui-test-inject-10px", "padding"));
  }

  public void testSameDefinitionAndValueReuseOneVariableAndOneUtilityRule() {
    InMemoryStyleSheet styleSheet = new InMemoryStyleSheet();
    DynamicCssRegistry registry = new DynamicCssRegistry(styleSheet);
    DynamicCssDefinition definition =
        DynamicCssDefinition.of("dui-test-reuse", "dui-test-reuse-value", "padding");

    CssClass first = registry.cssClass(definition, "10px");
    CssClass second = registry.cssClass(definition, "10px");

    assertEquals(first.getCssClass(), second.getCssClass());
    assertEquals(2, styleSheet.ruleCount());
  }

  public void testDifferentDefinitionsDoNotCollideForTheSameValue() {
    InMemoryStyleSheet styleSheet = new InMemoryStyleSheet();
    DynamicCssRegistry registry = new DynamicCssRegistry(styleSheet);

    CssClass padding =
        registry.cssClass(
            DynamicCssDefinition.of("dui-test-padding", "dui-test-shared", "padding"), "10px");
    CssClass gap =
        registry.cssClass(
            DynamicCssDefinition.of("dui-test-gap", "dui-test-shared", "gap"), "10px");

    assertEquals("dui-test-padding-10px", padding.getCssClass());
    assertEquals("dui-test-gap-10px", gap.getCssClass());
    assertEquals(3, styleSheet.ruleCount());
    assertEquals("10px", styleSheet.property("body.dui", "--dui-test-shared-10px"));
    assertEquals(
        "var(--dui-test-shared-10px)",
        styleSheet.property(".dui.dui-test-padding-10px", "padding"));
    assertEquals(
        "var(--dui-test-shared-10px)", styleSheet.property(".dui.dui-test-gap-10px", "gap"));
  }

  public void testExistingThemeVariableAndCompatibleUtilityRuleAreReusedWithoutWrites() {
    InMemoryStyleSheet styleSheet = new InMemoryStyleSheet();
    DynamicCssRegistry registry = new DynamicCssRegistry(styleSheet);
    styleSheet.setProperty(".dui.dui-theme-default", "--dui-spc-10", "2.5rem");
    styleSheet.setProperty(".dui.dui-p-10", "padding", "var(--dui-spc-10)");
    int writesBeforeRequest = styleSheet.setPropertyCalls();

    CssClass cssClass = registry.cssClass(DynamicPadding.PADDING, "10");

    assertEquals("dui-p-10", cssClass.getCssClass());
    assertEquals(writesBeforeRequest, styleSheet.setPropertyCalls());
  }

  public void testExistingDirectValueUtilityRuleIsReusedWithoutWrites() {
    InMemoryStyleSheet styleSheet = new InMemoryStyleSheet();
    DynamicCssRegistry registry = new DynamicCssRegistry(styleSheet);
    styleSheet.setProperty(".dui.dui-m-b-auto", "margin-bottom", "auto");
    int writesBeforeRequest = styleSheet.setPropertyCalls();

    CssClass cssClass = registry.cssClass(DynamicMargin.BOTTOM, "auto");

    assertEquals("dui-m-b-auto", cssClass.getCssClass());
    assertEquals(writesBeforeRequest, styleSheet.setPropertyCalls());
  }

  public void testAdvancedUtilitiesReuseTheirExistingStaticVariables() {
    InMemoryStyleSheet styleSheet = new InMemoryStyleSheet();
    DynamicCssRegistry registry = new DynamicCssRegistry(styleSheet);
    styleSheet.setProperty(".dui.dui-theme-default", "--dui-spc-10", "2.5rem");
    styleSheet.setProperty(".dui.dui-theme-default", "--dui-grow-2", "2");
    styleSheet.setProperty(".dui.dui-theme-default", "--dui-shrink-2", "2");
    styleSheet.setProperty(".dui.dui-theme-default", "--dui-order-2", "2");
    styleSheet.setProperty(".dui.dui-basis-10", "flex-basis", "var(--dui-spc-10)");
    styleSheet.setProperty(".dui.dui-grow-2", "flex-grow", "var(--dui-grow-2)");
    styleSheet.setProperty(".dui.dui-shrink-2", "flex-shrink", "var(--dui-shrink-2)");
    styleSheet.setProperty(".dui.dui-order-2", "order", "var(--dui-order-2)");
    styleSheet.setProperty(".dui.dui-border-10", "border-width", "var(--dui-spc-10)");
    int writesBeforeRequest = styleSheet.setPropertyCalls();

    assertEquals("dui-basis-10", registry.cssClass(DynamicFlex.BASIS, "10").getCssClass());
    assertEquals("dui-grow-2", registry.cssClass(DynamicFlex.GROW, "2").getCssClass());
    assertEquals("dui-shrink-2", registry.cssClass(DynamicFlex.SHRINK, "2").getCssClass());
    assertEquals("dui-order-2", registry.cssClass(DynamicFlex.ORDER, "2").getCssClass());
    assertEquals("dui-border-10", registry.cssClass(DynamicBorder.BORDER, "10").getCssClass());
    assertEquals(writesBeforeRequest, styleSheet.setPropertyCalls());
  }

  public void testExistingApplicationVariableIsReusedWhenTheUtilityRuleIsMissing() {
    InMemoryStyleSheet styleSheet = new InMemoryStyleSheet();
    DynamicCssRegistry registry = new DynamicCssRegistry(styleSheet);
    styleSheet.setProperty(".workspace", "--dui-spc-sidebar", "18rem");
    int writesBeforeRequest = styleSheet.setPropertyCalls();

    CssClass cssClass = registry.cssClass(DynamicPadding.LEFT, "sidebar");

    assertEquals("dui-p-l-sidebar", cssClass.getCssClass());
    assertEquals(writesBeforeRequest + 1, styleSheet.setPropertyCalls());
    assertEquals("", styleSheet.property("body.dui", "--dui-spc-sidebar"));
    assertEquals(
        "var(--dui-spc-sidebar)", styleSheet.property(".dui.dui-p-l-sidebar", "padding-left"));
  }

  public void testCssVariableExpressionInjectsOnlyADirectUtilityRule() {
    InMemoryStyleSheet styleSheet = new InMemoryStyleSheet();
    DynamicCssRegistry registry = new DynamicCssRegistry(styleSheet);
    String expression = "var(--dui-my-app-spc-5, var(--dui-my-app-default-spc))";

    CssClass cssClass = registry.cssClass(DynamicPadding.PADDING, expression);

    assertTrue(cssClass.getCssClass().startsWith("dui-p-var-"));
    assertEquals(1, styleSheet.setPropertyCalls());
    assertEquals(1, styleSheet.ruleCount());
    assertEquals(expression, styleSheet.property(".dui." + cssClass.getCssClass(), "padding"));
  }

  public void testArbitraryRawValueUsesASafeStableClassTokenWithoutChangingTheValue() {
    InMemoryStyleSheet styleSheet = new InMemoryStyleSheet();
    DynamicCssRegistry registry = new DynamicCssRegistry(styleSheet);
    DynamicCssDefinition definition =
        DynamicCssDefinition.of("dui-test-expression", "dui-test-expression-value", "padding");
    String rawValue = "calc(100% - 1rem)";

    CssClass first = registry.cssClass(definition, rawValue);
    CssClass second = registry.cssClass(definition, rawValue);

    assertTrue(first.getCssClass().startsWith("dui-test-expression-dyn-"));
    assertEquals(first.getCssClass(), second.getCssClass());
    assertEquals(2, styleSheet.ruleCount());
    assertEquals(
        rawValue,
        styleSheet.property(
            "body.dui", "--dui-test-expression-value-" + first.getCssClass().substring(20)));
  }

  public void testLazyCssClassResolvesItsSupplierOnlyWhenItsNameIsRequested() {
    int[] resolutions = {0};
    CssClass cssClass =
        new LazyDynamicCssClass(
            () -> {
              resolutions[0]++;
              return () -> "dui-p-4";
            });

    assertEquals(0, resolutions[0]);
    assertEquals("dui-p-4", cssClass.getCssClass());
    assertEquals("dui-p-4", cssClass.getCssClass());
    assertEquals(1, resolutions[0]);
  }

  public void testLazyCompatibilityClassInjectsItsCanonicalRuleOnlyWhenResolved() {
    InMemoryStyleSheet styleSheet = new InMemoryStyleSheet();
    DynamicCssRegistry registry = new DynamicCssRegistry(styleSheet);

    CssClass cssClass = registry.lazyCssClass(DynamicPadding.PADDING, "4", "var(--dui-spc-4)");

    assertEquals(0, styleSheet.ruleCount());
    assertEquals("dui-p-4", cssClass.getCssClass());
    assertEquals(1, styleSheet.ruleCount());
    assertEquals("var(--dui-spc-4)", styleSheet.property(".dui.dui-p-4", "padding"));
  }

  public void testStaticSpacingClassResolvesLazilyUsingItsExistingSelector() {
    InMemoryStyleSheet styleSheet = new InMemoryStyleSheet();
    DynamicCssRegistry registry = new DynamicCssRegistry(styleSheet);

    CssClass cssClass = registry.lazyCssClass("dui-p-x-4");

    assertEquals(0, styleSheet.ruleCount());
    assertEquals("dui-p-x-4", cssClass.getCssClass());
    assertEquals(1, styleSheet.ruleCount());
    assertEquals("var(--dui-spc-4)", styleSheet.property(".dui.dui-p-x-4", "padding-left"));
    assertEquals("var(--dui-spc-4)", styleSheet.property(".dui.dui-p-x-4", "padding-right"));
  }

  public void testStaticPositionAndMarginAutoClassesUseTheirDirectValues() {
    InMemoryStyleSheet styleSheet = new InMemoryStyleSheet();
    DynamicCssRegistry registry = new DynamicCssRegistry(styleSheet);

    CssClass margin = registry.lazyCssClass("dui-m-x-auto");
    CssClass inset = registry.lazyCssClass("dui-inset-auto");

    assertEquals(0, styleSheet.ruleCount());
    assertEquals("dui-m-x-auto", margin.getCssClass());
    assertEquals("auto", styleSheet.property(".dui.dui-m-x-auto", "margin-left"));
    assertEquals("auto", styleSheet.property(".dui.dui-m-x-auto", "margin-right"));
    assertEquals("dui-inset-auto", inset.getCssClass());
    assertEquals("auto", styleSheet.property(".dui.dui-inset-auto", "top"));
    assertEquals("auto", styleSheet.property(".dui.dui-inset-auto", "right"));
    assertEquals("auto", styleSheet.property(".dui.dui-inset-auto", "bottom"));
    assertEquals("auto", styleSheet.property(".dui.dui-inset-auto", "left"));
  }

  public void testStaticBorderFlexAndTypographyClassesResolveLazilyUsingExistingSelectors() {
    InMemoryStyleSheet styleSheet = new InMemoryStyleSheet();
    DynamicCssRegistry registry = new DynamicCssRegistry(styleSheet);

    CssClass border = registry.lazyCssClass("dui-border-x-4");
    CssClass grow = registry.lazyCssClass("dui-grow-2");
    CssClass order = registry.lazyCssClass("dui-order-20");
    CssClass indent = registry.lazyCssClass("dui-txt-indnt-4");
    CssClass fontSize = registry.lazyCssClass("dui-font-size-4");
    CssClass leading = registry.lazyCssClass("dui-leading-6");

    assertEquals("dui-border-x-4", border.getCssClass());
    assertEquals(
        "var(--dui-spc-4)", styleSheet.property(".dui.dui-border-x-4", "border-left-width"));
    assertEquals(
        "var(--dui-spc-4)", styleSheet.property(".dui.dui-border-x-4", "border-right-width"));
    assertEquals("dui-grow-2", grow.getCssClass());
    assertEquals("var(--dui-grow-2)", styleSheet.property(".dui.dui-grow-2", "flex-grow"));
    assertEquals("dui-order-20", order.getCssClass());
    assertEquals("var(--dui-order-20)", styleSheet.property(".dui.dui-order-20", "order"));
    assertEquals("dui-txt-indnt-4", indent.getCssClass());
    assertEquals("var(--dui-spc-4)", styleSheet.property(".dui.dui-txt-indnt-4", "text-indent"));
    assertEquals("dui-font-size-4", fontSize.getCssClass());
    assertEquals(
        "var(--dui-spc-4)", styleSheet.property(".dui.dui-font-size-4", "--dui-font-size"));
    assertEquals("var(--dui-spc-4)", styleSheet.property(".dui.dui-font-size-4", "font-size"));
    assertEquals("dui-leading-6", leading.getCssClass());
    assertEquals("1.5rem", styleSheet.property(".dui.dui-leading-6", "line-height"));
  }

  public void testPreloadingResolvesEveryMigratedStaticUtilityExactlyOnce() {
    InMemoryStyleSheet styleSheet = new InMemoryStyleSheet();
    DynamicCssRegistry registry = new DynamicCssRegistry(styleSheet);

    StaticDynamicCssUtility.preloadAll(registry);
    StaticDynamicCssUtility.preloadAll(registry);

    assertEquals(1826, styleSheet.ruleCount());
    assertEquals("var(--dui-spc-4)", styleSheet.property(".dui.dui-p-x-4", "padding-left"));
    assertEquals("var(--dui-spc-4)", styleSheet.property(".dui.dui-p-x-4", "padding-right"));
    assertEquals("auto", styleSheet.property(".dui.dui-m-x-auto", "margin-left"));
    assertEquals("auto", styleSheet.property(".dui.dui-m-x-auto", "margin-right"));
    assertEquals("100vw", styleSheet.property(".dui.dui-w-screen", "width"));
    assertEquals("10", styleSheet.property(".dui.dui-z-10", "z-index"));
    assertEquals("dui-grow-2", registry.cssClass(DynamicFlex.GROW, "2").getCssClass());
  }

  public void testStaticUtilityPreloadingIsLimitedToSuperDevMode() {
    assertTrue(DynamicCss.shouldPreloadStaticUtilities(true, false));
    assertFalse(DynamicCss.shouldPreloadStaticUtilities(true, true));
    assertFalse(DynamicCss.shouldPreloadStaticUtilities(false, false));
  }

  private static class InMemoryStyleSheet implements DynamicCssStyleSheet {

    private final Map<String, Map<String, String>> rules = new LinkedHashMap<>();
    private int setPropertyCalls;

    @Override
    public boolean hasRule(String selector) {
      return rules.containsKey(selector);
    }

    @Override
    public void setProperty(String selector, String property, String value) {
      setPropertyCalls++;
      rules.computeIfAbsent(selector, ignored -> new LinkedHashMap<>()).put(property, value);
    }

    private int ruleCount() {
      return rules.size();
    }

    @Override
    public String getPropertyValue(String selector, String property) {
      Map<String, String> properties = rules.get(selector);
      return properties == null ? "" : properties.getOrDefault(property, "");
    }

    @Override
    public boolean hasProperty(String property) {
      return rules.values().stream().anyMatch(properties -> properties.containsKey(property));
    }

    private String property(String selector, String property) {
      return getPropertyValue(selector, property);
    }

    private int setPropertyCalls() {
      return setPropertyCalls;
    }
  }
}
