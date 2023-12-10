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

import static elemental2.dom.DomGlobal.window;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.events.EventType.mousedown;
import static org.dominokit.domino.ui.utils.Domino.*;
import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

import elemental2.dom.*;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.gwtproject.timer.client.Timer;

/**
 * Provides a ripple (or "wave") effect on a given DOM element.
 *
 * <p>The ripple effect is typically used in material design to indicate user interaction.
 */
public class Waves implements IsElement<Element> {

  private final DivElement target;
  DivElement ripple;
  private JsPropertyMap<String> rippleStyle;
  private Timer delayTimer;
  private Timer removeTimer;
  private final int duration = 750;
  private final WavesEventListener wavesEventListener = new WavesEventListener();

  /**
   * Constructs a wave effect wrapper for a given target.
   *
   * @param target The DOM element on which the ripple effect will be applied.
   */
  public Waves(Element target) {
    this(elements.elementOf(target));
  }

  /**
   * Constructs a wave effect wrapper for a given {@link DominoElement}.
   *
   * <p>This constructor wraps the target in a sentinel div which is then used to handle the ripple
   * effect. The sentinel div is appended as a child to the target element.
   *
   * @param target The {@link DominoElement} on which the ripple effect will be applied.
   */
  public Waves(DominoElement<? extends Element> target) {
    this.target = elements.div().addCss("dui-wave-sentinel");
    elements.elementOf(target).addCss("dui-waves-target").appendChild(this.target);
  }

  /**
   * Factory method for creating a wave effect for a given target.
   *
   * @param target The DOM element target.
   * @return A new {@link Waves} instance.
   */
  public static Waves create(Element target) {
    return new Waves(target);
  }

  /**
   * Factory method to create a {@link Waves} instance for a given {@link DominoElement}.
   *
   * <p>This method provides a more expressive way to construct a `Waves` object compared to using
   * the direct constructor.
   *
   * @param target The {@link DominoElement} on which the ripple effect will be applied.
   * @return A new {@link Waves} instance associated with the provided target.
   */
  public static Waves create(DominoElement<? extends Element> target) {
    return new Waves(target);
  }

  /** Initializes the wave effect on the target. */
  public void initWaves() {
    if (isTargetDisabled()) return;

    target.addEventListener(mousedown.getName(), wavesEventListener);
  }

  /**
   * Removes the wave (ripple) effect from the target element.
   *
   * <p>This method detaches the wave event listener from the target and subsequently removes the
   * sentinel div (used for the ripple effect) from the DOM.
   */
  public void removeWaves() {
    target.removeEventListener(mousedown.getName(), wavesEventListener);
    this.target.remove();
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
                    ripple.removeCss("dui-waves-rippling");
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

  /** Represents an event listener to trigger and manage the wave effect on the target. */
  private final class WavesEventListener implements EventListener {

    @Override
    public void handleEvent(Event evt) {
      MouseEvent mouseEvent = Js.cast(evt);
      if (mouseEvent.button == 2) {
        return;
      }

      stopCurrentWave();

      ripple = elements.div().addCss("dui-waves-ripple", "dui-waves-rippling");
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
      ripple.addCss("dui-waves-notransition");

      ripple.setAttribute("style", convertStyle(rippleStyle));

      ripple.removeCss("dui-waves-notransition");

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
