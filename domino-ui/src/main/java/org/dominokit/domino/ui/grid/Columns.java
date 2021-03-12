package org.dominokit.domino.ui.grid;

/**
 * An enum representing the number of columns a row can have
 */
public enum Columns {
    _12(GridStyles.ROW_12, 12),
    _16(GridStyles.ROW_16, 16),
    _18(GridStyles.ROW_18, 18),
    _24(GridStyles.ROW_24, 24),
    _32(GridStyles.ROW_32, 32);

    private String columnsStyle;
    private int count;

    Columns(String columnsStyle, int count) {
        this.columnsStyle = columnsStyle;
        this.count = count;
    }

    /**
     * @return The style of the row based on the columns count
     */
    public String getColumnsStyle() {
        return columnsStyle;
    }

    /**
     * @return The number of columns
     */
    public int getCount() {
        return count;
    }
}
