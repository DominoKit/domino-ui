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

import elemental2.dom.Element;
import elemental2.dom.HTMLTableCellElement;
import elemental2.dom.Node;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.elements.TableRowElement;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.icons.MdiIcon;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.menu.direction.BestSideUpDownDropDirection;
import org.dominokit.domino.ui.popover.Tooltip;
import org.dominokit.domino.ui.utils.*;

/**
 * Class to define a column in the data table
 *
 * @param <T> the type of the data table records
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
   * Creates an instance with a name which will also be used as a title
   *
   * @param name String, the name of the column
   * @param <T> the type of the data table records
   * @return new {@link ColumnConfig} instance
   */
  public static <T> ColumnConfig<T> create(String name) {
    return new ColumnConfig<>(name);
  }

  /**
   * Creates an instance with a name and title
   *
   * @param name String, the name of the column
   * @param title String, the title of the column
   * @param <T> the type of the data table records
   * @return new {@link ColumnConfig} instance
   */
  public static <T> ColumnConfig<T> create(String name, String title) {
    return new ColumnConfig<>(name, title);
  }

  /**
   * Creates an instance with a name and title
   *
   * @param name String, the name of the column
   * @param title String, the title of the column
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
   * Creates an instance with a name which will also be used as a title
   *
   * @param name String, the name of the column
   */
  public ColumnConfig(String name) {
    this(name, "");
  }

  /** @return String column title */
  public String getTitle() {
    return title;
  }

  /** @return String column name */
  public String getName() {
    return name;
  }

  public String getFilterKey() {
    return nonNull(filterKey) ? filterKey : getName();
  }

  public ColumnConfig<T> setFilterKey(String filterKey) {
    this.filterKey = filterKey;
    return this;
  }

  /**
   * @param minWidth String css minimum width for the column
   * @return same ColumnConfig instance
   */
  public ColumnConfig<T> minWidth(String minWidth) {
    this.minWidth = minWidth;
    return this;
  }

  /**
   * @param maxWidth String css maximum width for the column
   * @return same ColumnConfig instance
   */
  public ColumnConfig<T> maxWidth(String maxWidth) {
    this.maxWidth = maxWidth;
    return this;
  }

  /**
   * @return String the width of the column that we set using the {@link #setWidth(String)} not the
   *     actual width of the column
   */
  public String getWidth() {
    return width;
  }

  /**
   * @param width String css width for the column
   * @return same ColumnConfig instance
   */
  public ColumnConfig<T> setWidth(String width) {
    this.width = width;
    return this;
  }

  /**
   * @param cellTextAlign String css text align for the column values
   *     <b>left</b>,<b>right</b>,<b>center</b>
   * @return same ColumnConfig instance
   */
  public ColumnConfig<T> setTextAlign(CellTextAlign cellTextAlign) {
    this.cellTextAlign = cellTextAlign;
    return this;
  }

  /**
   * @param headerCellTextAlign String css text align for the column header
   *     <b>left</b>,<b>right</b>,<b>center</b>
   * @return same ColumnConfig instance
   */
  public ColumnConfig<T> setHeaderTextAlign(CellTextAlign headerCellTextAlign) {
    this.headerCellTextAlign = headerCellTextAlign;
    return this;
  }

  /** @return the {@link HeaderElementSupplier} of the column */
  @Deprecated
  public HeaderElementSupplier getHeaderElement() {
    return getHeaderElementSupplier();
  }

  /** @return the {@link HeaderElementSupplier} of the column */
  public HeaderElementSupplier getHeaderElementSupplier() {
    return headerElementSupplier;
  }

  /**
   * Sets a custom header element for the column
   *
   * @param headerElement the {@link HeaderElementSupplier}
   * @return same ColumnConfig instance
   */
  @Deprecated
  public ColumnConfig<T> setHeaderElement(HeaderElementSupplier headerElement) {
    return setHeaderElementSupplier(headerElement);
  }

  /**
   * Sets a custom header element for the column
   *
   * @param headerElement the {@link HeaderElementSupplier}
   * @return same ColumnConfig instance
   */
  public ColumnConfig<T> setHeaderElementSupplier(HeaderElementSupplier headerElement) {
    this.headerElementSupplier = headerElement;
    return this;
  }

  /** @return the String minimum width we set with {@link #minWidth(String)} */
  public String getMinWidth() {
    return minWidth;
  }

  /** @return the String maximum width we set with {@link #maxWidth(String)} */
  public String getMaxWidth() {
    return maxWidth;
  }

  /** @return the String text align we set with {@link #setTextAlign(CellTextAlign)} */
  public CellTextAlign getTextAlign() {
    return cellTextAlign;
  }

  /** @return the String text align we set with {@link #setHeaderTextAlign(CellTextAlign)} */
  public CellTextAlign getHeaderTextAlign() {
    return headerCellTextAlign;
  }

  /**
   * @return boolean, if true the column width will be fixed and wont change if the table size
   *     changed
   */
  public boolean isFixed() {
    return fixed;
  }

  /**
   * @param fixed boolean, if true the column width will be fixed and wont change when the table
   *     size is changed.
   * @return same ColumnConfig instance.
   */
  public ColumnConfig<T> setFixed(boolean fixed) {
    this.fixed = fixed;
    return this;
  }

  public ColumnConfig<T> setTitle(String title) {
    this.title = title;
    return this;
  }

  /**
   * @return the {@link HTMLTableCellElement} that represent this column element wrapped as {@link
   *     DominoElement}
   */
  public DominoElement<HTMLTableCellElement> getHeadElement() {
    return elementOf(headElement);
  }

  /** @return the {@link CellRenderer} of this column */
  public CellRenderer<T> getCellRenderer() {
    return cellRenderer;
  }

  /**
   * sets the cell renderer for this column
   *
   * @param cellRenderer {@link CellRenderer}
   * @return same ColumnConfig instance
   */
  public ColumnConfig<T> setCellRenderer(CellRenderer<T> cellRenderer) {
    this.cellRenderer = cellRenderer;
    if (isNull(editableCellRenderer)) {
      this.editableCellRenderer = cellRenderer;
    }
    return this;
  }

  /** @return the {@link CellRenderer} of the editable version of this column */
  public CellRenderer<T> getEditableCellRenderer() {
    if (isNull(editableCellRenderer)) {
      return cellRenderer;
    }
    return editableCellRenderer;
  }

  /**
   * sets the cell renderer to render this column cells in editable mode
   *
   * @param editableCellRenderer {@link CellRenderer}
   * @return same ColumnConfig instance
   */
  public ColumnConfig<T> setEditableCellRenderer(CellRenderer<T> editableCellRenderer) {
    this.editableCellRenderer = editableCellRenderer;
    if (isNull(cellRenderer)) {
      this.cellRenderer = editableCellRenderer;
    }
    return this;
  }

  /**
   * a hook to style a column header
   *
   * @param headerStyler {@link CellStyler}
   * @return same ColumnConfig instance
   */
  public ColumnConfig<T> styleHeader(CellStyler<T> headerStyler) {
    this.headerStyler = headerStyler;
    return this;
  }

  /**
   * a hook to style a cell in the column
   *
   * @param cellStyler {@link CellStyler}
   * @return same ColumnConfig instance
   */
  public ColumnConfig<T> styleCell(CellStyler<T> cellStyler) {
    this.cellStyler = cellStyler;
    return this;
  }

  /** @return boolean, true if data can be sorted with this column, otherwise false */
  public boolean isSortable() {
    return sortable;
  }

  /**
   * set wither the column can be used to sort the data or not
   *
   * @param sortable boolean, if true then data can be sorted with this column, otherwise it cant
   * @return same ColumnConfig instance
   */
  public ColumnConfig<T> setSortable(boolean sortable) {
    return setSortable(sortable, name);
  }

  /**
   * set wither the column can be used to sort the data or not
   *
   * @param sortable boolean, if true then data can be sorted with this column, otherwise it cant
   * @return same ColumnConfig instance
   */
  public ColumnConfig<T> setSortable(boolean sortable, String sortKey) {
    this.sortable = sortable;
    this.sortKey = sortKey;
    return this;
  }

  /**
   * a shortcut for {@link #setSortable(boolean)} with value true
   *
   * @return same ColumnConfig instance
   */
  public ColumnConfig<T> sortable() {
    return setSortable(true, name);
  }

  /**
   * a shortcut for {@link #setSortable(boolean)} with value true
   *
   * @param sortKey String key for sort property
   * @return same ColumnConfig instance
   */
  public ColumnConfig<T> sortable(String sortKey) {
    return setSortable(true, sortKey);
  }

  /**
   * force apply screen medias if exists to a cell in this column
   *
   * @param element {@link HTMLTableCellElement}
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
   * @return the {@link Node} representing the tooltip for this column header if exists otherwise
   *     return the title node
   */
  public Node getTooltipNode() {
    if (nonNull(tooltipNode)) return tooltipNode;
    else {
      return getHeaderElementSupplier().asElement(title);
    }
  }

  /**
   * sets a custom tooltip element
   *
   * @param tooltipNode {@link Node}
   * @return same ColumnConfig instance
   */
  public ColumnConfig<T> setTooltipNode(Node tooltipNode) {
    this.tooltipNode = tooltipNode;
    return this;
  }

  /**
   * sets the tooltip text
   *
   * @param tooltipText String
   * @return same ColumnConfig instance
   */
  public ColumnConfig<T> setTooltipText(String tooltipText) {
    this.tooltipNode = elements.text(tooltipText);
    return this;
  }

  /**
   * @param showTooltip boolean, if true a tooltip will show up when hover on the column otherwise
   *     it will not.
   * @return same ColumnConfig instance
   */
  public ColumnConfig<T> setShowTooltip(boolean showTooltip) {
    this.showTooltip = showTooltip;
    return this;
  }

  /** @return the {@link ScreenMedia} that result on showing the column */
  public ScreenMedia getShowOn() {
    return showOn;
  }

  /**
   * @param showOn {@link ScreenMedia} when is applied the column will be shown
   * @return same ColumnConfig instance
   */
  public ColumnConfig<T> showOn(ScreenMedia showOn) {
    this.showOn = showOn;
    return this;
  }

  /** @return the {@link ScreenMedia} that result on hiding the column */
  public ScreenMedia getHideOn() {
    return hideOn;
  }

  /**
   * @param hideOn {@link ScreenMedia} when is applied the column will be hidden
   * @return same ColumnConfig instance
   */
  public ColumnConfig<T> hideOn(ScreenMedia hideOn) {
    this.hideOn = hideOn;
    return this;
  }

  /** make the headerStyler apply the styles */
  void applyHeaderStyle() {
    headerStyler.styleCell(headElement.element());
  }

  /**
   * make the cellStyler apply the style
   *
   * @param element {@link HTMLTableCellElement}
   */
  void applyCellStyle(Element element) {
    cellStyler.styleCell(element);
  }

  /** @return the {@link CellStyler} of the header element */
  public CellStyler<T> getHeaderStyler() {
    return headerStyler;
  }

  /** @return the {@link CellStyler} of the cell element */
  public CellStyler<T> getCellStyler() {
    return cellStyler;
  }

  /** @return boolean, if true this column show a tooltip otherwise it does not */
  public boolean isShowTooltip() {
    return showTooltip;
  }

  /**
   * Adds a listener to listen for column hide/show changes
   *
   * @param showHideListener {@link ColumnShowHideListener}
   * @return same ColumnConfig instance
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
   * remove the listener
   *
   * @param showHideListener {@link ColumnShowHideListener}
   * @return same ColumnConfig instance
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
   * show the column and call the listeners
   *
   * @return same ColumnConfig instance
   */
  public ColumnConfig<T> show() {
    this.permanentHideListeners.forEach(showHideListener -> showHideListener.onShowHide(true));
    this.showHideListeners.forEach(showHideListener -> showHideListener.onShowHide(true));
    this.hidden = false;
    return this;
  }

  /**
   * Hides the column and call the listeners
   *
   * @return same ColumnConfig instance
   */
  public ColumnConfig<T> hide() {
    this.permanentHideListeners.forEach(showHideListener -> showHideListener.onShowHide(false));
    this.showHideListeners.forEach(showHideListener -> showHideListener.onShowHide(false));
    this.hidden = true;
    return this;
  }

  /**
   * @param visible boolean, if true call {@link #show()} otherwise call {@link #hide()}
   * @return
   */
  public ColumnConfig<T> toggleDisplay(boolean visible) {
    if (visible) {
      return show();
    } else {
      return hide();
    }
  }

  /** @deprecated use {@link ColumnConfig#clearShowHideListeners()} */
  @Deprecated
  public void clearShowHideListners() {
    clearShowHideListeners();
  }

  /** removes all {@link ColumnShowHideListener}s of this column except the permanent listeners */
  public void clearShowHideListeners() {
    showHideListeners.clear();
  }

  /** @return boolean, true if the column is already hidden, otherwise false */
  public boolean isHidden() {
    return hidden;
  }

  /** @return boolean, true if the column is registered by a plugin, else false */
  public boolean isPluginColumn() {
    return pluginColumn;
  }

  /**
   * flags the columns as a plugin column or not
   *
   * @param pluginColumn boolean, true if the column is being registered by a plugin, else false
   * @return same ColumnConfig instance
   */
  public ColumnConfig<T> setPluginColumn(boolean pluginColumn) {
    this.pluginColumn = pluginColumn;
    return this;
  }

  /** @return String key of the column */
  public String getSortKey() {
    return Optional.ofNullable(sortKey).orElse(name);
  }

  /** @return boolean, true of the column is the plugins utility column, otherwise return false */
  public final boolean isUtilityColumn() {
    return "plugin-utility-column".equals(name);
  }

  /** @return boolean, true if the column show render the title */
  public boolean isDrawTitle() {
    return drawTitle;
  }

  /**
   * Set if the column should render its title or not
   *
   * @param drawTitle boolean
   * @return same ColumnConfig instance
   */
  public ColumnConfig<T> setDrawTitle(boolean drawTitle) {
    this.drawTitle = drawTitle;
    return this;
  }

  /**
   * Adds a configuration for a column in the data table
   *
   * @param column {@link ColumnConfig}
   * @return same TableConfig instance
   */
  public ColumnConfig<T> addColumn(ColumnConfig<T> column) {
    column.parent = this;
    column.applyMeta(ColumnHeaderMeta.create());
    this.subColumns.add(column);
    return this;
  }

  public boolean isColumnGroup() {
    return !this.subColumns.isEmpty();
  }

  public int getColumnsCount() {
    if (!isColumnGroup()) {
      return 1;
    }
    return this.subColumns.stream().map(ColumnConfig::getColumnsCount).reduce(0, Integer::sum);
  }

  public int getColumnsDepth() {
    if (!isColumnGroup()) {
      return getGroupLevel();
    }
    return this.subColumns.stream().mapToInt(ColumnConfig::getColumnsDepth).max().orElse(0);
  }

  public int getGroupLevel() {
    if (isNull(parent)) {
      return 0;
    }
    return 1 + parent.getGroupLevel();
  }

  private int getColSpan() {
    if (!isColumnGroup()) {
      return 1;
    }
    return subColumns.stream().mapToInt(ColumnConfig::getColSpan).sum();
  }

  public List<ColumnConfig<T>> flattenColumns() {
    List<ColumnConfig<T>> cols = new ArrayList<>();
    cols.add(this);
    if (isColumnGroup()) {
      subColumns.forEach(col -> cols.addAll(col.flattenColumns()));
    }
    return cols;
  }

  public List<ColumnConfig<T>> leafColumns() {
    List<ColumnConfig<T>> cols = new ArrayList<>();
    if (!isColumnGroup()) {
      cols.add(this);
    } else {
      subColumns.forEach(col -> cols.addAll(col.leafColumns()));
    }
    return cols;
  }

  public List<ColumnConfig<T>> getSubColumns() {
    return subColumns;
  }

  public boolean hasParent() {
    return nonNull(parent);
  }

  public ColumnConfig<T> applyMeta(ComponentMeta meta) {
    columnMeta.put(meta.getKey(), meta);
    return this;
  }

  @SuppressWarnings("all")
  public <C extends ComponentMeta> Optional<C> getMeta(String key) {
    return Optional.ofNullable((C) columnMeta.get(key));
  }

  public ColumnConfig<T> removeMeta(String key) {
    columnMeta.remove(key);
    return this;
  }

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

  private ColumnHeader createColumnElement(TableConfig<T> tableConfig) {

    //        flexLayout = FlexLayout.create().setAlignItems(FlexAlign.CENTER);
    //        if (isDrawTitle() && nonNull(getTitle())) {
    //            flexLayout.appendChild(
    //                    div().css("dui-th-title-wrapper")
    //                            .addCss(SpacingCss.dui_order_50)
    //                            .appendChild(getHeaderElementSupplier().asElement(getTitle())));
    //
    //            flexLayout.appendChild(
    //                    div().addCss(() -> "dui-th-filler", dui_order_60, dui_grow_1)
    //            );
    //        }

    //        flexLayout
    //                .appendChild(menuIcon.addCss(dui_font_size_4)
    //                        .clickable()
    //                        .removeWaves()
    //                        .addCss(dui_order_last_1));
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

  public ColumnConfig<T> applyAndOnSubColumns(Consumer<ColumnConfig<T>> handler) {
    handler.accept(this);
    if (isColumnGroup()) {
      getSubColumns().forEach(col -> col.applyAndOnSubColumns(handler));
    }
    return this;
  }

  public ColumnConfig<T> applyAndOnSubColumns(
      Predicate<ColumnConfig<T>> predicate, Consumer<ColumnConfig<T>> handler) {
    handler.accept(this);
    if (isColumnGroup()) {
      getSubColumns().forEach(col -> col.applyAndOnSubColumns(handler));
    }
    return this;
  }

  public ColumnConfig<T> applyAndOnEachFirstSubColumn(Consumer<ColumnConfig<T>> handler) {
    handler.accept(this);
    if (isColumnGroup()) {
      getSubColumns().get(0).applyAndOnEachFirstSubColumn(handler);
    }
    return this;
  }

  public ColumnConfig<T> onFirstSubColumn(Consumer<ColumnConfig<T>> handler) {
    if (isColumnGroup()) {
      getSubColumns().get(0).applyAndOnEachFirstSubColumn(handler);
    }
    return this;
  }

  public ColumnConfig<T> applyAndOnEachLastSubColumn(Consumer<ColumnConfig<T>> handler) {
    handler.accept(this);
    if (isColumnGroup()) {
      getSubColumns().get(getSubColumns().size() - 1).applyAndOnEachLastSubColumn(handler);
    }
    return this;
  }

  public ColumnConfig<T> onEachLastSubColumn(Consumer<ColumnConfig<T>> handler) {
    if (isColumnGroup()) {
      getSubColumns().get(getSubColumns().size() - 1).applyAndOnEachLastSubColumn(handler);
    }
    return this;
  }

  public ColumnConfig<T> applyAndOnParents(Consumer<ColumnConfig<T>> handler) {
    handler.accept(this);
    if (this.hasParent()) {
      getParent().applyAndOnParents(handler);
    }
    return this;
  }

  public ColumnConfig<T> getGrandParent() {
    if (hasParent()) {
      return getParent().getGrandParent();
    }
    return this;
  }

  public ColumnConfig<T> getLastGrandSiblingColumn() {
    if (!isColumnGroup()) {
      return this;
    }
    return this.getSubColumns().get(this.getSubColumns().size() - 1).getLastGrandSiblingColumn();
  }

  public ColumnConfig<T> getFirstGrandSiblingColumn() {
    if (!isColumnGroup()) {
      return this;
    }
    return this.getSubColumns().get(0).getFirstGrandSiblingColumn();
  }

  public Menu<String> getMenu() {
    return menu;
  }

  public ColumnConfig<T> getParent() {
    return parent;
  }

  public ColumnConfig<T> appendChild(IsElement<?> element) {
    headElement.appendChild(element);
    return this;
  }

  public ColumnConfig<T> removeChild(Node child) {
    if (headElement.contains(child)) {
      headElement.removeChild(child);
    }
    return this;
  }

  public ColumnConfig<T> removeChild(IsElement<?> child) {
    return removeChild(child.element());
  }

  /**
   * A hook interface to style a cell being rendered on the table
   *
   * @param <T> the type of the data table records
   */
  @FunctionalInterface
  public interface CellStyler<T> {
    /** @param element the {@link HTMLTableCellElement} to be styled */
    void styleCell(Element element);
  }
}
