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

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * An abstract element that provides waves support
 *
 * @param <E> the type of the root element
 * @param <T> the type of the waves element
 * @author vegegoku
 * @version $Id: $Id
 */
public abstract class WavesElement<E extends HTMLElement, T extends IsElement<E>>
    extends BaseDominoElement<E, T> implements HasWaveEffect<T> {

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
  public T removeWaves() {
    wavesSupport.removeWaves();
    return element;
  }
}
