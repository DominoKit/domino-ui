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
package org.dominokit.domino.ui.keyboard;

import elemental2.dom.EventListener;
import java.util.function.Supplier;

/**
 * The {@code KeyEventHandlerContext} class represents a context for key event handlers. It contains
 * an event listener handler and a supplier for {@link KeyboardEventOptions}.
 *
 * <p>Key event handlers can be associated with specific key events, and these handlers can have
 * custom event options defined by the {@link KeyboardEventOptions} class. The context stores both
 * the handler and its associated options.
 *
 * @see KeyboardEventOptions
 */
class KeyEventHandlerContext {
  /** The event listener handler associated with this context. */
  final EventListener handler;

  /** The supplier for {@link KeyboardEventOptions} associated with this context. */
  final Supplier<KeyboardEventOptions> options;

  /**
   * Constructs a new {@code KeyEventHandlerContext} with the specified event listener handler and
   * options supplier.
   *
   * @param handler The event listener handler.
   * @param options The supplier for {@link KeyboardEventOptions}.
   */
  public KeyEventHandlerContext(EventListener handler, Supplier<KeyboardEventOptions> options) {
    this.handler = handler;
    this.options = options;
  }
}
