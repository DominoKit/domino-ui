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

/** Dynamic position and stacking utility classes following Domino UI conventions. */
public final class DynamicPosition {

  public static final DynamicCssDefinition INSET =
      spacing("dui-inset", "top", "right", "bottom", "left");
  public static final DynamicCssDefinition X = spacing("dui-inset-x", "left", "right");
  public static final DynamicCssDefinition Y = spacing("dui-inset-y", "top", "bottom");
  public static final DynamicCssDefinition TOP = spacing("dui-top", "top");
  public static final DynamicCssDefinition RIGHT = spacing("dui-right", "right");
  public static final DynamicCssDefinition BOTTOM = spacing("dui-bottom", "bottom");
  public static final DynamicCssDefinition LEFT = spacing("dui-left", "left");
  public static final DynamicCssDefinition Z_INDEX =
      DynamicCssDefinition.of("dui-z", "dui-z", "z-index");

  private DynamicPosition() {}

  public static CssClass of(String value) {
    return cssClass(INSET, value);
  }

  public static CssClass of(Unit unit, Number value) {
    return cssClass(INSET, unit, value);
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

  public static CssClass zIndex(String value) {
    return cssClass(Z_INDEX, value);
  }

  public static CssClass zIndex(Number value) {
    return zIndex(String.valueOf(value));
  }

  private static DynamicCssDefinition spacing(String classPrefix, String... properties) {
    return DynamicCssDefinition.of(classPrefix, "dui-spc", properties);
  }

  private static CssClass cssClass(DynamicCssDefinition definition, String value) {
    return DynamicCssValues.cssClass(definition, value);
  }

  private static CssClass cssClass(DynamicCssDefinition definition, Unit unit, Number value) {
    return DynamicCssValues.cssClass(definition, unit, value);
  }
}
