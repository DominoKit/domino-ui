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

/** SelectAllEvent class. */
public class SelectAllEvent<T> implements TableEvent {

  /** Constant <code>SELECT_ALL_EVENT="dui-table-select-all-event"</code> */
  public static final String SELECT_ALL_EVENT = "dui-table-select-all-event";

  private final boolean selectAll;
  private final SelectionCondition<T> selectionCondition;

  /**
   * Constructor for SelectAllEvent.
   *
   * @param selectAll a boolean
   * @param selectionCondition a {@link org.dominokit.domino.ui.datatable.SelectionCondition} object
   */
  public SelectAllEvent(boolean selectAll, SelectionCondition<T> selectionCondition) {
    this.selectAll = selectAll;
    this.selectionCondition = selectionCondition;
  }

  /**
   * of.
   *
   * @param selectDeselect a boolean
   * @param selectionCondition a {@link org.dominokit.domino.ui.datatable.SelectionCondition} object
   * @param <T> a T class
   * @return a {@link org.dominokit.domino.ui.datatable.events.SelectAllEvent} object
   */
  public static final <T> SelectAllEvent of(
      boolean selectDeselect, SelectionCondition<T> selectionCondition) {
    return new SelectAllEvent(selectDeselect, selectionCondition);
  }

  /**
   * isSelectAll.
   *
   * @return a boolean
   */
  public boolean isSelectAll() {
    return selectAll;
  }

  /**
   * Getter for the field <code>selectionCondition</code>.
   *
   * @return a {@link org.dominokit.domino.ui.datatable.SelectionCondition} object
   */
  public SelectionCondition<T> getSelectionCondition() {
    return selectionCondition;
  }

  /** {@inheritDoc} */
  @Override
  public String getType() {
    return SELECT_ALL_EVENT;
  }
}
