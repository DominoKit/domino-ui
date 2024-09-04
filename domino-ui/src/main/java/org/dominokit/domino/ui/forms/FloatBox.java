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
import org.dominokit.domino.ui.utils.DominoUIConfig;

/** A component that has an input to take/provide float value */
@Deprecated
public class FloatBox extends NumberBox<FloatBox, Float> {

  /** @return a new instance without a label */
  public static FloatBox create() {
    return new FloatBox();
  }

  /** @return a new instance with a label */
  public static FloatBox create(String label) {
    return new FloatBox(label);
  }

  /** Create instance without a label */
  public FloatBox() {
    this("");
  }

  /**
   * Create an instance with a label
   *
   * @param label String
   */
  public FloatBox(String label) {
    super(label);
  }

  /** {@inheritDoc} */
  @Override
  protected void clearValue(boolean silent) {
    value(0.0F, silent);
  }

  /** {@inheritDoc} */
  @Override
  protected Function<String, Float> defaultValueParser() {
    return DominoUIConfig.INSTANCE.getNumberParsers().floatParser(this);
  }

  /** {@inheritDoc} */
  @Override
  protected boolean hasDecimalSeparator() {
    return true;
  }

  /** {@inheritDoc} */
  @Override
  protected boolean isExceedMaxValue(Float maxValue, Float value) {
    return value > maxValue;
  }

  /** {@inheritDoc} */
  @Override
  protected boolean isLowerThanMinValue(Float minValue, Float value) {
    return value < minValue;
  }

  /** {@inheritDoc} */
  @Override
  protected Float defaultMaxValue() {
    return (float) JsNumber.POSITIVE_INFINITY;
  }

  /** {@inheritDoc} */
  @Override
  protected Float defaultMinValue() {
    return (float) JsNumber.NEGATIVE_INFINITY;
  }
}
