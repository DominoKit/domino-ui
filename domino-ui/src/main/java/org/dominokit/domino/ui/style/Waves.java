/*
 * Copyright © 2019 Dominokit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dominokit.domino.ui.style;

import elemental2.dom.DOMRect;
import elemental2.dom.Element;
import elemental2.dom.Event;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.MouseEvent;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.gwtproject.timer.client.Timer;

import static elemental2.dom.DomGlobal.window;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.utils.ElementsFactory.elements;
import static org.dominokit.domino.ui.events.EventType.mousedown;

/** Adds the required events to add waves for a target element */
public class Waves implements IsElement<Element> {

  private final DominoElement<? extends Element> target;
  private DivElement ripple;
  private JsPropertyMap<String> rippleStyle;
  private Timer delayTimer;
  private Timer removeTimer;
  private final int duration = 750;
  private final WavesEventListener wavesEventListener = new WavesEventListener();

  public Waves(Element target) {
    this(elements.elementOf(target));
  }

  public Waves(DominoElement<? extends Element> target) {
    this.target = target;
  }

  /**
   * Creates waves for a specific target element
   *
   * @param target the {@link Element} to add waves to
   * @return new instance
   */
  public static Waves create(Element target) {
    return new Waves(target);
  }

  /**
   * Creates waves for a specific target element
   *
   * @param target the {@link DominoElement} to add waves to
   * @return new instance
   */
  public static Waves create(DominoElement<? extends Element> target) {
    return new Waves(target);
  }

  /** Initialize the required event listeners for waves */
  public void initWaves() {
    if (isTargetDisabled()) return;

    target.addEventListener(mousedown.getName(), wavesEventListener);
  }

  /** Removes the event listeners that adds waves */
  public void removeWaves() {
    target.removeEventListener(mousedown.getName(), wavesEventListener);
  }

  private boolean isTargetDisabled() {
    return target.getAttribute("disabled") != null || target.style().containsCss("disabled");
  }

  private void setupStopTimers() {
    delayTimer =
        new Timer() {
          @Override
          public void run() {
            rippleStyle.set("opacity ", "0");

            ripple.setAttribute("style", convertStyle(rippleStyle));

            removeTimer =
                new Timer() {
                  @Override
                  public void run() {
                    ripple.removeCss("waves-rippling");
                    ripple.remove();
                  }
                };
            removeTimer.schedule(duration);
          }
        };

    delayTimer.schedule(300);
  }

  private void stopCurrentWave() {
    if (nonNull(delayTimer)) delayTimer.cancel();
    if (nonNull(removeTimer)) removeTimer.cancel();
    if (nonNull(ripple)) ripple.remove();
  }

  private String convertStyle(JsPropertyMap<String> rippleStyle) {
    StringBuilder style = new StringBuilder();
    rippleStyle.forEach(
        key -> style.append(key).append(":").append(rippleStyle.get(key)).append(";"));

    return style.toString();
  }

  /** {@inheritDoc} */
  @Override
  public Element element() {
    return target.element();
  }

  private ElementOffset offset(Element target) {
    Element docElem = target.ownerDocument.documentElement;
    DOMRect box = target.getBoundingClientRect();
    ElementOffset position = new ElementOffset();
    position.top = box.top + window.pageYOffset - docElem.clientTop;
    position.left = box.left + window.pageXOffset - docElem.clientLeft;
    return position;
  }

  private static class ElementOffset {
    private double top = 0;
    private double left = 0;
  }

  private final class WavesEventListener implements EventListener {

    @Override
    public void handleEvent(Event evt) {
      MouseEvent mouseEvent = Js.cast(evt);
      if (mouseEvent.button == 2) {
        return;
      }

      stopCurrentWave();

      ripple = elements.div().addCss("waves-ripple", "waves-rippling");
      target.appendChild(ripple);

      ElementOffset position = offset(target.element());
      double relativeY = (mouseEvent.pageY - position.top);
      double relativeX = (mouseEvent.pageX - position.left);

      relativeY = relativeY >= 0 ? relativeY : 0;
      relativeX = relativeX >= 0 ? relativeX : 0;

      int clientWidth = target.element().clientWidth;

      double scaleValue = (clientWidth * 0.01) * 3;
      String scale = "scale(" + scaleValue + ")";
      String translate = "translate(0,0)";

      rippleStyle = Js.cast(JsPropertyMap.of());

      rippleStyle.set("top", relativeY + "px");
      rippleStyle.set("left", relativeX + "px");
      ripple.addCss("waves-notransition");

      ripple.setAttribute("style", convertStyle(rippleStyle));

      ripple.removeCss("waves-notransition");

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
    }
  }
}
