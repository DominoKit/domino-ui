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

import org.dominokit.domino.ui.utils.DominoEventListener;

/**
 * The {@code DataStore} interface defines a contract for managing and retrieving data for a data
 * table.
 *
 * @param <T> The type of data representing the records in the data table.
 */
public interface DataStore<T> extends DominoEventListener {

  /**
   * Registers a data change listener to be notified when the data in the store changes.
   *
   * @param dataChangeListener The data change listener to register.
   */
  void onDataChanged(StoreDataChangeListener<T> dataChangeListener);

  /**
   * Removes a previously registered data change listener.
   *
   * @param dataChangeListener The data change listener to remove.
   */
  void removeDataChangeListener(StoreDataChangeListener<T> dataChangeListener);

  /** Loads or refreshes the data in the data store. */
  void load();
}
