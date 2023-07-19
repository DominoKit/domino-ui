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
import elemental2.dom.Node;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import jsinterop.base.Js;
import org.dominokit.domino.ui.datatable.*;
import org.dominokit.domino.ui.datatable.events.*;
import org.dominokit.domino.ui.datatable.plugins.DataTablePlugin;
import org.dominokit.domino.ui.datatable.plugins.HasPluginConfig;
import org.dominokit.domino.ui.datatable.plugins.tree.events.TreeRowCollapsedEvent;
import org.dominokit.domino.ui.datatable.plugins.tree.events.TreeRowExpandedEvent;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.ToggleIcon;
import org.dominokit.domino.ui.utils.ComponentMeta;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.Unit;

/**
 * TreeGridPlugin class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class TreeGridPlugin<T>
    implements DataTablePlugin<T>, HasPluginConfig<T, TreeGridPlugin<T>, TreePluginConfig<T>> {

  /** Constant <code>TREE_GRID_ROW_LEVEL="tree-grid-row-level"</code> */
  public static final String TREE_GRID_ROW_LEVEL = "tree-grid-row-level";
  /** Constant <code>TREE_GRID_ROW_TOGGLE_ICON="tree-grid-row-toggle-icon"</code> */
  public static final String TREE_GRID_ROW_TOGGLE_ICON = "tree-grid-row-toggle-icon";
  /** Constant <code>TREE_GRID_EXPAND_COLLAPSE="plugin-utility-column"</code> */
  public static final String TREE_GRID_EXPAND_COLLAPSE = "plugin-utility-column";
  /** Constant <code>BASE_PADDING=10</code> */
  public static final int BASE_PADDING = 10;
  /** Constant <code>ICON_ORDER="10"</code> */
  public static final String ICON_ORDER = "10";

  private ToggleIcon<?, ?> headerIcon;
  private int expandedCount = 0;
  private DataTable<T> dataTable;
  private TreePluginConfig<T> config;

  /** Constructor for TreeGridPlugin. */
  public TreeGridPlugin() {
    config = new TreePluginConfig<>();
  }

  /** {@inheritDoc} */
  @Override
  public void init(DataTable<T> dataTable) {
    this.dataTable = dataTable;
    this.dataTable.applyMeta(TreeStateMeta.create());
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
   * @param row {@link org.dominokit.domino.ui.datatable.TableRow} to be expanded
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
    }
  }

  /** {@inheritDoc} */
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

  /** {@inheritDoc} */
  @Override
  public void onAllRowsAdded(DataTable<T> dataTable) {
    TreeStateMeta.get(this.dataTable).ifPresent(TreeStateMeta::onAllRowsAdded);
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

  private boolean isOdd(TableRow<T> subRow, TableRow<T> parent) {
    return !dui_odd.isAppliedTo(subRow.element().previousElementSibling);
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
   * @param row {@link org.dominokit.domino.ui.datatable.TableRow} to be expanded
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
   * @param row {@link org.dominokit.domino.ui.datatable.TableRow} to be collapsed
   */
  public final void collapseRow(TableRow<T> row) {
    collapse(row);
  }

  /** Collapse all table row */
  public final void collapseAllRows() {
    dataTable.getRows().forEach(this::collapseRow);
  }

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

  private void showRow(TableRow<T> row) {
    row.show();
  }

  private void collapse(TableRow<T> row) {
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

  private void initLeaf(List<HTMLElement> elements, TableRow<T> tableRow) {
    Icon<?> icon = config.getLeafIconSupplier().get().addCss("dt-tree-grid-leaf");
    icon.setAttribute("order", ICON_ORDER);
    tableRow.applyMeta(new TreeGridRowToggleIcon(icon));
    elements.add(icon.element());
  }

  private void initParent(List<HTMLElement> elements, TableRow<T> tableRow) {
    ToggleIcon<?, ?> icon = initExpandCollapseIcons(tableRow);
    icon.setAttribute("order", ICON_ORDER);
    tableRow.applyMeta(new TreeGridRowToggleIcon(icon));
    elements.add(icon.element());
  }

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

  /** Adds the Expand all/collapse all to the plugins utility column header {@inheritDoc} */
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

  /** {@inheritDoc} */
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

  /** @deprecated use {@link TreePluginConfig#setParentRowCellsSupplier(ParentRowCellsSupplier)} */
  /**
   * setParentRowCellsSupplier.
   *
   * @param parentRowCellsSupplier a {@link
   *     org.dominokit.domino.ui.datatable.plugins.tree.TreeGridPlugin.ParentRowCellsSupplier}
   *     object
   * @return a {@link org.dominokit.domino.ui.datatable.plugins.tree.TreeGridPlugin} object
   */
  @Deprecated
  public TreeGridPlugin<T> setParentRowCellsSupplier(
      ParentRowCellsSupplier<T> parentRowCellsSupplier) {
    this.config.setParentRowCellsSupplier(parentRowCellsSupplier);
    return this;
  }

  /** @deprecated use {@link TreePluginConfig#setLeafIconSupplier(Supplier)} */
  /**
   * setLeafIconSupplier.
   *
   * @param leafIconSupplier a {@link java.util.function.Supplier} object
   * @return a {@link org.dominokit.domino.ui.datatable.plugins.tree.TreeGridPlugin} object
   */
  @Deprecated
  public TreeGridPlugin<T> setLeafIconSupplier(Supplier<Icon<?>> leafIconSupplier) {
    config.setLeafIconSupplier(leafIconSupplier);
    return this;
  }

  /** @deprecated use {@link TreePluginConfig#setIndent(int)} */
  /**
   * setIndent.
   *
   * @param indent a int
   * @return a {@link org.dominokit.domino.ui.datatable.plugins.tree.TreeGridPlugin} object
   */
  @Deprecated
  public TreeGridPlugin<T> setIndent(int indent) {
    config.setIndent(indent);
    return this;
  }

  /** @deprecated use {@link TreePluginConfig#setIndentColumnElementSupplier(Function)} */
  /**
   * setIndentColumnElementSupplier.
   *
   * @param indentColumnElementSupplier a {@link java.util.function.Function} object
   * @return a {@link org.dominokit.domino.ui.datatable.plugins.tree.TreeGridPlugin} object
   */
  @Deprecated
  public TreeGridPlugin<T> setIndentColumnElementSupplier(
      Function<TableRow<T>, Node> indentColumnElementSupplier) {
    config.setIndentColumnElementSupplier(indentColumnElementSupplier);
    return this;
  }

  private boolean hasChildren(Optional<Collection<T>> items) {
    return items.isPresent() && !items.get().isEmpty();
  }

  /** {@inheritDoc} */
  @Override
  public TreeGridPlugin<T> setConfig(TreePluginConfig<T> config) {
    this.config = config;
    return this;
  }

  /** {@inheritDoc} */
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
