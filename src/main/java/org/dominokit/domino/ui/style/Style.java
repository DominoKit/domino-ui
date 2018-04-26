package org.dominokit.domino.ui.style;

import elemental2.dom.HTMLElement;
import org.jboss.gwt.elemento.core.IsElement;

public class Style<T extends HTMLElement> {

    private T element;

    public Style(T element){
        this.element=element;
    }

    public static <T extends HTMLElement> Style<T> of(T htmlElement){
        return new Style<>(htmlElement);
    }

    public static <T extends HTMLElement> Style<T> of(IsElement<T> htmlElement){
        return new Style<>(htmlElement.asElement());
    }

    public Style<T> setProperty(String name, String value){
        element.style.setProperty(name, value);
        return this;
    }

    public Style<T> setImportantProperty(String name, String value){
        element.style.setProperty(name, value, "important");
        return this;
    }


}
