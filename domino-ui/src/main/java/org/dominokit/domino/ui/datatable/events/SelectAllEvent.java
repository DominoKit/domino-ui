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

@Deprecated
public class SelectAllEvent<T> implements TableEvent {

  public static final String SELECT_ALL_EVENT = "dui-table-select-all-event";

  private final boolean selectAll;
  private final SelectionCondition<T> selectionCondition;

  public SelectAllEvent(boolean selectAll, SelectionCondition<T> selectionCondition) {
    this.selectAll = selectAll;
    this.selectionCondition = selectionCondition;
  }

  public static final <T> SelectAllEvent of(
      boolean selectDeselect, SelectionCondition<T> selectionCondition) {
    return new SelectAllEvent(selectDeselect, selectionCondition);
  }

  public boolean isSelectAll() {
    return selectAll;
  }

  public SelectionCondition<T> getSelectionCondition() {
    return selectionCondition;
  }

  @Override
  public String getType() {
    return SELECT_ALL_EVENT;
  }
}
