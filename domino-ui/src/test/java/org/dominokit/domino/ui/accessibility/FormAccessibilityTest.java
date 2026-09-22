/*
 * Copyright © 2019 Dominokit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 */
package org.dominokit.domino.ui.accessibility;

import com.google.gwt.junit.client.GWTTestCase;
import org.dominokit.domino.ui.forms.DateBox;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.forms.TimeBox;
import org.dominokit.domino.ui.forms.suggest.Select;
import org.dominokit.domino.ui.richtext.RichTextEditor;
import org.dominokit.domino.ui.upload.FileUpload;

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

  public void testFileUploadIsKeyboardAccessibleAndAnnouncesMessages() {
    FileUpload fileUpload = FileUpload.create();

    assertEquals("button", fileUpload.getAttribute("role"));
    assertEquals("0", fileUpload.getAttribute("tabindex"));
    assertEquals("Choose files", fileUpload.getAttribute("aria-label"));
    assertEquals(
        "polite",
        fileUpload.element().querySelector(".dui-file-upload-messages").getAttribute("aria-live"));
  }

  public void testDateAndTimeTypingModesExposeTheirExpectedPattern() {
    DateBox dateBox = DateBox.empty().setPattern("dd/MM/yyyy").setTypingModeEnabled(true);
    TimeBox timeBox = TimeBox.empty().setPattern("HH:mm").setTypingModeEnabled(true);

    assertEquals(
        "Type a date using the pattern dd/MM/yyyy.",
        dateBox.getInputElement().getAttribute("aria-description"));
    assertEquals(
        "Type a time using the pattern HH:mm.",
        timeBox.getInputElement().getAttribute("aria-description"));

    dateBox.setTypingModeEnabled(false);
    timeBox.setTypingModeEnabled(false);

    assertFalse(dateBox.getInputElement().hasAttribute("aria-description"));
    assertFalse(timeBox.getInputElement().hasAttribute("aria-description"));
  }
}
