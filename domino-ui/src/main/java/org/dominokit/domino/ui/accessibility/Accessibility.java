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
package org.dominokit.domino.ui.accessibility;

import elemental2.dom.EventListener;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/** Shared opt-in helpers for semantic and keyboard accessibility behavior. */
public final class Accessibility {

  private Accessibility() {}

  public static <E extends BaseDominoElement<?, ?>> E setRole(E element, String role) {
    if (role == null || role.isEmpty()) {
      element.removeAttribute("role");
    } else {
      element.setAttribute("role", role);
    }
    return element;
  }

  public static <E extends BaseDominoElement<?, ?>> E setState(
      E element, String state, boolean value) {
    element.setAttribute(state, String.valueOf(value));
    return element;
  }

  public static <E extends BaseDominoElement<?, ?>> E setReference(
      E element, String attribute, String id) {
    if (id == null || id.isEmpty()) {
      element.removeAttribute(attribute);
    } else {
      element.setAttribute(attribute, id);
    }
    return element;
  }

  public static <E extends BaseDominoElement<?, ?>> E activateOnEnterAndSpace(
      E element, EventListener listener) {
    element.onKeyDown(keyEvents -> keyEvents.onEnter(listener).onSpace(listener));
    return element;
  }
}
