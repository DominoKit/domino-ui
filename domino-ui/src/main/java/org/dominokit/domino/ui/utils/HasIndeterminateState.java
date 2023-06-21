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
 * HasIndeterminateState interface.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public interface HasIndeterminateState<T> {

  /**
   * Change the component to its indeterminate state
   *
   * @return same component instance
   */
  T indeterminate();

  /**
   * Change the component to its indeterminate state
   *
   * @return same component instance
   */
  T determinate();

  /**
   * toggleIndeterminate.
   *
   * @param indeterminate boolean, if true set the state to indeterminate otherwise determinate
   * @return same component instance
   */
  T toggleIndeterminate(boolean indeterminate);

  /**
   * Change the component to its unchecked/checked state
   *
   * @return same component instance
   */
  T toggleIndeterminate();

  /** @return boolean, true if the component is checked, otherwise false */
  /**
   * isChecked.
   *
   * @return a boolean
   */
  boolean isChecked();
}
