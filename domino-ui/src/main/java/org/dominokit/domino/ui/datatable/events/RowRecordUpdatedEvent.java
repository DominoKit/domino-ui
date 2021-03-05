package org.dominokit.domino.ui.datatable.events;

import org.dominokit.domino.ui.datatable.TableRow;

/**
 * This event will be fired when the record of a specific row in the table has its record updated
 * @param <T> the type of the record
 */
public class RowRecordUpdatedEvent<T> implements TableEvent {

    /**
     * A constant string to define a unique type for this event
     */
    public static final String RECORD_UPDATED = "record-updated";

    private final TableRow<T> tableRow;

    /**
     *
     * @param tableRow the {@link TableRow} being updated
     */
    public RowRecordUpdatedEvent(TableRow<T> tableRow) {
        this.tableRow = tableRow;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getType() {
        return RECORD_UPDATED;
    }

    /**
     *
     * @return the {@link TableRow} being updated
     */
    public TableRow<T> getTableRow() {
        return tableRow;
    }
}
