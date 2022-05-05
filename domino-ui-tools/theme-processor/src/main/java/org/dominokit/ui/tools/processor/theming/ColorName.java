package org.dominokit.ui.tools.processor.theming;

public class ColorName {
    public String name;
    public ColorName(String name) {
        this.name = name;
    }

    public static ColorName of(String name) {
        return new ColorName(name);
    }

    public String getName() {
        return name;
    }
}
