package org.dominokit.domino.ui.utils;

import java.util.List;

public interface HasMultiSelectSupport<T>{
    List<T> getSelectedItems();
    boolean isMultiSelect();
    void setMultiSelect(boolean multiSelect);
    List<T> getTableRows();
    void onSelectionChange(T source);
    boolean isSelectable();
    default void selectAll(){}
    default void deselectAll(){}

}
