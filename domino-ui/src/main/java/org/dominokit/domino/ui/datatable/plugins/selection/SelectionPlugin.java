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
import elemental2.dom.HTMLElement;
import elemental2.dom.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import jsinterop.base.Js;
import org.dominokit.domino.ui.datatable.*;
import org.dominokit.domino.ui.datatable.events.OnBeforeDataChangeEvent;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.datatable.plugins.DataTablePlugin;
import org.dominokit.domino.ui.forms.CheckBox;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.utils.Selectable;

/**
 * This plugin allow selecting/deselecting single or multiple rows based on the {@link
 * TableConfig#isMultiSelect()} and fires table selection change events when the user changes the
 * selection.
 *
 * @param <T> the type of the data table records
 * @author vegegoku
 * @version $Id: $Id
 */
public class SelectionPlugin<T> implements DataTablePlugin<T> {
  private Selectable<TableRow<T>> selectedRow;
  private Supplier<Element> singleSelectIndicator = () -> Icons.check().element();
  private SelectionCondition<T> selectionCondition = (table, row) -> true;
  private TableRow<T> lastSelected;
  private CheckBoxCreator<T> checkBoxCreator = tableRow -> CheckBox.create();
  private DataTable<T> datatable;
  private List<T> oldSelection = new ArrayList<>();
  private boolean retainSelectionOnDataChange = false;

  /** creates an instance with default configurations */
  public SelectionPlugin() {}

  /**
   * create an instance that changes the selected row background color and use a custom selection
   * indicator icon
   *
   * @param singleSelectIndicator {@link elemental2.dom.HTMLElement} to use a selection indicator
   */
  public SelectionPlugin(Supplier<Element> singleSelectIndicator) {
    this();
    this.singleSelectIndicator = singleSelectIndicator;
  }

  /** {@inheritDoc} */
  @Override
  public boolean requiresUtilityColumn() {
    return true;
  }

  /** {@inheritDoc} */
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

  /** {@inheritDoc} */
  @Override
  public void onAfterAddTable(DataTable<T> dataTable) {
    this.datatable = dataTable;
  }

  /** {@inheritDoc} */
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

  private Element createSingleSelectHeader() {
    return singleSelectIndicator.get();
  }

  private Element createSingleSelectCell(DataTable<T> dataTable, CellRenderer.CellInfo<T> cell) {
    Element clonedIndicator = Js.uncheckedCast(singleSelectIndicator.get());
    elementOf(clonedIndicator).addCss(dui_fg_accent);
    cell.getTableRow()
        .element()
        .addEventListener(
            "click",
            evt -> {
              if (selectionCondition.isAllowSelection(dataTable, cell.getTableRow())) {
                if (cell.getTableRow().isSelected()) {
                  cell.getTableRow().deselect();
                } else {
                  cell.getTableRow().select();
                }
              }
            });
    cell.getTableRow()
        .addSelectionListener(
            (source, row) -> {
              if (selectionCondition.isAllowSelection(dataTable, cell.getTableRow())) {
                if (nonNull(this.selectedRow)) {
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

  private HTMLElement createMultiSelectCell(DataTable<T> dataTable, CellRenderer.CellInfo<T> cell) {
    CheckBox checkBox = createCheckBox(Optional.ofNullable(cell.getTableRow()));

    TableRow<T> tableRow = cell.getTableRow();
    if (tableRow.isSelected()) {
      checkBox.check(true);
    }
    tableRow.addSelectionListener(
        (source, selectable) -> {
          if (selectionCondition.isAllowSelection(dataTable, tableRow)) {
            checkBox.check(true);
            selectable.addCss(dui_datatable_row_selected);
          }
        });
    tableRow.addDeselectionListener(
        (source, selectable) -> {
          if (selectionCondition.isAllowSelection(dataTable, tableRow)) {
            checkBox.uncheck(true);
            selectable.removeCss(dui_datatable_row_selected);
          }
        });

    checkBox.addClickListener(
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

  private void selectRow(DataTable<T> dataTable, TableRow<T> tableRow) {
    tableRow.select();
    tableRow.addCss(dui_datatable_row_selected);
  }

  private void deselectRow(DataTable<T> dataTable, TableRow<T> tableRow) {
    tableRow.deselect();
    tableRow.removeCss(dui_datatable_row_selected);
  }

  private HTMLElement createMultiSelectHeader(DataTable<T> dataTable) {
    CheckBox checkBox = createCheckBox(Optional.empty());
    checkBox.addChangeListener(
        (oldValue, checked) -> {
          if (checked) {
            dataTable.selectAll(selectionCondition);
          } else {
            dataTable.deselectAll(selectionCondition);
          }
        });

    dataTable.addSelectionDeselectionListener(
        (source, selectedRows) -> {
          long selectableCount =
              dataTable.getRows().stream()
                  .filter(tableRow -> selectionCondition.isAllowSelection(dataTable, tableRow))
                  .count();
          if (selectedRows.size() > 0 && selectedRows.size() < selectableCount) {
            checkBox.indeterminate();
          } else if (selectedRows.size() == selectableCount) {
            checkBox.check(true);
          } else if (selectedRows.isEmpty()) {
            checkBox.uncheck(true);
          }
        });

    return checkBox.element();
  }

  /**
   * Change the single selection indicator icon
   *
   * @param singleSelectIcon {@link org.dominokit.domino.ui.icons.Icon}
   * @return same plugin instance
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
   * Set a condition to use to determine if a row should be selectable or not
   *
   * @param selectionCondition {@link org.dominokit.domino.ui.datatable.SelectionCondition}
   * @return Same plugin instance
   */
  public SelectionPlugin<T> setSelectionCondition(SelectionCondition<T> selectionCondition) {
    if (nonNull(selectionCondition)) {
      this.selectionCondition = selectionCondition;
    }
    return this;
  }

  /**
   * If set to true any record that was originally selected, will remain selected after data change
   * if it is present in the ew data set
   *
   * @param retainSelectionOnDataChange boolean , true to retain selection and false to ignore old
   *     selection
   * @return Same plugin instance
   */
  public SelectionPlugin<T> setRetainSelectionOnDataChange(boolean retainSelectionOnDataChange) {
    this.retainSelectionOnDataChange = retainSelectionOnDataChange;
    return this;
  }

  /** {@inheritDoc} */
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

  /** {@inheritDoc} */
  @Override
  public void handleEvent(TableEvent event) {
    if (retainSelectionOnDataChange) {
      if (OnBeforeDataChangeEvent.ON_BEFORE_DATA_CHANGE.equals(event.getType())) {
        this.oldSelection = this.datatable.getSelectedRecords();
      }
    }
  }

  /**
   * A setter to give the user the ability to customize the selection checkbox
   *
   * @param checkBoxCreator {@link java.util.function.Supplier} of {@link
   *     org.dominokit.domino.ui.forms.CheckBox}
   * @return same plugin instance
   */
  public SelectionPlugin<T> setCheckBoxCreator(CheckBoxCreator<T> checkBoxCreator) {
    if (nonNull(checkBoxCreator)) {
      this.checkBoxCreator = checkBoxCreator;
    }
    return this;
  }

  public interface CheckBoxCreator<T> {
    CheckBox get(Optional<TableRow<T>> row);
  }
}
