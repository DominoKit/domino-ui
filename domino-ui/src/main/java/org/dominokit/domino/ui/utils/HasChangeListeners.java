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
 */
public interface HasChangeListeners<T, V> {

  /**
   * addChangeListener.
   *
   * @param changeListener {@link org.dominokit.domino.ui.utils.HasChangeListeners.ChangeListener}
   * @return same implementing class instance
   */
  default T addChangeListener(ChangeListener<? super V> changeListener) {
    getChangeListeners().add(changeListener);
    return (T) this;
  }

  /**
   * removeChangeListener.
   *
   * @param changeListener {@link org.dominokit.domino.ui.utils.HasChangeListeners.ChangeListener}
   * @return same implementing class instance
   */
  default T removeChangeListener(ChangeListener<? super V> changeListener) {
    getChangeListeners().remove(changeListener);
    return (T) this;
  }

  /**
   * Checks if a component has the specified ChangeHandler
   *
   * @param changeListener {@link org.dominokit.domino.ui.utils.HasChangeListeners.ChangeListener}
   * @return same implementing class instance
   */
  default boolean hasChangeListener(ChangeListener<? super V> changeListener) {
    return getChangeListeners().contains(changeListener);
  }

  /**
   * Disable change listeners
   *
   * @return same component instance
   */
  T pauseChangeListeners();

  /**
   * Enables change listeners
   *
   * @return same component instance
   */
  T resumeChangeListeners();

  /**
   * Disable/Enable change listeners
   *
   * @param toggle boolean, true to pause the change listeners, false to enable them
   * @return same component instance
   */
  T togglePauseChangeListeners(boolean toggle);

  /**
   * Execute a handler while toggling the change handlers state, revert the state back to its
   * original value after executing the handler
   *
   * @param toggle boolean, true to pause the change listeners, false to enable them
   * @return same component instance
   * @param handler a {@link org.dominokit.domino.ui.utils.Handler} object
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
   * Execute a handler while toggling the change handlers state, revert the state back to its
   * original value after executing the handler
   *
   * @return same component instance
   * @param handler a {@link org.dominokit.domino.ui.utils.Handler} object
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
   * Execute a handler while toggling the change handlers state, revert the state back to its
   * original value after the AsyncHandler.onComplete is called
   *
   * @param toggle boolean, true to pause the change listeners, false to enable them
   * @return same component instance
   * @param handler a {@link org.dominokit.domino.ui.utils.AsyncHandler} object
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
   * Execute a handler while toggling the change handlers state, revert the state back to its
   * original value after the AsyncHandler.onComplete is called
   *
   * @return same component instance
   * @param handler a {@link org.dominokit.domino.ui.utils.AsyncHandler} object
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
   * getChangeListeners.
   *
   * @return a {@link java.util.Set} object
   */
  Set<ChangeListener<? super V>> getChangeListeners();

  /**
   * isChangeListenersPaused.
   *
   * @return a boolean
   */
  boolean isChangeListenersPaused();

  /**
   * triggerChangeListeners.
   *
   * @param oldValue a V object
   * @param newValue a V object
   * @return a T object
   */
  T triggerChangeListeners(V oldValue, V newValue);

  /** @param <V> the type of the component value */
  @FunctionalInterface
  interface ChangeListener<V> {
    /**
     * Will be called whenever the component value is changed
     *
     * @param newValue V the new value of the component
     */
    void onValueChanged(V oldValue, V newValue);
  }
}
