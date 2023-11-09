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

import org.dominokit.domino.ui.style.Color;

/**
 * The {@code HasBackground} functional interface defines a method for setting the background color
 * for an object of type {@code T}.
 *
 * @param <T> The type of object on which the background color can be set.
 */
@FunctionalInterface
public interface HasBackground<T> {

  /**
   * Sets the background color for the object of type {@code T}.
   *
   * @param background The {@link Color} representing the background color to be set.
   * @return The modified object of type {@code T} with the background color set.
   */
  T setBackground(Color background);
}
