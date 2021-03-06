package org.dominokit.domino.ui.datatable.store;

/**
 * A listener interface to handle {@link DataChangedEvent}
 * @param <T> the type of the data table records
 */
@FunctionalInterface
public interface StoreDataChangeListener<T> {
    /**
     * Handles the data change event
     * @param dataChangedEvent {@link DataChangedEvent}
     */
    void onDataChanged(DataChangedEvent<T> dataChangedEvent);
}
