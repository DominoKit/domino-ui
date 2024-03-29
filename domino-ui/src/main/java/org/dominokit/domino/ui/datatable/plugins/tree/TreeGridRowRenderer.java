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

import java.util.List;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.RowCell;
import org.dominokit.domino.ui.datatable.TableRow;

/**
 * A custom row renderer implementation for rendering parent rows in a DataTable with tree-like
 * functionality.
 *
 * @param <T> The data type of the DataTable.
 */
public class TreeGridRowRenderer<T> implements TableRow.RowRenderer<T> {

  private final TreeGridPlugin<T> treeGridPlugin;

  /**
   * Constructs a new TreeGridRowRenderer with the given TreeGridPlugin.
   *
   * @param treeGridPlugin The TreeGridPlugin associated with this renderer.
   */
  public TreeGridRowRenderer(TreeGridPlugin<T> treeGridPlugin) {
    this.treeGridPlugin = treeGridPlugin;
  }

  /**
   * Renders a row within the DataTable based on the provided configuration.
   *
   * @param dataTable The DataTable to which the row belongs.
   * @param tableRow The TableRow to be rendered.
   */
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
