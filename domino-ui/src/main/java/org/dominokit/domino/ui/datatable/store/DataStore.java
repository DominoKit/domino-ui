package org.dominokit.domino.ui.datatable.store;

import org.dominokit.domino.ui.datatable.events.TableEventListener;

/**
 * An interface to implement different data stores for the data table and listen to table events.
 * @param <T>  the type of the data table records
 */
public interface DataStore<T> extends TableEventListener {
    /**
     * Adds a listener to handle the {@link DataChangedEvent} events
     * @param dataChangeListener {@link StoreDataChangeListener}
     */
    void onDataChanged(StoreDataChangeListener<T> dataChangeListener);

    /**
     * removes the listener
     * @param dataChangeListener {@link StoreDataChangeListener}
     */
    void removeDataChangeListener(StoreDataChangeListener<T> dataChangeListener);

    /**
     * loads the data into the data table
     */
    void load();

}

