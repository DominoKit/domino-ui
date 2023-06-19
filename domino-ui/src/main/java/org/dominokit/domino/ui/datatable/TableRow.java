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

import elemental2.dom.HTMLTableCellElement;
import elemental2.dom.HTMLTableRowElement;
import java.util.*;
import org.dominokit.domino.ui.datatable.events.RowRecordUpdatedEvent;
import org.dominokit.domino.ui.datatable.events.TableDataUpdatedEvent;
import org.dominokit.domino.ui.forms.validations.ValidationResult;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.utils.*;
import org.dominokit.domino.ui.utils.HasSelectionHandler.SelectionHandler;

public class TableRow<T> extends BaseDominoElement<HTMLTableRowElement, TableRow<T>>
    implements Selectable<TableRow<T>>,
        HasSelectionListeners<TableRow<T>, TableRow<T>, TableRow<T>>,
        DataTableStyles {
  private T record;
  private boolean selected = false;
  private final int index;
  private DataTable<T> dataTable;
  private final Map<String, RowCell<T>> rowCells = new HashMap<>();

  private Map<String, String> flags = new HashMap<>();

  private HTMLTableRowElement element = tr().element();
  private List<SelectionHandler<T>> selectionHandlers = new ArrayList<>();

  private List<RowListener<T>> listeners = new ArrayList<>();
  private boolean editable = false;
  private RowRenderer<T> rowRenderer = new DefaultRowRenderer<>();
  private TableRow<T> parent;
  private List<TableRow<T>> children = new ArrayList<>();
  private boolean selectionListenersPaused = false;
  private Set<SelectionListener<? super TableRow<T>, ? super TableRow<T>>> selectionListeners =
      new HashSet<>();
  private Set<SelectionListener<? super TableRow<T>, ? super TableRow<T>>> deselectionListeners =
      new HashSet<>();
  private boolean selectable;

  public TableRow(T record, int index, DataTable<T> dataTable) {
    this.record = record;
    this.index = index;
    this.dataTable = dataTable;
    init(this);
    addCss(dui_datatable_row);
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
  public TableRow<T> select() {
    return doSelect(true);
  }

  private TableRow<T> doSelect(boolean selectChildren) {
    if (!hasFalg(DataTable.DATA_TABLE_ROW_FILTERED)) {
      this.selected = true;
      if (selectChildren) {
        getChildren().forEach(TableRow::select);
      }
      Optional.ofNullable(parent)
          .ifPresent(
              tableRow -> {
                if (tableRow.shouldBeSelected()) {
                  tableRow.doSelect(false);
                }
              });
      triggerSelectionListeners(this, this);
      this.dataTable.triggerSelectionListeners(this, dataTable.getSelection());
    }
    return this;
  }

  private boolean shouldBeSelected() {
    return getChildren().stream().allMatch(TableRow::isSelected);
  }

  @Override
  public TableRow<T> deselect() {
    return doDeselect(true, true);
  }

  private TableRow<T> doDeselect(boolean deselectParent, boolean deselectChildren) {
    this.selected = false;
    if (deselectChildren) {
      getChildren().forEach(tableRow -> tableRow.doDeselect(false, true));
    }
    if (deselectParent) {
      Optional.ofNullable(parent).ifPresent(tableRow -> tableRow.doDeselect(true, false));
    }
    triggerDeselectionListeners(this, this);
    this.dataTable.triggerDeselectionListeners(this, dataTable.getSelection());
    return this;
  }

  @Override
  public TableRow<T> pauseSelectionListeners() {
    this.selectionListenersPaused = true;
    return this;
  }

  @Override
  public TableRow<T> resumeSelectionListeners() {
    this.selectionListenersPaused = false;
    return this;
  }

  @Override
  public TableRow<T> togglePauseSelectionListeners(boolean toggle) {
    this.selectionListenersPaused = toggle;
    return this;
  }

  @Override
  public Set<SelectionListener<? super TableRow<T>, ? super TableRow<T>>> getSelectionListeners() {
    return this.selectionListeners;
  }

  @Override
  public Set<SelectionListener<? super TableRow<T>, ? super TableRow<T>>>
      getDeselectionListeners() {
    return this.deselectionListeners;
  }

  @Override
  public boolean isSelectionListenersPaused() {
    return this.selectionListenersPaused;
  }

  @Override
  public TableRow<T> triggerSelectionListeners(TableRow<T> source, TableRow<T> selection) {
    if (!this.selectionListenersPaused) {
      new ArrayList<>(selectionListeners)
          .forEach(
              listener -> {
                listener.onSelectionChanged(Optional.ofNullable(source), selection);
              });
    }
    return this;
  }

  @Override
  public TableRow<T> triggerDeselectionListeners(TableRow<T> source, TableRow<T> selection) {
    if (!this.selectionListenersPaused) {
      new ArrayList<>(deselectionListeners)
          .forEach(
              listener -> {
                listener.onSelectionChanged(Optional.ofNullable(source), selection);
              });
    }
    return this;
  }

  @Override
  public TableRow<T> getSelection() {
    if (isSelected()) {
      return this;
    }
    return null;
  }

  @Override
  public boolean isSelectable() {
    return this.selectable;
  }

  @Override
  public TableRow<T> setSelectable(boolean selectable) {
    this.selectable = selectable;
    return this;
  }

  @Override
  public TableRow<T> setSelected(boolean selected) {
    this.selected = selected;
    if (selected) {
      select();
    } else {
      deselect();
    }
    return this;
  }

  @Override
  public TableRow<T> setSelected(boolean selected, boolean silent) {
    withPauseSelectionListenersToggle(silent, tableRow -> tableRow.setSelected(selected));
    return this;
  }

  @Override
  public TableRow<T> select(boolean silent) {
    return setSelected(true, silent);
  }

  @Override
  public TableRow<T> deselect(boolean silent) {
    return setSelected(true, silent);
  }

  @Override
  public boolean isSelected() {
    return selected;
  }

  public T getRecord() {
    return record;
  }

  public DataTable<T> getDataTable() {
    return dataTable;
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

  public void removeFlag(String name) {
    flags.remove(name);
  }

  /** @deprecated use {@link #hasFlag} */
  @Deprecated
  public boolean hasFalg(String name) {
    return flags.containsKey(name);
  }

  public boolean hasFlag(String name) {
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

  public void render() {
    Optional<RowRendererMeta<T>> rendererMeta = RowRendererMeta.get(this);
    if (rendererMeta.isPresent()) {
      rendererMeta.get().getRowRenderer().render(dataTable, this);
    } else {
      rowRenderer.render(dataTable, this);
    }
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
    addCss(BooleanCssClass.of(dui_datatable_row_editable, editable));
  }

  public void renderCell(ColumnConfig<T> columnConfig) {
    HTMLTableCellElement cellElement = td().addCss(dui_datatable_td).element();

    ColumnCssRuleMeta.get(columnConfig)
        .ifPresent(
            meta ->
                meta.cssRules()
                    .forEach(
                        columnCssRule ->
                            elementOf(cellElement)
                                .addCss(columnCssRule.getCssRule().getCssClass())));

    RowCell<T> rowCell =
        new RowCell<>(new CellRenderer.CellInfo<>(this, cellElement), columnConfig);
    rowCell.updateCell();
    addCell(rowCell);

    columnConfig.applyScreenMedia(cellElement);

    columnConfig.applyCellStyle(cellElement);
    if (columnConfig.isHidden()) {
      elementOf(cellElement).hide();
    }
    dataTable
        .getTableConfig()
        .getPlugins()
        .forEach(plugin -> plugin.onBeforeAddCell(dataTable, this, rowCell));
    element().appendChild(cellElement);
    dataTable
        .getTableConfig()
        .getPlugins()
        .forEach(plugin -> plugin.onAfterAddCell(dataTable, this, rowCell));
    columnConfig.addShowHideListener(DefaultColumnShowHideListener.of(cellElement));
  }

  public TableRow<T> getParent() {
    return parent;
  }

  public void setParent(TableRow<T> parent) {
    this.parent = parent;
  }

  public List<TableRow<T>> getChildren() {
    return children;
  }

  public void setChildren(List<TableRow<T>> children) {
    if (nonNull(children)) {
      this.children = children;
    }
  }

  public boolean isParent() {
    return !getChildren().isEmpty();
  }

  public boolean isChild() {
    return nonNull(parent);
  }

  public boolean isRoot() {
    return isNull(parent);
  }

  public interface RowRenderer<T> {
    void render(DataTable<T> dataTable, TableRow<T> tableRow);
  }

  private static class DefaultRowRenderer<T> implements RowRenderer<T> {

    @Override
    public void render(DataTable<T> dataTable, TableRow<T> tableRow) {
      dataTable.getTableConfig().getColumns().forEach(tableRow::renderCell);
    }
  }
}
