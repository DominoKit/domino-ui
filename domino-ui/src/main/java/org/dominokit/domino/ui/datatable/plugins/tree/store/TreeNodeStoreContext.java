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

import org.dominokit.domino.ui.datatable.events.SearchEvent;
import org.dominokit.domino.ui.datatable.events.SortEvent;

public class TreeNodeStoreContext<T> {

  private final T parent;
  private final SearchEvent lastSearch;
  private final SortEvent<T> lastSort;

  /**
   * Constructs a TreeNodeStoreContext with the provided parent, last search event, and last sort
   * event.
   *
   * @param parent The parent node for which children are being fetched.
   * @param lastSearch The last search event that occurred.
   * @param lastSort The last sort event that occurred.
   */
  public TreeNodeStoreContext(T parent, SearchEvent lastSearch, SortEvent<T> lastSort) {
    this.parent = parent;
    this.lastSearch = lastSearch;
    this.lastSort = lastSort;
  }

  /**
   * Gets the parent node for which children are being fetched.
   *
   * @return The parent node.
   */
  public T getParent() {
    return parent;
  }

  /**
   * Gets the last search event that occurred.
   *
   * @return The last search event.
   */
  public SearchEvent getLastSearch() {
    return lastSearch;
  }

  /**
   * Gets the last sort event that occurred.
   *
   * @return The last sort event.
   */
  public SortEvent<T> getLastSort() {
    return lastSort;
  }
}
