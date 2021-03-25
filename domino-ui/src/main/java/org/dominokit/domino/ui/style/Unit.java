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
package org.dominokit.domino.ui.style;

/** An enum representing the css units */
public enum Unit {
  px(value -> value + "px"),
  q(value -> value + "q"),
  mm(value -> value + "mm"),
  cm(value -> value + "cm"),
  in(value -> value + "in"),
  pt(value -> value + "pt"),
  pc(value -> value + "pc"),
  em(value -> value + "em"),
  rem(value -> value + "rem"),
  ex(value -> value + "ex"),
  ch(value -> value + "ch"),
  vw(value -> value + "vw"),
  vh(value -> value + "vh"),
  percent(value -> value + "%"),
  none(value -> value + "");

  private final UnitFormatter unitFormatter;

  Unit(UnitFormatter unitFormatter) {
    this.unitFormatter = unitFormatter;
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

  /** A formatter for formatting the number value based on the unit */
  @FunctionalInterface
  public interface UnitFormatter {
    String format(Number value);
  }
}
