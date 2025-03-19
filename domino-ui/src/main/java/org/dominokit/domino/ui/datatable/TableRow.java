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
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.HTMLTableCellElement;
import elemental2.dom.HTMLTableRowElement;
import java.util.*;
import org.dominokit.domino.ui.datatable.events.RowRecordUpdatedEvent;
import org.dominokit.domino.ui.datatable.events.TableDataUpdatedEvent;
import org.dominokit.domino.ui.forms.FieldsGrouping;
import org.dominokit.domino.ui.forms.validations.ValidationResult;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.HasSelectionListeners;
import org.dominokit.domino.ui.utils.Selectable;

/**
 * Represents a table row containing data and provides functionalities for handling selection,
 * editing, and rendering.
 *
 * @param <T> The type of the data object for this row.
 * @see BaseDominoElement
 */
public class TableRow<T> extends BaseDominoElement<HTMLTableRowElement, TableRow<T>>
    implements Selectable<TableRow<T>>,
        HasSelectionListeners<TableRow<T>, TableRow<T>, TableRow<T>>,
        DataTableStyles {
  private T record;
  private boolean selected = false;
  private final int index;
  private DataTable<T> dataTable;
  private Map<String, RowCell<T>> rowCells;

  private Map<String, String> flags;

  private HTMLTableRowElement element = tr().element();

  private List<RowListener<T>> listeners;
  private boolean editable = false;
  private RowRenderer<T> rowRenderer;
  private TableRow<T> parent;
  private List<TableRow<T>> children;
  private boolean selectionListenersPaused = false;
  private Set<SelectionListener<? super TableRow<T>, ? super TableRow<T>>> selectionListeners;
  private Set<SelectionListener<? super TableRow<T>, ? super TableRow<T>>> deselectionListeners;
  private boolean selectable;

  private FieldsGrouping rowFieldsGroup;
  private boolean draggable = true;

  /**
   * Constructs a table row with the given record, index, and parent table.
   *
   * @param record The data record for this row.
   * @param index The index of this row.
   * @param dataTable The parent table containing this row.
   */
  public TableRow(T record, int index, DataTable<T> dataTable) {
    this.record = record;
    this.index = index;
    this.dataTable = dataTable;
    init(this);
    addCss(dui_datatable_row);
  }

  /**
   * Sets the data record for this row.
   *
   * @param record The data record to be set.
   */
  public void setRecord(T record) {
    this.record = record;
  }

  /** @return A modified record containing changes made to the row. */
  public T getDirtyRecord() {
    T dirtyRecord = dataTable.getTableConfig().getDirtyRecordProvider().createDirtyRecord(record);
    getRowCells().forEach((s, rowCell) -> rowCell.getCellInfo().updateDirtyRecord(dirtyRecord));
    return dirtyRecord;
  }

  /**
   * Selects the current row and, by default, its child rows if they exist.
   *
   * @return The current instance of TableRow for chaining purposes.
   */
  @Override
  public TableRow<T> select() {
    return doSelect(true);
  }

  /**
   * Handles the selection logic for the row.
   *
   * @param selectChildren Whether to select child rows.
   * @return The current instance of TableRow for chaining purposes.
   */
  private TableRow<T> doSelect(boolean selectChildren) {
    if (!hasFlag(DataTable.DATA_TABLE_ROW_FILTERED)) {
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

  /**
   * Checks if the current row should be selected based on the state of its child rows.
   *
   * @return true if all child rows are selected, false otherwise.
   */
  private boolean shouldBeSelected() {
    return getChildren().stream().allMatch(TableRow::isSelected);
  }

  /**
   * Deselects the current row and its child and parent rows by default.
   *
   * @return The current instance of TableRow for chaining purposes.
   */
  @Override
  public TableRow<T> deselect() {
    return doDeselect(true, true);
  }

  /**
   * Handles the deselection logic for the row.
   *
   * @param deselectParent Whether to deselect the parent row.
   * @param deselectChildren Whether to deselect child rows.
   * @return The current instance of TableRow for chaining purposes.
   */
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

  /**
   * Pauses the firing of selection listeners.
   *
   * @return The current instance of TableRow for chaining purposes.
   */
  @Override
  public TableRow<T> pauseSelectionListeners() {
    this.selectionListenersPaused = true;
    return this;
  }

  /**
   * Resumes the firing of selection listeners.
   *
   * @return The current instance of TableRow for chaining purposes.
   */
  @Override
  public TableRow<T> resumeSelectionListeners() {
    this.selectionListenersPaused = false;
    return this;
  }

  /**
   * Toggles the state of selection listeners between paused and active.
   *
   * @param toggle The desired state of the listeners.
   * @return The current instance of TableRow for chaining purposes.
   */
  @Override
  public TableRow<T> togglePauseSelectionListeners(boolean toggle) {
    this.selectionListenersPaused = toggle;
    return this;
  }

  /**
   * Retrieves the set of selection listeners attached to the row.
   *
   * @return A set of selection listeners.
   */
  @Override
  public Set<SelectionListener<? super TableRow<T>, ? super TableRow<T>>> getSelectionListeners() {
    if (isNull(this.selectionListeners)) {
      this.selectionListeners = new HashSet<>();
    }
    return this.selectionListeners;
  }

  /**
   * Retrieves the set of deselection listeners attached to the row.
   *
   * @return A set of deselection listeners.
   */
  @Override
  public Set<SelectionListener<? super TableRow<T>, ? super TableRow<T>>>
      getDeselectionListeners() {
    if (isNull(this.deselectionListeners)) {
      this.deselectionListeners = new HashSet<>();
    }
    return this.deselectionListeners;
  }

  /**
   * Checks if selection listeners are currently paused.
   *
   * @return true if listeners are paused, false otherwise.
   */
  @Override
  public boolean isSelectionListenersPaused() {
    return this.selectionListenersPaused;
  }

  /**
   * Triggers all active selection listeners attached to the row.
   *
   * @param source The source row that triggered the listeners.
   * @param selection The row that was selected.
   * @return The current instance of TableRow for chaining purposes.
   */
  @Override
  public TableRow<T> triggerSelectionListeners(TableRow<T> source, TableRow<T> selection) {
    if (!this.selectionListenersPaused) {
      new ArrayList<>(getSelectionListeners())
          .forEach(
              listener -> {
                listener.onSelectionChanged(Optional.ofNullable(source), selection);
              });
    }
    return this;
  }

  /**
   * Triggers all active deselection listeners attached to the row.
   *
   * @param source The source row that triggered the listeners.
   * @param selection The row that was deselected.
   * @return The current instance of TableRow for chaining purposes.
   */
  @Override
  public TableRow<T> triggerDeselectionListeners(TableRow<T> source, TableRow<T> selection) {
    if (!this.selectionListenersPaused) {
      new ArrayList<>(getDeselectionListeners())
          .forEach(
              listener -> {
                listener.onSelectionChanged(Optional.ofNullable(source), selection);
              });
    }
    return this;
  }

  /**
   * Retrieves the selection state of the row.
   *
   * @return The current row if it's selected, null otherwise.
   */
  @Override
  public TableRow<T> getSelection() {
    if (isSelected()) {
      return this;
    }
    return null;
  }

  /**
   * Checks if the row can be selected.
   *
   * @return true if the row is selectable, false otherwise.
   */
  @Override
  public boolean isSelectable() {
    return this.selectable;
  }

  /**
   * Sets the selectable state of the row.
   *
   * @param selectable The desired selectable state.
   * @return The current instance of TableRow for chaining purposes.
   */
  @Override
  public TableRow<T> setSelectable(boolean selectable) {
    this.selectable = selectable;
    return this;
  }

  /**
   * Sets the selected state of the row and triggers the relevant selection/deselection logic.
   *
   * @param selected The desired selected state.
   * @return The current instance of TableRow for chaining purposes.
   */
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

  /**
   * Sets the selected state of the row with an option to suppress triggering the listeners.
   *
   * @param selected The desired selected state.
   * @param silent If true, suppresses triggering the listeners; otherwise, they're triggered.
   * @return The current instance of TableRow for chaining purposes.
   */
  @Override
  public TableRow<T> setSelected(boolean selected, boolean silent) {
    withPauseSelectionListenersToggle(silent, tableRow -> tableRow.setSelected(selected));
    return this;
  }

  /**
   * Selects the row with an option to suppress triggering the listeners.
   *
   * @param silent If true, suppresses triggering the listeners; otherwise, they're triggered.
   * @return The current instance of TableRow for chaining purposes.
   */
  @Override
  public TableRow<T> select(boolean silent) {
    return setSelected(true, silent);
  }

  /**
   * Deselects the row with an option to suppress triggering the listeners.
   *
   * @param silent If true, suppresses triggering the listeners; otherwise, they're triggered.
   * @return The current instance of TableRow for chaining purposes.
   */
  @Override
  public TableRow<T> deselect(boolean silent) {
    return setSelected(true, silent);
  }

  /**
   * Checks if the row is currently selected.
   *
   * @return true if the row is selected, false otherwise.
   */
  @Override
  public boolean isSelected() {
    return selected;
  }

  /**
   * Retrieves the record/data associated with the row.
   *
   * @return The data/record of type T.
   */
  public T getRecord() {
    return record;
  }

  /**
   * Retrieves the data table to which this row belongs.
   *
   * @return The parent DataTable instance.
   */
  public DataTable<T> getDataTable() {
    return dataTable;
  }

  /**
   * Adds a listener to this row which will be notified when the row data is updated.
   *
   * @param listener The listener to be added.
   */
  public void addRowListener(RowListener<T> listener) {
    getListeners().add(listener);
  }

  private List<RowListener<T>> getListeners() {
    if (isNull(this.listeners)) {
      this.listeners = new ArrayList<>();
    }
    return listeners;
  }

  /**
   * Removes a specified listener from this row.
   *
   * @param listener The listener to be removed.
   */
  public void removeListener(RowListener<T> listener) {
    getListeners().remove(listener);
  }

  /** Notifies all listeners that the row data has been updated. */
  public void fireUpdate() {
    getListeners().forEach(listener -> listener.onChange(TableRow.this));
  }

  @Override
  public HTMLTableRowElement element() {
    return element;
  }

  /**
   * Sets a flag associated with a specific name.
   *
   * @param name The name of the flag.
   * @param value The value associated with the flag.
   */
  public void setFlag(String name, String value) {
    flags().put(name, value);
  }

  private Map<String, String> flags() {
    if (isNull(flags)) {
      this.flags = new HashMap<>();
    }
    return flags;
  }

  /**
   * Retrieves the value of a flag associated with a specific name.
   *
   * @param name The name of the flag.
   * @return The value associated with the flag, or null if the flag doesn't exist.
   */
  public String getFlag(String name) {
    return flags().get(name);
  }

  /**
   * Removes a flag associated with a specific name.
   *
   * @param name The name of the flag.
   */
  public void removeFlag(String name) {
    flags().remove(name);
  }

  /**
   * Checks if a specific flag is set.
   *
   * @param name The name of the flag.
   * @return true if the flag is set, false otherwise.
   */
  public boolean hasFlag(String name) {
    return flags().containsKey(name);
  }

  /**
   * Adds a cell to the row.
   *
   * @param rowCell The cell to be added.
   */
  public void addCell(RowCell<T> rowCell) {
    getCells().put(rowCell.getColumnConfig().getName(), rowCell);
  }

  /**
   * Retrieves a cell associated with a specific name.
   *
   * @param name The name of the cell.
   * @return The cell associated with the name, or null if the cell doesn't exist.
   */
  public RowCell<T> getCell(String name) {
    return getCells().get(name);
  }

  /**
   * Retrieves the index of the row in the data table.
   *
   * @return The index of the row.
   */
  public int getIndex() {
    return index;
  }

  /** Updates the row with the current record. */
  public void updateRow() {
    updateRow(this.record);
  }

  /**
   * Updates the row with a new record and notifies any listeners.
   *
   * @param record The new record to be set in the row.
   */
  public void updateRow(T record) {
    this.record = record;
    getCells().values().forEach(RowCell::updateCell);
    this.dataTable.fireTableEvent(new RowRecordUpdatedEvent<>(this));
    this.dataTable.fireTableEvent(
        new TableDataUpdatedEvent<>(
            new ArrayList<>(dataTable.getData()), dataTable.getData().size()));
  }
  /**
   * Validates the content of each cell in the row. It uses the validation mechanism provided by the
   * cell's info. If any cell's content is invalid, the method will return the first encountered
   * invalid result.
   *
   * @return A {@link ValidationResult} indicating the result of the validation. It returns invalid
   *     if at least one cell is invalid, otherwise returns valid.
   */
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

  /**
   * Retrieves an unmodifiable map of the row's cells indexed by their names.
   *
   * @return An unmodifiable map of {@link RowCell} objects.
   */
  public Map<String, RowCell<T>> getRowCells() {
    return Collections.unmodifiableMap(getCells());
  }

  private Map<String, RowCell<T>> getCells() {
    if (isNull(rowCells)) {
      this.rowCells = new HashMap<>();
    }
    return rowCells;
  }

  /**
   * Renders the row. The method first checks if a specialized renderer is available for this
   * specific row (through {@link RowRendererMeta}). If one is present, it uses that. Otherwise, it
   * defaults to the general row renderer.
   */
  public void render() {
    Optional<RowRendererMeta<T>> rendererMeta = RowRendererMeta.get(this);
    if (rendererMeta.isPresent()) {
      rendererMeta.get().getRowRenderer().render(dataTable, this);
    } else {
      getRowRenderer().render(dataTable, this);
    }
  }

  private RowRenderer<T> getRowRenderer() {
    if (isNull(rowRenderer)) {
      this.rowRenderer = new DefaultRowRenderer<>();
    }
    return rowRenderer;
  }

  /**
   * Interface to listen for changes on a TableRow.
   *
   * @param <T> The type of the data object for the row.
   */
  @FunctionalInterface
  public interface RowListener<T> {

    /**
     * Called when the TableRow data changes.
     *
     * @param tableRow The row that has changed.
     */
    void onChange(TableRow<T> tableRow);
  }

  /**
   * Initiates the edit mode for this row, making its content editable. It then updates the row's
   * display to reflect this editable state.
   */
  public void edit() {
    setEditable(true);
    getRowFieldsGroup().removeAllFormElements();
    updateRow();
    this.dataTable.getTableConfig().getOnRowEditHandler().accept(this);
  }

  /**
   * Attempts to save the edited content of the row to the underlying data table. If the current
   * row's content passes validation, it triggers the associated save handler of the table
   * configuration and then updates the row's state to reflect that it's no longer in edit mode.
   */
  public void save() {
    if (validate().isValid()) {
      dataTable
          .getTableConfig()
          .getSaveDirtyRecordHandler()
          .saveDirtyRecord(record, getDirtyRecord());
      this.setEditable(false);
      updateRow();
      getRowFieldsGroup().removeAllFormElements();
      this.dataTable.getTableConfig().getOnRowFinishEditHandler().accept(this);
    }
  }

  /**
   * Cancels the editing mode for the row, reverting any unsaved changes. The row's display is then
   * updated to reflect this non-editable state.
   */
  public void cancelEditing() {
    this.setEditable(false);
    updateRow();
    getRowFieldsGroup().removeAllFormElements();
    this.dataTable.getTableConfig().getOnRowFinishEditHandler().accept(this);
  }

  /**
   * Checks if the row is currently in edit mode.
   *
   * @return A boolean indicating if the row is editable.
   */
  public boolean isEditable() {
    return editable;
  }

  /**
   * Updates the editable state of the row and applies corresponding CSS styles.
   *
   * @param editable A boolean indicating the desired editable state.
   */
  private void setEditable(boolean editable) {
    this.editable = editable;
    addCss(BooleanCssClass.of(dui_datatable_row_editable, editable));
  }

  /**
   * Renders a specific cell within this row according to the given column configuration. This
   * method takes care of the cell's styling, visibility, and other attributes based on the provided
   * {@link ColumnConfig}. It also handles cell creation, applying media rules, styles, and
   * integrating with any additional plugins from the table configuration.
   *
   * @param columnConfig The configuration information for the column to which this cell belongs.
   */
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
        new RowCell<>(new CellRenderer.CellInfo<>(this, columnConfig, cellElement), columnConfig);
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

  /**
   * Retrieves the parent row of this row. If this row doesn't have a parent, it returns null.
   *
   * @return The parent {@link TableRow} or null if it doesn't have a parent.
   */
  public TableRow<T> getParent() {
    return parent;
  }

  /**
   * Sets a parent row for this row.
   *
   * @param parent The {@link TableRow} to be set as the parent.
   */
  public void setParent(TableRow<T> parent) {
    this.parent = parent;
  }

  /**
   * Retrieves a list of child rows associated with this row.
   *
   * @return A list of child {@link TableRow}s.
   */
  public List<TableRow<T>> getChildren() {
    return rowChildren();
  }

  private List<TableRow<T>> rowChildren() {
    if (isNull(children)) {
      this.children = new ArrayList<>();
    }
    return children;
  }

  /**
   * Checks if this row has any child rows.
   *
   * @return A boolean indicating if the row has children.
   */
  public boolean isParent() {
    return !getChildren().isEmpty();
  }

  /**
   * Checks if this row has a parent row.
   *
   * @return A boolean indicating if the row is a child.
   */
  public boolean isChild() {
    return nonNull(parent);
  }

  /**
   * Determines if the row is the root, meaning it has no parent.
   *
   * @return A boolean indicating if the row is a root row.
   */
  public boolean isRoot() {
    return isNull(parent);
  }

  /**
   * Use this field grouping to group the row fields when it is in edit mode.
   *
   * @return The default fields group for this row.
   */
  public FieldsGrouping getRowFieldsGroup() {
    if (isNull(rowFieldsGroup)) {
      rowFieldsGroup = FieldsGrouping.create();
    }
    return rowFieldsGroup;
  }

  /** @return true if this table should be allowed to be dragged. */
  public boolean isDraggable() {
    return draggable;
  }

  /**
   * Sets if the table row should be allowed to be dragged. the actual execution of this flag is
   * upon the implementation of the dragging operation the flag here is just to give the
   * implementation if the table should be dragged or not.
   *
   * @param draggable true to allow row dragging, false to prevent it.
   */
  public void setDraggable(boolean draggable) {
    this.draggable = draggable;
  }

  /**
   * Represents a function to render a TableRow.
   *
   * @param <T> The type of the data object for the row.
   */
  public interface RowRenderer<T> {

    /**
     * Render the specified TableRow in the given DataTable.
     *
     * @param dataTable The parent table containing the row.
     * @param tableRow The row to be rendered.
     */
    void render(DataTable<T> dataTable, TableRow<T> tableRow);
  }

  /** Default implementation of the RowRenderer interface. */
  private static class DefaultRowRenderer<T> implements RowRenderer<T> {

    /**
     * Render the specified TableRow in the given DataTable using the default rendering logic.
     *
     * @param dataTable The parent table containing the row.
     * @param tableRow The row to be rendered.
     */
    @Override
    public void render(DataTable<T> dataTable, TableRow<T> tableRow) {
      dataTable.getTableConfig().getColumns().forEach(tableRow::renderCell);
    }
  }
}
