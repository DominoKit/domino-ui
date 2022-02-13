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

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLTableCellElement;
import elemental2.dom.Node;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.dominokit.domino.ui.datatable.CellRenderer;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.RowCell;
import org.dominokit.domino.ui.datatable.TableRow;
import org.dominokit.domino.ui.datatable.events.DataSortEvent;
import org.dominokit.domino.ui.datatable.events.SearchClearedEvent;
import org.dominokit.domino.ui.datatable.events.SearchEvent;
import org.dominokit.domino.ui.datatable.events.SortEvent;
import org.dominokit.domino.ui.datatable.events.TableDataUpdatedEvent;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.datatable.events.TablePageChangeEvent;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Unit;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.TextNode;

public class TreeGridPlugin<T> implements DataTablePlugin<T> {

  public static final String TREE_GRID_ROW_LEVEL = "tree-grid-row-level";
  public static final String TREE_GRID_ROW_SUBITEMS = "tree-grid-row-sub-items";
  public static final String TREE_GRID_ROW_TOGGLE_ICON = "tree-grid-row-toggle-icon";
  public static final String TREE_GRID_EXPAND_COLLAPSE = "plugin-utility-column";
  public static final int DEFAULT_INDENT = 20;
  public static final int BASE_PADDING = 10;
  public static final String ICON_ORDER = "10";

  private final SubItemsProvider<T> subItemsProvider;
  private ParentRowCellsSupplier<T> parentRowCellsSupplier;
  private Supplier<BaseIcon<?>> expandIconSupplier = Icons.ALL::menu_right_mdi;
  private Supplier<BaseIcon<?>> collapseIconSupplier = Icons.ALL::menu_down_mdi;
  private Supplier<BaseIcon<?>> leafIconSupplier = Icons.ALL::circle_medium_mdi;
  private Function<TableRow<T>, Node> indentColumnElementSupplier = tableRow -> TextNode.empty();
  private int indent = DEFAULT_INDENT;
  private BaseIcon<?> headerIcon;
  private int expandedCount = 0;
  private DataTable<T> dataTable;

  public TreeGridPlugin(SubItemsProvider<T> subItemsProvider) {
    this.subItemsProvider = subItemsProvider;
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
    expand(row, recursive);
    if (row.isRoot()) {
      increment();
    }
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
    row.show();
    if (recursive) {
      TreeGridRowToggleIcon treeGridRowToggleIcon = row.getMetaObject(TREE_GRID_ROW_TOGGLE_ICON);
      if (!treeGridRowToggleIcon.icon.isToggled()) {
        treeGridRowToggleIcon.icon.toggleIcon();
      }
      for (TableRow<T> child : row.getChildren()) {
        expand(child, false);
      }
    }
  }

  private void collapse(TableRow<T> row) {
    TreeGridRowToggleIcon treeGridRowToggleIcon = row.getMetaObject(TREE_GRID_ROW_TOGGLE_ICON);
    if (treeGridRowToggleIcon.icon.isToggled()) {
      treeGridRowToggleIcon.icon.toggleIcon();
    }
    for (TableRow<T> child : row.getChildren()) {
      child.hide();
      collapse(child);
    }
    if (row.isRoot()) {
      decrement();
    }
  }

  private void increment() {
    expandedCount++;
    if (!headerIcon.isToggled()) {
      headerIcon.toggleIcon();
    }
  }

  private void decrement() {
    expandedCount--;
    if (expandedCount == 0 && headerIcon.isToggled()) {
      headerIcon.toggleIcon();
    }
  }

  private DominoElement<HTMLTableCellElement> getRowCellElement(TableRow<T> subRow) {
    return DominoElement.of(
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
    getSubRecords(
        cellInfo.getTableRow(),
        items -> {
          TableRow<T> tableRow = cellInfo.getTableRow();
          BaseIcon<?> icon;
          if (!isParent(items)) {
            icon = leafIconSupplier.get().css("dt-tree-grid-leaf");
          } else {
            icon = expandIconSupplier.get().setToggleIcon(collapseIconSupplier.get()).clickable();
            icon.addClickListener(
                evt -> {
                  if (icon.isToggled()) {
                    collapse(tableRow);
                  } else {
                    expandRow(tableRow);
                  }
                  evt.stopPropagation();
                });
          }
          icon.setAttribute("order", ICON_ORDER);
          DominoElement<HTMLDivElement> title =
              DominoElement.div()
                  .setAttribute("order", "100")
                  .appendChild(indentColumnElementSupplier.apply(tableRow));
          tableRow.addMetaObject(new TreeGridRowToggleIcon(icon));
          elements.add(icon.element());
          elements.add(title.element());
        });

    return Optional.of(elements);
  }

  private void getSubRecords(TableRow<T> tableRow, Consumer<Optional<Collection<T>>> consumer) {
    SubItemMetaObject<T> metaObject = tableRow.getMetaObject(TREE_GRID_ROW_SUBITEMS);
    if (nonNull(metaObject)) {
      consumer.accept(metaObject.subItems);
    } else {
      subItemsProvider.get(tableRow.getRecord(), consumer);
    }
  }

  /** Adds the Expand all/collpase all to the plugins utility column header {@inheritDoc} */
  @Override
  public void onHeaderAdded(DataTable<T> dataTable, ColumnConfig<T> column) {
    if (column.isUtilityColumn()) {
      BaseIcon<?> baseIcon =
          expandIconSupplier.get().setToggleIcon(collapseIconSupplier.get()).clickable();
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
    if (nonNull(parentRowCellsSupplier)) {
      getSubRecords(
          tableRow,
          items -> {
            if (isParent(items)) {
              tableRow.setRowRenderer(new TreeGridRowRenderer());
            }
          });
    }
  }

  /** {@inheritDoc} */
  @Override
  public void onRowAdded(DataTable<T> dataTable, TableRow<T> tableRow) {
    getSubRecords(
        tableRow,
        itemsOptional -> {
          if (!isParent(itemsOptional)) {
            return;
          }
          List<T> items = new ArrayList<>(itemsOptional.get());
          List<TableRow<T>> subRows = new ArrayList<>();
          for (int i = 0; i < items.size(); i++) {
            TableRow<T> subRow = new TableRow<>(items.get(i), i, dataTable);
            subRow.hide();
            TreeGridRowLevel treeGridRowLevel =
                Optional.ofNullable(tableRow.getMetaObject(TREE_GRID_ROW_LEVEL))
                    .map(o -> (TreeGridRowLevel) o)
                    .orElse(new TreeGridRowLevel(1));
            tableRow.addMetaObject(treeGridRowLevel);
            subRow.addMetaObject(new TreeGridRowLevel(treeGridRowLevel.level + 1));
            dataTable
                .getTableConfig()
                .getPlugins()
                .forEach(plugin -> plugin.onBeforeAddRow(dataTable, subRow));
            dataTable.getTableConfig().drawRecord(dataTable, subRow);
            dataTable.getRows().add(subRow);
            subRow.setParent(tableRow);
            subRows.add(subRow);
            getRowCellElement(subRow)
                .setPaddingLeft(Unit.px.of(treeGridRowLevel.level * indent + BASE_PADDING));
          }
          tableRow.setChildren(subRows);
        });
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
          headerIcon.toggleIcon();
        }
        expandedCount = 0;
        break;
    }
  }

  /**
   * Set a supplier that provides cells to be rendered in a parent row cells, this can be used to
   * provide a custom UI for parent rows
   *
   * @param parentRowCellsSupplier {@link ParentRowCellsSupplier}
   * @return Same plugin instance
   */
  public TreeGridPlugin<T> setParentRowCellsSupplier(
      ParentRowCellsSupplier<T> parentRowCellsSupplier) {
    this.parentRowCellsSupplier = parentRowCellsSupplier;
    return this;
  }

  /**
   * Sets a supplier for a custom expand icon instead of the default one
   *
   * @param expandIconSupplier {@link Supplier} of {@link BaseIcon}
   * @return Same plugin instance
   */
  public TreeGridPlugin<T> setExpandIconSupplier(Supplier<BaseIcon<?>> expandIconSupplier) {
    if (isNull(expandIconSupplier)) {
      this.expandIconSupplier = () -> Icons.ALL.plus_mdi().size18();
    } else {
      this.expandIconSupplier = expandIconSupplier;
    }
    return this;
  }

  /**
   * Sets a supplier for a custom collapse icon instead of the default one
   *
   * @param collapseIconSupplier {@link Supplier} of {@link BaseIcon}
   * @return Same plugin instance
   */
  public TreeGridPlugin<T> setCollapseIconSupplier(Supplier<BaseIcon<?>> collapseIconSupplier) {
    if (isNull(collapseIconSupplier)) {
      this.collapseIconSupplier = () -> Icons.ALL.minus_mdi().size18();
    } else {
      this.collapseIconSupplier = collapseIconSupplier;
    }
    return this;
  }

  /**
   * Sets a supplier for a custom leaf row icon instead of the default one
   *
   * @param leafIconSupplier {@link Supplier} of {@link BaseIcon}
   * @return Same plugin instance
   */
  public TreeGridPlugin<T> setLeafIconSupplier(Supplier<BaseIcon<?>> leafIconSupplier) {
    if (isNull(leafIconSupplier)) {
      this.leafIconSupplier = () -> Icons.ALL.circle_medium_mdi().size18();
    } else {
      this.leafIconSupplier = leafIconSupplier;
    }
    return this;
  }

  /**
   * Sets indent value to be added for each tree gird level
   *
   * @param indent int
   * @return Same plugin instance
   */
  public TreeGridPlugin<T> setIndent(int indent) {
    if (indent < 0) {
      this.indent = DEFAULT_INDENT;
    } else {
      this.indent = indent;
    }
    return this;
  }

  /**
   * Sets a supplier of elements to be appended to the tree grid indent column as part of the
   * utility columns cells
   *
   * @param indentColumnElementSupplier {@link Function} that takes a {@link TableRow} and return a
   *     {@link Node}
   * @return same plugin instance
   */
  public TreeGridPlugin<T> setIndentColumnElementSupplier(
      Function<TableRow<T>, Node> indentColumnElementSupplier) {
    if (isNull(indentColumnElementSupplier)) {
      this.indentColumnElementSupplier = tableRow -> TextNode.empty();
    } else {
      this.indentColumnElementSupplier = indentColumnElementSupplier;
    }
    return this;
  }

  private boolean isParent(Optional<Collection<T>> items) {
    return items.isPresent() && !items.get().isEmpty();
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

  private static class TreeGridRowLevel implements TableRow.RowMetaObject {
    private final int level;

    public TreeGridRowLevel(int level) {
      this.level = level;
    }

    @Override
    public String getKey() {
      return TREE_GRID_ROW_LEVEL;
    }
  }

  private static class SubItemMetaObject<T> implements TableRow.RowMetaObject {
    private final Optional<Collection<T>> subItems;

    public SubItemMetaObject(Optional<Collection<T>> subItems) {
      this.subItems = subItems;
    }

    @Override
    public String getKey() {
      return TREE_GRID_ROW_SUBITEMS;
    }
  }

  private static class TreeGridRowToggleIcon implements TableRow.RowMetaObject {
    private final BaseIcon<?> icon;

    public TreeGridRowToggleIcon(BaseIcon<?> icon) {
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

      List<RowCell<T>> rowCells = parentRowCellsSupplier.get(dataTable, tableRow);
      rowCells.forEach(
          rowCell -> {
            tableRow.addCell(rowCell);
            tableRow.element().appendChild(rowCell.getCellInfo().getElement());
          });
    }
  }
}
