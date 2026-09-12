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

/** Dynamic typography metric utility classes following Domino UI conventions. */
public final class DynamicTypography {

  public static final DynamicCssDefinition FONT_SIZE = definition("dui-font-size", "font-size");
  public static final DynamicCssDefinition LINE_HEIGHT = definition("dui-leading", "line-height");
  public static final DynamicCssDefinition LETTER_SPACING =
      definition("dui-tracking", "letter-spacing");
  public static final DynamicCssDefinition FONT_WEIGHT =
      DynamicCssDefinition.of("dui-font-weight", "dui-font-weight", "font-weight");

  private DynamicTypography() {}

  public static CssClass fontSize(String value) {
    return cssClass(FONT_SIZE, value);
  }

  public static CssClass fontSize(Unit unit, Number value) {
    return cssClass(FONT_SIZE, unit, value);
  }

  public static CssClass lineHeight(String value) {
    return cssClass(LINE_HEIGHT, value);
  }

  public static CssClass lineHeight(Unit unit, Number value) {
    return cssClass(LINE_HEIGHT, unit, value);
  }

  public static CssClass letterSpacing(String value) {
    return cssClass(LETTER_SPACING, value);
  }

  public static CssClass letterSpacing(Unit unit, Number value) {
    return cssClass(LETTER_SPACING, unit, value);
  }

  public static CssClass fontWeight(String value) {
    return cssClass(FONT_WEIGHT, value);
  }

  public static CssClass fontWeight(Number value) {
    return fontWeight(String.valueOf(value));
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
