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
package org.dominokit.domino.ui.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.dominokit.domino.ui.utils.AsyncHandler;
import org.dominokit.domino.ui.utils.Handler;

public interface HasDataFilters<T, C extends HasDataFilters<T, C>> {

  /**
   * Adds a change listener to the set of listeners.
   *
   * @param filter The {@link DataFilter} to be added.
   * @return The modified object of type {@code T} with the data filters added.
   */
  default C addDataFilter(DataFilter<? super T> filter) {
    getDataFilters().add(filter);
    return (C) this;
  }

  /**
   * Removes a change listener from the set of listeners.
   *
   * @param dataFilter The {@link DataFilter} to be removed.
   * @return The modified object of type {@code T} with the change listener removed.
   */
  default C removeDataFilter(DataFilter<? super T> dataFilter) {
    getDataFilters().remove(dataFilter);
    return (C) this;
  }

  /**
   * Checks if a change listener is present in the set of listeners.
   *
   * @param dataFilter The {@link DataFilter} to be checked.
   * @return {@code true} if the change listener is present, {@code false} otherwise.
   */
  default boolean hasDataFilter(DataFilter<? super T> dataFilter) {
    return getDataFilters().contains(dataFilter);
  }

  /**
   * Pauses change listeners.
   *
   * @return The modified object of type {@code T} with change listeners paused.
   */
  C pauseDataFilters();

  /**
   * Resumes change listeners.
   *
   * @return The modified object of type {@code T} with change listeners resumed.
   */
  C resumeDataFilters();

  /**
   * Toggles the pause state of change listeners.
   *
   * @param toggle {@code true} to pause change listeners, {@code false} to resume.
   * @return The modified object of type {@code T} with the change listener pause state toggled.
   */
  C togglePauseDataFilters(boolean toggle);

  /**
   * Executes a handler with change listeners paused, then resumes change listeners.
   *
   * @param toggle {@code true} to pause change listeners, {@code false} to resume.
   * @param handler The {@link Handler} to be executed.
   * @return The modified object of type {@code T} with change listeners handled accordingly.
   */
  default C withPauseDataFiltersToggle(boolean toggle, Handler<C> handler) {
    boolean oldState = isDataFiltersPaused();
    togglePauseDataFilters(toggle);
    try {
      handler.apply((C) this);
    } finally {
      togglePauseDataFilters(oldState);
    }
    return (C) this;
  }

  /**
   * Executes a handler with change listeners paused, then resumes change listeners.
   *
   * @param handler The {@link Handler} to be executed.
   * @return The modified object of type {@code T} with change listeners handled accordingly.
   */
  default C withPausedDataFilters(Handler<C> handler) {
    boolean oldState = isDataFiltersPaused();
    togglePauseDataFilters(true);
    try {
      handler.apply((C) this);
    } finally {
      togglePauseDataFilters(oldState);
    }
    return (C) this;
  }

  /**
   * Executes an asynchronous handler with change listeners paused, then resumes change listeners.
   *
   * @param toggle {@code true} to pause change listeners, {@code false} to resume.
   * @param handler The {@link AsyncHandler} to be executed.
   * @return The modified object of type {@code T} with change listeners handled asynchronously.
   */
  default C withPauseDataFiltersToggleAsync(boolean toggle, AsyncHandler<C> handler) {
    boolean oldState = isDataFiltersPaused();
    togglePauseDataFilters(toggle);
    try {
      handler.apply((C) this, () -> togglePauseDataFilters(oldState));
    } catch (Exception e) {
      togglePauseDataFilters(oldState);
      throw e;
    }
    return (C) this;
  }

  /**
   * Executes an asynchronous handler with change listeners paused, then resumes change listeners.
   *
   * @param handler The {@link AsyncHandler} to be executed.
   * @return The modified object of type {@code T} with change listeners handled asynchronously.
   */
  default C withPausedDataFiltersAsync(AsyncHandler<C> handler) {
    boolean oldState = isDataFiltersPaused();
    togglePauseDataFilters(true);
    try {
      handler.apply((C) this, () -> togglePauseDataFilters(oldState));
    } catch (Exception e) {
      togglePauseDataFilters(oldState);
      throw e;
    }
    return (C) this;
  }

  /**
   * Retrieves the set of change listeners.
   *
   * @return A {@link Set} of {@link DataFilter} objects.
   */
  Set<DataFilter<? super T>> getDataFilters();

  /**
   * Checks if change listeners are currently paused.
   *
   * @return {@code true} if change listeners are paused, {@code false} otherwise.
   */
  boolean isDataFiltersPaused();

  default FilterMode<T> getFilterMode() {
    return FilterMode.denial();
  }

  /**
   * Triggers change listeners with the old and new values.
   *
   * @param data The old value before the change.
   * @return The modified object of type {@code T} with change listeners triggered.
   */
  default List<T> filterData(T data) {
    return filterData(Collections.singletonList(data));
  }

  /**
   * Triggers change listeners with the old and new values.
   *
   * @param data The old value before the change.
   * @return The modified object of type {@code T} with change listeners triggered.
   */
  default boolean isAcceptedByFilters(T data) {
    return filterData(Collections.singletonList(data)).contains(data);
  }

  /**
   * Triggers change listeners with the old and new values.
   *
   * @param data The old value before the change.
   * @return The modified object of type {@code T} with change listeners triggered.
   */
  default List<T> filterData(Collection<T> data) {
    if (data == null || data.isEmpty()) return new ArrayList<>();
    if (isDataFiltersPaused()) return new ArrayList<>(data);

    FilterMode<T> mode = getFilterMode();
    Collection<DataFilter<? super T>> filters =
        (getDataFilters() != null) ? getDataFilters() : Collections.emptyList();

    return (mode != null) ? mode.apply(data, filters) : new ArrayList<>(data);
  }
}
