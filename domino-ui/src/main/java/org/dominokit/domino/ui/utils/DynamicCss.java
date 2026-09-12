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

import org.dominokit.domino.ui.style.CssClass;

/**
 * Creates document-global dynamic CSS utility classes.
 *
 * <p>Values are passed directly to the browser CSSOM. Callers are responsible for supplying valid,
 * trusted CSS values.
 */
public final class DynamicCss {

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

  static void reset() {
    DynamicCssRegistry.reset();
  }
}
