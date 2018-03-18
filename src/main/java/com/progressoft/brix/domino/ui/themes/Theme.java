package com.progressoft.brix.domino.ui.themes;

import elemental2.dom.DomGlobal;

import static java.util.Objects.nonNull;

public enum Theme {
    RED("theme-red", "Red", "red"),
    PINK("theme-pink", "Pink", "pink"),
    PURPLE("theme-purple", "Purple", "purple"),
    DEEP_PURPLE("theme-deep-purple", "Deep purple", "deep_purple"),
    INDIGO("theme-indigo", "Indigo", "indigo"),
    BLUE("theme-blue", "Blue", "blue"),
    LIGHT_BLUE("theme-light-blue", "Light blue", "light_blue"),
    CYAN("theme-cyan", "Cyan", "cyan"),
    TEAL("theme-teal", "Teal", "teal"),
    GREEN("theme-green", "Green", "green"),
    LIGHT_GREEN("theme-light-green", "Light green", "light_green"),
    LIME("theme-lime", "Lime", "lime"),
    YELLOW("theme-yellow", "Yellow", "yellow"),
    AMBER("theme-amber", "Amber", "amber"),
    ORANGE("theme-orange", "Orange", "orange"),
    DEEP_ORANGE("theme-deep-orange", "Deep orange", "deep_orange"),
    BROWN("theme-brown", "Brown", "brown"),
    GREY("theme-grey", "Grey", "grey"),
    BLUE_GREY("theme-blue-grey", "Blue grey", "blue_grey"),
    BLACK("theme-black", "Black", "black");

    private final String themeStyle;
    private final String name;
    private final String key;

    public static Theme currentTheme = Theme.RED;

    Theme(String themeStyle, String name, String key) {
        this.themeStyle = themeStyle;
        this.name = name;
        this.key = key;
    }

    public static Theme of(String themeKey) {
        switch (themeKey) {
            case "red":
                return Theme.RED;

            case "pink":
                return Theme.PINK;

            case "purple":
                return Theme.PURPLE;

            case "deep_purple":
                return Theme.DEEP_PURPLE;

            case "indigo":
                return Theme.INDIGO;

            case "blue":
                return Theme.BLUE;

            case "light_blue":
                return Theme.LIGHT_BLUE;

            case "cyan":
                return Theme.CYAN;

            case "teal":
                return Theme.TEAL;

            case "green":
                return Theme.GREEN;

            case "light_green":
                return Theme.LIGHT_GREEN;

            case "lime":
                return Theme.LIME;

            case "yellow":
                return Theme.YELLOW;

            case "amber":
                return Theme.AMBER;

            case "orange":
                return Theme.ORANGE;

            case "deep_orange":
                return Theme.DEEP_ORANGE;

            case "brown":
                return Theme.BROWN;

            case "grey":
                return Theme.GREY;

            case "blue_grey":
                return Theme.BLUE_GREY;

            case "black":
                return Theme.BLACK;
            default:
                return currentTheme;
        }
    }

    public String getThemeStyle() {
        return themeStyle;
    }

    public String getName() {
        return name;
    }

    public String getKey() {
        return key;
    }

    public void apply() {
        if (nonNull(currentTheme))
            DomGlobal.document.body.classList.remove(currentTheme.themeStyle);
        this.currentTheme = this;

        DomGlobal.document.body.classList.add(themeStyle);
    }
}
