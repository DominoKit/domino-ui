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
package org.dominokit.domino.ui.collapsible;

import com.google.gwt.junit.client.GWTTestCase;

public class AccordionTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testInsertChildKeepsPanelListAndDomInSameOrder() {
    Accordion accordion = Accordion.create();
    AccordionPanel first = new AccordionPanel();
    AccordionPanel third = new AccordionPanel();
    AccordionPanel second = new AccordionPanel();
    accordion.appendChild(first, third);

    accordion.insertChild(1, second);

    assertSame(second, accordion.getPanels().get(1));
    assertSame(second.element(), accordion.element().childNodes.item(1));
    assertSame(third.element(), accordion.element().childNodes.item(2));
  }
}
