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
 * The {@code HasSelectSupport} interface defines a method for retrieving the selected item in a
 * component.
 *
 * @param <T> The type of the selected item.
 */
public interface HasSelectSupport<T> {

  /**
   * Gets the selected item in the component.
   *
   * @return The selected item.
   */
  T getSelectedItem();
}
