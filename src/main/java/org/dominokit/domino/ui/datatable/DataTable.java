package org.dominokit.domino.ui.datatable;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLTableElement;
import elemental2.dom.HTMLTableSectionElement;
import org.dominokit.domino.ui.datatable.events.OnBeforeDataChangeEvent;
import org.dominokit.domino.ui.datatable.events.TableDataUpdatedEvent;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.datatable.events.TableEventListener;
import org.dominokit.domino.ui.datatable.model.SearchContext;
import org.dominokit.domino.ui.datatable.store.DataStore;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasSelectionSupport;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.*;

public class DataTable<T> extends BaseDominoElement<HTMLDivElement, DataTable<T>> implements HasSelectionSupport<TableRow<T>> {

    public static final String ANY = "*";
    private final DataStore<T> dataStore;
    private DominoElement<HTMLDivElement> element = DominoElement.of(div().css("table-responsive"));
    private DominoElement<HTMLTableElement> tableElement = DominoElement.of(table().css("table", "table-hover", "table-striped"));
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

    private final SearchContext<T> searchContext= new SearchContext<>(this);

    public DataTable(TableConfig<T> tableConfig, DataStore<T> dataStore) {
        this.tableConfig = tableConfig;
        this.events.put(ANY, new ArrayList<>());
        this.dataStore = dataStore;
        this.addTableEventListner(ANY, dataStore);
        this.dataStore.onDataChanged(dataChangedEvent -> {
            fireTableEvent(new OnBeforeDataChangeEvent<>(this.data, dataChangedEvent.getTotalCount(), dataChangedEvent.isAppend()));
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
        element.appendChild(tableElement);
        tableConfig.getPlugins().forEach(plugin -> plugin.onAfterAddTable(DataTable.this));
        if (!tableConfig.isLazyLoad()) {
            this.dataStore.load();
        }
        if (tableConfig.isFixed()) {
            element.style()
                    .setPosition("relative")
                    .setOverFlowY("hidden");
            thead.style().setDisplay("block");
            tbody.style()
                    .add("tbody-fixed")
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

        tbody.asElement().scrollTop = 0.0;
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
        tableElement.style().remove("table-condensed");
        this.condensed = false;
        return this;
    }

    public DataTable<T> condense() {
        expand();
        tableElement.style().add("table-condensed");
        this.condensed = true;
        return this;
    }

    public DataTable<T> noHover() {
        tableElement.style().remove("table-hover");
        this.hoverable = false;
        return this;
    }

    public DataTable<T> hovered() {
        noHover();
        tableElement.style().add("table-hover");
        this.hoverable = true;
        return this;
    }

    public DataTable<T> noBorder() {
        tableElement.style().remove("table-bordered");
        this.bordered = false;
        return this;
    }

    public DataTable<T> bordered() {
        noBorder();
        tableElement.style().add("table-bordered");
        this.bordered = true;
        return this;
    }

    public DataTable<T> noStripes() {
        tableElement.style().remove("table-striped");
        this.striped = false;
        return this;
    }

    public DataTable<T> striped() {
        noStripes();
        tableElement.style().add("table-striped");
        this.striped = true;
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
                tableRow.style().removeProperty("display");
                tableRow.removeFlag("data-table-row-filtered");
                tableRow.fireUpdate();
            } else {
                tableRow.style().setDisplay("none");
                tableRow.setFlag("data-table-row-filtered", "true");
                tableRow.deselect();
                tableRow.fireUpdate();
            }
        });
    }

    public void clearRowFilters() {
        tableRows.stream().filter(tableRow -> nonNull(tableRow.getFlag("data-table-row-filtered")))
                .forEach(tableRow -> {
                    tableRow.style().removeProperty("display");
                    tableRow.removeFlag("data-table-row-filtered");
                    tableRow.fireUpdate();
                });
    }

    @Override
    public HTMLDivElement asElement() {
        return element.asElement();
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

    @Override
    public void onSelectionChange(TableRow<T> source) {
        selectionChangeListeners.forEach(selectionChangeListener -> selectionChangeListener.onSelectionChanged(getSelectedItems(), getSelectedRecords()));
    }

    @Override
    public void selectAll() {
        if (tableConfig.isMultiSelect() && !tableRows.isEmpty()) {
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
