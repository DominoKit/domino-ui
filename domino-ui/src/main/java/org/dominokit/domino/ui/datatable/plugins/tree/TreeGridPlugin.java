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

import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLTableCellElement;
import java.util.*;
import java.util.stream.Collectors;
import jsinterop.base.Js;
import org.dominokit.domino.ui.datatable.*;
import org.dominokit.domino.ui.datatable.events.*;
import org.dominokit.domino.ui.datatable.plugins.DataTablePlugin;
import org.dominokit.domino.ui.datatable.plugins.HasPluginConfig;
import org.dominokit.domino.ui.datatable.plugins.tree.events.TreeRowCollapsedEvent;
import org.dominokit.domino.ui.datatable.plugins.tree.events.TreeRowExpandedEvent;
import org.dominokit.domino.ui.datatable.plugins.tree.events.TreeRowOnBeforeCollapseEvent;
import org.dominokit.domino.ui.datatable.plugins.tree.events.TreeRowOnBeforeExpandEvent;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.ToggleIcon;
import org.dominokit.domino.ui.utils.ComponentMeta;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.Unit;

/**
 * The TreeGridPlugin is a DataTable plugin that allows you to create hierarchical tables with
 * expandable/collapsible rows. It provides functionality to expand and collapse rows, making it
 * easy to display tree-like data structures in your DataTable. This plugin adds a utility column to
 * the DataTable for expand/collapse icons in each row.
 *
 * <p>Usage example:
 *
 * <pre>
 * TreeGridPlugin<MyData> treeGridPlugin = new TreeGridPlugin<>();
 * treeGridPlugin.expandAllRows(true);
 *
 * DataTable<MyData> dataTable = DataTable.create();
 * dataTable.addPlugin(treeGridPlugin);
 * </pre>
 *
 * All rows in the DataTable can be expanded or collapsed at once using the expandAllRows and
 * collapseAllRows methods. You can also expand or collapse individual rows using the expandRow and
 * collapseRow methods.
 */
public class TreeGridPlugin<T>
    implements DataTablePlugin<T>, HasPluginConfig<T, TreeGridPlugin<T>, TreePluginConfig<T>> {

  public static final String TREE_GRID_ROW_LEVEL = "tree-grid-row-level";

  public static final String TREE_GRID_ROW_TOGGLE_ICON = "tree-grid-row-toggle-icon";

  public static final String TREE_GRID_EXPAND_COLLAPSE = "plugin-utility-column";

  public static final int BASE_PADDING = 10;

  public static final String ICON_ORDER = "10";

  private ToggleIcon<?, ?> headerIcon;
  private int expandedCount = 0;
  private DataTable<T> dataTable;
  private TreePluginConfig<T> config;

  /** Constructs a new TreeGridPlugin with default configuration. */
  public TreeGridPlugin() {
    config = new TreePluginConfig<>();
  }

  /**
   * Initializes the TreeGridPlugin with the given DataTable. This method is called by the DataTable
   * when the plugin is added. It sets up the necessary configuration and applies the TreeStateMeta
   * to keep track of the tree state.
   *
   * @param dataTable The DataTable to which this plugin is being added.
   */
  @Override
  public void init(DataTable<T> dataTable) {
    this.dataTable = dataTable;
    this.dataTable.applyMeta(TreeStateMeta.create());
  }

  /**
   * Indicates whether this plugin requires a utility column in the DataTable. The utility column is
   * used to display expand/collapse icons for tree rows.
   *
   * @return {@code true} if a utility column is required, {@code false} otherwise.
   */
  @Override
  public boolean requiresUtilityColumn() {
    return true;
  }

  /**
   * Expands a specific row in the DataTable.
   *
   * @param row The TableRow to expand.
   * @param recursive Whether to recursively expand child rows.
   */
  public void expandRow(TableRow<T> row, boolean recursive) {
    this.dataTable.fireTableEvent(new TreeRowOnBeforeExpandEvent<>(row));
    if (config.isLazy()) {
      TreeGridRowSubItemsMeta.get(row)
          .ifPresent(
              meta -> {
                meta.getRecords(
                    row,
                    items -> {
                      if (hasChildren(items)) {
                        if (nonNull(config.getParentRowCellsSupplier())) {
                          row.applyMeta(RowRendererMeta.of(new TreeGridRowRenderer<>(this)));
                          row.clearElement();
                          row.render();
                          applyIndent(row);
                        }
                        addRowChildren(row);
                        expand(row, recursive);
                        if (row.isRoot()) {
                          increment();
                        }
                      } else {
                        row.removeMeta(RowRendererMeta.TABLE_ROW_RENDERER_META);
                        row.clearElement();
                        row.render();
                        applyIndent(row);
                      }
                      TreeStateMeta.get(this.dataTable)
                          .ifPresent(
                              treeStateMeta -> {
                                treeStateMeta.onRowExpanded(row);
                              });
                      this.dataTable.fireTableEvent(new TreeRowExpandedEvent<>(row));
                    });
              });
    } else {
      expand(row, recursive);
      if (row.isRoot()) {
        increment();
      }
      this.dataTable.fireTableEvent(new TreeRowExpandedEvent<>(row));
    }
  }

  /**
   * Handles the event when a new row is added to the DataTable. If the TreeGridPlugin is not
   * configured as lazy, it adds the children of the row to the table. If the added row was
   * previously expanded, it ensures that the child rows are visible as well.
   *
   * @param dataTable The DataTable to which the row is added.
   * @param tableRow The TableRow that was added.
   */
  @Override
  public void onRowAdded(DataTable<T> dataTable, TableRow<T> tableRow) {
    if (!config.isLazy()) {
      addRowChildren(tableRow);
    }

    TreeStateMeta.get(this.dataTable)
        .ifPresent(
            treeStateMeta -> {
              if (treeStateMeta.isRowExpanded(tableRow)) {
                expandRow(tableRow, false);
                treeStateMeta.onExpandedRowAdded(tableRow);
              }
            });
  }

  /**
   * Handles the event when all rows are added to the DataTable. This method is called after all
   * rows have been added.
   *
   * @param dataTable The DataTable to which rows are added.
   */
  @Override
  public void onAllRowsAdded(DataTable<T> dataTable) {
    TreeStateMeta.get(this.dataTable).ifPresent(TreeStateMeta::onAllRowsAdded);
  }

  /**
   * Adds child rows to the given parent TableRow based on the TreeGridRowSubItemsMeta information.
   * If the parent row already has children, the new child rows are added after the existing ones.
   *
   * @param tableRow The parent TableRow to which child rows are added.
   */
  private void addRowChildren(TableRow<T> tableRow) {
    TreeGridRowSubItemsMeta.get(tableRow)
        .ifPresent(
            meta -> {
              meta.getRecords(
                  tableRow,
                  rowItems -> {
                    rowItems.ifPresent(
                        items -> {
                          if (tableRow.getChildren().isEmpty()) {
                            List<T> records = new ArrayList<>(items);
                            for (int i = 0; i < records.size(); i++) {
                              TableRow<T> subRow = new TableRow<>(records.get(i), i, dataTable);
                              subRow.hide();
                              TreeGridRowLevel treeGridRowLevel =
                                  tableRow
                                      .getMeta(TREE_GRID_ROW_LEVEL)
                                      .map(o -> (TreeGridRowLevel) o)
                                      .orElse(new TreeGridRowLevel(1));
                              tableRow.applyMeta(treeGridRowLevel);
                              subRow.applyMeta(new TreeGridRowLevel(treeGridRowLevel.level + 1));
                              subRow.setParent(tableRow);
                              subRow.applyMeta(
                                  RowAppenderMeta.of(new TreeChildRowAppender<>(config)));
                              dataTable
                                  .getTableConfig()
                                  .getPlugins()
                                  .forEach(plugin -> plugin.onBeforeAddRow(dataTable, subRow));

                              dataTable.getTableConfig().drawRecord(dataTable, subRow);
                              dataTable.getRows().add(subRow);
                              tableRow.getChildren().add(subRow);
                              applyIndent(subRow);
                            }
                          } else {
                            Map<T, TableRow<T>> rowsMap =
                                tableRow.getChildren().stream()
                                    .collect(Collectors.toMap(TableRow::getRecord, row -> row));
                            List<T> records = new ArrayList<>(items);
                            records.forEach(
                                record -> {
                                  TableRow<T> nodeRow = rowsMap.get(record);

                                  TableRow<T> otherNode =
                                      tableRow.getChildren().get(tableRow.getChildren().size() - 1);
                                  dataTable.bodyElement().insertAfter(nodeRow, otherNode);
                                });
                          }
                        });
                  });
            });
  }

  /**
   * Checks if a TableRow is odd relative to its parent.
   *
   * @param subRow The TableRow to check.
   * @param parent The parent TableRow.
   * @return {@code true} if the subRow is odd, {@code false} otherwise.
   */
  private boolean isOdd(TableRow<T> subRow, TableRow<T> parent) {
    return !dui_odd.isAppliedTo(subRow.element().previousElementSibling);
  }

  /**
   * Applies the indentation to a TableRow based on its level in the tree hierarchy. The indentation
   * is determined by the TreeGridPlugin's configuration.
   *
   * @param tableRow The TableRow to which the indentation is applied.
   */
  private void applyIndent(TableRow<T> tableRow) {
    TreeGridRowLevel treeGridRowLevel =
        tableRow
            .getMeta(TREE_GRID_ROW_LEVEL)
            .map(o -> (TreeGridRowLevel) o)
            .orElse(new TreeGridRowLevel(1));
    getRowCellElement(tableRow)
        .setPaddingLeft(
            Unit.px.of(
                (treeGridRowLevel.level >= 1 ? treeGridRowLevel.level - 1 : treeGridRowLevel.level)
                        * config.getIndent()
                    + BASE_PADDING));
  }

  /**
   * Expands a specific row in the DataTable with recursive expansion of child rows.
   *
   * @param row The TableRow to expand.
   */
  public void expandRow(TableRow<T> row) {
    expandRow(row, true);
  }

  /**
   * Expands all rows in the DataTable. If "recursive" is set to true, child rows will also be
   * expanded.
   *
   * @param recursive If true, child rows will also be expanded; otherwise, only the parent rows are
   *     expanded.
   */
  public void expandAllRows(boolean recursive) {
    dataTable.getRows().forEach(tableRow -> expandRow(tableRow, recursive));
  }

  /**
   * Collapses a specific row in the DataTable, hiding its child rows if any.
   *
   * @param row The TableRow to collapse.
   */
  public void collapseRow(TableRow<T> row) {
    collapse(row);
  }

  /** Collapses all rows in the DataTable, hiding child rows if any. */
  public void collapseAllRows() {
    dataTable.getRows().forEach(this::collapseRow);
  }

  /**
   * Expands a specific TableRow, making it visible, and optionally expanding its child rows
   * recursively.
   *
   * @param row The TableRow to expand.
   * @param recursive If true, child rows are expanded recursively; otherwise, only the direct child
   *     rows are expanded.
   */
  private void expand(TableRow<T> row, boolean recursive) {
    showRow(row);
    for (TableRow<T> child : row.getChildren()) {
      showRow(child);
      if (recursive) {
        expandRow(child, recursive);
      }
    }

    Optional<TreeGridRowToggleIcon> iconMeta = row.getMeta(TREE_GRID_ROW_TOGGLE_ICON);
    iconMeta.ifPresent(
        meta -> {
          ToggleIcon<?, ?> icon = Js.uncheckedCast(meta.icon);
          if (!icon.isToggled()) {
            icon.toggle();
          }
        });
  }

  /**
   * Makes a TableRow visible by displaying it in the DataTable.
   *
   * @param row The TableRow to show.
   */
  private void showRow(TableRow<T> row) {
    row.show();
  }

  /**
   * Collapses a specific TableRow, hiding it, and optionally collapsing its child rows recursively.
   *
   * @param row The TableRow to collapse.
   * @param recursive If true, child rows are collapsed recursively; otherwise, only the direct
   *     child rows are collapsed.
   */
  private void collapse(TableRow<T> row) {
    this.dataTable.fireTableEvent(new TreeRowOnBeforeCollapseEvent<>(row));
    Optional<TreeGridRowToggleIcon> iconMeta = row.getMeta(TREE_GRID_ROW_TOGGLE_ICON);
    iconMeta.ifPresent(
        meta -> {
          if (row.isParent()) {
            ToggleIcon<?, ?> icon = Js.uncheckedCast(meta.icon);
            if (icon.isToggled()) {
              icon.toggle();
            }
          }
        });

    for (TableRow<T> child : row.getChildren()) {
      if (config.isLazy()) {
        child.remove();
      } else {
        child.hide();
      }
      collapse(child);
    }
    if (config.isLazy()) {
      row.getChildren().clear();
    }
    if (row.isRoot()) {
      decrement();
    }
    TreeStateMeta.get(this.dataTable).ifPresent(treeStateMeta -> treeStateMeta.onRowCollapsed(row));
    this.dataTable.fireTableEvent(new TreeRowCollapsedEvent<>(row));
  }

  /** Increments the count of expanded rows and toggles the header icon if needed. */
  private void increment() {
    expandedCount++;
    if (!headerIcon.isToggled()) {
      headerIcon.toggle();
    }
  }

  /**
   * Decrements the count of expanded rows and toggles the header icon if all rows are collapsed.
   */
  private void decrement() {
    expandedCount--;
    if (expandedCount == 0 && headerIcon.isToggled()) {
      headerIcon.toggle();
    }
  }

  /**
   * Gets the DOM element of the cell associated with a TableRow.
   *
   * @param subRow The TableRow for which the cell element is retrieved.
   * @return A DominoElement representing the cell element.
   */
  private DominoElement<HTMLTableCellElement> getRowCellElement(TableRow<T> subRow) {
    return elements.elementOf(
        subRow
            .getRowCells()
            .get(TreeGridPlugin.TREE_GRID_EXPAND_COLLAPSE)
            .getCellInfo()
            .getElement());
  }

  /**
   * Generates utility elements to be displayed in a cell of the DataTable.
   *
   * @param dataTable The DataTable instance.
   * @param cellInfo Information about the cell.
   * @return A list of utility elements to be displayed in the cell.
   */
  @Override
  public Optional<List<HTMLElement>> getUtilityElements(
      DataTable<T> dataTable, CellRenderer.CellInfo<T> cellInfo) {
    List<HTMLElement> elementsList = new ArrayList<>();
    TableRow<T> tableRow = cellInfo.getTableRow();
    Optional<TreeGridRowSubItemsMeta<T>> subRecordsMeta = TreeGridRowSubItemsMeta.get(tableRow);

    if (config.isLazy() && !subRecordsMeta.get().hasChildren(tableRow)) {
      initLeaf(elementsList, tableRow);
    } else if (config.isLazy() && !subRecordsMeta.get().loaded()) {
      initParent(elementsList, tableRow);
    } else {
      subRecordsMeta.ifPresent(
          meta -> {
            meta.getRecords(
                cellInfo.getTableRow(),
                itemsOptional -> {
                  if (itemsOptional.isPresent() && itemsOptional.get().size() > 0) {
                    initParent(elementsList, tableRow);
                  } else {
                    initLeaf(elementsList, tableRow);
                  }
                });
          });
    }

    DivElement title =
        elements
            .div()
            .setAttribute("order", 100)
            .appendChild(config.getIndentColumnElementSupplier().apply(tableRow));
    elementsList.add(title.element());

    return Optional.of(elementsList);
  }

  /**
   * Initializes the utility elements for a leaf node in the tree.
   *
   * @param elements A list of utility elements to which the leaf icon will be added.
   * @param tableRow The TableRow representing the leaf node.
   */
  private void initLeaf(List<HTMLElement> elements, TableRow<T> tableRow) {
    Icon<?> icon = config.getLeafIconSupplier().get().addCss("dt-tree-grid-leaf");
    icon.setAttribute("order", ICON_ORDER);
    tableRow.applyMeta(new TreeGridRowToggleIcon(icon));
    elements.add(icon.element());
  }

  /**
   * Initializes the utility elements for a parent node in the tree.
   *
   * @param elements A list of utility elements to which the expand/collapse icon will be added.
   * @param tableRow The TableRow representing the parent node.
   */
  private void initParent(List<HTMLElement> elements, TableRow<T> tableRow) {
    ToggleIcon<?, ?> icon = initExpandCollapseIcons(tableRow);
    icon.setAttribute("order", ICON_ORDER);
    tableRow.applyMeta(new TreeGridRowToggleIcon(icon));
    elements.add(icon.element());
  }

  /**
   * Initializes the expand/collapse icon for a parent node in the tree.
   *
   * @param tableRow The TableRow representing the parent node.
   * @return The initialized ToggleIcon for expand/collapse functionality.
   */
  private ToggleIcon<?, ?> initExpandCollapseIcons(TableRow<T> tableRow) {
    ToggleIcon<?, ?> icon;
    icon = config.getExpandToggleIconSupplier().get().clickable();
    icon.addClickListener(
        evt -> {
          if (icon.isToggled()) {
            collapse(tableRow);
          } else {
            expandRow(tableRow, false);
          }
          evt.stopPropagation();
        });
    return icon;
  }

  /**
   * Handles the event when a header is added to the DataTable.
   *
   * @param dataTable The DataTable instance.
   * @param column The ColumnConfig that was added as a header.
   */
  @Override
  public void onHeaderAdded(DataTable<T> dataTable, ColumnConfig<T> column) {
    if (column.isUtilityColumn()) {
      ToggleIcon<?, ?> baseIcon = config.getExpandToggleIconSupplier().get().clickable();

      baseIcon.addClickListener(
          evt -> {
            if (baseIcon.isToggled()) {
              collapseAllRows();
            } else {
              expandAllRows(true);
            }
            evt.stopPropagation();
          });
      headerIcon = baseIcon;
      column.appendChild(div().addCss(dui_order_10).appendChild(baseIcon));
    }
  }

  /**
   * Handles the event before adding a row to the DataTable.
   *
   * @param dataTable The DataTable instance.
   * @param tableRow The TableRow to be added.
   */
  @Override
  public void onBeforeAddRow(DataTable<T> dataTable, TableRow<T> tableRow) {
    if (config.isLazy()) {
      if (nonNull(config.getParentRowCellsSupplier())) {
        tableRow.applyMeta(RowRendererMeta.of(new TreeGridRowRenderer(this)));
      }
      tableRow.applyMeta(TreeGridRowSubItemsMeta.of(config));
    } else {
      tableRow.applyMeta(
          TreeGridRowSubItemsMeta.of(config)
              .getRecords(
                  tableRow,
                  items -> {
                    if (hasChildren(items)) {
                      if (nonNull(config.getParentRowCellsSupplier())) {
                        tableRow.applyMeta(RowRendererMeta.of(new TreeGridRowRenderer(this)));
                      }
                    }
                  }));
    }
  }

  /**
   * Handles table-related events such as sorting, searching, data updates, and pagination. Updates
   * the header icon and resets the expanded count if necessary.
   *
   * @param event The table event to handle.
   */
  @Override
  public void handleEvent(TableEvent event) {
    switch (event.getType()) {
      case SortEvent.SORT_EVENT:
      case DataSortEvent.EVENT:
      case SearchEvent.SEARCH_EVENT:
      case SearchClearedEvent.SEARCH_EVENT_CLEARED:
      case TableDataUpdatedEvent.DATA_UPDATED:
      case TablePageChangeEvent.PAGINATION_EVENT:
        if (headerIcon.isToggled()) {
          headerIcon.toggle();
        }
        expandedCount = 0;
        break;
    }
  }

  /**
   * Checks if a collection of items has children.
   *
   * @param items The collection of items to check.
   * @return {@code true} if the collection is present and not empty; otherwise, {@code false}.
   */
  private boolean hasChildren(Optional<Collection<T>> items) {
    return items.isPresent() && !items.get().isEmpty();
  }

  /**
   * Sets the configuration for the TreeGridPlugin.
   *
   * @param config The configuration to set.
   * @return The TreeGridPlugin instance.
   */
  @Override
  public TreeGridPlugin<T> setConfig(TreePluginConfig<T> config) {
    this.config = config;
    return this;
  }

  /**
   * Retrieves the current configuration of the TreeGridPlugin.
   *
   * @return The current TreePluginConfig instance.
   */
  @Override
  public TreePluginConfig<T> getConfig() {
    return config;
  }

  /**
   * Functional interface for supplying parent row cells.
   *
   * @param <T> The data type of the DataTable.
   */
  @FunctionalInterface
  public interface ParentRowCellsSupplier<T> {
    List<RowCell<T>> get(DataTable<T> dataTable, TableRow<T> tableRow);
  }

  /** Inner class representing the level of a tree grid row. */
  private static class TreeGridRowLevel implements ComponentMeta {
    private final int level;

    public TreeGridRowLevel(int level) {
      this.level = level;
    }

    @Override
    public String getKey() {
      return TREE_GRID_ROW_LEVEL;
    }
  }

  /** Inner class representing the toggle icon for a tree grid row. */
  private static class TreeGridRowToggleIcon implements ComponentMeta {
    private final Icon<?> icon;

    public TreeGridRowToggleIcon(Icon<?> icon) {
      this.icon = icon;
    }

    @Override
    public String getKey() {
      return TREE_GRID_ROW_TOGGLE_ICON;
    }
  }
}
