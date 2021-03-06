package org.dominokit.domino.ui.datatable;

/**
 * The implementations of this interface will determine if a row in the table should be selectable or not
 * @param <T>
 */
public interface SelectionCondition<T> {
    /**
     *
     * @param table {@link DataTable}
     * @param tableRow {@link TableRow}
     * @return boolean, true if the row should be selectable otherwise it will not be selectable
     */
    boolean isAllowSelection(DataTable<T> table, TableRow<T> tableRow);
}