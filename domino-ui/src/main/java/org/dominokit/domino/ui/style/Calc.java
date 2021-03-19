package org.dominokit.domino.ui.style;

/**
 * A utility class for creating {@code calc} CSS property
 */
public class Calc {

    /**
     * Creates calc by subtracting left from right
     *
     * @param left  the left value
     * @param right the right value
     * @return the string CSS property
     */
    public static String sub(String left, String right) {
        return "calc(" + left + " - " + right + ")";
    }

    /**
     * Creates calc by summation left from right
     *
     * @param left  the left value
     * @param right the right value
     * @return the string CSS property
     */
    public static String sum(String left, String right) {
        return "calc(" + left + " + " + right + ")";
    }

    /**
     * Creates calc with a size
     *
     * @param size the formulate string value
     * @return the string CSS property
     */
    public static String of(String size) {
        return "calc(" + size + ")";
    }
}
