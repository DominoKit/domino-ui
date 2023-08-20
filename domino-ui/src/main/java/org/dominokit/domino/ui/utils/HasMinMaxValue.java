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
package org.dominokit.domino.ui.utils;

/** HasMinMaxValue interface. */
public interface HasMinMaxValue<T, V> {
  /** Constant <code>MAX_VALUE="max"</code> */
  String MAX_VALUE = "max";
  /** Constant <code>MIN_VALUE="min"</code> */
  String MIN_VALUE = "min";

  /**
   * getMaxValue.
   *
   * @return a V object
   */
  V getMaxValue();

  /**
   * setMaxValue.
   *
   * @param maxValue a V object
   * @return a T object
   */
  T setMaxValue(V maxValue);

  /**
   * getMinValue.
   *
   * @return a V object
   */
  V getMinValue();

  /**
   * setMinValue.
   *
   * @param minLength a V object
   * @return a T object
   */
  T setMinValue(V minLength);
}
