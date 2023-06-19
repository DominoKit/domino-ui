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

public class KeyboardEvents<T extends Node>
    implements HasDefaultEventOptions<KeyboardEventOptions> {

  public static final String KEYDOWN = "keydown";
  public static final String KEYUP = "keyup";
  public static final String KEYPRESS = "keypress";

  private KeyboardEventOptions defaultOptions = KeyboardEventOptions.create();
  private final T element;

  private KeyboardKeyListener keyUpListener = new KeyboardKeyListener(this);
  private KeyboardKeyListener keyDownListener = new KeyboardKeyListener(this);
  private KeyboardKeyListener keyPressListener = new KeyboardKeyListener(this);

  private LazyInitializer keyUpListenerInitializer;
  private LazyInitializer keyDownListenerInitializer;
  private LazyInitializer keyPressListenerInitializer;

  public KeyboardEvents(T element) {
    this.element = element;
    keyUpListenerInitializer =
        new LazyInitializer(() -> element.addEventListener(KEYUP, keyUpListener));
    keyDownListenerInitializer =
        new LazyInitializer(() -> element.addEventListener(KEYDOWN, keyDownListener));
    keyPressListenerInitializer =
        new LazyInitializer(() -> element.addEventListener(KEYPRESS, keyPressListener));
  }

  public KeyboardEvents<T> listenOnKeyDown(KeyEventsConsumer onKeyDown) {
    keyDownListenerInitializer.apply();
    onKeyDown.accept(keyDownListener);
    return this;
  }

  public KeyboardEvents<T> stopListenOnKeyDown() {
    element.removeEventListener(KEYDOWN, keyDownListener);
    keyDownListenerInitializer.reset();
    return this;
  }

  public KeyboardEvents<T> listenOnKeyUp(KeyEventsConsumer onKeyUp) {
    keyUpListenerInitializer.apply();
    onKeyUp.accept(keyUpListener);
    return this;
  }

  public KeyboardEvents<T> stopListenOnKeyUp() {
    element.removeEventListener(KEYUP, keyUpListener);
    keyDownListenerInitializer.reset();
    return this;
  }

  public KeyboardEvents<T> listenOnKeyPress(KeyEventsConsumer onKeyPress) {
    keyPressListenerInitializer.apply();
    onKeyPress.accept(keyPressListener);
    return this;
  }

  public KeyboardEvents<T> stopListenOnKeyPress() {
    element.removeEventListener(KEYPRESS, keyPressListener);
    keyPressListenerInitializer.reset();
    return this;
  }

  @Override
  public KeyboardEventOptions getOptions() {
    return defaultOptions;
  }

  /**
   * Sets the default {@link KeyboardEventOptions}
   *
   * @param defaultOptions the default {@link KeyboardEventOptions}
   * @return same instance
   */
  public KeyboardEvents<T> setDefaultOptions(KeyboardEventOptions defaultOptions) {
    this.defaultOptions = defaultOptions;
    return this;
  }
}
