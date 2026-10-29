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
 * The {@code HasAttributes} interface defines methods for setting and getting attributes on an
 * object of type {@code T}.
 *
 * @param <T> The type on which attributes can be set and retrieved.
 */
public interface HasAttributes<T> {

  /**
   * Sets a boolean attribute with the specified name on the object of type {@code T}.
   *
   * @param name The name of the attribute to set.
   * @param value The boolean value to set for the attribute.
   * @return The modified object of type {@code T} with the attribute set.
   */
  T setAttribute(String name, boolean value);

  /**
   * Sets a double attribute with the specified name on the object of type {@code T}.
   *
   * @param name The name of the attribute to set.
   * @param value The double value to set for the attribute.
   * @return The modified object of type {@code T} with the attribute set.
   */
  T setAttribute(String name, double value);

  /**
   * Sets a string attribute with the specified name on the object of type {@code T}.
   *
   * @param name The name of the attribute to set.
   * @param value The string value to set for the attribute.
   * @return The modified object of type {@code T} with the attribute set.
   */
  T setAttribute(String name, String value);

  /**
   * Gets the value of the attribute with the specified name from the object of type {@code T}.
   *
   * @param name The name of the attribute to retrieve.
   * @return The value of the attribute as a string, or {@code null} if the attribute is not set.
   */
  String getAttribute(String name);

  T removeAttribute(String name);
}
