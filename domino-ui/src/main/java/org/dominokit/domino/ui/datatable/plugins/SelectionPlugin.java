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
package org.dominokit.domino.ui.datatable.plugins;

import elemental2.dom.Element;
import elemental2.dom.HTMLElement;
import elemental2.dom.MouseEvent;
import jsinterop.base.Js;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.datatable.CellRenderer;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.DataTableStyles;
import org.dominokit.domino.ui.datatable.SelectionCondition;
import org.dominokit.domino.ui.datatable.TableConfig;
import org.dominokit.domino.ui.datatable.TableRow;
import org.dominokit.domino.ui.datatable.events.OnBeforeDataChangeEvent;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.forms.CheckBox;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Style;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import static java.util.Collections.singletonList;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * This plugin allow selecting/deselecting single or multiple rows based on the {@link
 * TableConfig#isMultiSelect()} and fires table selection change events when the user changes the
 * selection.
 *
 * @param <T> the type of the data table records
 */
public class SelectionPlugin<T> implements DataTablePlugin<T> {

    private TableRow<T> selectedRow;
    private Element singleSelectIndicator = Icons.ALL.check_mdi().element();
    private SelectionCondition<T> selectionCondition = (table, row) -> true;
    private TableRow<T> lastSelected;
    private CheckBoxCreator<T> checkBoxCreator = tableRow -> CheckBox.create();
    private DataTable<T> datatable;
    private List<T> oldSelection = new ArrayList<>();
    private boolean retainSelectionOnDataChange = false;

    /**
     * creates an instance with default configurations
     */
    public SelectionPlugin() {
    }


    /**
     * create an instance that changes the selected row background color and use a custom selection
     * indicator icon
     *
     * @param singleSelectIndicator {@link HTMLElement} to use a selection indicator
     */
    public SelectionPlugin(Element singleSelectIndicator) {
        this.singleSelectIndicator = singleSelectIndicator;
    }

    /**
     * create an instance that changes the selected row background color and use a custom selection
     * indicator icon
     *
     * @param singleSelectIndicator {@link IsElement} to use a selection indicator
     */
    public SelectionPlugin(IsElement<?> singleSelectIndicator) {
        this(singleSelectIndicator.element());
    }

    @Override
    public boolean requiresUtilityColumn() {
        return true;
    }

    @Override
    public Optional<List<HTMLElement>> getUtilityElements(
            DataTable<T> dataTable, CellRenderer.CellInfo<T> cellInfo) {
        if (selectionCondition.isAllowSelection(dataTable, cellInfo.getTableRow())) {
            if (dataTable.getTableConfig().isMultiSelect()) {
                return Optional.of(singletonList(createMultiSelectCell(dataTable, cellInfo)));
            } else {
                return Optional.of(
                        singletonList(
                                elements.div()
                                        .setMinWidth("24px")
                                        .appendChild(createSingleSelectCell(dataTable, cellInfo))
                                        .element()));
            }
        }
        return Optional.empty();
    }

    @Override
    public void onAfterAddTable(DataTable<T> dataTable) {
        this.datatable = dataTable;
    }

    @Override
    public void onHeaderAdded(DataTable<T> dataTable, ColumnConfig<T> column) {
        if (column.isUtilityColumn()) {
            if (dataTable.getTableConfig().isMultiSelect()) {
                column
                        .getHeaderLayout()
                        .appendChild(
                                FlexItem.create().setOrder(20).appendChild(createMultiSelectHeader(dataTable)));
            } else {
                column
                        .getHeaderLayout()
                        .appendChild(FlexItem.create().setOrder(20).appendChild(createSingleSelectHeader()));
            }
        }
    }

    private HTMLElement createSingleSelectHeader() {
        return (HTMLElement) singleSelectIndicator.cloneNode(true);
    }

    private HTMLElement createSingleSelectCell(
            DataTable<T> dataTable, CellRenderer.CellInfo<T> cell) {
        HTMLElement clonedIndicator = Js.uncheckedCast(singleSelectIndicator.cloneNode(true));
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
                                dataTable.onSelectionChange(cell.getTableRow());
                            }
                        });
        cell.getTableRow()
                .addSelectionListener((source, selection) -> {
                    if (selectionCondition.isAllowSelection(dataTable, cell.getTableRow())) {
                        if (source.isPresent() && source.get().isSelected()) {
                            if (nonNull(selectedRow)) {
                                selectedRow.deselect();
                            }
                            Style.of(clonedIndicator).setDisplay("inline-block");

                            selectedRow = source.get();
                        } else {
                            Style.of(clonedIndicator).setDisplay("none");

                            selectedRow = null;
                        }
                    }
                });

        Style.of(clonedIndicator).setDisplay("none");
        return clonedIndicator;
    }

    private HTMLElement createMultiSelectCell(DataTable<T> dataTable, CellRenderer.CellInfo<T> cell) {
        CheckBox checkBox = createCheckBox(Optional.ofNullable(cell.getTableRow()));

        TableRow<T> tableRow = cell.getTableRow();
        tableRow
                .addSelectionListener((source, selection) -> {
                    if (selectionCondition.isAllowSelection(dataTable, tableRow)) {
                        if (source.isPresent() && source.get().isSelected()) {
                            checkBox.check(true);

                        } else {
                            checkBox.uncheck(true);

                        }
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
        checkBox
                .addChangeListener((oldValue, newValue) -> {
                    if (selectionCondition.isAllowSelection(dataTable, tableRow)) {
                        if (newValue) {
                            selectRow(dataTable, tableRow);
                        } else {
                            tableRow.deselect();

                            dataTable.onSelectionChange(tableRow);
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

        dataTable.onSelectionChange(tableRow);
    }

    private void deselectRow(DataTable<T> dataTable, TableRow<T> tableRow) {
        tableRow.deselect();

        dataTable.onSelectionChange(tableRow);
    }

    private HTMLElement createMultiSelectHeader(DataTable<T> dataTable) {
        CheckBox checkBox = createCheckBox(Optional.empty());
        checkBox
                .addChangeListener((oldValue, newValue) -> {
                    if (newValue) {
                        dataTable.selectAll(selectionCondition);
                    } else {
                        dataTable.deselectAll(selectionCondition);
                    }
                });

        dataTable.addSelectionListener(
                (selectedRows, selectedRecords) -> {
                    if (selectedRows.size()
                            != dataTable.getRows().stream()
                            .filter(tableRow -> selectionCondition.isAllowSelection(dataTable, tableRow))
                            .count()) {
                        checkBox.uncheck(true);
                    } else {
                        checkBox.check(true);
                    }
                });
        return checkBox.element();
    }

    /**
     * Change the single selection indicator icon
     *
     * @param singleSelectIcon {@link Icon}
     * @return same plugin instance
     */
    public SelectionPlugin<T> setSingleSelectIcon(Icon<?> singleSelectIcon) {
        return this;
    }

    private CheckBox createCheckBox(Optional<TableRow<T>> tableRow) {
        CheckBox checkBox = checkBoxCreator.get(tableRow);
        checkBox.addCss(DataTableStyles.SELECT_CHECKBOX);
        return checkBox;
    }

    /**
     * Set a condition to use to determine if a row should be selectable or not
     *
     * @param selectionCondition {@link SelectionCondition}
     * @return Same plugin instance
     */
    public SelectionPlugin<T> setSelectionCondition(SelectionCondition<T> selectionCondition) {
        if (nonNull(selectionCondition)) {
            this.selectionCondition = selectionCondition;
        }
        return this;
    }

    /**
     * If set to true any record that was originally selected, will remain selected after data
     * change
     * if it is present in the ew data set
     *
     * @param retainSelectionOnDataChange boolean , true to retain selection and false to ignore old
     *                                    selection
     * @return Same plugin instance
     */
    public SelectionPlugin<T> setRetainSelectionOnDataChange(boolean retainSelectionOnDataChange) {
        this.retainSelectionOnDataChange = retainSelectionOnDataChange;
        return this;
    }

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
     * @param checkBoxCreator {@link Supplier} of {@link CheckBox}
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
