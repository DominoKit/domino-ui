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
 * ValueMeta class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class ValueMeta<T> implements ComponentMeta {

  /** Constant <code>VALUE_META="dui-value-meta"</code> */
  public static final String VALUE_META = "dui-value-meta";

  private final T value;

  /**
   * of.
   *
   * @param value a T object
   * @param <T> a T class
   * @return a {@link org.dominokit.domino.ui.utils.meta.ValueMeta} object
   */
  public static <T> ValueMeta<T> of(T value) {
    return new ValueMeta<>(value);
  }

  /**
   * Constructor for ValueMeta.
   *
   * @param value a T object
   */
  public ValueMeta(T value) {
    this.value = value;
  }

  /**
   * get.
   *
   * @param component a {@link org.dominokit.domino.ui.utils.HasMeta} object
   * @param <T> a T class
   * @return a {@link java.util.Optional} object
   */
  public static <T> Optional<ValueMeta<T>> get(HasMeta<?> component) {
    return component.getMeta(VALUE_META);
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
    return VALUE_META;
  }
}
