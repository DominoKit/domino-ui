package org.dominokit.domino.ui.datatable.plugins;

import elemental2.core.JsMath;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLTableSectionElement;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.events.BodyScrollEvent;

/**
 * This plugin fires {@link BodyScrollEvent} whenever the table body scroll reaches the top of the bottom
 * @param <T> the type of the data table records
 */
public class BodyScrollPlugin<T> implements DataTablePlugin<T> {

    /**
     * {@inheritDoc}
     */
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

    /**
     * An enum to specify the postion of the scroll
     */
    public enum ScrollPosition{
        /**
         * The scroll reached the top
         */
        TOP,
        /**
         * The scroll reached the bottom
         */
        BOTTOM
    }
}
