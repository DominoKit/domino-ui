package org.dominokit.domino.ui.datatable.plugins;

import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableRow;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.gwt.elemento.core.EventType;

public class RowClickPlugin<T> implements DataTablePlugin<T> {
    private ClickHandler<T> handler;

    public RowClickPlugin(ClickHandler<T> handler) {
        this.handler = handler;
    }

    @Override
    public void onRowAdded(DataTable<T> dataTable, TableRow<T> tableRow) {
        DominoElement.of(tableRow.asElement()).styler(style -> style.setCursor("pointer"));
        tableRow.asElement().addEventListener(EventType.click.getName(), evt -> handler.onClick(tableRow));
    }

    @FunctionalInterface
    public interface ClickHandler<T> {
        void onClick(TableRow<T> tableRow);
    }
}
