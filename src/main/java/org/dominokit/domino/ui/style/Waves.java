package org.dominokit.domino.ui.style;

import elemental2.dom.*;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.gwtproject.timer.client.Timer;
import org.jboss.gwt.elemento.core.IsElement;

import static elemental2.dom.DomGlobal.window;
import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.EventType.mousedown;

public class Waves implements IsElement<HTMLElement> {

    private final HTMLElement target;
    private HTMLDivElement ripple;
    private JsPropertyMap<String> rippleStyle;
    private Timer delayTimer;
    private Timer removeTimer;
    private final int duration = 750;
    private double scaleValue;

    public Waves(HTMLElement target) {
        this.target = target;
        initWaves();
    }

    public static Waves create(HTMLElement target) {
        return new Waves(target);
    }

    private Node initWaves() {

        if (target.getAttribute("disabled") != null || target.classList.contains("disabled")) {
            return target;
        }

        target.addEventListener(mousedown.getName(), evt -> {

            MouseEvent mouseEvent = Js.cast(evt);
            if (mouseEvent.button == 2) {
                return;
            }

            stopCurrentWave();

            ripple = div().asElement();
            ripple.classList.add("waves-ripple", "waves-rippling");
            target.appendChild(ripple);

            ElementOffset position = offset(target);
            double relativeY = (mouseEvent.pageY - position.top);
            double relativeX = (mouseEvent.pageX - position.left);

            relativeY = relativeY >= 0 ? relativeY : 0;
            relativeX = relativeX >= 0 ? relativeX : 0;

            int clientWidth = target.clientWidth;

            scaleValue = (clientWidth * 0.01) * 3;
            String scale = "scale(" + scaleValue + ")";
            String translate = "translate(0,0)";

            rippleStyle = Js.cast(JsPropertyMap.of());

            rippleStyle.set("top", relativeY + "px");
            rippleStyle.set("left", relativeX + "px");
            ripple.classList.add("waves-notransition");

            ripple.setAttribute("style", convertStyle(rippleStyle));

            ripple.classList.remove("waves-notransition");

            rippleStyle.set("-webkit-transform", scale + " " + translate);
            rippleStyle.set("-moz-transform", scale + " " + translate);
            rippleStyle.set("-ms-transform", scale + " " + translate);
            rippleStyle.set("-o-transform", scale + " " + translate);
            rippleStyle.set("transform", scale + " " + translate);
            rippleStyle.set("opacity ", "1");

            rippleStyle.set("-webkit-transition-duration", duration + "ms");
            rippleStyle.set("-moz-transition-duration", duration + "ms");
            rippleStyle.set("-o-transition-duration", duration + "ms");
            rippleStyle.set("transition-duration", duration + "ms");

            ripple.setAttribute("style", convertStyle(rippleStyle));

            setupStopTimers();
        });

        return target;
    }

    private void setupStopTimers() {
        delayTimer = new Timer() {
            @Override
            public void run() {
                rippleStyle.set("opacity ", "0");

                ripple.setAttribute("style", convertStyle(rippleStyle));

                removeTimer = new Timer() {
                    @Override
                    public void run() {
                        ripple.classList.remove("waves-rippling");
                        ripple.remove();
                    }
                };
                removeTimer.schedule(duration);
            }
        };

        delayTimer.schedule(300);
    }

    private void stopCurrentWave() {
        if (nonNull(delayTimer))
            delayTimer.cancel();
        if (nonNull(removeTimer))
            removeTimer.cancel();
        if (nonNull(ripple))
            ripple.remove();
    }


    private String convertStyle(JsPropertyMap<String> rippleStyle) {
        StringBuilder style = new StringBuilder();
        rippleStyle.forEach(key -> {
            style.append(key + ":" + rippleStyle.get(key) + ";");
        });

        return style.toString();
    }

    @Override
    public HTMLElement asElement() {
        return target;
    }

    private ElementOffset offset(HTMLElement target) {

        Element docElem = target.ownerDocument.documentElement;
        ClientRect box = target.getBoundingClientRect();

        ElementOffset position = new ElementOffset();

        position.top = box.top + window.pageYOffset - docElem.clientTop;
        position.left = box.left + window.pageXOffset - docElem.clientLeft;

        return position;
    }

    private static class ElementOffset {
        private double top = 0;
        private double left = 0;
    }

}
