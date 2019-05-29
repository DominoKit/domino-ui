package org.dominokit.domino.ui.style;

public enum WaveColor {

    RED("waves-red"),
    PINK("waves-pink"),
    PURPLE("waves-purple"),
    DEEP_PURPLE("waves-deep-purple"),
    INDIGO("waves-indigo"),
    BLUE("waves-blue"),
    LIGHT_BLUE("waves-light-blue"),
    CYAN("waves-cyan"),
    TEAL("waves-teal"),
    GREEN("waves-green"),
    LIGHT_GREEN("waves-light-green"),
    LIME("waves-lime"),
    YELLOW("waves-yellow"),
    AMBER("waves-amber"),
    ORANGE("waves-orange"),
    DEEP_ORANGE("waves-deep-orange"),
    BROWN("waves-brown"),
    GREY("waves-grey"),
    BLUE_GREY("waves-blue-grey"),
    BLACK("waves-black"),
    WHITE("waves-white"),
    LIGHT("waves-light"),
    THEME("waves-theme");

    private final String style;

    WaveColor(String style) {
        this.style=style;
    }

    public String getStyle() {
        return style;
    }
}
