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

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.util.function.Supplier;

public class SupplyOnce<T> {
  private T value;
  private Supplier<T> supplier;

  public static <T> SupplyOnce<T> of(Supplier<T> supplier) {
    return new SupplyOnce<>(supplier);
  }

  public SupplyOnce(Supplier<T> supplier) {
    this.supplier = supplier;
  }

  public T get() {
    if (nonNull(supplier) && isNull(value)) {
      this.value = supplier.get();
    }
    return value;
  }
}
