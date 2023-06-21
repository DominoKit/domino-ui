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
 * @author vegegoku
 * @version $Id: $Id
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
   * @param silent a boolean
   */
  T select(boolean silent);

  /**
   * deselect the component without triggering the selection/change handlers
   *
   * @return same implementing component instance
   * @param silent a boolean
   */
  T deselect(boolean silent);

  /** @return boolean, true if the component is currently selected */
  /**
   * isSelected.
   *
   * @return a boolean
   */
  boolean isSelected();

  /**
   * isSelectable.
   *
   * @return a boolean
   */
  boolean isSelectable();

  /**
   * setSelectable.
   *
   * @param selectable a boolean
   * @return a T object
   */
  T setSelectable(boolean selectable);

  /**
   * setSelected.
   *
   * @param selected a boolean
   * @return a T object
   */
  T setSelected(boolean selected);

  /**
   * setSelected.
   *
   * @param selected a boolean
   * @param silent a boolean
   * @return a T object
   */
  T setSelected(boolean selected, boolean silent);

  /**
   * toggleSelect.
   *
   * @return a T object
   */
  default T toggleSelect() {
    return setSelected(!isSelected());
  }

  /**
   * toggleSelect.
   *
   * @param silent a boolean
   * @return a T object
   */
  default T toggleSelect(boolean silent) {
    return setSelected(!isSelected(), silent);
  }
}
