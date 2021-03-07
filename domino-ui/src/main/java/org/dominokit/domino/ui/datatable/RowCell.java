package org.dominokit.domino.ui.datatable;

import elemental2.dom.HTMLTableCellElement;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.dominokit.domino.ui.utils.TextNode;
import org.jboss.elemento.IsElement;

import static java.util.Objects.nonNull;

/**
 * This class represent a single cell in a data table row and it contains information about the cell row and column which it is part of
 * @param <T> the type of the data table records
 */
public class RowCell<T> {

    private final ColumnConfig<T> columnConfig;
    private final CellRenderer.CellInfo<T> cellInfo;
    private CellRenderer<T> defaultCellRenderer=  cell -> TextNode.of("");

    /**
     * Creates and initialize an instance with the cell info and column info
     * @param cellInfo the {@link CellRenderer.CellInfo} information about this cell
     * @param columnConfig the {@link ColumnConfig} the column this cell is part of
     */
    public RowCell(CellRenderer.CellInfo<T> cellInfo, ColumnConfig<T> columnConfig) {
        this.columnConfig = columnConfig;
        this.cellInfo = cellInfo;
    }

    /**
     *
     * @return the {@link ColumnConfig} the column this cell is part of
     */
    public ColumnConfig<T> getColumnConfig() {
        return columnConfig;
    }

    /**
     * This method will force update the cell which might result on clearing all it content and rerender them again with any updated data
     * this is useful when for example changing a field value in the records instance and we want to reflect the change to the cell that renders the field.
     */
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

        if(cellInfo.getTableRow().isEditable()){
            if(nonNull(columnConfig.getEditableCellRenderer())) {
                cellInfo.getElement().appendChild(columnConfig.getEditableCellRenderer().asElement(cellInfo));
            }else{
                cellInfo.getElement().appendChild(defaultCellRenderer.asElement(cellInfo));
            }
        }else {
            if(nonNull(columnConfig.getCellRenderer())) {
                cellInfo.getElement().appendChild(columnConfig.getCellRenderer().asElement(cellInfo));
            }else{
                cellInfo.getElement().appendChild(defaultCellRenderer.asElement(cellInfo));
            }
        }
    }

    /**
     *
     * @return the {@link CellRenderer.CellInfo} information about this cell
     */
    public CellRenderer.CellInfo<T> getCellInfo() {
        return cellInfo;
    }
}
