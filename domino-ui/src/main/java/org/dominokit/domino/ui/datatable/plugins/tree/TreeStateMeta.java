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

package org.dominokit.domino.ui.datatable.plugins.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableRow;
import org.dominokit.domino.ui.utils.ComponentMeta;

/**
 * The <code>TreeStateMeta</code> class is responsible for managing the state of tree-like
 * structures within a DataTable. It keeps track of expanded rows, ensuring their state is
 * preserved.
 *
 * <p>This class allows you to maintain information about which rows are expanded and collapsed in a
 * DataTable with a tree-like structure. You can use it to expand and collapse rows and check their
 * current state.
 *
 * <p>Usage Example:
 *
 * <pre>
 * // Create a TreeStateMeta instance
 * TreeStateMeta&lt;MyData&gt; treeStateMeta = TreeStateMeta.create();
 *
 * // Check if a row is expanded
 * boolean isExpanded = treeStateMeta.isRowExpanded(tableRow);
 *
 * // Expand a row
 * treeStateMeta.onRowExpanded(tableRow);
 * </pre>
 *
 * @param <T> The type of data stored in the DataTable.
 */
public class TreeStateMeta<T> implements ComponentMeta {

  /** The key used to access this metadata. */
  public static final String TREE_STATE_TABLE_META = "tree-state-table-meta";

  /** The list of expanded records. */
  private List<T> expandedRecords = new ArrayList<>();

  /** A temporary list of expanded records. */
  private List<T> tempExpandedRecords = new ArrayList<>();

  /**
   * Creates a new instance of <code>TreeStateMeta</code>.
   *
   * @param <T> The type of data stored in the DataTable.
   * @return A new <code>TreeStateMeta</code> instance.
   */
  public static <T> TreeStateMeta<T> create() {
    return new TreeStateMeta<>();
  }

  /**
   * Retrieves the <code>TreeStateMeta</code> instance associated with a DataTable.
   *
   * @param <T> The type of data stored in the DataTable.
   * @param dataTable The DataTable for which to retrieve the <code>TreeStateMeta</code> instance.
   * @return An {@link Optional} containing the <code>TreeStateMeta</code> instance if found, or an
   *     empty {@link Optional} if not.
   */
  public static <T> Optional<TreeStateMeta<T>> get(DataTable<T> dataTable) {
    return dataTable.getMeta(TREE_STATE_TABLE_META);
  }

  /**
   * Marks a row as expanded.
   *
   * @param tableRow The TableRow to mark as expanded.
   */
  public void onRowExpanded(TableRow<T> tableRow) {
    this.expandedRecords.add(tableRow.getRecord());
  }

  /**
   * Checks if a row is expanded.
   *
   * @param tableRow The TableRow to check.
   * @return {@code true} if the row is expanded, {@code false} otherwise.
   */
  public boolean isRowExpanded(TableRow<T> tableRow) {
    return this.expandedRecords.contains(tableRow.getRecord());
  }

  /**
   * Marks an expanded row as added.
   *
   * @param tableRow The TableRow to mark as added.
   */
  public void onExpandedRowAdded(TableRow<T> tableRow) {
    this.tempExpandedRecords.add(tableRow.getRecord());
  }

  /** Marks all rows as added after all rows have been added. */
  public void onAllRowsAdded() {
    this.expandedRecords.clear();
    this.expandedRecords.addAll(tempExpandedRecords);
    this.tempExpandedRecords.clear();
  }

  /**
   * Marks a row as collapsed.
   *
   * @param tableRow The TableRow to mark as collapsed.
   */
  public void onRowCollapsed(TableRow<T> tableRow) {
    this.expandedRecords.remove(tableRow.getRecord());
  }

  /**
   * Retrieves the list of expanded records.
   *
   * @return A list of expanded records.
   */
  public List<T> getExpandedRecords() {
    return expandedRecords;
  }

  /** {@inheritDoc} */
  @Override
  public String getKey() {
    return TREE_STATE_TABLE_META;
  }
}
