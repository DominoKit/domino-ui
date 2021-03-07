package org.dominokit.domino.ui.datatable;

/**
 * Implementations of this interface can listen to columns show/hide events
 */
public interface ColumnShowHideListener {
    /**
     *
     * @param visible boolean, if true the column has become visible, otherwise it is hidden
     */
    void onShowHide(boolean visible);

    /**
     *
     * @return boolean, if true the listener wont be removed if the listeners of the column are cleared.
     */
    boolean isPermanent();
}
