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

import java.math.BigDecimal;
import java.util.function.Function;

/**
 * A specialized {@link NumberBox} for handling arbitrary-precision decimal values. This box allows
 * for input and representation of {@link BigDecimal} values.
 */
public class BigDecimalBox extends NumberBox<BigDecimalBox, BigDecimal> {

  /**
   * Creates a new instance of BigDecimalBox with a default value set to {@link BigDecimal#ZERO}.
   *
   * @return A new instance of BigDecimalBox.
   */
  public static BigDecimalBox create() {
    return new BigDecimalBox();
  }

  /**
   * Creates a new instance of BigDecimalBox with the given label.
   *
   * @param label The label to be used for the BigDecimalBox.
   * @return A new instance of BigDecimalBox.
   */
  public static BigDecimalBox create(String label) {
    return new BigDecimalBox(label);
  }

  /** Default constructor. Sets the default value of the box to {@link BigDecimal#ZERO}. */
  public BigDecimalBox() {
    setDefaultValue(BigDecimal.ZERO);
  }

  /**
   * Constructor with a label.
   *
   * @param label The label to be used for the BigDecimalBox.
   */
  public BigDecimalBox(String label) {
    this();
    setLabel(label);
  }

  /**
   * Provides the default parser for parsing string values to {@link BigDecimal}.
   *
   * @return The function to parse string values into BigDecimal values.
   */
  @Override
  protected Function<String, BigDecimal> defaultValueParser() {
    return getConfig().getNumberParsers().bigDecimalParser(this);
  }

  /**
   * Indicates that this BigDecimalBox supports decimal values.
   *
   * @return True, as {@link BigDecimal} values have a decimal separator.
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
  protected boolean isExceedMaxValue(BigDecimal maxValue, BigDecimal value) {
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
  protected boolean isLowerThanMinValue(BigDecimal minValue, BigDecimal value) {
    return value.compareTo(minValue) < 0;
  }

  /**
   * Returns the maximum representable value for a {@link BigDecimal}. Currently, this returns null,
   * indicating no specific limit.
   *
   * @return null, indicating no specific maximum value for {@link BigDecimal}.
   */
  @Override
  protected BigDecimal defaultMaxValue() {
    return null;
  }

  /**
   * Returns the minimum representable value for a {@link BigDecimal}. Currently, this returns null,
   * indicating no specific limit.
   *
   * @return null, indicating no specific minimum value for {@link BigDecimal}.
   */
  @Override
  protected BigDecimal defaultMinValue() {
    return null;
  }
}
