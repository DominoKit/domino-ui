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

/**
 * Represents an object that can have a wave effect applied to it.
 *
 * <p>Implementations of this interface can initialize, set styles, and remove wave effects.
 *
 * @param <T> the type of the implementing object, allowing for method chaining
 */
public interface HasWaveEffect<T> {

  /**
   * Initializes the wave effect on the implementing object.
   *
   * @return the current instance of the implementing object for method chaining
   */
  T initWaves();

  /**
   * Sets the style of the wave effect on the implementing object.
   *
   * @param type the desired style of the wave effect
   * @return the current instance of the implementing object for method chaining
   */
  T setWaveStyle(WaveStyle type);

  /**
   * Removes the wave effect from the implementing object.
   *
   * @return the current instance of the implementing object for method chaining
   */
  T removeWaves();
}
