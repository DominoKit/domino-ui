package org.dominokit.domino.ui.datatable.plugins;

import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLTableCellElement;
import elemental2.dom.HTMLTableRowElement;
import elemental2.dom.HTMLTableSectionElement;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableConfig;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.gwt.elemento.core.builder.HtmlContentBuilder;

import java.util.List;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.th;
import static org.jboss.gwt.elemento.core.Elements.tr;

public class ColumnHeaderFilterPlugin<T> implements DataTablePlugin<T> {

    @Override
    public void onAfterAddHeaders(DataTable<T> dataTable) {
        HtmlContentBuilder<HTMLTableRowElement> tr = tr();
        TableConfig<T> tableConfig = dataTable.getTableConfig();
        List<ColumnConfig<T>> columns = tableConfig.getColumns();
        DominoElement<HTMLTableSectionElement> thead = dataTable.headerElement();
        thead.appendChild(tr.asElement());

        columns.forEach(columnConfig -> {

            HtmlContentBuilder<HTMLTableCellElement> th = th().css("table-cm-filter")
                    .add(TextBox.create()
                            .apply(element -> {
                                element.getLeftAddonContainer().collapse();
                                element.getRightAddonContainer().collapse();
                            })
                            .setPlaceholder("Search")
                            .styler(style -> style.setMarginBottom("0px")));
            tr.add(th);

            if (dataTable.getTableConfig().isFixed() || columnConfig.isFixed()) {
                fixElementWidth(columnConfig, th.asElement());
            }
        });

        dataTable.tableElement().appendChild(thead);
    }

    private void fixElementWidth(ColumnConfig<T> column, HTMLElement element) {
        String fixedWidth = bestFitWidth(column);
        Style.of(element)
                .setWidth(fixedWidth)
                .setMinWidth(fixedWidth)
                .setMaxWidth(fixedWidth)
                .setProperty("overflow", "hidden")
                .setProperty("text-overflow", "ellipsis")
                .setProperty("white-space", "nowrap");

    }

    String bestFitWidth(ColumnConfig<T> columnConfig) {
        if (nonNull(columnConfig.getWidth()) && !columnConfig.getWidth().isEmpty()) {
            return columnConfig.getWidth();
        } else if (nonNull(columnConfig.getMinWidth()) && !columnConfig.getMinWidth().isEmpty()) {
            return columnConfig.getMinWidth();
        } else if (nonNull(columnConfig.getMaxWidth()) && !columnConfig.getMaxWidth().isEmpty()) {
            return columnConfig.getMaxWidth();
        } else {
            return "100px";
        }
    }
}
