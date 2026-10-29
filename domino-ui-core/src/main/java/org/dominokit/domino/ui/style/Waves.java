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

import static org.dominokit.domino.ui.utils.Unit.px;

import elemental2.dom.AddEventListenerOptions;
import elemental2.dom.DOMRect;
import elemental2.dom.Element;
import elemental2.dom.EventListener;
import elemental2.dom.MouseEvent;
import jsinterop.base.Js;
import org.dominokit.domino.ui.IsElement;

/**
 * Provides a ripple (or "wave") effect on a given DOM element.
 *
 * <p>The ripple effect is typically used in material design to indicate user interaction.
 */
public class Waves implements IsElement<Element> {

  public static final CssClass dui_ripple_wave = () -> "dui-ripple-wave";
  public static final CssClass dui_ripple_wave_active = () -> "dui-ripple-wave-active";

  private final Element target;
  private EventListener waveListener;

  /**
   * Constructs a wave effect wrapper for a given target.
   *
   * @param target The DOM element on which the ripple effect will be applied.
   */
  public Waves(Element target) {
    this.target = target;
    Style.of(target).addCss(dui_ripple_wave);
    waveListener =
        evt -> {
          if (!target.hasAttribute("disabled")) {
            MouseEvent e = Js.uncheckedCast(evt);
            DOMRect rect = target.getBoundingClientRect();
            // Determine the maximum dimension for full coverage
            double size = Math.max(rect.width, rect.height);
            // Calculate coordinates so that the ripple centers on the click position
            double x = e.clientX - rect.left - size / 2;
            double y = e.clientY - rect.top - size / 2;

            // Set CSS custom properties for the pseudo-element
            Style<Element> targetStyle = Style.of(target);
            targetStyle.setCssProperty("--dui-ripple-x", px.of(x));
            targetStyle.setCssProperty("--dui-ripple-y", px.of(y));
            targetStyle.setCssProperty("--dui-ripple-size", px.of(size));

            // Add the class to trigger the ripple animation
            targetStyle.addCss(dui_ripple_wave_active);

            AddEventListenerOptions addEventListenerOptions = AddEventListenerOptions.create();
            addEventListenerOptions.setOnce(true);
            // Remove the class after animation completes so it can be triggered again
            target.addEventListener(
                "animationend",
                event -> Style.of(target).removeCss(dui_ripple_wave_active),
                addEventListenerOptions);
          }
        };
    target.addEventListener("click", waveListener);
  }

  /** Constructs a wave effect wrapper for an element abstraction. */
  public Waves(IsElement<? extends Element> target) {
    this(target.element());
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

  /** Factory method to create a Waves instance for an element abstraction. */
  public static Waves create(IsElement<? extends Element> target) {
    return new Waves(target);
  }

  /**
   * Removes the wave (ripple) effect from the target element.
   *
   * <p>This method detaches the wave event listener from the target and subsequently removes the
   * sentinel div (used for the ripple effect) from the DOM.
   */
  public void removeWaves() {
    Style.of(target).removeCss(dui_ripple_wave_active);
    Style.of(target).removeCss(dui_ripple_wave);
    target.removeEventListener("click", waveListener);
  }

  @Override
  public Element element() {
    return this.target;
  }
}
