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
package org.dominokit.domino.ui.shaded.datatable.plugins.tree;

import java.util.List;
import org.dominokit.domino.ui.shaded.datatable.ColumnConfig;
import org.dominokit.domino.ui.shaded.datatable.DataTable;
import org.dominokit.domino.ui.shaded.datatable.RowCell;
import org.dominokit.domino.ui.shaded.datatable.TableRow;

@Deprecated
public class TreeGridRowRenderer<T> implements TableRow.RowRenderer<T> {

  private final TreeGridPlugin<T> treeGridPlugin;

  public TreeGridRowRenderer(TreeGridPlugin<T> treeGridPlugin) {
    this.treeGridPlugin = treeGridPlugin;
  }

  @Override
  public void render(DataTable<T> dataTable, TableRow<T> tableRow) {
    List<ColumnConfig<T>> columns = dataTable.getTableConfig().getColumns();
    columns.stream().filter(ColumnConfig::isPluginColumn).forEach(tableRow::renderCell);

    List<RowCell<T>> rowCells =
        treeGridPlugin.getConfig().getParentRowCellsSupplier().get(dataTable, tableRow);
    rowCells.forEach(
        rowCell -> {
          tableRow.addCell(rowCell);
          tableRow.element().appendChild(rowCell.getCellInfo().getElement());
        });
  }
}
