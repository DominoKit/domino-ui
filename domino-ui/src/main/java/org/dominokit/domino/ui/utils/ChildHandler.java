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
 * A functional interface for handling child elements in a parent-child relationship.
 *
 * @param <P> The type of the parent element.
 * @param <C> The type of the child element.
 */
public interface ChildHandler<P, C> {
  /**
   * Applies the handler logic to the parent and child elements.
   *
   * @param parent The parent element.
   * @param self The child element.
   */
  void apply(P parent, C self);
}
