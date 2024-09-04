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

import static java.util.Objects.nonNull;

import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableConfig;
import org.dominokit.domino.ui.datatable.TableRow;

@Deprecated
public class TreeChildRowAppender<T> implements TableConfig.RowAppender<T> {

  private final TreePluginConfig<T> config;

  public TreeChildRowAppender(TreePluginConfig<T> config) {
    this.config = config;
  }

  @Override
  public void appendRow(DataTable<T> dataTable, TableRow<T> tableRow) {
    if (config.isLazy()) {
      if (nonNull(tableRow.getParent())) {
        TableRow<T> parentRow = tableRow.getParent();
        if (parentRow.getChildren().isEmpty()) {
          dataTable.bodyElement().insertAfter(tableRow, parentRow);
        } else {
          TableRow<T> otherNode = parentRow.getChildren().get(parentRow.getChildren().size() - 1);
          dataTable.bodyElement().insertAfter(tableRow, otherNode);
        }
      } else {
        dataTable.bodyElement().appendChild(tableRow.element());
      }
    } else {
      dataTable.bodyElement().appendChild(tableRow.element());
    }
  }
}
