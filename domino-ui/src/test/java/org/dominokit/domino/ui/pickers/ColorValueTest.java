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
package org.dominokit.domino.ui.pickers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class ColorValueTest {

  @Test
  public void parsesThreeComponentHexAndRgbValues() {
    ColorValue hex = ColorValue.of("#12aBef");
    ColorValue rgb = ColorValue.of("rgb(18, 171, 239)");

    assertEquals(18, hex.getRed());
    assertEquals(171, hex.getGreen());
    assertEquals(239, hex.getBlue());
    assertEquals(hex.getHex().toLowerCase(), rgb.getHex());
  }

  @Test
  public void rejectsHexValuesThatDoNotHaveExactlyThreeByteComponents() {
    assertInvalid(() -> ColorValue.of("#FFF"));
    assertInvalid(() -> ColorValue.of("#11223344"));
    assertInvalid(() -> ColorValue.of("#GG2233"));
  }

  @Test
  public void rejectsMalformedAndOutOfRangeRgbComponents() {
    assertInvalid(() -> ColorValue.of("rgb(1, 2)"));
    assertInvalid(() -> ColorValue.of("rgb(1, 2, 3, 4)"));
    assertInvalid(() -> ColorValue.of("rgb(-1, 2, 3)"));
    assertInvalid(() -> ColorValue.of("rgb(256, 2, 3)"));
    assertInvalid(() -> ColorValue.of(1, -1, 3));
  }

  private void assertInvalid(Runnable action) {
    try {
      action.run();
      fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
      // Expected.
    }
  }
}
