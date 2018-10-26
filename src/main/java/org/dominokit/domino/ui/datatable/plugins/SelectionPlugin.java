package org.dominokit.domino.ui.datatable.plugins;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import jsinterop.base.Js;
import org.dominokit.domino.ui.datatable.CellRenderer;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableRow;
import org.dominokit.domino.ui.forms.CheckBox;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.Selectable;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.nonNull;

public class SelectionPlugin<T> implements DataTablePlugin<T> {

    private ColorScheme colorScheme;
    private Selectable<T> selectedRow;
    private HTMLElement singleSelectIndicator = Icons.ALL.check().asElement();

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
                    if (dataTable.getTableConfig().isMultiSelect()) {
                        return createMultiSelectCell(dataTable, cell);
                    } else {
                        return createSingleSelectCell(dataTable, cell);
                    }
                }).asHeader());
    }

    private Node createSingleSelectHeader() {
        return singleSelectIndicator.cloneNode(true);
    }

    private Node createSingleSelectCell(DataTable<T> dataTable, CellRenderer.CellInfo<T> cell) {
        HTMLElement clonedIndicator = Js.uncheckedCast(singleSelectIndicator.cloneNode(true));
        cell.getTableRow().asElement().addEventListener("click", evt -> {
            cell.getTableRow().select();
            dataTable.onSelectionChange(cell.getTableRow());
        });
        cell.getTableRow().addSelectionHandler(selectable -> {
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
            }
        });
        Style.of(clonedIndicator).setDisplay("none");
        return clonedIndicator;
    }

    private Node createMultiSelectCell(DataTable<T> dataTable, CellRenderer.CellInfo<T> cell) {
        CheckBox checkBox = createCheckBox();

        cell.getTableRow().addSelectionHandler(selectable -> {
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
        });

        checkBox.addChangeHandler(checked -> {
            if (checked) {
                cell.getTableRow().select();
                if (nonNull(colorScheme)) {
                    Style.of(cell.getTableRow().asElement()).add(colorScheme.lighten_5().getBackground());
                }
                dataTable.onSelectionChange(cell.getTableRow());
            } else {
                cell.getTableRow().deselect();
                if (nonNull(colorScheme)) {
                    Style.of(cell.getTableRow().asElement()).remove(colorScheme.lighten_5().getBackground());
                }
                dataTable.onSelectionChange(cell.getTableRow());
            }
        });
        return checkBox.asElement();
    }

    private Node createMultiSelectHeader(DataTable<T> dataTable) {
        CheckBox checkBox = createCheckBox();
        checkBox.addChangeHandler(checked -> {
            if (checked) {
                dataTable.selectAll();
            } else {
                dataTable.deselectAll();
            }
        });

        dataTable.addSelectionListener((selectedRows, selectedRecords) -> {
            if (selectedRows.size() != dataTable.getItems().size()) {
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
        Style.of(checkBox).add("select-checkbox");
        return checkBox;
    }

}
