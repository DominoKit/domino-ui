package org.dominokit.domino.ui.style;

public enum Background {

    RED("bg-red"),
    PINK("bg-pink"),
    PURPLE("bg-purple"),
    DEEP_PURPLE("bg-deep-purple"),
    INDIGO("bg-indigo"),
    BLUE("bg-blue"),
    LIGHT_BLUE("bg-light-blue"),
    CYAN("bg-cyan"),
    TEAL("bg-teal"),
    GREEN("bg-green"),
    LIGHT_GREEN("bg-light-green"),
    LIME("bg-lime"),
    YELLOW("bg-yellow"),
    AMBER("bg-amber"),
    ORANGE("bg-orange"),
    DEEP_ORANGE("bg-deep-orange"),
    BROWN("bg-brown"),
    GREY("bg-grey"),
    BLUE_GREY("bg-blue-grey"),
    BLACK("bg-black"),
    WHITE("bg-white"),
    THEME("bg-theme");

    private final String style;

    Background(String style) {
        this.style = style;
    }

    public String getStyle() {
        return style;
    }
}
