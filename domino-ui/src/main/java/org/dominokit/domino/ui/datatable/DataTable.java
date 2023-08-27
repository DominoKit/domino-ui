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

import elemental2.dom.*;
import elemental2.dom.EventListener;
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
 * The data table component
 *
 * @param <T> the type of the data table records
 */
public class DataTable<T> extends BaseDominoElement<HTMLDivElement, DataTable<T>>
    implements HasSelectionSupport<TableRow<T>>,
        HasSelectionListeners<DataTable<T>, TableRow<T>, List<TableRow<T>>>,
        DataTableStyles {

  /** Use this constant to register a table event listener that listen to all events */
  public static final String ANY = "*";
  /** Use this constant as flag value to check if a row in the data tables have been filtered out */
  public static final String DATA_TABLE_ROW_FILTERED = "data-table-row-filtered";

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
   * Creates a new data table instance
   *
   * @param tableConfig the {@link org.dominokit.domino.ui.datatable.TableConfig}
   * @param dataStore the {@link org.dominokit.domino.ui.datatable.store.DataStore}
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
   * Getter for the field <code>dataStore</code>.
   *
   * @return a {@link org.dominokit.domino.ui.datatable.store.DataStore} object
   */
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
   * redraw.
   *
   * @return a {@link org.dominokit.domino.ui.datatable.DataTable} object
   */
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
   * @param data {@link java.util.List} of T
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
   * @param newData {@link java.util.List} of T
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
  /**
   * Getter for the field <code>data</code>.
   *
   * @return a {@link java.util.Collection} object
   */
  public Collection<T> getData() {
    return data;
  }

  /**
   * setCondensed.
   *
   * @param condensed a boolean
   * @return a {@link org.dominokit.domino.ui.datatable.DataTable} object
   */
  public DataTable<T> setCondensed(boolean condensed) {
    this.addCss(BooleanCssClass.of(dui_datatable_condensed, condensed));
    return this;
  }

  /**
   * isCondensed.
   *
   * @return a boolean
   */
  public boolean isCondensed() {
    return dui_datatable_condensed.isAppliedTo(this);
  }

  /**
   * setHover.
   *
   * @param hover a boolean
   * @return a {@link org.dominokit.domino.ui.datatable.DataTable} object
   */
  public DataTable<T> setHover(boolean hover) {
    this.addCss(BooleanCssClass.of(dui_datatable_hover, hover));
    return this;
  }

  /**
   * isHover.
   *
   * @return a boolean
   */
  public boolean isHover() {
    return dui_datatable_hover.isAppliedTo(this);
  }

  /**
   * setBordered.
   *
   * @param bordered a boolean
   * @return a {@link org.dominokit.domino.ui.datatable.DataTable} object
   */
  public DataTable<T> setBordered(boolean bordered) {
    this.addCss(BooleanCssClass.of(dui_datatable_bordered, bordered));
    return this;
  }

  /**
   * isBordered.
   *
   * @return a boolean
   */
  public boolean isBordered() {
    return dui_datatable_bordered.isAppliedTo(this);
  }

  /**
   * setStriped.
   *
   * @param striped a boolean
   * @return a {@link org.dominokit.domino.ui.datatable.DataTable} object
   */
  public DataTable<T> setStriped(boolean striped) {
    this.addCss(BooleanCssClass.of(dui_datatable_striped, striped));
    return this;
  }

  /**
   * isStriped.
   *
   * @return a boolean
   */
  public boolean isStriped() {
    return dui_datatable_striped.isAppliedTo(this);
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
  /**
   * tableElement.
   *
   * @return a {@link org.dominokit.domino.ui.elements.TableElement} object
   */
  public TableElement tableElement() {
    return tableElement;
  }

  /** @return the {@link HTMLTableSectionElement} -tbody- wrapped as {@link DominoElement} */
  /**
   * bodyElement.
   *
   * @return a {@link org.dominokit.domino.ui.elements.TBodyElement} object
   */
  public TBodyElement bodyElement() {
    return tbody;
  }

  /** @return the {@link HTMLTableSectionElement} -thead- wrapped as {@link DominoElement} */
  /**
   * headerElement.
   *
   * @return a {@link org.dominokit.domino.ui.elements.THeadElement} object
   */
  public THeadElement headerElement() {
    return thead;
  }

  /** @return the {@link HTMLTableSectionElement} -tfoot- wrapped as {@link DominoElement} */
  /**
   * footerElement.
   *
   * @return a {@link org.dominokit.domino.ui.elements.TFootElement} object
   */
  public TFootElement footerElement() {
    return tfoot;
  }

  /** @return the applied {@link TableConfig} of this table */
  /**
   * Getter for the field <code>tableConfig</code>.
   *
   * @return a {@link org.dominokit.domino.ui.datatable.TableConfig} object
   */
  public TableConfig<T> getTableConfig() {
    return tableConfig;
  }

  /**
   * Immediately filter the current table rows using the the specified filter
   *
   * @param rowFilter {@link org.dominokit.domino.ui.datatable.DataTable.LocalRowFilter}
   * @return Same datatable instance
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
   * Clear all filtration applied using {@link #filterRows(LocalRowFilter)}
   *
   * @return Same datatable instance
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

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }

  /** @return */
  /** {@inheritDoc} */
  @Override
  public List<TableRow<T>> getSelectedItems() {
    return tableRows.stream().filter(TableRow::isSelected).collect(Collectors.toList());
  }

  /** @return a {@link List} of the currently selected records including a row selected children */
  /**
   * getSelectedRecords.
   *
   * @return a {@link java.util.List} object
   */
  public List<T> getSelectedRecords() {
    return tableRows.stream()
        .filter(TableRow::isSelected)
        .map(TableRow::getRecord)
        .collect(Collectors.toList());
  }

  /** @return a {@link List} of {@link TableRow}s including the child rows */
  /** {@inheritDoc} */
  @Override
  public List<TableRow<T>> getRows() {
    return tableRows;
  }

  /**
   * getRootRows.
   *
   * @return a {@link java.util.List} object
   */
  public List<TableRow<T>> getRootRows() {
    return getRows().stream().filter(TableRow::isRoot).collect(Collectors.toList());
  }

  /** @return a {@link List} of {@link TableRow}s excluding the child rows */
  /**
   * getRecords.
   *
   * @return a {@link java.util.List} object
   */
  public List<T> getRecords() {
    return getRows().stream()
        .filter(TableRow::isRoot)
        .map(TableRow::getRecord)
        .collect(Collectors.toList());
  }

  /** @return a {@link List} of {@link TableRow}s that are being edited and still not saved */
  /**
   * getDirtyRecords.
   *
   * @return a {@link java.util.List} object
   */
  public List<T> getDirtyRecords() {
    return getRows().stream().map(TableRow::getDirtyRecord).collect(Collectors.toList());
  }

  /**
   * {@inheritDoc}
   *
   * <p>Select all table rows
   */
  @Override
  public void selectAll() {
    selectAll((table, tableRow) -> true);
  }

  /**
   * Select all table rows that match a condition
   *
   * @return Same datatable instance
   * @param selectionCondition a {@link org.dominokit.domino.ui.datatable.SelectionCondition} object
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

  /**
   * {@inheritDoc}
   *
   * <p>Deselect all table rows
   */
  @Override
  public void deselectAll() {
    deselectAll((table, tableRow) -> true);
  }

  /**
   * Deselect all table rows that match a condition
   *
   * @return Same datatable instance
   * @param selectionCondition a {@link org.dominokit.domino.ui.datatable.SelectionCondition} object
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

  /** {@inheritDoc} */
  @Override
  public boolean isSelectable() {
    return this.selectable;
  }

  /** {@inheritDoc} */
  @Override
  public DataTable<T> pauseSelectionListeners() {
    this.selectionListenersPaused = true;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public DataTable<T> resumeSelectionListeners() {
    this.selectionListenersPaused = false;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public DataTable<T> togglePauseSelectionListeners(boolean toggle) {
    this.selectionListenersPaused = toggle;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Set<SelectionListener<? super TableRow<T>, ? super List<TableRow<T>>>>
      getSelectionListeners() {
    return this.selectionListeners;
  }

  /** {@inheritDoc} */
  @Override
  public Set<SelectionListener<? super TableRow<T>, ? super List<TableRow<T>>>>
      getDeselectionListeners() {
    return this.deselectionListeners;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isSelectionListenersPaused() {
    return this.selectionListenersPaused;
  }

  /** {@inheritDoc} */
  @Override
  public DataTable<T> triggerSelectionListeners(TableRow<T> source, List<TableRow<T>> selection) {
    if (!this.selectionListenersPaused) {
      this.selectionListeners.forEach(
          selectionListener ->
              selectionListener.onSelectionChanged(Optional.ofNullable(source), selection));
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public DataTable<T> triggerDeselectionListeners(TableRow<T> source, List<TableRow<T>> selection) {
    if (!this.selectionListenersPaused) {
      this.deselectionListeners.forEach(
          selectionListener ->
              selectionListener.onSelectionChanged(Optional.ofNullable(source), selection));
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public List<TableRow<T>> getSelection() {
    return getSelectedItems();
  }

  /**
   * Adds a table event listener by event type
   *
   * @param type String type of the event
   * @param listener {@link org.dominokit.domino.ui.datatable.events.TableEventListener}
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
   * @param listener {@link org.dominokit.domino.ui.datatable.events.TableEventListener}
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
   * @param tableEvent {@link org.dominokit.domino.ui.datatable.events.TableEvent}
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
  /**
   * Getter for the field <code>searchContext</code>.
   *
   * @return a {@link org.dominokit.domino.ui.datatable.model.SearchContext} object
   */
  public SearchContext<T> getSearchContext() {
    return searchContext;
  }

  /**
   * Setter for the field <code>removeRecordsHandler</code>.
   *
   * @param removeRecordsHandler a {@link
   *     org.dominokit.domino.ui.datatable.DataTable.RemoveRowsHandler} object
   * @return a {@link org.dominokit.domino.ui.datatable.DataTable} object
   */
  public DataTable<T> setRemoveRecordsHandler(RemoveRowsHandler<T> removeRecordsHandler) {
    if (nonNull(removeRecordsHandler)) {
      this.removeRecordsHandler = removeRecordsHandler;
    }
    return this;
  }

  /**
   * Getter for the field <code>dynamicStyleSheet</code>.
   *
   * @return a {@link org.dominokit.domino.ui.utils.DynamicStyleSheet} object
   */
  public DynamicStyleSheet<HTMLDivElement, DataTable<T>> getDynamicStyleSheet() {
    return dynamicStyleSheet;
  }

  /** {@inheritDoc} */
  @Override
  public DataTable<T> appendChild(Node node) {
    super.appendChild(node);
    if (nonNull(this.dynamicStyleSheet)) {
      this.root.appendChild(this.dynamicStyleSheet.getStyleElement());
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public DataTable<T> appendChild(String text) {
    super.appendChild(text);
    if (nonNull(this.dynamicStyleSheet)) {
      this.root.appendChild(this.dynamicStyleSheet.getStyleElement());
    }
    return this;
  }

  public DataTable<T> withTable(ChildHandler<DataTable<T>, TableElement> handler) {
    handler.apply(this, tableElement);
    return this;
  }

  public DataTable<T> withTableBody(ChildHandler<DataTable<T>, TBodyElement> handler) {
    handler.apply(this, tbody);
    return this;
  }

  public DataTable<T> withTableFooter(ChildHandler<DataTable<T>, TFootElement> handler) {
    handler.apply(this, tfoot);
    return this;
  }

  public DataTable<T> withTableHead(ChildHandler<DataTable<T>, THeadElement> handler) {
    handler.apply(this, thead);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public DataTable<T> appendChild(IsElement<?> isElement) {
    super.appendChild(isElement);
    if (nonNull(this.dynamicStyleSheet)) {
      this.root.appendChild(this.dynamicStyleSheet.getStyleElement());
    }
    return this;
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
