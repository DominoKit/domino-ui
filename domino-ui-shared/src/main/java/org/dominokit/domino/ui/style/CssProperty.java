package org.dominokit.domino.ui.style;

import elemental2.dom.Element;
import org.dominokit.domino.ui.IsElement;

public class CssProperty implements IsCssProperty{
    private final String name;
    private final String value;

    public static CssProperty of(String name, String value){
        return new CssProperty(name, value);
    }

    private CssProperty(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public void apply(Element element){
        Style.of(element).setCssProperty(name, value);
    }

    @Override
    public void remove(Element element) {
        Style.of(element).removeCssProperty(name);
    }
}
