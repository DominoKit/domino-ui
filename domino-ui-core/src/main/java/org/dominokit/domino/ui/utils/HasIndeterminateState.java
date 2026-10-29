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
 * The {@code HasIndeterminateState} interface defines methods for managing the indeterminate state
 * of a component.
 *
 * @param <T> The type of the component that can have an indeterminate state.
 */
public interface HasIndeterminateState<T> {

  /**
   * Sets the component to an indeterminate state.
   *
   * @return The component in the indeterminate state.
   */
  T indeterminate();

  /**
   * Sets the component to a determinate state.
   *
   * @return The component in the determinate state.
   */
  T determinate();

  /**
   * Toggles the indeterminate state of the component.
   *
   * @param indeterminate {@code true} to set the component to an indeterminate state, {@code false}
   *     to set it to a determinate state.
   * @return The component with the updated indeterminate state.
   */
  T toggleIndeterminate(boolean indeterminate);

  /**
   * Toggles the indeterminate state of the component.
   *
   * @return The component with the updated indeterminate state.
   */
  T toggleIndeterminate();

  /**
   * Checks if the component is in a checked state.
   *
   * @return {@code true} if the component is checked, {@code false} otherwise.
   */
  boolean isChecked();
}
