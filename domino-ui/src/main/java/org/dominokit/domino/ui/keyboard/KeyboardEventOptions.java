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

import org.dominokit.domino.ui.events.EventHandlerOptions;

/**
 * The {@code KeyboardEventOptions} class represents options for configuring keyboard event
 * handling. These options include settings for preventing default actions, stopping event
 * propagation, and checking modifier keys.
 *
 * <p>Use the {@link #create()} method to create a new instance of {@code KeyboardEventOptions} with
 * default settings. You can then use the setter methods to customize the options as needed.
 */
public class KeyboardEventOptions implements EventHandlerOptions {

  /**
   * Indicates whether the default action for the keyboard event should be prevented. Default is
   * {@code false}.
   */
  boolean preventDefault = false;

  /** Indicates whether event propagation should be stopped. Default is {@code false}. */
  boolean stopPropagation = false;

  /** Indicates whether the Ctrl key should be checked. Default is {@code false}. */
  boolean withCtrlKey;

  /** Indicates whether the Alt key should be checked. Default is {@code false}. */
  boolean withAltKey;

  /** Indicates whether the Shift key should be checked. Default is {@code false}. */
  boolean withShiftKey;

  /** Indicates whether the Meta key should be checked. Default is {@code false}. */
  boolean withMetaKey;

  boolean repeating;

  private Runnable removeHandler = () -> {};

  /** Indicates whether the event is a repeating event. Default is {@code false}. */

  /** Creates a new instance of {@code KeyboardEventOptions} with default settings. */
  public static KeyboardEventOptions create() {
    return new KeyboardEventOptions();
  }

  void setRemoveHandler(Runnable removeHandler) {
    this.removeHandler = removeHandler;
  }

  /**
   * Sets whether the default action for the keyboard event should be prevented.
   *
   * @param preventDefault {@code true} to prevent the default action, {@code false} otherwise.
   * @return This {@code KeyboardEventOptions} instance for method chaining.
   */
  public KeyboardEventOptions setPreventDefault(boolean preventDefault) {
    this.preventDefault = preventDefault;
    return this;
  }

  /**
   * Sets whether event propagation should be stopped.
   *
   * @param stopPropagation {@code true} to stop event propagation, {@code false} otherwise.
   * @return This {@code KeyboardEventOptions} instance for method chaining.
   */
  public KeyboardEventOptions setStopPropagation(boolean stopPropagation) {
    this.stopPropagation = stopPropagation;
    return this;
  }

  /**
   * Sets whether the Ctrl key should be checked.
   *
   * @param withCtrlKey {@code true} to check the Ctrl key, {@code false} otherwise.
   * @return This {@code KeyboardEventOptions} instance for method chaining.
   */
  public KeyboardEventOptions setWithCtrlKey(boolean withCtrlKey) {
    this.withCtrlKey = withCtrlKey;
    return this;
  }

  /**
   * Sets whether the Alt key should be checked.
   *
   * @param withAltKey {@code true} to check the Alt key, {@code false} otherwise.
   * @return This {@code KeyboardEventOptions} instance for method chaining.
   */
  public KeyboardEventOptions setWithAltKey(boolean withAltKey) {
    this.withAltKey = withAltKey;
    return this;
  }

  /**
   * Sets whether the Shift key should be checked.
   *
   * @param withShiftKey {@code true} to check the Shift key, {@code false} otherwise.
   * @return This {@code KeyboardEventOptions} instance for method chaining.
   */
  public KeyboardEventOptions setWithShiftKey(boolean withShiftKey) {
    this.withShiftKey = withShiftKey;
    return this;
  }

  /**
   * Sets whether the Meta key should be checked.
   *
   * @param withMetaKey {@code true} to check the Meta key, {@code false} otherwise.
   * @return This {@code KeyboardEventOptions} instance for method chaining.
   */
  public KeyboardEventOptions setWithMetaKey(boolean withMetaKey) {
    this.withMetaKey = withMetaKey;
    return this;
  }

  /**
   * Sets whether the event is a repeating event.
   *
   * @param repeating {@code true} if the event is repeating, {@code false} otherwise.
   * @return This {@code KeyboardEventOptions} instance for method chaining.
   */
  public KeyboardEventOptions setRepeating(boolean repeating) {
    this.repeating = repeating;
    return this;
  }

  public void removeHandler() {
    removeHandler.run();
  }
}
