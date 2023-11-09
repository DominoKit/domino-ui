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

/** A specialized {@link NumberBox} for handling long integer values. */
public class LongBox extends NumberBox<LongBox, Long> {

  /**
   * Creates a new instance of LongBox with default value set to 0.
   *
   * @return A new instance of LongBox.
   */
  public static LongBox create() {
    return new LongBox();
  }

  /**
   * Creates a new instance of LongBox with the given label.
   *
   * @param label The label to be used for the LongBox.
   * @return A new instance of LongBox.
   */
  public static LongBox create(String label) {
    return new LongBox(label);
  }

  /** Default constructor. Sets the default value of the box to 0. */
  public LongBox() {
    setDefaultValue(0L);
  }

  /**
   * Constructor with a label.
   *
   * @param label The label to be used for the LongBox.
   */
  public LongBox(String label) {
    this();
    setLabel(label);
  }

  /**
   * Provides the default parser for parsing string values to long integers.
   *
   * @return The function to parse string values into long values.
   */
  @Override
  protected Function<String, Long> defaultValueParser() {
    return getConfig().getNumberParsers().longParser(this);
  }

  /**
   * Returns the maximum representable value for a long integer.
   *
   * @return The maximum long value, {@link Long#MAX_VALUE}.
   */
  @Override
  protected Long defaultMaxValue() {
    return Long.MAX_VALUE;
  }

  /**
   * Returns the minimum representable value for a long integer.
   *
   * @return The minimum long value, {@link Long#MIN_VALUE}.
   */
  @Override
  protected Long defaultMinValue() {
    return Long.MIN_VALUE;
  }

  /**
   * Determines if the provided value exceeds the given maximum value.
   *
   * @param maxValue The maximum allowable value.
   * @param value The value to check.
   * @return True if the value exceeds the maximum, false otherwise.
   */
  @Override
  protected boolean isExceedMaxValue(Long maxValue, Long value) {
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
  protected boolean isLowerThanMinValue(Long minValue, Long value) {
    return value < minValue;
  }
}
