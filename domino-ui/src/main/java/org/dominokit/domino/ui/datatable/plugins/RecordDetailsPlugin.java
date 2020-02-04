package org.dominokit.domino.ui.datatable.plugins;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLTableCellElement;
import elemental2.dom.HTMLTableRowElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.datatable.*;
import org.dominokit.domino.ui.datatable.events.ExpandRecordEvent;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.jboss.elemento.IsElement;

import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.*;

public class RecordDetailsPlugin<T> implements DataTablePlugin<T> {

    public static final String DATA_TABLE_DETAILS_CM = "data-table-details-cm";
    private final BaseIcon<?> collapseIcon;
    private final BaseIcon<?> expandIcon;
    private HTMLDivElement element = div().element();
    private HTMLTableCellElement td = td().css(DataTableStyles.DETAILS_TD).add(element).element();
    private HTMLTableRowElement tr = tr().css(DataTableStyles.DETAILS_TR).add(td).element();

    private final CellRenderer<T> cellRenderer;
    private DetailsButtonElement buttonElement;
    private DataTable<T> dataTable;


    public RecordDetailsPlugin(CellRenderer<T> cellRenderer) {
        this(cellRenderer, Icons.ALL.fullscreen_exit(), Icons.ALL.fullscreen());
    }

    public RecordDetailsPlugin(CellRenderer<T> cellRenderer, BaseIcon<?> collapseIcon, BaseIcon<?> expandIcon) {
        this.cellRenderer = cellRenderer;
        this.collapseIcon = collapseIcon;
        this.expandIcon = expandIcon;
    }

    @Override
    public void onBeforeAddHeaders(DataTable<T> dataTable) {
        this.dataTable = dataTable;
        ColumnConfig<T> column = ColumnConfig.<T>create(DATA_TABLE_DETAILS_CM)
                .setSortable(false)
                .setWidth("60px")
                .setFixed(true)
                .setCellRenderer(cell -> {
                    applyStyles(cell);
                    DetailsButtonElement<T> detailsButtonElement = new DetailsButtonElement<>(expandIcon, collapseIcon, RecordDetailsPlugin.this, cell);
                    cell.getTableRow().addMetaObject(detailsButtonElement);
                    applyStyles(cell);
                    return detailsButtonElement.element();
                })
                .setHeaderElement(columnTitle -> Button.create(expandIcon.copy())
                        .linkify()
                        .disable()
                        .style()
                        .setProperty("padding", "0px")
                        .setHeight("24px")
                        .element())
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
        DetailsButtonElement<T> detailsButtonElement = event.getTableRow().getMetaObject(DataTableStyles.RECORD_DETAILS_BUTTON);
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
        private final Button button;
        private final CellRenderer.CellInfo<T> cellInfo;
        private final BaseIcon<?> expandIcon;
        private final BaseIcon<?> collapseIcon;
        private RecordDetailsPlugin<?> recordDetailsPlugin;
        private boolean expanded = false;

        public DetailsButtonElement(BaseIcon<?> expandIcon, BaseIcon<?> collapseIcon, RecordDetailsPlugin<?> recordDetailsPlugin, CellRenderer.CellInfo<T> cellInfo) {
            this.expandIcon = expandIcon;
            this.collapseIcon = collapseIcon;
            this.recordDetailsPlugin = recordDetailsPlugin;
            this.cellInfo = cellInfo;
            this.button = Button.create(expandIcon.copy()).linkify();
            button.style()
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
        public HTMLElement element() {
            return button.element();
        }

        @Override
        public String getKey() {
            return DataTableStyles.RECORD_DETAILS_BUTTON;
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
        ElementUtil.contentBuilder(td).attr("colspan", dataTable.getTableConfig().getColumns().size() + "");
        element.appendChild(cellRenderer.asElement(buttonElement.getCellInfo()));
        dataTable.bodyElement().element().insertBefore(tr, buttonElement.getCellInfo().getTableRow().element().nextSibling);
    }

}
