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
package org.dominokit.domino.ui.accessibility;

import static org.dominokit.domino.ui.utils.Domino.*;

import com.google.gwt.junit.client.GWTTestCase;
import org.dominokit.domino.ui.icons.lib.Icons;

public class AccessibilityTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testGenericAnchorsDoNotExposeDisclosureState() {
    assertNull(a().getAttribute("aria-expanded"));
    assertNull(a("/docs").getAttribute("aria-expanded"));
  }

  public void testClickableIconsDoNotExposeDisclosureStateByDefault() {
    assertNull(Icons.close().clickable().getAttribute("aria-expanded"));
  }

  public void testCustomDisabledElementsExposeAriaDisabled() {
    assertEquals("true", div().setDisabled(true).getAttribute("aria-disabled"));
  }

  public void testBaseElementProvidesFluentAccessibilityAttributes() {
    assertEquals(
        "button",
        div()
            .setRole("button")
            .setAriaLabel("Actions")
            .setAriaLabelledBy("actions-label")
            .setAriaDescribedBy("actions-description")
            .setAriaControls("actions-menu")
            .setAriaExpanded(true)
            .setAriaSelected(true)
            .setAriaPressed(true)
            .setAriaChecked(true)
            .setAriaCurrent("page")
            .setAriaHidden(false)
            .setAriaDisabled(false)
            .setAriaRequired(true)
            .setAriaInvalid(false)
            .setAriaLive("polite")
            .setAriaHasPopup("menu")
            .setAriaAutocomplete("none")
            .setAriaMultiline(true)
            .setAriaValueMin(0)
            .setAriaValueMax(100)
            .setAriaValueNow(50)
            .getAttribute("role"));
    assertEquals("Actions", div().setAriaLabel("Actions").getAttribute("aria-label"));
  }

  public void testEmptyFluentAccessibilityReferencesAreRemoved() {
    assertFalse(div().setAriaLabel("Actions").setAriaLabel("").hasAttribute("aria-label"));
    assertFalse(
        div().setAriaControls("actions-menu").setAriaControls(null).hasAttribute("aria-controls"));
    assertFalse(div().setRole("button").setRole("").hasAttribute("role"));
  }
}
