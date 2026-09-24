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

/** Dynamic border-width utility classes following Domino UI conventions. */
public final class DynamicBorder {

  public static final DynamicCssDefinition BORDER = definition("dui-border", "border-width");
  public static final DynamicCssDefinition X =
      definition("dui-border-x", "border-left-width", "border-right-width");
  public static final DynamicCssDefinition Y =
      definition("dui-border-y", "border-top-width", "border-bottom-width");
  public static final DynamicCssDefinition TOP = definition("dui-border-t", "border-top-width");
  public static final DynamicCssDefinition RIGHT = definition("dui-border-r", "border-right-width");
  public static final DynamicCssDefinition BOTTOM =
      definition("dui-border-b", "border-bottom-width");
  public static final DynamicCssDefinition LEFT = definition("dui-border-l", "border-left-width");

  private DynamicBorder() {}

  public static CssClass of(String value) {
    return cssClass(BORDER, value);
  }

  public static CssClass of(Unit unit, Number value) {
    return cssClass(BORDER, unit, value);
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

  public static CssClass top(String value) {
    return cssClass(TOP, value);
  }

  public static CssClass top(Unit unit, Number value) {
    return cssClass(TOP, unit, value);
  }

  public static CssClass right(String value) {
    return cssClass(RIGHT, value);
  }

  public static CssClass right(Unit unit, Number value) {
    return cssClass(RIGHT, unit, value);
  }

  public static CssClass bottom(String value) {
    return cssClass(BOTTOM, value);
  }

  public static CssClass bottom(Unit unit, Number value) {
    return cssClass(BOTTOM, unit, value);
  }

  public static CssClass left(String value) {
    return cssClass(LEFT, value);
  }

  public static CssClass left(Unit unit, Number value) {
    return cssClass(LEFT, unit, value);
  }

  private static DynamicCssDefinition definition(String classPrefix, String... properties) {
    return DynamicCssDefinition.of(classPrefix, "dui-spc", properties);
  }

  private static CssClass cssClass(DynamicCssDefinition definition, String value) {
    return DynamicCssValues.cssClass(definition, value);
  }

  private static CssClass cssClass(DynamicCssDefinition definition, Unit unit, Number value) {
    return DynamicCssValues.cssClass(definition, unit, value);
  }
}
