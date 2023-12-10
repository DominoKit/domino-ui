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
package org.dominokit.domino.ui.forms;

import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.CanChange;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.Focusable;

/**
 * The {@code HasInputElement} interface provides methods for working with input elements within a
 * component.
 *
 * @param <T> The concrete type implementing this interface.
 * @param <E> The type of the input element, which extends {@link HTMLElement}.
 */
public interface HasInputElement<T, E extends HTMLElement> extends Focusable<T>, CanChange {

  /**
   * Gets the input element as a {@link DominoElement}.
   *
   * @return The {@link DominoElement} representing the input element.
   */
  DominoElement<E> getInputElement();

  /**
   * Gets the string value of the input element.
   *
   * @return The string value of the input element.
   */
  String getStringValue();
}
