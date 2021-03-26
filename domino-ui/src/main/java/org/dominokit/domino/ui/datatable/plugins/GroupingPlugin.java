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
package org.dominokit.domino.ui.datatable.plugins;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.style.Unit.px;
import static org.jboss.elemento.Elements.td;
import static org.jboss.elemento.Elements.tr;

import elemental2.dom.HTMLTableCellElement;
import elemental2.dom.Node;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.dominokit.domino.ui.datatable.CellRenderer;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableConfig;
import org.dominokit.domino.ui.datatable.TableRow;
import org.dominokit.domino.ui.datatable.events.OnBeforeDataChangeEvent;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.utils.DominoElement;

/**
 * This plugin renders the table rows in groups.
 *
 * @param <T> the type of the data table records
 */
public class GroupingPlugin<T> implements DataTablePlugin<T>, TableConfig.RowAppender<T> {

  private Map<String, DataGroup<T>> dataGroups = new HashMap<>();
  private final GroupSupplier<T> groupSupplier;
  private CellRenderer<T> groupRenderer;
  private Supplier<BaseIcon<?>> groupExpandedIconSupplier = Icons.ALL::minus_box_mdi;
  private Supplier<BaseIcon<?>> groupCollapsedIconSupplier = Icons.ALL::plus_box_mdi;

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
   * @param groupExpandedIconSupplier Supplier of {@link BaseIcon} to change the icon
   * @return same plugin instance
   */
  public GroupingPlugin<T> setGroupExpandedIcon(Supplier<BaseIcon<?>> groupExpandedIconSupplier) {
    this.groupExpandedIconSupplier = groupExpandedIconSupplier;
    return this;
  }

  /**
   * Changes the group collapse icon
   *
   * @param groupCollapsedIconSupplier Supplier of {@link BaseIcon} to change the icon
   * @return same plugin instance
   */
  public GroupingPlugin<T> setGroupCollapsedIcon(Supplier<BaseIcon<?>> groupCollapsedIconSupplier) {
    this.groupCollapsedIconSupplier = groupCollapsedIconSupplier;
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
      DataGroup<T> dataGroup = new DataGroup<>(tableRow);
      HTMLTableCellElement cellElement =
          td().attr("colspan", dataTable.getTableConfig().getColumns().size() + "").element();
      CellRenderer.CellInfo<T> cellInfo = new CellRenderer.CellInfo<>(tableRow, cellElement);

      BaseIcon<?> groupIconSupplier =
          groupExpandedIconSupplier
              .get()
              .clickable()
              .setToggleIcon(groupCollapsedIconSupplier.get())
              .toggleOnClick(true)
              .addClickListener(evt -> dataGroup.toggleGroup());
      dataGroup.setGroupIconSupplier(groupIconSupplier);

      cellElement.appendChild(
          FlexLayout.create()
              .appendChild(FlexItem.create().appendChild(groupIconSupplier))
              .appendChild(
                  FlexItem.create()
                      .styler(style -> style.setLineHeight(px.of(35)).setPaddingLeft(px.of(10)))
                      .setFlexGrow(1)
                      .appendChild(groupRenderer.asElement(cellInfo)))
              .element());

      dataTable.bodyElement().appendChild(tr().add(cellElement));
      dataTable.bodyElement().appendChild(tableRow.element());
      dataGroups.put(groupId, dataGroup);
    } else {
      DataGroup<T> dataGroup = dataGroups.get(groupId);
      Node nextSibling = dataGroup.lastRow.element().nextSibling;
      if (nonNull(nextSibling)) {
        DominoElement.of(dataTable.bodyElement()).insertBefore(tableRow.element(), nextSibling);
      } else {
        dataTable.bodyElement().appendChild(tableRow.element());
      }

      dataGroup.lastRow = tableRow;
      dataGroup.addRow(tableRow);
    }
  }

  /** Expands all the current groups in the data table */
  public void expandAll() {
    for (DataGroup<T> dataGroup : dataGroups.values()) {
      if (!dataGroup.expanded) {
        dataGroup.toggleGroup();
        dataGroup.getGroupIconSupplier().toggleIcon();
      }
    }
  }

  /** Collapse all the current groups in the data table */
  public void collapseAll() {
    for (DataGroup<T> dataGroup : dataGroups.values()) {
      if (dataGroup.expanded) {
        dataGroup.toggleGroup();
        dataGroup.getGroupIconSupplier().toggleIcon();
      }
    }
  }

  /** {@inheritDoc} */
  @Override
  public void handleEvent(TableEvent event) {
    if (event.getType().equalsIgnoreCase(OnBeforeDataChangeEvent.ON_BEFORE_DATA_CHANGE)) {
      dataGroups.clear();
    }
  }

  private class DataGroup<T> {

    private List<TableRow<T>> groupRows = new ArrayList<>();
    private TableRow<T> lastRow;
    private boolean expanded = true;
    private BaseIcon<?> groupIconSupplier;

    public DataGroup(TableRow<T> lastRow) {
      this.lastRow = lastRow;
      groupRows.add(lastRow);
    }

    public void toggleGroup() {
      expanded = !expanded;
      groupRows.forEach(tableRow -> DominoElement.of(tableRow.element()).toggleDisplay(expanded));
    }

    public void addRow(TableRow<T> tableRow) {
      groupRows.add(tableRow);
    }

    private void setGroupIconSupplier(BaseIcon<?> groupIconSupplier) {
      this.groupIconSupplier = groupIconSupplier;
    }

    private BaseIcon<?> getGroupIconSupplier() {
      return this.groupIconSupplier;
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
