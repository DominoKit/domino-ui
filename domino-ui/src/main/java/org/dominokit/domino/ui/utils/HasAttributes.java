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
 * HasAttributes interface.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public interface HasAttributes<T> {
  /**
   * setAttribute.
   *
   * @param name a {@link java.lang.String} object
   * @param value a boolean
   * @return a T object
   */
  T setAttribute(String name, boolean value);

  /**
   * setAttribute.
   *
   * @param name a {@link java.lang.String} object
   * @param value a double
   * @return a T object
   */
  T setAttribute(String name, double value);

  /**
   * setAttribute.
   *
   * @param name a {@link java.lang.String} object
   * @param value a {@link java.lang.String} object
   * @return a T object
   */
  T setAttribute(String name, String value);

  /**
   * getAttribute.
   *
   * @param name a {@link java.lang.String} object
   * @return a {@link java.lang.String} object
   */
  String getAttribute(String name);
}
