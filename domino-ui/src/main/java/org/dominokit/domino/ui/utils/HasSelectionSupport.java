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
 * Components that needs to support selection of items can implement this interface
 *
 * @param <T> the type of items being selected
 * @author vegegoku
 * @version $Id: $Id
 */
public interface HasSelectionSupport<T> {

  /** @return a List of all currently selected items */
  /**
   * getSelectedItems.
   *
   * @return a {@link java.util.List} object
   */
  List<T> getSelectedItems();

  /** @return a List of all selected and not selected items */
  /**
   * getRows.
   *
   * @return a {@link java.util.List} object
   */
  List<T> getRows();

  /** @return boolean, true if the component allows selection otherwise false. */
  /**
   * isSelectable.
   *
   * @return a boolean
   */
  boolean isSelectable();

  /** Select all not selected items */
  default void selectAll() {}

  /** Deselect all currently selected items */
  default void deselectAll() {}
}
