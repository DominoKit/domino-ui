package org.dominokit.domino.ui.datatable.events;

/**
 * An interface to define events for the data table and specify the event type
 */
public interface TableEvent {
    /**
     *
     * @return String, a unique event type.
     */
    String getType();
}
