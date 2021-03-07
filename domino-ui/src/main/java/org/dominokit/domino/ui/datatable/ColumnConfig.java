package org.dominokit.domino.ui.datatable;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLTableCellElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.ScreenMedia;
import org.dominokit.domino.ui.utils.TextNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * Class to define a column in the data table
 * @param <T> the type of the data table records
 */
public class ColumnConfig<T> {

    private final String name;
    private String title;
    private HTMLTableCellElement headElement;
    public HTMLDivElement contextMenu;
    private boolean header = false;
    private String minWidth;
    private String maxWidth;
    private String textAlign;
    private CellRenderer<T> cellRenderer;
    private CellRenderer<T> editableCellRenderer;
    private HeaderElement headerElement = TextNode::of;
    private CellStyler<T> headerStyler = element -> {
    };
    private CellStyler<T> cellStyler = element -> {
    };
    private boolean sortable = false;
    private String width;
    private boolean fixed = false;
    private Node tooltipNode;
    private boolean showTooltip = true;

    private boolean hidden = false;

    private ScreenMedia showOn;
    private ScreenMedia hideOn;

    private final List<ColumnShowHideListener> showHideListeners = new ArrayList<>();

    /**
     * Creates an instance with a name which will also be used as a title
     * @param name String, the name of the column
     * @param <T> the type of the data table records
     * @return new {@link ColumnConfig} instance
     */
    public static <T> ColumnConfig<T> create(String name) {
        return new ColumnConfig<>(name);
    }

    /**
     * Creates an instance with a name and title
     * @param name String, the name of the column
     * @param title String, the title of the column
     * @param <T> the type of the data table records
     * @return new {@link ColumnConfig} instance
     */
    public static <T> ColumnConfig<T> create(String name, String title) {
        return new ColumnConfig<>(name, title);
    }

    /**
     * Creates an instance with a name and title
     * @param name String, the name of the column
     * @param title String, the title of the column
     */
    public ColumnConfig(String name, String title) {
        this.name = name;
        this.title = title;
    }

    /**
     * Creates an instance with a name which will also be used as a title
     * @param name String, the name of the column
     */
    public ColumnConfig(String name) {
        this(name, "");
    }

    /**
     *
     * @return String column title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @return String column name
     */
    public String getName() {
        return name;
    }

    public ColumnConfig<T> asHeader() {
        this.header = true;
        return this;
    }

    /**
     *
     * @param minWidth String css minimum width for the column
     * @return same ColumnConfig instance
     */
    public ColumnConfig<T> minWidth(String minWidth) {
        this.minWidth = minWidth;
        return this;
    }

    /**
     *
     * @param maxWidth String css maximum width for the column
     * @return same ColumnConfig instance
     */
    public ColumnConfig<T> maxWidth(String maxWidth) {
        this.maxWidth = maxWidth;
        return this;
    }

    /**
     *
     * @return String the width of the column that we set using the {@link #setWidth(String)} not the actual width of the column
     */
    public String getWidth() {
        return width;
    }

    /**
     *
     * @param width String css width for the column
     * @return same ColumnConfig instance
     */
    public ColumnConfig<T> setWidth(String width) {
        this.width = width;
        return this;
    }

    /**
     *
     * @param textAlign String css text align for the column values <b>left</b>,<b>right</b>,<b>center</b>
     * @return same ColumnConfig instance
     */
    public ColumnConfig<T> textAlign(String textAlign) {
        this.textAlign = textAlign;
        return this;
    }

    /**
     * a shortcut to {@link #setWidth(String)} with value <b>left</b>
     * @return same ColumnConfig instance
     */
    public ColumnConfig<T> alignLeft() {
        textAlign("left");
        return this;
    }

    /**
     * a shortcut to {@link #setWidth(String)} with value <b>right</b>
     * @return same ColumnConfig instance
     */
    public ColumnConfig<T> alignRight() {
        textAlign("right");
        return this;
    }

    /**
     * a shortcut to {@link #setWidth(String)} with value <b>center</b>
     * @return same ColumnConfig instance
     */
    public ColumnConfig<T> alignCenter() {
        textAlign("center");
        return this;
    }

    /**
     *
     * @return the {@link HeaderElement} of the column
     */
    public HeaderElement getHeaderElement() {
        return headerElement;
    }

    /**
     * Sets a custom header element for the column
     * @param headerElement the {@link HeaderElement}
     * @return same ColumnConfig instance
     */
    public ColumnConfig<T> setHeaderElement(HeaderElement headerElement) {
        this.headerElement = headerElement;
        return this;
    }

    /**
     * While rendering the column this will determine if we should build the header with th or td elements
     * @return boolean, if ture use th elements, otherwise use td elements
     */
    public boolean isHeader() {
        return header;
    }

    /**
     *
     * @return the String minimum width we set with {@link #minWidth(String)}
     */
    public String getMinWidth() {
        return minWidth;
    }

    /**
     *
     * @return the String maximum width we set with {@link #maxWidth(String)}
     */
    public String getMaxWidth() {
        return maxWidth;
    }
    /**
     *
     * @return the String text align we set with {@link #textAlign(String)}
     */
    public String getTextAlign() {
        return textAlign;
    }

    /**
     *
     * @return boolean, if true the column width will be fixed and wont change if the table size changed
     */
    public boolean isFixed() {
        return fixed;
    }

    /**
     *
     * @param fixed boolean, if true the column width will be fixed and wont change when the table size is changed.
     * @return same ColumnConfig instance.
     */
    public ColumnConfig<T> setFixed(boolean fixed) {
        this.fixed = fixed;
        return this;
    }

    public ColumnConfig<T> setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     *
     * @return the {@link HTMLTableCellElement} that represent this column element wrapped as {@link DominoElement}
     */
    public DominoElement<HTMLTableCellElement> getHeadElement() {
        return DominoElement.of(headElement);
    }

    /**
     * sets a custom element for the column header
     * @param headElement {@link HTMLTableCellElement}
     */
    protected void setHeadElement(HTMLTableCellElement headElement) {
        this.headElement = headElement;
    }

    /**
     *
     * @return the {@link CellRenderer} of this column
     */
    public CellRenderer<T> getCellRenderer() {
        return cellRenderer;
    }

    /**
     * sets the cell renderer for this column
     * @param cellRenderer {@link CellRenderer}
     * @return same ColumnConfig instance
     */
    public ColumnConfig<T> setCellRenderer(CellRenderer<T> cellRenderer) {
        this.cellRenderer = cellRenderer;
        if(isNull(editableCellRenderer)){
            this.editableCellRenderer = cellRenderer;
        }
        return this;
    }

    /**
     *
     * @return the {@link CellRenderer} of the editable version of this column
     */
    public CellRenderer<T> getEditableCellRenderer() {
        if(isNull(editableCellRenderer)){
            return cellRenderer;
        }
        return editableCellRenderer;
    }

    /**
     * sets the cell renderer to render this column cells in editable mode
     * @param editableCellRenderer {@link CellRenderer}
     * @return same ColumnConfig instance
     */
    public ColumnConfig<T> setEditableCellRenderer(CellRenderer<T> editableCellRenderer) {
        this.editableCellRenderer = editableCellRenderer;
        if(isNull(cellRenderer)){
            this.cellRenderer = editableCellRenderer;
        }
        return this;
    }

    /**
     * a hook to style a column header
     * @param headerStyler {@link CellStyler}
     * @return same ColumnConfig instance
     */
    public ColumnConfig<T> styleHeader(CellStyler<T> headerStyler) {
        this.headerStyler = headerStyler;
        return this;
    }

    /**
     * a hook to style a cell in the column
     * @param cellStyler {@link CellStyler}
     * @return same ColumnConfig instance
     */
    public ColumnConfig<T> styleCell(CellStyler<T> cellStyler) {
        this.cellStyler = cellStyler;
        return this;
    }

    /**
     *
     * @return boolean, true if data can be sorted with this column, otherwise false
     */
    public boolean isSortable() {
        return sortable;
    }

    /**
     * set wither the column can be used to sort the data or not
     * @param sortable boolean, if true then data can be sorted with this column, otherwise it cant
     * @return same ColumnConfig instance
     */
    public ColumnConfig<T> setSortable(boolean sortable) {
        this.sortable = sortable;
        return this;
    }

    /**
     * a shortcut for {@link #setSortable(boolean)} with value true
     * @return same ColumnConfig instance
     */
    public ColumnConfig<T> sortable() {
        this.sortable = true;
        return this;
    }

    /**
     * force apply screen medias if exists to a cell in this column
     * @param element {@link HTMLTableCellElement}
     */
    public void applyScreenMedia(HTMLTableCellElement element) {
        DominoElement<HTMLTableCellElement> thElement = DominoElement.of(element);

        if (nonNull(showOn)) {
            thElement.showOn(showOn);
        }

        if (nonNull(hideOn)) {
            thElement.hideOn(hideOn);
        }
    }

    /**
     *
     * @return the {@link Node} representing the tooltip for this column header if exists otherwise return the title node
     */
    public Node getTooltipNode() {
        if (nonNull(tooltipNode))
            return tooltipNode;
        else {
            return getHeaderElement().asElement(title);
        }
    }

    /**
     * sets a custom tooltip element
     * @param tooltipNode {@link Node}
     * @return same ColumnConfig instance
     */
    public ColumnConfig<T> setTooltipNode(Node tooltipNode) {
        this.tooltipNode = tooltipNode;
        return this;
    }

    /**
     * sets the tooltip text
     * @param tooltipText String
     * @return same ColumnConfig instance
     */
    public ColumnConfig<T> setTooltipText(String tooltipText) {
        this.tooltipNode = TextNode.of(tooltipText);
        return this;
    }

    /**
     *
     * @param showTooltip boolean, if true a tooltip will show up when hover on the column otherwise it will not.
     * @return same ColumnConfig instance
     */
    public ColumnConfig<T> setShowTooltip(boolean showTooltip) {
        this.showTooltip = showTooltip;
        return this;
    }

    /**
     *
     * @return the {@link ScreenMedia} that result on showing the column
     */
    public ScreenMedia getShowOn() {
        return showOn;
    }

    /**
     *
     * @param showOn {@link ScreenMedia} when is applied the column will be shown
     * @return same ColumnConfig instance
     */
    public ColumnConfig<T> showOn(ScreenMedia showOn) {
        this.showOn = showOn;
        return this;
    }

    /**
     *
     * @return the {@link ScreenMedia} that result on hiding the column
     */
    public ScreenMedia getHideOn() {
        return hideOn;
    }

    /**
     *
     * @param hideOn {@link ScreenMedia} when is applied the column will be hidden
     * @return same ColumnConfig instance
     */
    public ColumnConfig<T> hideOn(ScreenMedia hideOn) {
        this.hideOn = hideOn;
        return this;
    }

    /**
     * make the headerStyler apply the styles
     */
    void applyHeaderStyle() {
        headerStyler.styleCell(headElement);
    }

    /**
     * make the cellStyler apply the style
     * @param element {@link HTMLTableCellElement}
     */
    void applyCellStyle(HTMLTableCellElement element) {
        cellStyler.styleCell(element);
    }

    /**
     *
     * @return the {@link CellStyler} of the header element
     */
    public CellStyler<T> getHeaderStyler() {
        return headerStyler;
    }

    /**
     *
     * @return the {@link CellStyler} of the cell element
     */
    public CellStyler<T> getCellStyler() {
        return cellStyler;
    }

    /**
     *
     * @return boolean, if true this column show a tooltip otherwise it does not
     */
    public boolean isShowTooltip() {
        return showTooltip;
    }

    /**
     * Adds a listener to listen for column hide/show changes
     * @param showHideListener {@link ColumnShowHideListener}
     * @return same ColumnConfig instance
     */
    public ColumnConfig<T> addShowHideListener(ColumnShowHideListener showHideListener){
        this.showHideListeners.add(showHideListener);
        return this;
    }

    /**
     * remove the listener
     * @param showHideListener {@link ColumnShowHideListener}
     * @return same ColumnConfig instance
     */
    public ColumnConfig<T> removeShowHideListener(ColumnShowHideListener showHideListener){
        this.showHideListeners.remove(showHideListener);
        return this;
    }

    /**
     * show the column and call the listeners
     * @return same ColumnConfig instance
     */
    public ColumnConfig<T> show(){
        this.showHideListeners.forEach(showHideListener -> showHideListener.onShowHide(true));
        this.hidden = false;
        return this;
    }

    /**
     * Hides the column and call the listeners
     * @return same ColumnConfig instance
     */
    public ColumnConfig<T> hide(){
        this.showHideListeners.forEach(showHideListener -> showHideListener.onShowHide(false));
        this.hidden = true;
        return this;
    }

    /**
     *
     * @param visible boolean, if true call {@link #show()} otherwise call {@link #hide()}
     * @return
     */
    public ColumnConfig<T> toggleDisplay(boolean visible){
        if(visible){
            return show();
        }else {
            return hide();
        }
    }

    /**
     * @deprecated use {@link ColumnConfig#clearShowHideListeners()}
     */
    @Deprecated
    public void clearShowHideListners(){
        clearShowHideListeners();
    }

    /**
     * removes all {@link ColumnShowHideListener}s of this column except the permanent listeners
     */
    public void clearShowHideListeners(){
        List<ColumnShowHideListener> nonPermanent = showHideListeners.stream()
                .filter(listener -> !listener.isPermanent())
                .collect(Collectors.toList());

        showHideListeners.removeAll(nonPermanent);
    }

    /**
     *
     * @return boolean, true if the column is already hidden, otherwise false
     */
    public boolean isHidden() {
        return hidden;
    }

    /**
     * A hook interface to style a cell being rendered on the table
     * @param <T> the type of the data table records
     */
    @FunctionalInterface
    public interface CellStyler<T> {
        /**
         *
         * @param element the {@link HTMLTableCellElement} to be styled
         */
        void styleCell(HTMLTableCellElement element);
    }

}
