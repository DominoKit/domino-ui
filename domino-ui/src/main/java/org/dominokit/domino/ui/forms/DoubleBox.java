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

/** A specialized {@link NumberBox} for handling double-precision floating point values. */
public class DoubleBox extends NumberBox<DoubleBox, Double> {

  /**
   * Creates a new instance of DoubleBox with a default value set to 0.0.
   *
   * @return A new instance of DoubleBox.
   */
  public static DoubleBox create() {
    return new DoubleBox();
  }

  /**
   * Creates a new instance of DoubleBox with the given label.
   *
   * @param label The label to be used for the DoubleBox.
   * @return A new instance of DoubleBox.
   */
  public static DoubleBox create(String label) {
    return new DoubleBox(label);
  }

  /** Default constructor. Sets the default value of the box to 0.0. */
  public DoubleBox() {
    setDefaultValue(0.0);
  }

  /**
   * Constructor with a label.
   *
   * @param label The label to be used for the DoubleBox.
   */
  public DoubleBox(String label) {
    this();
    setLabel(label);
  }

  /**
   * Provides the default parser for parsing string values to doubles.
   *
   * @return The function to parse string values into double values.
   */
  @Override
  protected Function<String, Double> defaultValueParser() {
    return getConfig().getNumberParsers().doubleParser(this);
  }

  /**
   * Specifies that this box supports decimal values.
   *
   * @return True since double values have decimal separators.
   */
  @Override
  protected boolean hasDecimalSeparator() {
    return true;
  }

  /**
   * Determines if the provided value exceeds the given maximum value.
   *
   * @param maxValue The maximum allowable value.
   * @param value The value to check.
   * @return True if the value exceeds the maximum, false otherwise.
   */
  @Override
  protected boolean isExceedMaxValue(Double maxValue, Double value) {
    return value.compareTo(maxValue) > 0;
  }

  /**
   * Determines if the provided value is lower than the given minimum value.
   *
   * @param minValue The minimum allowable value.
   * @param value The value to check.
   * @return True if the value is lower than the minimum, false otherwise.
   */
  @Override
  protected boolean isLowerThanMinValue(Double minValue, Double value) {
    return value.compareTo(minValue) < 0;
  }

  /**
   * Returns the maximum representable value for a double.
   *
   * @return The maximum double value, {@link Double#MAX_VALUE}.
   */
  @Override
  protected Double defaultMaxValue() {
    return Double.MAX_VALUE;
  }

  /**
   * Returns the minimum representable value for a double.
   *
   * @return A value representing negative infinity, {@link Double#NEGATIVE_INFINITY}.
   */
  @Override
  protected Double defaultMinValue() {
    return Double.NEGATIVE_INFINITY;
  }
}
