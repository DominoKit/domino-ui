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

/** Dynamic gap utility classes following Domino UI spacing conventions. */
public final class DynamicGap {

  public static final DynamicCssDefinition GAP = definition("dui-gap", "gap");
  public static final DynamicCssDefinition X = definition("dui-gap-x", "column-gap");
  public static final DynamicCssDefinition Y = definition("dui-gap-y", "row-gap");

  private DynamicGap() {}

  public static CssClass of(String value) {
    return cssClass(GAP, value);
  }

  public static CssClass of(Unit unit, Number value) {
    return cssClass(GAP, unit, value);
  }

  public static CssClass x(String value) {
    return cssClass(X, value);
  }

  public static CssClass x(Unit unit, Number value) {
    return cssClass(X, unit, value);
  }

  public static CssClass y(String value) {
    return cssClass(Y, value);
  }

  public static CssClass y(Unit unit, Number value) {
    return cssClass(Y, unit, value);
  }

  private static DynamicCssDefinition definition(String classPrefix, String cssProperty) {
    return DynamicCssDefinition.of(classPrefix, "dui-spc", cssProperty);
  }

  private static CssClass cssClass(DynamicCssDefinition definition, String value) {
    return DynamicCssValues.cssClass(definition, value);
  }

  private static CssClass cssClass(DynamicCssDefinition definition, Unit unit, Number value) {
    return DynamicCssValues.cssClass(definition, unit, value);
  }
}
