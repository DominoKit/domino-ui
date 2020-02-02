package org.dominokit.domino.ui.grid;

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

    public String getColumnsStyle() {
        return columnsStyle;
    }

    public int getCount() {
        return count;
    }
}
