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
package org.dominokit.domino.ui.datatable.store;

import org.dominokit.domino.ui.datatable.events.TableEventListener;

/**
 * An interface to implement different data stores for the data table and listen to table events.
 *
 * @param <T> the type of the data table records
 * @author vegegoku
 * @version $Id: $Id
 */
public interface DataStore<T> extends TableEventListener {
  /**
   * Adds a listener to handle the {@link org.dominokit.domino.ui.datatable.store.DataChangedEvent}
   * events
   *
   * @param dataChangeListener {@link
   *     org.dominokit.domino.ui.datatable.store.StoreDataChangeListener}
   */
  void onDataChanged(StoreDataChangeListener<T> dataChangeListener);

  /**
   * removes the listener
   *
   * @param dataChangeListener {@link
   *     org.dominokit.domino.ui.datatable.store.StoreDataChangeListener}
   */
  void removeDataChangeListener(StoreDataChangeListener<T> dataChangeListener);

  /** loads the data into the data table */
  void load();
}
