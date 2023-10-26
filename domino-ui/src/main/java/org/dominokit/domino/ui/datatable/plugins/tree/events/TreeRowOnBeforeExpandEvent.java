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

package org.dominokit.domino.ui.datatable.plugins.tree.events;

import org.dominokit.domino.ui.datatable.TableRow;
import org.dominokit.domino.ui.datatable.events.TableEvent;

/**
 * An event that represents the occurrence of a row expanding before it actually expands. This event
 * is triggered when a tree row is about to be expanded.
 *
 * @param <T> The type of data in the DataTable.
 */
public class TreeRowOnBeforeExpandEvent<T> implements TableEvent {

  /** The type of this event, which is {@code TREE_ROW_ON_BEFORE_EXPAND_EVENT}. */
  public static final String TREE_ROW_ON_BEFORE_EXPAND_EVENT = "tree-row-on-before-expand-event";

  /** The table row associated with this event. */
  private final TableRow<T> tableRow;

  /**
   * Creates a new {@code TreeRowOnBeforeExpandEvent} with the given table row.
   *
   * @param tableRow The table row associated with this event.
   */
  public TreeRowOnBeforeExpandEvent(TableRow<T> tableRow) {
    this.tableRow = tableRow;
  }

  /**
   * Gets the type of this event, which is {@code TREE_ROW_ON_BEFORE_EXPAND_EVENT}.
   *
   * @return The type of this event.
   */
  @Override
  public String getType() {
    return TREE_ROW_ON_BEFORE_EXPAND_EVENT;
  }

  /**
   * Gets the table row associated with this event.
   *
   * @return The table row associated with this event.
   */
  public TableRow<T> getTableRow() {
    return tableRow;
  }
}
