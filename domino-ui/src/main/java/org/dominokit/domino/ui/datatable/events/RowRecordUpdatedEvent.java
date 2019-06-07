package org.dominokit.domino.ui.datatable.events;

import org.dominokit.domino.ui.datatable.TableRow;

public class RowRecordUpdatedEvent<T> implements TableEvent {

    public static final String RECORD_UPDATED = "record-updated";

    private final TableRow<T> tableRow;

    public RowRecordUpdatedEvent(TableRow<T> tableRow) {
        this.tableRow = tableRow;
    }

    @Override
    public String getType() {
        return RECORD_UPDATED;
    }

    public TableRow<T> getTableRow() {
        return tableRow;
    }
}
