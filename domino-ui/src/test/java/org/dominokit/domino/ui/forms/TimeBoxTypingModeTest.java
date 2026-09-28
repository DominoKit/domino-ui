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
import java.util.Date;

public class TimeBoxTypingModeTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testTypingModeIsDisabledByDefaultAndCanBeEnabledExplicitly() {
    TimeBox timeBox = TimeBox.empty();

    assertFalse(timeBox.isTypingModeEnabled());
    assertTrue(timeBox.setTypingModeEnabled(true).isTypingModeEnabled());
    assertFalse(timeBox.setTypingModeEnabled(false).isTypingModeEnabled());
  }

  public void testTypingModeUsesTheInputKeyboardPathToCommitACompleteTime() {
    TimeBox timeBox =
        TimeBox.empty().setPattern("HH:mm").setTypingModeEnabled(true).pauseValidations();

    type(timeBox, "1430");

    assertEquals("14:30", timeBox.getStringValue());
    assertNull(timeBox.getValue());

    key(timeBox, "Enter");

    assertNotNull(timeBox.getValue());
    assertEquals("14:30", timeBox.getStringValue());
  }

  public void testTypingModeCommitsAnAmPmTime() {
    TimeBox timeBox =
        TimeBox.empty().setPattern("h:mm a").setTypingModeEnabled(true).pauseValidations();

    type(timeBox, "3:45 PM");
    key(timeBox, "Enter");

    assertNotNull(timeBox.getValue());
    assertEquals("3:45 PM", timeBox.getStringValue());
  }

  public void testTypingModeAdvancesFromASingleDigitHourToMinutes() {
    Date initialValue = new Date(0);
    initialValue.setHours(14);
    initialValue.setMinutes(38);
    TimeBox timeBox =
        TimeBox.create(initialValue)
            .setPattern("h:mm a")
            .setTypingModeEnabled(true)
            .pauseValidations();

    assertEquals("2:38 PM", timeBox.getStringValue());
    type(timeBox, "305");
    key(timeBox, "Enter");

    assertEquals("3:05 PM", timeBox.getStringValue());
  }

  public void testTypingModeUsesItsPatternAsTheEmptyFieldPlaceholder() {
    TimeBox timeBox = TimeBox.empty().setPattern("HH:mm").setTypingModeEnabled(true);

    assertEquals("HH:mm", timeBox.getInputElement().element().placeholder);

    timeBox.setTypingModeEnabled(false);

    assertEquals("", timeBox.getInputElement().element().placeholder);
  }

  public void testTypingModeKeepsThePickerAvailableOnlyFromItsAddonIcon() {
    TimeBox timeBox = TimeBox.empty().setTypingModeEnabled(true);

    assertFalse(isPickerOpenOnClick(timeBox));
    timeBox.getInputElement().element().click();
    assertTrue(isPickerCollapsed(timeBox));

    pickerAddon(timeBox).click();
    assertFalse(isPickerCollapsed(timeBox));
  }

  public void testReadOnlyFieldDoesNotStartATypingSession() {
    TimeBox timeBox =
        TimeBox.empty().setPattern("HH:mm").setTypingModeEnabled(true).setReadOnly(true);

    key(timeBox, "1");

    assertEquals("", timeBox.getStringValue());
    assertNull(timeBox.getValue());
  }

  private void type(TimeBox timeBox, String value) {
    for (int index = 0; index < value.length(); index++) {
      key(timeBox, value.substring(index, index + 1));
    }
  }

  private void key(TimeBox timeBox, String key) {
    KeyboardEventInit init = KeyboardEventInit.create();
    init.setKey(key);
    timeBox.getInputElement().element().dispatchEvent(new KeyboardEvent("keydown", init));
  }

  private HTMLElement pickerAddon(TimeBox timeBox) {
    return (HTMLElement)
        timeBox.element().querySelector(".dui-clickable[aria-label='Open time picker']");
  }

  private boolean isPickerCollapsed(TimeBox timeBox) {
    boolean[] collapsed = new boolean[1];
    timeBox.withPopover(
        (ignored, popover) -> collapsed[0] = popover.getCollapsible().isCollapsed());
    return collapsed[0];
  }

  private boolean isPickerOpenOnClick(TimeBox timeBox) {
    boolean[] openOnClick = new boolean[1];
    timeBox.withPopover((ignored, popover) -> openOnClick[0] = popover.isOpenOnClick());
    return openOnClick[0];
  }
}
