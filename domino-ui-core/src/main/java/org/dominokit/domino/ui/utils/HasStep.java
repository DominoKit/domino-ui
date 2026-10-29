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

package org.dominokit.domino.ui.utils;

/**
 * The {@code HasStep} interface defines methods for getting and setting a step value.
 *
 * @param <T> The type of the implementing class.
 * @param <V> The type of the step value.
 */
public interface HasStep<T, V> {

  /**
   * Gets the step value.
   *
   * @return The step value.
   */
  V getStep();

  /**
   * Sets the step value.
   *
   * @param step The step value to set.
   * @return The implementing class instance.
   */
  T setStep(V step);
}
