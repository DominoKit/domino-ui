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

import static org.dominokit.domino.ui.utils.Domino.div;

import com.google.gwt.junit.client.GWTTestCase;
import elemental2.dom.DomGlobal;
import elemental2.dom.Event;
import org.dominokit.domino.ui.elements.DivElement;

public class BaseDominoElementMutationTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testAutoRemoveOnAttachAlsoRemovesDetachObserver() {
    delayTestFinish(1000);
    DivElement element = div();
    int[] calls = {0};
    element.onAttachedDetached(MutationObserverCallback.doOnce(record -> calls[0]++));

    DomGlobal.document.body.appendChild(element.element());
    DomGlobal.setTimeout(
        firstTimeout -> {
          DomGlobal.document.body.removeChild(element.element());
          DomGlobal.setTimeout(
              secondTimeout -> {
                assertEquals(1, calls[0]);
                finishTest();
              },
              50);
        },
        50);
  }

  public void testMultipleOneTimeAttributeObserversCanRemoveDuringNotification() {
    delayTestFinish(1000);
    DivElement element = div();
    int[] calls = {0};
    element.onAttributeChange("data-audit", MutationObserverCallback.doOnce(record -> calls[0]++));
    element.onAttributeChange("data-audit", MutationObserverCallback.doOnce(record -> calls[0]++));

    element.setAttribute("data-audit", "first");
    DomGlobal.setTimeout(
        firstTimeout -> {
          assertEquals(2, calls[0]);
          element.setAttribute("data-audit", "second");
          DomGlobal.setTimeout(
              secondTimeout -> {
                assertEquals(2, calls[0]);
                finishTest();
              },
              50);
        },
        50);
  }

  public void testAddEventsListenerCanCaptureBeforeChildStopsPropagation() {
    DivElement parent = div();
    DivElement child = div();
    int[] calls = {0};
    parent.appendChild(child);
    parent.addEventsListener(event -> calls[0]++, true, "audit-capture");
    child.element().addEventListener("audit-capture", event -> event.stopPropagation());
    DomGlobal.document.body.appendChild(parent.element());

    child.element().dispatchEvent(new Event("audit-capture"));

    assertEquals(1, calls[0]);
  }
}
