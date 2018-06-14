package org.dominokit.domino.ui.utils;

import elemental2.dom.Element;
import elemental2.dom.HTMLElement;
import elemental2.dom.KeyboardEvent;
import org.jboss.gwt.elemento.core.builder.HtmlContentBuilder;

import static java.util.Objects.nonNull;

public class ElementUtil {

    public static void clear(Element element){
        if(nonNull(element))
            while(nonNull(element.firstChild))
                element.removeChild(element.firstChild);
    }

    public static <T extends HTMLElement> HtmlContentBuilder<T> builderFor(T element){
        return new HtmlContentBuilder<>(element);
    }

    public static boolean isKeyOf(String keyCode, KeyboardEvent keyboardEvent) {
        return keyCode.equalsIgnoreCase(keyboardEvent.code);
    }

    public static boolean isEnterKey(KeyboardEvent keyboardEvent) {
        return isKeyOf("enter", keyboardEvent);
    }

    public static boolean isSpaceKey(KeyboardEvent keyboardEvent) {
        return isKeyOf("space", keyboardEvent);
    }
}
