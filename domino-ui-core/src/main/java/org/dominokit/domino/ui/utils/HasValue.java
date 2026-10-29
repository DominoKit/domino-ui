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
 * The {@code HasValue} interface defines methods for setting and getting a value of a generic type
 * {@code V}.
 *
 * @param <T> The type of the object that implements this interface.
 * @param <V> The type of the value.
 */
public interface HasValue<T, V> {

  /**
   * Sets the value to the specified value.
   *
   * @param value The value to set.
   * @return The object after setting the value.
   */
  T withValue(V value);

  /**
   * Sets the value to the specified value and optionally does it silently (without triggering
   * events or listeners).
   *
   * @param value The value to set.
   * @param silent {@code true} to set the value silently (without triggering events or listeners),
   *     {@code false} otherwise.
   * @return The object after setting the value.
   */
  T withValue(V value, boolean silent);
}
