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
package org.dominokit.domino.ui.style;

/** Typed CSS properties for form-field typography. */
public final class FormFieldTypography {

  /** CSS property controlling the font shorthand used by radio and checkbox labels. */
  public static final String CHOICE_LABEL_FONT_PROPERTY = "--dui-form-field-choice-label-font";

  private FormFieldTypography() {}

  /** Creates a CSS property for overriding radio and checkbox label typography. */
  public static CssProperty choiceLabelFont(String font) {
    return CssProperty.of(CHOICE_LABEL_FONT_PROPERTY, font);
  }
}
