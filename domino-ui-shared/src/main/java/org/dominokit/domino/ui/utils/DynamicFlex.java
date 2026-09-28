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

/** Dynamic flex-item utility classes following Domino UI conventions. */
public final class DynamicFlex {

  public static final DynamicCssDefinition BASIS = definition("dui-basis", "dui-spc", "flex-basis");
  public static final DynamicCssDefinition GROW = definition("dui-grow", "dui-grow", "flex-grow");
  public static final DynamicCssDefinition SHRINK =
      definition("dui-shrink", "dui-shrink", "flex-shrink");
  public static final DynamicCssDefinition ORDER = definition("dui-order", "dui-order", "order");

  private DynamicFlex() {}

  public static CssClass basis(String value) {
    return cssClass(BASIS, value);
  }

  public static CssClass basis(Unit unit, Number value) {
    return cssClass(BASIS, unit, value);
  }

  public static CssClass grow(String value) {
    return cssClass(GROW, value);
  }

  public static CssClass grow(Number value) {
    return grow(String.valueOf(value));
  }

  public static CssClass shrink(String value) {
    return cssClass(SHRINK, value);
  }

  public static CssClass shrink(Number value) {
    return shrink(String.valueOf(value));
  }

  public static CssClass order(String value) {
    return cssClass(ORDER, value);
  }

  public static CssClass order(Number value) {
    return order(String.valueOf(value));
  }

  private static DynamicCssDefinition definition(
      String classPrefix, String variablePrefix, String property) {
    return DynamicCssDefinition.of(classPrefix, variablePrefix, property);
  }

  private static CssClass cssClass(DynamicCssDefinition definition, String value) {
    return DynamicCssValues.cssClass(definition, value);
  }

  private static CssClass cssClass(DynamicCssDefinition definition, Unit unit, Number value) {
    return DynamicCssValues.cssClass(definition, unit, value);
  }
}
