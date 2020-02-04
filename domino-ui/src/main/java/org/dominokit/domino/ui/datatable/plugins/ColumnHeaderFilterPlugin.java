package org.dominokit.domino.ui.datatable.plugins;

import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLTableCellElement;
import elemental2.dom.HTMLTableRowElement;
import elemental2.dom.HTMLTableSectionElement;
import org.dominokit.domino.ui.datatable.*;
import org.dominokit.domino.ui.datatable.events.SearchClearedEvent;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.datatable.model.SearchContext;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.IsElement;
import org.jboss.elemento.HtmlContentBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.th;
import static org.jboss.elemento.Elements.tr;

public class ColumnHeaderFilterPlugin<T> implements DataTablePlugin<T> {

    private final Map<String, HeaderFilter> headerFilters = new HashMap<>();

    public static <T> ColumnHeaderFilterPlugin<T> create() {
        return new ColumnHeaderFilterPlugin<>();
    }

    @Override
    public void onAfterAddHeaders(DataTable<T> dataTable) {
        HtmlContentBuilder<HTMLTableRowElement> tr = tr();
        TableConfig<T> tableConfig = dataTable.getTableConfig();
        List<ColumnConfig<T>> columns = tableConfig.getColumns();
        DominoElement<HTMLTableSectionElement> thead = dataTable.headerElement();
        thead.appendChild(tr.element());

        columns.forEach(columnConfig -> {

            HtmlContentBuilder<HTMLTableCellElement> th = th().css(DataTableStyles.TABLE_CM_FILTER);
            columnConfig.getHeaderStyler()
                    .styleCell(th.element());

            columnConfig.applyScreenMedia(th.element());

            tr.add(th);

            if (dataTable.getTableConfig().isFixed() || columnConfig.isFixed()) {
                fixElementWidth(columnConfig, th.element());
            }
            if (headerFilters.containsKey(columnConfig.getName())) {
                headerFilters.get(columnConfig.getName()).init(dataTable.getSearchContext(), columnConfig);
                th.add(headerFilters.get(columnConfig.getName()));
            }

            columnConfig.addShowHideListener(DefaultColumnShowHideListener.of(th.element(), true));
            DominoElement.of(th).toggleDisplay(!columnConfig.isHidden());
        });

        dataTable.tableElement().appendChild(thead);
    }

    private void fixElementWidth(ColumnConfig<T> column, HTMLElement element) {
        String fixedWidth = bestFitWidth(column);
        Style.of(element)
                .setWidth(fixedWidth)
                .setMinWidth(fixedWidth)
                .setMaxWidth(fixedWidth)
                .add(DataTableStyles.FIXED_WIDTH);

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

    public ColumnHeaderFilterPlugin<T> addHeaderFilter(String columnName, HeaderFilter headerFilter) {
        headerFilters.put(columnName, headerFilter);
        return this;
    }

    @Override
    public void handleEvent(TableEvent event) {
        if (SearchClearedEvent.SEARCH_EVENT_CLEARED.equals(event.getType())) {
            headerFilters.values().forEach(HeaderFilter::clear);
        }
    }

    public interface HeaderFilter<T> extends IsElement<HTMLElement> {
        void init(SearchContext<T> searchContext, ColumnConfig<T> columnConfig);

        void clear();
    }
}
