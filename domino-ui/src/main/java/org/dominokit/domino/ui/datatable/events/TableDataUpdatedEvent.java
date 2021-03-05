package org.dominokit.domino.ui.datatable.events;

import java.util.List;

/**
 * This event will be fired after the data in the table is changed
 * @param <T> the type of the table records
 */
public class TableDataUpdatedEvent<T> implements TableEvent {

    /**
     * A constant string to define a unique type for this event
     */
    public static final String DATA_UPDATED = "table-data-updated";

    private final List<T> data;
    private final int totalCount;

    /**
     *
     * @param data {@link List} of the new data records
     * @param totalCount int, the total count of the data
     */
    public TableDataUpdatedEvent(List<T> data, int totalCount) {
        this.data = data;
        this.totalCount = totalCount;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getType() {
        return DATA_UPDATED;
    }

    /**
     *
     * @return {@link List} of the new data records
     */
    public List<T> getData() {
        return data;
    }

    /**
     *
     * @return int, the total count of the data
     */
    public int getTotalCount() {
        return totalCount;
    }
}
