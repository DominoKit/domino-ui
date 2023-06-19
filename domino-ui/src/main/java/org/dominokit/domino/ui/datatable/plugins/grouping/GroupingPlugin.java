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

import elemental2.dom.DomGlobal;
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
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.icons.ToggleIcon;
import org.dominokit.domino.ui.icons.ToggleMdiIcon;
import org.dominokit.domino.ui.utils.ComponentMeta;

/**
 * This plugin renders the table rows in groups.
 *
 * @param <T> the type of the data table records
 */
public class GroupingPlugin<T> implements DataTablePlugin<T>, TableConfig.RowAppender<T> {

  private Map<String, DataGroup<T>> dataGroups = new HashMap<>();
  private final GroupSupplier<T> groupSupplier;
  private CellRenderer<T> groupRenderer;
  private Supplier<ToggleIcon<?, ?>> groupExpandedCollapseIconSupplier =
      () -> ToggleMdiIcon.create(Icons.minus_box(), Icons.plus_box());

  /**
   * Create an instance with custom group supplier and group cell renderer
   *
   * @param groupSupplier the {@link GroupSupplier}
   * @param groupRenderer the {@link CellRenderer}
   */
  public GroupingPlugin(GroupSupplier<T> groupSupplier, CellRenderer<T> groupRenderer) {
    this.groupSupplier = groupSupplier;
    this.groupRenderer = groupRenderer;
  }

  /** {@inheritDoc} */
  @Override
  public void init(DataTable<T> dataTable) {
    dataTable.getTableConfig().setRowAppender(this);
  }

  /**
   * Changes the group expand icon
   *
   * @param groupExpandedIconSupplier Supplier of {@link Icon} to change the icon
   * @return same plugin instance
   */
  public GroupingPlugin<T> setGroupExpandedCollapseIcon(
      Supplier<ToggleIcon<?, ?>> groupExpandedIconSupplier) {
    this.groupExpandedCollapseIconSupplier = groupExpandedIconSupplier;
    return this;
  }

  /**
   * {@inheritDoc}
   *
   * <p>the plugin will create a group based on the GroupSupplier and will append rows to the first
   * group matching the criteria
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

      DomGlobal.console.info(groupId + " : " + dataGroup.groupRows.indexOf(tableRow));
    }
  }

  /** Expands all the current groups in the data table */
  public void expandAll() {
    for (DataGroup<T> dataGroup : dataGroups.values()) {
      if (!dataGroup.expanded) {
        dataGroup.toggleGroup();
        dataGroup.getGroupIconSupplier().toggle();
      }
    }
  }

  /** Collapse all the current groups in the data table */
  public void collapseAll() {
    for (DataGroup<T> dataGroup : dataGroups.values()) {
      if (dataGroup.expanded) {
        dataGroup.toggleGroup();
        dataGroup.getGroupIconSupplier().toggle();
      }
    }
  }

  public Map<String, DataGroup<T>> getDataGroups() {
    return dataGroups;
  }

  /** {@inheritDoc} */
  @Override
  public void handleEvent(TableEvent event) {
    if (event.getType().equalsIgnoreCase(OnBeforeDataChangeEvent.ON_BEFORE_DATA_CHANGE)) {
      dataGroups.clear();
    }
  }

  public static class DataGroup<T> implements ComponentMeta {

    private static final String KEY = "dataGroup";

    private List<TableRow<T>> groupRows = new ArrayList<>();
    private TableRow<T> lastRow;
    private CellRenderer.CellInfo<T> cellInfo;
    private boolean expanded = true;
    private ToggleIcon<?, ?> groupIconSupplier;
    private CellRenderer<T> groupRenderer;

    public DataGroup(TableRow<T> lastRow, CellRenderer.CellInfo<T> cellInfo) {
      this.lastRow = lastRow;
      this.cellInfo = cellInfo;
      addRow(lastRow);
    }

    public static <T> Optional<DataGroup<T>> fromRow(TableRow<T> tableRow) {
      return tableRow.getMeta(KEY);
    }

    public void toggleGroup() {
      expanded = !expanded;
      groupRows.forEach(tableRow -> elements.elementOf(tableRow.element()).toggleDisplay(expanded));
    }

    public void addRow(TableRow<T> tableRow) {
      groupRows.add(tableRow);
      tableRow.addCss(isOdd(tableRow) ? dui_odd : dui_even);
      tableRow.applyMeta(this);
    }

    private DataGroup<T> setGroupIconSupplier(ToggleIcon<?, ?> groupIconSupplier) {
      this.groupIconSupplier = groupIconSupplier;
      return this;
    }

    private ToggleIcon<?, ?> getGroupIconSupplier() {
      return this.groupIconSupplier;
    }

    private DataGroup<T> setGroupRenderer(CellRenderer<T> groupRenderer) {
      this.groupRenderer = groupRenderer;
      return this;
    }

    @Override
    public String getKey() {
      return KEY;
    }

    private boolean isOdd(TableRow<T> tableRow) {
      return groupRows.indexOf(tableRow) % 2 > 0;
    }

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
   * this interface is to provide an implementation to define each row group
   *
   * @param <T> the type of the table row record
   */
  @FunctionalInterface
  public interface GroupSupplier<T> {
    /**
     * determines the row group
     *
     * @param tableRow the {@link TableRow}
     * @return String group name the table row belongs to
     */
    String getRecordGroupId(TableRow<T> tableRow);
  }
}
