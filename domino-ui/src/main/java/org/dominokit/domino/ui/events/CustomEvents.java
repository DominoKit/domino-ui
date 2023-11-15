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
package org.dominokit.domino.ui.events;

import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.CustomEvent;
import elemental2.dom.CustomEventInit;
import jsinterop.base.Js;

/**
 * The {@code CustomEvents} class provides utility methods for creating custom events.
 *
 * <p>Custom events allow you to define and dispatch your own events with custom data and
 * properties.
 *
 * <p><strong>Usage Examples:</strong>
 *
 * <pre>
 * // Create a custom event without details
 * CustomEvent&lt;Void&gt; eventWithoutDetails = CustomEvents.create("customEventWithoutDetails");
 *
 * // Create a custom event with details
 * String eventData = "Custom event data";
 * CustomEvent&lt;String&gt; eventWithDetails = CustomEvents.create("customEventWithDetails", eventData);
 * </pre>
 *
 * <p>The {@code CustomEvents} class includes methods for creating custom events with and without
 * details.
 */
public class CustomEvents {

  /**
   * Creates a custom event without details.
   *
   * @param name The name of the custom event.
   * @param <T> The type of event details (use {@code Void} if no details are needed).
   * @return A custom event instance without details.
   */
  public static <T> CustomEvent<T> create(String name) {
    return new CustomEvent<>(name);
  }

  /**
   * Creates a custom event with details.
   *
   * @param name The name of the custom event.
   * @param details The event details.
   * @param <T> The type of event details.
   * @return A custom event instance with details.
   */
  public static <T> CustomEvent<T> create(String name, T details) {
    CustomEventInit<T> initOptions = Js.uncheckedCast(CustomEventInit.create());
    initOptions.setDetail(details);
    return new CustomEvent<>(name, initOptions);
  }
}
