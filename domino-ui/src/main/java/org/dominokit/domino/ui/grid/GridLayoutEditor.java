package org.dominokit.domino.ui.grid;

/**
 * A utility class to redraw grid layout based on the configuration provided in {@link GridLayout}
 */
class GridLayoutEditor {

    private static final String G_CONTENT = "g-content";
    private static final String G_LEFT = "g-left";
    private static final String G_RIGHT = "g-right";
    private static final String G_HEADER = "g-header";
    private static final String G_FOOTER = "g-footer";

    private final String[][] gridTemplateAreas = new String[][]{
            {G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT},
            {G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT},
            {G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT},
            {G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT},
            {G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT},
            {G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT},
            {G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT},
            {G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT},
            {G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT},
            {G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT},
            {G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT},
            {G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT, G_CONTENT}
    };
    private SectionSpan headerSectionSpan = SectionSpan._1;
    private SectionSpan footerSectionSpan = SectionSpan._1;
    private SectionSpan leftSectionSpan = SectionSpan._3;
    private boolean leftSpanUp = false;
    private SectionSpan rightSectionSpan = SectionSpan._3;
    private boolean rightSpanUp = false;
    private boolean hasFooter = false;
    private boolean hasHeader = false;
    private boolean hasLeft = false;
    private boolean hasRight = false;


    void addHeader(SectionSpan sectionSpan) {
        removeHeader();
        this.hasHeader = true;
        this.headerSectionSpan = sectionSpan;
        for (int i = 0; i < sectionSpan.getValue(); i++) {
            for (int j = 0; j < gridTemplateAreas.length; j++) {
                String cellArea = gridTemplateAreas[i][j];
                if (cellArea.equals(G_CONTENT) || (cellArea.equals(G_LEFT) && !leftSpanUp) || (cellArea.equals(G_RIGHT) && !rightSpanUp)) {
                    gridTemplateAreas[i][j] = G_HEADER;
                }
            }
        }

    }

    void removeHeader() {
        this.hasHeader = false;
        for (int i = 0; i < headerSectionSpan.getValue(); i++) {
            for (int j = 0; j < gridTemplateAreas.length; j++) {
                if (gridTemplateAreas[i][j].equals(G_HEADER)) {
                    resetCell(i, j);
                }
            }
        }

    }


    void addRight(SectionSpan sectionSpan, boolean spanUp, boolean spanDown) {
        removeRight();
        this.hasRight = true;
        this.rightSectionSpan = sectionSpan;
        this.rightSpanUp = spanUp;

        int xStart = hasHeader() ? headerSectionSpan.getValue() : 0;
        int xEnd = hasFooter() ? gridTemplateAreas.length - footerSectionSpan.getValue() : gridTemplateAreas.length;
        int yStart = gridTemplateAreas.length - rightSectionSpan.getValue();
        int yEnd = gridTemplateAreas.length;
        for (int x = xStart; x < xEnd; x++) {
            for (int y = yStart; y < yEnd; y++) {
                gridTemplateAreas[x][y] = G_RIGHT;
            }
        }

        if (!hasHeader() || spanUp) {
            xStart = 0;
            xEnd = headerSectionSpan.getValue();
            yStart = gridTemplateAreas.length - rightSectionSpan.getValue();
            yEnd = gridTemplateAreas.length;
            for (int x = xStart; x < xEnd; x++) {
                for (int y = yStart; y < yEnd; y++) {
                    gridTemplateAreas[x][y] = G_RIGHT;
                }
            }
        }

        if (!hasFooter() || spanDown) {
            xStart = gridTemplateAreas.length - footerSectionSpan.getValue();
            xEnd = gridTemplateAreas.length;
            yStart = gridTemplateAreas.length - rightSectionSpan.getValue();
            yEnd = gridTemplateAreas.length;
            for (int x = xStart; x < xEnd; x++) {
                for (int y = yStart; y < yEnd; y++) {
                    gridTemplateAreas[x][y] = G_RIGHT;
                }
            }
        }

    }

    private boolean hasFooter() {
        return this.hasFooter;
    }

    void removeRight() {

        int xStart = hasHeader() ? headerSectionSpan.getValue() : 0;
        int xEnd = hasFooter() ? gridTemplateAreas.length - footerSectionSpan.getValue() : gridTemplateAreas.length;
        int yStart = gridTemplateAreas.length - rightSectionSpan.getValue();
        int yEnd = gridTemplateAreas.length;
        for (int x = xStart; x < xEnd; x++) {
            for (int y = yStart; y < yEnd; y++) {
                gridTemplateAreas[x][y] = G_CONTENT;
            }
        }

        if (hasHeader()) {
            xStart = 0;
            xEnd = headerSectionSpan.getValue();
            yStart = gridTemplateAreas.length - rightSectionSpan.getValue();
            yEnd = gridTemplateAreas.length;
            for (int x = xStart; x < xEnd; x++) {
                for (int y = yStart; y < yEnd; y++) {
                    gridTemplateAreas[x][y] = G_HEADER;
                }
            }
        }

        if (hasFooter()) {
            xStart = gridTemplateAreas.length - footerSectionSpan.getValue();
            xEnd = gridTemplateAreas.length;
            yStart = gridTemplateAreas.length - rightSectionSpan.getValue();
            yEnd = gridTemplateAreas.length;
            for (int x = xStart; x < xEnd; x++) {
                for (int y = yStart; y < yEnd; y++) {
                    gridTemplateAreas[x][y] = G_FOOTER;
                }
            }
        }

        this.hasRight = false;

    }

    void addLeft(SectionSpan sectionSpan, boolean spanUp, boolean spanDown) {
        removeLeft();
        this.hasLeft = true;
        this.leftSectionSpan = sectionSpan;
        this.leftSpanUp = spanUp;

        int xStart = hasHeader() ? headerSectionSpan.getValue() : 0;
        int xEnd = hasFooter() ? gridTemplateAreas.length - footerSectionSpan.getValue() : gridTemplateAreas.length;
        int yStart = 0;
        int yEnd = leftSectionSpan.getValue();
        for (int x = xStart; x < xEnd; x++) {
            for (int y = yStart; y < yEnd; y++) {
                gridTemplateAreas[x][y] = G_LEFT;
            }
        }

        if (!hasHeader() || spanUp) {
            xStart = 0;
            xEnd = headerSectionSpan.getValue();
            yStart = 0;
            yEnd = leftSectionSpan.getValue();
            for (int x = xStart; x < xEnd; x++) {
                for (int y = yStart; y < yEnd; y++) {
                    gridTemplateAreas[x][y] = G_LEFT;
                }
            }
        }

        if (!hasFooter() || spanDown) {
            xStart = gridTemplateAreas.length - footerSectionSpan.getValue();
            xEnd = gridTemplateAreas.length;
            yStart = 0;
            yEnd = leftSectionSpan.getValue();
            for (int x = xStart; x < xEnd; x++) {
                for (int y = yStart; y < yEnd; y++) {
                    gridTemplateAreas[x][y] = G_LEFT;
                }
            }
        }

    }

    void removeLeft() {
        int xStart = hasHeader() ? headerSectionSpan.getValue() : 0;
        int xEnd = hasFooter() ? gridTemplateAreas.length - footerSectionSpan.getValue() : gridTemplateAreas.length;
        int yStart = 0;
        int yEnd = leftSectionSpan.getValue();
        for (int x = xStart; x < xEnd; x++) {
            for (int y = yStart; y < yEnd; y++) {
                gridTemplateAreas[x][y] = G_CONTENT;
            }
        }

        if (hasHeader()) {
            xStart = 0;
            xEnd = headerSectionSpan.getValue();
            yStart = 0;
            yEnd = leftSectionSpan.getValue();
            for (int x = xStart; x < xEnd; x++) {
                for (int y = yStart; y < yEnd; y++) {
                    gridTemplateAreas[x][y] = G_HEADER;
                }
            }
        }

        if (hasFooter()) {
            xStart = gridTemplateAreas.length - footerSectionSpan.getValue();
            xEnd = gridTemplateAreas.length;
            yStart = 0;
            yEnd = leftSectionSpan.getValue();
            for (int x = xStart; x < xEnd; x++) {
                for (int y = yStart; y < yEnd; y++) {
                    gridTemplateAreas[x][y] = G_FOOTER;
                }
            }
        }

        this.hasLeft = false;

    }

    void addFooter(SectionSpan sectionSpan) {
        removeFooter();
        this.hasFooter = true;
        this.footerSectionSpan = sectionSpan;
        for (int i = gridTemplateAreas.length - sectionSpan.getValue(); i < gridTemplateAreas.length; i++) {
            for (int j = 0; j < gridTemplateAreas.length; j++) {
                String cellArea = gridTemplateAreas[i][j];
                if (cellArea.equals(G_CONTENT) || (cellArea.equals(G_LEFT) && !leftSpanUp) || (cellArea.equals(G_RIGHT) && !rightSpanUp)) {
                    gridTemplateAreas[i][j] = G_FOOTER;
                }
            }
        }

    }

    void removeFooter() {
        this.hasFooter = false;
        for (int i = gridTemplateAreas.length - footerSectionSpan.getValue(); i < gridTemplateAreas.length; i++) {
            for (int j = 0; j < gridTemplateAreas.length; j++) {
                if (gridTemplateAreas[i][j].equals(G_FOOTER)) {
                    resetCell(i, j);
                }
            }
        }

    }

    private void resetCell(int i, int j) {
        if (hasLeft() && j < leftSectionSpan.getValue()) {
            gridTemplateAreas[i][j] = G_LEFT;
        } else if (hasRight() && j > gridTemplateAreas.length - rightSectionSpan.getValue() - 1) {
            gridTemplateAreas[i][j] = G_RIGHT;
        } else {
            gridTemplateAreas[i][j] = G_CONTENT;
        }
    }

    private boolean hasHeader() {
        return this.hasHeader;
    }

    private boolean hasLeft() {
        return this.hasLeft;
    }

    private boolean hasRight() {
        return this.hasRight;
    }


    String gridAreasAsString() {
        StringBuilder sb = new StringBuilder();
        for (String[] gridTemplateArea : gridTemplateAreas) {
            sb.append("\"");
            for (String aGridTemplateArea : gridTemplateArea) {
                sb.append(aGridTemplateArea).append(" ");
            }
            sb.append("\"\n");
        }
        return sb.toString();
    }


}
