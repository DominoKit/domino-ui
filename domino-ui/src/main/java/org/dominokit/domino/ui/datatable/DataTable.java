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
import static org.dominokit.domino.ui.datatable.DataTableStyles.*;
import static org.dominokit.domino.ui.style.Unit.*;
import static org.jboss.elemento.Elements.*;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLTableElement;
import elemental2.dom.HTMLTableSectionElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.dominokit.domino.ui.datatable.events.*;
import org.dominokit.domino.ui.datatable.model.SearchContext;
import org.dominokit.domino.ui.datatable.store.DataStore;
import org.dominokit.domino.ui.style.Unit;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
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

  private final DataStore<T> dataStore;
  private DominoElement<HTMLDivElement> root = DominoElement.of(div().css(TABLE_RESPONSIVE));
  private DominoElement<HTMLTableElement> tableElement =
      DominoElement.of(table().css(TABLE, TABLE_HOVER, TABLE_STRIPED));
  private TableConfig<T> tableConfig;
  private DominoElement<HTMLTableSectionElement> tbody = DominoElement.of(tbody());
  private DominoElement<HTMLTableSectionElement> thead = DominoElement.of(thead());
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

  private double scrollBarWidth = -1;

  /**
   * Creates a new data table instance
   *
   * @param tableConfig the {@link TableConfig}
   * @param dataStore the {@link DataStore}
   */
  public DataTable(TableConfig<T> tableConfig, DataStore<T> dataStore) {
    this.tableConfig = tableConfig;
    this.events.put(ANY, new ArrayList<>());
    this.dataStore = dataStore;
    this.addTableEventListener(ANY, dataStore);
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

    init();
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
    tableConfig.onBeforeHeaders(this);
    tableConfig.drawHeaders(this, thead);
    tableConfig.onAfterHeaders(this);
    tableElement.appendChild(tbody);
    tableConfig.getPlugins().forEach(plugin -> plugin.onBodyAdded(DataTable.this));
    root.appendChild(tableElement);
    tableConfig.getPlugins().forEach(plugin -> plugin.onAfterAddTable(DataTable.this));
    if (!tableConfig.isLazyLoad()) {
      this.dataStore.load();
    }
    if (tableConfig.isFixed()) {
      root.style().add(TABLE_FIXED);
      thead.style().add(THEAD_FIXED);
      tbody.style().add(TBODY_FIXED).setMaxHeight(tableConfig.getFixedBodyHeight());
      tableElement.addEventListener(EventType.scroll, e -> updateTableWidth());
      DomGlobal.window.addEventListener(EventType.resize.getName(), e -> updateTableWidth());
    }
    super.init(this);

    onResize(
        (target, observer, entries) -> {
          DomGlobal.requestAnimationFrame(
              timestamp -> {
                if (isNull(entries) || entries.length <= 0) {
                  return;
                }
                updateTableWidth();
              });
        });

    return this;
  }

  private void updateTableWidth() {
    final long w =
        tableElement.element().offsetWidth + Math.round(tableElement.element().scrollLeft);
    thead.setWidth(px.of(w));
    tbody.setWidth(px.of(w));
    if (tableConfig.isFixed()) {
      updateHeadWidth(false);
    }
  }

  /** Force loading the data into the table */
  public void load() {
    this.dataStore.load();
  }

  /**
   * Set the table data
   *
   * @param data {@link List} of T
   */
  public void setData(List<T> data) {
    this.data = data;
    tableRows.clear();
    tbody.clearElement();
    if (nonNull(data) && !data.isEmpty()) {
      addRows(data, 0);
    }

    updateHeadWidth(true);
  }

  private void updateHeadWidth(boolean scrollTop) {
    if (hasVScrollBar()) {
      if (scrollTop) {
        tbody.element().scrollTop = 0.0;
      }
      if (tableConfig.isFixed()) {
        thead.setWidth(Unit.px.of(tbody.element().offsetWidth - getScrollWidth() - 2));
        tbody.setWidth(Unit.px.of(tbody.element().offsetWidth - 2));
      }
    }
  }

  private boolean hasVScrollBar() {
    if (tbody.element().scrollTop > 0) {
      return true;
    }
    tbody.element().scrollTop = 1.0;
    double scrollTop = tbody.element().scrollTop;
    return scrollTop > 0.0;
  }

  private double getScrollWidth() {
    if (scrollBarWidth == -1) {
      DominoElement<HTMLDivElement> outer =
          DominoElement.div()
              .setTop("-1000px")
              .setLeft("-1000px")
              .setWidth("100px")
              .setHeight("50px")
              .setOverFlow("hidden")
              .setProperty("-ms-overflow-style", "hidden");

      DominoElement<HTMLDivElement> inner = DominoElement.div().setHeight("200px");

      outer.appendChild(inner);
      DominoElement.body().appendChild(outer);
      double noScrollWidth = inner.element().offsetWidth;
      outer.setOverFlow("auto").setProperty("-ms-overflow-style", "scrollbar");
      double widthWithScroll = inner.element().clientWidth;
      outer.remove();
      scrollBarWidth = noScrollWidth - widthWithScroll;
    }

    return scrollBarWidth;
  }

  /**
   * Appends more records to the current data list of the table
   *
   * @param newData {@link List} of T
   */
  public void appendData(List<T> newData) {
    if (nonNull(this.data)) {
      addRows(newData, this.data.size());
      this.data.addAll(newData);
    } else {
      setData(newData);
    }
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
    tableElement.style().remove(TABLE_CONDENSED);
    this.condensed = false;
    return this;
  }

  /**
   * Decreases the height of the data table rows
   *
   * @return same DataTable instance
   */
  public DataTable<T> condense() {
    tableElement.style().add(TABLE_CONDENSED);
    this.condensed = true;
    return this;
  }

  /**
   * removes the hover effect from data table rows
   *
   * @return same DataTable instance
   */
  public DataTable<T> noHover() {
    tableElement.style().remove(TABLE_HOVER);
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
    tableElement.style().add(TABLE_HOVER);
    this.hoverable = true;
    return this;
  }

  /**
   * Remove the borders from the data table rows
   *
   * @return same DataTable instance
   */
  public DataTable<T> noBorder() {
    tableElement.style().remove(TABLE_BORDERED);
    this.bordered = false;
    return this;
  }

  /**
   * Adds borders from the data table rows
   *
   * @return same DataTable instance
   */
  public DataTable<T> bordered() {
    noBorder();
    tableElement.style().add(TABLE_BORDERED);
    this.bordered = true;
    return this;
  }

  /**
   * Remove the background alternation from the data table rows
   *
   * @return same DataTable instance
   */
  public DataTable<T> noStripes() {
    tableElement.style().remove(TABLE_STRIPED);
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
    tableElement.style().add(TABLE_STRIPED);
    this.striped = true;
    return this;
  }

  /**
   * Render all table rows in editable mode
   *
   * @return same DataTable instance
   */
  public DataTable<T> edit() {
    getItems().forEach(TableRow::edit);
    return this;
  }

  /**
   * Saves all editable table rows changes
   *
   * @return same DataTable instance
   */
  public DataTable<T> save() {
    getItems().forEach(TableRow::save);
    return this;
  }

  /**
   * Cancel editing of all table rows
   *
   * @return same DataTable instance
   */
  public DataTable<T> cancelEditing() {
    getItems().forEach(TableRow::cancelEditing);
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
   */
  public void filterRows(LocalRowFilter<T> rowFilter) {
    tableRows.forEach(
        tableRow -> {
          if (rowFilter.filter(tableRow)) {
            tableRow.style().remove(TABLE_ROW_FILTERED);
            tableRow.removeFlag(DATA_TABLE_ROW_FILTERED);
            tableRow.fireUpdate();
          } else {
            tableRow.style().add(TABLE_ROW_FILTERED);
            tableRow.setFlag(DATA_TABLE_ROW_FILTERED, "true");
            tableRow.deselect();
            tableRow.fireUpdate();
          }
        });
  }

  /** Clear all filtration applied using {@link #filterRows(LocalRowFilter)} */
  public void clearRowFilters() {
    tableRows.stream()
        .filter(tableRow -> nonNull(tableRow.getFlag(DATA_TABLE_ROW_FILTERED)))
        .forEach(
            tableRow -> {
              tableRow.style().remove(TABLE_ROW_FILTERED);
              tableRow.removeFlag(DATA_TABLE_ROW_FILTERED);
              tableRow.fireUpdate();
            });
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

  public List<T> getSelectedRecords() {
    return getSelectedItems().stream().map(TableRow::getRecord).collect(Collectors.toList());
  }

  @Override
  public List<TableRow<T>> getItems() {
    return tableRows;
  }

  public List<T> getRecords() {
    return getItems().stream().map(TableRow::getRecord).collect(Collectors.toList());
  }

  public List<T> getDirtyRecords() {
    return getItems().stream().map(TableRow::getDirtyRecord).collect(Collectors.toList());
  }

  @Override
  public void onSelectionChange(TableRow<T> source) {
    selectionChangeListeners.forEach(
        selectionChangeListener ->
            selectionChangeListener.onSelectionChanged(getSelectedItems(), getSelectedRecords()));
  }

  @Override
  public void selectAll() {
    selectAll((table, tableRow) -> true);
  }

  public void selectAll(SelectionCondition<T> selectionCondition) {
    if (tableConfig.isMultiSelect() && !tableRows.isEmpty()) {
      for (TableRow<T> tableRow : tableRows) {
        if (selectionCondition.isAllowSelection(this, tableRow)) {
          tableRow.select();
        }
      }
      onSelectionChange(tableRows.get(0));
    }
  }

  @Override
  public void deselectAll() {
    deselectAll((table, tableRow) -> true);
  }

  public void deselectAll(SelectionCondition<T> selectionCondition) {
    if (!tableRows.isEmpty()) {
      for (TableRow<T> tableRow : tableRows) {
        if (tableRow.isSelected()) {
          if (selectionCondition.isAllowSelection(this, tableRow)) {
            tableRow.deselect();
          }
        }
      }
      onSelectionChange(tableRows.get(0));
    }
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
   */
  public void addSelectionListener(SelectionChangeListener<T> selectionChangeListener) {
    this.selectionChangeListeners.add(selectionChangeListener);
  }

  /** @param selectionChangeListener {@link SelectionChangeListener} */
  public void removeSelectionListener(SelectionChangeListener<T> selectionChangeListener) {
    this.selectionChangeListeners.remove(selectionChangeListener);
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
   */
  public void addTableEventListener(String type, TableEventListener listener) {
    if (!events.containsKey(type)) {
      events.put(type, new ArrayList<>());
    }
    events.get(type).add(listener);
  }

  /**
   * Removes a table event listener by event type
   *
   * @param type String type of the event
   * @param listener {@link TableEventListener}
   */
  public void removeTableListener(String type, TableEventListener listener) {
    if (events.containsKey(type)) {
      events.get(type).remove(listener);
    }
  }

  /**
   * Manually fire a table event
   *
   * @param tableEvent {@link TableEvent}
   */
  public void fireTableEvent(TableEvent tableEvent) {
    if (events.containsKey(tableEvent.getType())) {
      events.get(tableEvent.getType()).forEach(listener -> listener.handleEvent(tableEvent));
    }

    events.get(ANY).forEach(listener -> listener.handleEvent(tableEvent));
  }

  /** @return the current {@link SearchContext} of the data table */
  public SearchContext getSearchContext() {
    return searchContext;
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
}
