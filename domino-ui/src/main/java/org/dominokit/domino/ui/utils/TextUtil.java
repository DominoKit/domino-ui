package org.dominokit.domino.ui.utils;

/**
 * Utility class to deal with text operations
 */
public class TextUtil {
    /**
     *
     * @param input String
     * @return same String with first letter capitalized
     */
    public static String firstLetterToUpper(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
}
