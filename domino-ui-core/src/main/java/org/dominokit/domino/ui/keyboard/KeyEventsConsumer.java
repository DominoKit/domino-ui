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

/**
 * The {@code KeyEventsConsumer} functional interface represents a consumer of key events. It
 * accepts an {@link AcceptKeyEvents} instance, allowing for the registration of key event handlers.
 *
 * <p>This functional interface is typically used to add key event handlers to user interface
 * elements.
 *
 * @see AcceptKeyEvents
 */
@FunctionalInterface
public interface KeyEventsConsumer {

  /**
   * Accepts an {@link AcceptKeyEvents} instance, enabling the registration of key event handlers.
   *
   * @param keyEvents The {@link AcceptKeyEvents} instance used to register key event handlers.
   */
  void accept(AcceptKeyEvents keyEvents);
}
