package org.dominokit.domino.ui.utils;

/**
 * This interface is used to implement multi-select capability to a component
 */
public interface HasMultiSelectionSupport {
    /**
     *
     * @return boolean, true if the component supports multi-selection, otherwise false
     */
    boolean isMultiSelect();

    /**
     *
     * @param multiSelect boolean, true if the component should support multi-selection, otherwise false
     */
    void setMultiSelect(boolean multiSelect);
}
