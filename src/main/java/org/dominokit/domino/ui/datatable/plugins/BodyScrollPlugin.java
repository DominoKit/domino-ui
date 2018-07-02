package org.dominokit.domino.ui.datatable.plugins;

import elemental2.dom.HTMLTableSectionElement;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.events.BodyScrollEvent;

public class BodyScrollPlugin<T> implements DataTablePlugin<T> {
    @Override
    public void onBodyAdded(DataTable<T> dataTable) {
        HTMLTableSectionElement tbody = dataTable.bodyElement();
        tbody.addEventListener("scroll", evt -> {
            if (tbody.scrollTop == 0) {
                dataTable.fireTableEvent(new BodyScrollEvent(ScrollPosition.TOP));
            }
            if (tbody.offsetHeight + tbody.scrollTop == tbody.scrollHeight) {
                dataTable.fireTableEvent(new BodyScrollEvent(ScrollPosition.BOTTOM));
            }
        });


    }

    public enum ScrollPosition{
        TOP,
        BOTTOM
    }
}
