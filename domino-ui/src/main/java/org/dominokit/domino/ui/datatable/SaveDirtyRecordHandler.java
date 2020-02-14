package org.dominokit.domino.ui.datatable;

@FunctionalInterface
public interface SaveDirtyRecordHandler<T> {
    void saveDirtyRecord(T originalRecord, T dirtyRecord);
}
