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

import elemental2.core.JsNumber;
import java.util.function.Function;

/** A specialized {@link NumberBox} for handling floating-point values. */
public class FloatBox extends NumberBox<FloatBox, Float> {

  /**
   * Creates a new instance of FloatBox with a default value set to 0.0F.
   *
   * @return A new instance of FloatBox.
   */
  public static FloatBox create() {
    return new FloatBox();
  }

  /**
   * Creates a new instance of FloatBox with the given label.
   *
   * @param label The label to be used for the FloatBox.
   * @return A new instance of FloatBox.
   */
  public static FloatBox create(String label) {
    return new FloatBox(label);
  }

  /** Default constructor. Sets the default value of the box to 0.0F. */
  public FloatBox() {
    setDefaultValue(0.0F);
  }

  /**
   * Constructor with a label.
   *
   * @param label The label to be used for the FloatBox.
   */
  public FloatBox(String label) {
    this();
    setLabel(label);
  }

  /**
   * Provides the default parser for parsing string values to floats.
   *
   * @return The function to parse string values into float values.
   */
  @Override
  protected Function<String, Float> defaultValueParser() {
    return getConfig().getNumberParsers().floatParser(this);
  }

  /**
   * Indicates that this FloatBox supports decimal values.
   *
   * @return True, as float values have a decimal separator.
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
  protected boolean isExceedMaxValue(Float maxValue, Float value) {
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
  protected boolean isLowerThanMinValue(Float minValue, Float value) {
    return value < minValue;
  }

  /**
   * Returns the maximum representable value for a float, which is positive infinity.
   *
   * @return The maximum float value, positive infinity.
   */
  @Override
  protected Float defaultMaxValue() {
    return (float) JsNumber.POSITIVE_INFINITY;
  }

  /**
   * Returns the minimum representable value for a float, which is negative infinity.
   *
   * @return The minimum float value, negative infinity.
   */
  @Override
  protected Float defaultMinValue() {
    return (float) JsNumber.NEGATIVE_INFINITY;
  }
}
