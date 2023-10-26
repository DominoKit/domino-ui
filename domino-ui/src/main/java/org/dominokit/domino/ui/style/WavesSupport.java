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

import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

import elemental2.dom.Element;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasWavesElement;

/**
 * Provides support for the Waves (ripple) effect on elements.
 *
 * <p>This class encapsulates the logic for adding, modifying, and removing the Waves effect from
 * any given element.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>
 * Element someElement = ...;
 * WavesSupport wavesSupport = WavesSupport.addFor(someElement);
 * wavesSupport.setWaveStyle(WaveStyle.RIPPLE);
 * </pre>
 */
public class WavesSupport implements HasWaveEffect<WavesSupport> {

  private static final CssClass dui_waves_effect = () -> "dui-waves-effect";
  private final DominoElement<Element> element;
  private final Waves wavesElement;
  private final SwapCssClass waveClass = SwapCssClass.of(WaveStyle.RIPPLE);

  /**
   * Private constructor for initializing WavesSupport with a {@link HasWavesElement}.
   *
   * @param targetElement target element that implements {@link HasWavesElement}.
   */
  private WavesSupport(HasWavesElement targetElement) {
    this(targetElement.getWavesElement());
  }

  /**
   * Private constructor for initializing WavesSupport with a DOM {@link Element}.
   *
   * @param targetElement target DOM element.
   */
  private WavesSupport(Element targetElement) {
    this.element = elements.elementOf(targetElement);
    wavesElement = Waves.create(this.element);
  }

  /**
   * Adds Waves effect for the provided {@link HasWavesElement} and initializes it.
   *
   * @param element the target element that implements {@link HasWavesElement}.
   * @return an instance of {@link WavesSupport}.
   */
  public static WavesSupport addFor(HasWavesElement element) {
    return new WavesSupport(element).initWaves();
  }

  /**
   * Adds Waves effect for the provided DOM {@link Element} and initializes it.
   *
   * @param element the target DOM element.
   * @return an instance of {@link WavesSupport}.
   */
  public static WavesSupport addFor(Element element) {
    return new WavesSupport(element).initWaves();
  }

  /**
   * Initializes the Waves (ripple) effect on the element.
   *
   * @return the current instance of {@link WavesSupport} for chaining.
   */
  @Override
  public WavesSupport initWaves() {
    if (!hasWavesEffect()) {
      element.addCss(dui_waves_effect);
      wavesElement.initWaves();
    }
    return this;
  }

  private boolean hasWavesEffect() {
    return dui_waves_effect.isAppliedTo(element);
  }

  /**
   * Sets the style of the Waves (ripple) effect on the element.
   *
   * @param waveStyle the desired {@link WaveStyle}.
   * @return the current instance of {@link WavesSupport} for chaining.
   */
  @Override
  public WavesSupport setWaveStyle(WaveStyle waveStyle) {
    if (!hasWavesEffect()) {
      initWaves();
    }
    element.addCss(waveClass.replaceWith(waveStyle));
    return this;
  }

  /**
   * Removes the Waves (ripple) effect from the element.
   *
   * @return the current instance of {@link WavesSupport} for chaining.
   */
  @Override
  public WavesSupport removeWaves() {
    dui_waves_effect.remove(element);
    waveClass.remove(element);
    removeWaveStyles();
    wavesElement.removeWaves();
    return this;
  }

  private void removeWaveStyles() {
    for (int i = 0; i < element.style().cssClassesCount(); ++i) {
      String style = element.style().cssClassByIndex(i);
      if (style.contains("waves-")) element.removeCss(style);
    }
  }

  /**
   * Gets the {@link DominoElement} associated with this WavesSupport.
   *
   * @return the {@link DominoElement} instance.
   */
  public DominoElement<Element> getElement() {
    return element;
  }
}
