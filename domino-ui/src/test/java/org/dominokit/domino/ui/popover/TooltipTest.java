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
package org.dominokit.domino.ui.popover;

import static org.dominokit.domino.ui.utils.Domino.body;
import static org.dominokit.domino.ui.utils.Domino.div;

import com.google.gwt.junit.client.GWTTestCase;
import elemental2.dom.MouseEvent;
import org.dominokit.domino.ui.elements.DivElement;
import org.gwtproject.timer.client.Timer;

public class TooltipTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testTooltipClosesAfterRepeatedHoverCycles() {
    DivElement target = div();
    body().appendChild(target);
    Tooltip tooltip = Tooltip.create(target, "Tooltip");

    delayTestFinish(2000);
    tooltip.open();
    assertTrue(isAttached(tooltip));

    dispatchMouseEvent(target, "mouseleave");
    new Timer() {
      @Override
      public void run() {
        assertFalse(isAttached(tooltip));
        tooltip.open();
        assertTrue(isAttached(tooltip));
        dispatchMouseEvent(target, "mouseleave");
        new Timer() {
          @Override
          public void run() {
            assertFalse(isAttached(tooltip));
            target.remove();
            finishTest();
          }
        }.schedule(400);
      }
    }.schedule(400);
  }

  private void dispatchMouseEvent(DivElement target, String eventType) {
    target.element().dispatchEvent(new MouseEvent(eventType));
  }

  private boolean isAttached(Tooltip tooltip) {
    return tooltip.element().parentNode != null;
  }
}
