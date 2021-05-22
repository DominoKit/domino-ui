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

import org.dominokit.domino.ui.utils.ElementUtil;
import org.gwtproject.i18n.client.NumberFormat;

import static java.util.Objects.nonNull;

/** A component that has an input to take/provide Double value */
public class DoubleBox extends NumberBox<DoubleBox, Double> {

  /** @return a new instance without a label */
  public static DoubleBox create() {
    return new DoubleBox();
  }

  /** @return a new instance with a label */
  public static DoubleBox create(String label) {
    return new DoubleBox(label);
  }

  /** Creates a DoubleBox with empty label */
  public DoubleBox() {
    this("");
  }

  /**
   * Creates a DoubleBox with a label
   *
   * @param label String
   */
  public DoubleBox(String label) {
    super(label);
    ElementUtil.decimalOnly(this);
  }

  /** {@inheritDoc} */
  @Override
  protected void clearValue() {
    value(0.0);
  }

  /** {@inheritDoc} */
  @Override
  protected Double parseValue(String value) {
    return parseDouble(value);
  }

  /** {@inheritDoc} */
  @Override
  protected boolean isExceedMaxValue(Double maxValue, Double value) {
    return value.compareTo(maxValue) > 0;
  }

  /** {@inheritDoc} */
  @Override
  protected boolean isLowerThanMinValue(Double minValue, Double value) {
    return value.compareTo(minValue) < 0;
  }

  /** {@inheritDoc} */
  @Override
  protected Double defaultMaxValue() {
    return Double.MAX_VALUE;
  }

  /** {@inheritDoc} */
  @Override
  protected Double defaultMinValue() {
    return Double.NEGATIVE_INFINITY;
  }
}
