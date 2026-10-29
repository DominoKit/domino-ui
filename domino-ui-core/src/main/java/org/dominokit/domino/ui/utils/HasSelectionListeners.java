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

import java.util.Optional;
import java.util.Set;

/**
 * The {@code HasSelectionListeners} interface defines methods for adding and removing selection
 * listeners to a component that can be selected and deselected, and for handling selection and
 * deselection events.
 *
 * @param <T> The type of the component to which selection listeners can be added or removed.
 * @param <V> The type of the source of selection events.
 * @param <S> The type of the selection value.
 */
public interface HasSelectionListeners<T, V, S> {

  /**
   * Adds a selection listener to the component.
   *
   * @param selectionListener The selection listener to be added.
   * @return The component with the added selection listener.
   */
  default T addSelectionListener(SelectionListener<? super V, ? super S> selectionListener) {
    getSelectionListeners().add(selectionListener);
    return (T) this;
  }

  /**
   * Adds a deselection listener to the component.
   *
   * @param selectionListener The deselection listener to be added.
   * @return The component with the added deselection listener.
   */
  default T addDeselectionListener(SelectionListener<? super V, ? super S> selectionListener) {
    getDeselectionListeners().add(selectionListener);
    return (T) this;
  }

  /**
   * Adds a selection and deselection listener to the component.
   *
   * @param listener The selection and deselection listener to be added.
   * @return The component with the added listener.
   */
  default T addSelectionChangeListener(SelectionListener<? super V, ? super S> listener) {
    addDeselectionListener(listener);
    addSelectionListener(listener);
    return (T) this;
  }

  /**
   * Removes a selection listener from the component.
   *
   * @param selectionListener The selection listener to be removed.
   * @return The component with the selection listener removed.
   */
  default T removeSelectionListener(SelectionListener<? super V, ? super S> selectionListener) {
    getSelectionListeners().remove(selectionListener);
    return (T) this;
  }

  /**
   * Removes a deselection listener from the component.
   *
   * @param selectionListener The deselection listener to be removed.
   * @return The component with the deselection listener removed.
   */
  default T removeDeselectionListener(SelectionListener<? super V, ? super S> selectionListener) {
    getDeselectionListeners().remove(selectionListener);
    return (T) this;
  }

  /**
   * Checks if the component has a selection listener.
   *
   * @param selectionListener The selection listener to check.
   * @return {@code true} if the component has the selection listener, {@code false} otherwise.
   */
  default boolean hasSelectionListener(SelectionListener<? super V, ? super S> selectionListener) {
    return getSelectionListeners().contains(selectionListener);
  }

  /**
   * Checks if the component has a deselection listener.
   *
   * @param selectionListener The deselection listener to check.
   * @return {@code true} if the component has the deselection listener, {@code false} otherwise.
   */
  default boolean hasDeselectionListener(
      SelectionListener<? super V, ? super S> selectionListener) {
    return getDeselectionListeners().contains(selectionListener);
  }

  /**
   * Pauses selection listeners for the component.
   *
   * @return The component with selection listeners paused.
   */
  T pauseSelectionListeners();

  /**
   * Resumes selection listeners for the component.
   *
   * @return The component with selection listeners resumed.
   */
  T resumeSelectionListeners();

  /**
   * Toggles the pause state of selection listeners for the component.
   *
   * @param toggle {@code true} to pause, {@code false} to resume.
   * @return The component with selection listeners paused or resumed based on the toggle value.
   */
  T togglePauseSelectionListeners(boolean toggle);

  /**
   * Executes a handler with selection listeners paused, then restores the previous pause state.
   *
   * @param toggle {@code true} to pause, {@code false} to resume.
   * @param handler The handler to execute.
   * @return The component with selection listeners paused or resumed based on the toggle value.
   */
  default T withPauseSelectionListenersToggle(boolean toggle, Handler<T> handler) {
    boolean oldState = isSelectionListenersPaused();
    togglePauseSelectionListeners(toggle);
    try {
      handler.apply((T) this);
    } finally {
      togglePauseSelectionListeners(oldState);
    }
    return (T) this;
  }

  /**
   * Executes an asynchronous handler with selection listeners paused, then restores the previous
   * pause state.
   *
   * @param toggle {@code true} to pause, {@code false} to resume.
   * @param handler The asynchronous handler to execute.
   * @return The component with selection listeners paused or resumed based on the toggle value.
   */
  default T withPauseSelectionListenersToggleAsync(boolean toggle, AsyncHandler<T> handler) {
    boolean oldState = isSelectionListenersPaused();
    togglePauseSelectionListeners(toggle);
    try {
      handler.apply((T) this, () -> togglePauseSelectionListeners(oldState));
    } catch (Exception e) {
      togglePauseSelectionListeners(oldState);
      throw e;
    }
    return (T) this;
  }

  /**
   * Gets the set of selection listeners for the component.
   *
   * @return The set of selection listeners.
   */
  Set<SelectionListener<? super V, ? super S>> getSelectionListeners();

  /**
   * Gets the set of deselection listeners for the component.
   *
   * @return The set of deselection listeners.
   */
  Set<SelectionListener<? super V, ? super S>> getDeselectionListeners();

  /**
   * Checks if selection listeners for the component are paused.
   *
   * @return {@code true} if selection listeners are paused, {@code false} otherwise.
   */
  boolean isSelectionListenersPaused();

  /**
   * Triggers selection listeners for the component.
   *
   * @param source The source of the selection event.
   * @param selection The selection value.
   * @return The component with selection listeners triggered.
   */
  T triggerSelectionListeners(V source, S selection);

  /**
   * Triggers deselection listeners for the component.
   *
   * @param source The source of the deselection event.
   * @param selection The selection value.
   * @return The component with deselection listeners triggered.
   */
  T triggerDeselectionListeners(V source, S selection);

  /**
   * Gets the current selection value of the component.
   *
   * @return The current selection value.
   */
  S getSelection();

  /**
   * A functional interface for handling selection and deselection events of a component.
   *
   * @param <V> The type of the source of the event.
   * @param <S> The type of the selection value.
   */
  @FunctionalInterface
  interface SelectionListener<V, S> {

    /**
     * Called when a selection or deselection event occurs in the component.
     *
     * @param source The source of the event.
     * @param selection The selection or deselection value.
     */
    void onSelectionChanged(Optional<V> source, S selection);
  }
}
