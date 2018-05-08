package org.dominokit.domino.ui.themes;


import org.dominokit.domino.ui.style.ColorScheme;

import static elemental2.dom.DomGlobal.document;
import static java.util.Objects.nonNull;

public class Theme {

    public static final ColorScheme RED=ColorScheme.RED;

    public static final ColorScheme PINK=ColorScheme.PINK;

    public static final ColorScheme PURPLE=ColorScheme.PURPLE;

    public static final ColorScheme DEEP_PURPLE=ColorScheme.DEEP_PURPLE;

    public static final ColorScheme INDIGO=ColorScheme.INDIGO;

    public static final ColorScheme BLUE=ColorScheme.BLUE;

    public static final ColorScheme LIGHT_BLUE=ColorScheme.LIGHT_BLUE;

    public static final ColorScheme CYAN=ColorScheme.CYAN;

    public static final ColorScheme TEAL=ColorScheme.TEAL;

    public static final ColorScheme GREEN=ColorScheme.GREEN;

    public static final ColorScheme LIGHT_GREEN=ColorScheme.LIGHT_GREEN;

    public static final ColorScheme LIME=ColorScheme.LIME;

    public static final ColorScheme YELLOW=ColorScheme.YELLOW;

    public static final ColorScheme AMBER=ColorScheme.AMBER;

    public static final ColorScheme ORANGE=ColorScheme.ORANGE;

    public static final ColorScheme DEEP_ORANGE=ColorScheme.DEEP_ORANGE;

    public static final ColorScheme BROWN=ColorScheme.BROWN;

    public static final ColorScheme GREY=ColorScheme.GREY;

    public static final ColorScheme BLUE_GREY=ColorScheme.BLUE_GREY;

    public static final ColorScheme BLACK=ColorScheme.BLACK;

    public static final ColorScheme WHITE=ColorScheme.WHITE;

    public static final ColorScheme TRANSPARENT=ColorScheme.TRANSPARENT;

    private final ColorScheme scheme;
    private final String themeStyle;
    private final String name;

    public static Theme currentTheme = new Theme(ColorScheme.RED);

    public Theme(ColorScheme scheme) {
        this.scheme = scheme;
        this.themeStyle=scheme.color().getStyle().replace("col-","theme-");
        this.name=scheme.color().getName().replace(" ","_").toLowerCase();
    }

    public ColorScheme getScheme() {
        return scheme;
    }

    public String getThemeStyle() {
        return themeStyle;
    }

    public String getName() {
        return name;
    }

    public void apply() {
        if (nonNull(currentTheme))
            document.body.classList.remove(currentTheme.themeStyle);
        this.currentTheme = this;
        document.body.classList.add(themeStyle);
    }
}
