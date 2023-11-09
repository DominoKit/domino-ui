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
 * The {@code EventHandlerOptions} interface represents options that can be used when registering
 * event handlers. This interface serves as a marker interface for event handler options.
 *
 * <p><strong>Usage Example:</strong>
 *
 * <pre>
 * // Register an event listener with options
 * EventListener listener = event -> {
 *     // Handle the event
 * };
 *
 * EventHandlerOptions options = new MyEventHandlerOptions(); // Custom implementation of EventHandlerOptions
 * element.addEventListener(EventType.click.getName(), listener, options);
 * </pre>
 *
 * <p>Custom implementations of {@code EventHandlerOptions} can be created to provide additional
 * options for event handling.
 */
public interface EventHandlerOptions {
  // This interface serves as a marker interface for event handler options.
  // Custom implementations can be created to provide additional options for event handling.
}
