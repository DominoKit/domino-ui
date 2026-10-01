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
package org.dominokit.domino.ui.utils;

import com.google.gwt.junit.client.GWTTestCase;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;

public class DominoIdTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testDefaultIdsAreUniqueAndUsableInSelectors() {
    String first = DominoId.unique();
    String second = DominoId.unique();

    assertFalse(first.equals(second));
    assertTrue(first.matches("dui-[0-9]+-[0-9]+"));
    assertTrue(second.matches("dui-[0-9]+-[0-9]+"));
    assertSelectable(first);
    assertSelectable(second);
  }

  public void testCustomPrefixIsPreserved() {
    String id = DominoId.unique("custom-");

    assertTrue(id.matches("custom-[0-9]+-[0-9]+"));
    assertSelectable(id);
  }

  private void assertSelectable(String id) {
    HTMLElement element = (HTMLElement) DomGlobal.document.createElement("div");
    element.id = id;
    element.className = id;
    DomGlobal.document.body.appendChild(element);
    try {
      assertSame(element, DomGlobal.document.querySelector("#" + id));
      assertSame(element, DomGlobal.document.querySelector("." + id));
    } finally {
      element.remove();
    }
  }
}
