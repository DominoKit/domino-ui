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
 * An interface for a component that can have different sizes
 *
 * @param <T> the type of component implementing this interface
 */
public interface Sizable<T> {
  /**
   * set the size to large
   *
   * @return same component instance
   */
  T large();
  /**
   * set the size to medium
   *
   * @return same component instance
   */
  T medium();
  /**
   * set the size to small
   *
   * @return same component instance
   */
  T small();
  /**
   * set the size to xSmall
   *
   * @return same component instance
   */
  T xSmall();
}
