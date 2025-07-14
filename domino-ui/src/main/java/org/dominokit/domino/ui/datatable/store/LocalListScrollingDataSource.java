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
import org.dominokit.domino.ui.datatable.plugins.pagination.BodyScrollPlugin;
import org.dominokit.domino.ui.utils.DominoEvent;

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
  private int initialLoadedPages = 1;
  private int pageIndex = 0;
  private List<StoreDataChangeListener<T>> listeners = new ArrayList<>();
  private SearchFilter<T> searchFilter;
  private RecordsSorter<T> recordsSorter;
  private SortEvent<T> lastSort;

  /**
   * Creates a new instance of {@link LocalListScrollingDataSource} with the specified page size.
   *
   * @param pageSize The number of records to load per page.
   */
  public LocalListScrollingDataSource(int pageSize) {
    this.original = new ArrayList<>();
    this.pageSize = pageSize;
  }

  /**
   * Creates a new instance of {@link LocalListScrollingDataSource} with the specified page size.
   *
   * @param pageSize The number of records to load per page.
   * @param initialLoadedPages The number of pages to load in the initial load - page index 0 -.
   */
  public LocalListScrollingDataSource(int pageSize, int initialLoadedPages) {
    this.original = new ArrayList<>();
    this.pageSize = pageSize;
    this.initialLoadedPages = initialLoadedPages;
  }

  /**
   * Creates a new instance of {@link LocalListScrollingDataSource} with the specified page size and
   * initial data.
   *
   * @param data The initial data to populate the data source.
   * @param pageSize The number of records to load per page.
   */
  public LocalListScrollingDataSource(List<T> data, int pageSize) {
    this.original = data;
    this.pageSize = pageSize;
    this.filtered.addAll(data);
  }

  /**
   * Creates a new instance of {@link LocalListScrollingDataSource} with the specified page size and
   * initial data.
   *
   * @param data The initial data to populate the data source.
   * @param pageSize The number of records to load per page.
   * @param initialLoadedPages The number of pages to load in the initial load - page index 0 -.
   */
  public LocalListScrollingDataSource(List<T> data, int pageSize, int initialLoadedPages) {
    this.original = data;
    this.pageSize = pageSize;
    this.initialLoadedPages = initialLoadedPages;
    this.filtered.addAll(data);
  }

  /**
   * Retrieves a copy of records stored in the data store.
   *
   * @return A list of original records.
   */
  public List<T> getRecords() {
    return new ArrayList<>(original);
  }

  /**
   * Gets the search filter currently set for this data source.
   *
   * @return The search filter instance, or {@code null} if no search filter is set.
   */
  public SearchFilter<T> getSearchFilter() {
    return searchFilter;
  }

  /**
   * Sets the search filter to be used for filtering records based on search criteria.
   *
   * @param searchFilter The search filter to apply.
   * @return This data source instance for method chaining.
   */
  public LocalListScrollingDataSource<T> setSearchFilter(SearchFilter<T> searchFilter) {
    this.searchFilter = searchFilter;
    return this;
  }

  /**
   * Gets the records sorter currently set for this data source.
   *
   * @return The records sorter instance, or {@code null} if no records sorter is set.
   */
  public RecordsSorter<T> getRecordsSorter() {
    return recordsSorter;
  }

  /**
   * Sets the records sorter to be used for sorting records based on sorting criteria.
   *
   * @param recordsSorter The records sorter to apply.
   * @return This data source instance for method chaining.
   */
  public LocalListScrollingDataSource<T> setRecordsSorter(RecordsSorter<T> recordsSorter) {
    this.recordsSorter = recordsSorter;
    return this;
  }

  /**
   * Sets the data for the data source. This replaces the current data with the new data.
   *
   * @param data The new data to set for the data source.
   */
  public void setData(List<T> data) {
    this.original.clear();
    this.original.addAll(data);
    this.filtered.clear();
    this.filtered.addAll(original);
    load();
  }

  /**
   * Registers a data change listener to receive updates when the data in the data source changes.
   *
   * @param dataChangeListener The data change listener to register.
   */
  @Override
  public void onDataChanged(StoreDataChangeListener<T> dataChangeListener) {
    listeners.add(dataChangeListener);
  }

  /**
   * Removes a previously registered data change listener.
   *
   * @param dataChangeListener The data change listener to remove.
   */
  @Override
  public void removeDataChangeListener(StoreDataChangeListener<T> dataChangeListener) {
    listeners.remove(dataChangeListener);
  }

  /** Loads data from the data source, resetting the page index and triggering a data update. */
  @Override
  public void load() {
    pageIndex = 0;
    fireUpdate(false);
  }

  private void fireUpdate(boolean append) {
    int fromIndex = pageSize * pageIndex;
    int toIndex = Math.min(getToIndex(fromIndex), filtered.size());

    listeners.forEach(
        dataChangeListener ->
            dataChangeListener.onDataChanged(
                new DataChangedEvent<>(
                    new ArrayList<>(filtered.subList(fromIndex, toIndex)),
                    append,
                    filtered.size())));
  }

  private int getToIndex(int fromIndex) {
    if (pageIndex == 0 && initialLoadedPages > 1) {
      int toIndex = fromIndex + (initialLoadedPages * pageSize);
      pageIndex = initialLoadedPages - 1;
      return toIndex;
    }
    return fromIndex + pageSize;
  }

  /**
   * Handles various table-related events and delegates to specific event handling methods based on
   * the event type.
   *
   * @param event The table event to handle.
   */
  @Override
  public void handleEvent(DominoEvent event) {
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

  /**
   * Handles scrolling events in the data table, specifically when scrolling to the bottom. It
   * increments the page index and triggers an update in append mode if the scroll position is at
   * the bottom.
   *
   * @param bodyScrollEvent The body scroll event to handle.
   */
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

  /**
   * Handles search events in the data table. It filters the data based on the provided search
   * criteria and sorts the filtered data if a previous sorting event occurred. Then, it triggers a
   * data update.
   *
   * @param event The search event to handle.
   */
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

  /**
   * Handles sorting events in the data table. It sorts the data based on the specified sorting
   * criteria and triggers a data update.
   *
   * @param event The sort event to handle.
   */
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
   * Gets the filtered records based on the current filtering criteria.
   *
   * @return A list of filtered records.
   */
  public List<T> getFiltered() {
    return new ArrayList<>(filtered);
  }
}
