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

package org.dominokit.domino.ui.utils;

/**
 * An interface for elements that can be focused, unfocused, and checked for focus state.
 *
 * @param <T> The type of the element implementing this interface.
 */
public interface Focusable<T> {

  /**
   * Determines if autofocus is enabled for the element.
   *
   * @return {@code true} if the element has autofocus enabled; {@code false} otherwise.
   */
  public default boolean isAutoFocus() {
    return true;
  }

  public T setAutoFocus(boolean autoFocus);

  /**
   * Sets focus on the element.
   *
   * @return The instance of the element after focus has been set.
   */
  T focus();

  /**
   * Removes focus from the element.
   *
   * @return The instance of the element after focus has been removed.
   */
  T unfocus();

  /**
   * Checks if the element is currently focused.
   *
   * @return {@code true} if the element is focused, {@code false} otherwise.
   */
  boolean isFocused();

  /**
   * Pauses change listeners.
   *
   * @return The modified object of type {@code T} with change listeners paused.
   */
  default T pauseAutoFocus() {
    setAutoFocus(false);
    return (T) this;
  }

  /**
   * Resumes change listeners.
   *
   * @return The modified object of type {@code T} with change listeners resumed.
   */
  default T resumeAutoFocus() {
    setAutoFocus(true);
    return (T) this;
  }

  /**
   * Toggles the pause state of change listeners.
   *
   * @param toggle {@code true} to pause change listeners, {@code false} to resume.
   * @return The modified object of type {@code T} with the change listener pause state toggled.
   */
  default T togglePauseAutoFocus(boolean toggle) {
    setAutoFocus(toggle);
    return (T) this;
  }

  /**
   * Executes a handler with change listeners paused, then resumes change listeners.
   *
   * @param toggle {@code true} to pause change listeners, {@code false} to resume.
   * @param handler The {@link Handler} to be executed.
   * @return The modified object of type {@code T} with change listeners handled accordingly.
   */
  default T withPauseAutoFocusToggle(boolean toggle, Handler<T> handler) {
    boolean oldState = isAutoFocus();
    togglePauseAutoFocus(toggle);
    try {
      handler.apply((T) this);
    } finally {
      togglePauseAutoFocus(oldState);
    }
    return (T) this;
  }

  /**
   * Executes a handler with change listeners paused, then resumes change listeners.
   *
   * @param handler The {@link Handler} to be executed.
   * @return The modified object of type {@code T} with change listeners handled accordingly.
   */
  default T withPausedAutoFocus(Handler<T> handler) {
    boolean oldState = isAutoFocus();
    togglePauseAutoFocus(true);
    try {
      handler.apply((T) this);
    } finally {
      togglePauseAutoFocus(oldState);
    }
    return (T) this;
  }

  /**
   * Executes an asynchronous handler with change listeners paused, then resumes change listeners.
   *
   * @param toggle {@code true} to pause change listeners, {@code false} to resume.
   * @param handler The {@link AsyncHandler} to be executed.
   * @return The modified object of type {@code T} with change listeners handled asynchronously.
   */
  default T withPauseAutoFocusToggleAsync(boolean toggle, AsyncHandler<T> handler) {
    boolean oldState = isAutoFocus();
    togglePauseAutoFocus(toggle);
    try {
      handler.apply((T) this, () -> togglePauseAutoFocus(oldState));
    } catch (Exception e) {
      togglePauseAutoFocus(oldState);
      throw e;
    }
    return (T) this;
  }

  /**
   * Executes an asynchronous handler with change listeners paused, then resumes change listeners.
   *
   * @param handler The {@link AsyncHandler} to be executed.
   * @return The modified object of type {@code T} with change listeners handled asynchronously.
   */
  default T withPausedAutoFocusAsync(AsyncHandler<T> handler) {
    boolean oldState = isAutoFocus();
    togglePauseAutoFocus(true);
    try {
      handler.apply((T) this, () -> togglePauseAutoFocus(oldState));
    } catch (Exception e) {
      togglePauseAutoFocus(oldState);
      throw e;
    }
    return (T) this;
  }
}
