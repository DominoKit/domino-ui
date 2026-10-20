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

import com.google.gwt.junit.client.GWTTestCase;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableConfig;
import org.dominokit.domino.ui.datatable.store.LocalListDataStore;
import org.dominokit.domino.ui.utils.ElementsFactory;

public class GroupingPluginTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testGroupHeaderRowIsAttachedBeforeRendererRuns() {
    boolean[] attachedDuringRender = {false};
    boolean[] sourceRowRemainsAvailable = {false};
    GroupingPlugin<String> groupingPlugin =
        new GroupingPlugin<>(
            tableRow -> "group",
            groupCell -> {
              attachedDuringRender[0] =
                  groupCell.getGroupHeaderRow() != null
                      && groupCell.element().parentElement
                          == groupCell.getGroupHeaderRow().element();
              sourceRowRemainsAvailable[0] = "record".equals(groupCell.getTableRow().getRecord());
              return ElementsFactory.elements.div().element();
            });
    TableConfig<String> tableConfig = new TableConfig<String>().addPlugin(groupingPlugin);
    DataTable<String> dataTable = new DataTable<>(tableConfig, new LocalListDataStore<>());

    dataTable.setData(java.util.Collections.singletonList("record"));

    assertTrue(
        "Group header must be attached to the table before rendering.", attachedDuringRender[0]);
    assertTrue(
        "The existing data-row accessor must remain backward-compatible.",
        sourceRowRemainsAvailable[0]);
  }
}
