package org.dominokit.domino.ui.datatable.plugins;

import elemental2.dom.Node;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.datatable.events.TableEventListener;

/**
 * An interface to implement header action elements for the {@link HeaderBarPlugin}
 * @param <T> the type of the data table records
 */
public interface HeaderActionElement<T> extends TableEventListener {
    /**
     *  initialize the element for this action
     * @param dataTable the {@link DataTable} we are attaching the plugin to
     * @return the {@link Node} representing this action element
     */
    Node asElement(DataTable<T> dataTable);

    /**
     * {@inheritDoc}
     */
    @Override
    default void handleEvent(TableEvent event) {

    }
}
