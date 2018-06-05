package org.dominokit.domino.ui.style;

import elemental2.dom.HTMLElement;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.nonNull;

public class Style<T extends HTMLElement> implements IsElement<T> {

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

    public Style<T> setWidth(String width, boolean important) {
        if(important){
            setImportantProperty("width", width);
        }else {
            setProperty("width", width);
        }
        return this;
    }

    public Style<T> setMinWidth(String width){
        setProperty("min-width", width);
        return this;
    }

    public Style<T> setMinWidth(String width, boolean important) {
        if(important){
            setImportantProperty("min-width", width);
        }else {
            setProperty("min-width", width);
        }
        return this;
    }

    public Style<T> setMaxWidth(String width){
        setProperty("max-width", width);
        return this;
    }

    public Style<T> setMaxWidth(String width, boolean important) {
        if(important){
            setImportantProperty("max-width", width);
        }else {
            setProperty("max-width", width);
        }
        return this;
    }


    public Style<T> setTextAlign(String textAlign){
        setProperty("text-align", textAlign);
        return this;
    }

    public Style<T> setTextAlign(String textAlign, boolean important) {
        if(important){
            setImportantProperty("text-align", textAlign);
        }else {
            setProperty("text-align", textAlign);
        }
        return this;
    }

    public Style<T> setColor(String color){
        setProperty("color", color);
        return this;
    }

    public Style<T> setColor(String color, boolean important) {
        if(important){
            setImportantProperty("color", color);
        }else {
            setProperty("color", color);
        }
        return this;
    }


    public Style<T> setBackgroundColor(String color){
        setProperty("background-color", color);
        return this;
    }

    public Style<T> setBackgroundColor(String color, boolean important) {
        if(important){
            setImportantProperty("background-color", color);
        }else {
            setProperty("background-color", color);
        }
        return this;
    }

    public boolean hasClass(String cssClass) {
        if (nonNull(cssClass) && !cssClass.isEmpty())
            element.classList.contains(cssClass);
        return false;
    }


    @Override
    public T asElement() {
        return element;
    }
}
