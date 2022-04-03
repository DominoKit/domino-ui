package org.dominokit.ui.tools.processor.theming;

public class Media {
    public String name;
    public String value;

    public Media(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public static Media of(String name, String value) {
        return new Media(name, value);
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
