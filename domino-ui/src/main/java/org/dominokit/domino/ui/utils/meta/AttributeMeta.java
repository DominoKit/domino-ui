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
package org.dominokit.domino.ui.utils.meta;

import java.util.Optional;
import org.dominokit.domino.ui.utils.ComponentMeta;
import org.dominokit.domino.ui.utils.HasMeta;

/** AttributeMeta class. */
public class AttributeMeta<T> implements ComponentMeta {

  private String key;
  private final T value;

  /**
   * of.
   *
   * @param key a {@link java.lang.String} object
   * @param value a T object
   * @param <T> a T class
   * @return a {@link org.dominokit.domino.ui.utils.meta.AttributeMeta} object
   */
  public static <T> AttributeMeta<T> of(String key, T value) {
    return new AttributeMeta<>(key, value);
  }

  /**
   * Constructor for AttributeMeta.
   *
   * @param key a {@link java.lang.String} object
   * @param value a T object
   */
  public AttributeMeta(String key, T value) {
    this.key = key;
    this.value = value;
  }

  /**
   * get.
   *
   * @param key a {@link java.lang.String} object
   * @param component a {@link org.dominokit.domino.ui.utils.HasMeta} object
   * @param <T> a T class
   * @return a {@link java.util.Optional} object
   */
  public static <T> Optional<AttributeMeta<T>> get(String key, HasMeta<?> component) {
    return component.getMeta(key);
  }

  /**
   * Getter for the field <code>value</code>.
   *
   * @return a T object
   */
  public T getValue() {
    return value;
  }

  /** {@inheritDoc} */
  @Override
  public String getKey() {
    return key;
  }
}
