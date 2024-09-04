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

import java.util.List;
import org.dominokit.domino.ui.datatable.events.SearchEvent;
import org.dominokit.domino.ui.datatable.events.SortEvent;
import org.dominokit.domino.ui.datatable.plugins.SortDirection;
import org.dominokit.domino.ui.datatable.store.LocalListDataStore;
import org.dominokit.domino.ui.datatable.store.RecordsSorter;
import org.dominokit.domino.ui.datatable.store.SearchFilter;
import org.dominokit.domino.ui.pagination.HasPagination;

@Deprecated
public class SubItemsStore<T> extends LocalListDataStore<T> {

  private final LocalTreeDataStore<T> parent;

  public SubItemsStore(LocalTreeDataStore<T> parent) {
    this.parent = parent;
  }

  public SubItemsStore(List<T> data, LocalTreeDataStore<T> parent) {
    super(data);
    this.parent = parent;
  }

  @Override
  public HasPagination getPagination() {
    return parent.getPagination();
  }

  @Override
  public SearchFilter<T> getSearchFilter() {
    return parent.getSearchFilter();
  }

  @Override
  public RecordsSorter<T> getRecordsSorter() {
    return parent.getRecordsSorter();
  }

  @Override
  public SortFunction<T> getSortFunction() {
    return parent.getSortFunction();
  }

  @Override
  public SortEvent<T> getLastSort() {
    return parent.getLastSort();
  }

  @Override
  public SearchEvent getLastSearch() {
    return parent.getLastSearch();
  }

  @Override
  public String getAutoSortBy() {
    return parent.getAutoSortBy();
  }

  @Override
  public SortDirection getAutoSortDirection() {
    return parent.getAutoSortDirection();
  }

  @Override
  public boolean isAutoSort() {
    return parent.isAutoSort();
  }

  @Override
  public boolean isAutoSortApplied() {
    return parent.isAutoSortApplied();
  }
}
