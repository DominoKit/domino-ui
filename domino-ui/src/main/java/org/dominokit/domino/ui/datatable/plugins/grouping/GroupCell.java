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
package org.dominokit.domino.ui.datatable.plugins.grouping;

import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

import elemental2.dom.Element;
import elemental2.dom.HTMLTableCellElement;
import org.dominokit.domino.ui.datatable.GroupCellInfo;
import org.dominokit.domino.ui.datatable.TableCell;

public class GroupCell<T>
    extends TableCell<
        T, HTMLTableCellElement, GroupCellInfo<T>, GroupCellRenderer<T>, GroupCell<T>> {

  private GroupingPlugin.DataGroup<T> dataGroup;

  /**
   * Constructs a new {@code RowCell} with the given cell information and column configuration.
   *
   * @param cellInfo Information about the cell.
   */
  public GroupCell(GroupCellInfo<T> cellInfo) {
    super(cellInfo);
  }

  public GroupingPlugin.DataGroup<T> getDataGroup() {
    return dataGroup;
  }

  void setDataGroup(GroupingPlugin.DataGroup<T> dataGroup) {
    this.dataGroup = dataGroup;
  }

  @Override
  protected GroupCellRenderer<T> getDefaultCellRenderer() {
    return cellInfo -> elements.text();
  }

  @Override
  public Element getStyleTarget() {
    return cellInfo.getStyleTarget();
  }

  @Override
  public Element getAppendTarget() {
    return cellInfo.getAppendTarget();
  }
}
