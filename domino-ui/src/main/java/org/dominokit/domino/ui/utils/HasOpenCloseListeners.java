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
 * The {@code HasOpenCloseListeners} interface defines methods for adding and managing close and
 * open event listeners to an element.
 *
 * @param <T> The type of the element that can have close and open event listeners.
 */
public interface HasOpenCloseListeners<T> {

  /**
   * Adds a close event listener to the element.
   *
   * @param closeListener The close event listener to be added.
   * @return The element with the close event listener added.
   */
  default T addCloseListener(CloseListener<? super T> closeListener) {
    getCloseListeners().add(closeListener);
    return (T) this;
  }

  /**
   * Adds an open event listener to the element.
   *
   * @param openListener The open event listener to be added.
   * @return The element with the open event listener added.
   */
  default T addOpenListener(OpenListener<? super T> openListener) {
    getOpenListeners().add(openListener);
    return (T) this;
  }

  /**
   * Removes a close event listener from the element.
   *
   * @param closeListener The close event listener to be removed.
   * @return The element with the close event listener removed.
   */
  default T removeCloseListener(CloseListener<? super T> closeListener) {
    getCloseListeners().remove(closeListener);
    return (T) this;
  }

  /**
   * Removes an open event listener from the element.
   *
   * @param openListener The open event listener to be removed.
   * @return The element with the open event listener removed.
   */
  default T removeOpenListener(OpenListener<? super T> openListener) {
    getOpenListeners().remove(openListener);
    return (T) this;
  }

  /**
   * Checks if the element has a close event listener.
   *
   * @param closeListener The close event listener to be checked.
   * @return {@code true} if the element has the specified close event listener, {@code false}
   *     otherwise.
   */
  default boolean hasCloseListener(CloseListener<? super T> closeListener) {
    return getCloseListeners().contains(closeListener);
  }

  /**
   * Checks if the element has an open event listener.
   *
   * @param openListener The open event listener to be checked.
   * @return {@code true} if the element has the specified open event listener, {@code false}
   *     otherwise.
   */
  default boolean hasOpenListener(OpenListener<? super T> openListener) {
    return getOpenListeners().contains(openListener);
  }

  /**
   * Pauses all close event listeners associated with the element.
   *
   * @return The element with its close event listeners paused.
   */
  T pauseCloseListeners();

  /**
   * Resumes all pause close event listeners associated with the element.
   *
   * @return The element with its close event listeners resumed.
   */
  T resumeCloseListeners();

  /**
   * Toggles the pause state of close event listeners associated with the element.
   *
   * @param toggle {@code true} to pause the listeners, {@code false} to resume them.
   * @return The element with its close event listeners paused or resumed based on the toggle
   *     parameter.
   */
  T togglePauseCloseListeners(boolean toggle);

  /**
   * Executes a given action while temporarily pausing the close event listeners, then resumes their
   * state.
   *
   * @param toggle {@code true} to pause the listeners during the action, {@code false} to resume
   *     them afterward.
   * @param handler The action to execute.
   * @return The element with its close event listeners paused during the action and resumed
   *     afterward.
   */
  default T withPauseCloseListenersToggle(boolean toggle, Handler<T> handler) {
    boolean oldState = isCloseListenersPaused();
    togglePauseCloseListeners(toggle);
    try {
      handler.apply((T) this);
    } finally {
      togglePauseCloseListeners(oldState);
    }
    return (T) this;
  }

  /**
   * Executes a given asynchronous action while temporarily pausing the close event listeners, then
   * resumes their state.
   *
   * @param toggle {@code true} to pause the listeners during the action, {@code false} to resume
   *     them afterward.
   * @param handler The asynchronous action to execute.
   * @return The element with its close event listeners paused during the action and resumed
   *     afterward.
   */
  default T withPauseCloseListenersToggle(boolean toggle, AsyncHandler<T> handler) {
    boolean oldState = isCloseListenersPaused();
    togglePauseCloseListeners(toggle);
    try {
      handler.apply((T) this, () -> togglePauseCloseListeners(oldState));
    } catch (Exception e) {
      togglePauseCloseListeners(oldState);
      throw e;
    }
    return (T) this;
  }

  /**
   * Gets a set of all close event listeners associated with the element.
   *
   * @return A set of close event listeners.
   */
  Set<CloseListener<? super T>> getCloseListeners();

  /**
   * Gets a set of all open event listeners associated with the element.
   *
   * @return A set of open event listeners.
   */
  Set<OpenListener<? super T>> getOpenListeners();

  /**
   * Checks if the close event listeners are currently paused.
   *
   * @return {@code true} if the close event listeners are paused, {@code false} otherwise.
   */
  boolean isCloseListenersPaused();

  /**
   * Triggers all close event listeners associated with the element.
   *
   * @param component The component that triggered the listeners.
   * @return The element with its close event listeners triggered.
   */
  T triggerCloseListeners(T component);

  /**
   * Triggers all open event listeners associated with the element.
   *
   * @param component The component that triggered the listeners.
   * @return The element with its open event listeners triggered.
   */
  T triggerOpenListeners(T component);

  /**
   * Functional interface for handling close events.
   *
   * @param <T> The type of the component that triggered the event.
   */
  @FunctionalInterface
  interface CloseListener<T> {

    /**
     * Called when a close event occurs on the associated element.
     *
     * @param component The component that triggered the event.
     */
    void onClosed(T component);
  }

  /**
   * Functional interface for handling open events.
   *
   * @param <T> The type of the component that triggered the event.
   */
  @FunctionalInterface
  interface OpenListener<T> {

    /**
     * Called when an open event occurs on the associated element.
     *
     * @param component The component that triggered the event.
     */
    void onOpened(T component);
  }
}
