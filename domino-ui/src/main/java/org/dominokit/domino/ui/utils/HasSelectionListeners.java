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

import org.dominokit.domino.ui.menu.AbstractMenuItem;

import java.util.Optional;
import java.util.Set;

/**
 * Components that has a value that can be selectiond and need to define listeners for the selections
 * should implement this interface
 *
 * @param <T> the type of the class implementing this interface
 * @param <V> the type of the component value
 * @param <S> the type of selected value
 */
public interface HasSelectionListeners<T, V, S> {

    /**
     * @param selectionListener {@link SelectionListener}
     * @return same implementing class instance
     */
    default T addSelectionListener(SelectionListener<? super V, ? super S> selectionListener) {
        getSelectionListeners().add(selectionListener);
        return (T) this;
    }
    /**
     * @param selectionListener {@link SelectionListener}
     * @return same implementing class instance
     */
    default T addDeselectionListener(SelectionListener<? super V, ? super S> selectionListener) {
        getDeselectionListeners().add(selectionListener);
        return (T) this;
    }

    /**
     * @param selectionListener {@link SelectionListener}
     * @return same implementing class instance
     */
    default T removeSelectionListener(SelectionListener<? super V, ? super S> selectionListener) {
        getSelectionListeners().remove(selectionListener);
        return (T) this;
    }

    /**
     * @param selectionListener {@link SelectionListener}
     * @return same implementing class instance
     */
    default T removeDeselectionListener(SelectionListener<? super V, ? super S> selectionListener) {
        getDeselectionListeners().remove(selectionListener);
        return (T) this;
    }

    /**
     * Checks if a component has the specified SelectionHandler
     *
     * @param selectionListener {@link SelectionListener}
     * @return same implementing class instance
     */
    default boolean hasSelectionListener(SelectionListener<? super V, ? super S> selectionListener) {
        return getSelectionListeners().contains(selectionListener);
    }

    /**
     * Checks if a component has the specified SelectionHandler
     *
     * @param selectionListener {@link SelectionListener}
     * @return same implementing class instance
     */
    default boolean hasDeselectionListener(SelectionListener<? super V, ? super S> selectionListener) {
        return getDeselectionListeners().contains(selectionListener);
    }

    /**
     * Disable selection listeners
     *
     * @return same component instance
     */
    T pauseSelectionListeners();

    /**
     * Enables selection listeners
     *
     * @return same component instance
     */
    T resumeSelectionListeners();

    /**
     * Disable/Enable selection listeners
     *
     * @param toggle boolean, true to pause the selection listeners, false to enable them
     * @return same component instance
     */
    T togglePauseSelectionListeners(boolean toggle);

    /**
     * Execute a handler while toggling the selection handlers state, revert the state back to its original value after executing the handler
     *
     * @param toggle boolean, true to pause the selection listeners, false to enable them
     * @return same component instance
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
     * Execute a handler while toggling the selection handlers state, revert the state back to its original value after the AsyncHandler.onComplete is called
     *
     * @param toggle boolean, true to pause the selection listeners, false to enable them
     * @return same component instance
     */
    default T withPauseSelectionListenersToggle(boolean toggle, AsyncHandler<T> handler) {
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

    Set<SelectionListener<? super V, ? super S>> getSelectionListeners();


    Set<SelectionListener<? super V, ? super S>> getDeselectionListeners();

    boolean isSelectionListenersPaused();

    T triggerSelectionListeners(V source, S selection);

    T triggerDeselectionListeners(V source, S selection);

    S getSelected();

    /**
     * @param <V> the type of the component value
     * @param <S> the type of the selected value
     */
    @FunctionalInterface
    interface SelectionListener<V, S> {
        /**
         * Will be called whenever the component value is selectiond
         *
         * @param source V item that has its selection changed
         * @param selection The current selected item(s)
         */
        void onSelectionSelection(Optional<V> source, S selection);
    }
}
