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
    assertEquals("40.0", bar.element().getAttribute("aria-valuemax"));
    assertEquals("40.0", bar.element().getAttribute("aria-valuenow"));
  }
}
