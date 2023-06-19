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

public class AttributeMeta<T> implements ComponentMeta {

  private String key;
  private final T value;

  public static <T> AttributeMeta<T> of(String key, T value) {
    return new AttributeMeta<>(key, value);
  }

  public AttributeMeta(String key, T value) {
    this.key = key;
    this.value = value;
  }

  public static <T> Optional<AttributeMeta<T>> get(String key, HasMeta<?> component) {
    return component.getMeta(key);
  }

  public T getValue() {
    return value;
  }

  @Override
  public String getKey() {
    return key;
  }
}
