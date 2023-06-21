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
 * @author vegegoku
 * @version $Id: $Id
 */
public interface HasCollapseListeners<T> {

  /**
   * addCollapseListener.
   *
   * @param collapseListener {@link
   *     org.dominokit.domino.ui.utils.HasCollapseListeners.CollapseListener}
   * @return same implementing class instance
   */
  default T addCollapseListener(CollapseListener<? super T> collapseListener) {
    getCollapseListeners().add(collapseListener);
    return (T) this;
  }

  /**
   * addExpandListener.
   *
   * @param expandListener {@link org.dominokit.domino.ui.utils.HasCollapseListeners.ExpandListener}
   * @return same implementing class instance
   */
  default T addExpandListener(ExpandListener<? super T> expandListener) {
    getExpandListeners().add(expandListener);
    return (T) this;
  }

  /**
   * removeCollapseListener.
   *
   * @param collapseListener {@link
   *     org.dominokit.domino.ui.utils.HasCollapseListeners.CollapseListener}
   * @return same implementing class instance
   */
  default T removeCollapseListener(CollapseListener<? super T> collapseListener) {
    getCollapseListeners().remove(collapseListener);
    return (T) this;
  }

  /**
   * removeCExpandListener.
   *
   * @param expandListener {@link org.dominokit.domino.ui.utils.HasCollapseListeners.ExpandListener}
   * @return same implementing class instance
   */
  default T removeCExpandListener(ExpandListener<? super T> expandListener) {
    getExpandListeners().remove(expandListener);
    return (T) this;
  }

  /**
   * Checks if a component has the specified ChangeHandler
   *
   * @param collapseListener {@link
   *     org.dominokit.domino.ui.utils.HasCollapseListeners.CollapseListener}
   * @return same implementing class instance
   */
  default boolean hasCollapseListener(CollapseListener<? super T> collapseListener) {
    return getCollapseListeners().contains(collapseListener);
  }
  /**
   * Checks if a component has the specified ChangeHandler
   *
   * @param expandListener {@link org.dominokit.domino.ui.utils.HasCollapseListeners.ExpandListener}
   * @return same implementing class instance
   */
  default boolean hasExpandListener(ExpandListener<? super T> expandListener) {
    return getExpandListeners().contains(expandListener);
  }

  /**
   * Disable change listeners
   *
   * @return same component instance
   */
  T pauseCollapseListeners();

  /**
   * Enables change listeners
   *
   * @return same component instance
   */
  T resumeCollapseListeners();

  /**
   * Disable/Enable change listeners
   *
   * @param toggle boolean, true to pause the change listeners, false to enable them
   * @return same component instance
   */
  T togglePauseCollapseListeners(boolean toggle);

  /**
   * Execute a handler while toggling the change handlers state, revert the state back to its
   * original value after executing the handler
   *
   * @param toggle boolean, true to pause the change listeners, false to enable them
   * @return same component instance
   * @param handler a {@link org.dominokit.domino.ui.utils.Handler} object
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
   * Execute a handler while toggling the change handlers state, revert the state back to its
   * original value after the AsyncHandler.onComplete is called
   *
   * @param toggle boolean, true to pause the change listeners, false to enable them
   * @return same component instance
   * @param handler a {@link org.dominokit.domino.ui.utils.AsyncHandler} object
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
   * getCollapseListeners.
   *
   * @return a {@link java.util.Set} object
   */
  Set<CollapseListener<? super T>> getCollapseListeners();

  /**
   * getExpandListeners.
   *
   * @return a {@link java.util.Set} object
   */
  Set<ExpandListener<? super T>> getExpandListeners();

  /**
   * isCollapseListenersPaused.
   *
   * @return a boolean
   */
  boolean isCollapseListenersPaused();

  /**
   * triggerCollapseListeners.
   *
   * @param component a T object
   * @return a T object
   */
  T triggerCollapseListeners(T component);

  /**
   * triggerExpandListeners.
   *
   * @param component a T object
   * @return a T object
   */
  T triggerExpandListeners(T component);

  /** @param <T> the type of the component */
  @FunctionalInterface
  interface CollapseListener<T> {
    /**
     * Will be called whenever the component is collapsed/expanded
     *
     * @param component The collapsed/expanded component
     */
    void onCollapsed(T component);
  }

  /** @param <T> the type of the component */
  @FunctionalInterface
  interface ExpandListener<T> {
    /**
     * Will be called whenever the component is collapsed/expanded
     *
     * @param component The collapsed/expanded component
     */
    void onExpanded(T component);
  }
}
