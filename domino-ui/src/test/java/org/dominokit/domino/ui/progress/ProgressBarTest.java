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
package org.dominokit.domino.ui.progress;

import com.google.gwt.junit.client.GWTTestCase;

public class ProgressBarTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testChangingMaximumUpdatesAccessibleRangeAndClampsValue() {
    ProgressBar bar = ProgressBar.create(100).setValue(80);

    bar.setMaxValue(40);

    assertEquals(40d, bar.getValue(), 0d);
    assertEquals(40d, Double.parseDouble(bar.element().getAttribute("aria-valuemax")), 0d);
    assertEquals(40d, Double.parseDouble(bar.element().getAttribute("aria-valuenow")), 0d);
  }

  public void testNegativeConstructorMaximumIsNormalized() {
    ProgressBar bar = ProgressBar.create(-10);

    assertEquals(0d, bar.getMaxValue(), 0d);
    assertEquals("0", bar.element().getAttribute("aria-valuemax"));
  }

  public void testChangingProgressMembershipUpdatesAllWidths() {
    Progress progress = Progress.create();
    TrackingProgressBar first = new TrackingProgressBar(100);
    TrackingProgressBar second = new TrackingProgressBar(100);

    progress.appendChild(first);
    int firstUpdatesAfterFirstAppend = first.widthUpdates;
    progress.appendChild(second);
    assertTrue(first.widthUpdates > firstUpdatesAfterFirstAppend);
    assertTrue(second.widthUpdates > 0);

    int firstUpdatesBeforeRemoval = first.widthUpdates;
    second.remove();
    assertTrue(first.widthUpdates > firstUpdatesBeforeRemoval);
  }

  public void testChangingBarMaximumUpdatesSiblingWidths() {
    Progress progress = Progress.create();
    TrackingProgressBar first = new TrackingProgressBar(100);
    TrackingProgressBar second = new TrackingProgressBar(100);
    progress.appendChild(first, second);

    int siblingUpdates = second.widthUpdates;
    first.setMaxValue(200);

    assertTrue(second.widthUpdates > siblingUpdates);
  }

  private static class TrackingProgressBar extends ProgressBar {
    private int widthUpdates;

    private TrackingProgressBar(int maxValue) {
      super(maxValue);
    }

    @Override
    void updateWidth() {
      widthUpdates++;
      super.updateWidth();
    }
  }
}
