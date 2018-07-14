package org.dominokit.domino.ui.datatable.plugins;

import elemental2.dom.Node;
import org.dominokit.domino.ui.datatable.DataTable;

@FunctionalInterface
public interface HeaderActionElement<T> {
    Node asElement(DataTable<T> dataTable);
}
