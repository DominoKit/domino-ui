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

import elemental2.dom.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.dominokit.domino.ui.datatable.*;
import org.dominokit.domino.ui.datatable.events.DataSortEvent;
import org.dominokit.domino.ui.datatable.events.SearchClearedEvent;
import org.dominokit.domino.ui.datatable.events.SearchEvent;
import org.dominokit.domino.ui.datatable.events.SortEvent;
import org.dominokit.domino.ui.datatable.events.TableDataUpdatedEvent;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.datatable.events.TablePageChangeEvent;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.icons.ToggleIcon;
import org.dominokit.domino.ui.utils.Unit;
import org.dominokit.domino.ui.utils.ComponentMeta;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.ElementsFactory;

public class TreeGridPlugin<T>
    implements DataTablePlugin<T>, HasPluginConfig<T, TreeGridPlugin<T>, TreePluginConfig<T>> {

  public static final String TREE_GRID_ROW_LEVEL = "tree-grid-row-level";
  public static final String TREE_GRID_ROW_TOGGLE_ICON = "tree-grid-row-toggle-icon";
  public static final String TREE_GRID_EXPAND_COLLAPSE = "plugin-utility-column";
  public static final int BASE_PADDING = 10;
  public static final String ICON_ORDER = "10";

  private ToggleIcon<?,?> headerIcon;
  private int expandedCount = 0;
  private DataTable<T> dataTable;
  private TreePluginConfig<T> config;

  public TreeGridPlugin(SubItemsProvider<T> subItemsProvider) {
    config = new TreePluginConfig<>(subItemsProvider);
  }

  /** {@inheritDoc} */
  @Override
  public void init(DataTable<T> dataTable) {
    this.dataTable = dataTable;
  }

  /** {@inheritDoc} */
  @Override
  public boolean requiresUtilityColumn() {
    return true;
  }

  /**
   * If the row has children it will expand the row, and based on recursive value it might also
   * expand its children sub-children
   *
   * @param row {@link TableRow} to be expanded
   * @param recursive boolean, if true will recursively expand the row children
   */
  public final void expandRow(TableRow<T> row, boolean recursive) {
    if (config.isLazy()) {
      TreeGridRowSubItemsMeta.get(row)
          .ifPresent(
              meta -> {
                meta.getRecords(
                    row,
                    items -> {
                      if (hasChildren(items)) {
                        if (nonNull(config.getParentRowCellsSupplier())) {
                          row.applyMeta(RowRendererMeta.of(new TreeGridRowRenderer()));
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
                    });
              });
    } else {
      addRowChildren(row);
      expand(row, recursive);
      if (row.isRoot()) {
        increment();
      }
    }
  }

  @Override
  public void onRowAdded(DataTable<T> dataTable, TableRow<T> tableRow) {
    if (!config.isLazy()) {
      addRowChildren(tableRow);
    }
  }

  private void addRowChildren(TableRow<T> tableRow) {
    TreeGridRowSubItemsMeta.get(tableRow)
        .ifPresent(
            meta -> {
              meta.getRecords(
                  tableRow,
                  rowItems -> {
                    rowItems.ifPresent(
                        items -> {
                          List<T> records = new ArrayList<>(items);
                          for (int i = 0; i < records.size(); i++) {
                            TableRow<T> subRow = new TableRow<>(records.get(i), i, dataTable);
                            subRow.collapse();
                            TreeGridRowLevel treeGridRowLevel =
                                tableRow
                                    .getMeta(TREE_GRID_ROW_LEVEL)
                                    .map(o -> (TreeGridRowLevel) o)
                                    .orElse(new TreeGridRowLevel(1));
                            tableRow.applyMeta(treeGridRowLevel);
                            subRow.applyMeta(new TreeGridRowLevel(treeGridRowLevel.level + 1));
                            subRow.setParent(tableRow);
                            subRow.applyMeta(RowAppenderMeta.of(new TreeChildRowAppender()));
                            dataTable
                                .getTableConfig()
                                .getPlugins()
                                .forEach(plugin -> plugin.onBeforeAddRow(dataTable, subRow));

                            dataTable.getTableConfig().drawRecord(dataTable, subRow);
                            dataTable.getRows().add(subRow);
                            tableRow.getChildren().add(subRow);
                            applyIndent(subRow);
                          }
                        });
                  });
            });
  }

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
   * If the row has children it will expand the row and recursively expand the row children
   *
   * @param row {@link TableRow} to be expanded
   */
  public final void expandRow(TableRow<T> row) {
    expandRow(row, true);
  }

  /**
   * Expand all table rows, and based on recursive value it might also recursively expand all
   * children
   *
   * @param recursive boolean, if true will recursively expand the row children
   */
  public final void expandAllRows(boolean recursive) {
    dataTable.getRows().forEach(tableRow -> expandRow(tableRow, recursive));
  }

  /**
   * If the row has children it will collapse the row.
   *
   * @param row {@link TableRow} to be collapsed
   */
  public final void collapseRow(TableRow<T> row) {
    collapse(row);
  }

  /** Collapse all table row */
  public final void collapseAllRows() {
    dataTable.getRows().forEach(this::collapseRow);
  }

  private void expand(TableRow<T> row, boolean recursive) {
    row.expand();
    if (recursive) {
      Optional<TreeGridRowToggleIcon> iconMeta = row.getMeta(TREE_GRID_ROW_TOGGLE_ICON);
      iconMeta.ifPresent(
          meta -> {
            if (!meta.icon.isToggled()) {
              meta.icon.toggle();
            }
          });

      for (TableRow<T> child : row.getChildren()) {
        expand(child, false);
      }
    }
  }

  private void collapse(TableRow<T> row) {
    Optional<TreeGridRowToggleIcon> iconMeta = row.getMeta(TREE_GRID_ROW_TOGGLE_ICON);
    iconMeta.ifPresent(
        meta -> {
          if (meta.icon.isToggled()) {
            meta.icon.toggle();
          }
        });

    for (TableRow<T> child : row.getChildren()) {
      child.collapse();
      collapse(child);
    }
    if (row.isRoot()) {
      decrement();
    }
  }

  private void increment() {
    expandedCount++;
    if (!headerIcon.isToggled()) {
      headerIcon.toggle();
    }
  }

  private void decrement() {
    expandedCount--;
    if (expandedCount == 0 && headerIcon.isToggled()) {
      headerIcon.toggle();
    }
  }

  private DominoElement<HTMLTableCellElement> getRowCellElement(TableRow<T> subRow) {
    return elements.elementOf(
        subRow
            .getRowCells()
            .get(TreeGridPlugin.TREE_GRID_EXPAND_COLLAPSE)
            .getCellInfo()
            .getElement());
  }

  /** Adds the expand/collapse/leaf icons to the plugins utility columns cells {@inheritDoc} */
  @Override
  public Optional<List<HTMLElement>> getUtilityElements(
      DataTable<T> dataTable, CellRenderer.CellInfo<T> cellInfo) {
    List<HTMLElement> elements = new ArrayList<>();
    TableRow<T> tableRow = cellInfo.getTableRow();
    Optional<TreeGridRowSubItemsMeta<T>> subRecordsMeta = TreeGridRowSubItemsMeta.get(tableRow);
    ;
    if (config.isLazy() && !subRecordsMeta.get().loaded()) {
      ToggleIcon<?, ?> icon = initExpandCollapseIcons(tableRow);
      icon.setAttribute("order", ICON_ORDER);
      tableRow.applyMeta(new TreeGridRowToggleIcon(icon));
      elements.add(icon.element());
    } else {
      subRecordsMeta.ifPresent(
          meta -> {
            meta.getRecords(
                cellInfo.getTableRow(),
                itemsOptional -> {
                  if (itemsOptional.isPresent() && itemsOptional.get().size() > 0) {
                    ToggleIcon<?,?> icon = initExpandCollapseIcons(tableRow);
                    icon.setAttribute("order", ICON_ORDER);
                    tableRow.applyMeta(new TreeGridRowToggleIcon(icon));
                    elements.add(icon.element());
                  } else {
                    ToggleIcon<?,?> icon = config.getLeafIconSupplier().get().css("dt-tree-grid-leaf");
                    icon.setAttribute("order", ICON_ORDER);
                    tableRow.applyMeta(new TreeGridRowToggleIcon(icon));
                    elements.add(icon.element());
                  }
                });
          });
    }

    DivElement title =
        ElementsFactory.elements.div()
            .setAttribute("order", "100")
            .appendChild(config.getIndentColumnElementSupplier().apply(tableRow));
    elements.add(title.element());

    return Optional.of(elements);
  }

  private ToggleIcon<?,?> initExpandCollapseIcons(TableRow<T> tableRow) {
    ToggleIcon<?,?> icon;
    icon =
        config
            .getExpandColapseIconSupplier()
            .get()
            .clickable();
    icon.addClickListener(
        evt -> {
          if (icon.isToggled()) {
            collapse(tableRow);
          } else {
            expandRow(tableRow);
          }
          evt.stopPropagation();
        });
    return icon;
  }

  /** Adds the Expand all/collapse all to the plugins utility column header {@inheritDoc} */
  @Override
  public void onHeaderAdded(DataTable<T> dataTable, ColumnConfig<T> column) {
    if (column.isUtilityColumn()) {
      ToggleIcon<?,?> baseIcon =
          config
              .getExpandColapseIconSupplier()
              .get()
              .clickable();
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
      column.getHeaderLayout().appendChild(FlexItem.create().setOrder(10).appendChild(baseIcon));
    }
  }

  /** {@inheritDoc} */
  @Override
  public void onBeforeAddRow(DataTable<T> dataTable, TableRow<T> tableRow) {
    if (config.isLazy()) {
      if (nonNull(config.getParentRowCellsSupplier())) {
        tableRow.applyMeta(RowRendererMeta.of(new TreeGridRowRenderer()));
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
                        tableRow.applyMeta(RowRendererMeta.of(new TreeGridRowRenderer()));
                      }
                    }
                  }));
    }
  }

  /** {@inheritDoc} */
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

  private boolean hasChildren(Optional<Collection<T>> items) {
    return items.isPresent() && !items.get().isEmpty();
  }

  @Override
  public TreeGridPlugin<T> setConfig(TreePluginConfig config) {
    this.config = config;
    return this;
  }

  @Override
  public TreePluginConfig<T> getConfig() {
    return config;
  }

  /**
   * Functional interface to provide the cells to be rendered in a parent row
   *
   * @param <T> Type of the table records
   */
  @FunctionalInterface
  public interface ParentRowCellsSupplier<T> {
    List<RowCell<T>> get(DataTable<T> dataTable, TableRow<T> tableRow);
  }

  /**
   * A functional interface to supply record children
   *
   * @param <T> Type of table records.
   */
  @FunctionalInterface
  public interface SubItemsProvider<T> {
    void get(T parent, Consumer<Optional<Collection<T>>> itemsConsumer);
  }

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

  private static class TreeGridRowToggleIcon implements ComponentMeta {
    private final ToggleIcon<?, ?> icon;

    public TreeGridRowToggleIcon(ToggleIcon<?, ?> icon) {
      this.icon = icon;
    }

    @Override
    public String getKey() {
      return TREE_GRID_ROW_TOGGLE_ICON;
    }
  }

  private class TreeGridRowRenderer implements TableRow.RowRenderer<T> {

    @Override
    public void render(DataTable<T> dataTable, TableRow<T> tableRow) {
      List<ColumnConfig<T>> columns = dataTable.getTableConfig().getColumns();
      columns.stream().filter(ColumnConfig::isPluginColumn).forEach(tableRow::renderCell);

      List<RowCell<T>> rowCells = config.getParentRowCellsSupplier().get(dataTable, tableRow);
      rowCells.forEach(
          rowCell -> {
            tableRow.addCell(rowCell);
            tableRow.element().appendChild(rowCell.getCellInfo().getElement());
          });
    }
  }

  private class TreeChildRowAppender implements TableConfig.RowAppender<T> {

    @Override
    public void appendRow(DataTable<T> dataTable, TableRow<T> tableRow) {
      if (nonNull(tableRow.getParent())) {
        TableRow<T> parentRow = tableRow.getParent();
        if (tableRow.getChildren().isEmpty()) {
          dataTable.bodyElement().insertAfter(tableRow, parentRow);
        } else {
          dataTable
              .bodyElement()
              .insertAfter(
                  tableRow, parentRow.getChildren().get(parentRow.getChildren().size() - 1));
        }
      } else {
        dataTable.bodyElement().appendChild(tableRow.element());
      }
    }
  }
}
