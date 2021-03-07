package org.dominokit.domino.ui.datatable;

/**
 * Implementations of this interface will receive an instance of the row dirty record to update it with the current values from editable cells
 * @param <T> the type of the data table records
 */
@FunctionalInterface
public interface DirtyRecordHandler<T> {
    /**
     *
     * @param dirty T a dirty copy of the table row record
     */
    void onUpdateDirtyRecord(T dirty);
}