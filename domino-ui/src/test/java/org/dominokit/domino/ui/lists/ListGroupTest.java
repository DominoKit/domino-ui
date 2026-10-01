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
package org.dominokit.domino.ui.lists;

import com.google.gwt.junit.client.GWTTestCase;

public class ListGroupTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testInsertAtKeepsDomOrderAlignedWithItems() {
    ListGroup<String> listGroup = ListGroup.create();
    listGroup.addItem("first").addItem("third").insertAt(1, "second");

    assertEquals("first", listGroup.getItems().get(0).getValue());
    assertEquals("second", listGroup.getItems().get(1).getValue());
    assertEquals("third", listGroup.getItems().get(2).getValue());
    assertSame(listGroup.getItems().get(0).element(), listGroup.element().firstChild);
    assertSame(listGroup.getItems().get(1).element(), listGroup.element().childNodes.item(1));
    assertSame(listGroup.getItems().get(2).element(), listGroup.element().lastChild);
  }
}
