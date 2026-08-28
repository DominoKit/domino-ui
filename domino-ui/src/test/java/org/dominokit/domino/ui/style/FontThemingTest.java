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

import com.google.gwt.junit.client.GWTTestCase;

public class FontThemingTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testProvidesNamedFontFamilyClasses() {
    assertEquals("dui-font-inter", TypographyCss.dui_font_inter.getCssClass());
    assertEquals("dui-font-open-sans", TypographyCss.dui_font_open_sans.getCssClass());
    assertEquals("dui-font-roboto", TypographyCss.dui_font_roboto.getCssClass());
    assertEquals("dui-font-source-sans-3", TypographyCss.dui_font_source_sans_3.getCssClass());
    assertEquals("dui-font-ibm-plex-sans", TypographyCss.dui_font_ibm_plex_sans.getCssClass());
    assertEquals("dui-font-scope", TypographyCss.dui_font_scope.getCssClass());
  }

  public void testCreatesTypedFontFamilyProperties() {
    assertEquals("--dui-font-family", FontFamily.body("\"Acme Sans\", sans-serif").getName());
    assertEquals(
        "\"Acme Sans\", sans-serif", FontFamily.body("\"Acme Sans\", sans-serif").getValue());
    assertEquals("--dui-font-family-heading", FontFamily.heading("Georgia, serif").getName());
    assertEquals("--dui-font-family-mono", FontFamily.mono("ui-monospace").getName());
  }

  public void testCreatesTypedChoiceLabelFontProperty() {
    assertEquals(
        "--dui-form-field-choice-label-font",
        FormFieldTypography.choiceLabelFont("normal 400 16px var(--dui-font-family-body)")
            .getName());
    assertEquals(
        "normal 400 16px var(--dui-font-family-body)",
        FormFieldTypography.choiceLabelFont("normal 400 16px var(--dui-font-family-body)")
            .getValue());
  }
}
