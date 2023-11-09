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

/**
 * The {@code AcceptKeyEvents} interface defines methods for handling keyboard events.
 * Implementations of this interface can register event listeners for specific keyboard keys and
 * combinations.
 *
 * <p><strong>Usage Example:</strong>
 *
 * <pre>{@code
 * AcceptKeyEvents acceptKeyEvents = new SomeAcceptKeyEventsImplementation();
 * acceptKeyEvents.onEnter(event -> {
 *     // Handle Enter key press event
 * });
 * acceptKeyEvents.onBackspace(event -> {
 *     // Handle Backspace key press event
 * });
 * }</pre>
 */
public interface AcceptKeyEvents {

  /**
   * Registers an event listener to be called when the Backspace key is pressed.
   *
   * @param backspaceHandler The {@link elemental2.dom.EventListener} to call when the event occurs.
   * @return The same instance of {@code AcceptKeyEvents}.
   */
  AcceptKeyEvents onBackspace(EventListener backspaceHandler);

  /**
   * Registers an event listener to be called when the Backspace key is pressed with options.
   *
   * @param options The {@link org.dominokit.domino.ui.keyboard.KeyboardEventOptions}.
   * @param backspaceHandler The {@link elemental2.dom.EventListener} to call when the event occurs.
   * @return The same instance of {@code AcceptKeyEvents}.
   */
  AcceptKeyEvents onBackspace(KeyboardEventOptions options, EventListener backspaceHandler);

  /**
   * Registers an event listener to be called when the Escape key is pressed.
   *
   * @param escapeHandler The {@link elemental2.dom.EventListener} to call when the event occurs.
   * @return The same instance of {@code AcceptKeyEvents}.
   */
  AcceptKeyEvents onEscape(EventListener escapeHandler);

  /**
   * Registers an event listener to be called when the Escape key is pressed with options.
   *
   * @param options The {@link org.dominokit.domino.ui.keyboard.KeyboardEventOptions}.
   * @param escapeHandler The {@link elemental2.dom.EventListener} to call when the event occurs.
   * @return The same instance of {@code AcceptKeyEvents}.
   */
  AcceptKeyEvents onEscape(KeyboardEventOptions options, EventListener escapeHandler);

  /**
   * Registers an event listener to be called when the arrow up or arrow down keys are pressed.
   *
   * @param arrowDownHandler The {@link elemental2.dom.EventListener} to call when the event occurs.
   * @return The same instance of {@code AcceptKeyEvents}.
   */
  AcceptKeyEvents onArrowUpDown(EventListener arrowDownHandler);

  /**
   * Registers an event listener to be called when the arrow up or arrow down keys are pressed with
   * options.
   *
   * @param options The {@link org.dominokit.domino.ui.keyboard.KeyboardEventOptions}.
   * @param arrowDownHandler The {@link elemental2.dom.EventListener} to call when the event occurs.
   * @return The same instance of {@code AcceptKeyEvents}.
   */
  AcceptKeyEvents onArrowUpDown(KeyboardEventOptions options, EventListener arrowDownHandler);

  /**
   * Registers an event listener to be called when the arrow down key is pressed.
   *
   * @param arrowDownHandler The {@link elemental2.dom.EventListener} to call when the event occurs.
   * @return The same instance of {@code AcceptKeyEvents}.
   */
  AcceptKeyEvents onArrowDown(EventListener arrowDownHandler);

  /**
   * Registers an event listener to be called when the arrow down key is pressed with options.
   *
   * @param options The {@link org.dominokit.domino.ui.keyboard.KeyboardEventOptions}.
   * @param arrowDownHandler The {@link elemental2.dom.EventListener} to call when the event occurs.
   * @return The same instance of {@code AcceptKeyEvents}.
   */
  AcceptKeyEvents onArrowDown(KeyboardEventOptions options, EventListener arrowDownHandler);

  /**
   * Registers an event listener to be called when the arrow up key is pressed.
   *
   * @param arrowUpHandler The {@link elemental2.dom.EventListener} to call when the event occurs.
   * @return The same instance of {@code AcceptKeyEvents}.
   */
  AcceptKeyEvents onArrowUp(EventListener arrowUpHandler);

  /**
   * Registers an event listener to be called when the arrow up key is pressed with options.
   *
   * @param options The {@link org.dominokit.domino.ui.keyboard.KeyboardEventOptions}.
   * @param arrowUpHandler The {@link elemental2.dom.EventListener} to call when the event occurs.
   * @return The same instance of {@code AcceptKeyEvents}.
   */
  AcceptKeyEvents onArrowUp(KeyboardEventOptions options, EventListener arrowUpHandler);

  /**
   * Registers an event listener to be called when the arrow right key is pressed.
   *
   * @param arrowUpHandler The {@link elemental2.dom.EventListener} to call when the event occurs.
   * @return The same instance of {@code AcceptKeyEvents}.
   */
  AcceptKeyEvents onArrowRight(EventListener arrowUpHandler);

  /**
   * Registers an event listener to be called when the arrow right key is pressed with options.
   *
   * @param options The {@link org.dominokit.domino.ui.keyboard.KeyboardEventOptions}.
   * @param arrowUpHandler The {@link elemental2.dom.EventListener} to call when the event occurs.
   * @return The same instance of {@code AcceptKeyEvents}.
   */
  AcceptKeyEvents onArrowRight(KeyboardEventOptions options, EventListener arrowUpHandler);

  /**
   * Registers an event listener to be called when the arrow left key is pressed.
   *
   * @param arrowUpHandler The {@link elemental2.dom.EventListener} to call when the event occurs.
   * @return The same instance of {@code AcceptKeyEvents}.
   */
  AcceptKeyEvents onArrowLeft(EventListener arrowUpHandler);

  /**
   * Registers an event listener to be called when the arrow left key is pressed with options.
   *
   * @param options The {@link org.dominokit.domino.ui.keyboard.KeyboardEventOptions}.
   * @param arrowUpHandler The {@link elemental2.dom.EventListener} to call when the event occurs.
   * @return The same instance of {@code AcceptKeyEvents}.
   */
  AcceptKeyEvents onArrowLeft(KeyboardEventOptions options, EventListener arrowUpHandler);

  /**
   * Registers an event listener to be called when the Enter key is pressed.
   *
   * @param enterHandler The {@link elemental2.dom.EventListener} to call when the event occurs.
   * @return The same instance of {@code AcceptKeyEvents}.
   */
  AcceptKeyEvents onEnter(EventListener enterHandler);

  /**
   * Registers an event listener to be called when the Enter key is pressed with options.
   *
   * @param options The {@link org.dominokit.domino.ui.keyboard.KeyboardEventOptions}.
   * @param enterHandler The {@link elemental2.dom.EventListener} to call when the event occurs.
   * @return The same instance of {@code AcceptKeyEvents}.
   */
  AcceptKeyEvents onEnter(KeyboardEventOptions options, EventListener enterHandler);

  /**
   * Registers an event listener to be called when the Delete key is pressed.
   *
   * @param deleteHandler The {@link elemental2.dom.EventListener} to call when the event occurs.
   * @return The same instance of {@code AcceptKeyEvents}.
   */
  AcceptKeyEvents onDelete(EventListener deleteHandler);

  /**
   * Registers an event listener to be called when the cntrl + Delete key is pressed with options.
   *
   * @param options The {@link org.dominokit.domino.ui.keyboard.KeyboardEventOptions}.
   * @param deleteHandler The {@link elemental2.dom.EventListener} to call when the event occurs.
   * @return The same instance of {@code AcceptKeyEvents}.
   */
  AcceptKeyEvents onDelete(KeyboardEventOptions options, EventListener deleteHandler);

  /**
   * Registers an event listener to be called when the cntrl + Space key is pressed.
   *
   * @param spaceHandler The {@link elemental2.dom.EventListener} to call when the event occurs.
   * @return The same instance of {@code AcceptKeyEvents}.
   */
  AcceptKeyEvents onSpace(EventListener spaceHandler);

  /**
   * Registers an event listener to be called when the cntrl + Space key is pressed with options.
   *
   * @param options The {@link org.dominokit.domino.ui.keyboard.KeyboardEventOptions}.
   * @param spaceHandler The {@link elemental2.dom.EventListener} to call when the event occurs.
   * @return The same instance of {@code AcceptKeyEvents}.
   */
  AcceptKeyEvents onSpace(KeyboardEventOptions options, EventListener spaceHandler);

  /**
   * Registers an event listener to be called when the cntrl + Tab key is pressed.
   *
   * @param tabHandler The {@link elemental2.dom.EventListener} to call when the event occurs.
   * @return The same instance of {@code AcceptKeyEvents}.
   */
  AcceptKeyEvents onTab(EventListener tabHandler);

  /**
   * Registers an event listener to be called when the cntrl + Tab key is pressed with options.
   *
   * @param options The {@link org.dominokit.domino.ui.keyboard.KeyboardEventOptions}.
   * @param tabHandler The {@link elemental2.dom.EventListener} to call when the event occurs.
   * @return The same instance of {@code AcceptKeyEvents}.
   */
  AcceptKeyEvents onTab(KeyboardEventOptions options, EventListener tabHandler);

  /**
   * Registers an event listener be called when ctrl + a specific key is pressed with options.
   *
   * @param key A {@link java.lang.String} representing the key to listen for.
   * @param options The {@link org.dominokit.domino.ui.keyboard.KeyboardEventOptions}.
   * @param handler The {@link elemental2.dom.EventListener} to call when the event occurs.
   * @return The same instance of {@code AcceptKeyEvents}.
   */
  AcceptKeyEvents on(String key, KeyboardEventOptions options, EventListener handler);

  /**
   * Registers an event listener be called when ctrl + a specific key is pressed.
   *
   * @param key A {@link java.lang.String} representing the key to listen for.
   * @param handler The {@link elemental2.dom.EventListener} to call when the event occurs.
   * @return The same instance of {@code AcceptKeyEvents}.
   */
  AcceptKeyEvents on(String key, EventListener handler);

  /**
   * Registers an event listener be called when ctrl + any key is pressed with options.
   *
   * @param options The {@link org.dominokit.domino.ui.keyboard.KeyboardEventOptions}.
   * @param handler The {@link elemental2.dom.EventListener} to call when the event occurs.
   * @return The same instance of {@code AcceptKeyEvents}.
   */
  AcceptKeyEvents any(KeyboardEventOptions options, EventListener handler);

  /**
   * Registers an event listener be called when ctrl + any key is pressed.
   *
   * @param handler The {@link elemental2.dom.EventListener} to call when the event occurs.
   * @return The same instance of {@code AcceptKeyEvents}.
   */
  AcceptKeyEvents any(EventListener handler);

  /**
   * Clears all registered event listeners.
   *
   * @return The same instance of {@code AcceptKeyEvents}.
   */
  AcceptKeyEvents clearAll();

  /**
   * Clears the event listener for a specific key.
   *
   * @param key A {@link java.lang.String} representing the key to clear the event listener for.
   * @return The same instance of {@code AcceptKeyEvents}.
   */
  AcceptKeyEvents clear(String key);
}
