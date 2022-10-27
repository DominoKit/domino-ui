package org.dominokit.domino.ui.utils;

public final class DominoId {

    private static final String UNIQUE_ID = "id-";
    private static long counter = 0;

    /**
     * Creates an identifier guaranteed to be unique within this document. This is useful for allocating element IDs.
     */
    public static String unique() {
        return  UNIQUE_ID + counter++;
    }
}