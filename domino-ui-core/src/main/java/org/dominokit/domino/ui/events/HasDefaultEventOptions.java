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

/**
 * The {@code HasDefaultEventOptions} interface represents an element or component that provides
 * default event handler options.
 *
 * @param <T> The type of event handler options.
 *     <p><strong>Usage Example:</strong>
 *     <pre>
 * // Create a custom element with default event handler options
 * public class MyElement implements HasDefaultEventOptions<MyEventHandlerOptions> {
 *     // Implementation of other methods and properties
 *
 *     {@literal @}Override
 *     public MyEventHandlerOptions getOptions() {
 *         // Provide default event handler options for this element
 *         return new MyEventHandlerOptions();
 *     }
 * }
 *
 * // Usage of the custom element
 * MyElement myElement = new MyElement();
 * EventListener listener = event -> {
 *     // Handle the event
 * };
 * myElement.addEventListener(EventType.click.getName(), listener, myElement.getOptions());
 * </pre>
 *     <p>Implementing classes should provide default event handler options by overriding the {@code
 *     getOptions} method.
 * @see EventHandlerOptions
 */
public interface HasDefaultEventOptions<T extends EventHandlerOptions> {

  /**
   * Gets the default event handler options for this element or component.
   *
   * @return The default event handler options.
   */
  T getOptions();
}
