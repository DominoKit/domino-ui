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

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.HTMLTableCellElement;
import elemental2.dom.Node;
import java.util.*;
import java.util.function.Supplier;
import org.dominokit.domino.ui.datatable.CellRenderer;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableConfig;
import org.dominokit.domino.ui.datatable.TableRow;
import org.dominokit.domino.ui.datatable.events.OnBeforeDataChangeEvent;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.datatable.plugins.DataTablePlugin;
import org.dominokit.domino.ui.icons.ToggleIcon;
import org.dominokit.domino.ui.icons.ToggleMdiIcon;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.utils.ComponentMeta;

/**
 * The {@code GroupingPlugin} class provides the functionality to group data in a {@link DataTable}
 * based on a grouping criteria. It allows expanding and collapsing groups of rows, making it easier
 * to navigate and manage large datasets.
 *
 * <p><strong>Usage example:</strong>
 *
 * <pre>
 * DataTable<Person> dataTable = ... // Create a DataTable instance
 * GroupingPlugin<Person> groupingPlugin = new GroupingPlugin<>(new GroupSupplier<Person>() {
 *     {@literal @}Override
 *     public String getRecordGroupId(TableRow<Person> tableRow) {
 *         return tableRow.getModel().getCountry(); // Grouping criteria based on the 'country' field
 *     }
 * }, new CellRenderer<Person>() {
 *     {@literal @}Override
 *     public void render(CellInfo<Person> cellInfo) {
 *         // Custom rendering for the group header cell
 *         cellInfo.getElement().textContent = "Group: " + cellInfo.getModel().getCountry();
 *     }
 * });
 *
 * // Initialize and add the grouping plugin to the DataTable
 * dataTable.addPlugin(groupingPlugin);
 * </pre>
 *
 * @param <T> The data type of the DataTable.
 */
public class GroupingPlugin<T> implements DataTablePlugin<T>, TableConfig.RowAppender<T> {

  private Map<String, DataGroup<T>> dataGroups = new HashMap<>();
  private final GroupSupplier<T> groupSupplier;
  private CellRenderer<T> groupRenderer;
  private Supplier<ToggleIcon<?, ?>> groupExpandedCollapseIconSupplier =
      () -> ToggleMdiIcon.create(Icons.minus_box(), Icons.plus_box());

  /**
   * Creates a new {@code GroupingPlugin} instance with the given group supplier and group renderer.
   *
   * @param groupSupplier The supplier for grouping records.
   * @param groupRenderer The cell renderer for rendering group headers.
   */
  public GroupingPlugin(GroupSupplier<T> groupSupplier, CellRenderer<T> groupRenderer) {
    this.groupSupplier = groupSupplier;
    this.groupRenderer = groupRenderer;
  }

  /**
   * Initializes the grouping plugin and adds it to the DataTable.
   *
   * @param dataTable The DataTable instance to which this plugin will be added.
   */
  @Override
  public void init(DataTable<T> dataTable) {
    dataTable.getTableConfig().setRowAppender(this);
  }

  /**
   * Sets the group expanded/collapse icon supplier for the group headers.
   *
   * @param groupExpandedIconSupplier The supplier for the group expanded/collapse icon.
   * @return This {@code GroupingPlugin} instance for method chaining.
   */
  public GroupingPlugin<T> setGroupExpandedCollapseIcon(
      Supplier<ToggleIcon<?, ?>> groupExpandedIconSupplier) {
    this.groupExpandedCollapseIconSupplier = groupExpandedIconSupplier;
    return this;
  }

  /**
   * Appends a row to the DataTable. Handles grouping of rows based on the group criteria.
   *
   * @param dataTable The DataTable instance.
   * @param tableRow The TableRow to append.
   */
  @Override
  public void appendRow(DataTable<T> dataTable, TableRow<T> tableRow) {
    String groupId = groupSupplier.getRecordGroupId(tableRow);
    if (!dataGroups.containsKey(groupId)) {
      HTMLTableCellElement cellElement =
          elements
              .td()
              .setAttribute("colspan", dataTable.getTableConfig().getColumns().size() + "")
              .element();
      CellRenderer.CellInfo<T> cellInfo = new CellRenderer.CellInfo<>(tableRow, cellElement);
      DataGroup<T> dataGroup = new DataGroup<>(tableRow, cellInfo);

      ToggleIcon<?, ?> groupIconSupplier =
          groupExpandedCollapseIconSupplier
              .get()
              .clickable()
              .toggleOnClick(true)
              .addClickListener(evt -> dataGroup.toggleGroup());
      dataGroup.setGroupIconSupplier(groupIconSupplier).setGroupRenderer(groupRenderer).render();

      dataTable
          .bodyElement()
          .appendChild(elements.tr().css("data-table-group-row").appendChild(cellElement));
      dataTable.bodyElement().appendChild(tableRow.element());
      dataGroups.put(groupId, dataGroup);
    } else {
      DataGroup<T> dataGroup = dataGroups.get(groupId);
      Node nextSibling = dataGroup.lastRow.element().nextSibling;
      if (nonNull(nextSibling)) {
        elements.elementOf(dataTable.bodyElement()).insertBefore(tableRow.element(), nextSibling);
      } else {
        dataTable.bodyElement().appendChild(tableRow.element());
      }

      dataGroup.lastRow = tableRow;
      dataGroup.addRow(tableRow);
    }
  }

  /** Expands all groups in the DataTable. */
  public void expandAll() {
    for (DataGroup<T> dataGroup : dataGroups.values()) {
      if (!dataGroup.expanded) {
        dataGroup.toggleGroup();
        dataGroup.getGroupIconSupplier().toggle();
      }
    }
  }

  /** Collapses all groups in the DataTable. */
  public void collapseAll() {
    for (DataGroup<T> dataGroup : dataGroups.values()) {
      if (dataGroup.expanded) {
        dataGroup.toggleGroup();
        dataGroup.getGroupIconSupplier().toggle();
      }
    }
  }

  /**
   * Retrieves the data groups created by this plugin.
   *
   * @return A map of data groups.
   */
  public Map<String, DataGroup<T>> getDataGroups() {
    return dataGroups;
  }

  /**
   * Handles events triggered on the DataTable.
   *
   * @param event The TableEvent to handle.
   */
  @Override
  public void handleEvent(TableEvent event) {
    if (event.getType().equalsIgnoreCase(OnBeforeDataChangeEvent.ON_BEFORE_DATA_CHANGE)) {
      dataGroups.clear();
    }
  }

  /**
   * The {@code DataGroup} class represents a group of data rows in the DataTable. It is used for
   * grouping and rendering data rows as a single group.
   */
  public static class DataGroup<T> implements ComponentMeta {

    /** The key for identifying {@code DataGroup} instances in TableRow metadata. */
    private static final String KEY = "dataGroup";

    private List<TableRow<T>> groupRows = new ArrayList<>();
    private TableRow<T> lastRow;
    private CellRenderer.CellInfo<T> cellInfo;
    private boolean expanded = true;
    private ToggleIcon<?, ?> groupIconSupplier;
    private CellRenderer<T> groupRenderer;

    /**
     * Creates a new {@code DataGroup} instance with the given lastRow and cellInfo.
     *
     * @param lastRow The last TableRow in the group.
     * @param cellInfo The CellInfo containing the group cell element.
     */
    public DataGroup(TableRow<T> lastRow, CellRenderer.CellInfo<T> cellInfo) {
      this.lastRow = lastRow;
      this.cellInfo = cellInfo;
      addRow(lastRow);
    }

    /**
     * Retrieves a {@code DataGroup} associated with the given TableRow, if available.
     *
     * @param <T> The data type of the TableRow.
     * @param tableRow The TableRow for which to retrieve the associated DataGroup.
     * @return An Optional containing the associated DataGroup, or an empty Optional if not found.
     */
    public static <T> Optional<DataGroup<T>> fromRow(TableRow<T> tableRow) {
      return tableRow.getMeta(KEY);
    }

    /** Toggles the visibility of the group's rows (expanding/collapsing the group). */
    public void toggleGroup() {
      expanded = !expanded;
      groupRows.forEach(tableRow -> elements.elementOf(tableRow.element()).toggleDisplay(expanded));
    }

    /**
     * Adds a TableRow to the group and updates its styling.
     *
     * @param tableRow The TableRow to add to the group.
     */
    public void addRow(TableRow<T> tableRow) {
      groupRows.add(tableRow);
      tableRow.addCss(isOdd(tableRow) ? dui_odd : dui_even);
      tableRow.applyMeta(this);
    }

    /**
     * Sets the group expanded/collapse icon supplier for the group headers.
     *
     * @param groupIconSupplier The supplier for the group expanded/collapse icon.
     * @return This {@code DataGroup} instance for method chaining.
     */
    private DataGroup<T> setGroupIconSupplier(ToggleIcon<?, ?> groupIconSupplier) {
      this.groupIconSupplier = groupIconSupplier;
      return this;
    }

    /**
     * Retrieves the group's expanded/collapse icon supplier.
     *
     * @return The group icon supplier.
     */
    private ToggleIcon<?, ?> getGroupIconSupplier() {
      return this.groupIconSupplier;
    }

    /**
     * Sets the group renderer for rendering the group header cell.
     *
     * @param groupRenderer The group renderer.
     * @return This {@code DataGroup} instance for method chaining.
     */
    private DataGroup<T> setGroupRenderer(CellRenderer<T> groupRenderer) {
      this.groupRenderer = groupRenderer;
      return this;
    }

    /**
     * Retrieves the key for identifying {@code DataGroup} instances in TableRow metadata.
     *
     * @return The identifying key.
     */
    @Override
    public String getKey() {
      return KEY;
    }

    /**
     * Checks if the TableRow is an odd row within the group.
     *
     * @param tableRow The TableRow to check.
     * @return True if the TableRow is odd, false otherwise.
     */
    private boolean isOdd(TableRow<T> tableRow) {
      return groupRows.indexOf(tableRow) % 2 > 0;
    }

    /** Renders the group header cell with the provided group icon and group renderer. */
    public void render() {
      elements
          .elementOf(cellInfo.getElement())
          .clearElement()
          .appendChild(
              elements
                  .div()
                  .addCss(dui_flex, dui_gap_2, dui_items_center, dui_p_1)
                  .appendChild(groupIconSupplier)
                  .appendChild(
                      elements
                          .div()
                          .addCss(dui_grow_1)
                          .appendChild(groupRenderer.asElement(cellInfo))));
    }
  }

  /**
   * A functional interface for supplying group criteria for DataTable rows.
   *
   * @param <T> The type of data in the DataTable.
   */
  @FunctionalInterface
  public interface GroupSupplier<T> {

    /**
     * Gets the group criteria for a TableRow.
     *
     * @param tableRow The TableRow for which to determine the group criteria.
     * @return The group criteria.
     */
    String getRecordGroupId(TableRow<T> tableRow);
  }
}
