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
package org.dominokit.domino.ui.grid.flex;

import com.google.gwt.junit.client.GWTTestCase;

public class FlexLayoutTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testInsertingBeforeKeepsItemsAndDomInTheSameOrder() {
    FlexLayout layout = FlexLayout.create();
    FlexItem<?> first = FlexItem.create();
    FlexItem<?> second = FlexItem.create();
    FlexItem<?> third = FlexItem.create();

    layout.appendChild(first, third);
    layout.appendChildBefore(second, third);

    assertSame(first, layout.getFlexItems().get(0));
    assertSame(second, layout.getFlexItems().get(1));
    assertSame(third, layout.getFlexItems().get(2));
    assertSame(second.element(), layout.element().childNodes.item(1));
  }
}
