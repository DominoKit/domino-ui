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

import static java.util.Objects.nonNull;

import java.math.BigDecimal;
import org.dominokit.domino.ui.utils.ElementUtil;

/** A component that has an input to take/provide BigDecimal value */
public class BigDecimalBox extends NumberBox<BigDecimalBox, BigDecimal> {

  /** @return a new instance without a label */
  public static BigDecimalBox create() {
    return new BigDecimalBox();
  }

  /**
   * @param label String
   * @return new instance with a label
   */
  public static BigDecimalBox create(String label) {
    return new BigDecimalBox(label);
  }

  /** Create instance without a label */
  public BigDecimalBox() {
    this("");
  }

  /**
   * Create an instance with a label
   *
   * @param label String
   */
  public BigDecimalBox(String label) {
    super(label);
    ElementUtil.decimalOnly(this);
  }

  /** {@inheritDoc} clears the field and set the value to BigDecimal.ZERO */
  @Override
  protected void clearValue() {
    value(BigDecimal.ZERO);
  }

  /**
   * {@inheritDoc}
   *
   * @return
   */
  @Override
  protected BigDecimal parseValue(String value) {
    return new BigDecimal(parseDouble(value));
  }

  /** {@inheritDoc} */
  @Override
  protected boolean isExceedMaxValue(BigDecimal maxValue, BigDecimal value) {
    return value.compareTo(maxValue) > 0;
  }

  /** {@inheritDoc} */
  @Override
  protected boolean isLowerThanMinValue(BigDecimal minValue, BigDecimal value) {
    return value.compareTo(minValue) < 0;
  }

  /** {@inheritDoc} */
  @Override
  protected BigDecimal defaultMaxValue() {
    return null;
  }

  /** {@inheritDoc} */
  @Override
  protected BigDecimal defaultMinValue() {
    return null;
  }
}
