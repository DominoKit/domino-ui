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
package org.dominokit.domino.ui.datatable.plugins.responsive;

import com.google.gwt.junit.client.GWTTestCase;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import jsinterop.annotations.JsFunction;
import jsinterop.base.Js;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.RowCell;
import org.dominokit.domino.ui.datatable.TableConfig;
import org.dominokit.domino.ui.datatable.TableRow;
import org.dominokit.domino.ui.datatable.events.ExpandRecordEvent;
import org.dominokit.domino.ui.datatable.plugins.DataTablePlugin;
import org.dominokit.domino.ui.datatable.plugins.pagination.SimplePaginationPlugin;
import org.dominokit.domino.ui.datatable.plugins.pagination.SortDirection;
import org.dominokit.domino.ui.datatable.plugins.pagination.SortPlugin;
import org.dominokit.domino.ui.datatable.plugins.row.RecordDetailsPlugin;
import org.dominokit.domino.ui.datatable.store.LocalListDataStore;

public class ResponsiveDataTablePluginTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void gwtSetUp() {
    // The headless GWT test browser does not provide CSS.escape, which DataTable uses to build
    // per-column selectors. Column names in these tests are plain identifiers, so identity is a
    // sufficient test-environment fallback.
    Js.asPropertyMap(DomGlobal.CSS).set("escape", (CssEscape) value -> value);
  }

  public void testDefaultsTo768pxAndSetBreakpointIsFluent() {
    FakeBreakpointObserver observer = new FakeBreakpointObserver(false);
    ResponsiveDataTablePlugin<String> plugin = new ResponsiveDataTablePlugin<>(observer);

    assertSame(plugin, plugin.setBreakpoint("640px"));
    DataTable<String> table = table(plugin, ColumnConfig.<String>create("name", "Name"));

    assertEquals("(max-width: 640px)", observer.query);

    FakeBreakpointObserver defaultObserver = new FakeBreakpointObserver(false);
    table(
        new ResponsiveDataTablePlugin<>(defaultObserver),
        ColumnConfig.<String>create("name", "Name"));
    assertEquals("(max-width: 768px)", defaultObserver.query);
  }

  public void testModeDefaultsToStackedAndPriorityConfigurationIsFluent() {
    ResponsiveDataTablePlugin<String> plugin =
        new ResponsiveDataTablePlugin<>(new FakeBreakpointObserver(false));

    assertEquals(ResponsiveDataTablePlugin.Mode.STACKED, plugin.getMode());
    assertSame(plugin, plugin.setMode(ResponsiveDataTablePlugin.Mode.PRIORITY_DETAILS));
    assertSame(plugin, plugin.setPriorityColumns("name", "status"));
    assertEquals(ResponsiveDataTablePlugin.Mode.PRIORITY_DETAILS, plugin.getMode());
  }

  public void testPriorityDetailsAcceptsVisibleLeafColumnsAndRecordDetailsPlugin() {
    ColumnConfig<String> person =
        ColumnConfig.<String>create("person", "Person")
            .addColumn(ColumnConfig.<String>create("given", "Given"))
            .addColumn(ColumnConfig.<String>create("family", "Family"));
    ResponsiveDataTablePlugin<String> responsive = priorityPlugin("given", "family");
    RecordDetailsPlugin<String> details = detailsPlugin();
    TableConfig<String> config =
        new TableConfig<String>().addColumn(person).addPlugin(responsive).addPlugin(details);

    DataTable<String> table = new DataTable<>(config, new LocalListDataStore<>());

    assertNotNull(table);
  }

  public void testPriorityDetailsRequiresRecordDetailsPlugin() {
    TableConfig<String> config =
        new TableConfig<String>()
            .addColumn(ColumnConfig.<String>create("name", "Name"))
            .addPlugin(priorityPlugin("name"));

    assertInvalidConfiguration(config, "RecordDetailsPlugin");
  }

  public void testPriorityDetailsRequiresAtLeastOnePriorityColumn() {
    TableConfig<String> config = validDetailsConfig();
    config.addPlugin(priorityPlugin());

    assertInvalidConfiguration(config, "priority column");
  }

  public void testPriorityDetailsRejectsNullPriorityColumnNames() {
    TableConfig<String> config = validDetailsConfig();
    config.addPlugin(priorityPlugin((String[]) null));

    assertInvalidConfiguration(config, "priority column");
  }

  public void testPriorityDetailsRejectsBlankPriorityColumnNames() {
    TableConfig<String> config = validDetailsConfig();
    config.addPlugin(priorityPlugin("  "));

    assertInvalidConfiguration(config, "priority column");
  }

  public void testPriorityDetailsRejectsUnknownPriorityColumnNames() {
    TableConfig<String> config = validDetailsConfig();
    config.addPlugin(priorityPlugin("missing"));

    assertInvalidConfiguration(config, "missing");
  }

  public void testPriorityDetailsRejectsDuplicatePriorityColumnNames() {
    TableConfig<String> config = validDetailsConfig();
    config.addPlugin(priorityPlugin("name", "name"));

    assertInvalidConfiguration(config, "name");
  }

  public void testPriorityDetailsRejectsGroupNames() {
    ColumnConfig<String> group =
        ColumnConfig.<String>create("person", "Person")
            .addColumn(ColumnConfig.<String>create("given", "Given"));
    TableConfig<String> config =
        new TableConfig<String>()
            .addColumn(group)
            .addPlugin(detailsPlugin())
            .addPlugin(priorityPlugin("person"));

    assertInvalidConfiguration(config, "person");
  }

  public void testPriorityDetailsRejectsHiddenPriorityColumns() {
    ColumnConfig<String> hidden = ColumnConfig.<String>create("name", "Name").hide();
    TableConfig<String> config =
        new TableConfig<String>()
            .addColumn(hidden)
            .addPlugin(detailsPlugin())
            .addPlugin(priorityPlugin("name"));

    assertInvalidConfiguration(config, "name");
  }

  public void testPriorityDetailsRejectsUtilityPriorityColumns() {
    TableConfig<String> config =
        new TableConfig<String>()
            .addColumn(ColumnConfig.<String>create("name", "Name"))
            .addPlugin(detailsPlugin())
            .addPlugin(priorityPlugin("plugin-utility-column"));

    assertInvalidConfiguration(config, "plugin-utility-column");
  }

  public void testPriorityDetailsMarksCellsAndPreservesTheirIdentityAcrossTransitions() {
    ColumnConfig<String> name = ColumnConfig.<String>create("name", "Name");
    ColumnConfig<String> email = ColumnConfig.<String>create("email", "Email");
    FakeBreakpointObserver observer = new FakeBreakpointObserver(false);
    TableConfig<String> config =
        new TableConfig<String>().addColumn(name).addColumn(email).addPlugin(detailsPlugin());
    ResponsiveDataTablePlugin<String> responsive =
        new ResponsiveDataTablePlugin<String>(observer)
            .setMode(ResponsiveDataTablePlugin.Mode.PRIORITY_DETAILS)
            .setPriorityColumns("name");
    config.addPlugin(responsive);
    DataTable<String> table = new DataTable<>(config, new LocalListDataStore<>());
    table.setData(Collections.singletonList("Ada"));
    TableRow<String> row = table.getRows().get(0);
    HTMLElement nameCell = row.getCell("name").element();
    HTMLElement emailCell = row.getCell("email").element();
    HTMLElement utilityCell = row.getCell("plugin-utility-column").element();

    assertTrue(nameCell.classList.contains("dui-datatable-responsive-priority-cell"));
    assertTrue(emailCell.classList.contains("dui-datatable-responsive-secondary-cell"));
    assertTrue(utilityCell.classList.contains("dui-datatable-responsive-utility-cell"));
    assertFalse(table.element().classList.contains("dui-datatable-responsive-priority-details"));

    observer.emit(true);
    assertTrue(table.element().classList.contains("dui-datatable-responsive-priority-details"));
    assertFalse(table.element().classList.contains("dui-datatable-responsive-stacked"));
    assertSame(nameCell, row.getCell("name").element());
    assertSame(emailCell, row.getCell("email").element());
    assertSame(utilityCell, row.getCell("plugin-utility-column").element());

    observer.emit(false);
    assertFalse(table.element().classList.contains("dui-datatable-responsive-priority-details"));
    assertSame(emailCell, row.getCell("email").element());
  }

  public void testPriorityDetailsInitialMatchActivatesOnlyItsOwnResponsiveClass() {
    FakeBreakpointObserver observer = new FakeBreakpointObserver(true);
    TableConfig<String> config =
        new TableConfig<String>()
            .addColumn(ColumnConfig.<String>create("name", "Name"))
            .addPlugin(detailsPlugin())
            .addPlugin(
                new ResponsiveDataTablePlugin<String>(observer)
                    .setMode(ResponsiveDataTablePlugin.Mode.PRIORITY_DETAILS)
                    .setPriorityColumns("name"));

    DataTable<String> table = new DataTable<>(config, new LocalListDataStore<>());

    assertTrue(table.element().classList.contains("dui-datatable-responsive-priority-details"));
    assertFalse(table.element().classList.contains("dui-datatable-responsive-stacked"));
  }

  public void testPriorityDetailsMovesFocusFromSecondaryCellToDetailsControl() {
    HTMLInputElement[] editor = new HTMLInputElement[1];
    ColumnConfig<String> name = ColumnConfig.<String>create("name", "Name");
    ColumnConfig<String> email =
        ColumnConfig.<String>create("email", "Email")
            .setRenderer(
                cell -> {
                  editor[0] = (HTMLInputElement) DomGlobal.document.createElement("input");
                  cell.element().appendChild(editor[0]);
                });
    FakeBreakpointObserver observer = new FakeBreakpointObserver(false);
    TableConfig<String> config =
        new TableConfig<String>()
            .addColumn(name)
            .addColumn(email)
            .addPlugin(detailsPlugin())
            .addPlugin(
                new ResponsiveDataTablePlugin<String>(observer)
                    .setMode(ResponsiveDataTablePlugin.Mode.PRIORITY_DETAILS)
                    .setPriorityColumns("name"));
    DataTable<String> table = new DataTable<>(config, new LocalListDataStore<>());
    table.setData(Collections.singletonList("Ada"));
    TableRow<String> row = table.getRows().get(0);
    editor[0].focus();
    HTMLElement detailsControl =
        (HTMLElement)
            row.getCell("plugin-utility-column").element().querySelector("[role='button']");

    assertNotNull(detailsControl);
    assertSame(editor[0], DomGlobal.document.activeElement);
    observer.emit(true);

    assertSame(detailsControl, DomGlobal.document.activeElement);
  }

  public void testPriorityDetailsPreservesFocusInsidePriorityCell() {
    HTMLInputElement[] editor = new HTMLInputElement[1];
    ColumnConfig<String> name =
        ColumnConfig.<String>create("name", "Name")
            .setRenderer(
                cell -> {
                  editor[0] = (HTMLInputElement) DomGlobal.document.createElement("input");
                  cell.element().appendChild(editor[0]);
                });
    FakeBreakpointObserver observer = new FakeBreakpointObserver(false);
    TableConfig<String> config =
        new TableConfig<String>()
            .addColumn(name)
            .addColumn(ColumnConfig.<String>create("email", "Email"))
            .addPlugin(detailsPlugin())
            .addPlugin(
                new ResponsiveDataTablePlugin<String>(observer)
                    .setMode(ResponsiveDataTablePlugin.Mode.PRIORITY_DETAILS)
                    .setPriorityColumns("name"));
    DataTable<String> table = new DataTable<>(config, new LocalListDataStore<>());
    table.setData(Collections.singletonList("Ada"));
    editor[0].focus();

    observer.emit(true);

    assertSame(editor[0], DomGlobal.document.activeElement);
  }

  public void testRecordDetailsExpansionWorksForEitherPluginRegistrationOrder() {
    for (boolean detailsFirst : new boolean[] {true, false}) {
      List<String> renderedRecords = new ArrayList<>();
      RecordDetailsPlugin<String> details = detailsPlugin(renderedRecords);
      ResponsiveDataTablePlugin<String> responsive = priorityPlugin("name");
      TableConfig<String> config =
          new TableConfig<String>()
              .addColumn(ColumnConfig.<String>create("name", "Name"))
              .addColumn(ColumnConfig.<String>create("email", "Email"));
      if (detailsFirst) {
        config.addPlugin(details).addPlugin(responsive);
      } else {
        config.addPlugin(responsive).addPlugin(details);
      }
      DataTable<String> table = new DataTable<>(config, new LocalListDataStore<>());
      table.setData(Collections.singletonList("Ada"));
      TableRow<String> row = table.getRows().get(0);
      HTMLElement detailsControl = detailsControl(row);

      detailsControl.click();

      assertEquals(Collections.singletonList("Ada"), renderedRecords);
      assertEquals("true", detailsControl.getAttribute("aria-expanded"));
      assertTrue(details.getTr().element().classList.contains("dui-datatable-details-tr"));
      assertSame(table.bodyElement().element(), details.getTr().element().parentElement);
      assertEquals("Details: Ada", details.getTd().element().textContent);
      assertEquals(1, detailsRowCount(table));
      assertFalse(row.isSelected());

      detailsControl.click();

      assertEquals("false", detailsControl.getAttribute("aria-expanded"));
      assertNull(details.getTr().element().parentElement);
      assertEquals(0, detailsRowCount(table));
    }
  }

  public void testReplacingDataClosesExpandedDetailsAndReleasesOldRow() {
    List<String> renderedRecords = new ArrayList<>();
    RecordDetailsPlugin<String> details = detailsPlugin(renderedRecords);
    TableConfig<String> config =
        new TableConfig<String>()
            .addColumn(ColumnConfig.<String>create("name", "Name"))
            .addPlugin(details)
            .addPlugin(priorityPlugin("name"));
    DataTable<String> table = new DataTable<>(config, new LocalListDataStore<>());
    table.setData(new ArrayList<>(Collections.singletonList("Ada")));
    HTMLElement oldDetailsControl = detailsControl(table.getRows().get(0));
    oldDetailsControl.click();
    assertEquals("true", oldDetailsControl.getAttribute("aria-expanded"));

    table.setData(new ArrayList<>(Collections.singletonList("Grace")));

    assertEquals("false", oldDetailsControl.getAttribute("aria-expanded"));
    assertNull(details.getTr().element().parentElement);
    assertEquals(0, detailsRowCount(table));
    assertEquals(Collections.singletonList("Ada"), renderedRecords);
    assertEquals("Grace", table.getRows().get(0).getRecord());

    detailsControl(table.getRows().get(0)).click();
    assertEquals(1, detailsRowCount(table));
    assertEquals(Arrays.asList("Ada", "Grace"), renderedRecords);
  }

  public void testRedrawTreatsReloadedRowsAsReplacementWithoutLeavingDetailsRows() {
    List<String> renderedRecords = new ArrayList<>();
    RecordDetailsPlugin<String> details = detailsPlugin(renderedRecords);
    LocalListDataStore<String> store =
        new LocalListDataStore<>(new ArrayList<>(Collections.singletonList("Ada")));
    TableConfig<String> config =
        new TableConfig<String>()
            .addColumn(ColumnConfig.<String>create("name", "Name"))
            .addPlugin(details)
            .addPlugin(priorityPlugin("name"));
    DataTable<String> table = new DataTable<>(config, store);
    table.setData(new ArrayList<>(Collections.singletonList("Ada")));
    HTMLElement oldControl = detailsControl(table.getRows().get(0));
    oldControl.click();
    assertEquals(1, detailsRowCount(table));

    table.redraw();

    assertEquals("false", oldControl.getAttribute("aria-expanded"));
    assertEquals(0, detailsRowCount(table));
    assertEquals("Ada", table.getRows().get(0).getRecord());

    detailsControl(table.getRows().get(0)).click();
    assertEquals(1, detailsRowCount(table));
    assertEquals(Arrays.asList("Ada", "Ada"), renderedRecords);
  }

  public void testAppendingDataRetainsExpandedDetailsAndExistingCellControls() {
    HTMLInputElement[] emailEditor = new HTMLInputElement[1];
    ColumnConfig<String> email =
        ColumnConfig.<String>create("email", "Email")
            .setRenderer(
                cell -> {
                  emailEditor[0] = (HTMLInputElement) DomGlobal.document.createElement("input");
                  cell.element().appendChild(emailEditor[0]);
                });
    List<String> renderedRecords = new ArrayList<>();
    RecordDetailsPlugin<String> details = detailsPlugin(renderedRecords);
    TableConfig<String> config =
        new TableConfig<String>()
            .addColumn(ColumnConfig.<String>create("name", "Name"))
            .addColumn(email)
            .addPlugin(details)
            .addPlugin(priorityPlugin("name"));
    DataTable<String> table = new DataTable<>(config, new LocalListDataStore<>());
    table.setData(new ArrayList<>(Collections.singletonList("Ada")));
    TableRow<String> expandedRow = table.getRows().get(0);
    HTMLElement nameCell = expandedRow.getCell("name").element();
    HTMLElement emailCell = expandedRow.getCell("email").element();
    HTMLInputElement originalEditor = emailEditor[0];
    HTMLElement detailsControl = detailsControl(expandedRow);
    detailsControl.click();

    table.appendData(Collections.singletonList("Grace"));

    assertSame(expandedRow, table.getRows().get(0));
    assertSame(nameCell, expandedRow.getCell("name").element());
    assertSame(emailCell, expandedRow.getCell("email").element());
    assertSame(originalEditor, expandedRow.getCell("email").element().firstChild);
    assertEquals("true", detailsControl.getAttribute("aria-expanded"));
    assertEquals(1, detailsRowCount(table));
    assertEquals(Collections.singletonList("Ada"), renderedRecords);

    detailsControl.click();
    assertEquals("false", detailsControl.getAttribute("aria-expanded"));
    assertEquals(0, detailsRowCount(table));
  }

  public void testResponsiveModeDoesNotUnhideARegularlyHiddenSecondaryColumn() {
    ColumnConfig<String> email = ColumnConfig.<String>create("email", "Email");
    FakeBreakpointObserver observer = new FakeBreakpointObserver(false);
    TableConfig<String> config =
        new TableConfig<String>()
            .addColumn(ColumnConfig.<String>create("name", "Name"))
            .addColumn(email)
            .addPlugin(detailsPlugin())
            .addPlugin(
                new ResponsiveDataTablePlugin<String>(observer)
                    .setMode(ResponsiveDataTablePlugin.Mode.PRIORITY_DETAILS)
                    .setPriorityColumns("name"));
    DataTable<String> table = new DataTable<>(config, new LocalListDataStore<>());
    table.setData(Collections.singletonList("Ada"));
    email.hide();
    HTMLElement emailCell = table.getRows().get(0).getCell("email").element();

    observer.emit(true);

    assertTrue(email.isHidden());
    assertTrue(emailCell.classList.contains("dui-hidden"));
    assertTrue(emailCell.classList.contains("dui-datatable-responsive-secondary-cell"));
  }

  public void testPriorityColumnHiddenThroughVisibilityApiStaysHidden() {
    ColumnConfig<String> name = ColumnConfig.<String>create("name", "Name");
    FakeBreakpointObserver observer = new FakeBreakpointObserver(false);
    TableConfig<String> config =
        new TableConfig<String>()
            .addColumn(name)
            .addColumn(ColumnConfig.<String>create("email", "Email"))
            .addPlugin(detailsPlugin())
            .addPlugin(
                new ResponsiveDataTablePlugin<String>(observer)
                    .setMode(ResponsiveDataTablePlugin.Mode.PRIORITY_DETAILS)
                    .setPriorityColumns("name"));
    DataTable<String> table = new DataTable<>(config, new LocalListDataStore<>());
    table.setData(Collections.singletonList("Ada"));
    HTMLElement nameCell = table.getRows().get(0).getCell("name").element();

    name.hide();
    observer.emit(true);

    assertTrue(name.isHidden());
    assertTrue(nameCell.classList.contains("dui-hidden"));
    assertTrue(nameCell.classList.contains("dui-datatable-responsive-priority-cell"));
  }

  public void testEmptyDetailsRendererStillHasUsableExpandedState() {
    RecordDetailsPlugin<String> details =
        new RecordDetailsPlugin<>(
            (org.dominokit.domino.ui.datatable.plugins.row.RecordDetailsRenderer<String>)
                cell -> {});
    TableConfig<String> config =
        new TableConfig<String>()
            .addColumn(ColumnConfig.<String>create("name", "Name"))
            .addPlugin(details)
            .addPlugin(priorityPlugin("name"));
    DataTable<String> table = new DataTable<>(config, new LocalListDataStore<>());
    table.setData(new ArrayList<>(Collections.singletonList("Ada")));
    HTMLElement detailsControl = detailsControl(table.getRows().get(0));

    detailsControl.click();

    assertEquals("true", detailsControl.getAttribute("aria-expanded"));
    assertEquals(1, detailsRowCount(table));
    assertEquals("", details.getDetailsElement().element().textContent);
  }

  public void testPluginReceivesReplacementAndAppendLifecycleNotifications() {
    List<Boolean> appendNotifications = new ArrayList<>();
    DataTablePlugin<String> lifecyclePlugin =
        new DataTablePlugin<String>() {
          @Override
          public void onBeforeDataChange(DataTable<String> dataTable, boolean append) {
            appendNotifications.add(append);
          }
        };
    DataTable<String> table =
        new DataTable<>(
            new TableConfig<String>()
                .addColumn(ColumnConfig.<String>create("name", "Name"))
                .addPlugin(lifecyclePlugin),
            new LocalListDataStore<>());

    table.setData(new ArrayList<>(Collections.singletonList("Ada")));
    table.appendData(Collections.singletonList("Grace"));

    assertEquals(Arrays.asList(false, true), appendNotifications);
  }

  public void testInitialMatchAndBothBreakpointTransitionsToggleTheResponsiveClass() {
    FakeBreakpointObserver observer = new FakeBreakpointObserver(true);
    DataTable<String> table =
        table(
            new ResponsiveDataTablePlugin<>(observer), ColumnConfig.<String>create("name", "Name"));

    assertTrue(table.element().classList.contains("dui-datatable-responsive-stacked"));
    observer.emit(false);
    assertFalse(table.element().classList.contains("dui-datatable-responsive-stacked"));
    observer.emit(true);
    assertTrue(table.element().classList.contains("dui-datatable-responsive-stacked"));
  }

  public void testInvalidMediaQueryRemainsInNormalPresentation() {
    DataTable<String> table =
        table(
            ResponsiveDataTablePlugin.<String>create().setBreakpoint("invalid query"),
            ColumnConfig.<String>create("name", "Name"));

    assertFalse(table.element().classList.contains("dui-datatable-responsive-stacked"));
  }

  public void testTableWithoutResponsivePluginHasNoResponsiveClassOrCellMetadata() {
    ColumnConfig<String> name = ColumnConfig.<String>create("name", "Name");
    DataTable<String> table = table(null, name);
    table.setData(new ArrayList<>(Collections.singletonList("Ada")));

    assertFalse(table.element().classList.contains("dui-datatable-responsive-stacked"));
    assertNull(table.getRows().get(0).getCell("name").element().getAttribute("data-label"));
    assertNull(table.getRows().get(0).getCell("name").element().getAttribute("headers"));
  }

  public void testColumnTitleAndNameFallbackAreAppliedToCells() {
    ColumnConfig<String> titled = ColumnConfig.<String>create("first_name", "First name");
    ColumnConfig<String> blankTitle = ColumnConfig.<String>create("last_name", " ");
    DataTable<String> table =
        table(
            new ResponsiveDataTablePlugin<>(new FakeBreakpointObserver(false)), titled, blankTitle);
    table.setData(Collections.singletonList("Ada"));

    assertEquals(
        "First name",
        table.getRows().get(0).getCell("first_name").element().getAttribute("data-label"));
    assertEquals(
        "last_name",
        table.getRows().get(0).getCell("last_name").element().getAttribute("data-label"));
    assertEquals(
        titled.getHeadElement().getAttribute("id"),
        table.getRows().get(0).getCell("first_name").element().getAttribute("headers"));
  }

  public void testGroupedLeafCellUsesItsLeafHeaderAssociation() {
    ColumnConfig<String> group =
        ColumnConfig.<String>create("person", "Person")
            .addColumn(ColumnConfig.<String>create("given", "Given name"))
            .addColumn(ColumnConfig.<String>create("family", "Family name"));
    DataTable<String> table =
        table(new ResponsiveDataTablePlugin<>(new FakeBreakpointObserver(false)), group);
    table.setData(Collections.singletonList("Ada"));

    RowCell<String> cell = table.getRows().get(0).getCell("given");
    ColumnConfig<String> leaf = group.getSubColumns().get(0);
    assertEquals("Given name", cell.element().getAttribute("data-label"));
    assertEquals(leaf.getHeadElement().getAttribute("id"), cell.element().getAttribute("headers"));
    assertNull(group.getHeadElement().getAttribute("id"));
  }

  public void testUtilityColumnCellRetainsItsContentAndReceivesMetadata() {
    ColumnConfig<String> name =
        ColumnConfig.<String>create("name", "Name").setRenderer(cell -> cell.setTextContent("Ada"));
    DataTablePlugin<String> utilityPlugin =
        new DataTablePlugin<String>() {
          @Override
          public boolean requiresUtilityColumn() {
            return true;
          }
        };
    TableConfig<String> config =
        new TableConfig<String>()
            .addColumn(name)
            .addPlugin(utilityPlugin)
            .addPlugin(new ResponsiveDataTablePlugin<>(new FakeBreakpointObserver(false)));
    DataTable<String> table = new DataTable<>(config, new LocalListDataStore<>());
    table.setData(Collections.singletonList("Ada"));

    RowCell<String> utilityCell = table.getRows().get(0).getCell("plugin-utility-column");
    assertNotNull(utilityCell);
    assertEquals("plugin-utility-column", utilityCell.element().getAttribute("data-label"));
    assertEquals("Ada", table.getRows().get(0).getCell("name").element().textContent);
  }

  public void testLabelsSurviveCellUpdateSetDataAppendDataAndRedraw() {
    ColumnConfig<String> name = ColumnConfig.<String>create("name", "Name");
    DataTable<String> table =
        table(new ResponsiveDataTablePlugin<>(new FakeBreakpointObserver(false)), name);
    table.setData(Collections.singletonList("Ada"));
    assertCellLabel(table.getRows().get(0), "name", "Name");

    table.getRows().get(0).getCell("name").updateCell();
    assertCellLabel(table.getRows().get(0), "name", "Name");

    table.setData(new java.util.ArrayList<>(Collections.singletonList("Grace")));
    assertCellLabel(table.getRows().get(0), "name", "Name");
    table.appendData(Collections.singletonList("Lin"));
    assertCellLabel(table.getRows().get(1), "name", "Name");
  }

  public void testSelectionAndLabelsSurviveAppendAndReplacementAndRedraw() {
    FakeBreakpointObserver observer = new FakeBreakpointObserver(false);
    ColumnConfig<String> name = ColumnConfig.<String>create("name", "Name");
    TableConfig<String> config =
        new TableConfig<String>()
            .addColumn(name)
            .addPlugin(new ResponsiveDataTablePlugin<>(observer));
    LocalListDataStore<String> store =
        new LocalListDataStore<>(new ArrayList<>(Collections.singletonList("Ada")));
    DataTable<String> table = new DataTable<>(config, store);
    store.load();

    TableRow<String> selectedRow = table.getRows().get(0).select();
    table.appendData(Collections.singletonList("Grace"));
    assertSame(selectedRow, table.getRows().get(0));
    assertTrue(selectedRow.isSelected());
    assertCellLabel(selectedRow, "name", "Name");

    store.setData(new ArrayList<>(Collections.singletonList("Lin")));
    assertEquals("Lin", table.getRows().get(0).getRecord());
    assertCellLabel(table.getRows().get(0), "name", "Name");
    assertEquals(
        name.getHeadElement().getAttribute("id"),
        table.getRows().get(0).getCell("name").element().getAttribute("headers"));

    observer.emit(true);
    table.redraw();
    assertTrue(table.element().classList.contains("dui-datatable-responsive-stacked"));
    assertEquals("Lin", table.getRows().get(0).getRecord());
    assertCellLabel(table.getRows().get(0), "name", "Name");
    assertEquals(
        name.getHeadElement().getAttribute("id"),
        table.getRows().get(0).getCell("name").element().getAttribute("headers"));
  }

  public void testSortingAndPaginationRemainAvailableInStackedMode() {
    ColumnConfig<String> name =
        ColumnConfig.<String>create("name", "Name")
            .sortable()
            .setRenderer(cell -> cell.setTextContent(cell.getRecord()));
    SortPlugin<String> sortPlugin = new SortPlugin<>();
    SimplePaginationPlugin<String> paginationPlugin = new SimplePaginationPlugin<>(1);
    LocalListDataStore<String> store =
        new LocalListDataStore<>(new ArrayList<>(Arrays.asList("Charlie", "Alpha", "Bravo")))
            .setPagination(paginationPlugin.getSimplePagination())
            .setRecordsSorter((sortBy, direction) -> Comparator.naturalOrder());
    FakeBreakpointObserver observer = new FakeBreakpointObserver(true);
    TableConfig<String> config =
        new TableConfig<String>()
            .addColumn(name)
            .addPlugin(sortPlugin)
            .addPlugin(paginationPlugin)
            .addPlugin(new ResponsiveDataTablePlugin<>(observer))
            .setLazyLoad(false);
    DataTable<String> table = new DataTable<>(config, store);

    sortPlugin.sort(SortDirection.ASC, name);
    assertEquals("ascending", name.getHeadElement().getAttribute("aria-sort"));
    paginationPlugin.getSimplePagination().gotoPage(2);

    assertEquals("Bravo", table.getRows().get(0).getRecord());
    assertEquals("Bravo", table.getRows().get(0).getCell("name").element().textContent);
    assertCellLabel(table.getRows().get(0), "name", "Name");
    assertTrue(table.element().classList.contains("dui-datatable-responsive-stacked"));
  }

  public void testRecordDetailsRowsKeepTheirOwnStructureInStackedMode() {
    ColumnConfig<String> name = ColumnConfig.<String>create("name", "Name");
    RecordDetailsPlugin<String> detailsPlugin =
        new RecordDetailsPlugin<>(
            (org.dominokit.domino.ui.datatable.plugins.row.RecordDetailsRenderer<String>)
                cell -> cell.appendChild("Record details"));
    FakeBreakpointObserver observer = new FakeBreakpointObserver(true);
    TableConfig<String> config =
        new TableConfig<String>()
            .addColumn(name)
            .addPlugin(detailsPlugin)
            .addPlugin(new ResponsiveDataTablePlugin<>(observer));
    DataTable<String> table = new DataTable<>(config, new LocalListDataStore<>());
    table.setData(Collections.singletonList("Ada"));

    TableRow<String> row = table.getRows().get(0);
    table.fireTableEvent(new ExpandRecordEvent<>(row));
    elemental2.dom.HTMLTableCellElement detailsCell = detailsPlugin.getTd().element();

    assertCellLabel(row, "name", "Name");
    assertTrue(detailsPlugin.getTr().element().classList.contains("dui-datatable-details-tr"));
    assertSame(table.bodyElement().element(), detailsPlugin.getTr().element().parentElement);
    assertEquals("Record details", detailsCell.textContent);
    assertTrue(table.element().classList.contains("dui-datatable-responsive-stacked"));
  }

  public void testEditableControlRetainsIdentityAndFocusWhenBreakpointChanges() {
    HTMLInputElement[] editor = new HTMLInputElement[1];
    ColumnConfig<String> name =
        ColumnConfig.<String>create("name", "Name")
            .setRenderer(cell -> cell.setTextContent(cell.getRecord()))
            .setEditableRenderer(
                cell -> {
                  editor[0] = (HTMLInputElement) DomGlobal.document.createElement("input");
                  cell.element().appendChild(editor[0]);
                });
    FakeBreakpointObserver observer = new FakeBreakpointObserver(false);
    DataTable<String> table = table(new ResponsiveDataTablePlugin<>(observer), name);
    table.setData(Collections.singletonList("Ada"));
    TableRow<String> row = table.getRows().get(0);
    row.edit("name");
    HTMLInputElement input = editor[0];
    input.focus();

    assertSame(input, DomGlobal.document.activeElement);
    observer.emit(true);
    assertSame(input, row.getCell("name").element().firstChild);
    assertSame(input, DomGlobal.document.activeElement);
    row.select();
    assertTrue(row.isSelected());

    observer.emit(false);
    assertFalse(table.element().classList.contains("dui-datatable-responsive-stacked"));
    assertSame(input, row.getCell("name").element().firstChild);
    assertSame(input, DomGlobal.document.activeElement);
  }

  public void testRemovingTableUnregistersBreakpointObserver() {
    FakeBreakpointObserver observer = new FakeBreakpointObserver(false);
    DataTable<String> table =
        table(
            new ResponsiveDataTablePlugin<>(observer), ColumnConfig.<String>create("name", "Name"));

    assertFalse(observer.removed);
    table.remove();

    assertTrue(observer.removed);
    observer.emit(true);
    assertFalse(table.element().classList.contains("dui-datatable-responsive-stacked"));
  }

  public void testRemovingPriorityDetailsTableRemovesItsResponsiveClass() {
    FakeBreakpointObserver observer = new FakeBreakpointObserver(true);
    TableConfig<String> config =
        new TableConfig<String>()
            .addColumn(ColumnConfig.<String>create("name", "Name"))
            .addPlugin(detailsPlugin())
            .addPlugin(
                new ResponsiveDataTablePlugin<String>(observer)
                    .setMode(ResponsiveDataTablePlugin.Mode.PRIORITY_DETAILS)
                    .setPriorityColumns("name"));
    DataTable<String> table = new DataTable<>(config, new LocalListDataStore<>());

    table.remove();
    observer.emit(false);

    assertTrue(observer.removed);
    assertFalse(table.element().classList.contains("dui-datatable-responsive-priority-details"));
  }

  private void assertCellLabel(TableRow<String> row, String column, String label) {
    assertEquals(label, row.getCell(column).element().getAttribute("data-label"));
  }

  private ResponsiveDataTablePlugin<String> priorityPlugin(String... columns) {
    return new ResponsiveDataTablePlugin<String>(new FakeBreakpointObserver(false))
        .setMode(ResponsiveDataTablePlugin.Mode.PRIORITY_DETAILS)
        .setPriorityColumns(columns);
  }

  private RecordDetailsPlugin<String> detailsPlugin() {
    return new RecordDetailsPlugin<>(
        (org.dominokit.domino.ui.datatable.plugins.row.RecordDetailsRenderer<String>)
            cell -> cell.appendChild("Record details"));
  }

  private RecordDetailsPlugin<String> detailsPlugin(List<String> renderedRecords) {
    return new RecordDetailsPlugin<>(
        (org.dominokit.domino.ui.datatable.plugins.row.RecordDetailsRenderer<String>)
            cell -> {
              renderedRecords.add(cell.getRecord());
              cell.appendChild("Details: " + cell.getRecord());
            });
  }

  private HTMLElement detailsControl(TableRow<String> row) {
    return (HTMLElement)
        row.getCell("plugin-utility-column").element().querySelector("[role='button']");
  }

  private int detailsRowCount(DataTable<String> table) {
    return table.bodyElement().element().querySelectorAll(".dui-datatable-details-tr").length;
  }

  private TableConfig<String> validDetailsConfig() {
    return new TableConfig<String>()
        .addColumn(ColumnConfig.<String>create("name", "Name"))
        .addPlugin(detailsPlugin());
  }

  private void assertInvalidConfiguration(TableConfig<String> config, String expectedMessage) {
    try {
      new DataTable<>(config, new LocalListDataStore<>());
      fail("Expected invalid priority/details configuration containing: " + expectedMessage);
    } catch (IllegalArgumentException e) {
      assertTrue(
          "Unexpected validation message: " + e.getMessage(),
          e.getMessage().contains(expectedMessage));
    }
  }

  @SafeVarargs
  private final DataTable<String> table(
      ResponsiveDataTablePlugin<String> plugin, ColumnConfig<String>... columns) {
    TableConfig<String> config = new TableConfig<>();
    Arrays.stream(columns).forEach(config::addColumn);
    if (plugin != null) {
      config.addPlugin(plugin);
    }
    return new DataTable<>(config, new LocalListDataStore<>());
  }

  private static class FakeBreakpointObserver implements ResponsiveBreakpointObserver {
    private final boolean initialMatch;
    private Consumer<Boolean> listener;
    private String query;
    private boolean removed;

    private FakeBreakpointObserver(boolean initialMatch) {
      this.initialMatch = initialMatch;
    }

    @Override
    public Registration observe(String query, Consumer<Boolean> onChange) {
      this.query = query;
      this.listener = onChange;
      onChange.accept(initialMatch);
      return () -> removed = true;
    }

    private void emit(boolean matches) {
      listener.accept(matches);
    }
  }

  @JsFunction
  private interface CssEscape {
    String apply(String value);
  }
}
