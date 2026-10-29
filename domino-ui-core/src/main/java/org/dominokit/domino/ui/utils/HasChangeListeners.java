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

import java.util.Set;

/**
 * The {@code HasChangeListeners} interface defines methods for managing change listeners and
 * handling changes in a value of type {@code V}.
 *
 * @param <T> The type of object implementing this interface.
 * @param <V> The type of the value that can change and be observed.
 */
public interface HasChangeListeners<T, V> {

  /**
   * Adds a change listener to the set of listeners.
   *
   * @param changeListener The {@link ChangeListener} to be added.
   * @return The modified object of type {@code T} with the change listener added.
   */
  default T addChangeListener(ChangeListener<? super V> changeListener) {
    getChangeListeners().add(changeListener);
    return (T) this;
  }

  /**
   * Removes a change listener from the set of listeners.
   *
   * @param changeListener The {@link ChangeListener} to be removed.
   * @return The modified object of type {@code T} with the change listener removed.
   */
  default T removeChangeListener(ChangeListener<? super V> changeListener) {
    getChangeListeners().remove(changeListener);
    return (T) this;
  }

  /**
   * Checks if a change listener is present in the set of listeners.
   *
   * @param changeListener The {@link ChangeListener} to be checked.
   * @return {@code true} if the change listener is present, {@code false} otherwise.
   */
  default boolean hasChangeListener(ChangeListener<? super V> changeListener) {
    return getChangeListeners().contains(changeListener);
  }

  /**
   * Pauses change listeners.
   *
   * @return The modified object of type {@code T} with change listeners paused.
   */
  T pauseChangeListeners();

  /**
   * Resumes change listeners.
   *
   * @return The modified object of type {@code T} with change listeners resumed.
   */
  T resumeChangeListeners();

  /**
   * Toggles the pause state of change listeners.
   *
   * @param toggle {@code true} to pause change listeners, {@code false} to resume.
   * @return The modified object of type {@code T} with the change listener pause state toggled.
   */
  T togglePauseChangeListeners(boolean toggle);

  /**
   * Executes a handler with change listeners paused, then resumes change listeners.
   *
   * @param toggle {@code true} to pause change listeners, {@code false} to resume.
   * @param handler The {@link Handler} to be executed.
   * @return The modified object of type {@code T} with change listeners handled accordingly.
   */
  default T withPauseChangeListenersToggle(boolean toggle, Handler<T> handler) {
    boolean oldState = isChangeListenersPaused();
    togglePauseChangeListeners(toggle);
    try {
      handler.apply((T) this);
    } finally {
      togglePauseChangeListeners(oldState);
    }
    return (T) this;
  }

  /**
   * Executes a handler with change listeners paused, then resumes change listeners.
   *
   * @param handler The {@link Handler} to be executed.
   * @return The modified object of type {@code T} with change listeners handled accordingly.
   */
  default T withPausedChangeListeners(Handler<T> handler) {
    boolean oldState = isChangeListenersPaused();
    togglePauseChangeListeners(true);
    try {
      handler.apply((T) this);
    } finally {
      togglePauseChangeListeners(oldState);
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
  default T withPauseChangeListenersToggleAsync(boolean toggle, AsyncHandler<T> handler) {
    boolean oldState = isChangeListenersPaused();
    togglePauseChangeListeners(toggle);
    try {
      handler.apply((T) this, () -> togglePauseChangeListeners(oldState));
    } catch (Exception e) {
      togglePauseChangeListeners(oldState);
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
  default T withPausedChangeListenersAsync(AsyncHandler<T> handler) {
    boolean oldState = isChangeListenersPaused();
    togglePauseChangeListeners(true);
    try {
      handler.apply((T) this, () -> togglePauseChangeListeners(oldState));
    } catch (Exception e) {
      togglePauseChangeListeners(oldState);
      throw e;
    }
    return (T) this;
  }

  /**
   * Retrieves the set of change listeners.
   *
   * @return A {@link Set} of {@link ChangeListener} objects.
   */
  Set<ChangeListener<? super V>> getChangeListeners();

  /**
   * Checks if change listeners are currently paused.
   *
   * @return {@code true} if change listeners are paused, {@code false} otherwise.
   */
  boolean isChangeListenersPaused();

  /**
   * Triggers change listeners with the old and new values.
   *
   * @param oldValue The old value before the change.
   * @param newValue The new value after the change.
   * @return The modified object of type {@code T} with change listeners triggered.
   */
  T triggerChangeListeners(V oldValue, V newValue);

  /**
   * The functional interface representing a change listener.
   *
   * @param <V> The type of the value that can change and be observed.
   */
  @FunctionalInterface
  interface ChangeListener<V> {

    /**
     * Invoked when the observed value has changed.
     *
     * @param oldValue The old value before the change.
     * @param newValue The new value after the change.
     */
    void onValueChanged(V oldValue, V newValue);
  }
}
