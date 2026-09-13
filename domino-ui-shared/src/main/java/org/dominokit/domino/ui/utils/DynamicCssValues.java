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

/** Shared value conversion for dynamic CSS utility factories. */
final class DynamicCssValues {

  private DynamicCssValues() {}

  static CssClass cssClass(DynamicCssDefinition definition, String value) {
    return DynamicCss.cssClass(definition, value);
  }

  static CssClass cssClass(DynamicCssDefinition definition, Unit unit, Number value) {
    return cssClass(definition, unit.of(value));
  }
}
