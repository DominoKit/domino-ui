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
 * HasDefaultValue interface.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public interface HasDefaultValue<T, V> {

  /** @return V the default value to be set when the instance is cleared */
  /**
   * getDefaultValue.
   *
   * @return a V object
   */
  V getDefaultValue();

  /**
   * setDefaultValue.
   *
   * @param defaultValue The default value to be used when the instance is created or cleared
   * @return same instance
   */
  T setDefaultValue(V defaultValue);
}
