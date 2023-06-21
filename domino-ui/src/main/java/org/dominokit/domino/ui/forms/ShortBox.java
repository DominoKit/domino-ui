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

/**
 * A component that has an input to take/provide Short value
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class ShortBox extends NumberBox<ShortBox, Short> {

  /** @return a new instance without a label */
  /**
   * create.
   *
   * @return a {@link org.dominokit.domino.ui.forms.ShortBox} object
   */
  public static ShortBox create() {
    return new ShortBox();
  }

  /**
   * create.
   *
   * @param label String
   * @return new instance with a label
   */
  public static ShortBox create(String label) {
    return new ShortBox(label);
  }

  /** Create instance without a label */
  public ShortBox() {
    setDefaultValue((short) 0);
  }

  /**
   * Create an instance with a label
   *
   * @param label String
   */
  public ShortBox(String label) {
    this();
    setLabel(label);
  }

  /** {@inheritDoc} */
  @Override
  protected Function<String, Short> defaultValueParser() {
    return getConfig().getNumberParsers().shortParser(this);
  }

  /** {@inheritDoc} */
  @Override
  protected Short defaultMaxValue() {
    return Short.MAX_VALUE;
  }

  /** {@inheritDoc} */
  @Override
  protected Short defaultMinValue() {
    return Short.MIN_VALUE;
  }

  /** {@inheritDoc} */
  @Override
  protected boolean isExceedMaxValue(Short maxValue, Short value) {
    return value > maxValue;
  }

  /** {@inheritDoc} */
  @Override
  protected boolean isLowerThanMinValue(Short minValue, Short value) {
    return value < minValue;
  }
}
