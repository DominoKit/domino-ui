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
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasWavesElement;

/** A utility class for configuring waves for a specific element */
public class WavesSupport implements HasWaveEffect<WavesSupport> {

  private static final CssClass dui_waves_effect = () -> "dui-waves-effect";
  private final DominoElement<Element> element;
  private final Waves wavesElement;
  private final SwapCssClass waveClass = SwapCssClass.of(WaveStyle.RIPPLE);

  private WavesSupport(HasWavesElement targetElement) {
    this(targetElement.getWavesElement());
  }

  private WavesSupport(Element targetElement) {
    this.element = elements.elementOf(targetElement);
    wavesElement = Waves.create(this.element);
  }

  /**
   * Adds waves support for a specific element
   *
   * @param element the {@link HasWavesElement}
   * @return new instance
   */
  public static WavesSupport addFor(HasWavesElement element) {
    return new WavesSupport(element).initWaves();
  }

  /**
   * Adds waves support for a specific element
   *
   * @param element the {@link HTMLElement}
   * @return new instance
   */
  public static WavesSupport addFor(Element element) {
    return new WavesSupport(element).initWaves();
  }

  /** {@inheritDoc} */
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

  /** {@inheritDoc} */
  @Override
  public WavesSupport setWaveStyle(WaveStyle waveStyle) {
    if (!hasWavesEffect()) {
      initWaves();
    }
    element.addCss(waveClass.replaceWith(waveStyle));
    return this;
  }

  /** {@inheritDoc} */
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

  public DominoElement<Element> getElement() {
    return element;
  }
}
