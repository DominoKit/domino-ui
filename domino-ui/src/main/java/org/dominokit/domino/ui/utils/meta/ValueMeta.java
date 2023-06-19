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

public class ValueMeta<T> implements ComponentMeta {

  public static final String VALUE_META = "dui-value-meta";
  private final T value;

  public static <T> ValueMeta<T> of(T value) {
    return new ValueMeta<>(value);
  }

  public ValueMeta(T value) {
    this.value = value;
  }

  public static <T> Optional<ValueMeta<T>> get(HasMeta<?> component) {
    return component.getMeta(VALUE_META);
  }

  public T getValue() {
    return value;
  }

  @Override
  public String getKey() {
    return VALUE_META;
  }
}
