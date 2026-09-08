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

import com.google.gwt.junit.client.GWTTestCase;
import org.dominokit.domino.ui.datatable.store.LocalListDataStore;

public class DataTableBorderModeTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testDefaultAndFullModePreserveLegacyBordering() {
    DataTable<String> table = new DataTable<>(new TableConfig<>(), new LocalListDataStore<>());

    assertEquals(TableBorderMode.FULL, table.getBorderMode());
    assertFalse(table.isBordered());
    assertFalse(table.element().classList.contains("dui-datatable-border-rows"));

    table.setBorderMode(TableBorderMode.FULL).setBordered(true);

    assertEquals(TableBorderMode.FULL, table.getBorderMode());
    assertTrue(table.isBordered());
    assertFalse(table.element().classList.contains("dui-datatable-border-full"));
  }

  public void testSelectingAModeEnablesBorderingAndReplacesThePreviousMode() {
    DataTable<String> table = new DataTable<>(new TableConfig<>(), new LocalListDataStore<>());

    table.setBorderMode(TableBorderMode.ROWS);

    assertEquals(TableBorderMode.ROWS, table.getBorderMode());
    assertTrue(table.isBordered());
    assertTrue(table.element().classList.contains("dui-datatable-border-rows"));

    table.setBorderMode(TableBorderMode.COLUMNS);

    assertEquals(TableBorderMode.COLUMNS, table.getBorderMode());
    assertFalse(table.element().classList.contains("dui-datatable-border-rows"));
    assertTrue(table.element().classList.contains("dui-datatable-border-columns"));
  }

  public void testDisablingBorderingDoesNotForgetTheSelectedMode() {
    DataTable<String> table = new DataTable<>(new TableConfig<>(), new LocalListDataStore<>());

    table.setBorderMode(TableBorderMode.SECTIONS).setBordered(false);

    assertEquals(TableBorderMode.SECTIONS, table.getBorderMode());
    assertFalse(table.isBordered());
    assertTrue(table.element().classList.contains("dui-datatable-border-sections"));

    table.setBordered(true);

    assertTrue(table.isBordered());
    assertTrue(table.element().classList.contains("dui-datatable-border-sections"));
  }

  public void testMultipleBorderModesCanBeAppliedTogether() {
    DataTable<String> table = new DataTable<>(new TableConfig<>(), new LocalListDataStore<>());

    table.setBorderModes(TableBorderMode.TABLE, TableBorderMode.ROWS, TableBorderMode.COLUMNS);

    assertTrue(table.isBordered());
    assertTrue(table.getBorderModes().contains(TableBorderMode.TABLE));
    assertTrue(table.getBorderModes().contains(TableBorderMode.ROWS));
    assertTrue(table.getBorderModes().contains(TableBorderMode.COLUMNS));
    assertTrue(table.element().classList.contains("dui-datatable-border-table"));
    assertTrue(table.element().classList.contains("dui-datatable-border-rows"));
    assertTrue(table.element().classList.contains("dui-datatable-border-columns"));

    table.removeBorderMode(TableBorderMode.ROWS);

    assertEquals(TableBorderMode.TABLE, table.getBorderMode());
    assertFalse(table.getBorderModes().contains(TableBorderMode.ROWS));
    assertTrue(table.getBorderModes().contains(TableBorderMode.TABLE));
    assertTrue(table.getBorderModes().contains(TableBorderMode.COLUMNS));
    assertFalse(table.element().classList.contains("dui-datatable-border-rows"));
  }

  public void testColumnGroupModeMarksGroupEndsAndUngroupedColumns() {
    ColumnConfig<String> groupedColumn =
        ColumnConfig.<String>create("contact", "Contact")
            .addColumn(ColumnConfig.<String>create("email", "Email"))
            .addColumn(ColumnConfig.<String>create("phone", "Phone"));
    TableConfig<String> tableConfig =
        new TableConfig<String>()
            .addColumn(groupedColumn)
            .addColumn(ColumnConfig.<String>create("status", "Status"));
    ColumnConfig<String> firstGroupedLeaf = groupedColumn.getSubColumns().get(0);
    ColumnConfig<String> lastGroupedLeaf = groupedColumn.getSubColumns().get(1);
    ColumnConfig<String> ungroupedColumn = tableConfig.getColumnsGrouped().get(1);

    assertTrue(groupedColumn.isColumnGroupBoundary());
    assertFalse(firstGroupedLeaf.isColumnGroupBoundary());
    assertTrue(lastGroupedLeaf.isColumnGroupBoundary());
    assertTrue(ungroupedColumn.isColumnGroupBoundary());
  }

  public void testColumnGroupModeMarksEveryHeaderOnTheRightmostGroupPath() {
    ColumnConfig<String> accountGroup =
        ColumnConfig.<String>create("account", "Account")
            .addColumn(
                ColumnConfig.<String>create("profile", "Profile")
                    .addColumn(ColumnConfig.<String>create("name", "Name"))
                    .addColumn(ColumnConfig.<String>create("email", "Email")))
            .addColumn(
                ColumnConfig.<String>create("contact", "Contact")
                    .addColumn(ColumnConfig.<String>create("phone", "Phone"))
                    .addColumn(ColumnConfig.<String>create("address", "Address")));
    TableConfig<String> tableConfig =
        new TableConfig<String>()
            .addColumn(accountGroup)
            .addColumn(ColumnConfig.<String>create("status", "Status"));

    ColumnConfig<String> profileGroup = accountGroup.getSubColumns().get(0);
    ColumnConfig<String> contactGroup = accountGroup.getSubColumns().get(1);
    ColumnConfig<String> lastContactColumn = contactGroup.getSubColumns().get(1);
    ColumnConfig<String> ungroupedColumn = tableConfig.getColumnsGrouped().get(1);

    assertTrue(accountGroup.isColumnGroupBoundary());
    assertFalse(profileGroup.isColumnGroupBoundary());
    assertTrue(contactGroup.isColumnGroupBoundary());
    assertTrue(lastContactColumn.isColumnGroupBoundary());
    assertTrue(ungroupedColumn.isColumnGroupBoundary());
  }

  public void testColumnStripingCanBeEnabledAndModeChanged() {
    DataTable<String> table = new DataTable<>(new TableConfig<>(), new LocalListDataStore<>());

    assertFalse(table.isColumnStriped());
    assertEquals(TableColumnStripeMode.COLUMNS, table.getColumnStripeMode());

    table.setColumnStriped(true);

    assertTrue(table.element().classList.contains("dui-datatable-column-stripe-columns"));
    table.setColumnStriped(false);

    table.setColumnStripeMode(TableColumnStripeMode.COLUMN_GROUPS);

    assertTrue(table.isColumnStriped());
    assertEquals(TableColumnStripeMode.COLUMN_GROUPS, table.getColumnStripeMode());
    assertTrue(table.element().classList.contains("dui-datatable-column-stripe-groups"));
    assertFalse(table.element().classList.contains("dui-datatable-column-stripe-columns"));

    table.setColumnStriped(false).setColumnStriped(true);

    assertTrue(table.isColumnStriped());
  }

  public void testColumnStripingUsesLeafAndTopLevelGroupOrder() {
    ColumnConfig<String> firstGroup =
        ColumnConfig.<String>create("first", "First")
            .addColumn(ColumnConfig.<String>create("name", "Name"))
            .addColumn(ColumnConfig.<String>create("email", "Email"));
    ColumnConfig<String> thirdGroup =
        ColumnConfig.<String>create("third", "Third")
            .addColumn(ColumnConfig.<String>create("phone", "Phone"))
            .addColumn(ColumnConfig.<String>create("address", "Address"));
    TableConfig<String> tableConfig =
        new TableConfig<String>()
            .addColumn(firstGroup)
            .addColumn(ColumnConfig.<String>create("status", "Status"))
            .addColumn(thirdGroup);
    ColumnConfig<String> name = firstGroup.getSubColumns().get(0);
    ColumnConfig<String> email = firstGroup.getSubColumns().get(1);
    ColumnConfig<String> status = tableConfig.getColumnsGrouped().get(1);
    ColumnConfig<String> phone = thirdGroup.getSubColumns().get(0);

    assertFalse(tableConfig.isColumnStripeAlternate(name, TableColumnStripeMode.COLUMNS));
    assertTrue(tableConfig.isColumnStripeAlternate(email, TableColumnStripeMode.COLUMNS));
    assertTrue(tableConfig.isColumnStripeAlternate(phone, TableColumnStripeMode.COLUMNS));
    assertTrue(tableConfig.isColumnStripeAlternate(status, TableColumnStripeMode.COLUMN_GROUPS));
  }
}
