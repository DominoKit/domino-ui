package org.dominokit.domino.ui.datatable.plugins;

import elemental2.dom.Text;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableRow;
import org.dominokit.domino.ui.forms.CheckBox;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.style.Style;

import static java.util.Objects.nonNull;

public class SelectionPlugin<T> implements DataTablePlugin<T> {

    private ColorScheme colorScheme;

    public SelectionPlugin() {
    }

    public SelectionPlugin(ColorScheme colorScheme) {
        this.colorScheme = colorScheme;
    }

    @Override
    public void onBeforeAddHeaders(DataTable<T> dataTable) {
        dataTable.getTableConfig().insertColumnFirst(ColumnConfig.<T>create("data-table-select-cm")
                .setSortable(false)
                .setWidth("40px")
                .setFixed(true)
        .setHeaderElement(columnTitle -> {
            if(dataTable.isMultiSelect()){
                CheckBox checkBox = createCheckBox();
                checkBox.addCheckHandler(checked -> {
                    if(checked){
                        dataTable.selectAll();
                    }else{
                        dataTable.deselectAll();
                    }
                });

                dataTable.addSelectionListener((selectedRows, selectedRecords) -> {
                    if(selectedRows.size()!=dataTable.getTableRows().size()){
                        checkBox.uncheck(true);
                    }else{
                        checkBox.check(true);
                    }
                });
                return checkBox.asElement();
            }else{
                return new Text("");
            }

        })
        .setCellRenderer(cell -> {
            CheckBox checkBox = createCheckBox();

            cell.getTableRow().addSelectionHandler(selectable -> {
                if(selectable.isSelected()){
                    checkBox.check(true);
                    if(nonNull(colorScheme)){
                        Style.of(((TableRow<T>)selectable).asElement()).css(colorScheme.lighten_5().getBackground());
                    }
                }else{
                    checkBox.uncheck(true);
                    if(nonNull(colorScheme)){
                        Style.of(((TableRow<T>)selectable).asElement()).removeClass(colorScheme.lighten_5().getBackground());
                    }
                }
            });

            checkBox.addCheckHandler(checked -> {
                if(checked){
                    cell.getTableRow().select();
                    if(nonNull(colorScheme)){
                        Style.of(cell.getTableRow().asElement()).css(colorScheme.lighten_5().getBackground());
                    }
                    dataTable.onSelectionChange(cell.getTableRow());
                }else{
                    cell.getTableRow().deselect();
                    if(nonNull(colorScheme)){
                        Style.of(cell.getTableRow().asElement()).removeClass(colorScheme.lighten_5().getBackground());
                    }
                    dataTable.onSelectionChange(cell.getTableRow());
                }
            });
            return checkBox.asElement();
        }).asHeader());
    }

    private CheckBox createCheckBox() {
        CheckBox checkBox = CheckBox.create();
        if(nonNull(colorScheme)){
            checkBox.setColor(colorScheme.color());
        }
        Style.of(checkBox).setMargin("0px");
        Style.of(checkBox.getInputElement()).setMargin("0px");
        Style.of(checkBox.getLabelElement())
                .css("table-checkbox")
                .setMargin("0px")
                .setHeight("20px");
        return checkBox;
    }

}
