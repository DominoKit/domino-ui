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
package org.dominokit.domino.ui.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.dominokit.domino.ui.forms.IntegerBox;
import org.dominokit.domino.ui.forms.ShortBox;
import org.junit.Test;

public class IntegerParserTest {

  @Test
  public void preservesIntegerBoundaries() {
    FormsFieldsConfig.NumberParsers parsers = new FormsFieldsConfig.NumberParsers() {};

    assertEquals(Integer.MAX_VALUE, parsers.integerParser((IntegerBox) null).apply("2147483647").intValue());
    assertEquals(Short.MIN_VALUE, parsers.shortParser((ShortBox) null).apply("-32768").shortValue());
  }

  @Test
  public void rejectsFractionalAndOutOfRangeFallbackValues() {
    FormsFieldsConfig.NumberParsers parsers = new FormsFieldsConfig.NumberParsers() {};

    assertInvalid(() -> parsers.exactInteger(3.5, Integer.MIN_VALUE, Integer.MAX_VALUE));
    assertInvalid(() -> parsers.exactInteger(32768, Short.MIN_VALUE, Short.MAX_VALUE));
  }

  private void assertInvalid(Runnable action) {
    try {
      action.run();
      fail("Expected NumberFormatException");
    } catch (NumberFormatException expected) {
      // Expected.
    }
  }
}
