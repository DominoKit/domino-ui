package org.dominokit.ui.tools.processor.theming;

public class Color {
    public String name;
    public String hex;

    public Color(String name, String hex) {
        this.name = name;
        this.hex = hex;
    }

    public static Color of(String name, String hex) {
        return new Color(name, hex);
    }

    public String getName() {
        return name;
    }

    public String getHex() {
        return hex;
    }
}
