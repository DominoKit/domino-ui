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
 * The <code>TreeRowCollapsedEvent</code> class represents an event that is triggered when a
 * tree-like structure's row is collapsed in a DataTable.
 *
 * @param <T> The type of data stored in the DataTable.
 */
public class TreeRowCollapsedEvent<T> implements TableEvent {

  /** The key used to identify this event type. */
  public static final String TREE_ROW_COLLAPSED_EVENT = "tree-row-collapsed-event";

  /** The TableRow associated with this event. */
  private final TableRow<T> tableRow;

  /**
   * Creates a new instance of <code>TreeRowCollapsedEvent</code> with the specified TableRow.
   *
   * @param tableRow The TableRow associated with this event.
   */
  public TreeRowCollapsedEvent(TableRow<T> tableRow) {
    this.tableRow = tableRow;
  }

  /**
   * Retrieves the type of this event, which is identified by the constant value {@link
   * TreeRowCollapsedEvent#TREE_ROW_COLLAPSED_EVENT}.
   *
   * @return The type of this event as a string.
   */
  @Override
  public String getType() {
    return TREE_ROW_COLLAPSED_EVENT;
  }

  /**
   * Retrieves the TableRow associated with this event.
   *
   * @return The TableRow associated with this event.
   */
  public TableRow<T> getTableRow() {
    return tableRow;
  }
}
