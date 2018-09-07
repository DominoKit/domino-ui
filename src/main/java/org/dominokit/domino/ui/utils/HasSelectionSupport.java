package org.dominokit.domino.ui.utils;

import java.util.List;

public interface HasSelectionSupport<T> {

    List<T> getSelectedItems();

    List<T> getTableRows();

    void onSelectionChange(T source);

    boolean isSelectable();

    default void selectAll() {
    }

    default void deselectAll() {
    }
}
