package org.dominokit.domino.ui.datatable.events;

import org.dominokit.domino.ui.datatable.TableRow;

/**
 * This event will be fired by the {@link org.dominokit.domino.ui.datatable.plugins.RecordDetailsPlugin} when a record is expanded
 * @param <T> the type of the record.
 */
public class ExpandRecordEvent<T> implements TableEvent {

    /**
     * A constant string to define a unique type for this event
     */
    public static final String EXPAND_RECORD="expand-record";

    private final TableRow<T> tableRow;

    /**
     *
     * @param tableRow the {@link TableRow} being expanded
     */
    public ExpandRecordEvent(TableRow<T> tableRow) {
        this.tableRow = tableRow;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getType() {
        return EXPAND_RECORD;
    }

    /**
     *
     * @return the {@link TableRow} being expanded
     */
    public TableRow<T> getTableRow() {
        return tableRow;
    }
}
