package org.dominokit.domino.ui.datatable;

@FunctionalInterface
public interface DirtyRecordProvider<T> {
    T createDirtyRecord(T original);
}