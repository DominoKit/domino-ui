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

/**
 * The {@code AttributeMeta} class represents metadata associated with a component or element in the
 * DOM. It allows for storing key-value pairs of metadata where the key is a string and the value
 * can be of any type.
 *
 * @param <T> The type of the value stored as metadata.
 */
public class AttributeMeta<T> implements ComponentMeta {

  private String key;
  private final T value;

  /**
   * Creates a new instance of {@code AttributeMeta} with the specified key and value.
   *
   * @param key The key associated with the metadata.
   * @param value The value to store as metadata.
   * @param <T> The type of the value.
   * @return An {@code AttributeMeta} instance with the specified key and value.
   */
  public static <T> AttributeMeta<T> of(String key, T value) {
    return new AttributeMeta<>(key, value);
  }

  /**
   * Constructs an {@code AttributeMeta} instance with the given key and value.
   *
   * @param key The key associated with the metadata.
   * @param value The value to store as metadata.
   */
  public AttributeMeta(String key, T value) {
    this.key = key;
    this.value = value;
  }

  /**
   * Retrieves a metadata item with the specified key from a component that implements {@code
   * HasMeta}.
   *
   * @param key The key of the metadata item to retrieve.
   * @param component The component or element that stores metadata.
   * @param <T> The type of the value stored as metadata.
   * @return An optional containing the metadata item if found, or an empty optional if not found.
   */
  public static <T> Optional<AttributeMeta<T>> get(String key, HasMeta<?> component) {
    return component.getMeta(key);
  }

  /**
   * Gets the value stored as metadata.
   *
   * @return The value associated with this metadata item.
   */
  public T getValue() {
    return value;
  }

  /**
   * Gets the key associated with this metadata item.
   *
   * @return The key of the metadata item.
   */
  @Override
  public String getKey() {
    return key;
  }
}
