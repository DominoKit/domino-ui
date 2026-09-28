/*
 * Copyright © 2026 Dominokit
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

import java.util.function.Supplier;
import org.dominokit.domino.ui.style.CssClass;

final class LazyDynamicCssClass implements CssClass {

  private final Supplier<CssClass> supplier;
  private CssClass resolved;
  private int resolvedRegistryGeneration = -1;

  LazyDynamicCssClass(Supplier<CssClass> supplier) {
    this.supplier = supplier;
  }

  @Override
  public String getCssClass() {
    int currentRegistryGeneration = DynamicCss.registryGeneration();
    if (resolved == null || resolvedRegistryGeneration != currentRegistryGeneration) {
      resolved = supplier.get();
      resolvedRegistryGeneration = currentRegistryGeneration;
    }
    return resolved.getCssClass();
  }
}
