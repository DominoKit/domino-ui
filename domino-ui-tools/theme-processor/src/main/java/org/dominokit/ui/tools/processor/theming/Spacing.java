package org.dominokit.ui.tools.processor.theming;

public class Spacing {
    public String name;
    public String value;

    public Spacing(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public static Spacing of(String name, String value) {
        return new Spacing(name, value);
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
