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
package org.dominokit.domino.ui.datatable.plugins.tree.store;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Consumer;
import org.dominokit.domino.ui.datatable.events.SearchEvent;
import org.dominokit.domino.ui.datatable.events.SortEvent;

/**
 * TreeNodeStore interface.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public interface TreeNodeStore<T> {
  /**
   * getNodeChildren.
   *
   * @param context a {@link
   *     org.dominokit.domino.ui.datatable.plugins.tree.store.TreeNodeStoreContext} object
   * @param itemsConsumer a {@link java.util.function.Consumer} object
   */
  void getNodeChildren(
      TreeNodeStoreContext<T> context, Consumer<Optional<Collection<T>>> itemsConsumer);

  /**
   * getLastSearch.
   *
   * @return a {@link org.dominokit.domino.ui.datatable.events.SearchEvent} object
   */
  SearchEvent getLastSearch();

  /**
   * getLastSort.
   *
   * @return a {@link org.dominokit.domino.ui.datatable.events.SortEvent} object
   */
  SortEvent<T> getLastSort();

  /**
   * hasChildren.
   *
   * @param record a T object
   * @return a boolean
   */
  boolean hasChildren(T record);
}
