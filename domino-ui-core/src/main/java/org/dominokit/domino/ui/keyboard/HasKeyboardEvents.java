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
 * The {@code HasKeyboardEvents} interface provides methods for registering and handling keyboard
 * events. Implementing classes should use this interface to manage keyboard event listeners.
 *
 * @param <T> The type of the implementing class.
 */
public interface HasKeyboardEvents<T> {

  /**
   * Registers an event listener to be called when a key is pressed down.
   *
   * @param onKeyDown The {@link KeyEventsConsumer} to call when a key is pressed down.
   * @return The instance of type {@code T} for method chaining.
   */
  T onKeyDown(KeyEventsConsumer onKeyDown);

  /**
   * Stops listening for key press down events.
   *
   * @return The instance of type {@code T} for method chaining.
   */
  T stopOnKeyDown();

  /**
   * Registers an event listener to be called when a key is released.
   *
   * @param onKeyUp The {@link KeyEventsConsumer} to call when a key is released.
   * @return The instance of type {@code T} for method chaining.
   */
  T onKeyUp(KeyEventsConsumer onKeyUp);

  /**
   * Stops listening for key release events.
   *
   * @return The instance of type {@code T} for method chaining.
   */
  T stopOnKeyUp();

  /**
   * Registers an event listener to be called when an input is applied.
   *
   * @param onInput The {@link KeyEventsConsumer} to call when an input is applied.
   * @return The instance of type {@code T} for method chaining.
   */
  T onInput(KeyEventsConsumer onInput);

  /**
   * Stops listening for input events.
   *
   * @return The instance of type {@code T} for method chaining.
   */
  T stopOnInput();

  /**
   * Registers an event listener to be called when an beforeinput is applied.
   *
   * @param onBeforeInput The {@link KeyEventsConsumer} to call when an beforeinput is applied.
   * @return The instance of type {@code T} for method chaining.
   */
  T onBeforeInput(KeyEventsConsumer onBeforeInput);

  /**
   * Stops listening for beforeinput events.
   *
   * @return The instance of type {@code T} for method chaining.
   */
  T stopOnBeforeInput();

  /**
   * Gets the keyboard event options associated with this instance.
   *
   * @return The {@link KeyboardEventOptions} associated with this instance.
   */
  KeyboardEventOptions getKeyboardEventsOptions();

  /**
   * Sets the default keyboard event options for this instance.
   *
   * @param defaultOptions The {@link KeyboardEventOptions} to set as default.
   * @return The instance of type {@code T} for method chaining.
   */
  T setDefaultOptions(KeyboardEventOptions defaultOptions);
}
