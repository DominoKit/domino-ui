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
 * @deprecated use {@link HasOpenCloseListeners}
 */
@Deprecated
public interface HasCollapseListeners<T> extends HasOpenCloseListeners<T> {

  /**
   * Adds a collapse event listener to the element.
   *
   * @param collapseListener The collapse event listener to be added.
   * @return The element with the collapse event listener added.
   * @deprecated use {@link #addCloseListener}
   */
  @Deprecated
  default T addCollapseListener(CollapseListener<? super T> collapseListener) {
    return addCloseListener(collapseListener);
  }

  /**
   * Adds an expand event listener to the element.
   *
   * @param expandListener The expand event listener to be added.
   * @return The element with the expand event listener added.
   * @deprecated use {@link #addOpenListener}
   */
  @Deprecated
  default T addExpandListener(ExpandListener<? super T> expandListener) {
    return addOpenListener(expandListener);
  }

  /**
   * Removes a collapse event listener from the element.
   *
   * @param collapseListener The collapse event listener to be removed.
   * @return The element with the collapse event listener removed.
   * @deprecated use {@link #removeCloseListener}
   */
  @Deprecated
  default T removeCollapseListener(CollapseListener<? super T> collapseListener) {
    return removeCloseListener(collapseListener);
  }

  /**
   * Removes an expand event listener from the element.
   *
   * @param expandListener The expand event listener to be removed.
   * @return The element with the expand event listener removed.
   * @deprecated use {@link #removeOpenListener}
   */
  @Deprecated
  default T removeExpandListener(ExpandListener<? super T> expandListener) {
    return removeOpenListener(expandListener);
  }

  /**
   * Checks if the element has a collapse event listener.
   *
   * @param collapseListener The collapse event listener to be checked.
   * @return {@code true} if the element has the specified collapse event listener, {@code false}
   *     otherwise.
   * @deprecated use {@link #hasCloseListener}
   */
  @Deprecated
  default boolean hasCollapseListener(CollapseListener<? super T> collapseListener) {
    return hasCloseListener(collapseListener);
  }

  /**
   * Checks if the element has an expand event listener.
   *
   * @param expandListener The expand event listener to be checked.
   * @return {@code true} if the element has the specified expand event listener, {@code false}
   *     otherwise.
   * @deprecated use {@link #hasOpenListener}
   */
  @Deprecated
  default boolean hasExpandListener(ExpandListener<? super T> expandListener) {
    return hasOpenListener(expandListener);
  }

  /**
   * Pauses all collapse event listeners associated with the element.
   *
   * @return The element with its collapse event listeners paused.
   * @deprecated use {@link #pauseCloseListeners}
   */
  @Deprecated
  default T pauseCollapseListeners() {
    return pauseCloseListeners();
  }

  /**
   * Resumes all pause collapse event listeners associated with the element.
   *
   * @return The element with its collapse event listeners resumed.
   * @deprecated use {@link #resumeCloseListeners}
   */
  @Deprecated
  default T resumeCollapseListeners() {
    return resumeCloseListeners();
  }

  /**
   * Toggles the pause state of collapse event listeners associated with the element.
   *
   * @param toggle {@code true} to pause the listeners, {@code false} to resume them.
   * @return The element with its collapse event listeners paused or resumed based on the toggle
   *     parameter.
   * @deprecated use {@link #togglePauseCloseListeners}
   */
  @Deprecated
  default T togglePauseCollapseListeners(boolean toggle) {
    return togglePauseCloseListeners(toggle);
  }

  /**
   * Executes a given action while temporarily pausing the collapse event listeners, then resumes
   * their state.
   *
   * @param toggle {@code true} to pause the listeners during the action, {@code false} to resume
   *     them afterward.
   * @param handler The action to execute.
   * @return The element with its collapse event listeners paused during the action and resumed
   *     afterward.
   * @deprecated use {@link #withPauseCloseListenersToggle}
   */
  @Deprecated
  default T withPauseCollapseListenersToggle(boolean toggle, Handler<T> handler) {
    return withPauseCloseListenersToggle(toggle, handler);
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
   * @deprecated use {@link #withPauseCloseListenersToggle}
   */
  @Deprecated
  default T withPauseCollapseListenersToggle(boolean toggle, AsyncHandler<T> handler) {
    return withPauseCloseListenersToggle(toggle, handler);
  }

  /**
   * Gets a set of all collapse event listeners associated with the element.
   *
   * @return A set of collapse event listeners.
   * @deprecated use {@link #getCloseListeners}
   */
  @Deprecated
  default Set<CloseListener<? super T>> getCollapseListeners() {
    return getCloseListeners();
  }

  /**
   * Gets a set of all expand event listeners associated with the element.
   *
   * @return A set of expand event listeners.
   * @deprecated use {@link #getOpenListeners}
   */
  @Deprecated
  default Set<OpenListener<? super T>> getExpandListeners() {
    return getOpenListeners();
  }

  /**
   * Checks if the collapse event listeners are currently paused.
   *
   * @return {@code true} if the collapse event listeners are paused, {@code false} otherwise.
   * @deprecated use {@link #isCloseListenersPaused}
   */
  @Deprecated
  default boolean isCollapseListenersPaused() {
    return isCloseListenersPaused();
  }

  /**
   * Triggers all collapse event listeners associated with the element.
   *
   * @param component The component that triggered the listeners.
   * @return The element with its collapse event listeners triggered.
   * @deprecated use {@link #triggerCloseListeners}
   */
  @Deprecated
  default T triggerCollapseListeners(T component) {
    return triggerCloseListeners(component);
  }

  /**
   * Triggers all expand event listeners associated with the element.
   *
   * @param component The component that triggered the listeners.
   * @return The element with its expand event listeners triggered.
   * @deprecated use {@link #triggerOpenListeners}
   */
  @Deprecated
  default T triggerExpandListeners(T component) {
    return triggerOpenListeners(component);
  }

  /**
   * Functional interface for handling collapse events.
   *
   * @param <T> The type of the component that triggered the event.
   * @deprecated use {@link CloseListener}
   */
  @Deprecated
  @FunctionalInterface
  interface CollapseListener<T> extends HasOpenCloseListeners.CloseListener<T> {

    /**
     * Called when a collapse event occurs on the associated element.
     *
     * @param component The component that triggered the event.
     */
    default void onCollapsed(T component) {
      onClosed(component);
    };
  }

  /**
   * Functional interface for handling expand events.
   *
   * @param <T> The type of the component that triggered the event.
   * @deprecated use {@link OpenListener}
   */
  @Deprecated
  @FunctionalInterface
  interface ExpandListener<T> extends HasOpenCloseListeners.OpenListener<T> {

    /**
     * Called when an expand event occurs on the associated element.
     *
     * @param component The component that triggered the event.
     */
    default void onExpanded(T component) {
      onOpened(component);
    }
  }
}
