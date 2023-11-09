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

import elemental2.dom.Node;
import org.dominokit.domino.ui.events.HasDefaultEventOptions;
import org.dominokit.domino.ui.utils.LazyInitializer;

/**
 * The {@code KeyboardEvents} class provides a fluent interface for configuring and managing
 * keyboard event listeners on a DOM element. It allows you to listen for key events such as
 * keydown, keyup, and keypress, and provides methods for adding and removing event listeners with
 * ease.
 *
 * <p>Keyboard event listeners can be customized using {@link KeyboardEventOptions} to specify
 * options like preventing default actions, stopping event propagation, and checking modifier keys.
 *
 * @param <T> The type of the DOM element on which the keyboard events will be listened to.
 */
public class KeyboardEvents<T extends Node>
    implements HasDefaultEventOptions<KeyboardEventOptions> {

  /** The constant representing the "keydown" event type. */
  public static final String KEYDOWN = "keydown";

  /** The constant representing the "keyup" event type. */
  public static final String KEYUP = "keyup";

  /** The constant representing the "keypress" event type. */
  public static final String KEYPRESS = "keypress";

  private KeyboardEventOptions defaultOptions = KeyboardEventOptions.create();
  private final T element;

  private KeyboardKeyListener keyUpListener = new KeyboardKeyListener(this);
  private KeyboardKeyListener keyDownListener = new KeyboardKeyListener(this);
  private KeyboardKeyListener keyPressListener = new KeyboardKeyListener(this);

  private LazyInitializer keyUpListenerInitializer;
  private LazyInitializer keyDownListenerInitializer;
  private LazyInitializer keyPressListenerInitializer;

  /**
   * Creates a new instance of {@code KeyboardEvents} for the specified DOM element.
   *
   * @param element The DOM element on which keyboard events will be listened to.
   */
  public KeyboardEvents(T element) {
    this.element = element;
    keyUpListenerInitializer =
        new LazyInitializer(() -> element.addEventListener(KEYUP, keyUpListener));
    keyDownListenerInitializer =
        new LazyInitializer(() -> element.addEventListener(KEYDOWN, keyDownListener));
    keyPressListenerInitializer =
        new LazyInitializer(() -> element.addEventListener(KEYPRESS, keyPressListener));
  }

  /**
   * Adds a keydown event listener to the element and associates it with the provided {@code
   * onKeyDown} consumer.
   *
   * @param onKeyDown The consumer that will receive keydown events.
   * @return This {@code KeyboardEvents} instance for method chaining.
   */
  public KeyboardEvents<T> listenOnKeyDown(KeyEventsConsumer onKeyDown) {
    keyDownListenerInitializer.apply();
    onKeyDown.accept(keyDownListener);
    return this;
  }

  /**
   * Removes the keydown event listener from the element.
   *
   * @return This {@code KeyboardEvents} instance for method chaining.
   */
  public KeyboardEvents<T> stopListenOnKeyDown() {
    element.removeEventListener(KEYDOWN, keyDownListener);
    keyDownListenerInitializer.reset();
    return this;
  }

  /**
   * Adds a keyup event listener to the element and associates it with the provided {@code onKeyUp}
   * consumer.
   *
   * @param onKeyUp The consumer that will receive keyup events.
   * @return This {@code KeyboardEvents} instance for method chaining.
   */
  public KeyboardEvents<T> listenOnKeyUp(KeyEventsConsumer onKeyUp) {
    keyUpListenerInitializer.apply();
    onKeyUp.accept(keyUpListener);
    return this;
  }

  /**
   * Removes the keyup event listener from the element.
   *
   * @return This {@code KeyboardEvents} instance for method chaining.
   */
  public KeyboardEvents<T> stopListenOnKeyUp() {
    element.removeEventListener(KEYUP, keyUpListener);
    keyDownListenerInitializer.reset();
    return this;
  }

  /**
   * Adds a keypress event listener to the element and associates it with the provided {@code
   * onKeyPress} consumer.
   *
   * @param onKeyPress The consumer that will receive keypress events.
   * @return This {@code KeyboardEvents} instance for method chaining.
   */
  public KeyboardEvents<T> listenOnKeyPress(KeyEventsConsumer onKeyPress) {
    keyPressListenerInitializer.apply();
    onKeyPress.accept(keyPressListener);
    return this;
  }

  /**
   * Removes the keypress event listener from the element.
   *
   * @return This {@code KeyboardEvents} instance for method chaining.
   */
  public KeyboardEvents<T> stopListenOnKeyPress() {
    element.removeEventListener(KEYPRESS, keyPressListener);
    keyPressListenerInitializer.reset();
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public KeyboardEventOptions getOptions() {
    return defaultOptions;
  }

  /**
   * Sets the default keyboard event options for this {@code KeyboardEvents} instance.
   *
   * @param defaultOptions The default keyboard event options to set.
   * @return This {@code KeyboardEvents} instance for method chaining.
   */
  public KeyboardEvents<T> setDefaultOptions(KeyboardEventOptions defaultOptions) {
    this.defaultOptions = defaultOptions;
    return this;
  }
}
