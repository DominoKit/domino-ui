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
package org.dominokit.domino.ui.tabs;

import static org.dominokit.domino.ui.utils.Domino.div;

import com.google.gwt.junit.client.GWTTestCase;
import org.dominokit.domino.ui.elements.DivElement;

public class TabsPanelTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testReplacingContentContainerMovesExistingTabPanelsInOrder() {
    TabsPanel tabs = TabsPanel.create();
    Tab members = Tab.create("members", "Members");
    Tab groups = Tab.create("groups", "Groups");
    tabs.appendChild(members, groups);
    DivElement contentContainer = div();

    tabs.setContentContainer(contentContainer);

    assertSame(contentContainer.element(), members.getTabPanel().element().parentElement);
    assertSame(contentContainer.element(), groups.getTabPanel().element().parentElement);
    assertSame(members.getTabPanel().element(), contentContainer.element().firstElementChild);
    assertSame(groups.getTabPanel().element(), contentContainer.element().lastElementChild);
  }
}
