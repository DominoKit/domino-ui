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

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

import java.util.*;
import java.util.stream.Collectors;
import org.dominokit.domino.ui.datatable.plugins.DataTablePlugin;
import org.dominokit.domino.ui.datatable.plugins.column.ResizeColumnMeta;
import org.dominokit.domino.ui.datatable.plugins.grouping.GroupingPlugin;
import org.dominokit.domino.ui.elements.THeadElement;
import org.dominokit.domino.ui.elements.TableRowElement;
import org.dominokit.domino.ui.style.DominoCss;
import org.dominokit.domino.ui.utils.HasMultiSelectionSupport;

/**
 * This class is responsible for configuring the data table
 *
 * @param <T> the type of the data table records
 * @author vegegoku
 * @version $Id: $Id
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
                          getPlugins().stream()
                              .map(plugin -> plugin.getUtilityElements(dataTable, cellInfo))
                              .filter(Optional::isPresent)
                              .map(Optional::get)
                              .flatMap(Collection::stream)
                              .forEach(
                                  node -> {
                                    String order =
                                        Optional.ofNullable(
                                                elements.elementOf(node).getAttribute("order"))
                                            .orElse("0");
                                    div.appendChild(
                                        elements
                                            .div()
                                            .setCssProperty("order", Integer.parseInt(order))
                                            .addCss(dui_datatable_utility_element)
                                            .appendChild(node));
                                  });
                        })
                    .element();
              });
  private UtilityColumnHandler<T> utilityColumnHandler = utilityColumn -> {};

  /**
   * This method will draw the table columns header elements for all columns and append them to the
   * table head element
   *
   * @param dataTable the {@link org.dominokit.domino.ui.datatable.DataTable} initialized with this
   *     configuration
   * @param thead the {@link org.dominokit.domino.ui.utils.DominoElement} of {@link
   *     elemental2.dom.HTMLTableSectionElement} that is the table header element
   */
  public void drawHeaders(DataTable<T> dataTable, THeadElement thead) {
    this.dataTable = dataTable;

    int maxDepth = columns.stream().mapToInt(ColumnConfig::getColumnsDepth).max().orElse(0);

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
   * Draw a record as a row in the data table, row information is obtained from the TableRow
   *
   * @param dataTable the {@link org.dominokit.domino.ui.datatable.DataTable} initialized with this
   *     configuration
   * @param tableRow the {@link org.dominokit.domino.ui.datatable.TableRow} we are adding to the
   *     table
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
   * Adds a configuration for a column in the data table
   *
   * @param column {@link org.dominokit.domino.ui.datatable.ColumnConfig}
   * @return same TableConfig instance
   */
  public TableConfig<T> addColumn(ColumnConfig<T> column) {
    column.applyMeta(ColumnHeaderMeta.create());
    this.columns.add(column);
    return this;
  }

  /**
   * Adds a configuration for a column in the data table as the first column over the existing
   * columns list
   *
   * @param column {@link org.dominokit.domino.ui.datatable.ColumnConfig}
   * @return same TableConfig instance
   */
  public TableConfig<T> insertColumnFirst(ColumnConfig<T> column) {
    this.columns.add(0, column);
    return this;
  }

  /**
   * Adds a configuration for a column in the data table as the last column after the existing
   * columns list
   *
   * @param column {@link org.dominokit.domino.ui.datatable.ColumnConfig}
   * @return same TableConfig instance
   */
  public TableConfig<T> insertColumnLast(ColumnConfig<T> column) {
    this.columns.add(this.columns.size() - 1, column);
    return this;
  }

  /**
   * Adds a new plugin to the data table
   *
   * @param plugin {@link org.dominokit.domino.ui.datatable.plugins.DataTablePlugin}
   * @return same TableConfig instance
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
   * onUtilityColumn.
   *
   * @param utilityColumnHandler a {@link
   *     org.dominokit.domino.ui.datatable.TableConfig.UtilityColumnHandler} object
   * @return a {@link org.dominokit.domino.ui.datatable.TableConfig} object
   */
  public TableConfig<T> onUtilityColumn(UtilityColumnHandler<T> utilityColumnHandler) {
    this.utilityColumnHandler = utilityColumnHandler;
    return this;
  }

  @FunctionalInterface
  public interface UtilityColumnHandler<T> {
    void handle(ColumnConfig<T> utilityColumn);
  }

  /**
   * isFixed.
   *
   * @return boolean, if true then this table will have a fixed width and wont change the columns
   *     width when resized, otherwise columns will stretch to match the table root element width
   */
  public boolean isFixed() {
    return fixed;
  }

  /**
   * Setter for the field <code>fixed</code>.
   *
   * @param fixed boolean, if true then this table will have a fixed width and wont change the
   *     columns width when resized, otherwise columns will stretch to match the table root element
   *     width
   * @return same TableConfig instance
   */
  public TableConfig<T> setFixed(boolean fixed) {
    this.fixed = fixed;
    return this;
  }

  /**
   * isLazyLoad.
   *
   * @return boolean, if true the table will only start loading the data from the data store if load
   *     is called manually, otherwise it will automatically load the data when it is initialized
   */
  public boolean isLazyLoad() {
    return lazyLoad;
  }

  /**
   * Setter for the field <code>lazyLoad</code>.
   *
   * @param lazyLoad boolean, if true the table will only start loading the data from the data store
   *     if load is called manually, otherwise it will automatically load the data when it is
   *     initialized
   * @return same TableConfig instance
   */
  public TableConfig<T> setLazyLoad(boolean lazyLoad) {
    this.lazyLoad = lazyLoad;
    return this;
  }

  /**
   * Getter for the field <code>fixedBodyHeight</code>.
   *
   * @return String, the height of the data table body, this is the value we set with {@link
   *     #setFixedBodyHeight(String)} not the actual current table body height
   */
  public String getFixedBodyHeight() {
    return fixedBodyHeight;
  }

  /**
   * Setter for the field <code>fixedBodyHeight</code>.
   *
   * @param fixedBodyHeight boolean, if true the height of the table body will be fixed to the
   *     specified value and while adding records to the table if the total height of rows exceed
   *     this height scroll bars will show up, otherwise the table body will not fixed and will grow
   *     to match the rows height and wont show scrollbars
   * @return same TableConfig instance
   */
  public TableConfig<T> setFixedBodyHeight(String fixedBodyHeight) {
    this.fixedBodyHeight = fixedBodyHeight;
    return this;
  }

  /** @return String default value for a fixed column width */
  /**
   * Getter for the field <code>fixedDefaultColumnWidth</code>.
   *
   * @return a {@link java.lang.String} object
   */
  public String getFixedDefaultColumnWidth() {
    return fixedDefaultColumnWidth;
  }

  /**
   * Setter for the field <code>fixedDefaultColumnWidth</code>.
   *
   * @param fixedDefaultColumnWidth String default value to be used as width for the fixed width
   *     columns
   * @return same TableConfig instance
   */
  public TableConfig<T> setFixedDefaultColumnWidth(String fixedDefaultColumnWidth) {
    this.fixedDefaultColumnWidth = fixedDefaultColumnWidth;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isMultiSelect() {
    return this.multiSelect;
  }

  /** {@inheritDoc} */
  @Override
  public TableConfig<T> setMultiSelect(boolean multiSelect) {
    this.multiSelect = multiSelect;
    return this;
  }

  /**
   * Change the default RowAppender for the data table
   *
   * @param rowAppender {@link org.dominokit.domino.ui.datatable.TableConfig.RowAppender}
   */
  public void setRowAppender(RowAppender<T> rowAppender) {
    if (nonNull(rowAppender)) {
      this.rowAppender = rowAppender;
    }
  }

  /** @return the {@link List} of plugins added to the table */
  /**
   * Getter for the field <code>plugins</code>.
   *
   * @return a {@link java.util.List} object
   */
  public List<DataTablePlugin<T>> getPlugins() {
    return plugins.stream().sorted().collect(Collectors.toList());
  }

  /**
   * Run the {@link DataTablePlugin#onBeforeAddHeaders(DataTable)} for all plugin added to the data
   * table
   *
   * @param dataTable the {@link DataTable} initialized with this configuration
   */
  void onBeforeHeaders(DataTable<T> dataTable) {
    getPlugins().forEach(plugin -> plugin.onBeforeAddHeaders(dataTable));
  }

  /**
   * Run the {@link DataTablePlugin#onAfterAddHeaders(DataTable)} for all plugin added to the data
   * table
   *
   * @param dataTable the {@link DataTable} initialized with this configuration
   */
  void onAfterHeaders(DataTable<T> dataTable) {
    getPlugins().forEach(plugin -> plugin.onAfterAddHeaders(dataTable));
  }

  /** @return a {@link List} of all non grouping {@link ColumnConfig} added to the table */
  /**
   * Getter for the field <code>columns</code>.
   *
   * @return a {@link java.util.List} object
   */
  public List<ColumnConfig<T>> getColumns() {
    return columns.stream().flatMap(col -> col.leafColumns().stream()).collect(Collectors.toList());
  }

  /** @return a {@link List} of all {@link ColumnConfig} added to the table */
  /**
   * getFlattenColumns.
   *
   * @return a {@link java.util.List} object
   */
  public List<ColumnConfig<T>> getFlattenColumns() {
    return columns.stream()
        .flatMap(col -> col.flattenColumns().stream())
        .collect(Collectors.toList());
  }

  /**
   * getColumnsGrouped.
   *
   * @return a {@link java.util.List} object
   */
  public List<ColumnConfig<T>> getColumnsGrouped() {
    return columns;
  }

  /** @return a {@link List} of all currently visible {@link ColumnConfig} of the table */
  /**
   * getVisibleColumns.
   *
   * @return a {@link java.util.List} object
   */
  public List<ColumnConfig<T>> getVisibleColumns() {
    return columns.stream().filter(column -> !column.isHidden()).collect(Collectors.toList());
  }

  /**
   * get a column config by the column name
   *
   * @param name String name of the column
   * @return the {@link org.dominokit.domino.ui.datatable.ColumnConfig} if exists otherwise throw
   *     {@link org.dominokit.domino.ui.datatable.TableConfig.ColumnNofFoundException}
   */
  public ColumnConfig<T> getColumnByName(String name) {
    Optional<ColumnConfig<T>> first =
        getFlattenColumns().stream()
            .filter(columnConfig -> columnConfig.getName().equals(name))
            .findFirst();
    if (first.isPresent()) {
      return first.get();
    } else {
      throw new ColumnNofFoundException(name);
    }
  }

  /**
   * setUtilityColumnTitle.
   *
   * @param title a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.datatable.TableConfig} object
   */
  public TableConfig<T> setUtilityColumnTitle(String title) {
    if (nonNull(title)) {
      pluginUtilityColumn.setTitle(title);
    }
    return this;
  }

  /** @return the {@link DataTable} initialized with this configuration */
  /**
   * Getter for the field <code>dataTable</code>.
   *
   * @return a {@link org.dominokit.domino.ui.datatable.DataTable} object
   */
  public DataTable<T> getDataTable() {
    return dataTable;
  }

  /**
   * sets the dirty record handlers for editable tables
   *
   * @param dirtyRecordProvider {@link org.dominokit.domino.ui.datatable.DirtyRecordProvider}
   * @param saveDirtyRecordHandler {@link org.dominokit.domino.ui.datatable.SaveDirtyRecordHandler}
   * @return same TableConfig istance
   */
  public TableConfig<T> setDirtyRecordHandlers(
      DirtyRecordProvider<T> dirtyRecordProvider,
      SaveDirtyRecordHandler<T> saveDirtyRecordHandler) {
    this.dirtyRecordProvider = dirtyRecordProvider;
    this.saveDirtyRecordHandler = saveDirtyRecordHandler;

    return this;
  }

  /**
   * Getter for the field <code>width</code>.
   *
   * @return a {@link java.lang.String} object
   */
  public String getWidth() {
    return width;
  }

  /**
   * Setter for the field <code>width</code>.
   *
   * @param width a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.datatable.TableConfig} object
   */
  public TableConfig<T> setWidth(String width) {
    this.width = width;
    return this;
  }

  /**
   * Getter for the field <code>maxWidth</code>.
   *
   * @return a {@link java.lang.String} object
   */
  public String getMaxWidth() {
    return maxWidth;
  }

  /**
   * Setter for the field <code>maxWidth</code>.
   *
   * @param maxWidth a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.datatable.TableConfig} object
   */
  public TableConfig<T> setMaxWidth(String maxWidth) {
    this.maxWidth = maxWidth;
    return this;
  }

  /**
   * Getter for the field <code>minWidth</code>.
   *
   * @return a {@link java.lang.String} object
   */
  public String getMinWidth() {
    return minWidth;
  }

  public boolean isStickyHeader() {
    return stickyHeader;
  }

  public TableConfig<T> setStickyHeader(boolean stickyHeader) {
    this.stickyHeader = stickyHeader;
    return this;
  }

  /**
   * Setter for the field <code>minWidth</code>.
   *
   * @param minWidth a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.datatable.TableConfig} object
   */
  public TableConfig<T> setMinWidth(String minWidth) {
    this.minWidth = minWidth;
    return this;
  }

  /** @return the {@link DirtyRecordProvider} */
  DirtyRecordProvider<T> getDirtyRecordProvider() {
    return dirtyRecordProvider;
  }

  /** @return the {@link SaveDirtyRecordHandler} */
  SaveDirtyRecordHandler<T> getSaveDirtyRecordHandler() {
    return saveDirtyRecordHandler;
  }

  /**
   * An interface to provide an alternative implementation of how rows should be appended to the
   * table
   *
   * <p>e.g
   *
   * <p>The {@link GroupingPlugin} defines an appender that appends a row into the appropriate group
   * instead of appending row sequentially
   *
   * @param <T> the type of the row record
   */
  @FunctionalInterface
  public interface RowAppender<T> {
    /**
     * Appends a row to the data table
     *
     * @param dataTable the {@link DataTable}
     * @param tableRow the {@link TableRow} being appended
     */
    void appendRow(DataTable<T> dataTable, TableRow<T> tableRow);
  }

  /**
   * This exception is thrown when performing action that looks up a column by its name but the
   * column does not exist in the current {@link TableConfig}
   */
  public static class ColumnNofFoundException extends RuntimeException {
    public ColumnNofFoundException(String name) {
      super(name);
    }
  }
}
