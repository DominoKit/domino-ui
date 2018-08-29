package org.dominokit.domino.ui.grid;

public enum Columns {
    _12("row-12", 12), _16("row-16", 16), _18("row-18", 18), _24("row-24", 24), _32("row-32", 32);

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
