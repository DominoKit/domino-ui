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
 * The {@code ValueMeta} class represents metadata associated with a component or element in the DOM
 * that stores a single value. It allows for storing and retrieving a value associated with a
 * component or element.
 *
 * @param <T> The type of the value stored as metadata.
 */
public class ValueMeta<T> implements ComponentMeta {

  public static final String VALUE_META = "dui-value-meta";

  private final T value;

  /**
   * Creates a new instance of {@code ValueMeta} with the specified value.
   *
   * @param value The value to store as metadata.
   * @param <T> The type of the value.
   * @return An {@code ValueMeta} instance with the specified value.
   */
  public static <T> ValueMeta<T> of(T value) {
    return new ValueMeta<>(value);
  }

  /**
   * Constructs an {@code ValueMeta} instance with the given value.
   *
   * @param value The value to store as metadata.
   */
  public ValueMeta(T value) {
    this.value = value;
  }

  /**
   * Retrieves a {@code ValueMeta} item from a component that implements {@code HasMeta}.
   *
   * @param component The component or element that stores the {@code ValueMeta} item.
   * @param <T> The type of the value stored as metadata.
   * @return An optional containing the {@code ValueMeta} item if found, or an empty optional if not
   *     found.
   */
  public static <T> Optional<ValueMeta<T>> get(HasMeta<?> component) {
    return component.getMeta(VALUE_META);
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
    return VALUE_META;
  }
}
