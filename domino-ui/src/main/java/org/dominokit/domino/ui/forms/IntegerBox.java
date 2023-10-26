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
package org.dominokit.domino.ui.forms;

import java.util.function.Function;

/** A specialized {@link NumberBox} for handling integer values. */
public class IntegerBox extends NumberBox<IntegerBox, Integer> {

  /**
   * Creates a new instance of IntegerBox with default value set to 0.
   *
   * @return A new instance of IntegerBox.
   */
  public static IntegerBox create() {
    return new IntegerBox();
  }

  /**
   * Creates a new instance of IntegerBox with the given label.
   *
   * @param label The label to be used for the IntegerBox.
   * @return A new instance of IntegerBox.
   */
  public static IntegerBox create(String label) {
    return new IntegerBox(label);
  }

  /** Default constructor. Sets the default value of the box to 0. */
  public IntegerBox() {
    setDefaultValue(0);
  }

  /**
   * Constructor with a label.
   *
   * @param label The label to be used for the IntegerBox.
   */
  public IntegerBox(String label) {
    this();
    setLabel(label);
  }

  /**
   * Provides the default parser for parsing string values to integers.
   *
   * @return The function to parse string values into integer values.
   */
  @Override
  protected Function<String, Integer> defaultValueParser() {
    return getConfig().getNumberParsers().integerParser(this);
  }

  /**
   * Returns the maximum representable value for an integer.
   *
   * @return The maximum integer value, {@link Integer#MAX_VALUE}.
   */
  @Override
  protected Integer defaultMaxValue() {
    return Integer.MAX_VALUE;
  }

  /**
   * Returns the minimum representable value for an integer.
   *
   * @return The minimum integer value, {@link Integer#MIN_VALUE}.
   */
  @Override
  protected Integer defaultMinValue() {
    return Integer.MIN_VALUE;
  }

  /**
   * Determines if the provided value exceeds the given maximum value.
   *
   * @param maxValue The maximum allowable value.
   * @param value The value to check.
   * @return True if the value exceeds the maximum, false otherwise.
   */
  @Override
  protected boolean isExceedMaxValue(Integer maxValue, Integer value) {
    return value > maxValue;
  }

  /**
   * Determines if the provided value is lower than the given minimum value.
   *
   * @param minValue The minimum allowable value.
   * @param value The value to check.
   * @return True if the value is lower than the minimum, false otherwise.
   */
  @Override
  protected boolean isLowerThanMinValue(Integer minValue, Integer value) {
    return value < minValue;
  }
}
