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

/** Dynamic sizing utility classes following Domino UI sizing conventions. */
public final class DynamicSizing {

  public static final DynamicCssDefinition WIDTH = definition("dui-w", "width");
  public static final DynamicCssDefinition HEIGHT = definition("dui-h", "height");
  public static final DynamicCssDefinition MIN_WIDTH = definition("dui-min-w", "min-width");
  public static final DynamicCssDefinition MIN_HEIGHT = definition("dui-min-h", "min-height");
  public static final DynamicCssDefinition MAX_WIDTH = definition("dui-max-w", "max-width");
  public static final DynamicCssDefinition MAX_HEIGHT = definition("dui-max-h", "max-height");

  private DynamicSizing() {}

  public static CssClass width(String value) {
    return cssClass(WIDTH, value);
  }

  public static CssClass width(Unit unit, Number value) {
    return cssClass(WIDTH, unit, value);
  }

  public static CssClass height(String value) {
    return cssClass(HEIGHT, value);
  }

  public static CssClass height(Unit unit, Number value) {
    return cssClass(HEIGHT, unit, value);
  }

  public static CssClass minWidth(String value) {
    return cssClass(MIN_WIDTH, value);
  }

  public static CssClass minWidth(Unit unit, Number value) {
    return cssClass(MIN_WIDTH, unit, value);
  }

  public static CssClass minHeight(String value) {
    return cssClass(MIN_HEIGHT, value);
  }

  public static CssClass minHeight(Unit unit, Number value) {
    return cssClass(MIN_HEIGHT, unit, value);
  }

  public static CssClass maxWidth(String value) {
    return cssClass(MAX_WIDTH, value);
  }

  public static CssClass maxWidth(Unit unit, Number value) {
    return cssClass(MAX_WIDTH, unit, value);
  }

  public static CssClass maxHeight(String value) {
    return cssClass(MAX_HEIGHT, value);
  }

  public static CssClass maxHeight(Unit unit, Number value) {
    return cssClass(MAX_HEIGHT, unit, value);
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
