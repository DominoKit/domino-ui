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
import elemental2.dom.Element;
import elemental2.dom.MouseEvent;
import org.dominokit.domino.ui.icons.lib.Icons;

public class FabTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testStandaloneFabBehavesAsNormalButton() {
    Fab fab = Fab.create(Icons.plus());
    boolean[] clicked = {false};

    fab.getButton().addClickListener(event -> clicked[0] = true);
    fab.getButton().element().dispatchEvent(new MouseEvent("click"));

    assertTrue(clicked[0]);
    assertFalse(fab.isExpanded());
    assertNull(fab.getButton().getAttribute("aria-expanded"));
    assertNull(fab.getButton().getAttribute("aria-haspopup"));
    assertNull(fab.getButton().getAttribute("aria-controls"));
  }

  public void testExpandableFabStartsCollapsedAndExposesActions() {
    Fab fab = Fab.create(Icons.plus());
    Button action = Button.create(Icons.email()).setAriaLabel("Email");

    fab.addAction(action);

    Element actions = fab.element().querySelector(".dui-fab-actions");
    assertFalse(fab.isExpanded());
    assertNotNull(actions);
    assertEquals("false", fab.getButton().getAttribute("aria-expanded"));
    assertEquals("true", fab.getButton().getAttribute("aria-haspopup"));
    assertNotNull(fab.getButton().getAttribute("aria-controls"));
    assertTrue(actions.hasAttribute("hidden"));
  }

  public void testPrimaryButtonClickTogglesExpandableFab() {
    Fab fab = Fab.create(Icons.plus()).addAction(Button.create(Icons.pencil()));
    Element actions = fab.element().querySelector(".dui-fab-actions");

    fab.getButton().element().dispatchEvent(new MouseEvent("click"));
    assertTrue(fab.isExpanded());
    assertEquals("true", fab.getButton().getAttribute("aria-expanded"));
    assertFalse(actions.hasAttribute("hidden"));

    fab.getButton().element().dispatchEvent(new MouseEvent("click"));
    assertFalse(fab.isExpanded());
    assertEquals("false", fab.getButton().getAttribute("aria-expanded"));
    assertTrue(actions.hasAttribute("hidden"));
  }

  public void testActionClickDoesNotToggleFab() {
    Fab fab = Fab.create(Icons.plus());
    Button action = Button.create(Icons.pencil());
    boolean[] clicked = {false};
    action.addClickListener(event -> clicked[0] = true);

    fab.addAction(action).setExpanded(true);
    action.element().dispatchEvent(new MouseEvent("click"));

    assertTrue(clicked[0]);
    assertTrue(fab.isExpanded());
  }
}
