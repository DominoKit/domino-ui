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
package org.dominokit.domino.ui.keyboard;

import static org.dominokit.domino.ui.utils.Domino.div;

import com.google.gwt.junit.client.GWTTestCase;
import elemental2.dom.HTMLElement;
import elemental2.dom.KeyboardEvent;
import elemental2.dom.KeyboardEventInit;

public class KeyboardEventsTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testKeyUpListenerCanBeReattachedAfterStopping() {
    HTMLElement element = div().element();
    KeyboardEvents<HTMLElement> events = new KeyboardEvents<>(element);
    int[] calls = {0};

    events.listenOnKeyUp(keys -> keys.any(event -> calls[0]++));
    dispatchKeyUp(element);
    assertEquals(1, calls[0]);

    events.stopListenOnKeyUp();
    dispatchKeyUp(element);
    assertEquals(1, calls[0]);

    events.listenOnKeyUp(keys -> keys.any(event -> calls[0]++));
    dispatchKeyUp(element);
    assertEquals(2, calls[0]);
  }

  private void dispatchKeyUp(HTMLElement element) {
    KeyboardEventInit init = KeyboardEventInit.create();
    init.setKey("a");
    element.dispatchEvent(new KeyboardEvent("keyup", init));
  }
}
