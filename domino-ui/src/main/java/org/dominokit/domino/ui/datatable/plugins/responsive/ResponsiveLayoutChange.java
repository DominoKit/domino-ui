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
package org.dominokit.domino.ui.datatable.plugins.responsive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;

/** An immutable snapshot of a responsive data table layout change. */
public class ResponsiveLayoutChange<T> {

  private final DataTable<T> dataTable;
  private final boolean responsive;
  private final List<ColumnConfig<T>> columnsInDetails;
  private final List<ColumnConfig<T>> columnsMovedToDetails;
  private final List<ColumnConfig<T>> columnsRestoredFromDetails;

  ResponsiveLayoutChange(
      DataTable<T> dataTable,
      boolean responsive,
      List<ColumnConfig<T>> columnsInDetails,
      List<ColumnConfig<T>> columnsMovedToDetails,
      List<ColumnConfig<T>> columnsRestoredFromDetails) {
    this.dataTable = dataTable;
    this.responsive = responsive;
    this.columnsInDetails = immutableCopy(columnsInDetails);
    this.columnsMovedToDetails = immutableCopy(columnsMovedToDetails);
    this.columnsRestoredFromDetails = immutableCopy(columnsRestoredFromDetails);
  }

  /** Returns the table whose responsive layout changed. */
  public DataTable<T> getDataTable() {
    return dataTable;
  }

  /** Returns whether the table is now using its responsive layout. */
  public boolean isResponsive() {
    return responsive;
  }

  /** Returns the columns currently rendered in the details panel, in table column order. */
  public List<ColumnConfig<T>> getColumnsInDetails() {
    return columnsInDetails;
  }

  /** Returns the columns newly moved into details by this layout change. */
  public List<ColumnConfig<T>> getColumnsMovedToDetails() {
    return columnsMovedToDetails;
  }

  /** Returns the columns restored to the table cells by this layout change. */
  public List<ColumnConfig<T>> getColumnsRestoredFromDetails() {
    return columnsRestoredFromDetails;
  }

  private List<ColumnConfig<T>> immutableCopy(List<ColumnConfig<T>> columns) {
    return Collections.unmodifiableList(new ArrayList<>(columns));
  }
}
