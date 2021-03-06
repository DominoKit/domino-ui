package org.dominokit.domino.ui.datatable.plugins;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.datatable.DataTable;
import org.jboss.elemento.IsElement;

import static java.util.Objects.nonNull;

/**
 * This abstract plugin attach custom content to the data table top panel
 * @param <T> the type of the data table records
 */
public abstract class TopPanelPlugin<T> implements DataTablePlugin<T>, IsElement<HTMLElement>{

    /**
     * {@inheritDoc}
     */
    @Override
    public void onBeforeAddTable(DataTable<T> dataTable) {
        if (nonNull(element())) {
            dataTable.element().appendChild(element());
        }
    }
}
