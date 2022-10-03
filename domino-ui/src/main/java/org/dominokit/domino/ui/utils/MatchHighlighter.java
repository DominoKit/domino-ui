package org.dominokit.domino.ui.utils;

import static java.util.Objects.isNull;

public class MatchHighlighter {

    private static final String prefix ="<mark>";
    private static final String postfix ="</mark>";

    public static String highlight(String source, String part) {
        if(isNull(part) || isNull(source) || part.isEmpty() || source.isEmpty() || !containsPart(source, part)){
            return sourceOrEmpty(source);
        }
        int startIndex = source.toLowerCase().indexOf(part.toLowerCase());
        String partInSource= source.substring(startIndex, startIndex+part.length());
        String result = source.replace(partInSource, prefix+partInSource+postfix);
        return result;
    }

    private static boolean containsPart(String source, String part) {
        return source.toLowerCase().contains(part.toLowerCase());
    }

    private static String sourceOrEmpty(String source) {
        return isNull(source) ? "" : source;
    }
}
