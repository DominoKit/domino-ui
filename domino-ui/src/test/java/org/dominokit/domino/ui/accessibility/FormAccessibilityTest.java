/*
 * Copyright © 2019 Dominokit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 */
package org.dominokit.domino.ui.accessibility;

import com.google.gwt.junit.client.GWTTestCase;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.forms.suggest.Select;
import org.dominokit.domino.ui.richtext.RichTextEditor;

public class FormAccessibilityTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testInvalidInputExposesStateAndErrorDescription() {
    TextBox textBox = TextBox.create("Name").invalidate("Name is required");

    assertEquals("true", textBox.getInputElement().getAttribute("aria-invalid"));
    assertEquals(
        textBox.getMessagesWrapperElement().getDominoId(),
        textBox.getInputElement().getAttribute("aria-describedby"));
  }

  public void testClearingInvalidStateRemovesErrorState() {
    TextBox textBox = TextBox.create("Name").invalidate("Name is required");

    textBox.clearInvalid();

    assertEquals("false", textBox.getInputElement().getAttribute("aria-invalid"));
    assertFalse(textBox.getInputElement().hasAttribute("aria-describedby"));
  }

  public void testSelectExposesComboboxRelationship() {
    Select<String> select = Select.create("Country");

    assertEquals("combobox", select.getInputElement().getAttribute("role"));
    assertEquals("false", select.getInputElement().getAttribute("aria-expanded"));
    assertEquals(
        select.getOptionsMenu().getDominoId(),
        select.getInputElement().getAttribute("aria-controls"));
  }

  public void testRichTextEditorExposesMultilineTextBox() {
    RichTextEditor editor = RichTextEditor.create();

    assertEquals("textbox", editor.getEditableElement().getAttribute("role"));
    assertEquals("true", editor.getEditableElement().getAttribute("aria-multiline"));
    assertEquals("Rich text editor", editor.getEditableElement().getAttribute("aria-label"));
  }

  public void testRequiredInputExposesRequiredState() {
    TextBox textBox = TextBox.create("Name").setRequired(true);

    assertEquals("true", textBox.getInputElement().getAttribute("aria-required"));
  }
}
