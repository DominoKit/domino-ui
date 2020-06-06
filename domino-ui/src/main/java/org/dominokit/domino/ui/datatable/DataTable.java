package org.dominokit.domino.ui.datatable;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLTableElement;
import elemental2.dom.HTMLTableSectionElement;
import org.dominokit.domino.ui.datatable.events.*;
import org.dominokit.domino.ui.datatable.model.SearchContext;
import org.dominokit.domino.ui.datatable.store.DataStore;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasSelectionSupport;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.datatable.DataTableStyles.*;
import static org.jboss.elemento.Elements.*;

public class DataTable<T> extends BaseDominoElement<HTMLDivElement, DataTable<T>> implements HasSelectionSupport<TableRow<T>> {

    public static final String ANY = "*";
    public static final String DATA_TABLE_ROW_FILTERED = "data-table-row-filtered";

    private final DataStore<T> dataStore;
    private DominoElement<HTMLDivElement> root = DominoElement.of(div().css(TABLE_RESPONSIVE));
    private DominoElement<HTMLTableElement> tableElement = DominoElement.of(table().css(TABLE, TABLE_HOVER, TABLE_STRIPED));
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

    public DataTable(TableConfig<T> tableConfig, DataStore<T> dataStore) {
        this.tableConfig = tableConfig;
        this.events.put(ANY, new ArrayList<>());
        this.dataStore = dataStore;
        this.addTableEventListner(ANY, dataStore);
        this.dataStore.onDataChanged(dataChangedEvent -> {
            fireTableEvent(new OnBeforeDataChangeEvent<>(this.data, dataChangedEvent.getTotalCount(), dataChangedEvent.isAppend()));
            if(dataChangedEvent.getSortDir().isPresent() && dataChangedEvent.getSortColumn().isPresent()){
                fireTableEvent(new DataSortEvent(dataChangedEvent.getSortDir().get(), dataChangedEvent.getSortColumn().get()));
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
        tableConfig.getPlugins().forEach(plugin -> {
            DataTable.this.addTableEventListner("*", plugin);
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
            tbody.style()
                    .add(TBODY_FIXED)
                    .setMaxHeight(tableConfig.getFixedBodyHeight());
        }
        super.init(this);
        return this;
    }

    public void load() {
        this.dataStore.load();
    }

    public void setData(List<T> data) {
        this.data = data;
        tableRows.clear();
        tbody.clearElement();
        if (nonNull(data) && !data.isEmpty()) {
            addRows(data, 0);
        }

        tbody.element().scrollTop = 0.0;
    }

    public void appendData(List<T> newData) {
        if (nonNull(this.data)) {
            addRows(newData, this.data.size());
            this.data.addAll(newData);
        } else {
            setData(newData);
        }
    }

    private void addRows(List<T> data, int initialIndex) {
        tableConfig.getColumns()
                .forEach(ColumnConfig::clearShowHideListners);

        for (int index = 0; index < data.size(); index++) {
            TableRow<T> tableRow = new TableRow<>(data.get(index), initialIndex + index, this);
            tableConfig.getPlugins().forEach(plugin -> plugin.onBeforeAddRow(DataTable.this, tableRow));
            tableConfig.drawRecord(DataTable.this, tableRow);
            tableRows.add(tableRow);
        }

        tableConfig.getPlugins().forEach(plugin -> plugin.onAllRowsAdded(DataTable.this));
    }

    public Collection<T> getData() {
        return data;
    }

    public DataTable<T> uncondense() {
        tableElement.style().remove(TABLE_CONDENSED);
        this.condensed = false;
        return this;
    }

    public DataTable<T> condense() {
        tableElement.style().add(TABLE_CONDENSED);
        this.condensed = true;
        return this;
    }

    public DataTable<T> noHover() {
        tableElement.style().remove(TABLE_HOVER);
        this.hoverable = false;
        return this;
    }

    public DataTable<T> hovered() {
        noHover();
        tableElement.style().add(TABLE_HOVER);
        this.hoverable = true;
        return this;
    }

    public DataTable<T> noBorder() {
        tableElement.style().remove(TABLE_BORDERED);
        this.bordered = false;
        return this;
    }

    public DataTable<T> bordered() {
        noBorder();
        tableElement.style().add(TABLE_BORDERED);
        this.bordered = true;
        return this;
    }

    public DataTable<T> noStripes() {
        tableElement.style().remove(TABLE_STRIPED);
        this.striped = false;
        return this;
    }

    public DataTable<T> striped() {
        noStripes();
        tableElement.style().add(TABLE_STRIPED);
        this.striped = true;
        return this;
    }

    public DataTable<T> edit(){
        getItems().forEach(TableRow::edit);
        return this;
    }

    public DataTable<T> save(){
        getItems().forEach(TableRow::save);
        return this;
    }

    public DataTable<T> cancelEditing(){
        getItems().forEach(TableRow::cancelEditing);
        return this;
    }

    public DominoElement<HTMLTableElement> tableElement() {
        return tableElement;
    }

    public DominoElement<HTMLTableSectionElement> bodyElement() {
        return tbody;
    }

    public DominoElement<HTMLTableSectionElement> headerElement() {
        return thead;
    }

    public TableConfig<T> getTableConfig() {
        return tableConfig;
    }

    public boolean isCondensed() {
        return condensed;
    }

    public boolean isHoverable() {
        return hoverable;
    }

    public boolean isStriped() {
        return striped;
    }

    public boolean isBordered() {
        return bordered;
    }

    public void filterRows(LocalRowFilter<T> rowFilter) {
        tableRows.forEach(tableRow -> {
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

    public void clearRowFilters() {
        tableRows.stream().filter(tableRow -> nonNull(tableRow.getFlag(DATA_TABLE_ROW_FILTERED)))
                .forEach(tableRow -> {
                    tableRow.style().remove(TABLE_ROW_FILTERED);
                    tableRow.removeFlag(DATA_TABLE_ROW_FILTERED);
                    tableRow.fireUpdate();
                });
    }

    @Override
    public HTMLDivElement element() {
        return root.element();
    }

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

    public List<T> getRecords(){
        return getItems()
                .stream()
                .map(TableRow::getRecord)
                .collect(Collectors.toList());
    }

    public List<T> getDirtyRecords(){
        return getItems()
                .stream()
                .map(TableRow::getDirtyRecord)
                .collect(Collectors.toList());
    }

    @Override
    public void onSelectionChange(TableRow<T> source) {
        selectionChangeListeners.forEach(selectionChangeListener -> selectionChangeListener.onSelectionChanged(getSelectedItems(), getSelectedRecords()));
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

    @Override
    public boolean isSelectable() {
        return this.selectable;
    }

    public void addSelectionListener(SelectionChangeListener<T> selectionChangeListener) {
        this.selectionChangeListeners.add(selectionChangeListener);
    }

    public void removeSelectionListener(SelectionChangeListener<T> selectionChangeListener) {
        this.selectionChangeListeners.remove(selectionChangeListener);
    }

    public void addTableEventListner(String type, TableEventListener listener) {
        if (!events.containsKey(type)) {
            events.put(type, new ArrayList<>());
        }
        events.get(type).add(listener);
    }

    public void removeTableListener(String type, TableEventListener listener) {
        if (events.containsKey(type)) {
            events.get(type).remove(listener);
        }
    }

    public void fireTableEvent(TableEvent tableEvent) {
        if (events.containsKey(tableEvent.getType())) {
            events.get(tableEvent.getType()).forEach(listener -> listener.handleEvent(tableEvent));
        }

        events.get(ANY).forEach(listener -> listener.handleEvent(tableEvent));
    }

    public SearchContext getSearchContext() {
        return searchContext;
    }

    @FunctionalInterface
    public interface SelectionChangeListener<T> {
        void onSelectionChanged(List<TableRow<T>> selectedTableRows, List<T> selectedRecords);
    }

    public interface LocalRowFilter<T> {
        boolean filter(TableRow<T> tableRow);
    }

}
