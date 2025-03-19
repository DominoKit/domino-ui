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

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

import elemental2.dom.DOMRect;
import elemental2.dom.HTMLElement;
import java.util.*;
import java.util.function.Consumer;
import org.dominokit.domino.ui.datatable.plugins.DataTablePlugin;
import org.dominokit.domino.ui.datatable.plugins.column.ResizeColumnMeta;
import org.dominokit.domino.ui.elements.THeadElement;
import org.dominokit.domino.ui.elements.TableRowElement;
import org.dominokit.domino.ui.style.DominoCss;
import org.dominokit.domino.ui.utils.HasMultiSelectionSupport;

/**
 * Configuration class for setting up a DataTable.
 *
 * <p>This class provides mechanisms to define columns, plugins, and many other configurations
 * needed to draw and interact with a DataTable.
 *
 * <h2>Usage example:</h2>
 *
 * <pre>
 * TableConfig&lt;MyData&gt; config = new TableConfig&lt;&gt;();
 * config.addColumn(ColumnConfig.create("name", "Name").setWidth("100px"))
 *      .addPlugin(new MyPlugin())
 *      .setLazyLoad(true);
 * DataTable&lt;MyData&gt; table = new DataTable&lt;&gt;(config);
 * </pre>
 */
public class TableConfig<T>
    implements HasMultiSelectionSupport<TableConfig<T>>, DataTableStyles, DominoCss {

  private List<ColumnConfig<T>> columns = new LinkedList<>();
  private List<DataTablePlugin<T>> plugins = new ArrayList<>();
  private DataTable<T> dataTable;
  private boolean fixed = false;
  private String fixedDefaultColumnWidth = "100px";
  private String fixedBodyHeight = "400px";
  private boolean lazyLoad = true;
  private boolean multiSelect = true;
  private boolean stickyHeader = false;
  private RowAppender<T> rowAppender =
      (dataTable, tableRow) -> dataTable.bodyElement().appendChild(tableRow.element());
  private DirtyRecordProvider<T> dirtyRecordProvider = original -> original;
  private SaveDirtyRecordHandler<T> saveDirtyRecordHandler = (originalRecord, dirtyRecord) -> {};

  private String width;
  private String maxWidth;
  private String minWidth;

  private Consumer<TableRow<T>> onRowEditHandler = (tableRow) -> {};
  private Consumer<TableRow<T>> onRowFinishEditHandler = (tableRow) -> {};

  private final ColumnConfig<T> pluginUtilityColumn =
      ColumnConfig.<T>create("plugin-utility-column")
          .setShowTooltip(false)
          .setDrawTitle(true)
          .setPluginColumn(true)
          .applyMeta(ResizeColumnMeta.create().setResizable(false))
          .setCellRenderer(
              cellInfo -> {
                elements.elementOf(cellInfo.getElement()).addCss(dui_datatable_column_utility);
                return elements
                    .div()
                    .addCss(dui_datatable_utility_elements)
                    .apply(
                        div -> {
                          List<DataTablePlugin<T>> pluginsList = getPlugins();
                          for (DataTablePlugin<T> plugin : pluginsList) {
                            Optional<List<HTMLElement>> optionalElements =
                                plugin.getUtilityElements(dataTable, cellInfo);
                            if (optionalElements.isPresent()) {
                              List<HTMLElement> nodes = optionalElements.get();
                              for (HTMLElement node : nodes) {
                                String orderAttr = elements.elementOf(node).getAttribute("order");
                                String order = (orderAttr != null) ? orderAttr : "0";
                                div.appendChild(
                                    elements
                                        .div()
                                        .setCssProperty("order", Integer.parseInt(order))
                                        .addCss(dui_datatable_utility_element)
                                        .appendChild(node));
                              }
                            }
                          }

                          cellInfo
                              .getColumnConfig()
                              .ifPresent(
                                  columnConfig -> {
                                    if (cellInfo
                                        .getTableRow()
                                        .getDataTable()
                                        .getTableConfig()
                                        .isFixed()) {
                                      DOMRect domRect =
                                          columnConfig
                                              .getHeadElement()
                                              .element()
                                              .getBoundingClientRect();
                                      elements
                                          .elementOf(cellInfo.getElement())
                                          .setCssProperty("width", domRect.width + "px")
                                          .setCssProperty("min-width", domRect.width + "px")
                                          .setCssProperty("max-width", domRect.width + "px");
                                    }
                                  });
                        })
                    .element();
              });
  private UtilityColumnHandler<T> utilityColumnHandler = utilityColumn -> {};

  /**
   * Draws headers of the DataTable based on the provided configurations.
   *
   * @param dataTable The DataTable for which headers are to be drawn.
   * @param thead The table header element.
   */
  public void drawHeaders(DataTable<T> dataTable, THeadElement thead) {
    this.dataTable = dataTable;

    boolean seen = false;
    int best = 0;
    for (ColumnConfig<T> column : columns) {
      int columnsDepth = column.getColumnsDepth();
      if (!seen || columnsDepth > best) {
        seen = true;
        best = columnsDepth;
      }
    }
    int maxDepth = seen ? best : 0;

    TableRowElement[] headers = new TableRowElement[maxDepth + 1];
    for (int i = 0; i < headers.length; i++) {
      headers[i] = elements.tr().addCss(dui_datatable_row);
      thead.appendChild(headers[i]);
    }

    columns.forEach(col -> col.renderHeader(dataTable, this, headers));
    if (!thead.isAttached()) {
      dataTable.tableElement().appendChild(thead);
    }
  }

  /**
   * Draws a record (row) in the provided DataTable based on the configuration and applies the
   * appropriate CSS.
   *
   * <p>This method will render the table row, apply a CSS class based on its index (odd or even),
   * and append it to the DataTable either directly or using the associated RowAppenderMeta. After
   * the row is added, it will notify all associated plugins.
   *
   * @param dataTable The DataTable in which the record is to be drawn.
   * @param tableRow The table row that represents the record.
   */
  public void drawRecord(DataTable<T> dataTable, TableRow<T> tableRow) {
    tableRow.render();
    tableRow.addCss(isOdd(tableRow.getIndex()) ? dui_odd : dui_even);
    Optional<RowAppenderMeta<T>> appenderMeta = RowAppenderMeta.get(tableRow);
    if (appenderMeta.isPresent()) {
      appenderMeta.get().getRowAppender().appendRow(dataTable, tableRow);
    } else {
      rowAppender.appendRow(dataTable, tableRow);
    }

    getPlugins().forEach(plugin -> plugin.onRowAdded(dataTable, tableRow));
  }

  private boolean isOdd(int index) {
    return index % 2 > 0;
  }

  /**
   * Adds a column to the configuration.
   *
   * @param column Column configuration.
   * @return Current instance of {@link TableConfig} for chaining.
   */
  public TableConfig<T> addColumn(ColumnConfig<T> column) {
    column.applyMeta(ColumnHeaderMeta.create());
    this.columns.add(column);
    return this;
  }

  /**
   * Inserts a new column configuration at the beginning of the list of columns.
   *
   * @param column The column configuration to be added.
   * @return The current instance of {@link TableConfig} for chaining.
   */
  public TableConfig<T> insertColumnFirst(ColumnConfig<T> column) {
    this.columns.add(0, column);
    return this;
  }

  /**
   * Inserts a new column configuration at the position before the last column in the list.
   *
   * @param column The column configuration to be added.
   * @return The current instance of {@link TableConfig} for chaining.
   */
  public TableConfig<T> insertColumnLast(ColumnConfig<T> column) {
    this.columns.add(this.columns.size() - 1, column);
    return this;
  }

  /**
   * Adds a new plugin to the DataTable and checks if a utility column is required by the plugin. If
   * the plugin requires a utility column and one isn't already added, the utility column is
   * inserted at the beginning.
   *
   * @param plugin The {@link DataTablePlugin} to be added.
   * @return The current instance of {@link TableConfig} for chaining.
   */
  public TableConfig<T> addPlugin(DataTablePlugin<T> plugin) {
    this.plugins.add(plugin);
    if (plugin.requiresUtilityColumn() && !columns.contains(pluginUtilityColumn)) {
      utilityColumnHandler.handle(pluginUtilityColumn);
      insertColumnFirst(pluginUtilityColumn);
    }
    return this;
  }

  /**
   * Sets the handler for utility columns in the DataTable configuration.
   *
   * @param utilityColumnHandler The handler for utility columns.
   * @return The current instance of {@link TableConfig} for chaining.
   */
  public TableConfig<T> onUtilityColumn(UtilityColumnHandler<T> utilityColumnHandler) {
    this.utilityColumnHandler = utilityColumnHandler;
    return this;
  }

  /**
   * An interface that provides a mechanism to handle a utility column.
   *
   * @param <T> The type of the data being used in the DataTable.
   */
  @FunctionalInterface
  public interface UtilityColumnHandler<T> {
    void handle(ColumnConfig<T> utilityColumn);
  }

  /**
   * Checks if the DataTable is in a fixed layout mode.
   *
   * @return {@code true} if the table layout is fixed, {@code false} otherwise.
   */
  public boolean isFixed() {
    return fixed;
  }

  /**
   * Sets the DataTable layout mode as fixed or fluid.
   *
   * @param fixed {@code true} to set the table layout as fixed, {@code false} for fluid.
   * @return The current instance of {@link TableConfig} for chaining.
   */
  public TableConfig<T> setFixed(boolean fixed) {
    this.fixed = fixed;
    return this;
  }

  /**
   * Checks if the DataTable is in lazy load mode.
   *
   * @return {@code true} if the table is set to lazy load mode, {@code false} otherwise.
   */
  public boolean isLazyLoad() {
    return lazyLoad;
  }

  /**
   * Enables or disables the lazy load mode for the DataTable.
   *
   * @param lazyLoad {@code true} to enable lazy load mode, {@code false} to disable.
   * @return The current instance of {@link TableConfig} for chaining.
   */
  public TableConfig<T> setLazyLoad(boolean lazyLoad) {
    this.lazyLoad = lazyLoad;
    return this;
  }

  /**
   * Retrieves the fixed height for the table body when in fixed layout mode.
   *
   * @return A string representing the fixed height, e.g., "200px".
   */
  public String getFixedBodyHeight() {
    return fixedBodyHeight;
  }

  /**
   * Sets the fixed height for the table body when in fixed layout mode.
   *
   * @param fixedBodyHeight The height as a string, e.g., "200px".
   * @return The current instance of {@link TableConfig} for chaining.
   */
  public TableConfig<T> setFixedBodyHeight(String fixedBodyHeight) {
    this.fixedBodyHeight = fixedBodyHeight;
    return this;
  }

  /**
   * Retrieves the default width for columns in the fixed layout mode.
   *
   * @return A string representing the default column width, e.g., "100px".
   */
  public String getFixedDefaultColumnWidth() {
    return fixedDefaultColumnWidth;
  }

  /**
   * Sets the default width for columns when in fixed layout mode.
   *
   * @param fixedDefaultColumnWidth The width as a string, e.g., "100px".
   * @return The current instance of {@link TableConfig} for chaining.
   */
  public TableConfig<T> setFixedDefaultColumnWidth(String fixedDefaultColumnWidth) {
    this.fixedDefaultColumnWidth = fixedDefaultColumnWidth;
    return this;
  }

  /**
   * Checks if the DataTable supports multi-selection.
   *
   * @return {@code true} if multi-selection is enabled, {@code false} otherwise.
   */
  @Override
  public boolean isMultiSelect() {
    return this.multiSelect;
  }

  /**
   * Sets the multi-selection mode for the DataTable.
   *
   * @param multiSelect {@code true} to enable multi-selection mode, {@code false} to disable.
   * @return The current instance of {@link TableConfig} for chaining.
   */
  @Override
  public TableConfig<T> setMultiSelect(boolean multiSelect) {
    this.multiSelect = multiSelect;
    return this;
  }

  /**
   * Sets the row appender for the DataTable. It is ignored if the provided appender is null.
   *
   * @param rowAppender The row appender to set.
   */
  public void setRowAppender(RowAppender<T> rowAppender) {
    if (nonNull(rowAppender)) {
      this.rowAppender = rowAppender;
    }
  }

  /**
   * Retrieves the list of plugins attached to the DataTable, sorted in their natural order.
   *
   * @return A sorted list of {@link DataTablePlugin}.
   */
  public List<DataTablePlugin<T>> getPlugins() {
    List<DataTablePlugin<T>> sortedPlugins = new ArrayList<>();
    // Add all plugins using a simple loop
    for (DataTablePlugin<T> plugin : plugins) {
      sortedPlugins.add(plugin);
    }
    // Sort the list using Collections.sort(), which sorts according to natural ordering
    Collections.sort(sortedPlugins);
    return sortedPlugins;
  }

  /**
   * Notifies the plugins before headers are added to the DataTable.
   *
   * @param dataTable The DataTable to which the headers are added.
   */
  void onBeforeHeaders(DataTable<T> dataTable) {
    getPlugins().forEach(plugin -> plugin.onBeforeAddHeaders(dataTable));
  }

  /**
   * Notifies the plugins after headers are added to the DataTable.
   *
   * @param dataTable The DataTable to which the headers are added.
   */
  void onAfterHeaders(DataTable<T> dataTable) {
    getPlugins().forEach(plugin -> plugin.onAfterAddHeaders(dataTable));
  }

  /**
   * Retrieves the leaf columns of the DataTable.
   *
   * @return A list of {@link ColumnConfig} representing the leaf columns.
   */
  public List<ColumnConfig<T>> getColumns() {
    List<ColumnConfig<T>> allColumns = new ArrayList<>();
    for (ColumnConfig<T> col : columns) {
      // Retrieve the leaf columns from the current column
      List<ColumnConfig<T>> leafColumns = col.leafColumns();
      for (ColumnConfig<T> leaf : leafColumns) {
        allColumns.add(leaf);
      }
    }
    return allColumns;
  }

  /**
   * Retrieves all the columns of the DataTable, including nested columns if any.
   *
   * @return A list of {@link ColumnConfig} representing all columns, flattened.
   */
  public List<ColumnConfig<T>> getFlattenColumns() {
    List<ColumnConfig<T>> flattenColumns = new ArrayList<>();
    for (ColumnConfig<T> col : columns) {
      List<ColumnConfig<T>> colFlattenColumns = col.flattenColumns();
      for (ColumnConfig<T> flattened : colFlattenColumns) {
        flattenColumns.add(flattened);
      }
    }
    return flattenColumns;
  }

  /**
   * Retrieves only the leaf columns of the data table.
   *
   * @return A list of {@link ColumnConfig} representing all columns, flattened.
   */
  public List<ColumnConfig<T>> getLeafColumns() {
    List<ColumnConfig<T>> leafColumnsList = new ArrayList<>();
    for (ColumnConfig<T> col : columns) {
      List<ColumnConfig<T>> childLeafColumns = col.leafColumns();
      for (ColumnConfig<T> leaf : childLeafColumns) {
        leafColumnsList.add(leaf);
      }
    }
    return leafColumnsList;
  }

  /**
   * Retrieves the columns of the DataTable as grouped.
   *
   * @return A list of {@link ColumnConfig} representing grouped columns.
   */
  public List<ColumnConfig<T>> getColumnsGrouped() {
    return columns;
  }

  /**
   * Retrieves only the visible columns of the DataTable.
   *
   * @return A list of {@link ColumnConfig} representing visible columns.
   */
  public List<ColumnConfig<T>> getVisibleColumns() {
    List<ColumnConfig<T>> list = new ArrayList<>();
    for (ColumnConfig<T> column : columns) {
      if (!column.isHidden()) {
        list.add(column);
      }
    }
    return list;
  }

  /**
   * Retrieves a column configuration by its name.
   *
   * @param name The name of the column to retrieve.
   * @return The {@link ColumnConfig} associated with the given name.
   * @throws ColumnNofFoundException If no column is found with the specified name.
   */
  public ColumnConfig<T> getColumnByName(String name) {
    Optional<ColumnConfig<T>> first = Optional.empty();
    for (ColumnConfig<T> columnConfig : getFlattenColumns()) {
      if (columnConfig.getName().equals(name)) {
        first = Optional.of(columnConfig);
        break;
      }
    }
    if (first.isPresent()) {
      return first.get();
    } else {
      throw new ColumnNofFoundException(name);
    }
  }

  /**
   * Sets the title for the utility column.
   *
   * @param title The title to set for the utility column.
   * @return The current instance of {@link TableConfig} for chaining.
   */
  public TableConfig<T> setUtilityColumnTitle(String title) {
    if (nonNull(title)) {
      pluginUtilityColumn.setTitle(title);
    }
    return this;
  }

  /**
   * Retrieves the associated DataTable instance.
   *
   * @return The {@link DataTable} associated with this configuration.
   */
  public DataTable<T> getDataTable() {
    return dataTable;
  }

  /**
   * Configures handlers for managing dirty records.
   *
   * @param dirtyRecordProvider The provider to detect dirty records.
   * @param saveDirtyRecordHandler The handler to save dirty records.
   * @return The current instance of {@link TableConfig} for chaining.
   */
  public TableConfig<T> setDirtyRecordHandlers(
      DirtyRecordProvider<T> dirtyRecordProvider,
      SaveDirtyRecordHandler<T> saveDirtyRecordHandler) {
    this.dirtyRecordProvider = dirtyRecordProvider;
    this.saveDirtyRecordHandler = saveDirtyRecordHandler;

    return this;
  }

  /**
   * Retrieves the width of the table.
   *
   * @return The width of the table.
   */
  public String getWidth() {
    return width;
  }

  /**
   * Sets the width of the table.
   *
   * @param width The width to set.
   * @return The current instance of {@link TableConfig} for chaining.
   */
  public TableConfig<T> setWidth(String width) {
    this.width = width;
    return this;
  }

  /**
   * Retrieves the maximum width of the table.
   *
   * @return The maximum width of the table.
   */
  public String getMaxWidth() {
    return maxWidth;
  }

  /**
   * Sets the maximum width of the table.
   *
   * @param maxWidth The maximum width to set.
   * @return The current instance of {@link TableConfig} for chaining.
   */
  public TableConfig<T> setMaxWidth(String maxWidth) {
    this.maxWidth = maxWidth;
    return this;
  }

  /**
   * Retrieves the minimum width of the table.
   *
   * @return The minimum width of the table.
   */
  public String getMinWidth() {
    return minWidth;
  }

  /**
   * Checks if the header of the table is sticky.
   *
   * @return {@code true} if the header is sticky, {@code false} otherwise.
   */
  public boolean isStickyHeader() {
    return stickyHeader;
  }

  /**
   * Sets the sticky state of the table header.
   *
   * @param stickyHeader {@code true} to make the header sticky, {@code false} to disable.
   * @return The current instance of {@link TableConfig} for chaining.
   */
  public TableConfig<T> setStickyHeader(boolean stickyHeader) {
    this.stickyHeader = stickyHeader;
    return this;
  }

  /**
   * Sets the minimum width of the table.
   *
   * @param minWidth The minimum width to set.
   * @return The current instance of {@link TableConfig} for chaining.
   */
  public TableConfig<T> setMinWidth(String minWidth) {
    this.minWidth = minWidth;
    return this;
  }

  /**
   * Retrieves the provider for dirty records.
   *
   * @return The {@link DirtyRecordProvider} for this table.
   */
  DirtyRecordProvider<T> getDirtyRecordProvider() {
    return dirtyRecordProvider;
  }

  /**
   * Retrieves the handler to save dirty records.
   *
   * @return The {@link SaveDirtyRecordHandler} for this table.
   */
  SaveDirtyRecordHandler<T> getSaveDirtyRecordHandler() {
    return saveDirtyRecordHandler;
  }

  /**
   * Use this to set a handler that will be called when ever a row is being edited.
   *
   * @param handler The handler to be called.
   * @return same TableConfig instance.
   */
  public TableConfig<T> setOnRowEditHandler(Consumer<TableRow<T>> handler) {
    if (isNull(handler)) {
      this.onRowEditHandler = tableRow -> {};
    } else {
      this.onRowEditHandler = handler;
    }
    return this;
  }

  /** @return the handler to be called when a row is being edited. */
  Consumer<TableRow<T>> getOnRowEditHandler() {
    return onRowEditHandler;
  }

  /**
   * Use this to set a handler that will be called when ever a row editing finished.
   *
   * @param handler The handler to be called.
   * @return same TableConfig instance.
   */
  public TableConfig<T> setOnRowFinishEditHandler(Consumer<TableRow<T>> handler) {
    if (isNull(handler)) {
      this.onRowFinishEditHandler = tableRow -> {};
    } else {
      this.onRowFinishEditHandler = handler;
    }
    return this;
  }

  /** @return the handler to be called when a row editing finished. */
  Consumer<TableRow<T>> getOnRowFinishEditHandler() {
    return onRowFinishEditHandler;
  }

  /** A functional interface defining the behavior for appending rows. */
  @FunctionalInterface
  public interface RowAppender<T> {
    /**
     * Appends a row to the provided {@link DataTable}.
     *
     * @param dataTable The DataTable to which the row should be appended.
     * @param tableRow The row to append.
     */
    void appendRow(DataTable<T> dataTable, TableRow<T> tableRow);
  }

  /** An exception that's thrown when no column is found by a given name. */
  public static class ColumnNofFoundException extends RuntimeException {
    /**
     * Constructs a new exception with the specified column name.
     *
     * @param name The name of the column that was not found.
     */
    public ColumnNofFoundException(String name) {
      super(name);
    }
  }
}
