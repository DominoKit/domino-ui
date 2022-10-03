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
 */
public interface HasToggleListeners<T> {

    /**
     * @param toggleListener {@link ToggleListener}
     * @return same implementing class instance
     */
    default T addToggleListener(ToggleListener toggleListener) {
        getToggleListeners().add(toggleListener);
        return (T) this;
    }

    /**
     * @param toggleListener {@link ToggleListener}
     * @return same implementing class instance
     */
    default T removeToggleListener(ToggleListener toggleListener) {
        getToggleListeners().remove(toggleListener);
        return (T) this;
    }

    /**
     * Checks if a component has the specified ChangeHandler
     *
     * @param toggleListener {@link ToggleListener}
     * @return same implementing class instance
     */
    default boolean hasToggleListener(ToggleListener toggleListener) {
        return getToggleListeners().contains(toggleListener);
    }

    /**
     * Disable change listeners
     *
     * @return same component instance
     */
    T pauseToggleListeners();

    /**
     * Enables change listeners
     *
     * @return same component instance
     */
    T resumeToggleListeners();

    /**
     * Disable/Enable change listeners
     *
     * @param toggle boolean, true to pause the change listeners, false to enable them
     * @return same component instance
     */
    T togglePauseToggleListeners(boolean toggle);

    /**
     * Execute a handler while toggling the change handlers state, revert the state back to its original value after executing the handler
     *
     * @param toggle boolean, true to pause the change listeners, false to enable them
     * @return same component instance
     */
    default T withPauseToggleListenersToggle(boolean toggle, Handler<T> handler) {
        boolean oldState = isToggleListenersPaused();
        togglePauseToggleListeners(toggle);
        try {
            handler.apply((T) this);
        } finally {
            togglePauseToggleListeners(oldState);
        }
        return (T) this;
    }

    /**
     * Execute a handler while toggling the change handlers state, revert the state back to its original value after the AsyncHandler.onComplete is called
     *
     * @param toggle boolean, true to pause the change listeners, false to enable them
     * @return same component instance
     */
    default T withPauseToggleListenersToggle(boolean toggle, AsyncHandler<T> handler) {
        boolean oldState = isToggleListenersPaused();
        togglePauseToggleListeners(toggle);
        try {
            handler.apply((T) this, () -> togglePauseToggleListeners(oldState));
        } catch (Exception e) {
            togglePauseToggleListeners(oldState);
            throw e;
        }
        return (T) this;
    }

    Set<ToggleListener> getToggleListeners();

    boolean isToggleListenersPaused();

    T triggerToggleListeners(Boolean oldValue, Boolean newValue);

    /**
     */
    @FunctionalInterface
    interface ToggleListener {
        /**
         * Will be called whenever the component value is changed
         *
         * @param newValue V the new value of the component
         */
        void onValueChanged(Boolean oldValue, Boolean newValue);
    }
}
