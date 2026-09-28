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

import static org.dominokit.domino.ui.forms.datetime.DateTimePatternToken.Kind.DERIVED;
import static org.dominokit.domino.ui.forms.datetime.DateTimePatternToken.Kind.DISPLAY_ONLY;
import static org.dominokit.domino.ui.forms.datetime.DateTimePatternToken.Kind.LITERAL;
import static org.dominokit.domino.ui.forms.datetime.DateTimePatternToken.Kind.LOCALIZED_TEXT;
import static org.dominokit.domino.ui.forms.datetime.DateTimePatternToken.Kind.NUMERIC;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** Tokenizes GWT date-time patterns for the DateBox and TimeBox typing editor. */
public final class DateTimePatternTokenizer {

  private DateTimePatternTokenizer() {}

  /**
   * Splits a GWT date-time pattern into editable, derived, display-only, and literal tokens.
   *
   * @param pattern the GWT date-time format pattern
   * @return ordered tokens representing the supplied pattern
   * @throws IllegalArgumentException when the pattern contains an unclosed quoted literal
   */
  public static List<DateTimePatternToken> tokenize(String pattern) {
    Objects.requireNonNull(pattern, "pattern");

    List<DateTimePatternToken> tokens = new ArrayList<>();
    StringBuilder literal = new StringBuilder();
    int index = 0;
    while (index < pattern.length()) {
      char current = pattern.charAt(index);
      if (current == '\'') {
        index = appendQuotedLiteral(pattern, index, literal);
      } else if (Character.isLetter(current)) {
        addLiteral(tokens, literal);
        int end = index + 1;
        while (end < pattern.length() && pattern.charAt(end) == current) {
          end++;
        }
        String tokenPattern = pattern.substring(index, end);
        tokens.add(new DateTimePatternToken(kindOf(current, tokenPattern.length()), tokenPattern));
        index = end;
      } else {
        literal.append(current);
        index++;
      }
    }
    addLiteral(tokens, literal);
    return tokens;
  }

  private static int appendQuotedLiteral(String pattern, int quoteIndex, StringBuilder literal) {
    int index = quoteIndex + 1;
    if (index < pattern.length() && pattern.charAt(index) == '\'') {
      literal.append('\'');
      return index + 1;
    }

    while (index < pattern.length()) {
      char current = pattern.charAt(index);
      if (current == '\'') {
        if (index + 1 < pattern.length() && pattern.charAt(index + 1) == '\'') {
          literal.append('\'');
          index += 2;
        } else {
          return index + 1;
        }
      } else {
        literal.append(current);
        index++;
      }
    }
    throw new IllegalArgumentException("Unclosed quoted literal in date-time pattern: " + pattern);
  }

  private static void addLiteral(List<DateTimePatternToken> tokens, StringBuilder literal) {
    if (literal.length() == 0) {
      return;
    }
    String value = literal.toString();
    literal.setLength(0);
    if (!tokens.isEmpty() && tokens.get(tokens.size() - 1).getKind() == LITERAL) {
      DateTimePatternToken previous = tokens.remove(tokens.size() - 1);
      value = previous.getPattern() + value;
    }
    tokens.add(new DateTimePatternToken(LITERAL, value));
  }

  private static DateTimePatternToken.Kind kindOf(char symbol, int length) {
    switch (symbol) {
      case 'd':
      case 'D':
      case 'F':
      case 'w':
      case 'W':
      case 'y':
      case 'H':
      case 'h':
      case 'K':
      case 'k':
      case 'm':
      case 's':
      case 'S':
        return NUMERIC;
      case 'M':
      case 'L':
        return length <= 2 ? NUMERIC : LOCALIZED_TEXT;
      case 'a':
        return LOCALIZED_TEXT;
      case 'E':
      case 'c':
        return DERIVED;
      default:
        return DISPLAY_ONLY;
    }
  }
}
