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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.dominokit.domino.ui.forms.validations.ValidationResult;

/** Coordinates an uncommitted token-aware typing session for a date or time field. */
public final class DateTimeTypingEditor {

  private final DateTimeTypingEditorHost host;
  private DateTimeTypingSession session;
  private Date originalValue;

  private DateTimeTypingEditor(DateTimeTypingEditorHost host) {
    this.host = Objects.requireNonNull(host, "host");
  }

  public static DateTimeTypingEditor create(DateTimeTypingEditorHost host) {
    return new DateTimeTypingEditor(host);
  }

  /** Starts a typing session and renders the current value or the retained pattern template. */
  public void beginSession() {
    if (isSessionActive()) {
      return;
    }
    originalValue = host.getCommittedValue();
    List<DateTimePatternToken> tokens = DateTimePatternTokenizer.tokenize(host.getPattern());
    List<String> values = new ArrayList<>();
    for (DateTimePatternToken token : tokens) {
      values.add(
          token.getKind() == DateTimePatternToken.Kind.LITERAL
              ? null
              : host.format(token, originalValue));
    }
    session = DateTimeTypingSession.withValues(tokens, values);
    renderSession();
  }

  /** Adds typed text using overwrite semantics. */
  public void type(String value) {
    if (!isSessionActive()) {
      beginSession();
    }
    session.overwrite(value);
    renderSession();
  }

  /** Handles one keyboard key and returns whether the native event should be prevented. */
  public boolean handleKey(String key) {
    if (key == null || key.isEmpty()) {
      return false;
    }
    switch (key) {
      case "Escape":
        cancelSession();
        return true;
      case "Enter":
        commitSession();
        return true;
      case "Tab":
        commitSession();
        return false;
      case "ArrowRight":
        beginSession();
        session.moveNext();
        renderSession();
        return true;
      case "ArrowLeft":
        beginSession();
        session.movePrevious();
        renderSession();
        return true;
      case "Backspace":
        beginSession();
        session.backspace();
        renderSession();
        return true;
      default:
        if (key.length() == 1 && Character.isLetterOrDigit(key.charAt(0))) {
          type(key);
          return true;
        }
        if (key.length() == 1) {
          beginSession();
          if (session.acceptLiteral(key)) {
            renderSession();
            return true;
          }
        }
        return false;
    }
  }

  /** Restores the value captured when the current session began. */
  public void cancelSession() {
    if (isSessionActive()) {
      host.restore(originalValue);
      host.clearInvalid();
      clearSession();
    }
  }

  /**
   * Parses, validates, and commits the current candidate.
   *
   * @return {@code true} when the candidate was committed
   */
  public boolean commitSession() {
    if (!isSessionActive()) {
      return true;
    }
    if (!session.isModified()) {
      host.restore(originalValue);
      host.clearInvalid();
      clearSession();
      return true;
    }
    String displayText = session.getDisplayText();
    if (!session.isComplete()) {
      rollbackInvalid(displayText);
      return false;
    }
    try {
      Date candidate = host.parse(session.getCandidatePattern(), session.getCandidateText());
      ValidationResult validationResult = host.validateCandidate(candidate);
      if (!validationResult.isValid()) {
        rollbackValidation(validationResult.getErrorMessage());
        return false;
      }
      host.commit(candidate);
      host.clearInvalid();
      clearSession();
      return true;
    } catch (IllegalArgumentException e) {
      rollbackInvalid(displayText);
      return false;
    }
  }

  public boolean isSessionActive() {
    return session != null;
  }

  /** Ends an active session after a value was selected through the picker. */
  public void completeFromPicker() {
    clearSession();
  }

  private void rollbackInvalid(String invalidValue) {
    host.restore(originalValue);
    host.invalidate(host.invalidFormatMessage(invalidValue));
    clearSession();
  }

  private void rollbackValidation(String validationMessage) {
    host.restore(originalValue);
    host.invalidate(validationMessage);
    clearSession();
  }

  private void clearSession() {
    session = null;
    originalValue = null;
  }

  private void renderSession() {
    host.display(
        session.getDisplayText(), session.getActiveTokenStart(), session.getActiveTokenEnd());
  }
}
