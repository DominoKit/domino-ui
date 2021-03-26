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
import static org.dominokit.domino.ui.datatable.events.SearchEvent.SEARCH_EVENT;
import static org.dominokit.domino.ui.datatable.events.SortEvent.SORT_EVENT;
import static org.dominokit.domino.ui.datatable.events.TablePageChangeEvent.PAGINATION_EVENT;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.dominokit.domino.ui.datatable.events.SearchEvent;
import org.dominokit.domino.ui.datatable.events.SortEvent;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.datatable.plugins.SortDirection;
import org.dominokit.domino.ui.pagination.HasPagination;

/**
 * An implementation of the {@link DataStore} that wraps an in-memory/local list of records allowing
 * the data table to use features like pagination and sorting
 *
 * @param <T> the type of the data table records
 */
public class LocalListDataStore<T> implements DataStore<T> {

  private List<StoreDataChangeListener<T>> listeners = new ArrayList<>();

  private final List<T> original;
  private List<T> filtered;
  private HasPagination pagination;
  private SearchFilter<T> searchFilter;
  private RecordsSorter<T> recordsSorter;
  private SortEvent<T> lastSort;
  private boolean autoSort = false;
  private String autoSortBy = "*";
  private SortDirection autoSortDirection = SortDirection.ASC;
  private boolean autSortApplied = false;

  /** Creates an instance initialized with empty list */
  public LocalListDataStore() {
    this.original = new ArrayList<>();
    this.filtered = new ArrayList<>();
  }

  /**
   * Creates an instance initialized with a custom list of data
   *
   * @param data {@link List} of records
   */
  public LocalListDataStore(List<T> data) {
    this.original = data;
    this.filtered = new ArrayList<>(data);
  }

  /**
   * sets new data list overriding the existing one, and clears all filters, then loads it in the
   * data table
   *
   * @param data the new {@link List} of records
   */
  public void setData(List<T> data) {
    this.original.clear();
    this.original.addAll(data);
    this.filtered.clear();
    this.filtered.addAll(original);
    load();
  }

  /**
   * @return a reference to the current applied {@link SearchFilter} if exists, otherwise return
   *     null
   */
  public SearchFilter<T> getSearchFilter() {
    return searchFilter;
  }

  /**
   * Sets a search filter, when ever the data store receives a {@link SearchEvent} it will use this
   * search filter to filter the data list
   *
   * @param searchFilter {@link SearchFilter}
   * @return same instance
   */
  public LocalListDataStore<T> setSearchFilter(SearchFilter<T> searchFilter) {
    this.searchFilter = searchFilter;
    return this;
  }

  /**
   * @param autoSort if true the data store will automatically sort the data list list before
   *     loading it into the data table
   * @return same instance
   */
  public LocalListDataStore<T> setAutoSort(boolean autoSort) {
    this.autoSort = autoSort;
    return this;
  }

  /**
   * set the default column name to initially sort the data list by.
   *
   * @param autoSortBy String, the name of initial sort column
   * @return same instance
   */
  public LocalListDataStore<T> setAutoSortBy(String autoSortBy) {
    this.autoSortBy = autoSortBy;
    return this;
  }

  /**
   * set the default sort direction to initially sort the data list by.
   *
   * @param autoSortDirection {@link SortDirection}
   * @return same instance
   */
  public LocalListDataStore<T> setAutoSortDirection(SortDirection autoSortDirection) {
    this.autoSortDirection = autoSortDirection;
    return this;
  }

  /** @return the {@link HasPagination} component used in this data store */
  public HasPagination getPagination() {
    return pagination;
  }

  /**
   * set the pagination component to be used by the data store
   *
   * @param pagination {@link HasPagination}
   * @return same instance
   */
  public LocalListDataStore<T> setPagination(HasPagination pagination) {
    this.pagination = pagination;
    return this;
  }

  /** @return the {@link RecordsSorter} used in this data store */
  public RecordsSorter<T> getRecordsSorter() {
    return recordsSorter;
  }

  /**
   * Sets the records sorting for this data store
   *
   * @param recordsSorter {@link RecordsSorter}
   * @return same instance
   */
  public LocalListDataStore<T> setRecordsSorter(RecordsSorter<T> recordsSorter) {
    this.recordsSorter = recordsSorter;
    return this;
  }

  private void updatePagination() {
    if (nonNull(pagination) && nonNull(original)) {
      this.pagination.updatePagesByTotalCount(this.original.size());
    }
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

  /**
   * {@inheritDoc} this store will listen to the following events
   *
   * <pre>SearchEvent</pre>
   *
   * <pre>SortEvent</pre>
   *
   * <pre>TablePageChangeEvent</pre>
   */
  @Override
  public void handleEvent(TableEvent event) {
    switch (event.getType()) {
      case SEARCH_EVENT:
        onSearchChanged((SearchEvent) event);
        break;
      case SORT_EVENT:
        onSortChanged((SortEvent) event);
        break;
      case PAGINATION_EVENT:
        onPageChanged();
        break;
    }
  }

  private void onSearchChanged(SearchEvent event) {
    if (nonNull(searchFilter)) {
      filtered =
          original.stream()
              .filter(record -> searchFilter.filterRecord(event, record))
              .collect(Collectors.toList());
      if (nonNull(lastSort)) {
        sort(lastSort);
      }
      loadFirstPage();
    }
  }

  private void onSortChanged(SortEvent<T> event) {
    if (nonNull(this.recordsSorter)) {
      this.lastSort = event;
      sort(event);
      fireUpdate(false);
    }
  }

  private void sort(SortEvent<T> event) {
    filtered.sort(
        recordsSorter.onSortChange(event.getColumnConfig().getName(), event.getSortDirection()));
  }

  private void loadFirstPage() {
    if (nonNull(pagination)) {
      pagination.updatePagesByTotalCount(filtered.size());
    }
    fireUpdate(true);
  }

  private void onPageChanged() {
    fireUpdate(true);
  }

  /** {@inheritDoc} */
  @Override
  public void load() {
    fireUpdate(true);
    updatePagination();
  }

  private void fireUpdate(boolean applySort) {
    List<T> updateRecords = getUpdateRecords();
    if (applySort) {
      if (nonNull(this.lastSort) && nonNull(recordsSorter)) {
        updateRecords.sort(
            recordsSorter.onSortChange(
                this.lastSort.getColumnConfig().getName(), this.lastSort.getSortDirection()));
      } else if (autoSort && nonNull(recordsSorter)) {
        updateRecords.sort(recordsSorter.onSortChange(autoSortBy, autoSortDirection));
      }
    }
    if (!autSortApplied) {
      autSortApplied = true;
      listeners.forEach(
          dataChangeListener ->
              dataChangeListener.onDataChanged(
                  new DataChangedEvent<>(
                      updateRecords, filtered.size(), autoSortDirection, autoSortBy)));
    } else {
      listeners.forEach(
          dataChangeListener ->
              dataChangeListener.onDataChanged(
                  new DataChangedEvent<>(updateRecords, filtered.size())));
    }
  }

  private List<T> getUpdateRecords() {
    if (nonNull(pagination)) {
      int fromIndex = pagination.getPageSize() * (pagination.activePage() - 1);
      int toIndex = Math.min(fromIndex + pagination.getPageSize(), filtered.size());
      return new ArrayList<>(filtered.subList(fromIndex, toIndex));
    } else {
      return new ArrayList<>(filtered);
    }
  }

  /**
   * adds a single record to the current list and updates the data table accordingly
   *
   * @param record T the new record being added
   */
  public void addRecord(T record) {
    original.add(record);
    List<T> newData = new ArrayList<>(original);
    setData(newData);
  }

  /**
   * removes a single record from the current list and updates the data table accordingly
   *
   * @param record T the record being removed
   */
  public void removeRecord(T record) {
    if (original.contains(record)) {
      original.remove(record);
      filtered.remove(record);
      load();
    }
  }

  /**
   * adds a list of records to the current list and updates the data table accordingly
   *
   * @param records {@link Collection} of records
   */
  public void addRecords(Collection<T> records) {
    original.addAll(records);
    List<T> newData = new ArrayList<>(original);
    setData(newData);
  }

  /**
   * removes a list of records from the current list and updates the data table accordingly
   *
   * @param records {@link Collection} of records
   */
  public void removeRecord(Collection<T> records) {
    original.removeAll(records);
    filtered.removeAll(records);
    load();
  }

  /** @return an immutable list obtained from the data records from the data store */
  public List<T> getRecords() {
    return new ArrayList<>(original);
  }

  /**
   * @return an immutable list obtained from the data records from the data store that match the
   *     current applied filters
   */
  public List<T> getFilteredRecords() {
    return new ArrayList<>(filtered);
  }
}
