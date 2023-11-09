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
 * The {@code HasSelectionHandler} interface defines methods for adding and removing selection
 * handlers to a component that represents a selection action.
 *
 * @param <T> The type of the component to which a selection handler can be added or removed.
 * @param <V> The type of the value that is selected.
 */
public interface HasSelectionHandler<T, V> {

  /**
   * Adds a selection handler to the component.
   *
   * @param selectionHandler The selection handler to be added.
   * @return The component with the added selection handler.
   */
  T addSelectionHandler(SelectionHandler<V> selectionHandler);

  /**
   * Removes a selection handler from the component.
   *
   * @param selectionHandler The selection handler to be removed.
   * @return The component with the selection handler removed.
   */
  T removeSelectionHandler(SelectionHandler<V> selectionHandler);

  /**
   * A functional interface for handling selection events of a component.
   *
   * @param <V> The type of the value that is selected.
   */
  interface SelectionHandler<V> {

    /**
     * Called when a selection event occurs in the component.
     *
     * @param value The value that is selected.
     */
    void onSelection(V value);
  }
}
