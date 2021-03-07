package org.dominokit.domino.ui.datatable;

/**
 * implementations of this interface will save changes from the dirty record into the original record
 * @param <T> the type of data table records
 */
@FunctionalInterface
public interface SaveDirtyRecordHandler<T> {
    /**
     *
     * @param originalRecord T the record in the table row
     * @param dirtyRecord T the dirty record that has changes
     */
    void saveDirtyRecord(T originalRecord, T dirtyRecord);
}
