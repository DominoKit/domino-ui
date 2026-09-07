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
package org.dominokit.domino.ui.layout;

import com.google.gwt.junit.client.GWTTestCase;
import elemental2.dom.Element;
import org.dominokit.domino.ui.elements.SectionElement;

public class AppLayoutTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testDrawerInitializationDoesNotReenterLazyChildren() {
    AppLayout appLayout = AppLayout.create();

    SectionElement leftDrawer = appLayout.getLeftDrawer();
    SectionElement rightDrawer = appLayout.getRightDrawer();

    assertNotNull(leftDrawer);
    assertNotNull(rightDrawer);
    Element leftToggle =
        appLayout
            .getNavBar()
            .element()
            .querySelector("[aria-controls='" + leftDrawer.getDominoId() + "']");
    Element rightToggle =
        appLayout
            .getNavBar()
            .element()
            .querySelector("[aria-controls='" + rightDrawer.getDominoId() + "']");

    assertNotNull(leftToggle);
    assertNotNull(rightToggle);
  }
}
