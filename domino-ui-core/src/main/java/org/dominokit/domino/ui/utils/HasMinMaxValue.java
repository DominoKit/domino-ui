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

/**
 * The {@code HasMinMaxValue} interface defines methods for managing minimum and maximum value
 * constraints on a component.
 *
 * @param <T> The type of the component that can have minimum and maximum value constraints.
 * @param <V> The type of the value constraints.
 */
public interface HasMinMaxValue<T, V> {

  /** The name of the attribute for specifying the maximum value. */
  String MAX_VALUE = "max";

  /** The name of the attribute for specifying the minimum value. */
  String MIN_VALUE = "min";

  /**
   * Gets the maximum value constraint for the component.
   *
   * @return The maximum value constraint.
   */
  V getMaxValue();

  /**
   * Sets the maximum value constraint for the component.
   *
   * @param maxValue The maximum value constraint to set.
   * @return The component with the maximum value constraint set.
   */
  T setMaxValue(V maxValue);

  /**
   * Gets the minimum value constraint for the component.
   *
   * @return The minimum value constraint.
   */
  V getMinValue();

  /**
   * Sets the minimum value constraint for the component.
   *
   * @param minValue The minimum value constraint to set.
   * @return The component with the minimum value constraint set.
   */
  T setMinValue(V minValue);
}
