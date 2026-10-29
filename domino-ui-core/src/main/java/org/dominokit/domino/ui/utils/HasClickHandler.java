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
 * The {@code HasClickHandler} interface defines methods for adding click event handlers to an
 * element.
 *
 * @param <T> The type of the element that can have click event handlers.
 */
public interface HasClickHandler<T> {

  /**
   * Adds a click event handler to the element.
   *
   * @param clickHandler The click event handler to be added.
   * @return The element with the click event handler added.
   */
  T addClickHandler(ClickHandler clickHandler);

  /** Functional interface for handling click events. */
  @FunctionalInterface
  interface ClickHandler {

    /** Called when a click event occurs on the associated element. */
    void onClick();
  }
}
