package org.dominokit.domino.ui.style;

import elemental2.dom.HTMLElement;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.nonNull;

public class Style<T extends HTMLElement> {

    private T element;

    public Style(T element) {
        this.element = element;
    }

    public static <T extends HTMLElement> Style<T> of(T htmlElement) {
        return new Style<>(htmlElement);
    }

    public static <T extends HTMLElement> Style<T> of(IsElement<T> htmlElement) {
        return new Style<>(htmlElement.asElement());
    }

    public Style<T> setProperty(String name, String value) {
        element.style.setProperty(name, value);
        return this;
    }

    public Style<T> setImportantProperty(String name, String value) {
        element.style.setProperty(name, value, "important");
        return this;
    }

    public Style<T> addClass(String cssClass) {
        if (nonNull(cssClass) && !cssClass.isEmpty())
            element.classList.add(cssClass);
        return this;
    }

    public Style<T> addClass(String... cssClasses) {
        if (nonNull(cssClasses) && cssClasses.length > 0)
            element.classList.add(cssClasses);
        return this;
    }

    public Style<T> removeClass(String cssClass) {
        if (nonNull(cssClass) && !cssClass.isEmpty())
            element.classList.remove(cssClass);
        return this;
    }

    public Style<T> removeClass(String... cssClasses) {
        if (nonNull(cssClasses) && cssClasses.length > 0)
            element.classList.remove(cssClasses);
        return this;
    }

    public Style<T> replaceClass(String cssClass, String replacementClass){
        if(hasClass(cssClass)) {
            removeClass(cssClass);
            addClass(replacementClass);
        }
        return this;
    }

    public Style<T> setWidth(String width){
        setProperty("width", width);
        return this;
    }

    public boolean hasClass(String cssClass) {
        if (nonNull(cssClass) && !cssClass.isEmpty())
            element.classList.contains(cssClass);
        return false;
    }



}
