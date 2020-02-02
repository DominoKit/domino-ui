package org.dominokit.domino.ui.datatable.plugins;

import elemental2.core.JsMath;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLTableSectionElement;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.events.BodyScrollEvent;

public class BodyScrollPlugin<T> implements DataTablePlugin<T> {
    @Override
    public void onBodyAdded(DataTable<T> dataTable) {
        HTMLTableSectionElement tbody = dataTable.bodyElement().element();
        tbody.addEventListener("scroll", evt -> {
            double scrollTop = new Double(tbody.scrollTop).intValue();
            if (scrollTop == 0) {
                dataTable.fireTableEvent(new BodyScrollEvent(ScrollPosition.TOP));
            }
            int offsetHeight = new Double(tbody.offsetHeight).intValue();
            int scrollHeight = new Double(tbody.scrollHeight).intValue();

            if (JsMath.abs(offsetHeight) + JsMath.abs(scrollTop) == new Double(scrollHeight).intValue()) {
                dataTable.fireTableEvent(new BodyScrollEvent(ScrollPosition.BOTTOM));
            }
        });
    }

    public enum ScrollPosition{
        TOP,
        BOTTOM
    }
}
