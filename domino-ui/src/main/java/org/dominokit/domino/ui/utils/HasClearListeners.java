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
 * The {@code HasClearListeners} interface defines methods for managing clear listeners on an
 * object.
 *
 * @param <T> The type of object implementing this interface.
 * @param <V> The type of the value that can be cleared.
 */
public interface HasClearListeners<T, V> {

  /**
   * Adds a clear listener to the object.
   *
   * @param clearListener The clear listener to be added.
   * @return The modified object of type {@code T} with the clear listener added.
   */
  default T addClearListener(ClearListener<? super V> clearListener) {
    getClearListeners().add(clearListener);
    return (T) this;
  }

  /**
   * Removes a clear listener from the object.
   *
   * @param clearListener The clear listener to be removed.
   * @return The modified object of type {@code T} with the clear listener removed.
   */
  default T removeClearListener(ClearListener<? super V> clearListener) {
    getClearListeners().remove(clearListener);
    return (T) this;
  }

  /**
   * Checks if the object has a specific clear listener.
   *
   * @param clearListener The clear listener to check.
   * @return {@code true} if the clear listener is registered, {@code false} otherwise.
   */
  default boolean hasClearListener(ClearListener<? super V> clearListener) {
    return getClearListeners().contains(clearListener);
  }

  /**
   * Retrieves the set of clear listeners registered on the object.
   *
   * @return A set of clear listeners.
   */
  Set<ClearListener<? super V>> getClearListeners();

  /**
   * Checks if clear listeners are currently paused.
   *
   * @return {@code true} if clear listeners are paused, {@code false} otherwise.
   */
  boolean isClearListenersPaused();

  /**
   * Pauses clear listeners.
   *
   * @return The modified object of type {@code T} with clear listeners paused.
   */
  T pauseClearListeners();

  /**
   * Resumes clear listeners.
   *
   * @return The modified object of type {@code T} with clear listeners resumed.
   */
  T resumeClearListeners();

  /**
   * Toggles the pause state of clear listeners.
   *
   * @param toggle {@code true} to pause clear listeners, {@code false} to resume them.
   * @return The modified object of type {@code T} with clear listeners paused or resumed.
   */
  T togglePauseClearListeners(boolean toggle);

  /**
   * Executes a specified action while toggling the pause state of clear listeners.
   *
   * @param toggle {@code true} to pause clear listeners, {@code false} to resume them.
   * @param handler The handler to apply while clear listeners are toggled.
   * @return The modified object of type {@code T} with clear listeners paused or resumed.
   */
  default T withPauseClearListenersToggle(boolean toggle, Handler<T> handler) {
    boolean oldState = isClearListenersPaused();
    togglePauseClearListeners(toggle);
    try {
      handler.apply((T) this);
    } finally {
      togglePauseClearListeners(oldState);
    }
    return (T) this;
  }

  /**
   * Executes an asynchronous action while toggling the pause state of clear listeners.
   *
   * @param toggle {@code true} to pause clear listeners, {@code false} to resume them.
   * @param handler The asynchronous handler to apply while clear listeners are toggled.
   * @return The modified object of type {@code T} with clear listeners paused or resumed.
   */
  default T withPauseClearListenersToggle(boolean toggle, AsyncHandler<T> handler) {
    boolean oldState = isClearListenersPaused();
    togglePauseClearListeners(toggle);
    try {
      handler.apply((T) this, () -> togglePauseClearListeners(oldState));
    } catch (Exception e) {
      togglePauseClearListeners(oldState);
      throw e;
    }
    return (T) this;
  }

  /**
   * Triggers clear listeners with the old value that has been cleared.
   *
   * @param oldValue The old value that has been cleared.
   */
  T triggerClearListeners(V oldValue);

  /**
   * Functional interface for a clear listener.
   *
   * @param <V> The type of the value that can be cleared.
   */
  @FunctionalInterface
  interface ClearListener<V> {

    /**
     * Called when a value is cleared.
     *
     * @param oldValue The old value that has been cleared.
     */
    void onValueCleared(V oldValue);
  }
}
