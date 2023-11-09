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

import elemental2.dom.AddEventListenerOptions;

/**
 * The {@code EventOptions} class represents options for configuring event listeners.
 *
 * <p>Event options include settings for capture, once, and passive behavior.
 *
 * <p><strong>Usage Example:</strong>
 *
 * <pre>
 * // Create event options with custom settings
 * EventOptions customOptions = EventOptions.of(true, false, true)
 *     .setCapture(true)
 *     .setOnce(false)
 *     .setPassive(true);
 *
 * // Attach an event listener with the custom event options
 * myElement.addEventListener(EventType.click.getName(), event -> {
 *     // Handle the click event
 * }, customOptions.get());
 * </pre>
 *
 * <p>The {@code EventOptions} class provides methods for configuring event options and obtaining
 * the underlying {@code AddEventListenerOptions} instance.
 *
 * @see EventType
 * @see EventHandlerOptions
 */
public class EventOptions {
  private final AddEventListenerOptions options;

  /** Constructs a new {@code EventOptions} instance with default settings. */
  public EventOptions() {
    this.options = AddEventListenerOptions.create();
  }

  /**
   * Constructs a new {@code EventOptions} instance with custom settings.
   *
   * @param capture Whether to use capture phase.
   * @param once Whether to trigger the event listener at most once.
   * @param passive Whether the event listener should not prevent the default action.
   */
  public EventOptions(boolean capture, boolean once, boolean passive) {
    this.options = AddEventListenerOptions.create();
    this.options.setCapture(capture);
    this.options.setOnce(once);
    this.options.setPassive(passive);
  }

  /**
   * Creates a new {@code EventOptions} instance with default settings.
   *
   * @return A new {@code EventOptions} instance with default settings.
   */
  public static EventOptions of() {
    return new EventOptions();
  }

  /**
   * Creates a new {@code EventOptions} instance with custom settings.
   *
   * @param capture Whether to use capture phase.
   * @param once Whether to trigger the event listener at most once.
   * @param passive Whether the event listener should not prevent the default action.
   * @return A new {@code EventOptions} instance with custom settings.
   */
  public static EventOptions of(boolean capture, boolean once, boolean passive) {
    return new EventOptions(capture, once, passive);
  }

  /**
   * Sets the passive behavior for the event listener.
   *
   * @param passive Whether the event listener should not prevent the default action.
   * @return The updated {@code EventOptions} instance.
   */
  public EventOptions setPassive(boolean passive) {
    options.setPassive(passive);
    return this;
  }

  /**
   * Sets the once behavior for the event listener.
   *
   * @param once Whether to trigger the event listener at most once.
   * @return The updated {@code EventOptions} instance.
   */
  public EventOptions setOnce(boolean once) {
    options.setOnce(once);
    return this;
  }

  /**
   * Sets the capture phase behavior for the event listener.
   *
   * @param capture Whether to use capture phase.
   * @return The updated {@code EventOptions} instance.
   */
  public EventOptions setCapture(boolean capture) {
    options.setCapture(capture);
    return this;
  }

  /**
   * Gets the underlying {@code AddEventListenerOptions} instance.
   *
   * @return The {@code AddEventListenerOptions} instance.
   */
  public AddEventListenerOptions get() {
    return options;
  }
}
