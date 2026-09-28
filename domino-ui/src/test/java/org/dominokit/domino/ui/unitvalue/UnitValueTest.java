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
package org.dominokit.domino.ui.unitvalue;

import static org.dominokit.domino.ui.utils.Domino.div;

import com.google.gwt.junit.client.GWTTestCase;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.style.GenericCss;

public class UnitValueTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testValueOnlyRendersTheValueWithoutOptionalElements() {
    UnitValue unitValue = UnitValue.create("603.455");

    assertTrue(unitValue.element().classList.contains("dui-unit-value"));
    assertNotNull(unitValue.element().querySelector(".dui-unit-value-value-row"));
    assertEquals("603.455", text(unitValue, ".dui-unit-value-value"));
    assertNull(unitValue.element().querySelector(".dui-unit-value-title"));
    assertNull(unitValue.element().querySelector(".dui-unit-value-unit"));
    assertNull(unitValue.element().querySelector(".dui-unit-value-description"));
  }

  public void testVerticalContentKeepsTitleValueUnitAndDescriptionOrder() {
    UnitValue unitValue =
        UnitValue.create("-293.517", "JOD")
            .setTitle("Bank")
            .setDescription("Based on current month expenses");

    assertTrue(unitValue.element().firstElementChild.classList.contains("dui-unit-value-title"));
    assertTrue(
        ((HTMLElement) unitValue.element().childNodes.item(1))
            .classList.contains("dui-unit-value-value-row"));
    assertTrue(
        unitValue.element().lastElementChild.classList.contains("dui-unit-value-description"));
    assertEquals("Bank", text(unitValue, ".dui-unit-value-title"));
    assertEquals("-293.517", text(unitValue, ".dui-unit-value-value"));
    assertEquals("JOD", text(unitValue, ".dui-unit-value-unit"));
    assertEquals("Based on current month expenses", text(unitValue, ".dui-unit-value-description"));
  }

  public void testHorizontalModifierKeepsTitleAndValueOnTheMainLine() {
    UnitValue unitValue =
        UnitValue.create("-293.517", "JOD")
            .setTitle("Bank")
            .setDescription("Based on current month expenses")
            .addCss("dui-horizontal");

    assertTrue(unitValue.element().classList.contains("dui-horizontal"));
    assertEquals(3, unitValue.element().childNodes.length);
    assertSame(
        unitValue.element().querySelector(".dui-unit-value-title"),
        unitValue.element().firstElementChild);
    assertSame(
        unitValue.element().querySelector(".dui-unit-value-value-row"),
        unitValue.element().childNodes.item(1));
    assertSame(
        unitValue.element().querySelector(".dui-unit-value-description"),
        unitValue.element().lastElementChild);
  }

  public void testClearingOptionalContentRemovesItsElement() {
    UnitValue unitValue =
        UnitValue.create("78.661", "JOD").setTitle("Balance").setDescription("Available");

    unitValue.setTitle((String) null).setDescription((String) null).setUnit((String) null);

    assertNull(unitValue.element().querySelector(".dui-unit-value-title"));
    assertNull(unitValue.element().querySelector(".dui-unit-value-unit"));
    assertNull(unitValue.element().querySelector(".dui-unit-value-description"));
    assertEquals("78.661", text(unitValue, ".dui-unit-value-value"));
  }

  public void testIconUnitIsKeptAsASeparateUnitElement() {
    Icon<?> icon = Icons.currency_usd();
    UnitValue unitValue = UnitValue.create("1,989.729").setUnit(icon);

    assertSame(
        icon.element(),
        unitValue.element().querySelector(".dui-unit-value-unit").firstElementChild);
    assertEquals("1,989.729", text(unitValue, ".dui-unit-value-value"));
  }

  public void testUnitValueSupportsNodeTitleAndDescription() {
    UnitValue unitValue =
        UnitValue.create("78.661")
            .setTitle(div().setTextContent("Revenue"))
            .setDescription(div().setTextContent("Current period"));

    assertEquals("Revenue", text(unitValue, ".dui-unit-value-title"));
    assertEquals("Current period", text(unitValue, ".dui-unit-value-description"));
  }

  public void testSizeModifierStaysOnTheRootAndSubelementsRemainTargetable() {
    UnitValue unitValue =
        UnitValue.create("603.455", "JOD")
            .setTitle("Balance")
            .setDescription("Available")
            .addCss("dui-sm");

    assertTrue(unitValue.element().classList.contains("dui-sm"));
    assertTrue(
        unitValue
            .element()
            .querySelector(".dui-unit-value-value")
            .classList
            .contains("dui-unit-value-value"));
    assertFalse(
        unitValue.element().querySelector(".dui-unit-value-unit").classList.contains("dui-sm"));
    assertFalse(
        unitValue.element().querySelector(".dui-unit-value-title").classList.contains("dui-sm"));
    assertFalse(
        unitValue
            .element()
            .querySelector(".dui-unit-value-description")
            .classList
            .contains("dui-sm"));
  }

  public void testContextualColorsAreReservedForTheValueText() {
    UnitValue unitValue = UnitValue.create("603.455").addCss(GenericCss.dui_success);

    assertTrue(unitValue.element().classList.contains("dui-ctx"));
    assertTrue(unitValue.element().classList.contains("dui-success"));
    assertTrue(unitValue.element().classList.contains("dui-ignore-bg"));
    assertTrue(unitValue.element().classList.contains("dui-ignore-fg"));
  }

  private String text(UnitValue unitValue, String selector) {
    return ((HTMLElement) unitValue.element().querySelector(selector)).textContent;
  }
}
