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
import static org.dominokit.domino.ui.datatable.ColumnUtils.fixElementWidth;
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.Element;
import elemental2.dom.HTMLTableCellElement;
import elemental2.dom.Node;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.elements.TableRowElement;
import org.dominokit.domino.ui.icons.MdiIcon;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.menu.direction.BestSideUpDownDropDirection;
import org.dominokit.domino.ui.popover.Tooltip;
import org.dominokit.domino.ui.utils.ComponentMeta;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.ElementsFactory;
import org.dominokit.domino.ui.utils.ScreenMedia;

/**
 * Represents the configuration for a column within a data table.
 *
 * <p>Usage example:
 *
 * <pre>
 * ColumnConfig<User> nameColumn = ColumnConfig.<User>create("name")
 *     .setTitle("User Name")
 *     .setWidth("200px")
 *     .sortable();
 * </pre>
 *
 * @param <T> the type parameter indicating the data type the column is related to.
 */
public class ColumnConfig<T> implements ElementsFactory, DataTableStyles {

  private final String name;
  private String filterKey;
  private String title;
  private ColumnHeader headElement;
  private String minWidth;
  private String maxWidth;
  private CellTextAlign cellTextAlign = CellTextAlign.LEFT;
  private CellTextAlign headerCellTextAlign = CellTextAlign.LEFT;
  private CellRenderer<T> cellRenderer;
  private CellRenderer<T> editableCellRenderer;
  private HeaderElementSupplier headerElementSupplier = columnTitle -> text(columnTitle);
  private CellStyler<T> headerStyler = element -> {};
  private CellStyler<T> cellStyler = element -> {};
  private boolean sortable = false;
  private String sortKey;
  private String width;
  private boolean fixed = false;
  private Node tooltipNode;
  private boolean showTooltip = true;
  private boolean hidden = false;
  private boolean pluginColumn;
  private ScreenMedia showOn;
  private ScreenMedia hideOn;
  private boolean drawTitle = true;

  private final List<ColumnShowHideListener> showHideListeners = new ArrayList<>();
  private final List<ColumnShowHideListener> permanentHideListeners = new ArrayList<>();

  private final List<ColumnConfig<T>> subColumns = new ArrayList<>();
  private ColumnConfig<T> parent;

  private final Map<String, ComponentMeta> columnMeta = new HashMap<>();

  private final Menu<String> menu;
  private MdiIcon menuIcon;

  /**
   * Factory method to create a new instance of {@link ColumnConfig} with the specified column name.
   *
   * @param name the name of the column
   * @param <T> the data type
   * @return a new {@link ColumnConfig} instance
   */
  public static <T> ColumnConfig<T> create(String name) {
    return new ColumnConfig<>(name);
  }

  /**
   * Factory method to create a new instance of {@link ColumnConfig} with the specified column name
   * and title.
   *
   * @param name the name of the column
   * @param title the title of the column
   * @param <T> the data type
   * @return a new {@link ColumnConfig} instance
   */
  public static <T> ColumnConfig<T> create(String name, String title) {
    return new ColumnConfig<>(name, title);
  }

  /**
   * Constructs a {@link ColumnConfig} with the specified name and title.
   *
   * @param name the name of the column
   * @param title the title of the column
   */
  public ColumnConfig(String name, String title) {
    this.name = name;
    this.title = title;
    menuIcon = Icons.dots_vertical().addCss(dui_datatable_th_menu_icon);
    this.menu =
        Menu.<String>create()
            .setTargetElement(menuIcon)
            .setDropDirection(new BestSideUpDownDropDirection())
            .addOnAddItemHandler((menu1, menuItem) -> menuIcon.show());
    menuIcon.hide();
  }

  /**
   * Constructs a {@link ColumnConfig} with the specified name.
   *
   * @param name the name of the column
   */
  public ColumnConfig(String name) {
    this(name, "");
  }

  /**
   * Getter for the field <code>title</code>.
   *
   * @return a {@link java.lang.String} object
   */
  public String getTitle() {
    return title;
  }

  /**
   * Returns the name of the column.
   *
   * @return the column name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the filter key for the column. If a specific filter key is not set, it defaults to the
   * column name.
   *
   * @return the filter key or the column name if filter key is null
   */
  public String getFilterKey() {
    return nonNull(filterKey) ? filterKey : getName();
  }

  /**
   * Sets a specific key for filtering purposes on this column.
   *
   * @param filterKey the filter key to set
   * @return the current instance for chaining
   */
  public ColumnConfig<T> setFilterKey(String filterKey) {
    this.filterKey = filterKey;
    return this;
  }

  /**
   * Sets the minimum width constraint for this column.
   *
   * @param minWidth the minimum width to set
   * @return the current instance for chaining
   */
  public ColumnConfig<T> minWidth(String minWidth) {
    this.minWidth = minWidth;
    return this;
  }

  /**
   * Sets the maximum width constraint for this column.
   *
   * @param maxWidth the maximum width to set
   * @return the current instance for chaining
   */
  public ColumnConfig<T> maxWidth(String maxWidth) {
    this.maxWidth = maxWidth;
    return this;
  }

  /**
   * Gets the set width for this column.
   *
   * @return the width of the column
   */
  public String getWidth() {
    return width;
  }

  /**
   * Sets the width for this column.
   *
   * @param width the desired width for the column
   * @return the current instance for chaining
   */
  public ColumnConfig<T> setWidth(String width) {
    this.width = width;
    return this;
  }

  /**
   * Sets the text alignment for cells within this column.
   *
   * @param cellTextAlign the alignment setting for the cell content
   * @return the current instance for chaining
   */
  public ColumnConfig<T> setTextAlign(CellTextAlign cellTextAlign) {
    this.cellTextAlign = cellTextAlign;
    return this;
  }

  /**
   * Sets the text alignment for the header cell of this column.
   *
   * @param headerCellTextAlign the alignment setting for the header cell content
   * @return the current instance for chaining
   */
  public ColumnConfig<T> setHeaderTextAlign(CellTextAlign headerCellTextAlign) {
    this.headerCellTextAlign = headerCellTextAlign;
    return this;
  }

  /**
   * Retrieves the header element supplier for this column.
   *
   * @return the header element supplier
   */
  public HeaderElementSupplier getHeaderElementSupplier() {
    return headerElementSupplier;
  }

  /**
   * Sets the header element supplier for this column.
   *
   * @param headerElement the header element supplier to set
   * @return the current instance for chaining
   */
  public ColumnConfig<T> setHeaderElementSupplier(HeaderElementSupplier headerElement) {
    this.headerElementSupplier = headerElement;
    return this;
  }

  /**
   * Gets the minimum width of the column.
   *
   * @return the minimum width
   */
  public String getMinWidth() {
    return minWidth;
  }

  /**
   * Gets the maximum width of the column.
   *
   * @return the maximum width
   */
  public String getMaxWidth() {
    return maxWidth;
  }

  /**
   * Retrieves the text alignment for cells within this column.
   *
   * @return the cell text alignment
   */
  public CellTextAlign getTextAlign() {
    return cellTextAlign;
  }

  /**
   * Retrieves the text alignment for the header cell of this column.
   *
   * @return the header cell text alignment
   */
  public CellTextAlign getHeaderTextAlign() {
    return headerCellTextAlign;
  }

  /**
   * Checks if the column is fixed or not.
   *
   * @return true if the column is fixed, false otherwise
   */
  public boolean isFixed() {
    return fixed;
  }

  /**
   * Sets the fixed status for this column.
   *
   * @param fixed the fixed status to set
   * @return the current instance for chaining
   */
  public ColumnConfig<T> setFixed(boolean fixed) {
    this.fixed = fixed;
    return this;
  }

  /**
   * Sets the title for this column.
   *
   * @param title the title to set
   * @return the current instance for chaining
   */
  public ColumnConfig<T> setTitle(String title) {
    this.title = title;
    return this;
  }

  /**
   * Retrieves the head element of this column.
   *
   * @return the head element
   */
  public DominoElement<HTMLTableCellElement> getHeadElement() {
    return elementOf(headElement);
  }

  /**
   * Gets the renderer used for displaying cell data in this column.
   *
   * @return the cell renderer
   */
  public CellRenderer<T> getCellRenderer() {
    return cellRenderer;
  }

  /**
   * Sets the renderer for displaying cell data in this column. If the editable cell renderer is
   * null, it also updates the editable cell renderer.
   *
   * @param cellRenderer the cell renderer to set
   * @return the current instance for chaining
   */
  public ColumnConfig<T> setCellRenderer(CellRenderer<T> cellRenderer) {
    this.cellRenderer = cellRenderer;
    if (isNull(editableCellRenderer)) {
      this.editableCellRenderer = cellRenderer;
    }
    return this;
  }

  /**
   * Gets the renderer used for editable cells in this column. If the editable cell renderer is
   * null, it returns the cell renderer.
   *
   * @return the editable cell renderer or the cell renderer if editable one is null
   */
  public CellRenderer<T> getEditableCellRenderer() {
    if (isNull(editableCellRenderer)) {
      return cellRenderer;
    }
    return editableCellRenderer;
  }

  /**
   * Sets the renderer for editable cells in this column. If the cell renderer is null, it also
   * updates the cell renderer.
   *
   * @param editableCellRenderer the editable cell renderer to set
   * @return the current instance for chaining
   */
  public ColumnConfig<T> setEditableCellRenderer(CellRenderer<T> editableCellRenderer) {
    this.editableCellRenderer = editableCellRenderer;
    if (isNull(cellRenderer)) {
      this.cellRenderer = editableCellRenderer;
    }
    return this;
  }

  /**
   * Styles the header using the provided header styler.
   *
   * @param headerStyler the styler to be applied to the header
   * @return the current instance for chaining
   */
  public ColumnConfig<T> styleHeader(CellStyler<T> headerStyler) {
    this.headerStyler = headerStyler;
    return this;
  }

  /**
   * Styles the cells using the provided cell styler.
   *
   * @param cellStyler the styler to be applied to the cells
   * @return the current instance for chaining
   */
  public ColumnConfig<T> styleCell(CellStyler<T> cellStyler) {
    this.cellStyler = cellStyler;
    return this;
  }

  /**
   * Checks if the column is sortable.
   *
   * @return true if the column is sortable, false otherwise
   */
  public boolean isSortable() {
    return sortable;
  }

  /**
   * Sets the sortable status of the column using the default sort key.
   *
   * @param sortable the sortable status to set
   * @return the current instance for chaining
   */
  public ColumnConfig<T> setSortable(boolean sortable) {
    return setSortable(sortable, name);
  }

  /**
   * Sets the sortable status of the column with a specified sort key.
   *
   * @param sortable the sortable status to set
   * @param sortKey the sort key to use
   * @return the current instance for chaining
   */
  public ColumnConfig<T> setSortable(boolean sortable, String sortKey) {
    this.sortable = sortable;
    this.sortKey = sortKey;
    return this;
  }

  /**
   * Sets the column as sortable using the default sort key.
   *
   * @return the current instance for chaining
   */
  public ColumnConfig<T> sortable() {
    return setSortable(true, name);
  }

  /**
   * Sets the column as sortable with a specified sort key.
   *
   * @param sortKey the sort key to use
   * @return the current instance for chaining
   */
  public ColumnConfig<T> sortable(String sortKey) {
    return setSortable(true, sortKey);
  }

  /**
   * Applies the screen media styles to the provided element.
   *
   * @param element the element to apply styles to
   */
  public void applyScreenMedia(Element element) {
    DominoElement<Element> thElement = elements.elementOf(element);

    if (nonNull(showOn)) {
      thElement.showOn(showOn);
    }

    if (nonNull(hideOn)) {
      thElement.hideOn(hideOn);
    }
  }

  /**
   * Retrieves the tooltip node for this column. If it's not explicitly set, it uses the header
   * element supplier's element for the title.
   *
   * @return the tooltip node
   */
  public Node getTooltipNode() {
    if (nonNull(tooltipNode)) return tooltipNode;
    else {
      return getHeaderElementSupplier().asElement(title);
    }
  }

  /**
   * Sets the tooltip node for this column.
   *
   * @param tooltipNode the tooltip node to set
   * @return the current instance for chaining
   */
  public ColumnConfig<T> setTooltipNode(Node tooltipNode) {
    this.tooltipNode = tooltipNode;
    return this;
  }

  /**
   * Sets the tooltip text for this column. This also sets the tooltip node.
   *
   * @param tooltipText the tooltip text to set
   * @return the current instance for chaining
   */
  public ColumnConfig<T> setTooltipText(String tooltipText) {
    this.tooltipNode = elements.text(tooltipText);
    return this;
  }

  /**
   * Sets the visibility of the tooltip for this column.
   *
   * @param showTooltip true to show the tooltip, false otherwise
   * @return the current instance for chaining
   */
  public ColumnConfig<T> setShowTooltip(boolean showTooltip) {
    this.showTooltip = showTooltip;
    return this;
  }

  /**
   * Retrieves the screen media on which the column is shown.
   *
   * @return the screen media for showing the column
   */
  public ScreenMedia getShowOn() {
    return showOn;
  }

  /**
   * Sets the screen media on which the column should be shown.
   *
   * @param showOn the screen media for showing the column
   * @return the current instance for chaining
   */
  public ColumnConfig<T> showOn(ScreenMedia showOn) {
    this.showOn = showOn;
    return this;
  }

  /**
   * Retrieves the screen media on which the column is hidden.
   *
   * @return the screen media for hiding the column
   */
  public ScreenMedia getHideOn() {
    return hideOn;
  }

  /**
   * Sets the screen media on which the column should be hidden.
   *
   * @param hideOn the screen media for hiding the column
   * @return the current instance for chaining
   */
  public ColumnConfig<T> hideOn(ScreenMedia hideOn) {
    this.hideOn = hideOn;
    return this;
  }

  /** Applies header styling to the header element. */
  void applyHeaderStyle() {
    headerStyler.styleCell(headElement.element());
  }

  /**
   * Applies cell styling to the given element.
   *
   * @param element the element to be styled
   */
  void applyCellStyle(Element element) {
    cellStyler.styleCell(element);
  }

  /**
   * Retrieves the styler used for the header.
   *
   * @return the header styler
   */
  public CellStyler<T> getHeaderStyler() {
    return headerStyler;
  }

  /**
   * Retrieves the styler used for the cells.
   *
   * @return the cell styler
   */
  public CellStyler<T> getCellStyler() {
    return cellStyler;
  }

  /**
   * Checks if tooltips are shown for the column.
   *
   * @return true if tooltips are shown, false otherwise
   */
  public boolean isShowTooltip() {
    return showTooltip;
  }

  /**
   * Adds a show/hide listener to the column.
   *
   * @param showHideListener the listener to be added
   * @return the current instance for chaining
   */
  public ColumnConfig<T> addShowHideListener(ColumnShowHideListener showHideListener) {
    if (showHideListener.isPermanent()) {
      this.permanentHideListeners.add(showHideListener);
    } else {
      this.showHideListeners.add(showHideListener);
    }
    return this;
  }

  /**
   * Removes a show/hide listener from the column.
   *
   * @param showHideListener the listener to be removed
   * @return the current instance for chaining
   */
  public ColumnConfig<T> removeShowHideListener(ColumnShowHideListener showHideListener) {
    if (showHideListener.isPermanent()) {
      this.permanentHideListeners.remove(showHideListener);
    } else {
      this.showHideListeners.remove(showHideListener);
    }
    return this;
  }

  /**
   * Makes the column visible.
   *
   * @return the current instance for chaining
   */
  public ColumnConfig<T> show() {
    this.permanentHideListeners.forEach(showHideListener -> showHideListener.onShowHide(true));
    this.showHideListeners.forEach(showHideListener -> showHideListener.onShowHide(true));
    this.hidden = false;
    return this;
  }

  /**
   * Hides the column.
   *
   * @return the current instance for chaining
   */
  public ColumnConfig<T> hide() {
    this.permanentHideListeners.forEach(showHideListener -> showHideListener.onShowHide(false));
    this.showHideListeners.forEach(showHideListener -> showHideListener.onShowHide(false));
    this.hidden = true;
    return this;
  }

  /**
   * Toggles the display of the column.
   *
   * @param visible true to make the column visible, false to hide
   * @return the current instance for chaining
   */
  public ColumnConfig<T> toggleDisplay(boolean visible) {
    if (visible) {
      return show();
    } else {
      return hide();
    }
  }

  /** @deprecated Use {@link #clearShowHideListeners()} instead. */
  @Deprecated
  public void clearShowHideListners() {
    clearShowHideListeners();
  }

  /** Clears all non-permanent show/hide listeners. */
  public void clearShowHideListeners() {
    showHideListeners.clear();
  }

  /**
   * Checks if the column is hidden.
   *
   * @return true if the column is hidden, false otherwise
   */
  public boolean isHidden() {
    return hidden;
  }

  /**
   * Checks if the column is a plugin column.
   *
   * @return true if the column is a plugin column, false otherwise
   */
  public boolean isPluginColumn() {
    return pluginColumn;
  }

  /**
   * Sets the column as a plugin column.
   *
   * @param pluginColumn true to mark the column as a plugin column
   * @return the current instance for chaining
   */
  public ColumnConfig<T> setPluginColumn(boolean pluginColumn) {
    this.pluginColumn = pluginColumn;
    return this;
  }

  /**
   * Retrieves the sort key of the column, defaulting to the column name if not set.
   *
   * @return the sort key of the column
   */
  public String getSortKey() {
    return Optional.ofNullable(sortKey).orElse(name);
  }

  /**
   * Checks if the column is a utility column.
   *
   * @return true if the column is a utility column, false otherwise
   */
  public final boolean isUtilityColumn() {
    return "plugin-utility-column".equals(name);
  }

  /**
   * Checks if the column title is drawn.
   *
   * @return true if the title is drawn, false otherwise
   */
  public boolean isDrawTitle() {
    return drawTitle;
  }

  /**
   * Sets whether the column title should be drawn.
   *
   * @param drawTitle true to draw the title, false otherwise
   * @return the current instance for chaining
   */
  public ColumnConfig<T> setDrawTitle(boolean drawTitle) {
    this.drawTitle = drawTitle;
    return this;
  }

  /**
   * Adds a sub-column to the current column.
   *
   * @param column the sub-column to be added
   * @return the current instance for chaining
   */
  public ColumnConfig<T> addColumn(ColumnConfig<T> column) {
    column.parent = this;
    column.applyMeta(ColumnHeaderMeta.create());
    this.subColumns.add(column);
    return this;
  }

  /**
   * Checks if the column is a group of sub-columns.
   *
   * @return true if the column has sub-columns, false otherwise
   */
  public boolean isColumnGroup() {
    return !this.subColumns.isEmpty();
  }

  /**
   * Retrieves the total number of columns under this column, including itself.
   *
   * @return the total count of columns
   */
  public int getColumnsCount() {
    if (!isColumnGroup()) {
      return 1;
    }
    return this.subColumns.stream().map(ColumnConfig::getColumnsCount).reduce(0, Integer::sum);
  }

  /**
   * Retrieves the depth of the column in terms of nested sub-columns.
   *
   * @return the depth of the column
   */
  public int getColumnsDepth() {
    if (!isColumnGroup()) {
      return getGroupLevel();
    }
    return this.subColumns.stream().mapToInt(ColumnConfig::getColumnsDepth).max().orElse(0);
  }

  /**
   * Retrieves the level of the column in terms of nesting.
   *
   * @return the level of the column
   */
  public int getGroupLevel() {
    if (isNull(parent)) {
      return 0;
    }
    return 1 + parent.getGroupLevel();
  }

  /**
   * Retrieves the colspan value for the column.
   *
   * @return the colspan value
   */
  private int getColSpan() {
    if (!isColumnGroup()) {
      return 1;
    }
    return subColumns.stream().mapToInt(ColumnConfig::getColSpan).sum();
  }

  /**
   * Flattens the structure of the column, including all its sub-columns.
   *
   * @return a list of all columns under this column, including itself
   */
  public List<ColumnConfig<T>> flattenColumns() {
    List<ColumnConfig<T>> cols = new ArrayList<>();
    cols.add(this);
    if (isColumnGroup()) {
      subColumns.forEach(col -> cols.addAll(col.flattenColumns()));
    }
    return cols;
  }

  /**
   * Retrieves only the leaf columns under this column.
   *
   * @return a list of leaf columns
   */
  public List<ColumnConfig<T>> leafColumns() {
    List<ColumnConfig<T>> cols = new ArrayList<>();
    if (!isColumnGroup()) {
      cols.add(this);
    } else {
      subColumns.forEach(col -> cols.addAll(col.leafColumns()));
    }
    return cols;
  }

  /**
   * Retrieves the direct sub-columns of this column.
   *
   * @return a list of direct sub-columns
   */
  public List<ColumnConfig<T>> getSubColumns() {
    return subColumns;
  }

  /**
   * Checks if the column has a parent column.
   *
   * @return true if the column has a parent, false otherwise
   */
  public boolean hasParent() {
    return nonNull(parent);
  }

  /**
   * Associates metadata with the column.
   *
   * @param meta the metadata to be associated with the column
   * @return the current instance for chaining
   */
  public ColumnConfig<T> applyMeta(ComponentMeta meta) {
    columnMeta.put(meta.getKey(), meta);
    return this;
  }

  /**
   * Retrieves the metadata associated with a given key.
   *
   * @param key the key for which metadata is to be retrieved
   * @return an optional containing the metadata if present, otherwise an empty optional
   */
  @SuppressWarnings("all")
  public <C extends ComponentMeta> Optional<C> getMeta(String key) {
    return Optional.ofNullable((C) columnMeta.get(key));
  }

  /**
   * Removes the metadata associated with a given key.
   *
   * @param key the key for which metadata is to be removed
   * @return the current instance for chaining
   */
  public ColumnConfig<T> removeMeta(String key) {
    columnMeta.remove(key);
    return this;
  }

  /**
   * Renders the header of the column.
   *
   * @param dataTable the data table to which the column belongs
   * @param tableConfig the configuration of the table
   * @param headers the row elements that make up the headers
   */
  void renderHeader(DataTable<T> dataTable, TableConfig<T> tableConfig, TableRowElement[] headers) {
    int depth = getColumnsDepth();
    int startIndex = headers.length - 1 - depth;

    if (startIndex == 0) {
      elementOf(headers[0]).appendChild(createColumnElement(tableConfig));
    } else {
      ColumnHeader fillHeader =
          createColumnElement(tableConfig)
              .clearElement()
              .apply(self -> self.setAttribute("rowspan", startIndex + ""));
      ColumnHeaderMeta.get(this)
          .ifPresent(columnHeaderMeta -> columnHeaderMeta.addExtraHeadElement(fillHeader));
      elementOf(headers[0]).appendChild(fillHeader);
      elementOf(headers[startIndex]).appendChild(createColumnElement(tableConfig));
    }

    if (isColumnGroup()) {
      renderChildColumns(dataTable, tableConfig, headers, startIndex + 1);
    }
    tableConfig.getPlugins().forEach(plugin -> plugin.onHeaderAdded(dataTable, this));
  }

  /**
   * Renders the child columns under this column.
   *
   * @param dataTable the data table to which the column belongs
   * @param tableConfig the configuration of the table
   * @param headers the row elements that make up the headers
   * @param startIndex the starting index to begin rendering child columns
   */
  private void renderChildColumns(
      DataTable<T> dataTable,
      TableConfig<T> tableConfig,
      TableRowElement[] headers,
      int startIndex) {
    getSubColumns()
        .forEach(
            col -> {
              if (col.isColumnGroup()) {
                elementOf(headers[startIndex])
                    .appendChild(
                        col.createColumnElement(tableConfig)
                            .apply(
                                self -> {
                                  if (startIndex < (headers.length - col.getColumnsDepth())) {
                                    int diff = headers.length - col.getColumnsDepth() - 1;
                                    self.setAttribute("rowspan", diff + 1 + "");
                                  }
                                }));
                col.renderChildColumns(dataTable, tableConfig, headers, startIndex + 1);
              } else {
                int index = headers.length - 1;
                if (index > startIndex) {
                  int diff = startIndex - index;
                  ColumnHeader fillHeader =
                      col.createColumnElement(tableConfig)
                          .clearElement()
                          .setAttribute("rowspan", diff + "");
                  ColumnCssRuleMeta.get(this)
                      .ifPresent(
                          meta ->
                              meta.cssRules()
                                  .forEach(
                                      columnCssRule ->
                                          fillHeader.addCss(
                                              columnCssRule.getCssRule().getCssClass())));
                  ColumnHeaderMeta.get(col)
                      .ifPresent(
                          columnHeaderMeta -> columnHeaderMeta.addExtraHeadElement(fillHeader));
                  elementOf(headers[startIndex]).appendChild(fillHeader);
                }
                elementOf(headers[index]).appendChild(col.createColumnElement(tableConfig));
                tableConfig.getPlugins().forEach(plugin -> plugin.onHeaderAdded(dataTable, col));
              }
            });
  }

  /**
   * Creates a column header element based on the table configuration and column properties.
   *
   * @param tableConfig the configuration of the table
   * @return the created column header
   */
  private ColumnHeader createColumnElement(TableConfig<T> tableConfig) {
    if (isDrawTitle() && nonNull(getTitle())) {
      this.headElement = ColumnHeader.create(getHeaderElementSupplier().asElement(getTitle()));
    } else {
      this.headElement = ColumnHeader.create();
    }
    this.headElement.setAttribute("colspan", getColSpan() + "").appendChild(menuIcon);

    if (isColumnGroup()) {
      this.headElement.addCss("dui-column-group");
    }

    ColumnCssRuleMeta.get(this)
        .ifPresent(
            meta ->
                meta.cssRules()
                    .forEach(
                        columnCssRule ->
                            this.headElement.addCss(columnCssRule.getCssRule().getCssClass())));

    applyScreenMedia(this.headElement.element());

    if (tableConfig.isFixed() || isFixed()) {
      fixElementWidth(this, this.headElement.element());
    }

    if (isShowTooltip()) {
      Tooltip.create(this.headElement.element(), getTooltipNode());
    }
    applyHeaderStyle();
    addShowHideListener(DefaultColumnShowHideListener.of(this.headElement.element(), true));
    this.headElement.toggleDisplay(!isHidden());
    return this.headElement;
  }

  /**
   * Applies the given handler to this column and recursively to all of its sub-columns.
   *
   * @param handler the consumer to be applied
   * @return the current column instance for chaining
   */
  public ColumnConfig<T> applyAndOnSubColumns(Consumer<ColumnConfig<T>> handler) {
    handler.accept(this);
    if (isColumnGroup()) {
      getSubColumns().forEach(col -> col.applyAndOnSubColumns(handler));
    }
    return this;
  }

  /**
   * Applies the given handler to this column and recursively to all of its sub-columns if they
   * satisfy the given predicate.
   *
   * @param predicate the condition to be checked before applying the handler
   * @param handler the consumer to be applied if the predicate is true
   * @return the current column instance for chaining
   */
  public ColumnConfig<T> applyAndOnSubColumns(
      Predicate<ColumnConfig<T>> predicate, Consumer<ColumnConfig<T>> handler) {
    handler.accept(this);
    if (isColumnGroup()) {
      getSubColumns().forEach(col -> col.applyAndOnSubColumns(handler));
    }
    return this;
  }

  /**
   * Applies the given handler to this column and recursively to the first sub-column of each
   * subsequent column group.
   *
   * @param handler the consumer to be applied
   * @return the current column instance for chaining
   */
  public ColumnConfig<T> applyAndOnEachFirstSubColumn(Consumer<ColumnConfig<T>> handler) {
    handler.accept(this);
    if (isColumnGroup()) {
      getSubColumns().get(0).applyAndOnEachFirstSubColumn(handler);
    }
    return this;
  }

  /**
   * Applies the given handler to the first sub-column of this column.
   *
   * @param handler the consumer to be applied
   * @return the current column instance for chaining
   */
  public ColumnConfig<T> onFirstSubColumn(Consumer<ColumnConfig<T>> handler) {
    if (isColumnGroup()) {
      getSubColumns().get(0).applyAndOnEachFirstSubColumn(handler);
    }
    return this;
  }

  /**
   * Applies the given handler to this column and recursively to the last sub-column of each
   * subsequent column group.
   *
   * @param handler the consumer to be applied
   * @return the current column instance for chaining
   */
  public ColumnConfig<T> applyAndOnEachLastSubColumn(Consumer<ColumnConfig<T>> handler) {
    handler.accept(this);
    if (isColumnGroup()) {
      getSubColumns().get(getSubColumns().size() - 1).applyAndOnEachLastSubColumn(handler);
    }
    return this;
  }

  /**
   * Applies the given handler to the last sub-column of this column.
   *
   * @param handler the consumer to be applied
   * @return the current column instance for chaining
   */
  public ColumnConfig<T> onEachLastSubColumn(Consumer<ColumnConfig<T>> handler) {
    if (isColumnGroup()) {
      getSubColumns().get(getSubColumns().size() - 1).applyAndOnEachLastSubColumn(handler);
    }
    return this;
  }

  /**
   * Applies the given handler to this column and recursively to all of its parent columns.
   *
   * @param handler the consumer to be applied
   * @return the current column instance for chaining
   */
  public ColumnConfig<T> applyAndOnParents(Consumer<ColumnConfig<T>> handler) {
    handler.accept(this);
    if (this.hasParent()) {
      getParent().applyAndOnParents(handler);
    }
    return this;
  }

  /**
   * Retrieves the grandparent column of this column, or itself if it doesn't have a grandparent.
   *
   * @return the grandparent column or the current column
   */
  public ColumnConfig<T> getGrandParent() {
    if (hasParent()) {
      return getParent().getGrandParent();
    }
    return this;
  }

  /**
   * Retrieves the last grand sibling column of this column group. If the column is not a column
   * group, it retrieves itself.
   *
   * @return the last grand sibling column or the current column
   */
  public ColumnConfig<T> getLastGrandSiblingColumn() {
    if (!isColumnGroup()) {
      return this;
    }
    return this.getSubColumns().get(this.getSubColumns().size() - 1).getLastGrandSiblingColumn();
  }

  /**
   * Retrieves the first grand sibling column of this column group. If the column is not a column
   * group, it retrieves itself.
   *
   * @return the first grand sibling column or the current column
   */
  public ColumnConfig<T> getFirstGrandSiblingColumn() {
    if (!isColumnGroup()) {
      return this;
    }
    return this.getSubColumns().get(0).getFirstGrandSiblingColumn();
  }

  /**
   * Retrieves the associated menu of the column.
   *
   * @return the menu associated with the column
   */
  public Menu<String> getMenu() {
    return menu;
  }

  /**
   * Retrieves the parent column of this column.
   *
   * @return the parent column or null if this column does not have a parent
   */
  public ColumnConfig<T> getParent() {
    return parent;
  }

  /**
   * Appends the given element as a child to the header element of this column.
   *
   * @param element the element to be appended
   * @return the current column instance for chaining
   */
  public ColumnConfig<T> appendChild(IsElement<?> element) {
    headElement.appendChild(element);
    return this;
  }

  /**
   * Removes the specified child node from the header element of this column if it is a direct
   * child.
   *
   * @param child the child node to be removed
   * @return the current column instance for chaining
   */
  public ColumnConfig<T> removeChild(Node child) {
    if (headElement.contains(child)) {
      headElement.removeChild(child);
    }
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ColumnConfig<?> that = (ColumnConfig<?>) o;
    return Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  /**
   * Removes the specified child element from the header element of this column.
   *
   * @param child the child element to be removed
   * @return the current column instance for chaining
   */
  public ColumnConfig<T> removeChild(IsElement<?> child) {
    return removeChild(child.element());
  }

  /** Functional interface for styling the cells of a column. */
  @FunctionalInterface
  public interface CellStyler<T> {

    /**
     * Applies styling to the given cell element.
     *
     * @param element the cell element to be styled
     */
    void styleCell(Element element);
  }
}
