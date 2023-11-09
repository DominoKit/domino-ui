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
 * The {@code HasCollapseListeners} interface defines methods for adding and managing collapse and
 * expand event listeners to an element.
 *
 * @param <T> The type of the element that can have collapse and expand event listeners.
 */
public interface HasCollapseListeners<T> {

  /**
   * Adds a collapse event listener to the element.
   *
   * @param collapseListener The collapse event listener to be added.
   * @return The element with the collapse event listener added.
   */
  default T addCollapseListener(CollapseListener<? super T> collapseListener) {
    getCollapseListeners().add(collapseListener);
    return (T) this;
  }

  /**
   * Adds an expand event listener to the element.
   *
   * @param expandListener The expand event listener to be added.
   * @return The element with the expand event listener added.
   */
  default T addExpandListener(ExpandListener<? super T> expandListener) {
    getExpandListeners().add(expandListener);
    return (T) this;
  }

  /**
   * Removes a collapse event listener from the element.
   *
   * @param collapseListener The collapse event listener to be removed.
   * @return The element with the collapse event listener removed.
   */
  default T removeCollapseListener(CollapseListener<? super T> collapseListener) {
    getCollapseListeners().remove(collapseListener);
    return (T) this;
  }

  /**
   * Removes an expand event listener from the element.
   *
   * @param expandListener The expand event listener to be removed.
   * @return The element with the expand event listener removed.
   */
  default T removeExpandListener(ExpandListener<? super T> expandListener) {
    getExpandListeners().remove(expandListener);
    return (T) this;
  }

  /**
   * Checks if the element has a collapse event listener.
   *
   * @param collapseListener The collapse event listener to be checked.
   * @return {@code true} if the element has the specified collapse event listener, {@code false}
   *     otherwise.
   */
  default boolean hasCollapseListener(CollapseListener<? super T> collapseListener) {
    return getCollapseListeners().contains(collapseListener);
  }

  /**
   * Checks if the element has an expand event listener.
   *
   * @param expandListener The expand event listener to be checked.
   * @return {@code true} if the element has the specified expand event listener, {@code false}
   *     otherwise.
   */
  default boolean hasExpandListener(ExpandListener<? super T> expandListener) {
    return getExpandListeners().contains(expandListener);
  }

  /**
   * Pauses all collapse event listeners associated with the element.
   *
   * @return The element with its collapse event listeners paused.
   */
  T pauseCollapseListeners();

  /**
   * Resumes all pause collapse event listeners associated with the element.
   *
   * @return The element with its collapse event listeners resumed.
   */
  T resumeCollapseListeners();

  /**
   * Toggles the pause state of collapse event listeners associated with the element.
   *
   * @param toggle {@code true} to pause the listeners, {@code false} to resume them.
   * @return The element with its collapse event listeners paused or resumed based on the toggle
   *     parameter.
   */
  T togglePauseCollapseListeners(boolean toggle);

  /**
   * Executes a given action while temporarily pausing the collapse event listeners, then resumes
   * their state.
   *
   * @param toggle {@code true} to pause the listeners during the action, {@code false} to resume
   *     them afterward.
   * @param handler The action to execute.
   * @return The element with its collapse event listeners paused during the action and resumed
   *     afterward.
   */
  default T withPauseCollapseListenersToggle(boolean toggle, Handler<T> handler) {
    boolean oldState = isCollapseListenersPaused();
    togglePauseCollapseListeners(toggle);
    try {
      handler.apply((T) this);
    } finally {
      togglePauseCollapseListeners(oldState);
    }
    return (T) this;
  }

  /**
   * Executes a given asynchronous action while temporarily pausing the collapse event listeners,
   * then resumes their state.
   *
   * @param toggle {@code true} to pause the listeners during the action, {@code false} to resume
   *     them afterward.
   * @param handler The asynchronous action to execute.
   * @return The element with its collapse event listeners paused during the action and resumed
   *     afterward.
   */
  default T withPauseCollapseListenersToggle(boolean toggle, AsyncHandler<T> handler) {
    boolean oldState = isCollapseListenersPaused();
    togglePauseCollapseListeners(toggle);
    try {
      handler.apply((T) this, () -> togglePauseCollapseListeners(oldState));
    } catch (Exception e) {
      togglePauseCollapseListeners(oldState);
      throw e;
    }
    return (T) this;
  }

  /**
   * Gets a set of all collapse event listeners associated with the element.
   *
   * @return A set of collapse event listeners.
   */
  Set<CollapseListener<? super T>> getCollapseListeners();

  /**
   * Gets a set of all expand event listeners associated with the element.
   *
   * @return A set of expand event listeners.
   */
  Set<ExpandListener<? super T>> getExpandListeners();

  /**
   * Checks if the collapse event listeners are currently paused.
   *
   * @return {@code true} if the collapse event listeners are paused, {@code false} otherwise.
   */
  boolean isCollapseListenersPaused();

  /**
   * Triggers all collapse event listeners associated with the element.
   *
   * @param component The component that triggered the listeners.
   * @return The element with its collapse event listeners triggered.
   */
  T triggerCollapseListeners(T component);

  /**
   * Triggers all expand event listeners associated with the element.
   *
   * @param component The component that triggered the listeners.
   * @return The element with its expand event listeners triggered.
   */
  T triggerExpandListeners(T component);

  /**
   * Functional interface for handling collapse events.
   *
   * @param <T> The type of the component that triggered the event.
   */
  @FunctionalInterface
  interface CollapseListener<T> {

    /**
     * Called when a collapse event occurs on the associated element.
     *
     * @param component The component that triggered the event.
     */
    void onCollapsed(T component);
  }

  /**
   * Functional interface for handling expand events.
   *
   * @param <T> The type of the component that triggered the event.
   */
  @FunctionalInterface
  interface ExpandListener<T> {

    /**
     * Called when an expand event occurs on the associated element.
     *
     * @param component The component that triggered the event.
     */
    void onExpanded(T component);
  }
}
