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

import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.Node;
import org.dominokit.domino.ui.IsElement;

/**
 * The {@code HasChildren} interface defines methods for adding child nodes or elements to an
 * object.
 *
 * @param <T> The type of object implementing this interface.
 */
public interface HasChildren<T> {

  /**
   * Appends a child {@link Node} to the object.
   *
   * @param node The {@link Node} to be appended as a child.
   * @return The modified object of type {@code T} with the child {@link Node} appended.
   */
  T appendChild(Node node);

  /**
   * Appends a child {@link IsElement} to the object.
   *
   * @param isElement The {@link IsElement} to be appended as a child.
   * @return The modified object of type {@code T} with the child {@link IsElement} appended.
   */
  T appendChild(IsElement<?> isElement);
}
