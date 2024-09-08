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
package org.dominokit.domino.ui.shaded.style;

import static java.util.Objects.isNull;

/** An enum representing the css units */
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

  Unit(UnitFormatter unitFormatter, UnitParser unitParser) {
    this.unitFormatter = unitFormatter;
    this.unitParser = unitParser;
  }

  /**
   * Formats the number based on the unit
   *
   * @param value the number value
   * @return the formatted string value
   */
  public String of(Number value) {
    return unitFormatter.format(value);
  }

  /**
   * Parses the string based on the unit
   *
   * @param value the string value
   * @return the number value
   */
  public Number parse(String value) {
    return unitParser.parse(value);
  }

  /** A formatter for formatting the number value based on the unit */
  @FunctionalInterface
  @Deprecated
  public interface UnitFormatter {
    String format(Number value);
  }
  /** A formatter for formatting the number value based on the unit */
  @FunctionalInterface
  @Deprecated
  public interface UnitParser {
    Number parse(String value);
  }

  private static class Constants {
    private static UnitParser parser(int numOfChars) {
      return value ->
          isNull(value) ? 0 : Double.parseDouble(value.substring(0, value.length() - numOfChars));
    }
  }
}
