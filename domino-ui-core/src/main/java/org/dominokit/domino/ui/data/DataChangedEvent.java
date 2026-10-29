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

package org.dominokit.domino.ui.data;

import java.util.List;
import java.util.Optional;
import org.dominokit.domino.ui.datatable.plugins.pagination.SortDirection;

/**
 * The {@code DataChangedEvent} class represents an event that is triggered when data in a data
 * store changes, such as when records are loaded or sorted.
 *
 * @param <T> The type of data representing the records in the data table.
 */
public class DataChangedEvent<T> {
  private final List<T> newData;
  private final boolean append;
  private final int totalCount;
  private final Optional<SortDirection> sortDir;
  private final Optional<String> sortColumn;

  /**
   * Constructs a new {@code DataChangedEvent} with the provided data and total count.
   *
   * @param newData The list of new data records.
   * @param totalCount The total count of records.
   */
  public DataChangedEvent(List<T> newData, int totalCount) {
    this.newData = newData;
    this.totalCount = totalCount;
    this.append = false;
    this.sortDir = Optional.empty();
    this.sortColumn = Optional.empty();
  }

  /**
   * Constructs a new {@code DataChangedEvent} with the provided data, total count, sort direction,
   * and sort column.
   *
   * @param newData The list of new data records.
   * @param totalCount The total count of records.
   * @param sortDirection The sorting direction.
   * @param sortColumn The column used for sorting.
   */
  public DataChangedEvent(
      List<T> newData, int totalCount, SortDirection sortDirection, String sortColumn) {
    this.newData = newData;
    this.totalCount = totalCount;
    this.append = false;
    this.sortDir = Optional.of(sortDirection);
    this.sortColumn = Optional.of(sortColumn);
  }

  /**
   * Constructs a new {@code DataChangedEvent} with the provided data, append flag, and total count.
   *
   * @param newData The list of new data records.
   * @param append {@code true} if the data is being appended to the existing data; {@code false}
   *     otherwise.
   * @param totalCount The total count of records.
   */
  public DataChangedEvent(List<T> newData, boolean append, int totalCount) {
    this.newData = newData;
    this.append = append;
    this.totalCount = totalCount;
    this.sortDir = Optional.empty();
    this.sortColumn = Optional.empty();
  }

  /**
   * Constructs a new {@code DataChangedEvent} with the provided data, append flag, total count,
   * sort direction, and sort column.
   *
   * @param newData The list of new data records.
   * @param append {@code true} if the data is being appended to the existing data; {@code false}
   *     otherwise.
   * @param totalCount The total count of records.
   * @param sortDirection The sorting direction.
   * @param sortColumn The column used for sorting.
   */
  public DataChangedEvent(
      List<T> newData,
      boolean append,
      int totalCount,
      SortDirection sortDirection,
      String sortColumn) {
    this.newData = newData;
    this.append = append;
    this.totalCount = totalCount;
    this.sortDir = Optional.of(sortDirection);
    this.sortColumn = Optional.of(sortColumn);
  }

  /**
   * Gets the list of new data records.
   *
   * @return A list of new data records.
   */
  public List<T> getNewData() {
    return newData;
  }

  /**
   * Checks if the data is being appended to the existing data.
   *
   * @return {@code true} if the data is being appended; {@code false} otherwise.
   */
  public boolean isAppend() {
    return append;
  }

  /**
   * Gets the total count of records.
   *
   * @return The total count of records.
   */
  public int getTotalCount() {
    return totalCount;
  }

  /**
   * Gets the sorting direction, if available.
   *
   * @return An {@code Optional} containing the sorting direction, or empty if not available.
   */
  public Optional<SortDirection> getSortDir() {
    return sortDir;
  }

  /**
   * Gets the column used for sorting, if available.
   *
   * @return An {@code Optional} containing the sort column, or empty if not available.
   */
  public Optional<String> getSortColumn() {
    return sortColumn;
  }
}
