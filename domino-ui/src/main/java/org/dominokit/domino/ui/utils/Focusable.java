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
 * An interface for elements that can be focused, unfocused, and checked for focus state.
 *
 * @param <T> The type of the element implementing this interface.
 */
public interface Focusable<T> {

  /**
   * Sets focus on the element.
   *
   * @return The instance of the element after focus has been set.
   */
  T focus();

  /**
   * Removes focus from the element.
   *
   * @return The instance of the element after focus has been removed.
   */
  T unfocus();

  /**
   * Checks if the element is currently focused.
   *
   * @return {@code true} if the element is focused, {@code false} otherwise.
   */
  boolean isFocused();
}
