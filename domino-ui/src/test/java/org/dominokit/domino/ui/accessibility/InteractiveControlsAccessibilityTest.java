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

import com.google.gwt.junit.client.GWTTestCase;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.DropdownButton;
import org.dominokit.domino.ui.button.RemoveButton;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.menu.Menu;

public class InteractiveControlsAccessibilityTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testIconOnlyButtonsCanDeclareAnAccessibleName() {
    Button button = Button.create(Icons.close());
    button.setAttribute("aria-label", "Close");
    assertEquals("Close", button.getAttribute("aria-label"));
  }

  public void testRemoveButtonHasAnAccessibleName() {
    assertEquals("Remove", RemoveButton.create().getAttribute("aria-label"));
  }

  public void testDropdownSynchronizesExpandedStateAndControls() {
    Menu<String> menu = Menu.create();
    DropdownButton<Button, String> dropdown = DropdownButton.create(Button.create("Actions"), menu);

    assertEquals("false", dropdown.getButton().getAttribute("aria-expanded"));
    assertEquals(menu.getDominoId(), dropdown.getButton().getAttribute("aria-controls"));
  }

  public void testCardCollapseControlExposesExpandedState() {
    Card card = Card.create("Collapsible").setCollapsible(true);

    assertEquals(
        "true", card.element().querySelector(".dui-clickable").getAttribute("aria-expanded"));
    card.collapse();
    assertEquals(
        "false", card.element().querySelector(".dui-clickable").getAttribute("aria-expanded"));
  }
}
