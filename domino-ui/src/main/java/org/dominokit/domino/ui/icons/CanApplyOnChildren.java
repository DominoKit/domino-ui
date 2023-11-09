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

package org.dominokit.domino.ui.icons;

import org.dominokit.domino.ui.utils.ElementHandler;

/**
 * The {@code CanApplyOnChildren} interface defines a contract for applying a handler to child
 * elements of a specific type.
 *
 * @param <T> The type of the concrete class that implements this interface.
 * @param <C> The type of child elements that the handler will be applied to.
 */
public interface CanApplyOnChildren<T, C> {

  /**
   * Iterates through the child elements and applies a handler to each of them.
   *
   * @param handler The handler to apply to each child element.
   * @return The instance of the concrete class with the handler applied to its children.
   */
  T forEachChild(ElementHandler<C> handler);
}
