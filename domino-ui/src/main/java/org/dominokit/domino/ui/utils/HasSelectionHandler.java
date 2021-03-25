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
 * A component that has items to be selected/deselected should implement this interface
 *
 * @param <T> the type of the component implementing this interface
 * @param <V> the type of the Value being selected
 */
public interface HasSelectionHandler<T, V> {
  /**
   * Adds a Selection handler to the component
   *
   * @param selectionHandler {@link org.dominokit.domino.ui.utils.Selectable.SelectionHandler}
   * @return same implementing component instance
   */
  T addSelectionHandler(SelectionHandler<V> selectionHandler);

  T removeSelectionHandler(SelectionHandler<V> selectionHandler);

  /**
   * A function to implement logic to be executed when a component being selected
   *
   * @param <V> the type of the selected value
   */
  interface SelectionHandler<V> {
    /** @param value the selected value */
    void onSelection(V value);
  }
}
