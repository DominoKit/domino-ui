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

/** TreeNodeStoreContext class. */
public class TreeNodeStoreContext<T> {

  private final T parent;
  private final SearchEvent lastSearch;
  private final SortEvent<T> lastSort;

  /**
   * Constructor for TreeNodeStoreContext.
   *
   * @param parent a T object
   * @param lastSearch a {@link org.dominokit.domino.ui.datatable.events.SearchEvent} object
   * @param lastSort a {@link org.dominokit.domino.ui.datatable.events.SortEvent} object
   */
  public TreeNodeStoreContext(T parent, SearchEvent lastSearch, SortEvent<T> lastSort) {
    this.parent = parent;
    this.lastSearch = lastSearch;
    this.lastSort = lastSort;
  }

  /**
   * Getter for the field <code>parent</code>.
   *
   * @return a T object
   */
  public T getParent() {
    return parent;
  }

  /**
   * Getter for the field <code>lastSearch</code>.
   *
   * @return a {@link org.dominokit.domino.ui.datatable.events.SearchEvent} object
   */
  public SearchEvent getLastSearch() {
    return lastSearch;
  }

  /**
   * Getter for the field <code>lastSort</code>.
   *
   * @return a {@link org.dominokit.domino.ui.datatable.events.SortEvent} object
   */
  public SortEvent<T> getLastSort() {
    return lastSort;
  }
}
