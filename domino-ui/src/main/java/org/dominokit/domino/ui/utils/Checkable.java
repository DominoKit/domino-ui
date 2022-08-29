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
 * A Component that needs to have a toggle state (checked/unchecked) should implement this interface
 *
 * @param <T> The type of the component implementing this interface
 */
public interface Checkable<T> {
  /**
   * Change the component to its checked state
   *
   * @return same component instance
   */
  T check();

  /**
   * Change the component to its unchecked state
   *
   * @return same component instance
   */
  T uncheck();

  /**
   * Change the component to its checked state without triggering change handlers
   *
   * @param silent boolean, if true dont trigger change handlers
   * @return same component instance
   */
  T check(boolean silent);

  /**
   * Change the component to its unchecked state with optionally triggering change handlers
   *
   * @param silent boolean, if true dont trigger change handlers
   * @return same component instance
   */
  T uncheck(boolean silent);

  /**
   * Change the component to its unchecked/checked state with optionally triggering change handlers
   *
   * @param silent boolean, if true dont trigger change handlers
   * @return same component instance
   */
  T toggleChecked(boolean silent);

  /**
   * Change the component to its unchecked/checked state with optionally triggering change handlers
   *
   * @param silent boolean, if true dont trigger change handlers
   * @return same component instance
   */
  T toggleChecked(boolean checkedState, boolean silent);

  /**
   * Change the component to its unchecked/checked state
   *
   * @return same component instance
   */
  T toggleChecked();

  /** @return boolean, true if the component is checked, otherwise false */
  boolean isChecked();
}
