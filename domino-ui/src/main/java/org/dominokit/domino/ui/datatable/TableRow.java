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

import static org.jboss.elemento.Elements.tr;

import elemental2.dom.HTMLTableRowElement;
import java.util.*;
import org.dominokit.domino.ui.datatable.events.RowRecordUpdatedEvent;
import org.dominokit.domino.ui.datatable.events.TableDataUpdatedEvent;
import org.dominokit.domino.ui.forms.validations.ValidationResult;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.Selectable;

public class TableRow<T> extends BaseDominoElement<HTMLTableRowElement, TableRow<T>>
    implements Selectable<T> {
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
  private boolean editable = false;

  public TableRow(T record, int index, DataTable<T> dataTable) {
    this.record = record;
    this.index = index;
    this.dataTable = dataTable;
    init(this);
  }

  public void setRecord(T record) {
    this.record = record;
  }

  public T getDirtyRecord() {
    T dirtyRecord = dataTable.getTableConfig().getDirtyRecordProvider().createDirtyRecord(record);
    getRowCells().forEach((s, rowCell) -> rowCell.getCellInfo().updateDirtyRecord(dirtyRecord));
    return dirtyRecord;
  }

  @Override
  public T select() {
    if (!hasFalg(DataTable.DATA_TABLE_ROW_FILTERED)) {
      this.selected = true;
      selectionHandlers.forEach(
          selectionHandler -> selectionHandler.onSelectionChanged(TableRow.this));
    }
    return record;
  }

  @Override
  public T deselect() {
    this.selected = false;
    selectionHandlers.forEach(
        selectionHandler -> selectionHandler.onSelectionChanged(TableRow.this));
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
    this.dataTable.fireTableEvent(
        new TableDataUpdatedEvent<>(
            new ArrayList<>(dataTable.getData()), dataTable.getData().size()));
  }

  public ValidationResult validate() {
    Optional<ValidationResult> first =
        getRowCells().values().stream()
            .map(tRowCell -> tRowCell.getCellInfo().validate())
            .filter(result -> !result.isValid())
            .findFirst();
    if (first.isPresent()) {
      return ValidationResult.invalid("");
    } else {
      return ValidationResult.valid();
    }
  }

  public Map<String, RowCell<T>> getRowCells() {
    return Collections.unmodifiableMap(rowCells);
  }

  /**
   * An interface to implement listeners for Table row changes
   *
   * @param <T> the type of the data table records
   */
  @FunctionalInterface
  public interface RowListener<T> {
    /** @param tableRow the changed {@link TableRow} */
    void onChange(TableRow<T> tableRow);
  }

  /**
   * this interface is used to implement custom meta object for rows with a unique key then later
   * these meta object can be added to the row and can be used for any kind of logic.
   */
  public interface RowMetaObject {
    /** @return String, a unique key for the meta object */
    String getKey();
  }

  /** Convert the row the editable mode */
  public void edit() {
    setEditable(true);
    updateRow();
  }

  /** Save the editable row changes and switch to normal mode */
  public void save() {
    if (validate().isValid()) {
      dataTable
          .getTableConfig()
          .getSaveDirtyRecordHandler()
          .saveDirtyRecord(record, getDirtyRecord());
      this.setEditable(false);
      updateRow();
    }
  }

  /** Cancel the current edit operation and switch to the normal mode */
  public void cancelEditing() {
    this.setEditable(false);
    updateRow();
  }

  /** @return boolean, true if the row is editable, otherwise false */
  public boolean isEditable() {
    return editable;
  }

  /** @param editable boolean, true if this row should be editable, otherwise it is not */
  private void setEditable(boolean editable) {
    this.editable = editable;
  }
}
