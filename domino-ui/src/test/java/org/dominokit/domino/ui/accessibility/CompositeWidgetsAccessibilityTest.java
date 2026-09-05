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
import org.dominokit.domino.ui.collapsible.AccordionPanel;
import org.dominokit.domino.ui.dialogs.MessageDialog;
import org.dominokit.domino.ui.progress.ProgressBar;
import org.dominokit.domino.ui.tabs.Tab;
import org.dominokit.domino.ui.tabs.TabsPanel;

public class CompositeWidgetsAccessibilityTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testTabsExposeTabListTabAndTabPanelSemantics() {
    TabsPanel tabs = TabsPanel.create();
    Tab tab = Tab.create("home", "Home");
    tabs.appendChild(tab);

    assertEquals("tablist", tabs.getTabsNav().getAttribute("role"));
    assertEquals("tab", tab.getClickableElement().getAttribute("role"));
    assertEquals("tabpanel", tab.getTabPanel().getAttribute("role"));
    assertEquals("true", tab.getClickableElement().getAttribute("aria-selected"));
  }

  public void testAccordionHeaderControlsItsPanel() {
    AccordionPanel panel = AccordionPanel.create("Details");

    assertEquals("button", panel.getHeader().getAttribute("role"));
    assertEquals("false", panel.getHeader().getAttribute("aria-expanded"));
    assertEquals(panel.getContent().getDominoId(), panel.getHeader().getAttribute("aria-controls"));
  }

  public void testDialogsExposeDialogSemantics() {
    MessageDialog dialog = MessageDialog.create("Title", "Message");

    assertEquals("dialog", dialog.getModalElement().getAttribute("role"));
    assertEquals("true", dialog.getModalElement().getAttribute("aria-modal"));
    assertEquals(
        dialog.getHeader().getDominoId(), dialog.getModalElement().getAttribute("aria-labelledby"));

    dialog.setModal(false);
    assertEquals("false", dialog.getModalElement().getAttribute("aria-modal"));
  }

  public void testProgressBarExposesItsValueRange() {
    ProgressBar progressBar = ProgressBar.create(100).setValue(40);

    assertEquals("0", progressBar.getAttribute("aria-valuemin"));
    assertEquals("100", progressBar.getAttribute("aria-valuemax"));
    assertEquals("40", progressBar.getAttribute("aria-valuenow"));
  }
}
