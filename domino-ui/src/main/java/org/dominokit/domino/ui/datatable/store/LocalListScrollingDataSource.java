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

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.datatable.events.BodyScrollEvent.BODY_SCROLL;
import static org.dominokit.domino.ui.datatable.events.SearchEvent.SEARCH_EVENT;
import static org.dominokit.domino.ui.datatable.events.SortEvent.SORT_EVENT;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.dominokit.domino.ui.datatable.events.BodyScrollEvent;
import org.dominokit.domino.ui.datatable.events.SearchEvent;
import org.dominokit.domino.ui.datatable.events.SortEvent;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.datatable.plugins.pagination.BodyScrollPlugin;

/**
 * An implementation of the {@link org.dominokit.domino.ui.datatable.store.DataStore} that wraps an
 * in-memory/local list of records allowing the data table to use features like pagination and
 * sorting and will keep load data into the data table in append mode as we scroll to the bottom of
 * the data table
 *
 * @param <T> the type of the data table records
 */
public class LocalListScrollingDataSource<T> implements DataStore<T> {

  private final List<T> original;
  private List<T> filtered = new ArrayList<>();
  private final int pageSize;
  private int pageIndex = 0;
  private List<StoreDataChangeListener<T>> listeners = new ArrayList<>();
  private SearchFilter<T> searchFilter;
  private RecordsSorter<T> recordsSorter;
  private SortEvent<T> lastSort;

  /**
   * Creates and instance with a custom page size and empty data list
   *
   * @param pageSize int, Page size
   */
  public LocalListScrollingDataSource(int pageSize) {
    this.original = new ArrayList<>();
    this.pageSize = pageSize;
  }

  /**
   * Creates and instance with an initial data list and a custom page size
   *
   * @param data {@link java.util.List} of records
   * @param pageSize int
   */
  public LocalListScrollingDataSource(List<T> data, int pageSize) {
    this.original = data;
    this.pageSize = pageSize;
    this.filtered.addAll(data);
  }

  /**
   * Getter for the field <code>searchFilter</code>.
   *
   * @return a reference to the current applied {@link
   *     org.dominokit.domino.ui.datatable.store.SearchFilter} if exists, otherwise return null
   */
  public SearchFilter<T> getSearchFilter() {
    return searchFilter;
  }

  /**
   * Sets a search filter, when ever the data store receives a {@link
   * org.dominokit.domino.ui.datatable.events.SearchEvent} it will use this search filter to filter
   * the data list
   *
   * @param searchFilter {@link org.dominokit.domino.ui.datatable.store.SearchFilter}
   * @return same instance
   */
  public LocalListScrollingDataSource<T> setSearchFilter(SearchFilter<T> searchFilter) {
    this.searchFilter = searchFilter;
    return this;
  }

  /** @return the {@link RecordsSorter} used in this data store */
  /**
   * Getter for the field <code>recordsSorter</code>.
   *
   * @return a {@link org.dominokit.domino.ui.datatable.store.RecordsSorter} object
   */
  public RecordsSorter<T> getRecordsSorter() {
    return recordsSorter;
  }

  /**
   * Sets the records sorting for this data store
   *
   * @param recordsSorter {@link org.dominokit.domino.ui.datatable.store.RecordsSorter}
   * @return same instance
   */
  public LocalListScrollingDataSource<T> setRecordsSorter(RecordsSorter<T> recordsSorter) {
    this.recordsSorter = recordsSorter;
    return this;
  }

  /**
   * sets new data list overriding the existing one, and clears all filters, then loads it in the
   * data table
   *
   * @param data the new {@link java.util.List} of records
   */
  public void setData(List<T> data) {
    this.original.clear();
    this.original.addAll(data);
    this.filtered.clear();
    this.filtered.addAll(original);
  }

  /** {@inheritDoc} */
  @Override
  public void onDataChanged(StoreDataChangeListener<T> dataChangeListener) {
    listeners.add(dataChangeListener);
  }

  /** {@inheritDoc} */
  @Override
  public void removeDataChangeListener(StoreDataChangeListener<T> dataChangeListener) {
    listeners.remove(dataChangeListener);
  }

  /** {@inheritDoc} */
  @Override
  public void load() {
    pageIndex = 0;
    fireUpdate(false);
  }

  private void fireUpdate(boolean append) {
    int fromIndex = pageSize * pageIndex;
    int toIndex = Math.min(fromIndex + pageSize, filtered.size());

    listeners.forEach(
        dataChangeListener ->
            dataChangeListener.onDataChanged(
                new DataChangedEvent<>(
                    new ArrayList<>(filtered.subList(fromIndex, toIndex)),
                    append,
                    filtered.size())));
  }

  /**
   * {@inheritDoc} this store will listen to the following events
   *
   * <pre>BodyScrollEvent</pre>
   *
   * <pre>SortEvent</pre>
   *
   * <pre>TablePageChangeEvent</pre>
   */
  @Override
  public void handleEvent(TableEvent event) {
    switch (event.getType()) {
      case BODY_SCROLL:
        onBodyScroll((BodyScrollEvent) event);
        break;
      case SORT_EVENT:
        onSort((SortEvent<T>) event);
        break;
      case SEARCH_EVENT:
        onSearch((SearchEvent) event);
        break;
    }
  }

  private void onBodyScroll(BodyScrollEvent bodyScrollEvent) {
    if (BodyScrollPlugin.ScrollPosition.BOTTOM.equals(bodyScrollEvent.getScrollPosition())) {
      int nextIndex = pageIndex + 1;
      int fromIndex = nextIndex * pageSize;
      if (fromIndex < filtered.size()) {
        pageIndex++;
        fireUpdate(true);
      }
    }
  }

  private void onSearch(SearchEvent event) {
    if (nonNull(searchFilter)) {
      filtered =
          original.stream()
              .filter(t -> searchFilter.filterRecord(event, t))
              .collect(Collectors.toList());
      if (nonNull(lastSort)) {
        onSort(lastSort);
      } else {
        pageIndex = 0;
        fireUpdate(false);
      }
    }
  }

  private void onSort(SortEvent<T> event) {
    if (nonNull(this.recordsSorter)) {
      this.lastSort = event;
      filtered.sort(
          recordsSorter.onSortChange(
              event.getColumnConfig().getSortKey(), event.getSortDirection()));
      pageIndex = 0;
      fireUpdate(false);
    }
  }

  /**
   * Getter for the field <code>filtered</code>.
   *
   * @return an immutable list obtained from the data records from the data store that match the
   *     current applied filters
   */
  public List<T> getFiltered() {
    return new ArrayList<>(filtered);
  }
}
