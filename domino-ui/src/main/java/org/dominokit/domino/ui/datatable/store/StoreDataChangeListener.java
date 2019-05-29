package org.dominokit.domino.ui.datatable.store;

@FunctionalInterface
public interface StoreDataChangeListener<T> {
    void onDataChanged(DataChangedEvent<T> dataChangedEvent);
}
