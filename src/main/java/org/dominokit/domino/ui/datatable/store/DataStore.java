package org.dominokit.domino.ui.datatable.store;

import org.dominokit.domino.ui.datatable.events.SearchEvent;
import org.dominokit.domino.ui.datatable.events.TableEventListener;

import java.util.List;

public interface DataStore<T> extends TableEventListener {
    void onDataChanged(StoreDataChangeListener<T> dataChangeListener);

    void removeDataChangeListener(StoreDataChangeListener<T> dataChangeListener);

    void load();

}

