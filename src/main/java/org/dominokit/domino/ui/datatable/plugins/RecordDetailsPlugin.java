package org.dominokit.domino.ui.datatable.plugins;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLTableCellElement;
import elemental2.dom.HTMLTableRowElement;
import org.dominokit.domino.ui.button.IconButton;
import org.dominokit.domino.ui.datatable.CellRenderer;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableRow;
import org.dominokit.domino.ui.datatable.events.ExpandRecordEvent;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.*;

public class RecordDetailsPlugin<T> implements DataTablePlugin<T> {

    public static final String RECORD_DETAILS_BUTTON = "record-details-button";
    private final Icon collapseIcon;
    private final Icon expandIcon;
    private HTMLDivElement element = div().asElement();
    private HTMLTableCellElement td = td().css("details-td").add(element).asElement();
    private HTMLTableRowElement tr = tr().css("details-tr").add(td).asElement();

    private final CellRenderer<T> cellRenderer;
    private DetailsButtonElement buttonElement;
    private DataTable<T> dataTable;


    public RecordDetailsPlugin(CellRenderer<T> cellRenderer) {
        this(cellRenderer, Icons.ALL.fullscreen_exit(), Icons.ALL.fullscreen());
    }

    public RecordDetailsPlugin(CellRenderer<T> cellRenderer, Icon collapseIcon, Icon expandIcon) {
        this.cellRenderer = cellRenderer;
        this.collapseIcon = collapseIcon;
        this.expandIcon = expandIcon;
    }

    @Override
    public void onBeforeAddHeaders(DataTable<T> dataTable) {
        this.dataTable = dataTable;
        ColumnConfig<T> column = ColumnConfig.<T>create("data-table-details-cm")
                .setSortable(false)
                .setWidth("60px")
                .setFixed(true)
                .setCellRenderer(cell -> {
                    applyStyles(cell);
                    DetailsButtonElement<T> detailsButtonElement = new DetailsButtonElement<>(expandIcon, collapseIcon, RecordDetailsPlugin.this, cell);
                    cell.getTableRow().addMetaObject(detailsButtonElement);
                    applyStyles(cell);
                    return detailsButtonElement.asElement();
                })
                .setHeaderElement(columnTitle -> {
                    HTMLElement htmlElement = IconButton.create(expandIcon.copy()).linkify().disable().asElement();
                    Style.of(htmlElement)
                            .setProperty("padding", "0px")
                            .setHeight("24px")
                            .setMarginLeft("10px");

                    return htmlElement;
                })
                .asHeader()
                .textAlign("center");
        setupColumn(column);

        dataTable.getTableConfig().insertColumnFirst(column);
    }

    @Override
    public void handleEvent(TableEvent event) {
        if (ExpandRecordEvent.EXPAND_RECORD.equals(event.getType())) {
            expandRow((ExpandRecordEvent<T>) event);
        }
    }

    private void expandRow(ExpandRecordEvent<T> event) {
        DetailsButtonElement<T> detailsButtonElement = event.getTableRow().getMetaObject(RECORD_DETAILS_BUTTON);
        setExpanded(detailsButtonElement);
    }

    public HTMLDivElement getElement() {
        return element;
    }

    public HTMLTableCellElement getTd() {
        return td;
    }

    public HTMLTableRowElement getTr() {
        return tr;
    }

    public void applyStyles(CellRenderer.CellInfo<T> cellInfo) {
    }

    public void setupColumn(ColumnConfig<T> column) {
    }

    public static class DetailsButtonElement<T> implements IsElement<HTMLElement>, TableRow.RowMetaObject {
        private final IconButton button;
        private final CellRenderer.CellInfo<T> cellInfo;
        private final Icon expandIcon;
        private final Icon collapseIcon;
        private RecordDetailsPlugin<?> recordDetailsPlugin;
        private boolean expanded = false;

        public DetailsButtonElement(Icon expandIcon, Icon collapseIcon, RecordDetailsPlugin<?> recordDetailsPlugin, CellRenderer.CellInfo<T> cellInfo) {
            this.expandIcon = expandIcon;
            this.collapseIcon = collapseIcon;
            this.recordDetailsPlugin = recordDetailsPlugin;
            this.cellInfo = cellInfo;
            this.button = IconButton.create(expandIcon.copy());
            button.linkify();
            Style.of(button)
                    .setProperty("padding", "0px")
                    .setHeight("27px")
                    .setPaddingLeft("2px")
                    .setPaddingRight("2px");

            button.addClickListener(evt -> {
                if (expanded) {
                    collapse();
                } else {
                    expand();
                }
            });
        }

        public CellRenderer.CellInfo<T> getCellInfo() {
            return cellInfo;
        }

        public void expand() {
            button.setIcon(collapseIcon.copy());
            expanded = true;
            recordDetailsPlugin.setExpanded(this);
        }

        public void collapse() {
            button.setIcon(expandIcon.copy());
            expanded = false;
            recordDetailsPlugin.clear();
        }

        @Override
        public HTMLElement asElement() {
            return button.asElement();
        }

        @Override
        public String getKey() {
            return RECORD_DETAILS_BUTTON;
        }
    }

    private void clear() {
        tr.remove();
        ElementUtil.clear(element);
        this.buttonElement = null;
    }

    private void setExpanded(DetailsButtonElement buttonElement) {
        if (nonNull(this.buttonElement)) {
            this.buttonElement.collapse();
            clear();
        }
        this.buttonElement = buttonElement;
        ElementUtil.builderFor(td).attr("colspan", dataTable.getTableConfig().getColumns().size() + "");
        element.appendChild(cellRenderer.asElement(buttonElement.getCellInfo()));
        dataTable.bodyElement().insertBefore(tr, buttonElement.getCellInfo().getTableRow().asElement().nextSibling);
    }

}
