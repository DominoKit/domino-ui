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
import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

import elemental2.dom.Element;
import elemental2.dom.HTMLElement;

/**
 * The {@code AppendStrategy} functional interface defines a strategy for appending an {@link
 * HTMLElement} to an {@link Element}. Implementations of this interface provide different
 * strategies for appending the element, such as inserting it at the beginning or end of the target
 * element.
 */
@FunctionalInterface
public interface AppendStrategy {

  /**
   * Appends an {@link HTMLElement} to the specified target {@link Element} using a specific
   * strategy.
   *
   * @param target The target {@link Element} to which the {@link HTMLElement} will be appended.
   * @param menu The {@link HTMLElement} to append to the target element.
   */
  void onAppend(Element target, HTMLElement menu);

  /**
   * An {@code AppendStrategy} that inserts the {@link HTMLElement} at the beginning of the target
   * element.
   */
  AppendStrategy FIRST = (target, menu) -> elements.elementOf(target).insertFirst(menu);

  /**
   * An {@code AppendStrategy} that appends the {@link HTMLElement} at the end of the target
   * element.
   */
  AppendStrategy LAST = (target, menu) -> elements.elementOf(target).appendChild(menu);
}
