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

import com.google.gwt.core.client.GWT;
import org.dominokit.domino.ui.style.CssClass;

/**
 * Creates document-global dynamic CSS utility classes.
 *
 * <p>Values are passed directly to the browser CSSOM. Callers are responsible for supplying valid,
 * trusted CSS values.
 */
public final class DynamicCss {

  private static int registryGeneration;

  private DynamicCss() {}

  /**
   * Gets a reusable CSS utility class for a definition and raw CSS value.
   *
   * @param definition the utility family definition
   * @param rawValue the raw CSS value to set on the generated custom property
   * @return a CSS class whose rule is ready to use when this method returns
   */
  public static CssClass cssClass(DynamicCssDefinition definition, String rawValue) {
    return DynamicCssRegistry.get().cssClass(definition, rawValue);
  }

  /**
   * Creates a compatibility CSS class that resolves its generated rule only when the class name is
   * requested.
   *
   * @param definition the utility family definition
   * @param classToken the existing static utility class token
   * @param cssValue the CSS declaration value to emit when the class is resolved
   * @return a lazy CSS class retaining the existing static selector name
   */
  public static CssClass lazyCssClass(
      DynamicCssDefinition definition, String classToken, String cssValue) {
    return DynamicCssRegistry.get().lazyCssClass(definition, classToken, cssValue);
  }

  /**
   * Creates a lazily resolved compatibility class for a migrated static value utility.
   *
   * <p>Supported spacing, sizing, flex-basis, position, and stacking utility names retain their
   * existing selector names and inject their rule only when the class is used.
   *
   * @param staticClassName the existing utility selector name, such as {@code dui-p-4}
   * @return a CSS class that retains the supplied static selector name
   */
  public static CssClass lazyCssClass(String staticClassName) {
    DynamicCssRegistry registry = DynamicCssRegistry.get();
    if (shouldPreloadStaticUtilities(GWT.isScript(), GWT.isProdMode())) {
      registry.preloadStaticUtilities();
    }
    return new LazyDynamicCssClass(() -> DynamicCssRegistry.get().lazyCssClass(staticClassName));
  }

  static boolean shouldPreloadStaticUtilities(boolean scriptMode, boolean productionMode) {
    return scriptMode && !productionMode;
  }

  static void reset() {
    DynamicCssRegistry.reset();
    registryGeneration++;
  }

  static int registryGeneration() {
    return registryGeneration;
  }
}
