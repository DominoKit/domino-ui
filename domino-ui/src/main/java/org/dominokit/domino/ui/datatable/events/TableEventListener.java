package org.dominokit.domino.ui.datatable.events;

/**
 * An interface to define a new listener for a Table event
 */
public interface TableEventListener {
    /**
     *
     * @param event the {@link TableEvent} being received
     */
    void handleEvent(TableEvent event);
}
