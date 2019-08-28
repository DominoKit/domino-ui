package org.dominokit.domino.ui.datatable;

public interface SelectionCondition<T> {
    boolean isAllowSelection(DataTable<T> table, TableRow<T> tableRow);
}