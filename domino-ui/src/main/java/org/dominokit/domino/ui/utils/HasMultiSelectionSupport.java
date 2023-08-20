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

/** This interface is used to implement multi-select capability to a component */
public interface HasMultiSelectionSupport<T extends HasMultiSelectionSupport<T>> {
  /** @return boolean, true if the component supports multi-selection, otherwise false */
  /**
   * isMultiSelect.
   *
   * @return a boolean
   */
  boolean isMultiSelect();

  /**
   * setMultiSelect.
   *
   * @param multiSelect boolean, true if the component should support multi-selection, otherwise
   *     false
   * @return a T object
   */
  T setMultiSelect(boolean multiSelect);
}
