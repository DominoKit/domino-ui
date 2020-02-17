package org.dominokit.domino.ui.datatable;

@FunctionalInterface
public interface DirtyRecordHandler<T> {
    void onUpdateDirtyRecord(T dirty);
}