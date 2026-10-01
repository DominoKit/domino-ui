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
package org.dominokit.domino.ui.button;

import com.google.gwt.junit.client.GWTTestCase;
import org.dominokit.domino.ui.style.CssClass;

public class ToggleButtonsGroupTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testResumeChangeListenersResumesNotifications() {
    ToggleButton button = ToggleButton.create();
    ToggleButtonsGroup group = ToggleButtonsGroup.create(button).setMultipleToggle(true);
    int[] changes = {0};
    group.addChangeListener((oldValue, newValue) -> changes[0]++);

    group.pauseChangeListeners();
    button.toggle();
    assertEquals(0, changes[0]);

    group.resumeChangeListeners();
    button.toggle();
    assertEquals(1, changes[0]);
  }

  public void testToggleCssClassCanBeSetBeforeAddingButtons() {
    CssClass toggleClass = () -> "custom-toggle";
    ToggleButtonsGroup group = ToggleButtonsGroup.create().setToggleCssClass(toggleClass);

    assertNotNull(group);
  }

  public void testRemovedButtonDoesNotKeepNotifyingGroup() {
    ToggleButton button = ToggleButton.create();
    ToggleButtonsGroup group = ToggleButtonsGroup.create(button).setMultipleToggle(true);
    int[] changes = {0};
    group.addChangeListener((oldValue, newValue) -> changes[0]++);

    group.removeChild(button);
    button.toggle();

    assertEquals(0, changes[0]);
  }
}
