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
 * TreeStateMeta class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class TreeStateMeta<T> implements ComponentMeta {

  /** Constant <code>TREE_STATE_TABLE_META="tree-state-table-meta"</code> */
  public static final String TREE_STATE_TABLE_META = "tree-state-table-meta";

  private List<T> expandedRecords = new ArrayList<>();
  private List<T> tempExpandedRecords = new ArrayList<>();

  /**
   * create.
   *
   * @param <T> a T class
   * @return a {@link org.dominokit.domino.ui.datatable.plugins.tree.TreeStateMeta} object
   */
  public static <T> TreeStateMeta<T> create() {
    return new TreeStateMeta<>();
  }

  /**
   * get.
   *
   * @param dataTable a {@link org.dominokit.domino.ui.datatable.DataTable} object
   * @param <T> a T class
   * @return a {@link java.util.Optional} object
   */
  public static <T> Optional<TreeStateMeta<T>> get(DataTable<T> dataTable) {
    return dataTable.getMeta(TREE_STATE_TABLE_META);
  }

  /**
   * onRowExpanded.
   *
   * @param tableRow a {@link org.dominokit.domino.ui.datatable.TableRow} object
   */
  public void onRowExpanded(TableRow<T> tableRow) {
    this.expandedRecords.add(tableRow.getRecord());
  }

  /**
   * isRowExpanded.
   *
   * @param tableRow a {@link org.dominokit.domino.ui.datatable.TableRow} object
   * @return a boolean
   */
  public boolean isRowExpanded(TableRow<T> tableRow) {
    return this.expandedRecords.contains(tableRow.getRecord());
  }

  /**
   * onExpandedRowAdded.
   *
   * @param tableRow a {@link org.dominokit.domino.ui.datatable.TableRow} object
   */
  public void onExpandedRowAdded(TableRow<T> tableRow) {
    this.tempExpandedRecords.add(tableRow.getRecord());
  }

  /** onAllRowsAdded. */
  public void onAllRowsAdded() {
    this.expandedRecords.clear();
    this.expandedRecords.addAll(tempExpandedRecords);
    this.tempExpandedRecords.clear();
  }

  /**
   * onRowCollapsed.
   *
   * @param tableRow a {@link org.dominokit.domino.ui.datatable.TableRow} object
   */
  public void onRowCollapsed(TableRow<T> tableRow) {
    this.expandedRecords.remove(tableRow.getRecord());
  }

  /**
   * Getter for the field <code>expandedRecords</code>.
   *
   * @return a {@link java.util.List} object
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
