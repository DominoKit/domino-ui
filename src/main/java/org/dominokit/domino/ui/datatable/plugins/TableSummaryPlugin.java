package org.dominokit.domino.ui.datatable.plugins;

import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.events.TableDataUpdated;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.List;

import static java.util.Objects.nonNull;

public class TableSummaryPlugin<T> implements DataTablePlugin<T> {

    private final SummaryElement<T> summaryElement;

    public TableSummaryPlugin(SummaryElement<T> summaryElement) {
        this.summaryElement = summaryElement;
    }

    @Override
    public void onBeforeAddTable(DataTable<T> dataTable) {
        if (nonNull(summaryElement)) {
            dataTable.asElement().appendChild(summaryElement.asElement());
        }
    }

    @Override
    public void handleEvent(TableEvent event) {
        if (TableDataUpdated.DATA_UPDATED.equals(event.getType())) {
            onDataUpdate((TableDataUpdated<T>) event);
        }
    }

    private void onDataUpdate(TableDataUpdated<T> event) {
        summaryElement.updateRootContent(event.getData(), event.getTotalCount());
    }

    public interface SummaryElement<T> extends IsElement<HTMLElement> {
        void updateRootContent(List<T> data, int totalCount);
    }

}
