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

import java.util.List;
import java.util.Optional;
import org.dominokit.domino.ui.datatable.plugins.SortDirection;

/**
 * This event is fired whenever the data in the data table is changed including the sort
 *
 * @param <T> the type of the data table records
 */
@Deprecated
public class DataChangedEvent<T> {
  private final List<T> newData;
  private final boolean append;
  private final int totalCount;
  private final Optional<SortDirection> sortDir;
  private final Optional<String> sortColumn;

  /**
   * Creates a new instance without sort information
   *
   * @param newData {@link List} of new records
   * @param totalCount int, The total count which may not be equal to the data list size as this
   *     represent the total count of items not just in the current page
   */
  public DataChangedEvent(List<T> newData, int totalCount) {
    this.newData = newData;
    this.totalCount = totalCount;
    this.append = false;
    this.sortDir = Optional.empty();
    this.sortColumn = Optional.empty();
  }

  /**
   * Creates a new instance with sort information
   *
   * @param newData {@link List} of new records
   * @param totalCount int, The total count which may not be equal to the data list size as this
   *     represent the total count of items not just in the current page
   * @param sortDirection the {@link SortDirection}
   * @param sortColumn String, the name of the column we sort by.
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
   * Creates a new instance without sort information
   *
   * @param newData {@link List} of new records
   * @param append boolean, true if the new data should be appended to the old data instead of
   *     replacing it.
   * @param totalCount int, The total count which may not be equal to the data list size as this
   *     represent the total count of items not just in the current page
   */
  public DataChangedEvent(List<T> newData, boolean append, int totalCount) {
    this.newData = newData;
    this.append = append;
    this.totalCount = totalCount;
    this.sortDir = Optional.empty();
    this.sortColumn = Optional.empty();
  }

  /**
   * Creates a new instance with sort information
   *
   * @param newData {@link List} of new records
   * @param append boolean, true if the new data should be appended to the old data instead of
   *     replacing it.
   * @param totalCount int, The total count which may not be equal to the data list size as this
   *     represent the total count of items not just in the current page
   * @param sortDirection the {@link SortDirection}
   * @param sortColumn String, the name of the column we sort by.
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

  /** @return the {@link List} of data */
  public List<T> getNewData() {
    return newData;
  }

  /**
   * @return boolean, true if the new data should be appended to the old data instead of replacing
   *     it.
   */
  public boolean isAppend() {
    return append;
  }

  /**
   * @return int, The total count which may not be equal to the data list size as this represent the
   *     total count of items not just in the current page
   */
  public int getTotalCount() {
    return totalCount;
  }

  /** @return the {@link SortDirection} */
  public Optional<SortDirection> getSortDir() {
    return sortDir;
  }

  /** @return String, the name of the column we sort by. */
  public Optional<String> getSortColumn() {
    return sortColumn;
  }
}
