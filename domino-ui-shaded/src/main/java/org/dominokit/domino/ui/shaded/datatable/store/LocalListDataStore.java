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
package org.dominokit.domino.ui.shaded.datatable.store;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.shaded.datatable.events.RecordDraggedOutEvent.RECORD_DRAGGED_OUT;
import static org.dominokit.domino.ui.shaded.datatable.events.RecordDroppedEvent.RECORD_DROPPED;
import static org.dominokit.domino.ui.shaded.datatable.events.SearchEvent.SEARCH_EVENT;
import static org.dominokit.domino.ui.shaded.datatable.events.SortEvent.SORT_EVENT;
import static org.dominokit.domino.ui.shaded.datatable.events.TablePageChangeEvent.PAGINATION_EVENT;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.dominokit.domino.ui.shaded.datatable.events.*;
import org.dominokit.domino.ui.shaded.datatable.plugins.SortDirection;
import org.dominokit.domino.ui.shaded.pagination.HasPagination;

/**
 * An implementation of the {@link DataStore} that wraps an in-memory/local list of records allowing
 * the data table to use features like pagination and sorting
 *
 * @param <T> the type of the data table records
 */
@Deprecated
public class LocalListDataStore<T> implements DataStore<T> {

  private final List<StoreDataChangeListener<T>> listeners = new ArrayList<>();

  protected final List<T> original;
  protected List<T> filtered;
  private HasPagination pagination;
  private SearchFilter<T> searchFilter;
  private RecordsSorter<T> recordsSorter;
  private SortFunction<T> sortFunction;
  private SortEvent<T> lastSort;
  private SearchEvent lastSearch;
  private boolean autoSort = false;
  private String autoSortBy = "*";
  private SortDirection autoSortDirection = SortDirection.ASC;
  private boolean autoSortApplied = false;

  private DragDropRecordActions<T> dragDropRecordActions =
      new DragDropRecordActions<T>() {
        @Override
        public void onDropped(T droppedRecord, T target) {
          int movedIndex = filtered.indexOf(droppedRecord);
          int targetIndex = filtered.size();
          if (nonNull(target)) {
            targetIndex = filtered.indexOf(target);
          }
          if (movedIndex > -1) {
            filtered.remove(movedIndex);
          }
          if (targetIndex > -1) {
            filtered.add(targetIndex, droppedRecord);
          }
        }

        @Override
        public void onDraggedOut(T draggedOutRecord) {
          int removedIndex = filtered.indexOf(draggedOutRecord);
          if (removedIndex > -1) {
            filtered.remove(removedIndex);
          }
        }
      };

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
   * @param autoSort if true the data store will automatically sort the data list before loading it
   *     into the data table
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
    setRecordsSorter(recordsSorter, List::sort);
    return this;
  }

  public LocalListDataStore<T> setRecordsSorter(
      RecordsSorter<T> recordsSorter, SortFunction<T> sortFunction) {
    this.recordsSorter = recordsSorter;
    this.sortFunction = sortFunction;
    return this;
  }

  @Deprecated
  public interface SortFunction<T> {
    void sort(List<T> items, Comparator<T> comparator);
  }

  private void updatePagination() {
    if (nonNull(getPagination()) && nonNull(original)) {
      this.getPagination().updatePagesByTotalCount(this.original.size());
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
      case RECORD_DROPPED:
        handleDropEvent((RecordDroppedEvent<T>) event);
        break;
      case RECORD_DRAGGED_OUT:
        handleDraggedOutEvent((RecordDraggedOutEvent<T>) event);
        break;
    }
  }

  private void handleDraggedOutEvent(RecordDraggedOutEvent<T> event) {
    T rowToRemove = event.getDraggedOutRecord();

    dragDropRecordActions.onDraggedOut(rowToRemove);

    fireUpdate(true);
  }

  private void handleDropEvent(RecordDroppedEvent<T> event) {
    T movedRow = event.getDroppedRecord();
    T targetRow = event.getTargetRecord();

    dragDropRecordActions.onDropped(movedRow, targetRow);

    fireUpdate(true);
  }

  public void onSearchChanged(SearchEvent event) {
    if (nonNull(getSearchFilter())) {
      setLastSearch(event);
      filtered =
          original.stream()
              .filter(record -> getSearchFilter().filterRecord(event, record))
              .collect(Collectors.toList());
      if (nonNull(getLastSort())) {
        sort(getLastSort());
      }
      loadFirstPage();
    }
  }

  private void onSortChanged(SortEvent<T> event) {
    if (nonNull(this.getRecordsSorter())) {
      setLastSort(event);
      sort(event);
      fireUpdate(false);
    }
  }

  protected void setLastSort(SortEvent<T> event) {
    this.lastSort = event;
  }

  public SortEvent<T> getLastSort() {
    return lastSort;
  }

  protected void setLastSearch(SearchEvent event) {
    this.lastSearch = event;
  }

  public SearchEvent getLastSearch() {
    return this.lastSearch;
  }

  public void sort(SortEvent<T> event) {
    getSortFunction()
        .sort(
            filtered,
            getRecordsSorter()
                .onSortChange(event.getColumnConfig().getSortKey(), event.getSortDirection()));
  }

  public SortFunction<T> getSortFunction() {
    return this.sortFunction;
  }

  protected void loadFirstPage() {
    if (nonNull(getPagination())) {
      getPagination().updatePagesByTotalCount(filtered.size());
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

  public boolean isAutoSort() {
    return autoSort;
  }

  public String getAutoSortBy() {
    return autoSortBy;
  }

  public SortDirection getAutoSortDirection() {
    return autoSortDirection;
  }

  public boolean isAutoSortApplied() {
    return autoSortApplied;
  }

  public void setSortFunction(SortFunction<T> sortFunction) {
    this.sortFunction = sortFunction;
  }

  protected void setAutoSortApplied(boolean autoSortApplied) {
    this.autoSortApplied = autoSortApplied;
  }

  private void fireUpdate(boolean applySort) {
    List<T> updateRecords = getUpdateRecords();
    if (applySort) {
      if (nonNull(getLastSort()) && nonNull(getRecordsSorter())) {
        updateRecords.sort(
            getRecordsSorter()
                .onSortChange(
                    getLastSort().getColumnConfig().getSortKey(),
                    getLastSort().getSortDirection()));
      } else if (isAutoSort() && nonNull(getRecordsSorter())) {
        updateRecords.sort(
            getRecordsSorter().onSortChange(getAutoSortBy(), getAutoSortDirection()));
      }
    }
    if (!isAutoSortApplied()) {
      setAutoSortApplied(true);
      listeners.forEach(
          dataChangeListener ->
              dataChangeListener.onDataChanged(
                  new DataChangedEvent<>(
                      updateRecords, filtered.size(), getAutoSortDirection(), getAutoSortBy())));
    } else {
      listeners.forEach(
          dataChangeListener ->
              dataChangeListener.onDataChanged(
                  new DataChangedEvent<>(updateRecords, filtered.size())));
    }
  }

  private List<T> getUpdateRecords() {
    if (nonNull(getPagination())) {
      int fromIndex = getPagination().getPageSize() * (getPagination().activePage() - 1);
      int toIndex = Math.min(fromIndex + getPagination().getPageSize(), filtered.size());
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
   * updates existing record from the current list and updates the data table accordingly
   *
   * @param record T the record being updated
   */
  public void updateRecord(T record) {
    updateRecord(original.indexOf(record), record);
  }

  /**
   * updates a single record at a specific index in the current list and updates the data table
   * accordingly
   *
   * @param record T the record being updated
   * @param index the index of the record to be updated
   */
  public void updateRecord(int index, T record) {
    internalUpdate(index, record, true);
  }

  /**
   * updates existing records from the current list and updates the data table accordingly
   *
   * @param records records to be updated
   */
  public void updateRecords(Collection<T> records) {
    for (T record : records) {
      internalUpdate(original.indexOf(record), record, false);
    }
    load();
  }

  /**
   * updates records from the current list starting from a specific index and updates the data table
   * accordingly
   *
   * <p>While updating the records, if the index is out of range then the process will stop.
   *
   * @param records records to be updated
   */
  public void updateRecords(int startIndex, Collection<T> records) {
    for (T record : records) {
      if (startIndex >= original.size()) {
        break;
      }
      internalUpdate(startIndex++, record, false);
    }
    load();
  }

  private void internalUpdate(int index, T record, boolean load) {
    if (index >= 0 && index < original.size()) {
      T oldRecord = original.get(index);
      original.set(index, record);
      if (filtered.contains(oldRecord)) {
        filtered.set(filtered.indexOf(oldRecord), record);
      }
      if (load) {
        load();
      }
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

  /** @deprecated use {@link #removeRecords} */
  @Deprecated
  public void removeRecord(Collection<T> records) {
    original.removeAll(records);
    filtered.removeAll(records);
    load();
  }

  /**
   * removes a list of records from the current list and updates the data table accordingly
   *
   * @param records {@link Collection} of records
   */
  public void removeRecords(Collection<T> records) {
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

  /** @param dragDropRecordActions the {@link DragDropRecordActions} handler */
  public void setDragDropRecordActions(DragDropRecordActions<T> dragDropRecordActions) {
    this.dragDropRecordActions = dragDropRecordActions;
  }

  /**
   * An interface that allows applying actions on a record such as moving and removing it
   *
   * @param <T> the type of the data table records
   */
  @Deprecated
  public interface DragDropRecordActions<T> {
    /**
     * On record gets dropped to a target
     *
     * @param droppedRecord the record to be moved
     * @param target the target record to move to
     */
    void onDropped(T droppedRecord, T target);

    /**
     * On record gets dragged out
     *
     * @param draggedOutRecord the record to remove
     */
    void onDraggedOut(T draggedOutRecord);
  }
}
