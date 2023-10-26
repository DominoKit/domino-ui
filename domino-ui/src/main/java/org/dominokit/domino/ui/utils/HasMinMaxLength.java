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
 * The {@code HasMinMaxLength} interface defines methods for managing minimum and maximum length
 * constraints on a component's input or content.
 *
 * @param <T> The type of the component that can have minimum and maximum length constraints.
 */
public interface HasMinMaxLength<T> {

  /** The name of the attribute for specifying maximum length. */
  String MAX_LENGTH = "maxlength";

  /** The name of the attribute for specifying minimum length. */
  String MIN_LENGTH = "minlength";

  /**
   * Gets the maximum length constraint for the component's input or content.
   *
   * @return The maximum length constraint.
   */
  int getMaxLength();

  /**
   * Sets the maximum length constraint for the component's input or content.
   *
   * @param maxLength The maximum length constraint to set.
   * @return The component with the maximum length constraint set.
   */
  T setMaxLength(int maxLength);

  /**
   * Gets the minimum length constraint for the component's input or content.
   *
   * @return The minimum length constraint.
   */
  int getMinLength();

  /**
   * Sets the minimum length constraint for the component's input or content.
   *
   * @param minLength The minimum length constraint to set.
   * @return The component with the minimum length constraint set.
   */
  T setMinLength(int minLength);

  /**
   * Gets the length of the component's input or content.
   *
   * @return The length of the component's input or content.
   */
  int getLength();
}
