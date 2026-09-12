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

/** Dynamic padding utility classes following Domino UI spacing conventions. */
public final class DynamicPadding {

  public static final DynamicCssDefinition PADDING = definition("dui-p", "padding");
  public static final DynamicCssDefinition TOP = definition("dui-p-t", "padding-top");
  public static final DynamicCssDefinition RIGHT = definition("dui-p-r", "padding-right");
  public static final DynamicCssDefinition BOTTOM = definition("dui-p-b", "padding-bottom");
  public static final DynamicCssDefinition LEFT = definition("dui-p-l", "padding-left");
  public static final DynamicCssDefinition X =
      definition("dui-p-x", "padding-left", "padding-right");
  public static final DynamicCssDefinition Y =
      definition("dui-p-y", "padding-top", "padding-bottom");

  private DynamicPadding() {}

  public static CssClass of(String value) {
    return cssClass(PADDING, value);
  }

  public static CssClass of(Unit unit, Number value) {
    return cssClass(PADDING, unit, value);
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

  private static DynamicCssDefinition definition(String classPrefix, String... cssProperties) {
    return DynamicCssDefinition.of(classPrefix, "dui-spc", cssProperties);
  }

  private static CssClass cssClass(DynamicCssDefinition definition, String value) {
    return DynamicCssValues.cssClass(definition, value);
  }

  private static CssClass cssClass(DynamicCssDefinition definition, Unit unit, Number value) {
    return DynamicCssValues.cssClass(definition, unit, value);
  }
}
