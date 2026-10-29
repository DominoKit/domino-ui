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
 * The {@code HasRemoveHandler} interface defines methods for adding a remove handler to a
 * component.
 *
 * @param <T> The type of the component to which a remove handler can be added.
 */
@FunctionalInterface
public interface HasRemoveHandler<T> {

  /**
   * Adds a remove handler to the component.
   *
   * @param removeHandler The remove handler to be added.
   * @return The component with the added remove handler.
   */
  T addRemoveHandler(RemoveHandler<T> removeHandler);

  /**
   * A functional interface for handling remove events of a component.
   *
   * @param <T> The type of the component that can be removed.
   */
  @FunctionalInterface
  interface RemoveHandler<T> {

    /**
     * Called when the component is removed.
     *
     * @param component The component that is being removed.
     */
    void onRemove(T component);
  }
}
