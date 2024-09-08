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
package org.dominokit.domino.ui.shaded.style;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.shaded.utils.BaseDominoElement;
import org.jboss.elemento.IsElement;

/**
 * An abstract element that provides waves support
 *
 * @param <E> the type of the root element
 * @param <T> the type of the waves element
 */
public abstract class WavesElement<E extends HTMLElement, T extends IsElement<E>>
    extends BaseDominoElement<E, T> implements HasWaveEffect<T> {

  protected WavesSupport wavesSupport;

  /** {@inheritDoc} */
  @Override
  public void init(T element) {
    super.init(element);
    wavesSupport = WavesSupport.addFor(this.getWavesElement());
  }

  /** {@inheritDoc} */
  @Override
  public T initWaves() {
    wavesSupport.initWaves();
    return element;
  }

  /** {@inheritDoc} */
  @Override
  public T setWaveColor(WaveColor waveColor) {
    wavesSupport.setWaveColor(waveColor);
    return element;
  }

  /** {@inheritDoc} */
  @Override
  public T applyWaveStyle(WaveStyle waveStyle) {
    wavesSupport.applyWaveStyle(waveStyle);
    return element;
  }

  /** {@inheritDoc} */
  @Override
  public T removeWaves() {
    wavesSupport.removeWaves();
    return element;
  }
}
