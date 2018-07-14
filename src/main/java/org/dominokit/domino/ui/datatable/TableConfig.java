package org.dominokit.domino.ui.datatable;

import elemental2.dom.*;
import org.dominokit.domino.ui.datatable.plugins.DataTablePlugin;
import org.dominokit.domino.ui.popover.Tooltip;
import org.dominokit.domino.ui.style.Style;
import org.jboss.gwt.elemento.core.builder.HtmlContentBuilder;

import java.util.LinkedList;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.*;

public class TableConfig<T> {

    private List<ColumnConfig<T>> columns = new LinkedList<>();
    private List<DataTablePlugin<T>> plugins = new LinkedList<>();
    private DataTable<T> dataTable;
    private boolean fixed = false;
    private String fixedDefaultColumnWidth = "100px";
    private String fixedBodyHeight = "400px";
    private boolean lazyLoad = true;

    public void drawHeaders(DataTable<T> dataTable, HTMLTableSectionElement thead) {
        this.dataTable = dataTable;
        HtmlContentBuilder<HTMLTableRowElement> tr = tr();
        thead.appendChild(tr.asElement());

        columns.forEach(columnConfig -> {
            Node element = columnConfig.getHeaderElement().asElement(columnConfig.getTitle());
            columnConfig.contextMenu = div().style("width: 15px; display: none;").asElement();
            HtmlContentBuilder<HTMLDivElement> add = div().style("display: flex;")
                    .add(div().style("width:100%").add(element))
                    .add(columnConfig.contextMenu);
            HtmlContentBuilder<HTMLTableCellElement> th = th().css("table-cm-header").add(add.asElement());
            tr.add(th);
            columnConfig.setHeadElement(th.asElement());
            if (dataTable.getTableConfig().isFixed() || columnConfig.isFixed()) {
                fixElementWidth(columnConfig, th.asElement());
            }

            Tooltip.create(th.asElement(), columnConfig.getTooltipNode());
            columnConfig.applyHeaderStyle();

            plugins.forEach(plugin -> plugin.onHeaderAdded(dataTable, columnConfig));
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

    public void drawRecord(DataTable<T> dataTable, TableRow<T> tableRow) {
        columns.forEach(columnConfig -> {

            HTMLTableCellElement cellElement;
            if (columnConfig.isHeader()) {
                cellElement = th().asElement();
            } else {
                cellElement = td().asElement();
            }

            if (dataTable.getTableConfig().isFixed() || columnConfig.isFixed()) {
                fixElementWidth(columnConfig, cellElement);
            }

            RowCell<T> rowCell = new RowCell<>(new CellRenderer.CellInfo<>(tableRow, cellElement), columnConfig);
            rowCell.updateCell();
            tableRow.addCell(rowCell);

            tableRow.asElement().appendChild(cellElement);
            columnConfig.applyCellStyle(cellElement);
        });
        dataTable.bodyElement().appendChild(tableRow.asElement());

        plugins.forEach(plugin -> plugin.onRowAdded(dataTable, tableRow));
    }


    public TableConfig<T> addColumn(ColumnConfig<T> column) {
        this.columns.add(column);
        return this;
    }

    public TableConfig<T> insertColumnFirst(ColumnConfig<T> column) {
        this.columns.add(0, column);
        return this;
    }

    public TableConfig<T> insertColumnLast(ColumnConfig<T> column) {
        this.columns.add(this.columns.size() - 1, column);
        return this;
    }

    public TableConfig<T> addPlugin(DataTablePlugin<T> plugin) {
        this.plugins.add(plugin);
        return this;
    }

    public boolean isFixed() {
        return fixed;
    }

    public TableConfig<T> setFixed(boolean fixed) {
        this.fixed = fixed;
        return this;
    }

    public boolean isLazyLoad() {
        return lazyLoad;
    }

    public TableConfig<T> setLazyLoad(boolean lazyLoad) {
        this.lazyLoad = lazyLoad;
        return this;
    }

    public String getFixedBodyHeight() {
        return fixedBodyHeight;
    }

    public TableConfig<T> setFixedBodyHeight(String fixedBodyHeight) {
        this.fixedBodyHeight = fixedBodyHeight;
        return this;
    }

    public String getFixedDefaultColumnWidth() {
        return fixedDefaultColumnWidth;
    }

    public TableConfig<T> setFixedDefaultColumnWidth(String fixedDefaultColumnWidth) {
        this.fixedDefaultColumnWidth = fixedDefaultColumnWidth;
        return this;
    }

    String bestFitWidth(ColumnConfig<T> columnConfig) {
        if (nonNull(columnConfig.getWidth()) && !columnConfig.getWidth().isEmpty()) {
            return columnConfig.getWidth();
        } else if (nonNull(columnConfig.getMinWidth()) && !columnConfig.getMinWidth().isEmpty()) {
            return columnConfig.getMinWidth();
        } else if (nonNull(columnConfig.getMaxWidth()) && !columnConfig.getMaxWidth().isEmpty()) {
            return columnConfig.getMaxWidth();
        } else {
            return fixedDefaultColumnWidth;
        }
    }

    public List<DataTablePlugin<T>> getPlugins() {
        return plugins;
    }

    void onBeforeHeaders(DataTable<T> dataTable) {
        plugins.forEach(plugin -> plugin.onBeforeAddHeaders(dataTable));
    }

    public List<ColumnConfig<T>> getColumns() {
        return columns;
    }

    public DataTable<T> getDataTable() {
        return dataTable;
    }
}
