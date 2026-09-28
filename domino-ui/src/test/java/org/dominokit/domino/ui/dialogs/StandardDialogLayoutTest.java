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
package org.dominokit.domino.ui.dialogs;

import com.google.gwt.junit.client.GWTTestCase;
import elemental2.dom.Element;
import elemental2.dom.NodeList;

/** Verifies the shared header and action layout of the standard dialogs. */
public class StandardDialogLayoutTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testStandardDialogsUseTheDedicatedHeaderNavStyle() {
    assertStandardHeaderNav(MessageDialog.create("Message"));
    assertStandardHeaderNav(ConfirmationDialog.create("Confirmation"));
    assertStandardHeaderNav(AlertMessageDialog.create("Alert"));
  }

  public void testStandardDialogsPlaceActionsInAPaddedFooterNavBar() {
    assertFooterActions(MessageDialog.create(), 1);
    assertFooterActions(ConfirmationDialog.create(), 2);
    assertFooterActions(AlertMessageDialog.create(), 1);
  }

  public void testConfirmationDialogPlacesTheLinkStyledRejectActionBeforeTheConfirmAction() {
    ConfirmationDialog dialog = ConfirmationDialog.create();
    NodeList<Element> actions =
        dialog.getContentFooter().element().querySelectorAll(".dui-postfix-addon");

    assertEquals(2, actions.length);
    assertSame(dialog.getRejectButton().element(), actions.item(0));
    assertSame(dialog.getConfirmButton().element(), actions.item(1));
    assertTrue(dialog.getRejectButton().element().classList.contains("dui-dialog-action"));
    assertTrue(dialog.getConfirmButton().element().classList.contains("dui-dialog-action"));
    assertTrue(
        dialog.getRejectButton().element().classList.contains("dui-dialog-secondary-action"));
  }

  private void assertStandardHeaderNav(AbstractDialog<?> dialog) {
    Element headerNav = dialog.getHeader().element().firstElementChild;

    assertNotNull(headerNav);
    assertEquals("NAV", headerNav.tagName);
    assertTrue(headerNav.classList.contains("dui-standard-dialog-nav"));
  }

  private void assertFooterActions(AbstractDialog<?> dialog, int expectedActionCount) {
    Element footerNav = dialog.getContentFooter().element().firstElementChild;

    assertNotNull(footerNav);
    assertEquals("NAV", footerNav.tagName);
    assertTrue(footerNav.classList.contains("dui-p-4"));
    assertEquals(
        expectedActionCount,
        footerNav.querySelectorAll(".dui-postfix-addon.dui-dialog-action").length);
  }
}
