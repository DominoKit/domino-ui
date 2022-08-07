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
 * A Component that can have a value should implement this interface
 *
 * @param <T> the type of the class implementing this interface
 * @param <V> the type of the component value
 */
public interface HasValue<T, V> {
  /**
   * @param value V to set as a value of the component
   * @return same implementing component instance
   */
  T value(V value);

  /**
   * @param value V to set as a value of the component
   * @param silent boolean if true set the value without triggering change handlers
   * @return same implementing component instance
   */
  T value(V value, boolean silent);
}
