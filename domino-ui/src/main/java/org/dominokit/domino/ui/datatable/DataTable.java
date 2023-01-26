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
import static org.dominokit.domino.ui.datatable.DataTableStyles.TABLE;
import static org.dominokit.domino.ui.datatable.DataTableStyles.TABLE_BORDERED;
import static org.dominokit.domino.ui.datatable.DataTableStyles.TABLE_CONDENSED;
import static org.dominokit.domino.ui.datatable.DataTableStyles.TABLE_HOVER;
import static org.dominokit.domino.ui.datatable.DataTableStyles.TABLE_RESPONSIVE;
import static org.dominokit.domino.ui.datatable.DataTableStyles.TABLE_ROW_FILTERED;
import static org.dominokit.domino.ui.datatable.DataTableStyles.TABLE_STRIPED;
import static org.jboss.elemento.Elements.*;

import elemental2.dom.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.dominokit.domino.ui.datatable.events.*;
import org.dominokit.domino.ui.datatable.model.SearchContext;
import org.dominokit.domino.ui.datatable.store.DataStore;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.DynamicStyleSheet;
import org.dominokit.domino.ui.utils.HasSelectionSupport;
import org.jboss.elemento.EventType;

/**
 * The data table component
 *
 * @param <T> the type of the data table records
 */
public class DataTable<T> extends BaseDominoElement<HTMLDivElement, DataTable<T>>
    implements HasSelectionSupport<TableRow<T>> {

  /** Use this constant to register a table event listener that listen to all events */
  public static final String ANY = "*";
  /** Use this constant as flag value to check if a row in the data tables have been filtered out */
  public static final String DATA_TABLE_ROW_FILTERED = "data-table-row-filtered";

  private static final String PARENT_SELECTOR_PREFIX = "dui-dt-";

  private final DataStore<T> dataStore;
  private DominoElement<HTMLDivElement> root = DominoElement.of(div()).css(TABLE_RESPONSIVE);
  private DominoElement<HTMLTableElement> tableElement =
      DominoElement.of(table()).css(TABLE, TABLE_HOVER, TABLE_STRIPED, "table-width-full");
  private TableConfig<T> tableConfig;
  private DominoElement<HTMLTableSectionElement> tbody = DominoElement.of(tbody());
  private DominoElement<HTMLTableSectionElement> thead = DominoElement.of(thead());
  private DominoElement<HTMLTableSectionElement> tfoot = DominoElement.of(tfoot());
  private List<T> data = new ArrayList<>();
  private boolean selectable = true;
  private List<TableRow<T>> tableRows = new ArrayList<>();

  private List<SelectionChangeListener<T>> selectionChangeListeners = new ArrayList<>();
  private boolean condensed = false;
  private boolean hoverable = true;
  private boolean striped = true;
  private boolean bordered = false;

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

  /**
   * Creates a new data table instance
   *
   * @param tableConfig the {@link TableConfig}
   * @param dataStore the {@link DataStore}
   */
  public DataTable(TableConfig<T> tableConfig, DataStore<T> dataStore) {
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
  }

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

  public DataStore<T> getDataStore() {
    return dataStore;
  }

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
    tableConfig.onBeforeHeaders(this);
    tableConfig.drawHeaders(this, thead);
    tableConfig.onAfterHeaders(this);
    tableElement.appendChild(tbody);
    tableConfig.getPlugins().forEach(plugin -> plugin.onBodyAdded(DataTable.this));
    tableElement.appendChild(tfoot);
    tableConfig.getPlugins().forEach(plugin -> plugin.onFooterAdded(DataTable.this));
    root.appendChild(tableElement);
    tableConfig.getPlugins().forEach(plugin -> plugin.onAfterAddTable(DataTable.this));
    if (!tableConfig.isLazyLoad()) {
      this.dataStore.load();
    }

    if (tableConfig.isFixed()) {
      tableElement.setMaxHeight(tableConfig.getFixedBodyHeight());
    }

    if (tableConfig.isFixed()) {
      tableElement.removeCss("table-width-full");
      root.addCss("table-fixed");
      ColumnUtils.fixElementWidth(this, tableElement.element());
    }

    if (tableConfig.isFixed()) {
      ColumnUtils.fixElementWidth(this, tableElement.element());
    }
    return this;
  }

  public DataTable<T> redraw() {
    tableConfig.onBeforeHeaders(this);
    tableConfig.drawHeaders(this, thead);
    tableConfig.onAfterHeaders(this);
    load();
    return this;
  }

  /**
   * Force loading the data into the table
   *
   * @return Same datatable instance
   */
  public DataTable<T> load() {
    this.dataStore.load();
    return this;
  }

  /**
   * Set the table data
   *
   * @param data {@link List} of T
   * @return Same datatable instance
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
   * Appends more records to the current data list of the table
   *
   * @param newData {@link List} of T
   * @return Same datatable instance
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

  /** @return the {@link Collection} of T that is the current data in the table */
  public Collection<T> getData() {
    return data;
  }

  /**
   * Increases the height of the data table rows
   *
   * @return same DataTable instance
   */
  public DataTable<T> uncondense() {
    tableElement.removeCss(TABLE_CONDENSED);
    this.condensed = false;
    return this;
  }

  /**
   * Decreases the height of the data table rows
   *
   * @return same DataTable instance
   */
  public DataTable<T> condense() {
    tableElement.addCss(TABLE_CONDENSED);
    this.condensed = true;
    return this;
  }

  /**
   * removes the hover effect from data table rows
   *
   * @return same DataTable instance
   */
  public DataTable<T> noHover() {
    tableElement.removeCss(TABLE_HOVER);
    this.hoverable = false;
    return this;
  }

  /**
   * Adds the hover effect to the data table rows
   *
   * @return same DataTable instance
   */
  public DataTable<T> hovered() {
    noHover();
    tableElement.addCss(TABLE_HOVER);
    this.hoverable = true;
    return this;
  }

  /**
   * Remove the borders from the data table rows
   *
   * @return same DataTable instance
   */
  public DataTable<T> noBorder() {
    tableElement.removeCss(TABLE_BORDERED);
    removeCss(TABLE_BORDERED);
    this.bordered = false;
    fireTableEvent(new TableBorderedEvent(false));
    return this;
  }

  /**
   * Adds borders from the data table rows
   *
   * @return same DataTable instance
   */
  public DataTable<T> bordered() {
    noBorder();
    tableElement.addCss(TABLE_BORDERED);
    addCss(TABLE_BORDERED);
    this.bordered = true;
    fireTableEvent(new TableBorderedEvent(true));
    return this;
  }

  /**
   * Remove the background alternation from the data table rows
   *
   * @return same DataTable instance
   */
  public DataTable<T> noStripes() {
    tableElement.removeCss(TABLE_STRIPED);
    this.striped = false;
    return this;
  }

  /**
   * Adds background alternation from the data table rows
   *
   * @return same DataTable instance
   */
  public DataTable<T> striped() {
    noStripes();
    tableElement.addCss(TABLE_STRIPED);
    this.striped = true;
    return this;
  }

  /**
   * Render all table rows in editable mode
   *
   * @return same DataTable instance
   */
  public DataTable<T> edit() {
    getRows().forEach(TableRow::edit);
    return this;
  }

  /**
   * Saves all editable table rows changes
   *
   * @return same DataTable instance
   */
  public DataTable<T> save() {
    getRows().forEach(TableRow::save);
    return this;
  }

  /**
   * Cancel editing of all table rows
   *
   * @return same DataTable instance
   */
  public DataTable<T> cancelEditing() {
    getRows().forEach(TableRow::cancelEditing);
    return this;
  }

  /** @return the {@link HTMLTableElement} wrapped as {@link DominoElement} */
  public DominoElement<HTMLTableElement> tableElement() {
    return tableElement;
  }

  /** @return the {@link HTMLTableSectionElement} -tbody- wrapped as {@link DominoElement} */
  public DominoElement<HTMLTableSectionElement> bodyElement() {
    return tbody;
  }

  /** @return the {@link HTMLTableSectionElement} -thead- wrapped as {@link DominoElement} */
  public DominoElement<HTMLTableSectionElement> headerElement() {
    return thead;
  }

  /** @return the {@link HTMLTableSectionElement} -tfoot- wrapped as {@link DominoElement} */
  public DominoElement<HTMLTableSectionElement> footerElement() {
    return tfoot;
  }

  /** @return the applied {@link TableConfig} of this table */
  public TableConfig<T> getTableConfig() {
    return tableConfig;
  }

  /** @return boolean */
  public boolean isCondensed() {
    return condensed;
  }

  /** @return boolean */
  public boolean isHoverable() {
    return hoverable;
  }

  /** @return boolean */
  public boolean isStriped() {
    return striped;
  }

  /** @return boolean */
  public boolean isBordered() {
    return bordered;
  }

  /**
   * Immediately filter the current table rows using the the specified filter
   *
   * @param rowFilter {@link LocalRowFilter}
   * @return Same datatable instance
   */
  public DataTable<T> filterRows(LocalRowFilter<T> rowFilter) {
    tableRows.forEach(
        tableRow -> {
          if (rowFilter.filter(tableRow)) {
            tableRow.removeCss(TABLE_ROW_FILTERED);
            tableRow.removeFlag(DATA_TABLE_ROW_FILTERED);
            tableRow.fireUpdate();
          } else {
            tableRow.addCss(TABLE_ROW_FILTERED);
            tableRow.setFlag(DATA_TABLE_ROW_FILTERED, "true");
            tableRow.deselect();
            tableRow.fireUpdate();
          }
        });
    return this;
  }

  /**
   * Clear all filtration applied using {@link #filterRows(LocalRowFilter)}
   *
   * @return Same datatable instance
   */
  public DataTable<T> clearRowFilters() {
    tableRows.stream()
        .filter(tableRow -> nonNull(tableRow.getFlag(DATA_TABLE_ROW_FILTERED)))
        .forEach(
            tableRow -> {
              tableRow.removeCss(TABLE_ROW_FILTERED);
              tableRow.removeFlag(DATA_TABLE_ROW_FILTERED);
              tableRow.fireUpdate();
            });
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }

  /** @return */
  @Override
  public List<TableRow<T>> getSelectedItems() {
    return tableRows.stream().filter(TableRow::isSelected).collect(Collectors.toList());
  }

  /** @return a {@link List} of the currently selected records including a row selected children */
  public List<T> getSelectedRecords() {
    return tableRows.stream()
        .filter(TableRow::isSelected)
        .map(TableRow::getRecord)
        .collect(Collectors.toList());
  }

  /** @return a {@link List} of {@link TableRow}s including the child rows */
  @Override
  @Deprecated
  public List<TableRow<T>> getItems() {
    return getRows();
  }

  /** @return a {@link List} of {@link TableRow}s including the child rows */
  @Override
  public List<TableRow<T>> getRows() {
    return tableRows;
  }

  public List<TableRow<T>> getRootRows() {
    return getRows().stream().filter(TableRow::isRoot).collect(Collectors.toList());
  }

  /** @return a {@link List} of {@link TableRow}s excluding the child rows */
  public List<T> getRecords() {
    return getRows().stream()
        .filter(TableRow::isRoot)
        .map(TableRow::getRecord)
        .collect(Collectors.toList());
  }

  /** @return a {@link List} of {@link TableRow}s that are being edited and still not saved */
  public List<T> getDirtyRecords() {
    return getRows().stream().map(TableRow::getDirtyRecord).collect(Collectors.toList());
  }

  @Override
  public void onSelectionChange(TableRow<T> source) {
    selectionChangeListeners.forEach(
        selectionChangeListener ->
            selectionChangeListener.onSelectionChanged(getSelectedItems(), getSelectedRecords()));
  }

  /** Select all table rows */
  @Override
  public void selectAll() {
    selectAll((table, tableRow) -> true);
  }

  /**
   * Select all table rows that match a condition
   *
   * @return Same datatable instance
   */
  public DataTable<T> selectAll(SelectionCondition<T> selectionCondition) {
    if (tableConfig.isMultiSelect() && !tableRows.isEmpty()) {
      for (TableRow<T> tableRow : tableRows) {
        if (selectionCondition.isAllowSelection(this, tableRow)) {
          tableRow.select();
        }
      }
      onSelectionChange(tableRows.get(0));
      fireTableEvent(SelectAllEvent.of(true, selectionCondition));
    }
    return this;
  }

  /** Deselect all table rows */
  @Override
  public void deselectAll() {
    deselectAll((table, tableRow) -> true);
  }

  /**
   * Deselect all table rows that match a condition
   *
   * @return Same datatable instance
   */
  public DataTable<T> deselectAll(SelectionCondition<T> selectionCondition) {
    if (!tableRows.isEmpty()) {
      for (TableRow<T> tableRow : tableRows) {
        if (tableRow.isSelected()) {
          if (selectionCondition.isAllowSelection(this, tableRow)) {
            tableRow.deselect();
          }
        }
      }
      onSelectionChange(tableRows.get(0));
      fireTableEvent(SelectAllEvent.of(false, selectionCondition));
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isSelectable() {
    return this.selectable;
  }

  /**
   * Add a listener to listen to data table selection changes
   *
   * @param selectionChangeListener {@link SelectionChangeListener}
   * @return Same datatable instance
   */
  public DataTable<T> addSelectionListener(SelectionChangeListener<T> selectionChangeListener) {
    this.selectionChangeListeners.add(selectionChangeListener);
    return this;
  }

  /**
   * @param selectionChangeListener {@link SelectionChangeListener}
   * @return Same datatable instance
   */
  public DataTable<T> removeSelectionListener(SelectionChangeListener<T> selectionChangeListener) {
    this.selectionChangeListeners.remove(selectionChangeListener);
    return this;
  }

  /** @deprecated use {@link #addTableEventListener(String, TableEventListener)} */
  @Deprecated
  public void addTableEventListner(String type, TableEventListener listener) {
    addTableEventListener(type, listener);
  }

  /**
   * Adds a table event listener by event type
   *
   * @param type String type of the event
   * @param listener {@link TableEventListener}
   * @return Same datatable instance
   */
  public DataTable<T> addTableEventListener(String type, TableEventListener listener) {
    if (!events.containsKey(type)) {
      events.put(type, new ArrayList<>());
    }
    events.get(type).add(listener);
    return this;
  }

  /**
   * Removes a table event listener by event type
   *
   * @param type String type of the event
   * @param listener {@link TableEventListener}
   * @return Same datatable instance
   */
  public DataTable<T> removeTableListener(String type, TableEventListener listener) {
    if (events.containsKey(type)) {
      events.get(type).remove(listener);
    }
    return this;
  }

  /**
   * Manually fire a table event
   *
   * @param tableEvent {@link TableEvent}
   * @return Same datatable instance
   */
  public DataTable<T> fireTableEvent(TableEvent tableEvent) {
    if (events.containsKey(tableEvent.getType())) {
      events.get(tableEvent.getType()).forEach(listener -> listener.handleEvent(tableEvent));
    }

    events.get(ANY).forEach(listener -> listener.handleEvent(tableEvent));
    return this;
  }

  /** @return the current {@link SearchContext} of the data table */
  public SearchContext<T> getSearchContext() {
    return searchContext;
  }

  public DataTable<T> setRemoveRecordsHandler(RemoveRowsHandler<T> removeRecordsHandler) {
    if (nonNull(removeRecordsHandler)) {
      this.removeRecordsHandler = removeRecordsHandler;
    }
    return this;
  }

  public DynamicStyleSheet<HTMLDivElement, DataTable<T>> getDynamicStyleSheet() {
    return dynamicStyleSheet;
  }

  /**
   * Listens to changes in the table rows selection
   *
   * @param <T> the type of the data table records
   */
  @FunctionalInterface
  public interface SelectionChangeListener<T> {
    /**
     * @param selectedTableRows {@link List} of {@link TableRow}s that has that are selected
     * @param selectedRecords {@link List} of T records of the rows being selected
     */
    void onSelectionChanged(List<TableRow<T>> selectedTableRows, List<T> selectedRecords);
  }

  /**
   * Use implement Table row filter
   *
   * @param <T> the type of the data table records
   */
  public interface LocalRowFilter<T> {
    /**
     * @param tableRow {@link TableRow}
     * @return boolean, true if the table row should be hidden else false.
     */
    boolean filter(TableRow<T> tableRow);
  }

  public interface RemoveRowsHandler<T> {
    void removeRows(DataTable<T> table);
  }
}
