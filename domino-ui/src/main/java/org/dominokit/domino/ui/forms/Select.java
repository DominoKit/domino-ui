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
package org.dominokit.domino.ui.forms;

import java.util.Objects;
import java.util.Optional;

public class Select<V> extends AbstractSelect<V, V, Option<V>, Select<V>> {

  public static <V> Select<V> create() {
    return new Select<>();
  }

  public static <V> Select<V> create(String label) {
    return new Select<>(label);
  }

  public Select() {}

  public Select(String label) {
    setLabel(label);
  }

  protected void doSetValue(V value) {
    Optional.ofNullable(getValue())
            .ifPresent(oldValue -> findOptionByValue(oldValue).ifPresent(option -> option.deselect(true)));
    this.value = value;
    findOptionByValue(value).ifPresent(option -> option.select(true));
  }

  @Override
  public V getValue() {
    return value;
  }
}
