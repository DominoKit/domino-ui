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
package org.dominokit.domino.ui.shaded.utils;

/**
 * Components that has a value that can be changed and need to define listeners for the changes
 * should implement this interface
 *
 * @param <T> the type of the class implementing this interface
 * @param <V> the type of the component value
 */
@Deprecated
public interface HasChangeHandlers<T, V> {

  /**
   * @param changeHandler {@link ChangeHandler}
   * @return same implementing class instance
   */
  T addChangeHandler(ChangeHandler<? super V> changeHandler);

  /**
   * @param changeHandler {@link ChangeHandler}
   * @return same implementing class instance
   */
  T removeChangeHandler(ChangeHandler<? super V> changeHandler);

  /**
   * Checks if a component has the specified ChangeHandler
   *
   * @param changeHandler {@link ChangeHandler}
   * @return same implementing class instance
   */
  boolean hasChangeHandler(ChangeHandler<? super V> changeHandler);

  /** @param <V> the type of the component value */
  @FunctionalInterface
  interface ChangeHandler<V> {
    /**
     * Will be called whenever the component value is changed
     *
     * @param value V the new value of the component
     */
    void onValueChanged(V value);
  }
}
