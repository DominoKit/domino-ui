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
 * An event class representing the expansion of a tree row in a data table.
 *
 * @param <T> The type of data in the table row.
 */
public class TreeRowExpandedEvent<T> implements TableEvent {

  /** The event type indicating the expansion of a tree row. */
  public static final String TREE_ROW_EXPANDED_EVENT = "tree-row-expanded-event";

  private final TableRow<T> tableRow;

  /**
   * Constructs a new TreeRowExpandedEvent.
   *
   * @param tableRow The TableRow that was expanded.
   */
  public TreeRowExpandedEvent(TableRow<T> tableRow) {
    this.tableRow = tableRow;
  }

  /**
   * Gets the type of this event, which is {@code TREE_ROW_EXPANDED_EVENT}.
   *
   * @return The type of this event.
   */
  @Override
  public String getType() {
    return TREE_ROW_EXPANDED_EVENT;
  }

  /**
   * Gets the TableRow that was expanded.
   *
   * @return The TableRow that was expanded.
   */
  public TableRow<T> getTableRow() {
    return tableRow;
  }
}
