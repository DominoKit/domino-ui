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

import java.util.List;

/**
 * The {@code HasSelectionSupport} interface defines methods for managing selection support in a
 * component. It provides functionality to retrieve selected items, all rows, and check if the
 * component is selectable.
 *
 * @param <T> The type of items that can be selected.
 */
public interface HasSelectionSupport<T> {

  /**
   * Gets the list of selected items in the component.
   *
   * @return A list of selected items.
   */
  List<T> getSelectedItems();

  /**
   * Gets the list of all rows or items in the component.
   *
   * @return A list of all rows or items.
   */
  List<T> getRows();

  /**
   * Checks if the component allows item selection.
   *
   * @return {@code true} if the component is selectable, {@code false} otherwise.
   */
  boolean isSelectable();

  /** Selects all items in the component. Default implementation does nothing. */
  default void selectAll() {}

  /** Deselects all items in the component. Default implementation does nothing. */
  default void deselectAll() {}
}
