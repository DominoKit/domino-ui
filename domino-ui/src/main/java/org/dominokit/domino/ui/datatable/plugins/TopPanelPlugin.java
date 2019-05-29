package org.dominokit.domino.ui.datatable.plugins;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.datatable.DataTable;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.nonNull;

public abstract class TopPanelPlugin<T> implements DataTablePlugin<T>, IsElement<HTMLElement>{

    @Override
    public void onBeforeAddTable(DataTable<T> dataTable) {
        if (nonNull(asElement())) {
            dataTable.asElement().appendChild(asElement());
        }
    }

}
