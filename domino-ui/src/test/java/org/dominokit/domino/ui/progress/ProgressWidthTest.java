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

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProgressWidthTest {

  @Test
  public void zeroAndNegativeMaximumsHaveSafeWidth() {
    assertEquals("0", ProgressWidth.calculateWidth(0, 0));
    assertEquals("0", ProgressWidth.calculateWidth(50, -10));
  }

  @Test
  public void positiveMaximumCalculatesPercentage() {
    assertEquals("25", ProgressWidth.calculateWidth(25, 100));
  }
}
