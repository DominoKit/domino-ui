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
import static org.dominokit.domino.ui.datatable.events.RecordDraggedOutEvent.RECORD_DRAGGED_OUT;
import static org.dominokit.domino.ui.datatable.events.RecordDroppedEvent.RECORD_DROPPED;
import static org.dominokit.domino.ui.datatable.events.SearchEvent.SEARCH_EVENT;
import static org.dominokit.domino.ui.datatable.events.SortEvent.SORT_EVENT;
import static org.dominokit.domino.ui.datatable.events.TablePageChangeEvent.PAGINATION_EVENT;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.dominokit.domino.ui.datatable.events.*;
import org.dominokit.domino.ui.datatable.plugins.pagination.SortDirection;
import org.dominokit.domino.ui.pagination.HasPagination;

/**
 * The {@code LocalListDataStore} class represents a local data store for a DataTable, where data is
 * loaded and managed within the client-side application.
 *
 * @param <T> The type of data representing the records in the data table.
 */
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

  /**
   * Constructs a new {@code LocalListDataStore} with an empty original data list and filtered data
   * list.
   */
  public LocalListDataStore() {
    this.original = new ArrayList<>();
    this.filtered = new ArrayList<>();
  }

  /**
   * Constructs a new {@code LocalListDataStore} with the provided data as the original data list.
   *
   * @param data The list of data records.
   */
  public LocalListDataStore(List<T> data) {
    this.original = data;
    this.filtered = new ArrayList<>(data);
  }

  /**
   * Sets the data for this data store. Clears the original and filtered data lists and loads the
   * new data.
   *
   * @param data The list of data records.
   */
  public void setData(List<T> data) {
    this.original.clear();
    this.original.addAll(data);
    this.filtered.clear();
    this.filtered.addAll(original);
    load();
  }

  /**
   * Gets the search filter used for filtering records.
   *
   * @return The search filter.
   */
  public SearchFilter<T> getSearchFilter() {
    return searchFilter;
  }

  /**
   * Sets the search filter used for filtering records.
   *
   * @param searchFilter The search filter.
   * @return This data store instance.
   */
  public LocalListDataStore<T> setSearchFilter(SearchFilter<T> searchFilter) {
    this.searchFilter = searchFilter;
    return this;
  }

  /**
   * Sets whether auto-sorting is enabled for this data store.
   *
   * @param autoSort {@code true} to enable auto-sorting, {@code false} otherwise.
   * @return This data store instance.
   */
  public LocalListDataStore<T> setAutoSort(boolean autoSort) {
    this.autoSort = autoSort;
    return this;
  }

  /**
   * Sets the column key for auto-sorting.
   *
   * @param autoSortBy The column key for auto-sorting.
   * @return This data store instance.
   */
  public LocalListDataStore<T> setAutoSortBy(String autoSortBy) {
    this.autoSortBy = autoSortBy;
    return this;
  }

  /**
   * Sets the sorting direction for auto-sorting.
   *
   * @param autoSortDirection The sorting direction for auto-sorting.
   * @return This data store instance.
   */
  public LocalListDataStore<T> setAutoSortDirection(SortDirection autoSortDirection) {
    this.autoSortDirection = autoSortDirection;
    return this;
  }

  /**
   * Gets the pagination component associated with this data store.
   *
   * @return The pagination component.
   */
  public HasPagination getPagination() {
    return pagination;
  }

  /**
   * Sets the pagination component for this data store.
   *
   * @param pagination The pagination component.
   * @return This data store instance.
   */
  public LocalListDataStore<T> setPagination(HasPagination pagination) {
    this.pagination = pagination;
    return this;
  }

  /**
   * Gets the records sorter used for sorting records.
   *
   * @return The records sorter.
   */
  public RecordsSorter<T> getRecordsSorter() {
    return recordsSorter;
  }

  /**
   * Sets the records sorter used for sorting records. Also sets the sorting function to the default
   * list sorting.
   *
   * @param recordsSorter The records sorter.
   * @return This data store instance.
   */
  public LocalListDataStore<T> setRecordsSorter(RecordsSorter<T> recordsSorter) {
    setRecordsSorter(recordsSorter, List::sort);
    return this;
  }

  /**
   * Sets the records sorter used for sorting records along with a custom sorting function.
   *
   * @param recordsSorter The records sorter.
   * @param sortFunction The custom sorting function.
   * @return This data store instance.
   */
  public LocalListDataStore<T> setRecordsSorter(
      RecordsSorter<T> recordsSorter, SortFunction<T> sortFunction) {
    this.recordsSorter = recordsSorter;
    this.sortFunction = sortFunction;
    return this;
  }

  /**
   * An interface for defining custom sorting logic for records.
   *
   * @param <T> The type of data representing the records in the data store.
   */
  public interface SortFunction<T> {
    /**
     * Sorts a list of items using a custom comparator.
     *
     * @param items The list of items to be sorted.
     * @param comparator The comparator used for sorting.
     */
    void sort(List<T> items, Comparator<T> comparator);
  }

  /** Updates the pagination based on the total number of original records. */
  private void updatePagination() {
    if (nonNull(getPagination()) && nonNull(original)) {
      this.getPagination().updatePagesByTotalCount(this.original.size());
    }
  }

  /**
   * Registers a data change listener to be notified when data changes.
   *
   * @param dataChangeListener The data change listener to register.
   */
  @Override
  public void onDataChanged(StoreDataChangeListener<T> dataChangeListener) {
    listeners.add(dataChangeListener);
  }

  /**
   * Removes a registered data change listener.
   *
   * @param dataChangeListener The data change listener to remove.
   */
  @Override
  public void removeDataChangeListener(StoreDataChangeListener<T> dataChangeListener) {
    listeners.remove(dataChangeListener);
  }

  /**
   * Handles various table-related events such as search, sort, pagination, and record manipulation.
   *
   * @param event The table event to handle.
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

  /**
   * Handles the event when a record is dragged out of the data store.
   *
   * @param event The record dragged out event.
   */
  private void handleDraggedOutEvent(RecordDraggedOutEvent<T> event) {
    T rowToRemove = event.getDraggedOutRecord();

    dragDropRecordActions.onDraggedOut(rowToRemove);

    fireUpdate(true);
  }

  /**
   * Handles the event when a record is dropped onto another record.
   *
   * @param event The record dropped event.
   */
  private void handleDropEvent(RecordDroppedEvent<T> event) {
    T movedRow = event.getDroppedRecord();
    T targetRow = event.getTargetRecord();

    dragDropRecordActions.onDropped(movedRow, targetRow);

    fireUpdate(true);
  }

  /**
   * Handles the event when a search is performed.
   *
   * @param event The search event.
   */
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

  /**
   * Handles the event when a sorting action is performed.
   *
   * @param event The sort event.
   */
  private void onSortChanged(SortEvent<T> event) {
    if (nonNull(this.getRecordsSorter())) {
      setLastSort(event);
      sort(event);
      fireUpdate(false);
    }
  }

  /**
   * Sets the last sorting event.
   *
   * @param event The last sort event.
   */
  protected void setLastSort(SortEvent<T> event) {
    this.lastSort = event;
  }

  /**
   * Gets the last sorting event.
   *
   * @return The last sort event.
   */
  public SortEvent<T> getLastSort() {
    return lastSort;
  }

  /**
   * Sets the last search event.
   *
   * @param event The last search event.
   */
  protected void setLastSearch(SearchEvent event) {
    this.lastSearch = event;
  }

  /**
   * Gets the last search event.
   *
   * @return The last search event.
   */
  public SearchEvent getLastSearch() {
    return this.lastSearch;
  }

  /**
   * Sorts the filtered records based on the given sorting event.
   *
   * @param event The sorting event containing sort information.
   */
  public void sort(SortEvent<T> event) {
    getSortFunction()
        .sort(
            filtered,
            getRecordsSorter()
                .onSortChange(event.getColumnConfig().getSortKey(), event.getSortDirection()));
  }

  /**
   * Gets the sort function used for sorting records.
   *
   * @return The sort function.
   */
  public SortFunction<T> getSortFunction() {
    return this.sortFunction;
  }

  /**
   * Loads the first page of data if pagination is enabled and updates the data store. This method
   * is typically called when search or sorting criteria change.
   */
  protected void loadFirstPage() {
    if (nonNull(getPagination())) {
      getPagination().updatePagesByTotalCount(filtered.size());
    }
    fireUpdate(true);
  }

  /**
   * Handles the event when the active page in pagination changes, triggering a data update. This
   * method is called when pagination is enabled.
   */
  private void onPageChanged() {
    fireUpdate(true);
  }

  /**
   * Initiates the data loading process. This method is typically called to initially load or reload
   * the data. It triggers a data update.
   */
  @Override
  public void load() {
    fireUpdate(true);
    updatePagination();
  }

  /**
   * Checks if auto-sorting is enabled.
   *
   * @return {@code true} if auto-sort is enabled, {@code false} otherwise.
   */
  public boolean isAutoSort() {
    return autoSort;
  }

  /**
   * Gets the key used for auto-sorting.
   *
   * @return The key used for auto-sorting.
   */
  public String getAutoSortBy() {
    return autoSortBy;
  }

  /**
   * Gets the auto-sort direction.
   *
   * @return The auto-sort direction (ascending or descending).
   */
  public SortDirection getAutoSortDirection() {
    return autoSortDirection;
  }

  /**
   * Checks if auto-sort has been applied.
   *
   * @return {@code true} if auto-sort has been applied, {@code false} otherwise.
   */
  public boolean isAutoSortApplied() {
    return autoSortApplied;
  }

  /**
   * Sets a custom sort function to be used for sorting records.
   *
   * @param sortFunction The custom sort function.
   */
  public void setSortFunction(SortFunction<T> sortFunction) {
    this.sortFunction = sortFunction;
  }

  /**
   * Sets whether auto-sort has been applied.
   *
   * @param autoSortApplied {@code true} if auto-sort has been applied, {@code false} otherwise.
   */
  protected void setAutoSortApplied(boolean autoSortApplied) {
    this.autoSortApplied = autoSortApplied;
  }

  /**
   * Fires a data update event to all registered data change listeners. Optionally, applies sorting
   * to the updated data.
   *
   * @param applySort {@code true} to apply sorting to the updated data, {@code false} to skip
   *     sorting.
   */
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

  /**
   * Retrieves the subset of records that need to be updated based on the current pagination
   * settings. If pagination is disabled, it returns a copy of the entire filtered list.
   *
   * @return A list of records to be updated.
   */
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
   * Adds a single record to the data store, updating both the original and filtered lists.
   *
   * @param record The record to be added.
   */
  public void addRecord(T record) {
    original.add(record);
    List<T> newData = new ArrayList<>(original);
    setData(newData);
  }

  /**
   * Removes a single record from the data store, updating both the original and filtered lists.
   *
   * @param record The record to be removed.
   */
  public void removeRecord(T record) {
    if (original.contains(record)) {
      original.remove(record);
      filtered.remove(record);
      load();
    }
  }

  /**
   * Updates a single record in the data store by replacing it with a new record, updating both the
   * original and filtered lists.
   *
   * @param record The new record to replace the existing record.
   */
  public void updateRecord(T record) {
    updateRecord(original.indexOf(record), record);
  }

  /**
   * Updates a single record in the data store at a specified index, updating both the original and
   * filtered lists.
   *
   * @param index The index of the record to be updated.
   * @param record The new record to replace the existing record.
   */
  public void updateRecord(int index, T record) {
    internalUpdate(index, record, true);
  }

  /**
   * Updates multiple records in the data store, updating both the original and filtered lists.
   *
   * @param records A collection of new records to replace the existing records.
   */
  public void updateRecords(Collection<T> records) {
    for (T record : records) {
      internalUpdate(original.indexOf(record), record, false);
    }
    load();
  }

  /**
   * Updates multiple records in the data store starting from a specified index, updating both the
   * original and filtered lists.
   *
   * @param startIndex The starting index for updating records.
   * @param records A collection of new records to replace the existing records.
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

  /**
   * Internal method to update a single record at a specified index, updating both the original and
   * filtered lists.
   *
   * @param index The index of the record to be updated.
   * @param record The new record to replace the existing record.
   * @param load Specifies whether to trigger a data load after the update.
   */
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
   * Adds multiple records to the data store, updating both the original and filtered lists.
   *
   * @param records A collection of records to be added.
   */
  public void addRecords(Collection<T> records) {
    original.addAll(records);
    List<T> newData = new ArrayList<>(original);
    setData(newData);
  }

  /**
   * Deprecated method to remove multiple records from the data store, updating both the original
   * and filtered lists.
   *
   * @param records A collection of records to be removed.
   * @deprecated Use {@link #removeRecords(Collection)} instead.
   */
  @Deprecated
  public void removeRecord(Collection<T> records) {
    original.removeAll(records);
    filtered.removeAll(records);
    load();
  }

  /**
   * Removes multiple records from the data store, updating both the original and filtered lists.
   *
   * @param records A collection of records to be removed.
   */
  public void removeRecords(Collection<T> records) {
    original.removeAll(records);
    filtered.removeAll(records);
    load();
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
   * Retrieves a copy of the filtered list of records in the data store, which represents the
   * current view based on search and pagination settings.
   *
   * @return A list of filtered records.
   */
  public List<T> getFilteredRecords() {
    return new ArrayList<>(filtered);
  }

  /**
   * Sets the actions for drag-and-drop operations on records within the data store.
   *
   * @param dragDropRecordActions The implementation of drag-and-drop actions for records.
   */
  public void setDragDropRecordActions(DragDropRecordActions<T> dragDropRecordActions) {
    this.dragDropRecordActions = dragDropRecordActions;
  }

  /**
   * An interface defining actions for handling drag-and-drop operations on records within the data
   * store.
   *
   * @param <T> The type of records in the data store.
   */
  public interface DragDropRecordActions<T> {
    /**
     * Invoked when a record is dropped onto a target record within the data store.
     *
     * @param droppedRecord The record that was dropped.
     * @param target The target record onto which the dropped record was placed.
     */
    void onDropped(T droppedRecord, T target);

    /**
     * Invoked when a record is dragged out of the data store.
     *
     * @param draggedOutRecord The record that was dragged out.
     */
    void onDraggedOut(T draggedOutRecord);
  }
}
