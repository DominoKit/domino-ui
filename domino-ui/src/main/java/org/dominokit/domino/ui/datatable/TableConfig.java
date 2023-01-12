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
import static org.jboss.elemento.Elements.*;

import elemental2.dom.*;
import java.util.*;
import java.util.stream.Collectors;
import org.dominokit.domino.ui.datatable.plugins.DataTablePlugin;
import org.dominokit.domino.ui.datatable.plugins.ResizeColumnMeta;
import org.dominokit.domino.ui.grid.flex.FlexAlign;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexJustifyContent;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasMultiSelectionSupport;

/**
 * This class is responsible for configuring the data table
 *
 * <pre>
 *     TableConfig&lt;Contact&gt; tableConfig = new TableConfig&lt;&gt;();
 * tableConfig
 *         .addColumn(ColumnConfig.<Contact&gt;create("id", "#")
 *                 .textAlign("right")
 *                 .asHeader()
 *                 .setCellRenderer(cell -&gt; TextNode.of(cell.getTableRow().getRecord().getIndex() + 1 + "")))
 *         .addColumn(ColumnConfig.<Contact&gt;create("firstName", "First name")
 *                 .setCellRenderer(cell -&gt; TextNode.of(cell.getTableRow().getRecord().getName())))
 *         .addColumn(ColumnConfig.<Contact&gt;create("email", "Email")
 *                 .setCellRenderer(cell -&gt; TextNode.of(cell.getTableRow().getRecord().getEmail())))
 *         .addColumn(ColumnConfig.<Contact&gt;create("phone", "Phone")
 *                 .setCellRenderer(cell -&gt; TextNode.of(cell.getTableRow().getRecord().getPhone())))
 *         .addColumn(ColumnConfig.<Contact&gt;create("badges", "Badges")
 *                 .setCellRenderer(cell -&gt; {
 *                     if (cell.getTableRow().getRecord().getAge() &lt; 35) {
 *                         return Badge.create("Young")
 *                                 .setBackground(ColorScheme.GREEN.color()).element();
 *                     }
 *                     return TextNode.of("");
 *                 }));
 * </pre>
 *
 * @param <T> the type of the data table records
 */
public class TableConfig<T> implements HasMultiSelectionSupport<TableConfig<T>> {

  private List<ColumnConfig<T>> columns = new LinkedList<>();
  private List<DataTablePlugin<T>> plugins = new ArrayList<>();
  private DataTable<T> dataTable;
  private boolean fixed = false;
  private String fixedDefaultColumnWidth = "100px";
  private String fixedBodyHeight = "400px";
  private boolean lazyLoad = true;
  private boolean multiSelect = true;
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
          .setSortable(true)
          .setDrawTitle(true)
          .setPluginColumn(true)
          .setWidth("100px")
          .applyMeta(ResizeColumnMeta.create().setResizable(false))
          .setCellRenderer(
              cellInfo -> {
                DominoElement.of(cellInfo.getElement()).css("dt-cm-utility");
                FlexLayout flexLayout =
                    FlexLayout.create()
                        .setAlignItems(FlexAlign.CENTER)
                        .setJustifyContent(FlexJustifyContent.START);
                getPlugins().stream()
                    .map(plugin -> plugin.getUtilityElements(dataTable, cellInfo))
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .flatMap(Collection::stream)
                    .forEach(
                        node -> {
                          String order =
                              Optional.ofNullable(DominoElement.of(node).getAttribute("order"))
                                  .orElse("0");
                          flexLayout.appendChild(
                              FlexItem.create()
                                  .setOrder(Integer.parseInt(order))
                                  .setAlignSelf(FlexAlign.CENTER)
                                  .appendChild(node));
                        });
                return flexLayout.element();
              });
  private UtilityColumnHandler<T> utilityColumnHandler = utilityColumn -> {};

  /**
   * This method will draw the table columns header elements for all columns and append them to the
   * table head element
   *
   * @param dataTable the {@link DataTable} initialized with this configuration
   * @param thead the {@link DominoElement} of {@link HTMLTableSectionElement} that is the table
   *     header element
   */
  public void drawHeaders(DataTable<T> dataTable, DominoElement<HTMLTableSectionElement> thead) {
    this.dataTable = dataTable;

    int maxDepth = columns.stream().mapToInt(ColumnConfig::getColumnsDepth).max().orElse(0);

    HTMLTableRowElement[] headers = new HTMLTableRowElement[maxDepth + 1];
    for (int i = 0; i < headers.length; i++) {
      headers[i] = tr().element();
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
   * @param dataTable the {@link DataTable} initialized with this configuration
   * @param tableRow the {@link TableRow} we are adding to the table
   */
  public void drawRecord(DataTable<T> dataTable, TableRow<T> tableRow) {
    tableRow.render();
    tableRow.addCss(isOdd(tableRow.getIndex()) ? "dom-ui-dt-tr-odd" : "dom-ui-dt-tr-even");
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
   * @param column {@link ColumnConfig}
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
   * @param column {@link ColumnConfig}
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
   * @param column {@link ColumnConfig}
   * @return same TableConfig instance
   */
  public TableConfig<T> insertColumnLast(ColumnConfig<T> column) {
    this.columns.add(this.columns.size() - 1, column);
    return this;
  }

  /**
   * Adds a new plugin to the data table
   *
   * @param plugin {@link DataTablePlugin}
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

  public TableConfig<T> onUtilityColumn(UtilityColumnHandler<T> utilityColumnHandler) {
    this.utilityColumnHandler = utilityColumnHandler;
    return this;
  }

  @FunctionalInterface
  public interface UtilityColumnHandler<T> {
    void handle(ColumnConfig<T> utilityColumn);
  }

  /**
   * @return boolean, if true then this table will have a fixed width and wont change the columns
   *     width when resized, otherwise columns will stretch to match the table root element width
   */
  public boolean isFixed() {
    return fixed;
  }

  /**
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
   * @return boolean, if true the table will only start loading the data from the data store if load
   *     is called manually, otherwise it will automatically load the data when it is initialized
   */
  public boolean isLazyLoad() {
    return lazyLoad;
  }

  /**
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
   * @return String, the height of the data table body, this is the value we set with {@link
   *     #setFixedBodyHeight(String)} not the actual current table body height
   */
  public String getFixedBodyHeight() {
    return fixedBodyHeight;
  }

  /**
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
  public String getFixedDefaultColumnWidth() {
    return fixedDefaultColumnWidth;
  }

  /**
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
   * @param rowAppender {@link RowAppender}
   */
  public void setRowAppender(RowAppender<T> rowAppender) {
    if (nonNull(rowAppender)) {
      this.rowAppender = rowAppender;
    }
  }

  /** @return the {@link List} of plugins added to the table */
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
  public List<ColumnConfig<T>> getColumns() {
    return columns.stream().flatMap(col -> col.leafColumns().stream()).collect(Collectors.toList());
  }

  /** @return a {@link List} of all {@link ColumnConfig} added to the table */
  public List<ColumnConfig<T>> getFlattenColumns() {
    return columns.stream()
        .flatMap(col -> col.flattenColumns().stream())
        .collect(Collectors.toList());
  }

  public List<ColumnConfig<T>> getColumnsGrouped() {
    return columns;
  }

  /** @return a {@link List} of all currently visible {@link ColumnConfig} of the table */
  public List<ColumnConfig<T>> getVisibleColumns() {
    return columns.stream().filter(column -> !column.isHidden()).collect(Collectors.toList());
  }

  /**
   * get a column config by the column name
   *
   * @param name String name of the column
   * @return the {@link ColumnConfig} if exists otherwise throw {@link ColumnNofFoundException}
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

  public TableConfig<T> setUtilityColumnTitle(String title) {
    if (nonNull(title)) {
      pluginUtilityColumn.setTitle(title);
    }
    return this;
  }

  /** @return the {@link DataTable} initialized with this configuration */
  public DataTable<T> getDataTable() {
    return dataTable;
  }

  /**
   * sets the dirty record handlers for editable tables
   *
   * @param dirtyRecordProvider {@link DirtyRecordProvider}
   * @param saveDirtyRecordHandler {@link SaveDirtyRecordHandler}
   * @return same TableConfig istance
   */
  public TableConfig<T> setDirtyRecordHandlers(
      DirtyRecordProvider<T> dirtyRecordProvider,
      SaveDirtyRecordHandler<T> saveDirtyRecordHandler) {
    this.dirtyRecordProvider = dirtyRecordProvider;
    this.saveDirtyRecordHandler = saveDirtyRecordHandler;

    return this;
  }

  public String getWidth() {
    return width;
  }

  public TableConfig<T> setWidth(String width) {
    this.width = width;
    return this;
  }

  public String getMaxWidth() {
    return maxWidth;
  }

  public TableConfig<T> setMaxWidth(String maxWidth) {
    this.maxWidth = maxWidth;
    return this;
  }

  public String getMinWidth() {
    return minWidth;
  }

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
   * <p>The {@link org.dominokit.domino.ui.datatable.plugins.GroupingPlugin} defines an appender
   * that appends a row into the appropriate group instead of appending row sequentially
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
