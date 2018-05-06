package org.dominokit.domino.ui.themes;

import org.dominokit.domino.ui.style.ColorScheme;

import static elemental2.dom.DomGlobal.document;
import static java.util.Objects.nonNull;

public class Theme {

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
