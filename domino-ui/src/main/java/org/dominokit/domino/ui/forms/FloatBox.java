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

/**
 * A component that has an input to take/provide float value
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class FloatBox extends NumberBox<FloatBox, Float> {

  /** @return a new instance without a label */
  /**
   * create.
   *
   * @return a {@link org.dominokit.domino.ui.forms.FloatBox} object
   */
  public static FloatBox create() {
    return new FloatBox();
  }

  /** @return a new instance with a label */
  /**
   * create.
   *
   * @param label a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.forms.FloatBox} object
   */
  public static FloatBox create(String label) {
    return new FloatBox(label);
  }

  /** Create instance without a label */
  public FloatBox() {
    setDefaultValue(0.0F);
  }

  /**
   * Create an instance with a label
   *
   * @param label String
   */
  public FloatBox(String label) {
    this();
    setLabel(label);
  }

  /** {@inheritDoc} */
  @Override
  protected Function<String, Float> defaultValueParser() {
    return getConfig().getNumberParsers().floatParser(this);
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
