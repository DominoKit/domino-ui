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

/** Dynamic grid-track utility classes following Domino UI conventions. */
public final class DynamicGrid {

  public static final DynamicCssDefinition COLUMNS =
      definition("dui-grid-cols", "grid-template-columns");
  public static final DynamicCssDefinition ROWS = definition("dui-grid-rows", "grid-template-rows");
  public static final DynamicCssDefinition AUTO_COLUMNS =
      definition("dui-auto-cols", "grid-auto-columns");
  public static final DynamicCssDefinition AUTO_ROWS =
      definition("dui-auto-rows", "grid-auto-rows");

  private DynamicGrid() {}

  public static CssClass columns(String value) {
    return cssClass(COLUMNS, value);
  }

  public static CssClass rows(String value) {
    return cssClass(ROWS, value);
  }

  public static CssClass autoColumns(String value) {
    return cssClass(AUTO_COLUMNS, value);
  }

  public static CssClass autoRows(String value) {
    return cssClass(AUTO_ROWS, value);
  }

  private static DynamicCssDefinition definition(String classPrefix, String property) {
    return DynamicCssDefinition.of(classPrefix, "dui-grid", property);
  }

  private static CssClass cssClass(DynamicCssDefinition definition, String value) {
    return DynamicCssValues.cssClass(definition, value);
  }
}
