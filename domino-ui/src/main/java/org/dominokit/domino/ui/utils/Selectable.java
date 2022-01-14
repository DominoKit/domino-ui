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
 * A component that can be selected/deselected should implement this interface
 *
 * @param <T> the type of the component implementing this interface
 */
public interface Selectable<T> {
  /**
   * make the component selected
   *
   * @return same implementing component instance
   */
  T select();

  /**
   * Deselect the component if it is already selected
   *
   * @return same implementing component instance
   */
  T deselect();

  /**
   * make the component selected without triggering the selection/change handlers
   *
   * @return same implementing component instance
   */
  T select(boolean silent);

  /**
   * deselect the component without triggering the selection/change handlers
   *
   * @return same implementing component instance
   */
  T deselect(boolean silent);

  /** @return boolean, true if the component is currently selected */
  boolean isSelected();

  /**
   * Adds a selection handler to this component, the handler will be called whenever the component
   * selected/deselected
   *
   * @param selectionHandler {@link SelectionHandler}
   */
  default void addSelectionHandler(SelectionHandler<T> selectionHandler) {}

  /**
   * A function to implement logic to be executed when a {@link Selectable} component selection
   * changed
   *
   * @param <T> The type of the component implementing {@link Selectable}
   */
  @FunctionalInterface
  interface SelectionHandler<T> {
    /** @param selectable {@link Selectable} component which has its selection changed */
    void onSelectionChanged(Selectable<T> selectable);
  }
}
