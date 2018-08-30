package org.dominokit.domino.ui.utils;

import com.google.gwt.i18n.client.NumberFormat;
import elemental2.dom.*;
import jsinterop.base.Js;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Row;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.core.ObserverCallback;
import org.jboss.gwt.elemento.core.builder.HtmlContentBuilder;

import java.util.Arrays;
import java.util.List;

import static java.util.Objects.nonNull;

public class ElementUtil {

    private static final List<String> navigationKeies = Arrays.asList("Backspace", "Delete", "ArrowUp", "ArrowDown", "ArrowRight", "ArrowLeft", "Tab", "Escape");
    private static final List<String> decimalKeies = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "-", ".");

    public static void clear(Element element) {
        if (nonNull(element))
            while (nonNull(element.firstChild))
                element.removeChild(element.firstChild);
    }

    public static <T extends HTMLElement> HtmlContentBuilder<T> contentBuilder(T element) {
        return new HtmlContentBuilder<>(element);
    }

    public static <E extends HTMLElement, T extends IsElement<E>> HtmlComponentBuilder<E,T> componentBuilder(T element) {
        return new HtmlComponentBuilder<>(element);
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

    /**
     * Registers a callback when an element is appended to the document body. Note that the callback will be called
     * only once, if the element is appended more than once a new callback should be registered.
     *
     * @param element  the HTML element which is going to be added to the body
     * @param callback {@link ObserverCallback}
     */
    public static void onAttach(HTMLElement element, ObserverCallback callback) {
        if (element != null) {
            BodyObserver.addAttachObserver(element, callback);
        }
    }

    /**
     * Registers a callback when an element is removed from the document body. Note that the callback will be called
     * only once, if the element is removed and re-appended a new callback should be registered.
     *
     * @param element  the HTML element which is going to be removed from the body
     * @param callback {@link ObserverCallback}
     */
    public static void onDetach(HTMLElement element, ObserverCallback callback) {

        if (element != null) {
            BodyObserver.addDetachObserver(element, callback);
        }
    }

    public static TextBox numbersOnly(TextBox textBox) {

        textBox.getInputElement().addEventListener("keypress", evt -> {
            KeyboardEvent keyboardEvent = Js.uncheckedCast(evt);
            if (!navigationKeies.contains(keyboardEvent.key) && !keyboardEvent.key.matches("^\\d+$")) {
                evt.preventDefault();
            }
        });
        textBox.getInputElement().addEventListener("paste", evt -> {
            ClipboardEvent clipboardEvent = Js.uncheckedCast(evt);
            if (!clipboardEvent.clipboardData.getData("text").matches("^\\d+$")) {
                evt.preventDefault();
            }
        });
        return textBox;
    }

    public static TextBox decimalOnly(TextBox textBox) {

        textBox.getInputElement().addEventListener("keypress", evt -> {

            KeyboardEvent keyboardEvent = Js.uncheckedCast(evt);
            String key = keyboardEvent.key;
            if (!(decimalKeies.contains(key) || navigationKeies.contains(key)) || (key.equals(".") && textBox.getValue().contains("."))) {
                evt.preventDefault();
            }

        });
        textBox.getInputElement().addEventListener("paste", evt -> {
            ClipboardEvent clipboardEvent = Js.uncheckedCast(evt);
            try {
                NumberFormat.getDecimalFormat().parse(clipboardEvent.clipboardData.getData("text"));
            } catch (Exception ex) {
                evt.preventDefault();
            }

        });
        return textBox;
    }

    public static void scrollTop() {
        DomGlobal.document.body.scrollTop = 0;
        DomGlobal.document.documentElement.scrollTop = 0;
    }

    public static void scrollToElement(IsElement isElement) {
        scrollToElement(isElement.asElement());
    }

    public static void scrollToElement(HTMLElement element) {
        element.scrollIntoView();
    }

    public static void test() {
        Row.create()
                .span1(column -> {

                });
    }

}
