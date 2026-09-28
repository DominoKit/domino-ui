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

/** Dynamic outline-width and outline-offset utility classes following Domino UI conventions. */
public final class DynamicOutline {

  public static final DynamicCssDefinition WIDTH = definition("dui-outline", "outline-width");
  public static final DynamicCssDefinition OFFSET =
      definition("dui-outline-offset", "outline-offset");

  private DynamicOutline() {}

  public static CssClass width(String value) {
    return cssClass(WIDTH, value);
  }

  public static CssClass width(Unit unit, Number value) {
    return cssClass(WIDTH, unit, value);
  }

  public static CssClass offset(String value) {
    return cssClass(OFFSET, value);
  }

  public static CssClass offset(Unit unit, Number value) {
    return cssClass(OFFSET, unit, value);
  }

  private static DynamicCssDefinition definition(String classPrefix, String property) {
    return DynamicCssDefinition.of(classPrefix, "dui-spc", property);
  }

  private static CssClass cssClass(DynamicCssDefinition definition, String value) {
    return DynamicCssValues.cssClass(definition, value);
  }

  private static CssClass cssClass(DynamicCssDefinition definition, Unit unit, Number value) {
    return DynamicCssValues.cssClass(definition, unit, value);
  }
}
