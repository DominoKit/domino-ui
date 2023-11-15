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
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.DomGlobal;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.Node;
import java.util.*;
import java.util.stream.Collectors;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.datatable.events.*;
import org.dominokit.domino.ui.datatable.model.SearchContext;
import org.dominokit.domino.ui.datatable.store.DataStore;
import org.dominokit.domino.ui.elements.*;
import org.dominokit.domino.ui.events.EventType;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.utils.*;

/**
 * Represents a flexible and feature-rich data table for displaying and interacting with data. The
 * DataTable provides features like column configurations, event listeners, row selection, row
 * filtering, etc. for working with both tabular data and hierarchical data structures.
 *
 * @param <T> the type of data to be displayed in the table
 * @see BaseDominoElement
 */
public class DataTable<T> extends BaseDominoElement<HTMLDivElement, DataTable<T>>
    implements HasSelectionSupport<TableRow<T>>,
        HasSelectionListeners<DataTable<T>, TableRow<T>, List<TableRow<T>>>,
        DataTableStyles {

  /** Constant used for wildcard event listeners. */
  public static final String ANY = "*";

  /** CSS class to indicate that a data table row is filtered. */
  public static final String DATA_TABLE_ROW_FILTERED = "data-table-row-filtered";

  /** Prefix used for parent selector CSS. */
  private static final String PARENT_SELECTOR_PREFIX = "dui-dt-";

  private final DataStore<T> dataStore;
  private DivElement root = div().addCss(dui_datatable_responsive);
  private TableElement tableElement;
  private TableConfig<T> tableConfig;
  private TBodyElement tbody = tbody().addCss(dui_datatable_body);
  private THeadElement thead = thead().addCss(dui_datatable_thead);
  private TFootElement tfoot = tfoot().addCss(dui_datatable_tfoot);
  private List<T> data = new ArrayList<>();
  private boolean selectable = true;
  private List<TableRow<T>> tableRows = new ArrayList<>();

  private boolean selectionListenersPaused = false;

  private Map<String, List<TableEventListener>> events = new HashMap<>();

  private final SearchContext<T> searchContext = new SearchContext<>(this);

  private RemoveRowsHandler<T> removeRecordsHandler = table -> table.bodyElement().clearElement();

  private EventListener disableKeyboardListener =
      evt -> {
        if (isDisabled()) {
          evt.preventDefault();
          evt.stopPropagation();
        }
      };

  private DynamicStyleSheet<HTMLDivElement, DataTable<T>> dynamicStyleSheet;
  private Set<SelectionListener<? super TableRow<T>, ? super List<TableRow<T>>>>
      selectionListeners = new HashSet<>();
  private Set<SelectionListener<? super TableRow<T>, ? super List<TableRow<T>>>>
      deselectionListeners = new HashSet<>();

  /**
   * Constructs a DataTable with the provided table configuration and data store.
   *
   * @param tableConfig Configuration details of the table.
   * @param dataStore Data storage handler to fetch and manipulate data for the table.
   */
  public DataTable(TableConfig<T> tableConfig, DataStore<T> dataStore) {
    tableElement = table().addCss(dui_datatable, dui_datatable_width_full);
    super.init(this);
    this.tableConfig = tableConfig;

    this.events.put(ANY, new ArrayList<>());
    this.dataStore = dataStore;
    this.addTableEventListener(ANY, dataStore);
    tableElement.setAttribute("dui-data-v-scroll", 0);
    tableElement.setAttribute("dui-data-h-scroll", 0);
    this.addEventListener(EventType.keydown.getName(), disableKeyboardListener, true);
    tableElement.addEventListener(
        "scroll",
        evt -> {
          double scrollTop = new Double(tableElement.element().scrollTop).intValue();
          double scrollLeft = new Double(tableElement.element().scrollLeft).intValue();
          tableElement.setAttribute("dui-data-v-scroll", scrollTop);
          tableElement.setAttribute("dui-data-h-scroll", scrollLeft);
        });
    this.dataStore.onDataChanged(
        dataChangedEvent -> {
          fireTableEvent(
              new OnBeforeDataChangeEvent<>(
                  this.data, dataChangedEvent.getTotalCount(), dataChangedEvent.isAppend()));
          if (dataChangedEvent.getSortDir().isPresent()
              && dataChangedEvent.getSortColumn().isPresent()) {
            fireTableEvent(
                new DataSortEvent(
                    dataChangedEvent.getSortDir().get(), dataChangedEvent.getSortColumn().get()));
          }

          if (dataChangedEvent.isAppend()) {
            appendData(dataChangedEvent.getNewData());
          } else {
            setData(dataChangedEvent.getNewData());
          }
          fireTableEvent(new TableDataUpdatedEvent<>(this.data, dataChangedEvent.getTotalCount()));
        });

    initDynamicStyleSheet();
    init();
    onAttached(
        mutationRecord -> {
          DomGlobal.setTimeout(
              p0 -> {
                getDynamicStyleSheet().flush();
              },
              0);
        });
    addCss(dui_datatable_hover, dui_datatable_striped);
  }

  /** Initializes dynamic style sheet configurations for the table columns. */
  private void initDynamicStyleSheet() {
    this.dynamicStyleSheet = new DynamicStyleSheet<>(PARENT_SELECTOR_PREFIX, this);
    tableConfig
        .getColumnsGrouped()
        .forEach(
            col -> {
              col.applyAndOnSubColumns(
                  column -> {
                    ColumnCssRuleMeta<T> columnCssRuleMeta =
                        ColumnCssRuleMeta.of(this.dynamicStyleSheet);
                    columnCssRuleMeta.addRule(
                        ColumnCssRuleMeta.DEFAULT_RULE,
                        "col-" + column.getName().replace(" ", "-"));
                    column.applyMeta(columnCssRuleMeta);
                  });
            });
  }

  /**
   * Returns the data store associated with this data table.
   *
   * @return the associated DataStore instance.
   */
  public DataStore<T> getDataStore() {
    return dataStore;
  }

  /**
   * Initializes and sets up the data table UI components, plugins, and listeners.
   *
   * @return the initialized DataTable instance.
   */
  private DataTable<T> init() {
    tableConfig
        .getPlugins()
        .forEach(
            plugin -> {
              DataTable.this.addTableEventListener("*", plugin);
              plugin.init(DataTable.this);
              plugin.onBeforeAddTable(DataTable.this);
            });
    thead.clearElement();
    if (tableConfig.isStickyHeader()) {
      addCss(dui_datatable_sticky_header);
    }
    tableConfig.onBeforeHeaders(this);
    tableConfig.drawHeaders(this, thead);
    tableConfig.onAfterHeaders(this);
    tableElement.appendChild(tbody);
    tableConfig.getPlugins().forEach(plugin -> plugin.onBodyAdded(DataTable.this));
    tableElement.appendChild(tfoot);
    tableConfig.getPlugins().forEach(plugin -> plugin.onFooterAdded(DataTable.this));
    appendChild(tableElement);
    tableConfig.getPlugins().forEach(plugin -> plugin.onAfterAddTable(DataTable.this));
    if (!tableConfig.isLazyLoad()) {
      this.dataStore.load();
    }

    if (tableConfig.isFixed()) {
      tableElement.setMaxHeight(tableConfig.getFixedBodyHeight());
    }

    if (tableConfig.isFixed()) {
      dui_datatable_width_full.remove(this);
      this.addCss(dui_datatable_fixed);
      ColumnUtils.fixElementWidth(this, tableElement.element());
    }

    if (tableConfig.isFixed()) {
      ColumnUtils.fixElementWidth(this, tableElement.element());
    }
    return this;
  }

  /**
   * Redraws the data table by updating the headers and reloading the data.
   *
   * @return the current DataTable instance
   */
  public DataTable<T> redraw() {
    tableConfig.onBeforeHeaders(this);
    tableConfig.drawHeaders(this, thead);
    tableConfig.onAfterHeaders(this);
    load();
    return this;
  }

  /**
   * Loads the data into the data table.
   *
   * @return the current DataTable instance
   */
  public DataTable<T> load() {
    this.dataStore.load();
    return this;
  }

  /**
   * Sets the provided data to the data table.
   *
   * @param data the list of data to be set
   * @return the current DataTable instance
   */
  public DataTable<T> setData(List<T> data) {
    this.data = data;
    tableRows.clear();
    removeRecordsHandler.removeRows(this);
    if (nonNull(data) && !data.isEmpty()) {
      addRows(data, 0);
    }
    return this;
  }

  /**
   * Appends the provided data to the existing data in the table.
   *
   * @param newData the new data to be appended
   * @return the current DataTable instance
   */
  public DataTable<T> appendData(List<T> newData) {
    if (nonNull(this.data)) {
      addRows(newData, this.data.size());
      this.data.addAll(newData);
    } else {
      setData(newData);
    }
    return this;
  }

  /**
   * Adds rows to the data table based on the provided data and starting index.
   *
   * @param data the list of data to be added as rows
   * @param initialIndex the starting index for the new rows
   */
  private void addRows(List<T> data, int initialIndex) {
    tableConfig.getColumns().forEach(ColumnConfig::clearShowHideListeners);

    for (int index = 0; index < data.size(); index++) {
      TableRow<T> tableRow = new TableRow<>(data.get(index), initialIndex + index, this);
      tableConfig.getPlugins().forEach(plugin -> plugin.onBeforeAddRow(DataTable.this, tableRow));

      tableConfig.drawRecord(DataTable.this, tableRow);
      tableRows.add(tableRow);
    }

    tableConfig.getPlugins().forEach(plugin -> plugin.onAllRowsAdded(DataTable.this));
  }

  /**
   * Returns the current data present in the table.
   *
   * @return the collection of data in the table
   */
  public Collection<T> getData() {
    return data;
  }

  /**
   * Sets the condensed style for the data table.
   *
   * @param condensed a boolean indicating whether to enable the condensed style
   * @return the current DataTable instance
   */
  public DataTable<T> setCondensed(boolean condensed) {
    this.addCss(BooleanCssClass.of(dui_datatable_condensed, condensed));
    return this;
  }

  /**
   * Checks if the data table has a condensed style.
   *
   * @return a boolean indicating if the table is condensed
   */
  public boolean isCondensed() {
    return dui_datatable_condensed.isAppliedTo(this);
  }

  /**
   * Enables or disables the hover effect for the data table rows.
   *
   * @param hover a boolean indicating whether to enable the hover effect
   * @return the current DataTable instance
   */
  public DataTable<T> setHover(boolean hover) {
    this.addCss(BooleanCssClass.of(dui_datatable_hover, hover));
    return this;
  }

  /**
   * Checks if the hover effect is enabled for the data table rows.
   *
   * @return a boolean indicating if the hover effect is enabled
   */
  public boolean isHover() {
    return dui_datatable_hover.isAppliedTo(this);
  }

  /**
   * Sets the bordered style for the data table.
   *
   * @param bordered a boolean indicating whether to enable the bordered style
   * @return the current DataTable instance
   */
  public DataTable<T> setBordered(boolean bordered) {
    this.addCss(BooleanCssClass.of(dui_datatable_bordered, bordered));
    return this;
  }

  /**
   * Checks if the data table has a bordered style.
   *
   * @return a boolean indicating if the table is bordered
   */
  public boolean isBordered() {
    return dui_datatable_bordered.isAppliedTo(this);
  }

  /**
   * Sets the striped style for the data table rows.
   *
   * @param striped a boolean indicating whether to enable the striped style
   * @return the current DataTable instance
   */
  public DataTable<T> setStriped(boolean striped) {
    this.addCss(BooleanCssClass.of(dui_datatable_striped, striped));
    return this;
  }

  /**
   * Checks if the striped style is enabled for the data table rows.
   *
   * @return a boolean indicating if the striped style is enabled
   */
  public boolean isStriped() {
    return dui_datatable_striped.isAppliedTo(this);
  }

  /**
   * Initiates the edit mode for all rows in the data table.
   *
   * @return the current DataTable instance
   */
  public DataTable<T> edit() {
    getRows().forEach(TableRow::edit);
    return this;
  }

  /**
   * Saves any edits made to all rows in the data table.
   *
   * @return the current DataTable instance
   */
  public DataTable<T> save() {
    getRows().forEach(TableRow::save);
    return this;
  }

  /**
   * Cancels the edit mode and discards any unsaved changes for all rows in the data table.
   *
   * @return the current DataTable instance
   */
  public DataTable<T> cancelEditing() {
    getRows().forEach(TableRow::cancelEditing);
    return this;
  }

  /**
   * Retrieves the main table element associated with the data table.
   *
   * @return the table element
   */
  public TableElement tableElement() {
    return tableElement;
  }

  /**
   * Retrieves the body element of the table, which contains the data rows.
   *
   * @return the table body element
   */
  public TBodyElement bodyElement() {
    return tbody;
  }

  /**
   * Retrieves the header element of the table, which contains the column headers.
   *
   * @return the table header element
   */
  public THeadElement headerElement() {
    return thead;
  }

  /**
   * Retrieves the footer element of the table, which might contain summary rows or other additional
   * information.
   *
   * @return the table footer element
   */
  public TFootElement footerElement() {
    return tfoot;
  }

  /**
   * Retrieves the configuration object associated with the data table, which defines columns,
   * plugins, and other table settings.
   *
   * @return the table configuration object
   */
  public TableConfig<T> getTableConfig() {
    return tableConfig;
  }

  /**
   * Applies a provided filter to each row in the data table. Rows that pass the filter remain
   * visible, while rows that fail the filter are marked as filtered and potentially hidden or
   * styled differently.
   *
   * @param rowFilter the filter to apply to each row in the table
   * @return the current DataTable instance
   */
  public DataTable<T> filterRows(LocalRowFilter<T> rowFilter) {
    tableRows.forEach(
        tableRow -> {
          if (rowFilter.filter(tableRow)) {
            tableRow.removeCss(table_row_filtered);
            tableRow.removeFlag(DATA_TABLE_ROW_FILTERED);
            tableRow.fireUpdate();
          } else {
            tableRow.addCss(table_row_filtered);
            tableRow.setFlag(DATA_TABLE_ROW_FILTERED, "true");
            tableRow.deselect();
            tableRow.fireUpdate();
          }
        });
    return this;
  }

  /**
   * Removes any previously applied filters, making all rows visible.
   *
   * @return the current DataTable instance
   */
  public DataTable<T> clearRowFilters() {
    tableRows.stream()
        .filter(tableRow -> nonNull(tableRow.getFlag(DATA_TABLE_ROW_FILTERED)))
        .forEach(
            tableRow -> {
              tableRow.removeCss(table_row_filtered);
              tableRow.removeFlag(DATA_TABLE_ROW_FILTERED);
              tableRow.fireUpdate();
            });
    return this;
  }

  /**
   * Retrieves the root element associated with the data table.
   *
   * @return the root element of the data table
   */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }

  /**
   * Retrieves a list of all the table rows that are currently selected.
   *
   * @return a list of selected table rows
   */
  @Override
  public List<TableRow<T>> getSelectedItems() {
    return tableRows.stream().filter(TableRow::isSelected).collect(Collectors.toList());
  }

  /**
   * Retrieves a list of the records associated with the table rows that are currently selected.
   *
   * @return a list of records corresponding to selected table rows
   */
  public List<T> getSelectedRecords() {
    return tableRows.stream()
        .filter(TableRow::isSelected)
        .map(TableRow::getRecord)
        .collect(Collectors.toList());
  }

  /**
   * Retrieves a list of all the table rows.
   *
   * @return a list of all table rows
   */
  @Override
  public List<TableRow<T>> getRows() {
    return tableRows;
  }

  /**
   * Retrieves a list of all the root table rows.
   *
   * @return a list of root table rows
   */
  public List<TableRow<T>> getRootRows() {
    return getRows().stream().filter(TableRow::isRoot).collect(Collectors.toList());
  }

  /**
   * Retrieves a list of records associated with the root table rows.
   *
   * @return a list of records corresponding to root table rows
   */
  public List<T> getRecords() {
    return getRows().stream()
        .filter(TableRow::isRoot)
        .map(TableRow::getRecord)
        .collect(Collectors.toList());
  }

  /**
   * Retrieves a list of records that have been modified.
   *
   * @return a list of modified records
   */
  public List<T> getDirtyRecords() {
    return getRows().stream().map(TableRow::getDirtyRecord).collect(Collectors.toList());
  }

  /** Selects all rows in the table, without any conditions. */
  @Override
  public void selectAll() {
    selectAll((table, tableRow) -> true);
  }

  /**
   * Selects all rows in the table that meet the provided selection condition.
   *
   * @param selectionCondition the condition determining which rows should be selected
   * @return the current DataTable instance
   */
  public DataTable<T> selectAll(SelectionCondition<T> selectionCondition) {
    if (tableConfig.isMultiSelect() && !tableRows.isEmpty()) {
      for (TableRow<T> tableRow : tableRows) {
        if (selectionCondition.isAllowSelection(this, tableRow)) {
          withPauseSelectionListenersToggle(
              true,
              field -> {
                tableRow.select();
              });
        }
      }
      triggerSelectionListeners(null, getSelection());
      fireTableEvent(SelectAllEvent.of(true, selectionCondition));
    }
    return this;
  }

  /** Deselects all rows in the table, without any conditions. */
  @Override
  public void deselectAll() {
    deselectAll((table, tableRow) -> true);
  }

  /**
   * Deselects all rows in the table that meet the provided selection condition.
   *
   * @param selectionCondition the condition determining which rows should be deselected
   * @return the current DataTable instance
   */
  public DataTable<T> deselectAll(SelectionCondition<T> selectionCondition) {
    if (!tableRows.isEmpty()) {
      for (TableRow<T> tableRow : tableRows) {
        if (tableRow.isSelected()) {
          if (selectionCondition.isAllowSelection(this, tableRow)) {
            withPauseSelectionListenersToggle(
                true,
                field -> {
                  tableRow.deselect();
                });
          }
        }
      }
      triggerDeselectionListeners(null, new ArrayList<>());
      fireTableEvent(SelectAllEvent.of(false, selectionCondition));
    }
    return this;
  }

  /**
   * Determines if the table rows are selectable.
   *
   * @return true if selectable, false otherwise
   */
  @Override
  public boolean isSelectable() {
    return this.selectable;
  }

  /**
   * Pauses the execution of selection listeners.
   *
   * @return the current DataTable instance
   */
  @Override
  public DataTable<T> pauseSelectionListeners() {
    this.selectionListenersPaused = true;
    return this;
  }

  /**
   * Resumes the execution of selection listeners.
   *
   * @return the current DataTable instance
   */
  @Override
  public DataTable<T> resumeSelectionListeners() {
    this.selectionListenersPaused = false;
    return this;
  }

  /**
   * Toggles the pausing of selection listeners based on the provided value.
   *
   * @param toggle true to pause the listeners, false to resume
   * @return the current DataTable instance
   */
  @Override
  public DataTable<T> togglePauseSelectionListeners(boolean toggle) {
    this.selectionListenersPaused = toggle;
    return this;
  }

  /**
   * Retrieves the set of selection listeners.
   *
   * @return a set of selection listeners
   */
  @Override
  public Set<SelectionListener<? super TableRow<T>, ? super List<TableRow<T>>>>
      getSelectionListeners() {
    return this.selectionListeners;
  }

  /**
   * Retrieves the set of deselection listeners.
   *
   * @return a set of deselection listeners
   */
  @Override
  public Set<SelectionListener<? super TableRow<T>, ? super List<TableRow<T>>>>
      getDeselectionListeners() {
    return this.deselectionListeners;
  }

  /**
   * Determines if the selection listeners are currently paused.
   *
   * @return true if the listeners are paused, false otherwise
   */
  @Override
  public boolean isSelectionListenersPaused() {
    return this.selectionListenersPaused;
  }

  /**
   * Triggers the registered selection listeners.
   *
   * @param source the source TableRow that caused the selection change
   * @param selection the list of currently selected rows
   * @return the current DataTable instance
   */
  @Override
  public DataTable<T> triggerSelectionListeners(TableRow<T> source, List<TableRow<T>> selection) {
    if (!this.selectionListenersPaused) {
      this.selectionListeners.forEach(
          selectionListener ->
              selectionListener.onSelectionChanged(Optional.ofNullable(source), selection));
    }
    return this;
  }

  /**
   * Triggers the registered deselection listeners.
   *
   * @param source the source TableRow that caused the deselection
   * @param selection the list of currently selected rows
   * @return the current DataTable instance
   */
  @Override
  public DataTable<T> triggerDeselectionListeners(TableRow<T> source, List<TableRow<T>> selection) {
    if (!this.selectionListenersPaused) {
      this.deselectionListeners.forEach(
          selectionListener ->
              selectionListener.onSelectionChanged(Optional.ofNullable(source), selection));
    }
    return this;
  }

  /**
   * Retrieves the currently selected table rows.
   *
   * @return a list of selected table rows
   */
  @Override
  public List<TableRow<T>> getSelection() {
    return getSelectedItems();
  }

  /**
   * Registers a table event listener for the specified event type.
   *
   * @param type the event type
   * @param listener the listener to be added
   * @return the current DataTable instance
   */
  public DataTable<T> addTableEventListener(String type, TableEventListener listener) {
    if (!events.containsKey(type)) {
      events.put(type, new ArrayList<>());
    }
    events.get(type).add(listener);
    return this;
  }

  /**
   * Removes a registered table event listener for the specified event type.
   *
   * @param type the event type
   * @param listener the listener to be removed
   * @return the current DataTable instance
   */
  public DataTable<T> removeTableListener(String type, TableEventListener listener) {
    if (events.containsKey(type)) {
      events.get(type).remove(listener);
    }
    return this;
  }

  /**
   * Fires a specified table event.
   *
   * @param tableEvent the event to fire
   * @return the current DataTable instance
   */
  public DataTable<T> fireTableEvent(TableEvent tableEvent) {
    if (events.containsKey(tableEvent.getType())) {
      events.get(tableEvent.getType()).forEach(listener -> listener.handleEvent(tableEvent));
    }

    events.get(ANY).forEach(listener -> listener.handleEvent(tableEvent));
    return this;
  }

  /**
   * Retrieves the current search context.
   *
   * @return the current search context
   */
  public SearchContext<T> getSearchContext() {
    return searchContext;
  }

  /**
   * Sets the handler for removing records.
   *
   * @param removeRecordsHandler the handler to set
   * @return the current DataTable instance
   */
  public DataTable<T> setRemoveRecordsHandler(RemoveRowsHandler<T> removeRecordsHandler) {
    if (nonNull(removeRecordsHandler)) {
      this.removeRecordsHandler = removeRecordsHandler;
    }
    return this;
  }

  /**
   * Retrieves the dynamic style sheet associated with the DataTable.
   *
   * @return the dynamic style sheet
   */
  public DynamicStyleSheet<HTMLDivElement, DataTable<T>> getDynamicStyleSheet() {
    return dynamicStyleSheet;
  }

  /**
   * Appends a given node to the table. If a dynamic stylesheet is set, it will also append the
   * style element of that stylesheet to the root element.
   *
   * @param node the node to be appended
   * @return the current DataTable instance
   */
  @Override
  public DataTable<T> appendChild(Node node) {
    super.appendChild(node);
    if (nonNull(this.dynamicStyleSheet)) {
      this.root.appendChild(this.dynamicStyleSheet.getStyleElement());
    }
    return this;
  }

  /**
   * Appends a given text as a text node to the table. If a dynamic stylesheet is set, it will also
   * append the style element of that stylesheet to the root element.
   *
   * @param text the text to be appended as a text node
   * @return the current DataTable instance
   */
  @Override
  public DataTable<T> appendChild(String text) {
    super.appendChild(text);
    if (nonNull(this.dynamicStyleSheet)) {
      this.root.appendChild(this.dynamicStyleSheet.getStyleElement());
    }
    return this;
  }

  /**
   * Provides direct access to the table element to apply custom configurations.
   *
   * @param handler the handler that defines the operations to be performed on the table element
   * @return the current DataTable instance
   */
  public DataTable<T> withTable(ChildHandler<DataTable<T>, TableElement> handler) {
    handler.apply(this, tableElement);
    return this;
  }

  /**
   * Provides direct access to the table body element to apply custom configurations.
   *
   * @param handler the handler that defines the operations to be performed on the table body
   *     element
   * @return the current DataTable instance
   */
  public DataTable<T> withTableBody(ChildHandler<DataTable<T>, TBodyElement> handler) {
    handler.apply(this, tbody);
    return this;
  }

  /**
   * Provides direct access to the table footer element to apply custom configurations.
   *
   * @param handler the handler that defines the operations to be performed on the table footer
   *     element
   * @return the current DataTable instance
   */
  public DataTable<T> withTableFooter(ChildHandler<DataTable<T>, TFootElement> handler) {
    handler.apply(this, tfoot);
    return this;
  }

  /**
   * Provides direct access to the table head element to apply custom configurations.
   *
   * @param handler the handler that defines the operations to be performed on the table head
   *     element
   * @return the current DataTable instance
   */
  public DataTable<T> withTableHead(ChildHandler<DataTable<T>, THeadElement> handler) {
    handler.apply(this, thead);
    return this;
  }

  /**
   * Appends a given element to the table. If a dynamic stylesheet is set, it will also append the
   * style element of that stylesheet to the root element.
   *
   * @param isElement the element to be appended
   * @return the current DataTable instance
   */
  @Override
  public DataTable<T> appendChild(IsElement<?> isElement) {
    super.appendChild(isElement);
    if (nonNull(this.dynamicStyleSheet)) {
      this.root.appendChild(this.dynamicStyleSheet.getStyleElement());
    }
    return this;
  }

  /**
   * Represents a listener for selection changes in the table.
   *
   * @param <T> the type of data in the table
   */
  @FunctionalInterface
  public interface SelectionChangeListener<T> {
    /**
     * Invoked when the selection in the table changes.
     *
     * @param selectedTableRows the currently selected table rows
     * @param selectedRecords the records associated with the selected rows
     */
    void onSelectionChanged(List<TableRow<T>> selectedTableRows, List<T> selectedRecords);
  }

  /**
   * Represents a filter for local rows in the table.
   *
   * @param <T> the type of data in the table
   */
  public interface LocalRowFilter<T> {
    /**
     * Determines whether a table row should be filtered.
     *
     * @param tableRow the table row to evaluate
     * @return true if the row should be included in the filtered set, false otherwise
     */
    boolean filter(TableRow<T> tableRow);
  }

  /**
   * Represents a handler for removing rows from the table.
   *
   * @param <T> the type of data in the table
   */
  public interface RemoveRowsHandler<T> {
    /**
     * Handles the removal of rows from the table.
     *
     * @param table the table from which rows should be removed
     */
    void removeRows(DataTable<T> table);
  }
}
