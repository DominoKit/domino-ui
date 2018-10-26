package org.dominokit.domino.ui.datatable.plugins;

import elemental2.dom.Node;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.datatable.events.TableEventListener;

public interface HeaderActionElement<T> extends TableEventListener {
    Node asElement(DataTable<T> dataTable);

    @Override
    default void handleEvent(TableEvent event) {

    }
}
