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
package org.dominokit.domino.ui.forms;

import com.google.gwt.junit.client.GWTTestCase;
import elemental2.dom.HTMLElement;
import elemental2.dom.KeyboardEvent;
import elemental2.dom.KeyboardEventInit;

public class DateBoxTypingModeTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testTypingModeIsDisabledByDefaultAndCanBeEnabledExplicitly() {
    DateBox dateBox = DateBox.empty();

    assertFalse(dateBox.isTypingModeEnabled());
    assertTrue(dateBox.setTypingModeEnabled(true).isTypingModeEnabled());
    assertFalse(dateBox.setTypingModeEnabled(false).isTypingModeEnabled());
  }

  public void testTypingModeUsesTheInputKeyboardPathToCommitACompleteDate() {
    DateBox dateBox =
        DateBox.empty().setPattern("yyyy-MM-dd").setTypingModeEnabled(true).pauseValidations();

    type(dateBox, "20261001");

    assertEquals("2026-10-01", dateBox.getStringValue());
    assertNull(dateBox.getValue());

    key(dateBox, "Enter");

    assertNotNull(dateBox.getValue());
    assertEquals("2026-10-01", dateBox.getStringValue());
  }

  public void testTypingModeCommitsAFullMonthName() {
    DateBox dateBox =
        DateBox.empty().setPattern("MMMM d, yyyy").setTypingModeEnabled(true).pauseValidations();

    type(dateBox, "September 18, 2026");
    key(dateBox, "Enter");

    assertNotNull(dateBox.getValue());
    assertEquals("September 18, 2026", dateBox.getStringValue());
  }

  public void testTypingModeUsesItsPatternAsTheEmptyFieldPlaceholder() {
    DateBox dateBox = DateBox.empty().setPattern("yyyy-MM-dd").setTypingModeEnabled(true);

    assertEquals("yyyy-MM-dd", dateBox.getInputElement().element().placeholder);

    dateBox.setTypingModeEnabled(false);

    assertEquals("", dateBox.getInputElement().element().placeholder);
  }

  public void testTypingModeKeepsThePickerAvailableOnlyFromItsAddonIcon() {
    DateBox dateBox = DateBox.empty().setTypingModeEnabled(true);

    dateBox.getInputElement().element().click();
    assertTrue(isPickerCollapsed(dateBox));

    pickerAddon(dateBox).click();
    assertFalse(isPickerCollapsed(dateBox));
  }

  public void testReadOnlyFieldDoesNotStartATypingSession() {
    DateBox dateBox =
        DateBox.empty().setPattern("yyyy-MM-dd").setTypingModeEnabled(true).setReadOnly(true);

    key(dateBox, "2");

    assertEquals("", dateBox.getStringValue());
    assertNull(dateBox.getValue());
  }

  public void testChangingThePatternCancelsAnActiveTypingSession() {
    DateBox dateBox =
        DateBox.empty().setPattern("yyyy-MM-dd").setTypingModeEnabled(true).pauseValidations();

    type(dateBox, "2026");
    dateBox.setPattern("MM/dd/yyyy");
    key(dateBox, "Enter");

    assertNull(dateBox.getValue());
    assertEquals("", dateBox.getStringValue());
  }

  private void type(DateBox dateBox, String value) {
    for (int index = 0; index < value.length(); index++) {
      key(dateBox, value.substring(index, index + 1));
    }
  }

  private void key(DateBox dateBox, String key) {
    KeyboardEventInit init = KeyboardEventInit.create();
    init.setKey(key);
    dateBox.getInputElement().element().dispatchEvent(new KeyboardEvent("keydown", init));
  }

  private HTMLElement pickerAddon(DateBox dateBox) {
    return (HTMLElement)
        dateBox.element().querySelector(".dui-clickable[aria-label='Open calendar']");
  }

  private boolean isPickerCollapsed(DateBox dateBox) {
    boolean[] collapsed = new boolean[1];
    dateBox.withPopover(
        (ignored, popover) -> collapsed[0] = popover.getCollapsible().isCollapsed());
    return collapsed[0];
  }
}
