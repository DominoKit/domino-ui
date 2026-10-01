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
package org.dominokit.domino.ui.spin;

import com.google.gwt.junit.client.GWTTestCase;

public class SpinSelectTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testPrependChildrenAddsItemsToTheBeginningInOrder() {
    HSpinSelect<String> spinSelect = HSpinSelect.create(false);
    SpinItem<String> first = SpinItem.create("first");
    SpinItem<String> second = SpinItem.create("second");
    SpinItem<String> existing = SpinItem.create("existing");

    spinSelect.appendChild(existing);
    spinSelect.prependChild(first, second);

    assertSame(first, spinSelect.getItems().get(0));
    assertSame(second, spinSelect.getItems().get(1));
    assertSame(existing, spinSelect.getItems().get(2));
  }

  public void testAppendingSameItemTwiceDoesNotDuplicateIt() {
    HSpinSelect<String> spinSelect = HSpinSelect.create(false);
    SpinItem<String> item = SpinItem.create("only");

    spinSelect.appendChild(item).appendChild(item).prependChild(item);

    assertEquals(1, spinSelect.getItems().size());
    assertSame(item, spinSelect.getItems().get(0));
  }
}
