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

package org.dominokit.domino.ui.datatable.events;

import org.dominokit.domino.ui.datatable.SelectionCondition;

/**
 * The {@code SelectAllEvent} class represents an event that occurs when selecting or deselecting
 * all items in a DataTable.
 *
 * @param <T> the type of items in the DataTable
 * @see org.dominokit.domino.ui.datatable.events.TableEvent
 * @see org.dominokit.domino.ui.datatable.SelectionCondition
 */
public class SelectAllEvent<T> implements TableEvent {

  /** The event type for the select all event. */
  public static final String SELECT_ALL_EVENT = "dui-table-select-all-event";

  /** A boolean flag indicating whether to select all items or deselect all items. */
  private final boolean selectAll;

  /** The selection condition to be applied when selecting or deselecting all items. */
  private final SelectionCondition<T> selectionCondition;

  /**
   * Constructs a new {@code SelectAllEvent} with the specified parameters.
   *
   * @param selectAll {@code true} to select all items, {@code false} to deselect all items
   * @param selectionCondition the selection condition to be applied
   */
  public SelectAllEvent(boolean selectAll, SelectionCondition<T> selectionCondition) {
    this.selectAll = selectAll;
    this.selectionCondition = selectionCondition;
  }

  /**
   * Creates a new instance of {@code SelectAllEvent} with the specified parameters.
   *
   * @param <T> the type of items in the DataTable
   * @param selectDeselect {@code true} to select all items, {@code false} to deselect all items
   * @param selectionCondition the selection condition to be applied
   * @return a new instance of {@code SelectAllEvent}
   */
  public static final <T> SelectAllEvent of(
      boolean selectDeselect, SelectionCondition<T> selectionCondition) {
    return new SelectAllEvent(selectDeselect, selectionCondition);
  }

  /**
   * Checks whether the event represents selecting all items.
   *
   * @return {@code true} if selecting all items, {@code false} if deselecting all items
   */
  public boolean isSelectAll() {
    return selectAll;
  }

  /**
   * Retrieves the selection condition to be applied.
   *
   * @return the selection condition
   */
  public SelectionCondition<T> getSelectionCondition() {
    return selectionCondition;
  }

  /**
   * Retrieves the type of this event.
   *
   * @return the event type
   */
  @Override
  public String getType() {
    return SELECT_ALL_EVENT;
  }
}
