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

import elemental2.dom.KeyboardEvent;

/**
 * Wrapper around a DOM {@link KeyboardEvent} that normalizes its {@code code} and {@code key}
 * values to the Domino UI {@link KeyboardKeyCode} and {@link KeyboardKey} enums.
 *
 * <p>Provides convenience accessors for modifier flags and common properties, plus helpers to stop
 * or prevent the underlying event.
 */
public class KeyEvent {

  private final KeyboardEvent event;
  private final KeyboardKeyCode code;
  private final KeyboardKey key;

  /**
   * Factory method for creating a {@link KeyEvent} from a DOM event.
   *
   * @param event the raw {@link KeyboardEvent}
   * @return a new {@link KeyEvent} wrapping the supplied event
   */
  public static KeyEvent of(KeyboardEvent event) {
    return new KeyEvent(event);
  }

  /**
   * Creates a new instance wrapping the provided keyboard event.
   *
   * @param event the raw {@link KeyboardEvent}
   */
  public KeyEvent(KeyboardEvent event) {
    this.event = event;
    this.code = KeyboardKeyCodes.of(event.code);
    this.key = KeyboardKeys.of(event.key);
  }

  /**
   * Returns the wrapped DOM event.
   *
   * @return the original {@link KeyboardEvent}
   */
  public KeyboardEvent getEvent() {
    return event;
  }

  /**
   * Returns the normalized key code.
   *
   * @return a {@link KeyboardKeyCode} corresponding to {@code event.code}
   */
  public KeyboardKeyCode getCode() {
    return code;
  }

  /**
   * Retrieves the raw code value from the underlying DOM event.
   *
   * @return the value of the code property from the DOM KeyboardEvent
   */
  public String getNativeCode() {
    return event.code;
  }

  /**
   * Returns the normalized key value.
   *
   * @return a {@link KeyboardKey} corresponding to {@code event.key}
   */
  public KeyboardKey getKey() {
    return key;
  }

  /**
   * Retrieves the raw key value from the underlying DOM event.
   *
   * @return the value of the key property from the DOM KeyboardEvent
   */
  public String getNativeKey() {
    return event.key;
  }

  /**
   * Checks whether the event code matches the provided code.
   *
   * @param code the code to compare against
   * @return {@code true} when the codes match
   */
  public boolean is(KeyboardKeyCode code) {
    return this.code.equals(code);
  }

  /**
   * Checks whether the event key matches the provided key.
   *
   * @param key the key to compare against
   * @return {@code true} when the keys match
   */
  public boolean is(KeyboardKey key) {
    return this.key.equals(key);
  }

  /**
   * Stops propagation and prevents the default action.
   *
   * @return this {@link KeyEvent} for chaining
   */
  public KeyEvent stop() {
    event.stopPropagation();
    event.preventDefault();
    return this;
  }

  /**
   * Prevents the default action.
   *
   * @return this {@link KeyEvent} for chaining
   */
  public KeyEvent preventDefault() {
    event.preventDefault();
    return this;
  }

  /**
   * Stops event propagation.
   *
   * @return this {@link KeyEvent} for chaining
   */
  public KeyEvent stopPropagation() {
    event.stopPropagation();
    return this;
  }

  /**
   * Indicates whether the key is being repeated (auto-repeat).
   *
   * @return {@code true} for repeated key events
   */
  public boolean isRepeat() {
    return event.repeat;
  }

  /**
   * Indicates whether the Ctrl modifier is active.
   *
   * @return {@code true} if {@code ctrlKey} is pressed
   */
  public boolean isCtrl() {
    return event.ctrlKey;
  }

  /**
   * Indicates whether the Shift modifier is active.
   *
   * @return {@code true} if {@code shiftKey} is pressed
   */
  public boolean isShift() {
    return event.shiftKey;
  }

  /**
   * Indicates whether the Alt modifier is active.
   *
   * @return {@code true} if {@code altKey} is pressed
   */
  public boolean isAlt() {
    return event.altKey;
  }

  /**
   * Indicates whether the Meta modifier is active.
   *
   * @return {@code true} if {@code metaKey} is pressed
   */
  public boolean isMeta() {
    return event.metaKey;
  }

  /**
   * Indicates whether the key code represents a lock key.
   *
   * @return {@code true} if the code is one of the lock keys
   */
  public boolean isLockKey() {
    return code.isLockKey();
  }

  /**
   * Indicates whether the key code belongs to the numpad group.
   *
   * @return {@code true} if the code is a numpad key
   */
  public boolean isNumpadKey() {
    return code.isNumpadKey();
  }

  /**
   * Indicates whether the key code represents a function key.
   *
   * @return {@code true} if the code is a function key
   */
  public boolean isFunctionKey() {
    return code.isFunctionKey();
  }

  /**
   * Indicates whether any modifier key is active (Ctrl, Shift, Alt, or Meta).
   *
   * @return {@code true} when a modifier is pressed
   */
  public boolean isModifierKey() {
    return isCtrl() || isShift() || isAlt() || isMeta();
  }

  /**
   * Returns the character associated with the key event, if provided.
   *
   * @return the character value from {@code event.char_}
   */
  public String getChar() {
    return event.char_;
  }

  /**
   * Returns the event locale.
   *
   * @return the locale string from the underlying event
   */
  public String getLocale() {
    return event.locale;
  }

  /**
   * Returns the location of the key on the keyboard (standard DOM locations).
   *
   * @return the numeric location from the underlying event
   */
  public int getLocation() {
    return event.location;
  }
}
