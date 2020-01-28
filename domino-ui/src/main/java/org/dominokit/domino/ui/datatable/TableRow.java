package org.dominokit.domino.ui.datatable;

import elemental2.dom.HTMLTableRowElement;
import org.dominokit.domino.ui.datatable.events.RowRecordUpdatedEvent;
import org.dominokit.domino.ui.datatable.events.TableDataUpdatedEvent;
import org.dominokit.domino.ui.datatable.store.DataChangedEvent;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.Selectable;

import java.util.*;

import static org.jboss.gwt.elemento.core.Elements.tr;

public class TableRow<T> extends BaseDominoElement<HTMLTableRowElement, TableRow<T>> implements Selectable<T> {
    private T record;
    private boolean selected = false;
    private final int index;
    private DataTable<T> dataTable;
    private final Map<String, RowCell<T>> rowCells = new HashMap<>();

    private Map<String, String> flags = new HashMap<>();
    private Map<String, RowMetaObject> metaObjects = new HashMap<>();

    private HTMLTableRowElement element = tr().element();
    private List<SelectionHandler<T>> selectionHandlers = new ArrayList<>();

    private List<RowListener<T>> listeners = new ArrayList<>();

    public TableRow(T record, int index, DataTable<T> dataTable) {
        this.record = record;
        this.index = index;
        this.dataTable = dataTable;
        init(this);
    }

    public void setRecord(T record) {
        this.record = record;
    }

    @Override
    public T select() {
        if (!hasFalg(DataTable.DATA_TABLE_ROW_FILTERED)) {
            this.selected = true;
            selectionHandlers.forEach(selectionHandler -> selectionHandler.onSelectionChanged(TableRow.this));
        }

        return record;
    }

    @Override
    public T deselect() {
        this.selected = false;
        selectionHandlers.forEach(selectionHandler -> selectionHandler.onSelectionChanged(TableRow.this));
        return record;
    }

    @Override
    public T select(boolean silent) {
        this.selected = true;
        return record;
    }

    @Override
    public T deselect(boolean silent) {
        this.selected = false;
        return record;
    }

    @Override
    public boolean isSelected() {
        return selected;
    }

    public T getRecord() {
        return record;
    }

    @Override
    public void addSelectionHandler(SelectionHandler<T> selectionHandler) {
        this.selectionHandlers.add(selectionHandler);
    }

    public void addRowListener(RowListener<T> listener) {
        listeners.add(listener);
    }

    public void removeListener(RowListener<T> listener) {
        listeners.remove(listener);
    }

    public void fireUpdate() {
        listeners.forEach(listener -> listener.onChange(TableRow.this));
    }

    @Override
    public HTMLTableRowElement element() {
        return element;
    }

    public void setFlag(String name, String value) {
        flags.put(name, value);
    }

    public String getFlag(String name) {
        return flags.get(name);
    }

    public void addMetaObject(RowMetaObject metaObject) {
        metaObjects.put(metaObject.getKey(), metaObject);
    }

    public <E extends RowMetaObject> E getMetaObject(String key) {
        return (E) metaObjects.get(key);
    }

    public void removeFlag(String name) {
        flags.remove(name);
    }

    public boolean hasFalg(String name) {
        return flags.containsKey(name);
    }

    public void addCell(RowCell<T> rowCell) {
        rowCells.put(rowCell.getColumnConfig().getName(), rowCell);
    }

    public RowCell<T> getCell(String name) {
        return rowCells.get(name);
    }

    public int getIndex() {
        return index;
    }

    public void updateRow() {
        updateRow(this.record);
    }

    public void updateRow(T record) {
        this.record = record;
        rowCells.values().forEach(RowCell::updateCell);
        this.dataTable.fireTableEvent(new RowRecordUpdatedEvent<>(this));
        this.dataTable.fireTableEvent(new TableDataUpdatedEvent<>(new ArrayList<>(dataTable.getData()), dataTable.getData().size()));
    }

    public Map<String, RowCell<T>> getRowCells() {
        return Collections.unmodifiableMap(rowCells);
    }

    @FunctionalInterface
    public interface RowListener<T> {
        void onChange(TableRow<T> tableRow);
    }

    public interface RowMetaObject {
        String getKey();
    }
}
