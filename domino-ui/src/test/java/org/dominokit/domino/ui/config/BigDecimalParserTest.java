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

import java.math.BigDecimal;
import org.junit.Test;

public class BigDecimalParserTest {

  @Test
  public void preservesPrecisionBeyondDoubleRange() {
    String value = "12345678901234567890.1234567890123456789";

    BigDecimal parsed = new FormsFieldsConfig.NumberParsers() {}.bigDecimalParser(null).apply(value);

    assertEquals(new BigDecimal(value), parsed);
  }
}
