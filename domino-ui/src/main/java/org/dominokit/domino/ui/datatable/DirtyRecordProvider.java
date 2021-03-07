package org.dominokit.domino.ui.datatable;

/**
 * Implementations of this interface should return a dirty copy of a record from data table row to be used for editable data tables,
 * all changes applied to the dirty record will be reflected to the original record if saved or will be reverted if the edit is canceled
 * @param <T> the type of the data table records
 */
@FunctionalInterface
public interface DirtyRecordProvider<T> {
    /**
     *
     * @param original T the original record from the table row
     * @return T a copy of the original record.
     */
    T createDirtyRecord(T original);
}