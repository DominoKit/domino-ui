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

package org.dominokit.domino.ui.datatable.plugins.selection;

import static java.util.Collections.singletonList;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.datatable.DataTableStyles.dui_datatable_row_selected;
import static org.dominokit.domino.ui.forms.FormsStyles.dui_form_select_check_box;

import elemental2.dom.Element;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;
import elemental2.dom.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;
import jsinterop.base.Js;
import org.dominokit.domino.ui.datatable.*;
import org.dominokit.domino.ui.datatable.events.OnBeforeDataChangeEvent;
import org.dominokit.domino.ui.datatable.events.TableDataUpdatedEvent;
import org.dominokit.domino.ui.datatable.plugins.DataTablePlugin;
import org.dominokit.domino.ui.forms.CheckBox;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.utils.DominoEvent;
import org.dominokit.domino.ui.utils.HasSelectionListeners;
import org.dominokit.domino.ui.utils.Register;
import org.dominokit.domino.ui.utils.Selectable;

/**
 * The `SelectionPlugin` class is a DataTable plugin that provides selection functionality for table
 * rows. It allows users to select one or multiple rows, and it provides options for customizing the
 * selection behavior.
 *
 * @param <T> The type of data in the DataTable rows.
 * @see DataTablePlugin
 */
public class SelectionPlugin<T> implements DataTablePlugin<T> {
  private Selectable<TableRow<T>> selectedRow;
  private Supplier<Element> singleSelectIndicator = () -> Icons.check().element();
  private SelectionCondition<T> selectionCondition = (table, row) -> true;
  private TableRow<T> lastSelected;
  private CheckBoxCreator<T> checkBoxCreator = tableRow -> CheckBox.create().addCss(dui_minified);
  private DataTable<T> datatable;
  private List<T> oldSelection = new ArrayList<>();
  private boolean retainSelectionOnDataChange = false;
  private CheckBox headerCheckBox;

  /** Creates a new `SelectionPlugin` with default settings. */
  public SelectionPlugin() {}

  /**
   * Creates a new `SelectionPlugin` with a custom single select indicator element.
   *
   * @param singleSelectIndicator A supplier for the single select indicator element.
   */
  public SelectionPlugin(Supplier<Element> singleSelectIndicator) {
    this();
    this.singleSelectIndicator = singleSelectIndicator;
  }

  /**
   * Indicates whether this plugin requires a utility column in the DataTable. It returns `true`
   * since it adds selection checkboxes to utility columns.
   *
   * @return `true` since this plugin requires a utility column.
   */
  @Override
  public boolean requiresUtilityColumn() {
    return true;
  }

  /**
   * Returns a list of utility elements to be added to utility columns for a specific cell.
   *
   * @param dataTable The DataTable to which this plugin is applied.
   * @param cellInfo The cell information containing the cell content and metadata.
   * @return An optional list of utility elements, empty if none.
   */
  @Override
  public Optional<List<HTMLElement>> getUtilityElements(
      DataTable<T> dataTable, CellRenderer.CellInfo<T> cellInfo) {
    if (selectionCondition.isAllowSelection(dataTable, cellInfo.getTableRow())) {
      if (dataTable.getTableConfig().isMultiSelect()) {
        return Optional.of(singletonList(createMultiSelectCell(dataTable, cellInfo)));
      } else {
        return Optional.of(
            singletonList(
                div()
                    .setMinWidth("24px")
                    .appendChild(createSingleSelectCell(dataTable, cellInfo))
                    .element()));
      }
    }
    return Optional.empty();
  }

  /**
   * This method is called after the DataTable has been added, allowing the plugin to access and
   * reference the DataTable.
   *
   * @param dataTable The DataTable instance to which this plugin is applied.
   */
  @Override
  public void onAfterAddTable(DataTable<T> dataTable) {
    this.datatable = dataTable;
  }

  /**
   * Handles the addition of headers to the DataTable. In this case, it adds the selection indicator
   * to the utility column header.
   *
   * @param dataTable The DataTable to which this plugin is applied.
   * @param column The column configuration to which the header is added.
   */
  @Override
  public void onHeaderAdded(DataTable<T> dataTable, ColumnConfig<T> column) {
    if (column.isUtilityColumn()) {
      if (dataTable.getTableConfig().isMultiSelect()) {
        column.appendChild(
            div().addCss(dui_order_20).appendChild(createMultiSelectHeader(dataTable)));
      } else {
        column.appendChild(div().addCss(dui_order_20).appendChild(createSingleSelectHeader()));
      }
    }
  }

  /**
   * Creates the selection indicator element for a single selection.
   *
   * @return The selection indicator element.
   */
  private Element createSingleSelectHeader() {
    return singleSelectIndicator.get();
  }

  /**
   * Creates the selection indicator element for a single selection cell.
   *
   * @param dataTable The DataTable to which this plugin is applied.
   * @param cell The cell information containing the cell content and metadata.
   * @return The selection indicator element for a single selection cell.
   */
  private Element createSingleSelectCell(DataTable<T> dataTable, CellRenderer.CellInfo<T> cell) {
    Element clonedIndicator = Js.uncheckedCast(singleSelectIndicator.get());
    elementOf(clonedIndicator).addCss(dui_fg_accent);

    EventListener clickListener =
        evt -> {
          if (selectionCondition.isAllowSelection(dataTable, cell.getTableRow())) {
            if (cell.getTableRow().isSelected()) {
              cell.getTableRow().deselect();
            } else {
              cell.getTableRow().select();
            }
          }
        };

    cell.getTableRow()
        .onAttached(
            mutationRecord -> {
              cell.getTableRow().addEventListener("click", clickListener);
            });
    cell.getTableRow()
        .onDetached(
            mutationRecord -> {
              cell.getTableRow().removeEventListener("click", clickListener);
            });
    cell.getTableRow()
        .addSelectionListener(
            (source, row) -> {
              if (selectionCondition.isAllowSelection(dataTable, cell.getTableRow())) {
                if (nonNull(this.selectedRow) && !Objects.equals(this.selectedRow, row)) {
                  this.selectedRow.deselect();
                }
                this.selectedRow = row;
                elementOf(clonedIndicator).show();
                row.addCss(dui_datatable_row_selected);
              }
            })
        .addDeselectionListener(
            (source, row) -> {
              if (selectionCondition.isAllowSelection(dataTable, cell.getTableRow())) {
                elementOf(clonedIndicator).hide();
                row.removeCss(dui_datatable_row_selected);
              }
            });
    elementOf(clonedIndicator).toggleDisplay(cell.getTableRow().isSelected());
    return clonedIndicator;
  }

  /**
   * Creates the selection indicator element for a multi-selection cell.
   *
   * @param dataTable The DataTable to which this plugin is applied.
   * @param cell The cell information containing the cell content and metadata.
   * @return The selection indicator element for a multi-selection cell.
   */
  private HTMLElement createMultiSelectCell(DataTable<T> dataTable, CellRenderer.CellInfo<T> cell) {
    CheckBox checkBox = createCheckBox(Optional.ofNullable(cell.getTableRow()));

    TableRow<T> tableRow = cell.getTableRow();
    if (tableRow.isSelected()) {
      checkBox.check(true);
    }
    HasSelectionListeners.SelectionListener<TableRow<T>, TableRow<T>> selectionListener =
        (source, selectable) -> {
          if (selectionCondition.isAllowSelection(dataTable, tableRow)) {
            checkBox.check(true);
            selectable.addCss(dui_datatable_row_selected);
          }
        };

    HasSelectionListeners.SelectionListener<TableRow<T>, TableRow<T>> deselectionListener =
        (source, selectable) -> {
          if (selectionCondition.isAllowSelection(dataTable, tableRow)) {
            checkBox.uncheck(true);
            selectable.removeCss(dui_datatable_row_selected);
          }
        };

    EventListener clickListener =
        evt -> {
          MouseEvent mouseEvent = Js.cast(evt);
          if (mouseEvent.shiftKey) {
            int startIndex = getStartSelectionIndex(dataTable);
            int endIndex = tableRow.getIndex();
            int increment = startIndex < endIndex ? 1 : -1;
            for (int i = startIndex;
                startIndex < endIndex ? i <= endIndex : i >= endIndex;
                i += increment) {
              TableRow<T> row = dataTable.getRows().get(i);
              selectRow(dataTable, row);
            }
          } else {
            this.lastSelected = tableRow;
          }
        };
    Register onAttach =
        checkBox.registerOnAttached(mutationRecord -> checkBox.addClickListener(clickListener));
    Register onDetach =
        checkBox.registerOnDetached(mutationRecord -> checkBox.removeClickListener(clickListener));

    tableRow.onAttached(
        mutationRecord -> {
          tableRow.addSelectionListener(selectionListener);
          tableRow.addDeselectionListener(deselectionListener);
        });

    tableRow.onDetached(
        mutationRecord -> {
          tableRow.removeSelectionListener(selectionListener);
          tableRow.removeDeselectionListener(deselectionListener);
          onAttach.remove();
          onDetach.remove();
        });

    checkBox.addChangeListener(
        (oldValue, checked) -> {
          if (selectionCondition.isAllowSelection(dataTable, tableRow)) {
            if (checked) {
              selectRow(dataTable, tableRow);
            } else {
              tableRow.deselect();
              tableRow.removeCss(dui_datatable_row_selected);
            }
          }
        });
    return checkBox.setAttribute("order", "20").element();
  }

  /**
   * Gets the index of the first selected row for use with shift-click selection.
   *
   * @param dataTable The DataTable to which this plugin is applied.
   * @return The index of the first selected row.
   */
  private int getStartSelectionIndex(DataTable<T> dataTable) {
    if (nonNull(lastSelected)) {
      return lastSelected.getIndex();
    } else {
      if (dataTable.getSelectedItems().isEmpty()) {
        return 0;
      } else {
        return dataTable.getSelectedItems().get(0).getIndex();
      }
    }
  }

  /**
   * Selects a row in the DataTable.
   *
   * @param dataTable The DataTable to which this plugin is applied.
   * @param tableRow The row to select.
   */
  private void selectRow(DataTable<T> dataTable, TableRow<T> tableRow) {
    tableRow.select();
    tableRow.addCss(dui_datatable_row_selected);
  }

  /**
   * Deselects a row in the DataTable.
   *
   * @param dataTable The DataTable to which this plugin is applied.
   * @param tableRow The row to deselect.
   */
  private void deselectRow(DataTable<T> dataTable, TableRow<T> tableRow) {
    tableRow.deselect();
    tableRow.removeCss(dui_datatable_row_selected);
  }

  /**
   * Creates the selection indicator element for a multi-selection header.
   *
   * @param dataTable The DataTable to which this plugin is applied.
   * @return The selection indicator element for a multi-selection header.
   */
  private HTMLElement createMultiSelectHeader(DataTable<T> dataTable) {
    headerCheckBox = createCheckBox(Optional.empty());
    headerCheckBox.addChangeListener(
        (oldValue, checked) -> {
          if (checked) {
            dataTable.selectAll(selectionCondition);
          } else {
            dataTable.deselectAll(selectionCondition);
          }
        });

    dataTable.addSelectionDeselectionListener(
        (source, selectedRows) -> {
          updateHeaderCheckBox(selectedRows);
        });

    return headerCheckBox.element();
  }

  private void updateHeaderCheckBox(List<TableRow<T>> selectedRows) {
    long selectableCount =
        this.datatable.getRows().stream()
            .filter(tableRow -> selectionCondition.isAllowSelection(this.datatable, tableRow))
            .count();
    if (selectedRows.size() > 0 && selectedRows.size() < selectableCount) {
      headerCheckBox.indeterminate();
    } else if (selectedRows.size() == selectableCount) {
      headerCheckBox.check(true);
    } else if (selectedRows.isEmpty()) {
      headerCheckBox.uncheck(true);
    }
  }

  /**
   * Sets the single selection indicator using a supplier of icons.
   *
   * @param singleSelectIcon A supplier for the single selection indicator icon.
   * @return This `SelectionPlugin` instance for method chaining.
   */
  public SelectionPlugin<T> setSingleSelectIcon(Supplier<Icon<?>> singleSelectIcon) {
    this.singleSelectIndicator = () -> singleSelectIcon.get().element();
    return this;
  }

  private CheckBox createCheckBox(Optional<TableRow<T>> tableRow) {
    CheckBox checkBox = checkBoxCreator.get(tableRow);
    checkBox.addCss(dui_form_select_check_box, dui_hide_label);
    return checkBox;
  }

  /**
   * Sets the selection condition for rows in the DataTable.
   *
   * @param selectionCondition A function that determines whether a row is selectable.
   * @return This `SelectionPlugin` instance for method chaining.
   */
  public SelectionPlugin<T> setSelectionCondition(SelectionCondition<T> selectionCondition) {
    if (nonNull(selectionCondition)) {
      this.selectionCondition = selectionCondition;
    }
    return this;
  }

  /**
   * Sets whether to retain row selection on data changes in the DataTable.
   *
   * @param retainSelectionOnDataChange `true` to retain row selection, `false` otherwise.
   * @return This `SelectionPlugin` instance for method chaining.
   */
  public SelectionPlugin<T> setRetainSelectionOnDataChange(boolean retainSelectionOnDataChange) {
    this.retainSelectionOnDataChange = retainSelectionOnDataChange;
    return this;
  }

  /**
   * Handles the addition of a row to the DataTable. If selection retention is enabled and the row
   * was previously selected, it re-selects the row.
   *
   * @param dataTable The DataTable to which this plugin is applied.
   * @param tableRow The row to be added.
   */
  @Override
  public void onRowAdded(DataTable<T> dataTable, TableRow<T> tableRow) {
    if (retainSelectionOnDataChange) {
      if (nonNull(oldSelection)
          && !oldSelection.isEmpty()
          && oldSelection.contains(tableRow.getRecord())) {
        if (isNull(selectionCondition)
            || selectionCondition.isAllowSelection(dataTable, tableRow)) {
          tableRow.select();
        }
      }
    }
  }

  /**
   * Handles DataTable events, specifically retaining the selection on data change events.
   *
   * @param event The DataTable event.
   */
  @Override
  public void handleEvent(DominoEvent event) {
    if (retainSelectionOnDataChange) {
      if (OnBeforeDataChangeEvent.ON_BEFORE_DATA_CHANGE.equals(event.getType())) {
        this.oldSelection = this.datatable.getSelectedRecords();
      }
    }

    if (TableDataUpdatedEvent.DATA_UPDATED.equals(event.getType())) {
      if (this.datatable.getTableConfig().isMultiSelect()) {
        updateHeaderCheckBox(this.datatable.getSelectedItems());
      }
    }
  }

  /**
   * Sets a custom CheckBox creator for multi-selection cells.
   *
   * @param checkBoxCreator A custom CheckBox creator.
   * @return This `SelectionPlugin` instance for method chaining.
   */
  public SelectionPlugin<T> setCheckBoxCreator(CheckBoxCreator<T> checkBoxCreator) {
    if (nonNull(checkBoxCreator)) {
      this.checkBoxCreator = checkBoxCreator;
    }
    return this;
  }

  /**
   * Functional interface for creating a CheckBox for a row.
   *
   * @param <T> The type of data in the DataTable rows.
   */
  public interface CheckBoxCreator<T> {
    CheckBox get(Optional<TableRow<T>> row);
  }
}
