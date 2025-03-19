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

import static org.dominokit.domino.ui.utils.Domino.*;

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

  private final Waves wavesElement;

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
    wavesElement = Waves.create(targetElement);
  }

  /**
   * Adds Waves effect for the provided {@link HasWavesElement} and initializes it.
   *
   * @param element the target element that implements {@link HasWavesElement}.
   * @return an instance of {@link WavesSupport}.
   */
  public static WavesSupport addFor(HasWavesElement element) {
    return new WavesSupport(element);
  }

  /**
   * Adds Waves effect for the provided DOM {@link Element} and initializes it.
   *
   * @param element the target DOM element.
   * @return an instance of {@link WavesSupport}.
   */
  public static WavesSupport addFor(Element element) {
    return new WavesSupport(element);
  }

  private boolean hasWavesEffect() {
    return Waves.dui_ripple_wave.isAppliedTo(wavesElement.element());
  }

  /**
   * Removes the Waves (ripple) effect from the element.
   *
   * @return the current instance of {@link WavesSupport} for chaining.
   */
  @Override
  public WavesSupport removeWaves() {
    wavesElement.removeWaves();
    return this;
  }

  /**
   * Gets the {@link DominoElement} associated with this WavesSupport.
   *
   * @return the {@link DominoElement} instance.
   */
  public DominoElement<Element> getElement() {
    return elementOf(wavesElement.element());
  }
}
