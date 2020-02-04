package org.dominokit.domino.ui.datatable;

import elemental2.dom.HTMLTableCellElement;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.jboss.elemento.IsElement;

import static java.util.Objects.nonNull;

public class RowCell<T> {

    private final ColumnConfig<T> columnConfig;
    private final CellRenderer.CellInfo<T> cellInfo;

    public RowCell(CellRenderer.CellInfo<T> cellInfo, ColumnConfig<T> columnConfig) {
        this.columnConfig = columnConfig;
        this.cellInfo = cellInfo;
    }

    public ColumnConfig<T> getColumnConfig() {
        return columnConfig;
    }

    public void updateCell() {
        ElementUtil.clear(cellInfo.getElement());
        Style<HTMLTableCellElement, IsElement<HTMLTableCellElement>> style = Style.of(cellInfo.getElement());
        if (nonNull(columnConfig.getMinWidth())) {
            style.setMinWidth(columnConfig.getMinWidth());
            columnConfig.getHeadElement().style().setMinWidth(columnConfig.getMinWidth());
        }

        if (nonNull(columnConfig.getMaxWidth())) {
            style.setMaxWidth(columnConfig.getMaxWidth());
            columnConfig.getHeadElement().style().setMaxWidth(columnConfig.getMaxWidth());
        }

        if (nonNull(columnConfig.getTextAlign())) {
            style.setTextAlign(columnConfig.getTextAlign());
            columnConfig.getHeadElement().style().setTextAlign(columnConfig.getTextAlign());
        }

        cellInfo.getElement().appendChild(columnConfig.getCellRenderer().asElement(cellInfo));
    }

    public CellRenderer.CellInfo<T> getCellInfo() {
        return cellInfo;
    }
}
