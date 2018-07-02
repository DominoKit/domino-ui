package org.dominokit.domino.ui.datatable;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLTableCellElement;
import elemental2.dom.Node;
import elemental2.dom.Text;

import static java.util.Objects.nonNull;

public class ColumnConfig<T> {

    private final String name;
    private String title;
    private HTMLTableCellElement headElement;
    public HTMLDivElement contextMenu;
    private boolean header = false;
    private String minWidth;
    private String maxWidth;
    private String textAlign;
    private TableCell<T> tableCell = cell -> new Text("");
    private HeaderElement headerElement = columnTitle -> new Text(columnTitle);
    private CellStyler<T> headerStyler = element -> {
    };
    private CellStyler<T> cellStyler = element -> {
    };
    private boolean sortable = false;
    private String width;
    private boolean fixed = false;
    private Node tooltipNode;

    public static <T> ColumnConfig<T> create(String name) {
        return new ColumnConfig<>(name);
    }

    public static <T> ColumnConfig<T> create(String name, String title) {
        return new ColumnConfig<>(name, title);
    }

    public ColumnConfig(String name, String title) {
        this.name = name;
        this.title = title;
    }

    public ColumnConfig(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public ColumnConfig<T> asHeader() {
        this.header = true;
        return this;
    }

    public ColumnConfig<T> minWidth(String minWidth) {
        this.minWidth = minWidth;
        return this;
    }

    public ColumnConfig<T> maxWidth(String maxWidth) {
        this.maxWidth = maxWidth;
        return this;
    }

    public String getWidth() {
        return width;
    }

    public ColumnConfig<T> setWidth(String width) {
        this.width = width;
        return this;
    }

    public ColumnConfig<T> textAlign(String textAlign) {
        this.textAlign = textAlign;
        return this;
    }

    public HeaderElement getHeaderElement() {
        return headerElement;
    }

    public ColumnConfig<T> setHeaderElement(HeaderElement headerElement) {
        this.headerElement = headerElement;
        return this;
    }

    public boolean isHeader() {
        return header;
    }

    public String getMinWidth() {
        return minWidth;
    }

    public String getMaxWidth() {
        return maxWidth;
    }

    public String getTextAlign() {
        return textAlign;
    }

    public boolean isFixed() {
        return fixed;
    }

    public ColumnConfig<T> setFixed(boolean fixed) {
        this.fixed = fixed;
        return this;
    }

    public ColumnConfig<T> setTitle(String title) {
        this.title = title;
        return this;
    }

    public HTMLTableCellElement getHeadElement() {
        return headElement;
    }

    protected void setHeadElement(HTMLTableCellElement headElement) {
        this.headElement = headElement;
    }

    public TableCell<T> getTableCell() {
        return tableCell;
    }

    public ColumnConfig<T> setTableCell(TableCell<T> tableCell) {
        this.tableCell = tableCell;
        return this;
    }

    public ColumnConfig<T> styleHeader(CellStyler<T> headerStyler) {
        this.headerStyler = headerStyler;
        return this;
    }

    public ColumnConfig<T> styleCell(CellStyler<T> cellStyler) {
        this.cellStyler = cellStyler;
        return this;
    }

    public boolean isSortable() {
        return sortable;
    }

    public ColumnConfig<T> setSortable(boolean sortable) {
        this.sortable = sortable;
        return this;
    }

    public ColumnConfig<T> sortable() {
        this.sortable = true;
        return this;
    }

    public Node getTooltipNode() {
        if (nonNull(tooltipNode))
            return tooltipNode;
        else {
            return getHeaderElement().asElement(title);
        }
    }

    public ColumnConfig<T> setTooltipNode(Node tooltipNode) {
        this.tooltipNode = tooltipNode;
        return this;
    }

    public ColumnConfig<T> setTooltipText(String tooltipText) {
        this.tooltipNode = new Text(tooltipText);
        return this;
    }


    void applyHeaderStyle() {
        headerStyler.styleCell(headElement);
    }

    void applyCellStyle(HTMLTableCellElement element) {
        cellStyler.styleCell(element);
    }

    @FunctionalInterface
    public interface CellStyler<T> {
        void styleCell(HTMLTableCellElement element);
    }

}
