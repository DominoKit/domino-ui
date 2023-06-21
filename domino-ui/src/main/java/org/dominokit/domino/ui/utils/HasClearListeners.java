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
 * Components that has a value that can be changed and need to define listeners for the changes
 * should implement this interface
 *
 * @param <T> the type of the class implementing this interface
 * @param <V> the type of the component value
 * @author vegegoku
 * @version $Id: $Id
 */
public interface HasClearListeners<T, V> {

  /**
   * addClearListener.
   *
   * @param clearListener {@link org.dominokit.domino.ui.utils.HasClearListeners.ClearListener}
   * @return same implementing class instance
   */
  default T addClearListener(ClearListener<? super V> clearListener) {
    getClearListeners().add(clearListener);
    return (T) this;
  }

  /**
   * removeClearListener.
   *
   * @param clearListener {@link org.dominokit.domino.ui.utils.HasClearListeners.ClearListener}
   * @return same implementing class instance
   */
  default T removeClearListener(ClearListener<? super V> clearListener) {
    getClearListeners().remove(clearListener);
    return (T) this;
  }

  /**
   * Checks if a component has the specified ChangeHandler
   *
   * @param clearListener {@link org.dominokit.domino.ui.utils.HasClearListeners.ClearListener}
   * @return same implementing class instance
   */
  default boolean hasClearListener(ClearListener<? super V> clearListener) {
    return getClearListeners().contains(clearListener);
  }

  /**
   * getClearListeners.
   *
   * @return a {@link java.util.Set} object
   */
  Set<ClearListener<? super V>> getClearListeners();

  /**
   * isClearListenersPaused.
   *
   * @return a boolean
   */
  boolean isClearListenersPaused();

  /**
   * Disable change listeners
   *
   * @return same component instance
   */
  T pauseClearListeners();

  /**
   * Enables change listeners
   *
   * @return same component instance
   */
  T resumeClearListeners();

  /**
   * Disable/Enable change listeners
   *
   * @param toggle boolean, true to pause the change listeners, false to enable them
   * @return same component instance
   */
  T togglePauseClearListeners(boolean toggle);

  /**
   * Execute a handler while toggling the change handlers state, revert the state back to its
   * original value after executing the handler
   *
   * @param toggle boolean, true to pause the change listeners, false to enable them
   * @return same component instance
   * @param handler a {@link org.dominokit.domino.ui.utils.Handler} object
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
   * Execute a handler while toggling the change handlers state, revert the state back to its
   * original value after the AsyncHandler.onComplete is called
   *
   * @param toggle boolean, true to pause the change listeners, false to enable them
   * @return same component instance
   * @param handler a {@link org.dominokit.domino.ui.utils.AsyncHandler} object
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
   * triggerClearListeners.
   *
   * @param oldValue a V object
   * @return a T object
   */
  T triggerClearListeners(V oldValue);

  /** @param <V> the type of the component value */
  @FunctionalInterface
  interface ClearListener<V> {
    /**
     * Will be called whenever the component value is changed
     *
     * @param oldValue V the new value of the component
     */
    void onValueCleared(V oldValue);
  }
}
