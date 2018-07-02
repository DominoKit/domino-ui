package org.dominokit.domino.ui.datatable.events;

import org.dominokit.domino.ui.datatable.TableRow;

public class ExpandRecordEvent<T> implements TableEvent {

    public static final String EXPAND_RECORD="expand-record";

    private final TableRow<T> tableRow;

    public ExpandRecordEvent(TableRow<T> tableRow) {
        this.tableRow = tableRow;
    }

    @Override
    public String getType() {
        return EXPAND_RECORD;
    }

    public TableRow<T> getTableRow() {
        return tableRow;
    }
}
