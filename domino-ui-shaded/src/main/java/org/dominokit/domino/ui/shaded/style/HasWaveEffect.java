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

/**
 * An interface provides waves effects
 *
 * @param <T> the type of the component implementing this
 */
@Deprecated
public interface HasWaveEffect<T> {
  /**
   * Initializes the waves functionality
   *
   * @return same instance
   */
  T initWaves();

  /**
   * Sets the color of the waves
   *
   * @param waveColor the {@link WaveColor}
   * @return same instance
   */
  T setWaveColor(WaveColor waveColor);

  /**
   * Applies the waves style
   *
   * @param type the {@link WaveStyle}
   * @return same instance
   */
  T applyWaveStyle(WaveStyle type);

  /**
   * Removes the waves support
   *
   * @return same instance
   */
  T removeWaves();
}
