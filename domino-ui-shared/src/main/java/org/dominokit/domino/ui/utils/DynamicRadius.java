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

/** Dynamic border-radius utility classes following Domino UI conventions. */
public final class DynamicRadius {

  public static final DynamicCssDefinition RADIUS = definition("dui-rounded", "border-radius");
  public static final DynamicCssDefinition TOP =
      definition("dui-rounded-t", "border-top-left-radius", "border-top-right-radius");
  public static final DynamicCssDefinition RIGHT =
      definition("dui-rounded-r", "border-top-right-radius", "border-bottom-right-radius");
  public static final DynamicCssDefinition BOTTOM =
      definition("dui-rounded-b", "border-bottom-right-radius", "border-bottom-left-radius");
  public static final DynamicCssDefinition LEFT =
      definition("dui-rounded-l", "border-top-left-radius", "border-bottom-left-radius");
  public static final DynamicCssDefinition TOP_LEFT =
      definition("dui-rounded-tl", "border-top-left-radius");
  public static final DynamicCssDefinition TOP_RIGHT =
      definition("dui-rounded-tr", "border-top-right-radius");
  public static final DynamicCssDefinition BOTTOM_RIGHT =
      definition("dui-rounded-br", "border-bottom-right-radius");
  public static final DynamicCssDefinition BOTTOM_LEFT =
      definition("dui-rounded-bl", "border-bottom-left-radius");

  private DynamicRadius() {}

  public static CssClass of(String value) {
    return cssClass(RADIUS, value);
  }

  public static CssClass of(Unit unit, Number value) {
    return cssClass(RADIUS, unit, value);
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

  public static CssClass topLeft(String value) {
    return cssClass(TOP_LEFT, value);
  }

  public static CssClass topLeft(Unit unit, Number value) {
    return cssClass(TOP_LEFT, unit, value);
  }

  public static CssClass topRight(String value) {
    return cssClass(TOP_RIGHT, value);
  }

  public static CssClass topRight(Unit unit, Number value) {
    return cssClass(TOP_RIGHT, unit, value);
  }

  public static CssClass bottomRight(String value) {
    return cssClass(BOTTOM_RIGHT, value);
  }

  public static CssClass bottomRight(Unit unit, Number value) {
    return cssClass(BOTTOM_RIGHT, unit, value);
  }

  public static CssClass bottomLeft(String value) {
    return cssClass(BOTTOM_LEFT, value);
  }

  public static CssClass bottomLeft(Unit unit, Number value) {
    return cssClass(BOTTOM_LEFT, unit, value);
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
