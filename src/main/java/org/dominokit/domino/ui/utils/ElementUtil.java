package org.dominokit.domino.ui.utils;

import elemental2.dom.*;
import jsinterop.base.Js;
import org.dominokit.domino.ui.collapsible.Collapsible;
import org.dominokit.domino.ui.forms.TextBox;
import org.gwtproject.timer.client.Timer;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.core.ObserverCallback;
import org.jboss.gwt.elemento.core.builder.HtmlContentBuilder;

import java.util.function.Consumer;
import java.util.function.Predicate;

import static java.util.Objects.nonNull;

public class ElementUtil {

    public static void clear(Element element) {
        if (nonNull(element))
            while (nonNull(element.firstChild))
                element.removeChild(element.firstChild);
    }

    public static <T extends HTMLElement> HtmlContentBuilder<T> builderFor(T element) {
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

    /**
     * Registers a callback when an element is appended to the document body. Note that the callback will be called
     * only once, if the element is appended more than once a new callback should be registered.
     *
     * @param element  the HTML element which is going to be added to the body
     * @param callback {@link ObserverCallback}
     */
    public static void onAttach(HTMLElement element, ObserverCallback callback) {
//        Elements.onAttach(element, callback);
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

//        Elements.onDetach(element, callback);
        if (element != null) {
            BodyObserver.addDetachObserver(element, callback);
        }
    }

    public static TextBox numbersOnly(TextBox textBox) {
        textBox.getInputElement().addEventListener("keypress", evt -> {
            KeyboardEvent keyboardEvent = Js.uncheckedCast(evt);
            if (!keyboardEvent.key.matches("^\\d+$")) {
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

    public static void collapse(HTMLElement element){
        Collapsible.create(element).collapse();
    }

    public static void expand(HTMLElement element){
        Collapsible.create(element).expand();
    }

    public static void collapse(IsElement element){
        Collapsible.create(element).collapse();
    }

    public static void expand(IsElement element){
        Collapsible.create(element).expand();
    }

    /*
Element to slide gets the following CSS:
    max-height: 0;
    opacity: 0;
    overflow: hidden;
    transition: max-height 0.4s ease 0s;
*/

    /**
     * Like jQuery's slideDown function - uses CSS3 transitions
     * @param  {Node} elem Element to show and hide
     */
    public static void slideDown(HTMLElement element) {
        element.style.maxHeight = CSSProperties.MaxHeightUnionType.of(1000);
        // We're using a timer to set opacity = 0 because setting max-height = 0 doesn't (completely) hide the element.
        element.style.opacity   = CSSProperties.OpacityUnionType.of(1);
    }

    /**
     * Slide element up (like jQuery's slideUp)
     * @param  {Node} elem Element
     * @return {[type]}      [description]
     */
    public static void slideUp(HTMLElement element) {
        element.style.maxHeight = CSSProperties.MaxHeightUnionType.of(0);
        once( 1, () -> {
            element.style.opacity = CSSProperties.OpacityUnionType.of(0);
        });
    }

    /**
     * Call once after timeout
     * @param  {Number}   seconds  Number of seconds to wait
     * @param  {Function} callback Callback function
     */
    public static void once (int seconds, Ready ready) {
        int[] counter = new int[]{0};
        new Timer(){
            @Override
            public void run() {
                counter[0]++;
                if ( counter[0] >= seconds ) {
                    ready.onReady();
                    cancel();
                }
            }
        }.scheduleRepeating(400);

    }

    @FunctionalInterface
    private interface Ready{
        void onReady();
    }
}
