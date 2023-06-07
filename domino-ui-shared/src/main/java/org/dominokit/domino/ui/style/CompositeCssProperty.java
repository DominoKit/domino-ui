package org.dominokit.domino.ui.style;

import elemental2.dom.Element;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CompositeCssProperty implements IsCssProperty{

    private Set<CssProperty> cssProperties = new HashSet<>();

    public static CompositeCssProperty of(Collection<CssProperty> cssProperties) {
        return new CompositeCssProperty(cssProperties);
    }

    public static CompositeCssProperty of(CssProperty... cssProperties) {
        return new CompositeCssProperty(cssProperties);
    }

    public CompositeCssProperty(Collection<CssProperty> cssProperties) {
        this.cssProperties.addAll(cssProperties);
    }

    public CompositeCssProperty(CssProperty... cssProperties) {
        this(Arrays.asList(cssProperties));
    }

    @Override
    public void apply(Element element) {
        cssProperties.forEach(cssProperty -> cssProperty.apply(element));
    }

    @Override
    public void remove(Element element) {
        cssProperties.forEach(cssProperty -> cssProperty.remove(element));
    }
}
