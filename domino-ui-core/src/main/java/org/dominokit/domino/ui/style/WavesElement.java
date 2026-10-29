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
 * An abstract representation of an element that supports the Waves (ripple) effect.
 *
 * <p>This class extends the functionality of {@link BaseDominoElement} to include support for the
 * Waves effect, which is commonly used in material design for interactive elements.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>
 * public class CustomButton extends WavesElement&lt;HTMLButtonElement, CustomButton&gt; {
 *     // Implementation of the CustomButton
 * }
 *
 * CustomButton button = new CustomButton();
 * button.initWaves();
 * </pre>
 *
 * @param <E> the type of the root HTML element of this component
 * @param <T> the type of the component
 * @see BaseDominoElement
 */
public abstract class WavesElement<E extends HTMLElement, T extends IsElement<E>>
    extends BaseDominoElement<E, T> implements HasWaveEffect<T> {

  /**
   * Initializes the element with its associated DOM representation and sets up the Waves (ripple)
   * effect for the element.
   *
   * @param element the domino-ui representation of the element
   */
  @Override
  public void init(T element) {
    super.init(element);
    wavesSupport = WavesSupport.addFor(this.getWavesElement());
  }

  /**
   * Removes the Waves (ripple) effect from this element.
   *
   * @return the current instance for chaining
   */
  @Override
  public T removeWaves() {
    wavesSupport.removeWaves();
    return element;
  }
}
