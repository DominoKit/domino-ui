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
package org.dominokit.domino.ui.forms.datetime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import org.dominokit.domino.ui.forms.validations.ValidationResult;
import org.junit.Test;

public class DateTimeTypingEditorTest {

  @Test
  public void commitsACompleteNumericSessionWithoutChangingTheValueWhileTyping() {
    FakeHost host = new FakeHost("yyyy-MM-dd", new Date(0));
    DateTimeTypingEditor editor = DateTimeTypingEditor.create(host);

    editor.beginSession();
    editor.type("20261001");

    assertEquals("2026-10-01", host.getDisplayedText());
    assertEquals(new Date(0), host.getCommittedValue());

    assertTrue(editor.commitSession());
    assertEquals(FakeHost.PARSED_DATE, host.getCommittedValue());
    assertFalse(editor.isSessionActive());
  }

  @Test
  public void escapeRestoresOriginalValueWithoutCommittingTheTemporaryText() {
    FakeHost host = new FakeHost("yyyy-MM-dd", new Date(0));
    DateTimeTypingEditor editor = DateTimeTypingEditor.create(host);

    editor.beginSession();
    editor.type("20261001");
    editor.cancelSession();

    assertEquals("1970-01-01", host.getDisplayedText());
    assertEquals(new Date(0), host.getCommittedValue());
    assertFalse(editor.isSessionActive());
  }

  @Test
  public void invalidCandidateRestoresOriginalValueAndReportsTheFailure() {
    FakeHost host = new FakeHost("yyyy-MM-dd", new Date(0));
    DateTimeTypingEditor editor = DateTimeTypingEditor.create(host);

    editor.beginSession();
    editor.type("20269999");

    assertFalse(editor.commitSession());
    assertEquals("1970-01-01", host.getDisplayedText());
    assertEquals(new Date(0), host.getCommittedValue());
    assertEquals("Invalid date: 2026-99-99", host.getInvalidMessage());
  }

  @Test
  public void keyboardInputUsesOverwriteAndEnterCommitsTheSession() {
    FakeHost host = new FakeHost("yyyy-MM-dd", null);
    DateTimeTypingEditor editor = DateTimeTypingEditor.create(host);

    assertTrue(editor.handleKey("2"));
    assertTrue(editor.handleKey("0"));
    assertTrue(editor.handleKey("2"));
    assertTrue(editor.handleKey("6"));
    assertTrue(editor.handleKey("1"));
    assertTrue(editor.handleKey("0"));
    assertTrue(editor.handleKey("0"));
    assertTrue(editor.handleKey("1"));
    assertTrue(editor.handleKey("Enter"));

    assertEquals(FakeHost.PARSED_DATE, host.getCommittedValue());
  }

  @Test
  public void committingAnUntouchedEmptySessionRestoresTheEmptyValueWithoutAnError() {
    FakeHost host = new FakeHost("yyyy-MM-dd", null);
    DateTimeTypingEditor editor = DateTimeTypingEditor.create(host);

    editor.beginSession();

    assertTrue(editor.commitSession());
    assertNull(host.getCommittedValue());
    assertNull(host.getInvalidMessage());
    assertFalse(editor.isSessionActive());
  }

  @Test
  public void rejectedValidationRestoresTheOriginalValueAndKeepsTheValidatorMessage() {
    FakeHost host = new FakeHost("yyyy-MM-dd", new Date(0));
    host.setValidationResult(ValidationResult.invalid("This date is not allowed"));
    DateTimeTypingEditor editor = DateTimeTypingEditor.create(host);

    editor.type("20261001");

    assertFalse(editor.commitSession());
    assertEquals(new Date(0), host.getCommittedValue());
    assertEquals("This date is not allowed", host.getInvalidMessage());
  }

  private static class FakeHost implements DateTimeTypingEditorHost {

    private static final Date PARSED_DATE = new Date(1790812800000L);

    private final String pattern;
    private Date committedValue;
    private String displayedText;
    private String invalidMessage;
    private ValidationResult validationResult = ValidationResult.valid();

    private FakeHost(String pattern, Date committedValue) {
      this.pattern = pattern;
      this.committedValue = committedValue;
      this.displayedText = "1970-01-01";
    }

    @Override
    public String getPattern() {
      return pattern;
    }

    @Override
    public Date getCommittedValue() {
      return committedValue;
    }

    @Override
    public String format(DateTimePatternToken token, Date value) {
      if (value == null) {
        return null;
      }
      switch (token.getPattern()) {
        case "yyyy":
          return "1970";
        case "MM":
          return "01";
        case "dd":
          return "01";
        default:
          return token.getPattern();
      }
    }

    @Override
    public Date parse(String candidatePattern, String candidateText) {
      if ("yyyy-MM-dd".equals(candidatePattern) && "2026-10-01".equals(candidateText)) {
        return PARSED_DATE;
      }
      throw new IllegalArgumentException(candidateText);
    }

    @Override
    public ValidationResult validateCandidate(Date candidate) {
      return validationResult;
    }

    @Override
    public void commit(Date value) {
      committedValue = value;
      displayedText = "2026-10-01";
    }

    @Override
    public void restore(Date value) {
      committedValue = value;
      displayedText = "1970-01-01";
    }

    @Override
    public void display(String value, int selectionStart, int selectionEnd) {
      displayedText = value;
    }

    @Override
    public void invalidate(String message) {
      invalidMessage = message;
    }

    @Override
    public void clearInvalid() {
      invalidMessage = null;
    }

    @Override
    public String invalidFormatMessage(String value) {
      return "Invalid date: " + value;
    }

    private String getDisplayedText() {
      return displayedText;
    }

    private void setValidationResult(ValidationResult validationResult) {
      this.validationResult = validationResult;
    }

    private String getInvalidMessage() {
      return invalidMessage;
    }
  }
}
