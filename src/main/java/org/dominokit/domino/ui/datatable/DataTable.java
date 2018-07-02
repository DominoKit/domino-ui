package org.dominokit.domino.ui.datatable;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLTableElement;
import elemental2.dom.HTMLTableSectionElement;
import org.dominokit.domino.ui.datatable.events.TableDataUpdated;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.datatable.events.TableEventListener;
import org.dominokit.domino.ui.datatable.store.DataStore;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.dominokit.domino.ui.utils.HasMultiSelectSupport;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.*;

public class DataTable<T> implements IsElement<HTMLDivElement>, HasMultiSelectSupport<TableRow<T>> {

    public static final String ANY = "*";
    private final DataStore<T> dataStore;
    private HTMLDivElement element = div().css("table-responsive").asElement();
    private HTMLTableElement tableElement = table().css("table", "table-hover", "table-striped").asElement();
    private TableConfig<T> tableConfig;
    private HTMLTableSectionElement tbody = tbody().asElement();
    private HTMLTableSectionElement thead = thead().asElement();
    private List<T> data = new ArrayList<>();
    private boolean multiSelect = true;
    private boolean selectable = true;
    private List<TableRow<T>> tableRows = new ArrayList<>();

    private List<SelectionChangeListener<T>> selectionChangeListeners = new ArrayList<>();
    private boolean condensed = false;
    private boolean hoverable = true;
    private boolean striped = true;
    private boolean bordered = false;

    private Map<String, List<TableEventListener>> events = new HashMap<>();

    public DataTable(TableConfig<T> tableConfig, DataStore<T> dataStore) {
        this.tableConfig = tableConfig;
        this.events.put(ANY, new ArrayList<>());
        this.dataStore = dataStore;
        this.addTableEventListner(ANY, dataStore);
        this.dataStore.onDataChanged(dataChangedEvent -> {
            if (dataChangedEvent.isAppend()) {
                appendData(dataChangedEvent.getNewData());
            } else {
                setData(dataChangedEvent.getNewData());
            }
            fireTableEvent(new TableDataUpdated<>(this.data, dataChangedEvent.getTotalCount()));
        });

        init();
    }

    private DataTable<T> init() {
        tableConfig.getPlugins().forEach(plugin -> {
            DataTable.this.addTableEventListner("*", plugin);
            plugin.onBeforeAddTable(DataTable.this);
        });
        tableConfig.onBeforeHeaders(this);
        tableConfig.drawHeaders(this, thead);
        tableElement.appendChild(tbody);
        tableConfig.getPlugins().forEach(plugin -> plugin.onBodyAdded(DataTable.this));
        element.appendChild(tableElement);
        tableConfig.getPlugins().forEach(plugin -> plugin.onAfterAddTable(DataTable.this));
        if (!tableConfig.isLazyLoad()) {
            this.dataStore.load();
        }
        if (tableConfig.isFixed()) {
            Style.of(element)
                    .setProperty("position", "relative")
                    .setProperty("overflow-y", "hidden");
            Style.of(thead).setDisplay("block");
            Style.of(tbody)
                    .css("tbody-fixed")
                    .setMaxHeight(tableConfig.getFixedBodyHeight());
        }
        return this;
    }


    public void load() {
        this.dataStore.load();
    }


    public void setData(List<T> data) {
        this.data = data;
        tableRows.clear();
        ElementUtil.clear(tbody);
        if (nonNull(data) && !data.isEmpty()) {
            addRows(data, 0);
        }

        tbody.scrollTop = 0.0;
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
        for (int index = 0; index < data.size(); index++) {
            TableRow<T> tableRow = new TableRow<>(data.get(index), initialIndex + index);
            tableConfig.drawRecord(DataTable.this, tableRow);
            tableRows.add(tableRow);
        }
    }

    public Collection<T> getData() {
        return data;
    }

    public DataTable<T> expand() {
        tableElement.classList.remove("table-condensed");
        this.condensed = false;
        return this;
    }

    public DataTable<T> condense() {
        expand();
        tableElement.classList.add("table-condensed");
        this.condensed = true;
        return this;
    }

    public DataTable<T> noHover() {
        tableElement.classList.remove("table-hover");
        this.hoverable = false;
        return this;
    }

    public DataTable<T> hovered() {
        noHover();
        tableElement.classList.add("table-hover");
        this.hoverable = true;
        return this;
    }

    public DataTable<T> noBorder() {
        tableElement.classList.remove("table-bordered");
        this.bordered = false;
        return this;
    }

    public DataTable<T> bordered() {
        noBorder();
        tableElement.classList.add("table-bordered");
        this.bordered = true;
        return this;
    }

    public DataTable<T> noStripes() {
        tableElement.classList.remove("table-striped");
        this.striped = false;
        return this;
    }

    public DataTable<T> striped() {
        noStripes();
        tableElement.classList.add("table-striped");
        this.striped = true;
        return this;
    }

    public HTMLTableElement tableElement() {
        return tableElement;
    }

    public HTMLTableSectionElement bodyElement() {
        return tbody;
    }

    public HTMLTableSectionElement headerElement() {
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
                Style.of(tableRow.asElement()).removeProperty("display");
                tableRow.removeFlag("data-table-row-filtered");
                tableRow.fireUpdate();
            } else {
                Style.of(tableRow.asElement()).setDisplay("none");
                tableRow.setFlag("data-table-row-filtered", "true");
                tableRow.deselect();
                tableRow.fireUpdate();
            }
        });
    }

    public void clearRowFilters() {
        tableRows.stream().filter(tableRow -> nonNull(tableRow.getFlag("data-table-row-filtered")))
                .forEach(tableRow -> {
                    Style.of(tableRow.asElement()).removeProperty("display");
                    tableRow.removeFlag("data-table-row-filtered");
                    tableRow.fireUpdate();
                });
    }

    @Override
    public HTMLDivElement asElement() {
        return element;
    }

    @Override
    public List<TableRow<T>> getSelectedItems() {
        return tableRows.stream().filter(TableRow::isSelected).collect(Collectors.toList());
    }

    public List<T> getSelectedRecords() {
        return getSelectedItems().stream().map(TableRow::getRecord).collect(Collectors.toList());
    }

    @Override
    public boolean isMultiSelect() {
        return this.multiSelect;
    }

    @Override
    public void setMultiSelect(boolean multiSelect) {
        this.multiSelect = multiSelect;
    }

    @Override
    public List<TableRow<T>> getItems() {
        return tableRows;
    }

    @Override
    public void onSelectionChange(TableRow<T> source) {
        selectionChangeListeners.forEach(selectionChangeListener -> selectionChangeListener.onSelectionChanged(getSelectedItems(), getSelectedRecords()));
    }

    @Override
    public void selectAll() {
        if (isMultiSelect() && !tableRows.isEmpty()) {
            tableRows.forEach(TableRow::select);
            onSelectionChange(tableRows.get(0));
        }
    }

    @Override
    public void deselectAll() {
        if (!tableRows.isEmpty()) {
            tableRows.stream().filter(TableRow::isSelected).forEach(TableRow::deselect);
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

    @FunctionalInterface
    public interface SelectionChangeListener<T> {
        void onSelectionChanged(List<TableRow<T>> selectedTableRows, List<T> selectedRecords);
    }

    public interface LocalRowFilter<T> {
        boolean filter(TableRow<T> tableRow);
    }

}
