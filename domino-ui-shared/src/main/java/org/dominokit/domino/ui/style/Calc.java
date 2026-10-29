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

/**
 * A utility class for constructing the {@code calc} CSS property expressions.
 *
 * <p>This class provides static methods to create common arithmetic {@code calc} expressions like
 * addition and subtraction.
 */
public class Calc {

  /**
   * Constructs a {@code calc} expression that represents the subtraction of two values.
   *
   * @param left the minuend (the number from which another number is to be subtracted)
   * @param right the subtrahend (the number to be subtracted from another number)
   * @return the resulting {@code calc} expression in the form "calc(left - right)"
   */
  public static String sub(String left, String right) {
    return "calc(" + left + " - " + right + ")";
  }

  /**
   * Constructs a {@code calc} expression that represents the addition of two values.
   *
   * @param left the first value to be added
   * @param right the second value to be added
   * @return the resulting {@code calc} expression in the form "calc(left + right)"
   */
  public static String sum(String left, String right) {
    return "calc(" + left + " + " + right + ")";
  }

  /**
   * Wraps the provided size or formula within a {@code calc} expression.
   *
   * @param size the size or formula string to be wrapped
   * @return the resulting {@code calc} expression in the form "calc(size)"
   */
  public static String of(String size) {
    return "calc(" + size + ")";
  }
}
