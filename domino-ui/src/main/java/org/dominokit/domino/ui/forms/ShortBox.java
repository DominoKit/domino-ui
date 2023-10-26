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

/** A specialized {@link NumberBox} for handling short integer values. */
public class ShortBox extends NumberBox<ShortBox, Short> {

  /**
   * Creates a new instance of ShortBox with a default value set to 0.
   *
   * @return A new instance of ShortBox.
   */
  public static ShortBox create() {
    return new ShortBox();
  }

  /**
   * Creates a new instance of ShortBox with the given label.
   *
   * @param label The label to be used for the ShortBox.
   * @return A new instance of ShortBox.
   */
  public static ShortBox create(String label) {
    return new ShortBox(label);
  }

  /** Default constructor. Sets the default value of the box to 0. */
  public ShortBox() {
    setDefaultValue((short) 0);
  }

  /**
   * Constructor with a label.
   *
   * @param label The label to be used for the ShortBox.
   */
  public ShortBox(String label) {
    this();
    setLabel(label);
  }

  /**
   * Provides the default parser for parsing string values to shorts.
   *
   * @return The function to parse string values into short values.
   */
  @Override
  protected Function<String, Short> defaultValueParser() {
    return getConfig().getNumberParsers().shortParser(this);
  }

  /**
   * Returns the maximum representable value for a short.
   *
   * @return The maximum short value, {@link Short#MAX_VALUE}.
   */
  @Override
  protected Short defaultMaxValue() {
    return Short.MAX_VALUE;
  }

  /**
   * Returns the minimum representable value for a short.
   *
   * @return The minimum short value, {@link Short#MIN_VALUE}.
   */
  @Override
  protected Short defaultMinValue() {
    return Short.MIN_VALUE;
  }

  /**
   * Determines if the provided value exceeds the given maximum value.
   *
   * @param maxValue The maximum allowable value.
   * @param value The value to check.
   * @return True if the value exceeds the maximum, false otherwise.
   */
  @Override
  protected boolean isExceedMaxValue(Short maxValue, Short value) {
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
  protected boolean isLowerThanMinValue(Short minValue, Short value) {
    return value < minValue;
  }
}
