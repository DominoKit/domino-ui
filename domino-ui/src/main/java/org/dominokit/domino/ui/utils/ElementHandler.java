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
 * A function to apply generic logic to a component
 *
 * @param <T> the type of the component
 */
@FunctionalInterface
public interface ElementHandler<T> {
  /** @param self the T component instance */
  /**
   * handleElement.
   *
   * @param self a T object
   */
  void handleElement(T self);
}
