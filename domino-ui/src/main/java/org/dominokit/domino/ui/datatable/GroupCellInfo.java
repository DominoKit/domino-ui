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
package org.dominokit.domino.ui.datatable;

import elemental2.dom.Element;
import elemental2.dom.HTMLTableCellElement;
import org.dominokit.domino.ui.IsElement;

public class GroupCellInfo<T> extends CellInfo<T, HTMLTableCellElement, GroupCellInfo<T>> {

  private final Element groupBody;
  private final TableRow<T> groupHeaderRow;

  public GroupCellInfo(
      TableRow<T> tableRow, HTMLTableCellElement element, IsElement<? extends Element> groupBody) {
    this(tableRow, tableRow, element, groupBody);
  }

  public GroupCellInfo(
      TableRow<T> tableRow,
      TableRow<T> groupHeaderRow,
      HTMLTableCellElement element,
      IsElement<? extends Element> groupBody) {
    super(tableRow, element);
    this.groupHeaderRow = groupHeaderRow;
    this.groupBody = groupBody.element();
  }

  /** Returns the generated row that contains this group's header cell. */
  public TableRow<T> getGroupHeaderRow() {
    return groupHeaderRow;
  }

  @Override
  public Element getStyleTarget() {
    return this.element();
  }

  @Override
  public Element getAppendTarget() {
    return groupBody;
  }
}
