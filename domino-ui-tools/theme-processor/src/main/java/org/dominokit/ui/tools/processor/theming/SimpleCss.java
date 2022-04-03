package org.dominokit.ui.tools.processor.theming;

public class SimpleCss {
    public String name;
    public String value;

    public SimpleCss(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public static SimpleCss of(String name, String value) {
        return new SimpleCss(name, value);
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
