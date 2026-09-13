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

import static java.util.Objects.isNull;

/** The {@code Unit} enum represents various units used in css. */
public enum Unit {
  px(value -> value + "px", Constants.parser(2)),
  q(value -> value + "q", Constants.parser(1)),
  mm(value -> value + "mm", Constants.parser(2)),
  cm(value -> value + "cm", Constants.parser(2)),
  in(value -> value + "in", Constants.parser(2)),
  pt(value -> value + "pt", Constants.parser(2)),
  pc(value -> value + "pc", Constants.parser(2)),
  em(value -> value + "em", Constants.parser(2)),
  rem(value -> value + "rem", Constants.parser(3)),
  ex(value -> value + "ex", Constants.parser(2)),
  ch(value -> value + "ch", Constants.parser(2)),
  vw(value -> value + "vw", Constants.parser(2)),
  vh(value -> value + "vh", Constants.parser(2)),
  percent(value -> value + "%", Constants.parser(1)),
  none(value -> value + "", Constants.parser(0));

  private final UnitFormatter unitFormatter;
  private final UnitParser unitParser;

  /**
   * Creates a new {@code Unit} with the specified formatting and parsing functions.
   *
   * @param unitFormatter The function to format a value with this unit.
   * @param unitParser The function to parse a value with this unit.
   */
  Unit(UnitFormatter unitFormatter, UnitParser unitParser) {
    this.unitFormatter = unitFormatter;
    this.unitParser = unitParser;
  }

  /**
   * Formats a numeric value with this unit.
   *
   * @param value The numeric value to format.
   * @return The formatted string with the unit.
   */
  public String of(Number value) {
    return unitFormatter.format(value);
  }

  /**
   * Parses a string value with this unit and returns a numeric value.
   *
   * @param value The string value to parse.
   * @return The parsed numeric value.
   */
  public Number parse(String value) {
    return unitParser.parse(value);
  }

  /** Functional interface for formatting numeric values with units. */
  @FunctionalInterface
  public interface UnitFormatter {
    String format(Number value);
  }

  /** Functional interface for parsing string values with units. */
  @FunctionalInterface
  public interface UnitParser {
    Number parse(String value);
  }

  private static class Constants {
    /**
     * Creates a unit parser based on the number of characters to remove from the end of the string.
     *
     * @param numOfChars The number of characters to remove.
     * @return The unit parser function.
     */
    private static UnitParser parser(int numOfChars) {
      return value ->
          isNull(value) ? 0 : Double.parseDouble(value.substring(0, value.length() - numOfChars));
    }
  }
}
