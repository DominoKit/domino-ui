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
 * The {@code Checkable} interface represents an entity that can be checked or unchecked.
 *
 * @param <T> The type implementing the interface.
 */
public interface Checkable<T> {

  /**
   * Checks the entity.
   *
   * @return The updated entity.
   */
  T check();

  /**
   * Unchecks the entity.
   *
   * @return The updated entity.
   */
  T uncheck();

  /**
   * Checks or unchecks the entity based on the given {@code checkedState} parameter.
   *
   * @param silent A flag indicating whether to perform the action silently (without triggering
   *     events).
   * @return The updated entity.
   */
  T check(boolean silent);

  /**
   * Checks or unchecks the entity based on the given {@code checkedState} parameter.
   *
   * @param silent A flag indicating whether to perform the action silently (without triggering
   *     events).
   * @return The updated entity.
   */
  T uncheck(boolean silent);

  /**
   * Toggles the checked state of the entity.
   *
   * @param silent A flag indicating whether to perform the action silently (without triggering
   *     events).
   * @return The updated entity.
   */
  T toggleChecked(boolean silent);

  /**
   * Toggles the checked state of the entity based on the given {@code checkedState} parameter.
   *
   * @param checkedState The state to set (true for checked, false for unchecked).
   * @param silent A flag indicating whether to perform the action silently (without triggering
   *     events).
   * @return The updated entity.
   */
  T toggleChecked(boolean checkedState, boolean silent);

  /**
   * Toggles the checked state of the entity.
   *
   * @return The updated entity.
   */
  T toggleChecked();

  /**
   * Checks if the entity is in a checked state.
   *
   * @return {@code true} if the entity is checked, {@code false} otherwise.
   */
  boolean isChecked();
}
