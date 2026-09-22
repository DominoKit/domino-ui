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
package org.dominokit.domino.ui.forms.datetime;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class DateTimePatternTokenizerTest {

  @Test
  public void tokenizesLocalizedDatePatternIntoEditableDerivedAndLiteralTokens() {
    List<DateTimePatternToken> tokens = DateTimePatternTokenizer.tokenize("EEEE, MMMM d, yyyy");

    assertEquals(
        Arrays.asList(
            new DateTimePatternToken(DateTimePatternToken.Kind.DERIVED, "EEEE"),
            new DateTimePatternToken(DateTimePatternToken.Kind.LITERAL, ", "),
            new DateTimePatternToken(DateTimePatternToken.Kind.LOCALIZED_TEXT, "MMMM"),
            new DateTimePatternToken(DateTimePatternToken.Kind.LITERAL, " "),
            new DateTimePatternToken(DateTimePatternToken.Kind.NUMERIC, "d"),
            new DateTimePatternToken(DateTimePatternToken.Kind.LITERAL, ", "),
            new DateTimePatternToken(DateTimePatternToken.Kind.NUMERIC, "yyyy")),
        tokens);
  }

  @Test
  public void preservesQuotedLiteralsAndMarksTimeZonesAsDisplayOnly() {
    List<DateTimePatternToken> tokens = DateTimePatternTokenizer.tokenize("HH:mm 'UTC' z");

    assertEquals(
        Arrays.asList(
            new DateTimePatternToken(DateTimePatternToken.Kind.NUMERIC, "HH"),
            new DateTimePatternToken(DateTimePatternToken.Kind.LITERAL, ":"),
            new DateTimePatternToken(DateTimePatternToken.Kind.NUMERIC, "mm"),
            new DateTimePatternToken(DateTimePatternToken.Kind.LITERAL, " UTC "),
            new DateTimePatternToken(DateTimePatternToken.Kind.DISPLAY_ONLY, "z")),
        tokens);
  }
}
