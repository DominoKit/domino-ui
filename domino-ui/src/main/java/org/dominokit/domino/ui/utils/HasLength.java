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
 * The {@code HasLength} interface defines methods for setting and getting the maximum and minimum
 * lengths of a component.
 *
 * @param <T> The type of the component that can have length constraints.
 */
public interface HasLength<T> {

  /**
   * Sets the maximum length for the component's input value.
   *
   * @param maxLength The maximum length to set.
   * @return The component with the updated maximum length constraint.
   */
  T setMaxLength(int maxLength);

  /**
   * Gets the maximum length constraint for the component's input value.
   *
   * @return The maximum length constraint for the component.
   */
  int getMaxLength();

  /**
   * Sets the minimum length for the component's input value.
   *
   * @param minLength The minimum length to set.
   * @return The component with the updated minimum length constraint.
   */
  T setMinLength(int minLength);

  /**
   * Gets the minimum length constraint for the component's input value.
   *
   * @return The minimum length constraint for the component.
   */
  int getMinLength();
}
