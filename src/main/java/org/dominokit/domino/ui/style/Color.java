package org.dominokit.domino.ui.style;

public enum Color {

    RED("col-red", "RED", "#F44336"),
    PINK("col-pink", "PINK", "#E91E63"),
    PURPLE("col-purple", "PURPLE", "#9C27B0"),
    DEEP_PURPLE("col-deep-purple", "DEEP PURPLE", "#673AB7"),
    INDIGO("col-indigo", "INDIGO", "#3F51B5"),
    BLUE("col-blue", "BLUE", "#2196F3"),
    LIGHT_BLUE("col-light-blue", "LIGHT BLUE", "#03A9F4"),
    CYAN("col-cyan", "CYAN", "#00BCD4"),
    TEAL("col-teal", "TEAL", "#009688"),
    GREEN("col-green", "GREEN", "#4CAF50"),
    LIGHT_GREEN("col-light-green", "LIGHT GREEN", "#8BC34A"),
    LIME("col-lime", "LIME", "#CDDC39"),
    YELLOW("col-yellow", "YELLOW", "#FFEB3B"),
    AMBER("col-amber", "AMBER", "#FFC107"),
    ORANGE("col-orange", "ORANGE", "#FF9800"),
    DEEP_ORANGE("col-deep-orange", "DEEP ORANGE", "#FF5722"),
    BROWN("col-brown", "BROWN", "#795548"),
    GREY("col-grey", "GREY", "#9E9E9E"),
    BLUE_GREY("col-blue-grey", "BLUE GREY", "#607D8B"),
    BLACK("col-black", "BLACK", "#000000"),
    WHITE("col-white", "WHITE", "#FFFFFF");

    private final String style;
    private final String name;
    private final String hex;

    Color(String style, String name, String hex) {
        this.style=style;
        this.name = name;
        this.hex = hex;
    }

    public String getStyle() {
        return style;
    }

    public String getName() {
        return name;
    }

    public String getHex() {
        return hex;
    }
}
