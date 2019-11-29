package org.dominokit.domino.ui.datatable.plugins;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;
import elemental2.dom.MouseEvent;
import elemental2.dom.Node;
import jsinterop.base.Js;
import org.dominokit.domino.ui.datatable.*;
import org.dominokit.domino.ui.forms.CheckBox;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.keyboard.KeyboardEvents;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.Selectable;
import org.dominokit.domino.ui.utils.TextNode;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.stream.Collectors;

import static java.util.Objects.nonNull;
import static java.util.Objects.requireNonNull;

public class SelectionPlugin<T> implements DataTablePlugin<T> {

    private ColorScheme colorScheme;
    private Selectable<T> selectedRow;
    private HTMLElement singleSelectIndicator = Icons.ALL.check().asElement();
    private SelectionCondition<T> selectionCondition = (table, row) -> true;
    private TableRow<T> lastSelected;

    public SelectionPlugin() {
    }

    public SelectionPlugin(ColorScheme colorScheme) {
        this.colorScheme = colorScheme;
    }

    public SelectionPlugin(ColorScheme colorScheme, HTMLElement singleSelectIndicator) {
        this(colorScheme);
        this.singleSelectIndicator = singleSelectIndicator;
    }

    public SelectionPlugin(ColorScheme colorScheme, IsElement singleSelectIndicator) {
        this(colorScheme, singleSelectIndicator.asElement());
    }

    @Override
    public void onBeforeAddHeaders(DataTable<T> dataTable) {
        dataTable.getTableConfig().insertColumnFirst(ColumnConfig.<T>create("data-table-select-cm")
                .setSortable(false)
                .setWidth(dataTable.getTableConfig().isMultiSelect() ? "40px" : "45px")
                .setFixed(true)
                .setTooltipNode(DomGlobal.document.createTextNode("Select"))
                .setHeaderElement(columnTitle -> {
                    if (dataTable.getTableConfig().isMultiSelect()) {
                        return createMultiSelectHeader(dataTable);
                    } else {
                        return createSingleSelectHeader();
                    }
                })
                .setCellRenderer(cell -> {
                    if (selectionCondition.isAllowSelection(dataTable, cell.getTableRow())) {
                        if (dataTable.getTableConfig().isMultiSelect()) {
                            return createMultiSelectCell(dataTable, cell);
                        } else {
                            return createSingleSelectCell(dataTable, cell);
                        }
                    } else {
                        return TextNode.empty();
                    }

                }).asHeader());
    }

    private Node createSingleSelectHeader() {
        return singleSelectIndicator.cloneNode(true);
    }

    private Node createSingleSelectCell(DataTable<T> dataTable, CellRenderer.CellInfo<T> cell) {
        HTMLElement clonedIndicator = Js.uncheckedCast(singleSelectIndicator.cloneNode(true));
        cell.getTableRow().asElement().addEventListener("click", evt -> {
            if (selectionCondition.isAllowSelection(dataTable, cell.getTableRow())) {
                if (cell.getTableRow().isSelected()) {
                    cell.getTableRow().deselect();
                } else {
                    cell.getTableRow().select();
                }
                dataTable.onSelectionChange(cell.getTableRow());
            }
        });
        cell.getTableRow().addSelectionHandler(selectable -> {
            if (selectionCondition.isAllowSelection(dataTable, cell.getTableRow())) {
                if (selectable.isSelected()) {
                    if (nonNull(selectedRow)) {
                        selectedRow.deselect();
                    }
                    Style.of(clonedIndicator).setDisplay("inline-block");
                    if (nonNull(colorScheme)) {
                        Style.of(((TableRow<T>) selectable).asElement()).add(colorScheme.lighten_5().getBackground());
                    }
                    selectedRow = selectable;
                } else {
                    Style.of(clonedIndicator).setDisplay("none");
                    if (nonNull(colorScheme)) {
                        Style.of(((TableRow<T>) selectable).asElement()).remove(colorScheme.lighten_5().getBackground());
                    }
                    selectedRow = null;
                }
            }
        });
        Style.of(clonedIndicator).setDisplay("none");
        return clonedIndicator;
    }

    private Node createMultiSelectCell(DataTable<T> dataTable, CellRenderer.CellInfo<T> cell) {
        CheckBox checkBox = createCheckBox();

        TableRow<T> tableRow = cell.getTableRow();
        tableRow.addSelectionHandler(selectable -> {
            if (selectionCondition.isAllowSelection(dataTable, tableRow)) {
                if (selectable.isSelected()) {
                    checkBox.check(true);
                    if (nonNull(colorScheme)) {
                        Style.of(((TableRow<T>) selectable).asElement()).add(colorScheme.lighten_5().getBackground());
                    }
                } else {
                    checkBox.uncheck(true);
                    if (nonNull(colorScheme)) {
                        Style.of(((TableRow<T>) selectable).asElement()).remove(colorScheme.lighten_5().getBackground());
                    }
                }
            }
        });

        checkBox.addClickListener(evt -> {
            MouseEvent mouseEvent = Js.cast(evt);
            if (mouseEvent.shiftKey) {
                int startIndex = getStartSelectionIndex(dataTable);
                int endIndex = tableRow.getIndex();
                int increment = startIndex < endIndex ? 1 : -1;
                for (int i = startIndex; startIndex < endIndex ? i <= endIndex : i >= endIndex; i += increment) {
                    TableRow<T> row = dataTable.getItems()
                            .get(i);
                    selectRow(dataTable, row);
                }
            } else {
                this.lastSelected = tableRow;
            }
        });
        checkBox.addChangeHandler(checked -> {
            if (selectionCondition.isAllowSelection(dataTable, tableRow)) {
                if (checked) {
                    selectRow(dataTable, tableRow);
                } else {
                    tableRow.deselect();
                    if (nonNull(colorScheme)) {
                        Style.of(tableRow.asElement()).remove(colorScheme.lighten_5().getBackground());
                    }
                    dataTable.onSelectionChange(tableRow);
                }
            }
        });
        return checkBox.asElement();
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
        if (nonNull(colorScheme)) {
            Style.of(tableRow.asElement()).add(colorScheme.lighten_5().getBackground());
        }
        dataTable.onSelectionChange(tableRow);
    }

    private void deselectRow(DataTable<T> dataTable, TableRow<T> tableRow) {
        tableRow.deselect();
        if (nonNull(colorScheme)) {
            Style.of(tableRow.asElement()).remove(colorScheme.lighten_5().getBackground());
        }
        dataTable.onSelectionChange(tableRow);
    }

    private Node createMultiSelectHeader(DataTable<T> dataTable) {
        CheckBox checkBox = createCheckBox();
        checkBox.addChangeHandler(checked -> {
            if (checked) {
                dataTable.selectAll(selectionCondition);
            } else {
                dataTable.deselectAll(selectionCondition);
            }
        });

        dataTable.addSelectionListener((selectedRows, selectedRecords) -> {
            if (selectedRows.size() != dataTable.getItems()
                    .stream()
                    .filter(tableRow -> selectionCondition.isAllowSelection(dataTable, tableRow))
                    .count()) {
                checkBox.uncheck(true);
            } else {
                checkBox.check(true);
            }
        });
        return checkBox.asElement();
    }

    public SelectionPlugin<T> setSingleSelectIcon(BaseIcon<?> singleSelectIcon) {
        return this;
    }

    private CheckBox createCheckBox() {
        CheckBox checkBox = CheckBox.create();
        if (nonNull(colorScheme)) {
            checkBox.setColor(colorScheme.color());
        }
        Style.of(checkBox).add(DataTableStyles.SELECT_CHECKBOX);
        return checkBox;
    }

    public SelectionPlugin<T> setSelectionCondition(SelectionCondition<T> selectionCondition) {
        if (nonNull(selectionCondition)) {
            this.selectionCondition = selectionCondition;
        }
        return this;
    }
}