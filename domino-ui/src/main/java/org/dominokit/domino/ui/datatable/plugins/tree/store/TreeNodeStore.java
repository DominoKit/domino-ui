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
 * A data store for tree nodes in a DataTable. This interface defines methods for fetching children
 * of a tree node, retrieving the last search event, the last sort event, and checking if a node has
 * children.
 *
 * @param <T> The type of data in the DataTable.
 */
public interface TreeNodeStore<T> {

  /**
   * Retrieves the children of a tree node and passes them to the provided consumer. The consumer
   * receives an optional collection of tree node children.
   *
   * @param context The context containing information about the node and the events.
   * @param itemsConsumer The consumer to receive the optional collection of tree node children.
   */
  void getNodeChildren(
      TreeNodeStoreContext<T> context, Consumer<Optional<Collection<T>>> itemsConsumer);

  /**
   * Retrieves the last search event performed.
   *
   * @return The last search event.
   */
  SearchEvent getLastSearch();

  /**
   * Retrieves the last sort event performed.
   *
   * @return The last sort event.
   */
  SortEvent<T> getLastSort();

  /**
   * Checks if a tree node has children.
   *
   * @param record The tree node to check for children.
   * @return {@code true} if the node has children, {@code false} otherwise.
   */
  boolean hasChildren(T record);
}
