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

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasWavesElement;

/** A utility class for configuring waves for a specific element */
public class WavesSupport implements HasWaveEffect<WavesSupport> {

  private static final String WAVES_EFFECT = "waves-effect";
  private final DominoElement<HTMLElement> element;

  private String waveColor;
  private final Waves wavesElement;

  private WavesSupport(HasWavesElement targetElement) {
    this(targetElement.getWavesElement());
  }

  private WavesSupport(HTMLElement targetElement) {
    this.element = DominoElement.of(targetElement);
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
  public static WavesSupport addFor(HTMLElement element) {
    return new WavesSupport(element).initWaves();
  }

  /** {@inheritDoc} */
  @Override
  public WavesSupport initWaves() {
    if (!hasWavesEffect()) element.style().add(WAVES_EFFECT);

    wavesElement.initWaves();
    return this;
  }

  private boolean hasWavesEffect() {
    return element.style().contains(WAVES_EFFECT);
  }

  /** Use {@link WavesSupport#setWaveColor(WaveColor)} instead */
  @Deprecated
  public WavesSupport setWavesColor(WaveColor waveColor) {
    return setWaveColor(waveColor);
  }

  /** {@inheritDoc} */
  @Override
  public WavesSupport setWaveColor(WaveColor waveColor) {
    if (!hasWavesEffect()) initWaves();
    if (isNull(this.waveColor)) element.style().add(waveColor.getStyle());
    else {
      element.style().remove(this.waveColor);
      element.style().add(waveColor.getStyle());
    }
    this.waveColor = waveColor.getStyle();
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public WavesSupport applyWaveStyle(WaveStyle waveStyle) {
    if (!hasWavesEffect()) initWaves();
    if (!element.style().contains(waveStyle.getStyle())) element.style().add(waveStyle.getStyle());
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public WavesSupport removeWaves() {
    if (hasWavesEffect()) element.style().remove(WAVES_EFFECT);
    if (nonNull(waveColor)) element.style().remove(waveColor);
    removeWaveStyles();
    wavesElement.removeWaves();
    return this;
  }

  private void removeWaveStyles() {
    for (int i = 0; i < element.style().cssClassesCount(); ++i) {
      String style = element.style().cssClassByIndex(i);
      if (style.contains("waves-")) element.style().remove(style);
    }
  }
}
