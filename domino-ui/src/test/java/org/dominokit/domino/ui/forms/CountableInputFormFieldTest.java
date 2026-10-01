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
package org.dominokit.domino.ui.forms;

import com.google.gwt.junit.client.GWTTestCase;
import elemental2.dom.Event;
import org.dominokit.domino.ui.forms.validations.MaxLengthValidator;
import org.dominokit.domino.ui.forms.validations.MinLengthValidator;
import org.dominokit.domino.ui.forms.validations.ValidationResult;

public class CountableInputFormFieldTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testClearingLengthLimitsDoesNotRequireAnExistingCounter() {
    TextBox textBox = TextBox.create();

    textBox.setMinLength(-1).setMaxLength(-1);

    assertFalse(textBox.getInputElement().hasAttribute("minlength"));
    assertFalse(textBox.getInputElement().hasAttribute("maxlength"));
  }

  public void testClearingAndReaddingMinimumLengthUpdatesTheAttribute() {
    TextBox textBox = TextBox.create().setMinLength(3);

    textBox.setMinLength(-1);
    assertFalse(textBox.getInputElement().hasAttribute("minlength"));

    textBox.setMinLength(2);
    assertTrue(textBox.getInputElement().hasAttribute("minlength"));
    assertEquals(2, textBox.getMinLength());
  }

  public void testProgrammaticallySetValueIsCheckedAgainstMinimumLength() {
    TextBox textBox = TextBox.create();
    textBox.setMinLength(3);
    textBox.setValue("x");

    ValidationResult result = new MinLengthValidator<>(textBox).isValid(textBox);

    assertFalse(result.isValid());
  }

  public void testMinimumLengthValidationWorksWithoutMaximumLength() {
    TextBox textBox = TextBox.create();
    textBox.setMinLength(3);
    textBox.setValue("x");

    assertTrue(hasMinLengthValidator(textBox));
    assertFalse(new MinLengthValidator<>(textBox).isValid(textBox).isValid());

    textBox.setMinLength(-1);
    assertFalse(hasMinLengthValidator(textBox));
  }

  public void testRemovingMaximumLengthRemovesTheRegisteredValidatorAfterInput() {
    TextBox textBox = TextBox.create();
    textBox.setMaxLength(2);
    textBox.setValue("long");
    assertTrue(hasMaxLengthValidator(textBox));
    textBox.getInputElement().element().dispatchEvent(new Event("input"));
    assertTrue(hasMaxLengthValidator(textBox));

    textBox.setMaxLength(-1);

    assertFalse(hasMaxLengthValidator(textBox));
  }

  private boolean hasMinLengthValidator(TextBox textBox) {
    for (org.dominokit.domino.ui.utils.HasValidation.Validator<TextBox> validator :
        textBox.getValidators()) {
      if (validator instanceof MinLengthValidator) {
        return true;
      }
    }
    return false;
  }

  private boolean hasMaxLengthValidator(TextBox textBox) {
    for (org.dominokit.domino.ui.utils.HasValidation.Validator<TextBox> validator :
        textBox.getValidators()) {
      if (validator instanceof MaxLengthValidator) {
        return true;
      }
    }
    return false;
  }

  public void testProgrammaticallySetValueIsCheckedAgainstMaximumLength() {
    TextBox textBox = TextBox.create();
    textBox.setMaxLength(1);
    textBox.setValue("xy");

    ValidationResult result = new MaxLengthValidator<>(textBox).isValid(textBox);

    assertFalse(result.isValid());
  }
}
